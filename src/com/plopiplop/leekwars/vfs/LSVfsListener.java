package com.plopiplop.leekwars.vfs;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.components.AbstractProjectComponent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.*;
import com.plopiplop.leekwars.actions.CompilationException;
import com.plopiplop.leekwars.apiclient.LeekWarsApiClient;
import com.plopiplop.leekwars.model.ServerAction;
import com.plopiplop.leekwars.options.PluginNotConfiguredException;
import com.plopiplop.leekwars.psi.LSFile;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.io.IOException;
import java.util.regex.Matcher;

public class LSVfsListener extends AbstractProjectComponent {

    protected LSVfsListener(Project project) {
        super(project);
    }

    @Override
    public void initComponent() {
        VirtualFileManager.getInstance().addVirtualFileListener(new VirtualFileAdapter() {
            @Override
            public void propertyChanged(@NotNull VirtualFilePropertyEvent event) {
                LSVfsListener.this.propertyChanged(event);
            }

            @Override
            public void fileDeleted(@NotNull VirtualFileEvent event) {
                LSVfsListener.this.fileDeleted(event);
            }
        });

    }

    private void fileDeleted(VirtualFileEvent event) {
        Matcher matcher = LSFile.LKS_FILE_PATTERN.matcher(event.getFileName());

        if (matcher.matches()) {
            int result = JOptionPane.showConfirmDialog(null, "Would you like to delete this AI on the LeekWars server as well?", "Confirm deletion", JOptionPane.YES_NO_OPTION);

            if (result == JOptionPane.YES_OPTION) {
                final int id = Integer.parseInt(matcher.group(2));

                LeekWarsApiClient.callAction(new ServerAction() {
                    @Override
                    public void doAction() throws PluginNotConfiguredException, IOException {
                        LeekWarsApiClient.getInstance().deleteScript(id);
                    }
                });
            }
        }
    }

    private void propertyChanged(@NotNull final VirtualFilePropertyEvent event) {
        if (event.getPropertyName().equals(VirtualFile.PROP_NAME)) {
            String oldName = event.getOldValue().toString();
            Matcher matcher = LSFile.LKS_FILE_PATTERN.matcher(oldName);

            if (matcher.matches()) {
                int oldId = Integer.parseInt(matcher.group(2));

                final Matcher newMatcher = LSFile.LKS_FILE_PATTERN.matcher(event.getNewValue().toString());

                if (newMatcher.matches() && Integer.parseInt(newMatcher.group(2)) == oldId) {

                    LeekWarsApiClient.callAction(new ServerAction() {
                        @Override
                        public void doAction() throws PluginNotConfiguredException, IOException {
                            try {
                                LeekWarsApiClient.getInstance().uploadScript(Integer.parseInt(newMatcher.group(2)), newMatcher.group(1), new String(event.getFile().contentsToByteArray()));
                            } catch (CompilationException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                } else {
                    Notifications.Bus.notify(new Notification("LeekScript", "Script renaming", "The script's ID was altered, synchronization with the LeekWars server will be lost", NotificationType.WARNING));
                }
            }
        }
    }
}
