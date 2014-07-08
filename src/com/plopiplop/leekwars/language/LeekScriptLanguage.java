package com.plopiplop.leekwars.language;

import com.intellij.lang.Language;

public class LeekScriptLanguage extends Language {

    public static final LeekScriptLanguage INSTANCE = new LeekScriptLanguage();

    private LeekScriptLanguage() {
        super("LeekScript");
    }
}
