package com.plopiplop.leekwars.actions;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ContentEntry;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiManager;
import com.plopiplop.leekwars.LeekWarsApi;
import com.plopiplop.leekwars.apiclient.LeekWarsApiClient;
import com.plopiplop.leekwars.model.ModelManager;
import com.plopiplop.leekwars.model.ServerAction;
import com.plopiplop.leekwars.options.PluginNotConfiguredException;
import com.plopiplop.leekwars.transformer.ApiTransformer;
import org.jetbrains.jps.model.java.JavaSourceRootProperties;
import org.jetbrains.jps.model.java.JavaSourceRootType;
import org.jetbrains.jps.model.java.JpsJavaExtensionService;

import java.io.IOException;

import static org.apache.commons.lang.ObjectUtils.defaultIfNull;

public class UpdateAPITask implements Runnable {

    private Project project;
    private ModelManager modelManager;

    public UpdateAPITask(Project project, ModelManager modelManager) {
        this.project = project;
        this.modelManager = (ModelManager) defaultIfNull(modelManager, ModelManager.getInstance(project));
    }

    @Override
    public void run() {

        LeekWarsApiClient.callAction(new ServerAction() {
            @Override
            public void doAction() throws PluginNotConfiguredException, IOException {
                modelManager.setWeapons(LeekWarsApiClient.getInstance().getWeapons());
                modelManager.setChips(LeekWarsApiClient.getInstance().getChips());
                modelManager.setFunctions(LeekWarsApiClient.getInstance().getFunctions());
                modelManager.setConstants(LeekWarsApiClient.getInstance().getConstants());

                if (!ApplicationManager.getApplication().isUnitTestMode()) {
                    writeApiFile();
                }
            }
        });
    }

    private void writeApiFile() {
        ApplicationManager.getApplication().invokeLater(new Runnable() {
            @Override
            public void run() {
                ApplicationManager.getApplication().runWriteAction(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            ApiTransformer.getInstance().transformToLeekScript(modelManager, findOrCreateGenSourceRoot());
                        } catch (Exception e) {
                            Notifications.Bus.notify(new Notification("LeekScript", "LeekWars API", "Can't write API to " + LeekWarsApi.LEEKWARS_API_FILE, NotificationType.ERROR));
                            throw new RuntimeException(e);
                        }
                    }
                });
            }
        });
    }

    private PsiDirectory findOrCreateGenSourceRoot() throws IOException {
        Module module = ModuleManager.getInstance(project).getModules()[0];
        VirtualFile genRoot = LeekWarsApi.getGenRoot(project);

        if (genRoot == null) {
            ModifiableRootModel model = ModuleRootManager.getInstance(module).getModifiableModel();

            ContentEntry contentEntry = model.getContentEntries()[0];

            if (contentEntry.getFile() != null) {
                VirtualFile genDirectory = contentEntry.getFile().createChildDirectory(this, "gen");
                JavaSourceRootProperties properties = JpsJavaExtensionService.getInstance().createSourceRootProperties("", true);
                genRoot = contentEntry.addSourceFolder(genDirectory, JavaSourceRootType.SOURCE, properties).getFile();
                model.commit();
                module.getProject().save();
            }
        }

        if (genRoot == null) {
            throw new IOException("Could not generate gen source root");
        }

        return PsiManager.getInstance(project).findDirectory(genRoot);
    }
}
