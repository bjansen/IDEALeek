package com.plopiplop.leekwars.refactoring;

import com.plopiplop.leekwars.codeInsight.LSCodeInsightTestSupport;

public class LSIntroduceVariableHandlerTest extends LSCodeInsightTestSupport {

    @Override
    protected String getTestDataPath() {
        return "testdata/refactoring/introducevar";
    }

    public void testMethodCall() {
        performTest("methodCall", 25);
    }

    public void testIf() {
        performTest("if", 32);
    }

    public void testWhile() {
        // TODO if the expression contains a variable that's modified in the while body, we should not allow it
        performTest("while", 32);
    }

    private void performTest(String fileName, int offset) {
        myFixture.configureByFile(fileName + ".lks");
        myFixture.getEditor().getCaretModel().moveToOffset(offset);

        new LSRefactoringSupportProvider().getIntroduceVariableHandler()
                .invoke(myFixture.getProject(), myFixture.getEditor(), myFixture.getFile(), null);

        myFixture.checkResultByFile(fileName + "_after.lks");
    }
}