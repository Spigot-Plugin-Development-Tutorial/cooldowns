package me.kodysimpson.commandcooldowns;

import org.bukkit.plugin.java.JavaPlugin;

public final class CommandCooldowns extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        getCommand("fart").setExecutor(new FartCommand());


    }

}
