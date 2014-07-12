package com.plopiplop.leekwars.model;

import com.intellij.openapi.vfs.CharsetToolkit;
import com.intellij.util.net.HttpConfigurable;
import com.plopiplop.leekwars.options.LSSettings;
import com.plopiplop.leekwars.options.PluginNotConfiguredException;
import org.apache.commons.net.util.Base64;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;

public class LeekWarsServer {
    private static final LeekWarsServer INSTANCE = new LeekWarsServer();

    private static final String LOGIN_PATH = "/index.php?page=login_form";
    private static final String MARKET_URL = "/market";
    private static final String DOCUMENTATION_URL = "/documentation";

    private String cookie;

    public static LeekWarsServer getInstance() {
        return INSTANCE;
    }

    public Document getMarket() throws IOException, PluginNotConfiguredException {
        return getPage(MARKET_URL);
    }

    public Document getDocumentation() throws IOException, PluginNotConfiguredException {
        return getPage(DOCUMENTATION_URL);
    }

    private Document getPage(String url) throws IOException, PluginNotConfiguredException {
        if (!LSSettings.getInstance().isValid()) {
            throw new PluginNotConfiguredException();
        }
        // FIXME handle expired sessions
        if (cookie == null || !cookie.contains("farmer_id")) {
            connectToLeekWars();
        }
        HttpURLConnection connection = HttpConfigurable.getInstance().openHttpConnection(buildUrl(url));
        connection.setRequestProperty("Cookie", cookie);
        addAuth(connection);
        connection.connect();

        Document document = Jsoup.parse(connection.getInputStream(), CharsetToolkit.UTF8, LSSettings.getInstance().getSiteUrl());
        document.outputSettings().prettyPrint(false);

        return document;
    }

    private void connectToLeekWars() throws IOException, PluginNotConfiguredException {
        HttpURLConnection connection = HttpConfigurable.getInstance().openHttpConnection(buildUrl("/"));

        addAuth(connection);

        connection.connect();

        String phpSessId = connection.getHeaderField("Set-Cookie");
        cookie = phpSessId.substring(0, phpSessId.indexOf(';'));

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
}
