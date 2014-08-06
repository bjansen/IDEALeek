package com.plopiplop.leekwars.project;

import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.options.ConfigurationException;
import com.plopiplop.leekwars.options.LeekScriptConfigurable;

import javax.swing.*;

public class LSModuleWizardStep extends ModuleWizardStep {

    private LeekScriptConfigurable configuration = new LeekScriptConfigurable();

    @Override
    public JComponent getComponent() {
        JComponent component = configuration.createComponent();

        configuration.reset();

        return component;
    }

    @Override
    public void updateDataModel() {
        try {
            configuration.apply();
        } catch (ConfigurationException e) {
            Notifications.Bus.notify(new Notification("LeekScript", "Configuration error", "Can't write configuration :(", NotificationType.ERROR));
        }
    }
}
