package com.plopiplop.leekwars.editor;

import com.intellij.ProjectTopics;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ModuleRootAdapter;
import com.intellij.openapi.roots.ModuleRootEvent;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.ui.EditorNotificationPanel;
import com.intellij.ui.EditorNotifications;
import com.plopiplop.leekwars.ApiNotFoundException;
import com.plopiplop.leekwars.LeekWarsApi;
import com.plopiplop.leekwars.actions.UpdateAPITask;
import com.plopiplop.leekwars.language.LeekScriptLanguage;
import com.plopiplop.leekwars.model.ModelManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MissingApiNotificationProvider extends EditorNotifications.Provider<EditorNotificationPanel> {

    private static final Key<EditorNotificationPanel> KEY = Key.create("setup.leekwars.api");

    private final Project myProject;

    public MissingApiNotificationProvider(Project project, final EditorNotifications notifications) {
        myProject = project;
        myProject.getMessageBus().connect(project).subscribe(ProjectTopics.PROJECT_ROOTS, new ModuleRootAdapter() {
            public void rootsChanged(ModuleRootEvent event) {
                notifications.updateAllNotifications();
            }
        });
    }

    @NotNull
    @Override
    public Key<EditorNotificationPanel> getKey() {
        return KEY;
    }

    @Nullable
    @Override
    public EditorNotificationPanel createNotificationPanel(@NotNull VirtualFile file, @NotNull FileEditor fileEditor) {
        final PsiFile psiFile = PsiManager.getInstance(myProject).findFile(file);
        if (psiFile == null) {
            return null;
        }

        if (psiFile.getLanguage() != LeekScriptLanguage.INSTANCE) {
            return null;
        }

        try {
            LeekWarsApi.getApiPsiFile(myProject);
        } catch (ApiNotFoundException e) {
            return createPanel(myProject);
        }

        return null;
    }


    @NotNull
    private static EditorNotificationPanel createPanel(final @NotNull Project project) {
        final EditorNotificationPanel panel = new EditorNotificationPanel();

        panel.setText("LeekWars API could not be found");
        panel.createActionLabel("Update LeekWars API", new UpdateAPITask(project, ModelManager.getInstance(project)));

        return panel;
    }
}
