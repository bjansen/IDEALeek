package com.plopiplop.leekwars.editor.formatter;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.CommandProcessor;
import com.intellij.psi.PsiFile;
import com.intellij.psi.codeStyle.CodeStyleManager;
import com.intellij.testFramework.fixtures.LightCodeInsightFixtureTestCase;

public class FormatterTest extends LightCodeInsightFixtureTestCase {

    @Override
    protected String getTestDataPath() {
        return "testdata/formatter";
    }

    public void testVarDeclarationFormatting() throws Exception {
        testFormatting("var");
    }

    public void testOperatorsFormatting() throws Exception {
        testFormatting("operator");
    }

    public void testForFormatting() throws Exception {
        testFormatting("for");
    }

    public void testIfFormatting() throws Exception {
        testFormatting("if");
    }

    public void testFunctionFormatting() throws Exception {
        testFormatting("function");
    }

    public void testWhileFormatting() throws Exception {
        testFormatting("while");
    }

    public void testAllFormatting() throws Exception {
        testFormatting("all");
    }

    private void testFormatting(String testSource) throws Exception {
        final PsiFile file = myFixture.configureByFile(testSource + ".lks");

        ApplicationManager.getApplication().runWriteAction(new Runnable() {
            @Override
            public void run() {
                CommandProcessor.getInstance().runUndoTransparentAction(
                        new Runnable() {
                            @Override
                            public void run() {
                                CodeStyleManager.getInstance(getProject()).reformat(file);
                            }
                        }
                );
            }
        });
        myFixture.checkResultByFile(testSource + ".formatted.lks");
    }
}
