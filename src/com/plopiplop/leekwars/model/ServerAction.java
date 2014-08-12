package com.plopiplop.leekwars.model;

import com.plopiplop.leekwars.options.PluginNotConfiguredException;

import java.io.IOException;

public interface ServerAction {

    void doAction() throws PluginNotConfiguredException, IOException;
}
