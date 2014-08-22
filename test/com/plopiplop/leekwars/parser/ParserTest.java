package com.plopiplop.leekwars.parser;

import com.intellij.testFramework.ParsingTestCase;
import com.plopiplop.leekwars.psi.LSParserDefinition;

public class ParserTest extends ParsingTestCase {
    public ParserTest() {
        super("", "lks", new LSParserDefinition());
    }

    public void testExpressions() {
        doTest(true);
    }

    @Override
    protected String getTestDataPath() {
        return "testdata/parser";
    }
}
