package com.plopiplop.leekwars.options;

import com.intellij.openapi.components.*;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.Nullable;

@State(name = "LSSettings", storages = {@Storage(file = "leekscript.xml")})
public class LSSettings implements PersistentStateComponent<LSSettings> {
    public String siteUrl = "https://leekwars.com";
    public String siteLogin;
    public String sitePassword;
    public boolean enableAuth;
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

    public boolean isValid() {
        return StringUtils.isNotBlank(siteUrl) && StringUtils.isNotBlank(siteLogin) && StringUtils.isNotBlank(sitePassword);
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

    public String getSiteLogin() {
        return siteLogin;
    }

    public String getSitePassword() {
        return sitePassword;
    }

    public boolean isEnableAuth() {
        return enableAuth;
    }
}
