package com.plopiplop.leekwars.psi;

import com.intellij.psi.tree.IElementType;
import com.plopiplop.leekwars.language.LeekScriptLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class LSTokenType extends IElementType {

    public LSTokenType(@NotNull @NonNls String debugName) {
        super(debugName, LeekScriptLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "LSTokenType." + super.toString();
    }
}