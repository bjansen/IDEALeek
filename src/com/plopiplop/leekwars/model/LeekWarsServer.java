package com.plopiplop.leekwars.model;

import com.google.common.io.CharStreams;
import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.vfs.CharsetToolkit;
import com.intellij.util.IncorrectOperationException;
import com.intellij.util.net.HttpConfigurable;
import com.plopiplop.leekwars.actions.CompilationException;
import com.plopiplop.leekwars.actions.DownloadScriptsTask;
import com.plopiplop.leekwars.options.LSSettings;
import com.plopiplop.leekwars.options.PluginNotConfiguredException;
import org.apache.commons.net.util.Base64;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.List;

public class LeekWarsServer {
    private static final LeekWarsServer INSTANCE = new LeekWarsServer();

    private static final String LOGIN_PATH = "/index.php?page=login_form";
    private static final String MARKET_URL = "/market";
    private static final String DOCUMENTATION_URL = "/documentation";
    private static final String EDITOR_URL = "/editor";
    private static final String EDITOR_UPDATE_URL = "/index.php?page=editor_update";

    private String cookie;
    private String token;

    public static LeekWarsServer getInstance() {
        return INSTANCE;
    }

    /**
     * Wrapper for a call to a server action which handles exceptions.
     *
     * @param action the action to call
     */
    public static void callAction(ServerAction action) {
        try {
            action.doAction();
        } catch (IOException e) {
            Notifications.Bus.notify(new Notification("LeekScript", "Error", "Can't reach LeekWars server :(", NotificationType.ERROR));
            throw new RuntimeException(e);
        } catch (PluginNotConfiguredException e) {
            Notifications.Bus.notify(new Notification("LeekScript", "Can't connect to LeekWars server", "Please configure the LeekScript plugin", NotificationType.ERROR));
        }
    }

    public Document getMarket() throws IOException, PluginNotConfiguredException {
        return getPage(MARKET_URL, null);
    }

    public Document getDocumentation() throws IOException, PluginNotConfiguredException {
        return getPage(DOCUMENTATION_URL, null);
    }

    public Document getEditor() throws IOException, PluginNotConfiguredException {
        return getPage(EDITOR_URL, null);
    }

    public Document downloadScript(String id) throws IOException, PluginNotConfiguredException {
        return getPage(EDITOR_UPDATE_URL, String.format("id=%s&load=true&token=%s", id, getToken()));
    }

    public void uploadScript(String id, String name, String content) throws CompilationException, IOException, PluginNotConfiguredException {
        // Needed to get the token first
        if (cookie == null || !cookie.contains("farmer_id")) {
            connectToLeekWars();
        }

        String params = String.format("id=%s&compile=true&token=%s&code=%s", id, getToken(), URLEncoder.encode(content, "UTF-8"));

        HttpURLConnection connection = getConnection(EDITOR_UPDATE_URL, params, true);
        String result = CharStreams.toString(new InputStreamReader(connection.getInputStream(), CharsetToolkit.UTF8));

        if (result.equals("bad token")) {
            new DownloadScriptsTask(null).parseScriptTags(getPage("/", null));
            uploadScript(id, name, content);
            return;
        }

        if (result.equals("\ufeff\n")) {
            throw new IncorrectOperationException("Received empty response, uploaded script may have an invalid ID");
        }

        CompilationException compilationResult = new CompilationException(result);

        params = String.format("id=%s&save=true&color=0&token=%s&name=%s", id, getToken(), URLEncoder.encode(name, "UTF-8"));
        connection = getConnection(EDITOR_UPDATE_URL, params, true);
        result = CharStreams.toString(new InputStreamReader(connection.getInputStream(), CharsetToolkit.UTF8));
        if (!result.equals("\uFEFFtrue\n")) {
            throw new IOException("Expected result \"true\" but was " + result);
        }

        if (!compilationResult.getSuccess()) {
            throw compilationResult;
        }
    }

    public String createScript(String name, String content) throws IOException, PluginNotConfiguredException, CompilationException {
        // Needed to get the token first
        if (cookie == null || !cookie.contains("farmer_id")) {
            connectToLeekWars();
        }

        String params = String.format("create=true&token=%s", getToken());
        HttpURLConnection connection = getConnection(EDITOR_UPDATE_URL, params, false);

        String location = connection.getHeaderField("Location");

        if (location != null && location.startsWith("/editor/")) {
            String id = location.substring("/editor/".length());

            // FIXME if it throws an exception, we don't rename the file and a duplicate AI will be uploaded next time
            uploadScript(id, name, content);

            return id;
        }

        return null;
    }

    public void deleteScript(String scriptId) throws IOException, PluginNotConfiguredException {
        // Needed to get the token first
        if (cookie == null || !cookie.contains("farmer_id")) {
            connectToLeekWars();
        }

        String params = String.format("id=%s&remove=true&token=%s", scriptId, getToken());
        HttpURLConnection connection = getConnection("/editor_update", params, true);
        CharStreams.toString(new InputStreamReader(connection.getInputStream(), CharsetToolkit.UTF8));
    }

    private Document getPage(String url, String postData) throws IOException, PluginNotConfiguredException {
        HttpURLConnection connection = getConnection(url, postData, true);

        Document document = Jsoup.parse(connection.getInputStream(), CharsetToolkit.UTF8, LSSettings.getInstance().getSiteUrl());
        document.outputSettings().prettyPrint(false);

        return document;
    }

    private HttpURLConnection getConnection(String url, String postData, boolean followRedirects) throws PluginNotConfiguredException, IOException {
        if (!LSSettings.getInstance().isValid()) {
            throw new PluginNotConfiguredException();
        }
        // FIXME handle expired sessions
        if (cookie == null || !cookie.contains("farmer_id")) {
            connectToLeekWars();
        }
        HttpURLConnection connection = HttpConfigurable.getInstance().openHttpConnection(buildUrl(url));
        connection.setRequestProperty("Cookie", cookie);
        connection.setDoInput(true);
        connection.setInstanceFollowRedirects(followRedirects);
        addAuth(connection);

        if (postData != null) {
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
            writer.write(postData);
            out.flush();
            writer.close();
            out.close();
        }
        connection.connect();

        return connection;
    }

    private void connectToLeekWars() throws IOException, PluginNotConfiguredException {
        HttpURLConnection connection = HttpConfigurable.getInstance().openHttpConnection(buildUrl("/"));

        addAuth(connection);

        connection.connect();

        String phpSessId = connection.getHeaderField("Set-Cookie");

        if (phpSessId != null) {
            cookie = phpSessId.substring(0, phpSessId.indexOf(';'));
        }

        connection = HttpConfigurable.getInstance().openHttpConnection(buildUrl(LOGIN_PATH));
        addAuth(connection);

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Cookie", cookie);
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.setUseCaches(true);
        connection.setDoOutput(true);
        connection.setDoInput(true);

        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
        out.writeBytes(String.format("login=%s&pass=%s&keep=on", LSSettings.getInstance().getSiteLogin(), LSSettings.getInstance().getSitePassword()));
        out.flush();
        out.close();

        connection.connect();

        List<String> fields = connection.getHeaderFields().get("Set-Cookie");

        if (fields != null) {
            // farmer_id and farmer_hash
            cookie += "; " + fields.get(0).substring(0, fields.get(0).indexOf(';'));
            cookie += "; " + fields.get(1).substring(0, fields.get(1).indexOf(';'));

            // Get the token
            new DownloadScriptsTask(null).parseScriptTags(getPage("/", null));
        } else {
            Document doc = Jsoup.parse(connection.getInputStream(), CharsetToolkit.UTF8, LSSettings.getInstance().getSiteUrl());
            if (doc.body().text().contains("Les identifiants sont incorrects")) {
                cookie = null;
                throw new PluginNotConfiguredException();
            }
        }
    }

    private String buildUrl(String path) {
        String host = LSSettings.getInstance().getSiteUrl();

        if (host.endsWith("/")) {
            host = host.substring(0, host.length() - 1);
        }

        return host + path;
    }

    private void addAuth(HttpURLConnection connection) {
        if (LSSettings.getInstance().isEnableAuth()) {
            String plaintTextAuth = LSSettings.getInstance().getAuthLogin() + ":" + LSSettings.getInstance().getAuthPassword();
            String auth = new String(Base64.encodeBase64(plaintTextAuth.getBytes()));

            connection.setRequestProperty("Authorization", "Basic " + auth);
        }
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
