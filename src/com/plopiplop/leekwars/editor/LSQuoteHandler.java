package com.plopiplop.leekwars.editor;

import com.intellij.codeInsight.editorActions.SimpleTokenSetQuoteHandler;
import com.plopiplop.leekwars.psi.LSTypes;

public class LSQuoteHandler extends SimpleTokenSetQuoteHandler {

    public LSQuoteHandler() {
        super(
                LSTypes.STRING
        );
    }
}
