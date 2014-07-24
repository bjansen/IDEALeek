package com.plopiplop.leekwars.templates;

import com.intellij.codeInsight.template.FileTypeBasedContextType;
import com.plopiplop.leekwars.language.LSFileType;

public class LSContextType extends FileTypeBasedContextType {

    protected LSContextType() {
        super("LEEK_SCRIPT", "&LeekScript", LSFileType.INSTANCE);
    }
}