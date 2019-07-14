package com.plopiplop.leekwars.actions;

import com.intellij.testFramework.fixtures.LightCodeInsightFixtureTestCase;
import com.plopiplop.leekwars.model.Chip;
import com.plopiplop.leekwars.model.ModelManager;
import com.plopiplop.leekwars.model.Weapon;
import com.plopiplop.leekwars.options.LSSettings;

public class UpdateAPITaskTest extends LightCodeInsightFixtureTestCase {

    public void testUpdateApi() {
        ModelManager manager = ModelManager.getInstance(getProject());
        LSSettings.getInstance().siteLogin = System.getenv("LKS_LOGIN");
        LSSettings.getInstance().sitePassword = System.getenv("LKS_PASSWORD");

        new UpdateAPITask(getProject(), manager).run();

        assertNotEmpty(manager.getFunctions());
        assertNotEmpty(manager.getChips());

        Chip meteorite = manager.getChip("CHIP_METEORITE");
        assertNotNull(meteorite);
        assertTrue(meteorite.getLevel().matches("Niveau \\d+"));
        //assertEquals("Météorite", meteorite.getName());
        assertEquals("CHIP_METEORITE", meteorite.getId());
        assertNotNull(meteorite.getPrice());
        assertNotNull(meteorite.getDescription());
        assertEquals("36", meteorite.getValue());

        assertNotEmpty(manager.getWeapons());

        Weapon electrisor = manager.getWeapon("WEAPON_ELECTRISOR");
        assertNotNull(meteorite);
        assertTrue(electrisor.getLevel().matches("Niveau \\d+"));
        //assertEquals("Électriseur", electrisor.getName());
        assertEquals("WEAPON_ELECTRISOR", electrisor.getId());
        assertNotNull(electrisor.getPrice());
        assertNotNull(electrisor.getDescription());
        assertEquals("44", electrisor.getValue());
    }
}