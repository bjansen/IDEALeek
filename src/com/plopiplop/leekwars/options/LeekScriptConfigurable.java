package com.plopiplop.leekwars.options;

import com.intellij.openapi.components.PersistentStateComponent;
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

public class LeekScriptConfigurable implements SearchableConfigurable, Configurable.NoScroll, PersistentStateComponent<LSSettings> {

    private JPanel rootComponent;
    private TextFieldWithStoredHistory siteUrl;
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

            JLabel labelSiteUrl = new JLabel("Site URL");
            rootComponent.add(labelSiteUrl);
            siteUrl = new TextFieldWithStoredHistory("LeekScript.SiteUrl");
            rootComponent.add(siteUrl);

            JLabel labelAuthLogin = new JLabel("Auth login");
            rootComponent.add(labelAuthLogin);
            authLogin = new JTextField();
            rootComponent.add(authLogin);

            JLabel labelAuthPassword = new JLabel("Auth password");
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
                || !StringUtil.equals(settings.siteUrl, siteUrl.getText());
    }

    @Override
    public void apply() throws ConfigurationException {
        LSSettings settings = LSSettings.getInstance();

        settings.authLogin = authLogin.getText();
        settings.authPassword = authPassword.getText();
        settings.siteUrl = siteUrl.getText();
    }

    @Override
    public void reset() {
        LSSettings settings = LSSettings.getInstance();

        authLogin.setText(settings.authLogin);
        authPassword.setText(settings.authPassword);
        siteUrl.setText(settings.siteUrl);
    }

    @Override
    public void disposeUIResources() {

    }

    @Nullable
    @Override
    public LSSettings getState() {
        return LSSettings.getInstance();
    }

    @Override
    public void loadState(LSSettings state) {
        LSSettings.getInstance().loadState(state);
    }
}
