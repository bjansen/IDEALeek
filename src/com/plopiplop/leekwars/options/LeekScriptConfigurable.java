package com.plopiplop.leekwars.options;

import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SearchableConfigurable;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.ui.TextFieldWithStoredHistory;
import org.jdesktop.swingx.VerticalLayout;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class LeekScriptConfigurable implements SearchableConfigurable, Configurable.NoScroll {

    private JPanel rootComponent;
    private TextFieldWithStoredHistory siteUrl;
    private JTextField siteLogin;
    private JTextField sitePassword;
    private JCheckBox enableHttpAuth;
    private JTextField authLogin;
    private JTextField authPassword;

    @NotNull
    @Override
    public String getId() {
        return getDisplayName();
    }

    @Nullable
    @Override
    public Runnable enableSearch(String option) {
        return null;
    }

    @Nls
    @Override
    public String getDisplayName() {
        return "LeekScript";
    }

    @Nullable
    @Override
    public String getHelpTopic() {
        return null;
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        if (rootComponent == null) {
            rootComponent = new JPanel();
            rootComponent.setLayout(new VerticalLayout());

            JLabel labelSiteUrl = new JLabel("LeekWars URL");
            rootComponent.add(labelSiteUrl);
            siteUrl = new TextFieldWithStoredHistory("LeekScript.SiteUrl");
            rootComponent.add(siteUrl);

            JLabel labelSiteLogin = new JLabel("LeekWars login");
            rootComponent.add(labelSiteLogin);
            siteLogin = new JTextField();
            rootComponent.add(siteLogin);

            JLabel labelSitePassword = new JLabel("LeekWars password");
            rootComponent.add(labelSitePassword);
            sitePassword = new JPasswordField();
            rootComponent.add(sitePassword);

            enableHttpAuth = new JCheckBox("Enable HTTP auth");
            rootComponent.add(enableHttpAuth);

            JLabel labelAuthLogin = new JLabel("HTTP auth login");
            rootComponent.add(labelAuthLogin);
            authLogin = new JTextField();
            rootComponent.add(authLogin);

            JLabel labelAuthPassword = new JLabel("HTTP auth password");
            rootComponent.add(labelAuthPassword);
            authPassword = new JPasswordField();
            rootComponent.add(authPassword);
        }

        return rootComponent;
    }

    @Override
    public boolean isModified() {
        LSSettings settings = LSSettings.getInstance();

        return !StringUtil.equals(settings.authLogin, authLogin.getText())
                || !StringUtil.equals(settings.authPassword, authPassword.getText())
                || !StringUtil.equals(settings.siteUrl, siteUrl.getText())
                || settings.enableAuth != enableHttpAuth.isSelected()
                || !StringUtil.equals(settings.siteLogin, siteLogin.getText())
                || !StringUtil.equals(settings.sitePassword, sitePassword.getText());
    }

    @Override
    public void apply() throws ConfigurationException {
        LSSettings settings = LSSettings.getInstance();

        settings.enableAuth = enableHttpAuth.isSelected();
        settings.authLogin = authLogin.getText();
        settings.authPassword = authPassword.getText();
        settings.siteUrl = siteUrl.getText();
        settings.siteLogin = siteLogin.getText();
        settings.sitePassword = sitePassword.getText();
    }

    @Override
    public void reset() {
        LSSettings settings = LSSettings.getInstance();

        enableHttpAuth.setSelected(settings.enableAuth);
        authLogin.setText(settings.authLogin);
        authPassword.setText(settings.authPassword);
        siteUrl.setText(settings.siteUrl);
        siteLogin.setText(settings.siteLogin);
        sitePassword.setText(settings.sitePassword);
    }

    @Override
    public void disposeUIResources() {

    }
}
