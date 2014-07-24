package com.plopiplop.leekwars.templates;

import com.intellij.codeInsight.template.impl.DefaultLiveTemplatesProvider;

public class LSLiveTemplatesProvider implements DefaultLiveTemplatesProvider {

    private static final String[] DEFAULT_TEMPLATES = new String[]{
            "/liveTemplates/LeekScriptLiveTemplates"
    };

    @Override
    public String[] getDefaultLiveTemplateFiles() {
        return DEFAULT_TEMPLATES;
    }

    @Override
    public String[] getHiddenLiveTemplateFiles() {
        return null;
    }
}