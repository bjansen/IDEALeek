import com.intellij.testFramework.fixtures.LightCodeInsightFixtureTestCase;
import com.plopiplop.leekwars.psi.LSFile;

public abstract class LSCodeInsightTestSupport extends LightCodeInsightFixtureTestCase {

    protected LSFile initFile(String filename) {
        myFixture.configureByFiles(filename);

        return (LSFile) myFixture.getFile();
    }

    protected void moveCaret(int columnShift, int lineShift) {
        myFixture.getEditor().getCaretModel().moveCaretRelatively(columnShift, lineShift, false, false, true);
    }

    @Override
    protected String getTestDataPath() {
        return "testdata";
    }
}