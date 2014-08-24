package com.plopiplop.leekwars.actions;

import com.intellij.testFramework.fixtures.LightCodeInsightFixtureTestCase;
import com.plopiplop.leekwars.model.LeekWarsServer;
import com.plopiplop.leekwars.options.LSSettings;
import com.plopiplop.leekwars.options.PluginNotConfiguredException;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Map;

public class ScriptEditingTest extends LightCodeInsightFixtureTestCase {

    public static final String SCRIPT_CONTENT = "var foo = getLeek();";
    public static final String SCRIPT_NEW_CONTENT = "//You got it man!\nvar foo = getLeek();";

    public void testScriptEditionWorkflow() throws IOException, PluginNotConfiguredException, CompilationException {
        LSSettings.getInstance().siteLogin = System.getenv("LKS_LOGIN");
        LSSettings.getInstance().sitePassword = System.getenv("LKS_PASSWORD");

        String scriptId = LeekWarsServer.getInstance().createScript("idealeek", SCRIPT_CONTENT);

        Document editor = LeekWarsServer.getInstance().getEditor();
        DownloadScriptsTask task = new DownloadScriptsTask(getProject());
        task.parseScriptTags(editor);

        Map<String, String> scripts = task.getFiles();
        assertNotEmpty(scripts.keySet());
        assertTrue(containsId(scripts, scriptId));

        assertEquals(SCRIPT_CONTENT, LeekWarsServer.getInstance().downloadScript(scriptId).body().html());

        LeekWarsServer.getInstance().uploadScript(scriptId, "idealeek", SCRIPT_NEW_CONTENT);

        assertEquals(SCRIPT_NEW_CONTENT, LeekWarsServer.getInstance().downloadScript(scriptId).body().html());

        LeekWarsServer.getInstance().deleteScript(scriptId);

        editor = LeekWarsServer.getInstance().getEditor();
        task = new DownloadScriptsTask(getProject());
        task.parseScriptTags(editor);
        scripts = task.getFiles();

        assertFalse(containsId(scripts, scriptId));
    }

    private boolean containsId(Map<String, String> scripts, String scriptId) {
        for (String id : scripts.keySet()) {
            if (id.equals(scriptId)) {
                return true;
            }
        }
        return false;
    }
}
