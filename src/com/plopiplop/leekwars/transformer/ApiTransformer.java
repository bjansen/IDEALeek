package com.plopiplop.leekwars.transformer;

import com.google.common.io.Files;
import com.intellij.ide.fileTemplates.FileTemplateManager;
import com.intellij.ide.fileTemplates.FileTemplateUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiFile;
import com.plopiplop.leekwars.model.ModelManager;

import java.io.File;
import java.nio.charset.Charset;
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
        String fileName = LEEKWARS_API_FILE;

        if (existingApi != null) {
            fileName = LEEKWARS_API_FILE + ".tmp";
            VirtualFile child = out.getVirtualFile().findChild(fileName + ".lks");

            if (child != null && child.exists()) {
                child.delete(this);
            }
        }

        FileTemplateUtil.createFromTemplate(templateManager.getInternalTemplate(LEEKWARS_API_FILE), fileName, context, out, getClass().getClassLoader());

        if (existingApi != null) {
            File tmpFile = new File(out.getVirtualFile().getPath(), fileName + ".lks");
            String content = Files.toString(tmpFile, Charset.forName("UTF-8"));
            existingApi.getViewProvider().getDocument().setText(content.replace("\r\n", "\n"));
            tmpFile.delete();
        }
    }
}
