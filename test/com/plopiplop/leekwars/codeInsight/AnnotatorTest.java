package com.plopiplop.leekwars.codeInsight;

public class AnnotatorTest extends LSCodeInsightTestSupport {

    @Override
    protected String getTestDataPath() {
        return "testdata/annotator";
    }

    public void testDuplicateDeclarations() {
        myFixture.configureByFile("Duplicates.lks");
        myFixture.checkHighlighting();
    }

    public void testUnresolvedIdentifier() {
        myFixture.configureByFile("Unresolved.lks");
        myFixture.checkHighlighting();
    }

    public void testGlobalVariables() {
        myFixture.configureByFile("Globals.lks");
        myFixture.checkHighlighting();
    }
}
