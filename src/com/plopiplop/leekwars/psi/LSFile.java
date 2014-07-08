package com.plopiplop.leekwars.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.plopiplop.leekwars.language.LSFileType;
import com.plopiplop.leekwars.language.LeekScriptLanguage;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class LSFile extends PsiFileBase {
    public LSFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, LeekScriptLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return LSFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Simple File";
    }

    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }
}