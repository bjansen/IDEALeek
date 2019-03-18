package com.plopiplop.leekwars.apiclient;

import com.google.common.io.CharStreams;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.vfs.CharsetToolkit;
import com.intellij.util.IncorrectOperationException;
import com.intellij.util.net.HttpConfigurable;
import com.plopiplop.leekwars.actions.CompilationException;
import com.plopiplop.leekwars.apiclient.dto.AIResponse;
import com.plopiplop.leekwars.apiclient.dto.AIsResponse;
import com.plopiplop.leekwars.apiclient.dto.FunctionsResponse;
import com.plopiplop.leekwars.apiclient.dto.WeaponsResponse;
import com.plopiplop.leekwars.model.Chip;
import com.plopiplop.leekwars.model.Function;
import com.plopiplop.leekwars.model.ServerAction;
import com.plopiplop.leekwars.model.Weapon;
import com.plopiplop.leekwars.options.LSSettings;
import com.plopiplop.leekwars.options.PluginNotConfiguredException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LeekWarsApiClient {

    private static final LeekWarsApiClient INSTANCE = new LeekWarsApiClient();

    private String token;

    public static LeekWarsApiClient getInstance() {
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

    public List<Weapon> getWeapons() throws IOException, PluginNotConfiguredException {
        HttpURLConnection conn = getConnection("/api/weapon/get-all", null, false, false);
        WeaponsResponse resp = new GsonBuilder().create().fromJson(
                new InputStreamReader(conn.getInputStream()),
                WeaponsResponse.class
        );

        if (resp.isSuccess()) {
            List<Weapon> weapons = new ArrayList<Weapon>();

            for (WeaponsResponse.Weap w : resp.getWeapons()) {
                Weapon weapon = new Weapon();
                weapon.id = "WEAPON_" + w.getName().toUpperCase();
                weapon.name = weapon.id;
                weapon.description = "?";
                weapon.level = "Niveau " + w.getLevel();
                weapon.price = "" + w.getCost();
                weapon.value = w.getId();
                weapons.add(weapon);
            }

            return weapons;
        }

        throw new IOException("Can't fetch weapons");
    }

    public List<Chip> getChips() throws IOException, PluginNotConfiguredException {
        HttpURLConnection conn = getConnection("/api/chip/get-all", null, false, false);
        Map resp = new GsonBuilder().create().fromJson(new InputStreamReader(conn.getInputStream()), Map.class);

        if (resp.get("success") == Boolean.TRUE) {
            Map map = (Map) resp.get("chips");

            List<Chip> chips = new ArrayList<Chip>();

            for (Object o : map.values()) {
                Map w = (Map) o;

                Chip chip = new Chip();
                chip.id = "CHIP_" + w.get("name").toString().toUpperCase();
                chip.name = chip.id;
                chip.description = "?";
                chip.level = "Niveau " + (int) Double.parseDouble(w.get("level").toString());
                chip.price = w.get("cost").toString();
                chip.value = "" + (int) Double.parseDouble(w.get("id").toString());
                chips.add(chip);
            }

            return chips;
        }

        throw new IOException("Can't fetch chips");
    }

    public List<Function> getFunctions() throws IOException, PluginNotConfiguredException {
        HttpURLConnection conn = getConnection("/api/function/get-all", null, false, false);
        FunctionsResponse resp = new GsonBuilder().create().fromJson(
                new InputStreamReader(conn.getInputStream()), FunctionsResponse.class);

        if (resp.isSuccess()) {
            List<Function> functions = new ArrayList<Function>();

            for (FunctionsResponse.Fun fun : resp.getFunctions()) {
                Function function = new Function();
                function.name = fun.getName();
                function.description = "?";

                for (String arg : fun.getArgumentNames()) {
                    if (!arg.matches("\\d+")) {
                        function.getParameters().put(arg, "?");
                    }
                }

                // TODO include n'est pas un mot-clé, il faut changer la grammaire puis virer ce if
                if (!"include".equals(function.name)) {
                    functions.add(function);
                }
            }

            return functions;
        }

        throw new IOException("Can't fetch functions");
    }

    public Map<Integer, String> listScripts() throws IOException, PluginNotConfiguredException {
        HttpURLConnection conn = getConnection("/api/ai/get-farmer-ais", null, false, true);
        AIsResponse resp = new GsonBuilder().create().fromJson(
                new InputStreamReader(conn.getInputStream()), AIsResponse.class);

        if (resp.isSuccess()) {
            Map<Integer, String> scripts = new TreeMap<Integer, String>();

            for (AIsResponse.AI fun : resp.getAis()) {
                scripts.put(fun.getId(), fun.getName());
            }

            return scripts;
        }

        throw new IOException("Can't fetch script");
    }

    public String downloadScript(int id) throws IOException, PluginNotConfiguredException {
        HttpURLConnection conn = getConnection("/api/ai/get/" + id, null, false, true);
        AIResponse resp = new GsonBuilder().create().fromJson(
                new InputStreamReader(conn.getInputStream()), AIResponse.class);

        if (resp.isSuccess()) {
            return resp.getAi().getCode();
        }

        throw new IOException("Can't fetch script");
    }

    public void uploadScript(int id, String name, String content) throws CompilationException, IOException, PluginNotConfiguredException {
        if (token == null) {
            connectToLeekWars();
        }

        String params = String.format("ai_id=%d&code=%s", id, URLEncoder.encode(content, "UTF-8"));

        HttpURLConnection connection = getConnection("/api/ai/save", params, true, true);
        String result = CharStreams.toString(new InputStreamReader(connection.getInputStream(), CharsetToolkit.UTF8));


        if (result.equals("\ufeff\n")) {
            throw new IncorrectOperationException("Received empty response, uploaded script may have an invalid ID");
        }
    }

    public int createScript(String name, String content) throws IOException, PluginNotConfiguredException, CompilationException {
        if (token == null) {
            connectToLeekWars();
        }

        HttpURLConnection conn = getConnection("/api/ai/new", "folder_id=0&v2=false", false, true);

        AIResponse resp = new GsonBuilder().create().fromJson(
                new InputStreamReader(conn.getInputStream()), AIResponse.class);

        if (resp.isSuccess()) {
            int id = resp.getAi().getId();

            uploadScript(id, name, content);

            return id;
        }

        throw new IOException("Can't create script");
    }

    public void deleteScript(int scriptId) throws IOException, PluginNotConfiguredException {
        if (token == null) {
            connectToLeekWars();
        }

        HttpURLConnection connection = getConnection("/api/ai/delete", "ai_id=" + scriptId, true, true);
        String response = CharStreams.toString(new InputStreamReader(connection.getInputStream(), CharsetToolkit.UTF8));
        System.out.println(response);
    }

    private HttpURLConnection getConnection(String url, String postData, boolean followRedirects, boolean appendToken) throws PluginNotConfiguredException, IOException {
        if (!LSSettings.getInstance().isValid()) {
            throw new PluginNotConfiguredException();
        }

        if (appendToken) {
            if (token == null) {
                connectToLeekWars();
            }

            if (postData != null) {
                postData += "&token=" + token;
            } else {
                url += "/" + token;
            }
        }

        HttpURLConnection connection = HttpConfigurable.getInstance().openHttpConnection(buildUrl(url));
        connection.setDoInput(true);
        connection.setRequestMethod("GET");
        connection.setInstanceFollowRedirects(followRedirects);

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
        String url = buildUrl(String.format(
                "/api/farmer/login-token/%s/%s",
                LSSettings.getInstance().getSiteLogin(),
                LSSettings.getInstance().getSitePassword())
        );
        HttpURLConnection connection = HttpConfigurable.getInstance().openHttpConnection(url);

        connection.connect();

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        Map map = gson.fromJson(new InputStreamReader(connection.getInputStream()), Map.class);

        System.out.println(map);

        if (map.get("success") == Boolean.TRUE) {
            token = map.get("token").toString();
        } else {
            throw new PluginNotConfiguredException();
        }
    }

    private String buildUrl(String path) {
        String host = LSSettings.getInstance().getSiteUrl();

        if (host.endsWith("/")) {
            host = host.substring(0, host.length() - 1);
        }

        return host + path;
    }
}
