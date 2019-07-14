package com.plopiplop.leekwars.actions;

import com.intellij.testFramework.fixtures.LightCodeInsightFixtureTestCase;
import com.plopiplop.leekwars.apiclient.ApiException;
import com.plopiplop.leekwars.apiclient.LeekWarsApiClient;
import com.plopiplop.leekwars.options.LSSettings;
import com.plopiplop.leekwars.options.PluginNotConfiguredException;

import java.io.IOException;
import java.util.Map;

public class ScriptEditingTest extends LightCodeInsightFixtureTestCase {

    private static final String SCRIPT_CONTENT = "var foo = getLeek();";
    private static final String SCRIPT_NEW_CONTENT = "//You got it man!\nvar foo = getLeek();";

    public void testScriptEditionWorkflow() throws IOException, PluginNotConfiguredException, CompilationException, ApiException {
        LSSettings.getInstance().siteLogin = System.getenv("LKS_LOGIN");
        LSSettings.getInstance().sitePassword = System.getenv("LKS_PASSWORD");

        int scriptId = LeekWarsApiClient.getInstance().createScript("idealeek", SCRIPT_CONTENT);

        Map<Integer, String> scripts = LeekWarsApiClient.getInstance().listScripts();
        assertTrue(scripts.containsKey(scriptId));
        assertEquals("idealeek", scripts.get(scriptId));

        assertEquals(SCRIPT_CONTENT, LeekWarsApiClient.getInstance().downloadScript(scriptId));

        LeekWarsApiClient.getInstance().uploadScript(scriptId, "idealeek", SCRIPT_NEW_CONTENT);

        assertEquals(SCRIPT_NEW_CONTENT, LeekWarsApiClient.getInstance().downloadScript(scriptId));

        LeekWarsApiClient.getInstance().deleteScript(scriptId);

        scripts = LeekWarsApiClient.getInstance().listScripts();
        assertFalse(scripts.containsKey(scriptId));
    }

}
