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
import com.plopiplop.leekwars.model.*;
import com.plopiplop.leekwars.options.PluginNotConfiguredException;
import com.plopiplop.leekwars.transformer.ApiTransformer;
import com.plopiplop.leekwars.transformer.ChipParser;
import com.plopiplop.leekwars.transformer.FunctionParser;
import com.plopiplop.leekwars.transformer.WeaponParser;
import org.jetbrains.jps.model.java.JavaSourceRootProperties;
import org.jetbrains.jps.model.java.JavaSourceRootType;
import org.jetbrains.jps.model.java.JpsJavaExtensionService;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Objects.firstNonNull;

public class UpdateAPITask implements Runnable {

    private Project project;
    private ModelManager modelManager;

    public UpdateAPITask(Project project, ModelManager modelManager) {
        this.project = project;
        this.modelManager = firstNonNull(modelManager, ModelManager.getInstance(project));
    }

    @Override
    public void run() {
        Document market;
        Document documentation;

        try {
            market = LeekWarsServer.getInstance().getMarket();
            documentation = LeekWarsServer.getInstance().getDocumentation();
        } catch (IOException e) {
            Notifications.Bus.notify(new Notification("LeekScript", "Error", "Can't reach LeekWars server :(", NotificationType.ERROR));
            e.printStackTrace();
            return;
        } catch (PluginNotConfiguredException e) {
            Notifications.Bus.notify(new Notification("LeekScript", "Can't connect to LeekWars server", "Please configure the LeekScript plugin", NotificationType.ERROR));
            return;
        }

        parseMarket(market);
        parseDocumentation(documentation);

        ApplicationManager.getApplication().invokeLater(new Runnable() {
            @Override
            public void run() {
                ApplicationManager.getApplication().runWriteAction(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            ApiTransformer.getInstance().transformToLeekScript(modelManager, findOrCreateGenSourceRoot());
                        } catch (Exception e) {
                            e.printStackTrace();
                            Notifications.Bus.notify(new Notification("LeekScript", "LeekWars APPI", "Can't write API to " + LeekWarsApi.LEEKWARS_API_FILE, NotificationType.ERROR));
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

    private void parseDocumentation(Document documentation) {
        Elements elements = documentation.select("#functions .function");
        List<Function> functions = new ArrayList<>();

        for (Element element : elements) {
            Function function = (FunctionParser.getInstance()).parse(element);

            if (function != null) {
                functions.add(function);
            }
        }

        modelManager.setFunctions(functions);
    }

    private void parseMarket(Document market) {
        Elements elements = market.select("#preview div.item");

        List<Weapon> weapons = new ArrayList<>();
        List<Chip> chips = new ArrayList<>();

        for (Element element : elements) {
            if (element.attr("id").startsWith("weapon-")) {
                weapons.add(WeaponParser.getInstance().parse(element));
            } else if (element.attr("id").startsWith("chip-")) {
                chips.add(ChipParser.getInstance().parse(element));
            }
        }

        modelManager.setWeapons(weapons);
        modelManager.setChips(chips);
    }
}
