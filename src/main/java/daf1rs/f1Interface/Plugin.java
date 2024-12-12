package daf1rs.f1Interface;

import org.bukkit.plugin.java.JavaPlugin;

import daf1rs.f1Interface.commands.*;

public final class Plugin extends JavaPlugin {

    @Override
    public void onEnable() {
        if (getCommand("f1Interface") != null) {
            getCommand("f1Interface").setExecutor(new F1InterfaceCommand());
            getCommand("f1Interface").setTabCompleter(new F1InterfaceTabCompleter());
        }
        getLogger().info("f1Interface включён!");
    }

    @Override
    public void onDisable() {
        getLogger().info("f1Interface выключён!");
    }
}
