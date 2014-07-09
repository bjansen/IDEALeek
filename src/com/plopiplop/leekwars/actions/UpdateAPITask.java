package com.plopiplop.leekwars.actions;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.project.Project;
import com.plopiplop.leekwars.model.Chip;
import com.plopiplop.leekwars.model.LeekWarsServer;
import com.plopiplop.leekwars.model.ModelManager;
import com.plopiplop.leekwars.model.Weapon;
import com.plopiplop.leekwars.options.PluginNotConfiguredException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UpdateAPITask implements Runnable {

    private Project project;
    private ModelManager modelManager;

    public UpdateAPITask(Project project, ModelManager modelManager) {
        this.project = project;
        this.modelManager = modelManager;
    }

    @Override
    public void run() {
        Document doc;
        try {
            doc = LeekWarsServer.getInstance().getMarket();
        } catch (IOException e) {
            Notifications.Bus.notify(new Notification("LeekScript", "Error", "Can't reach LeekWars server :(", NotificationType.ERROR));
            e.printStackTrace();
            return;
        } catch (PluginNotConfiguredException e) {
            Notifications.Bus.notify(new Notification("LeekScript", "Can't connect to LeekWars server", "Please configure the LeekScript plugin", NotificationType.ERROR));
            return;
        }

        Elements elements = doc.select("#preview div.item");

        List<Weapon> weapons = new ArrayList<>();
        List<Chip> chips = new ArrayList<>();

        for (Element element : elements) {
            if (element.attr("id").startsWith("weapon-")) {
                Weapon weapon = new Weapon();
                weapon.id = element.select("div.constant").text();
                weapon.name = element.select("div.header h2.name").text();
                weapon.level = element.select("div.header div.level").text();
                weapon.description = element.select("div.desc").text();
                weapon.price = element.select("div.buy-button span").text();

                weapons.add(weapon);
            } else if (element.attr("id").startsWith("chip-")) {
                Chip chip = new Chip();
                element = element.child(0);

                chip.id = element.select("div.constant").text();
                chip.name = element.select("div.header h2.name").text();
                chip.level = element.select("div.header div.level").text();
                chip.description = element.select("div.desc").text();
                chip.price = element.parent().select("div.buy-button span").text();

                chips.add(chip);
            }
        }

        if (modelManager == null) {
            ModelManager.getInstance(project).setWeapons(weapons);
            ModelManager.getInstance(project).setChips(chips);
        } else {
            modelManager.setWeapons(weapons);
            modelManager.setChips(chips);
        }
    }
}
