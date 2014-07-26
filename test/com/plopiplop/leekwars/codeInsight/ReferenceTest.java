package com.plopiplop.leekwars.codeInsight;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.PsiReferenceService;
import com.intellij.psi.util.PsiTreeUtil;
import com.plopiplop.leekwars.psi.LSFile;
import com.plopiplop.leekwars.psi.LSNamedElement;
import com.plopiplop.leekwars.psi.LSVariableDeclaration;

import java.util.List;

public class ReferenceTest extends LSCodeInsightTestSupport {

    @Override
    protected String getTestDataPath() {
        return "testdata/references";
    }

    public void testReferences() {
        LSFile file = initFile("BlockStatements.lks");

        // do/while loop

        // second debug() resolves correctly
        moveCaret(11, 5);
        assertRefdAtCaret(file, 30, LSVariableDeclaration.class);

        // reference in while condition is invalid
        moveCaret(0, 1);
        assertNoRef(file);

        // reference before declaration is invalid
        moveCaret(0, -5);
        assertNoRef(file);

        // references to itself
        moveCaret(-1, 2);
        assertRefdAtCaret(file, 30, LSVariableDeclaration.class);

        // reference outside of block is invalid
        moveCaret(-2, 5);
        assertNoRef(file);

        // while loop

        // reference in while condition is invalid
        moveCaret(0, 2);
        assertNoRef(file);

        // reference before declaration
        moveCaret(3, 1);
        assertNoRef(file);

        // reference to itself
        moveCaret(-1, 2);
        assertRefdAtCaret(file, 128, LSVariableDeclaration.class);

        // valid reference
        moveCaret(1, 2);
        assertRefdAtCaret(file, 128, LSVariableDeclaration.class);

        // reference before declaration
        moveCaret(-3, 3);
        assertNoRef(file);

        moveCaret(3, 1);
        assertNoRef(file);

        moveCaret(0, 1);
        assertRefdAtCaret(file, 221, LSVariableDeclaration.class);

        moveCaret(0, 1);
        assertRefdAtCaret(file, 221, LSVariableDeclaration.class);

        moveCaret(0, 2);
        assertRefdAtCaret(file, 259, LSVariableDeclaration.class);

        moveCaret(1, 1);
        assertRefdAtCaret(file, 259, LSVariableDeclaration.class);
    }

    private void assertNoRef(LSFile file) {
        final PsiElement elementAtCaret = file.findElementAt(myFixture.getCaretOffset());
        PsiElement element = PsiTreeUtil.getParentOfType(elementAtCaret, LSNamedElement.class);
        assertNotNull("Identifier not found at offset " + myFixture.getCaretOffset(), element);

        final PsiReference ref = getSingleReference(element);
        assertNull(ref.resolve());
    }

    private <PSI extends LSNamedElement> PSI assertRefdAtCaret(LSFile file, int referencedOffset, Class<? extends PSI> psiClass) {
        final PsiElement elementAtCaret = file.findElementAt(myFixture.getCaretOffset());
        PsiElement element = PsiTreeUtil.getParentOfType(elementAtCaret, LSNamedElement.class);
        assertNotNull("Identifier not found at offset " + myFixture.getCaretOffset(), element);
        final PSI referenced = getReferencedElement(element);
        assertTrue(String.format("%s (%s) not instance of %s", referenced, referenced.getClass(), psiClass), psiClass.isAssignableFrom(referenced.getClass()));
        final PsiElement nameIdentifier = referenced.getNameIdentifier();
        assertNotNull(nameIdentifier);
        assertEquals(referencedOffset, nameIdentifier.getTextOffset());
        return referenced;
    }


    private <T> T getReferencedElement(PsiElement element) {
        final PsiReference ref = getSingleReference(element);
        return resolveReference(ref);
    }

    private <T> T resolveReference(PsiReference ref) {
        @SuppressWarnings("unchecked")
        final T referenced = (T) ref.resolve();
        assertNotNull("Reference resolved to null.", referenced);
        return referenced;
    }

    private PsiReference getSingleReference(PsiElement element) {
        final List<PsiReference> refs = PsiReferenceService.getService().getReferences(element, new PsiReferenceService.Hints());
        assertSize(1, refs);
        return refs.get(0);
    }
}
