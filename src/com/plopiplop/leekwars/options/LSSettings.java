package com.plopiplop.leekwars.options;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.components.StoragePathMacros;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.Nullable;

@State(name = "LSSettings", storages = {@Storage(id = "leekscript", file = StoragePathMacros.APP_CONFIG + "/leekscript.xml")})
public class LSSettings implements PersistentStateComponent<LSSettings> {
    public String siteUrl;
    public String authLogin;
    public String authPassword;

    public static LSSettings getInstance() {
        return ServiceManager.getService(LSSettings.class);
    }

    @Nullable
    @Override
    public LSSettings getState() {
        return this;
    }

    @Override
    public void loadState(LSSettings state) {
        XmlSerializerUtil.copyBean(state, this);
    }

    /**
     * @return {@link LSSettings#siteUrl}
     */
    public String getSiteUrl() {
        return siteUrl;
    }

    /**
     * @return {@link LSSettings#authLogin}
     */
    public String getAuthLogin() {
        return authLogin;
    }

    /**
     * @return {@link LSSettings#authPassword}
     */
    public String getAuthPassword() {
        return authPassword;
    }
}
