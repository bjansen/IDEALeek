package com.plopiplop.leekwars.language;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class LSFileType extends LanguageFileType {
    public static final LSFileType INSTANCE = new LSFileType();

    private LSFileType() {
        super(LeekScriptLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Leek Script";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Script for LeekWars";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "lks";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return LSIcons.FILE;
    }
}
