package com.plopiplop.leekwars.project;

import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.util.IconLoader;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class LSModuleType extends ModuleType<LSModuleBuilder> {

    public static final LSModuleType INSTANCE = new LSModuleType();

    @NonNls
    private static final String ID = "LEEKSCRIPT_MODULE";

    public LSModuleType() {
        super(ID);
    }

    @NotNull
    @Override
    public LSModuleBuilder createModuleBuilder() {
        return new LSModuleBuilder();
    }

    @NotNull
    @Override
    public String getName() {
        return "LeekScript";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Creates a new module containing LeekScript files";
    }

    @Override
    public Icon getBigIcon() {
        return IconLoader.getIcon("/icons/leek.png");
    }

    @Override
    public Icon getNodeIcon(@Deprecated boolean isOpened) {
        return getBigIcon();
    }
}
