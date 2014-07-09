package com.plopiplop.leekwars.model;

import com.intellij.openapi.vfs.CharsetToolkit;
import com.intellij.util.net.HttpConfigurable;
import com.plopiplop.leekwars.options.LSSettings;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.net.util.Base64;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.HttpURLConnection;

public class LeekWarsServer {

    public static Document getMarket() throws IOException {
        return getPage("/market");
    }

    private static Document getPage(String url) throws IOException {
        HttpURLConnection connection = HttpConfigurable.getInstance().openHttpConnection(buildUrl("/market"));
        connection.setRequestProperty("Cookie", "TODO");
        addAuth(connection);
        connection.connect();

        return Jsoup.parse(connection.getInputStream(), CharsetToolkit.UTF8, LSSettings.getInstance().getSiteUrl());
    }

    private static String buildUrl(String path) {
        String host = LSSettings.getInstance().getSiteUrl();

        if (host.endsWith("/")) {
            host = host.substring(0, host.length() - 1);
        }

        return host + path;
    }

    private static void addAuth(HttpURLConnection connection) {
        if (StringUtils.isNotBlank(LSSettings.getInstance().authLogin)) {
            String auth = new String(Base64.encodeBase64((LSSettings.getInstance().authLogin + ":" + LSSettings.getInstance().authPassword).getBytes()));

            connection.setRequestProperty("Authorization", "Basic " + auth);
        }
    }
}
