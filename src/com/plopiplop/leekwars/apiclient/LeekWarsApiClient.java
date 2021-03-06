package com.plopiplop.leekwars.apiclient;

import com.google.common.io.CharStreams;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.util.Condition;
import com.intellij.util.containers.ContainerUtil;
import com.intellij.util.net.HttpConfigurable;
import com.plopiplop.leekwars.actions.CompilationException;
import com.plopiplop.leekwars.apiclient.dto.*;
import com.plopiplop.leekwars.model.*;
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
        } catch (ApiException e) {
            Notifications.Bus.notify(new Notification("LeekScript", "Can't connect to LeekWars server", "An error occured while calling the LeekWars API", NotificationType.ERROR));
        }
    }

    public List<Weapon> getWeapons() throws IOException, PluginNotConfiguredException, ApiException {
        WeaponsResponse resp = get("/api/weapon/get-all", WeaponsResponse.class);
        Map<String, String> labels = get("https://raw.githubusercontent.com/leek-wars/leek-wars-client/master/src/lang/fr/weapon.json", Map.class);

        List<Weapon> weapons = new ArrayList<Weapon>();

        for (WeaponsResponse.Weap w : resp.getWeapons()) {
            Weapon weapon = new Weapon();
            weapon.id = "WEAPON_" + w.getName().toUpperCase();
            weapon.name = labels.get(w.getName());
            weapon.description = "";
            weapon.level = "Niveau " + w.getLevel();
            weapon.price = "" + w.getCost();
            weapon.value = w.getId();
            weapons.add(weapon);
        }

        return weapons;
    }

    public List<Chip> getChips() throws IOException, PluginNotConfiguredException, ApiException {
        Map resp = get("/api/chip/get-all", Map.class);
        Map<String, String> labels = get("https://raw.githubusercontent.com/leek-wars/leek-wars-client/master/src/lang/fr/chip.json", Map.class);

        Map map = (Map) resp.get("chips");

        List<Chip> chips = new ArrayList<Chip>();

        for (Object o : map.values()) {
            Map w = (Map) o;

            Chip chip = new Chip();
            chip.id = "CHIP_" + w.get("name").toString().toUpperCase();
            chip.name = labels.get(w.get("name").toString());
            chip.description = "";
            chip.level = "Niveau " + (int) Double.parseDouble(w.get("level").toString());
            chip.price = w.get("cost").toString();
            chip.value = "" + (int) Double.parseDouble(w.get("id").toString());
            chips.add(chip);
        }

        return chips;
    }

    public List<Function> getFunctions() throws IOException, PluginNotConfiguredException, ApiException {
        FunctionsResponse resp = get("/api/function/get-all", FunctionsResponse.class);
        Map<String, String> labels = get("https://raw.githubusercontent.com/leek-wars/leek-wars/master/src/lang/doc.fr.lang", Map.class);

        List<Function> functions = new ArrayList<Function>();
        String lastName = null;
        int overloads = 0;

        for (FunctionsResponse.Fun fun : resp.getFunctions()) {
            Function function = new Function();
            function.name = fun.getName();

            String funName = fun.getName();

            if (fun.getName().equals(lastName)) {
                overloads++;
                funName += "_" + (overloads + 1);
            } else {
                overloads = 0;
            }
            lastName = fun.getName();

            function.description = labels.get("func_" + funName);

            int argPos = 0;

            for (String arg : fun.getArgumentNames()) {
                argPos++;
                if (!arg.matches("\\d+")) {
                    function.getParameters().put(arg, labels.get("func_" + funName + "_arg_" + argPos));
                }
            }

            functions.add(function);
        }

        return functions;
    }

    public List<Constant> getConstants() throws IOException, PluginNotConfiguredException, ApiException {
        ConstantsResponse resp = get("/api/constant/get-all", ConstantsResponse.class);
        Map<String, String> labels = get("https://raw.githubusercontent.com/leek-wars/leek-wars/master/src/lang/doc.fr.lang", Map.class);

        List<Constant> constants = ContainerUtil.filter(resp.getConstants(), new Condition<Constant>() {
            @Override
            public boolean value(Constant constant) {
                return !(constant.getName().startsWith("CHIP_") || constant.getName().startsWith("WEAPON_"));
            }
        });

        for (Constant constant : constants) {
            if (labels.containsKey("const_" + constant.getName())) {
                constant.description = labels.get("const_" + constant.getName());
            } else {
                constant.description = constant.getName();
            }
        }

        return constants;
    }

    public Map<Integer, String> listScripts() throws IOException, PluginNotConfiguredException, ApiException {
        AIsResponse resp = secureGet("/api/ai/get-farmer-ais", AIsResponse.class);

        Map<Integer, String> scripts = new TreeMap<Integer, String>();

        for (AIsResponse.AI fun : resp.getAis()) {
            scripts.put(fun.getId(), fun.getName());
        }

        return scripts;
    }

    public String downloadScript(int id) throws IOException, PluginNotConfiguredException, ApiException {
        AIResponse resp = secureGet("/api/ai/get/" + id, AIResponse.class);

        return resp.getAi().getCode();
    }

    public void renameScript(int id, String name) throws IOException, PluginNotConfiguredException, ApiException {
        String params = String.format("ai_id=%d&new_name=%s", id, name);

        securePost("/api/ai/rename", params, Void[].class);
    }

    public void uploadScript(int id, String name, String content) throws CompilationException, IOException, PluginNotConfiguredException, ApiException {
        String params = String.format("ai_id=%d&code=%s", id, URLEncoder.encode(content, "UTF-8"));

        GenericResponse result = securePost("/api/ai/save", params, GenericResponse.class);

        renameScript(id, name);

        Object uploadResult = result.getResult().get("" + id);
        if (uploadResult instanceof List) {
            List<Object> list = (List<Object>) uploadResult;

            if (!list.isEmpty()) {
                CompilationException compilationException = new CompilationException(list);
                if (!compilationException.isSuccess()) {
                    throw compilationException;
                }
            }
        }
    }

    public int createScript(String name, String content) throws IOException, PluginNotConfiguredException, CompilationException, ApiException {
        AIResponse resp = securePost("/api/ai/new", "folder_id=0&v2=false&version=10", AIResponse.class);

        int id = resp.getAi().getId();

        uploadScript(id, name, content);

        return id;
    }

    public void deleteScript(int scriptId) throws IOException, PluginNotConfiguredException, ApiException {
        securePost("/api/ai/delete", "ai_id=" + scriptId, Void[].class);
    }

    private <T> T securePost(String url, String params, Class<T> responseType) throws IOException, PluginNotConfiguredException, ApiException {
        HttpURLConnection connection = getConnection(url, params, true, true);

        if (connection.getResponseCode() == 200) {
            String json = CharStreams.toString(new InputStreamReader(connection.getInputStream()));

            System.out.println(json);

            return new GsonBuilder().create().fromJson(
                    json,
                    responseType
            );
        } else {
            System.out.println(CharStreams.toString(new InputStreamReader(connection.getErrorStream())));
            throw new ApiException("securePost", url, params);
        }
    }

    private <T> T secureGet(String url, Class<T> responseType) throws IOException, PluginNotConfiguredException, ApiException {
        HttpURLConnection connection = getConnection(url, null, true, true);

        if (connection.getResponseCode() == 200) {
            return new GsonBuilder().create().fromJson(
                    new InputStreamReader(connection.getInputStream()),
                    responseType
            );
        } else {
            throw new ApiException("secureGet", url, null);
        }
    }

    private <T> T get(String url, Class<T> responseType) throws IOException, PluginNotConfiguredException, ApiException {
        HttpURLConnection connection = getConnection(url, null, true, false);

        if (connection.getResponseCode() == 200) {
            return new GsonBuilder().create().fromJson(
                    new InputStreamReader(connection.getInputStream()),
                    responseType
            );
        } else {
            throw new ApiException("get", url, null);
        }
    }

    private HttpURLConnection getConnection(String url, String postData, boolean followRedirects, boolean appendToken) throws PluginNotConfiguredException, IOException {
        if (!LSSettings.getInstance().isValid()) {
            throw new PluginNotConfiguredException();
        }

        if (appendToken) {
            if (token == null) {
                connectToLeekWars();
            }
        }

        HttpURLConnection connection = HttpConfigurable.getInstance().openHttpConnection(buildUrl(url));
        connection.setDoInput(true);
        connection.setRequestMethod("GET");
        connection.setInstanceFollowRedirects(followRedirects);
        if (appendToken) {
            connection.setRequestProperty("Authorization", "Bearer " + token);
        }
        connection.setRequestProperty("Accept", "application/json");

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

        //System.out.println(map);

        if (map.containsKey("token")) {
            token = map.get("token").toString();
        } else {
            throw new PluginNotConfiguredException();
        }
    }

    private String buildUrl(String path) {
        if (path.startsWith("http")) {
            return path;
        }

        String host = LSSettings.getInstance().getSiteUrl();

        if (host.endsWith("/")) {
            host = host.substring(0, host.length() - 1);
        }

        return host + path;
    }
}
