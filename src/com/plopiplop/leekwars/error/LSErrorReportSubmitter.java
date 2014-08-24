package com.plopiplop.leekwars.error;

import com.intellij.diagnostic.LogMessage;
import com.intellij.ide.plugins.IdeaPluginDescriptor;
import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.application.ApplicationInfo;
import com.intellij.openapi.diagnostic.ErrorReportSubmitter;
import com.intellij.openapi.diagnostic.IdeaLoggingEvent;
import com.intellij.openapi.diagnostic.SubmittedReportInfo;
import com.intellij.openapi.extensions.PluginDescriptor;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.NonNls;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import static com.intellij.openapi.diagnostic.SubmittedReportInfo.SubmissionStatus.FAILED;
import static com.intellij.openapi.diagnostic.SubmittedReportInfo.SubmissionStatus.NEW_ISSUE;

public class LSErrorReportSubmitter extends ErrorReportSubmitter {

    private static final String URL = "http://idealeek.myjetbrains.com/youtrack/";
    private static final String ISSUE_URL = URL + "rest/issue";
    private static final String LOGIN_URL = URL + "rest/user/login";
    private static final String ENC = "UTF-8";

    @Override
    public String getReportActionText() {
        return "Report to IDEALeek";
    }

    @Override
    public SubmittedReportInfo submit(IdeaLoggingEvent[] events, Component parentComponent) {
        IdeaLoggingEvent firstEvent = events[0];
        String firstEventText = firstEvent.getThrowableText();
        String summary = firstEventText.substring(0, Math.min(Math.max(80, firstEventText.length()), 80));

        String platformBuild = ApplicationInfo.getInstance().getBuild().asString();
        PluginDescriptor pluginDescriptor = getPluginDescriptor();
        String localPluginVersion = "unknown";
        if (pluginDescriptor instanceof IdeaPluginDescriptor) {
            localPluginVersion = ((IdeaPluginDescriptor) pluginDescriptor).getVersion();
        }

        @NonNls StringBuilder description = new StringBuilder();
        description.append("Java Version: ").append(System.getProperty("java.version")).append('\n');
        description.append("Operating System: ").append(System.getProperty("os.name")).append('\n');
        description.append("IDE Version: ").append(platformBuild).append('\n');
        description.append("IDEALeek Version: ").append(localPluginVersion).append("\n");

        for (IdeaLoggingEvent event : events) {
            LogMessage logMessage = (LogMessage) event.getData();
            String additionalInfo = logMessage == null ? null : logMessage.getAdditionalInfo();
            if (StringUtils.isNotEmpty(additionalInfo)) {
                description.append("\n\nUser Message:");
                description.append("\n__________________________________________________________________\n");
                description.append(additionalInfo);
                description.append("\n__________________________________________________________________");
            }
            description.append("\n\n").append(event.toString());
        }


        String result = submit(localPluginVersion, summary, description.toString());

        if (result == null) {
            return new SubmittedReportInfo(ISSUE_URL, "", FAILED);
        }

        String ticketId = null;
        try {
            Pattern regex = Pattern.compile("id=\"([^\"]+)\"", Pattern.DOTALL | Pattern.MULTILINE);
            Matcher regexMatcher = regex.matcher(result);
            if (regexMatcher.find()) {
                ticketId = regexMatcher.group(1);
            }
        } catch (PatternSyntaxException ex) {
        }

        if (ticketId == null) {
            return new SubmittedReportInfo(ISSUE_URL, "", FAILED);
        }

        String ticketUrl = URL + "issue/" + ticketId;
        Notifications.Bus.notify(new Notification("LeekScript", "Error Reporting",
                "<html>Error report successfully sent. Ticket <a href='" + ticketUrl + "'>" + ticketId + "</a> created.</html>", NotificationType.INFORMATION));

        return new SubmittedReportInfo(ticketUrl, ticketId, NEW_ISSUE);
    }

    public String submit(String pluginVersion, String summary, String description) {
        StringBuilder response = new StringBuilder("");

        StringBuilder data = new StringBuilder();
        try {
            data.append(URLEncoder.encode("login", ENC)).append("=").append(URLEncoder.encode("guest", ENC));
            data.append("&").append(URLEncoder.encode("password", ENC)).append("=").append(URLEncoder.encode("guest", ENC));

            URL url = new URL(LOGIN_URL);
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(data.toString());
            wr.flush();

            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
            }

            data = new StringBuilder();
            data.append(URLEncoder.encode("project", ENC)).append("=").append(URLEncoder.encode("IDL", ENC));
            data.append("&").append(URLEncoder.encode("assignee", ENC)).append("=").append(URLEncoder.encode("Unassigned", ENC));
            data.append("&").append(URLEncoder.encode("summary", ENC)).append("=").append(URLEncoder.encode(summary, ENC));
            data.append("&").append(URLEncoder.encode("description", ENC)).append("=").append(URLEncoder.encode(description, ENC));
            data.append("&").append(URLEncoder.encode("priority", ENC)).append("=").append(URLEncoder.encode("4", ENC));
            data.append("&").append(URLEncoder.encode("type", ENC)).append("=").append(URLEncoder.encode("Exception", ENC));

            if (pluginVersion != null)
                data.append("&").append(URLEncoder.encode("affectsVersion", ENC)).append("=").append(URLEncoder.encode(pluginVersion, ENC));

            url = new URL(ISSUE_URL);
            conn = url.openConnection();
            conn.setDoOutput(true);

            wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(data.toString());
            wr.flush();

            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            while ((line = rd.readLine()) != null) {
                response.append(line);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return response.toString();
    }
}