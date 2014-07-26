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
}
