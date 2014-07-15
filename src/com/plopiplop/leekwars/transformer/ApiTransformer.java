package com.plopiplop.leekwars.transformer;

import com.intellij.ide.fileTemplates.FileTemplateManager;
import com.intellij.ide.fileTemplates.FileTemplateUtil;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiFile;
import com.plopiplop.leekwars.model.ModelManager;

import java.util.HashMap;
import java.util.Map;

import static com.plopiplop.leekwars.LeekWarsApi.LEEKWARS_API_FILE;


public class ApiTransformer {

    private static final ApiTransformer INSTANCE = new ApiTransformer();

    private ApiTransformer() {
    }

    public static ApiTransformer getInstance() {
        return INSTANCE;
    }

    public void transformToLeekScript(ModelManager manager, PsiDirectory out) throws Exception {
        FileTemplateManager templateManager = FileTemplateManager.getInstance();
        Map<String, Object> context = new HashMap<>();
        context.put("weapons", manager.getWeapons());
        context.put("chips", manager.getChips());
        context.put("functions", manager.getFunctions());

        PsiFile existingApi = out.findFile(LEEKWARS_API_FILE);

        if (existingApi != null) {
            existingApi.delete();
        }

        FileTemplateUtil.createFromTemplate(templateManager.getInternalTemplate(LEEKWARS_API_FILE), LEEKWARS_API_FILE, context, out, getClass().getClassLoader());
    }
}
