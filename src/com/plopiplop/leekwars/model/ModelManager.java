package com.plopiplop.leekwars.model;

import com.intellij.openapi.components.AbstractProjectComponent;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

public class ModelManager extends AbstractProjectComponent {

    private List<Weapon> weapons = Collections.emptyList();
    private List<Chip> chips = Collections.emptyList();
    private List<Function> functions;
    private List<Constant> constants;

    protected ModelManager(Project project) {
        super(project);
    }

    public static ModelManager getInstance(@NotNull Project project) {
        return project.getComponent(ModelManager.class);
    }

    @Override
    public void initComponent() {
//        MapDataContext context = new MapDataContext();
//        context.put(CommonDataKeys.PROJECT, myProject);
//        AnActionEvent event = new AnActionEvent(null, context, ActionPlaces.UNKNOWN, new Presentation(), ActionManager.getInstance(), 0);
//
//        new UpdateAPIAction(this).actionPerformed(event);
    }

    /**
     * @return {@link ModelManager#weapons}
     */
    public List<Weapon> getWeapons() {
        return weapons;
    }

    public Weapon getWeapon(String weaponId) {
        for (Weapon weapon : weapons) {
            if (weapon.id.equals(weaponId)) {
                return weapon;
            }
        }

        return null;
    }

    /**
     * @param weapons {@link ModelManager#weapons}
     */
    public void setWeapons(List<Weapon> weapons) {
        this.weapons = weapons;
    }

    public Chip getChip(String chipId) {
        for (Chip chip : chips) {
            if (chip.id.equals(chipId)) {
                return chip;
            }
        }

        return null;
    }

    /**
     * @return {@link ModelManager#chips}
     */
    public List<Chip> getChips() {
        return chips;
    }

    /**
     * @param chips {@link ModelManager#chips}
     */
    public void setChips(List<Chip> chips) {
        this.chips = chips;
    }

    public void setFunctions(List<Function> functions) {
        this.functions = functions;
    }

    public List<Function> getFunctions() {
        return functions;
    }

    public void setConstants(List<Constant> constants) {
        this.constants = constants;
    }

    public List<Constant> getConstants() {
        return constants;
    }
}
