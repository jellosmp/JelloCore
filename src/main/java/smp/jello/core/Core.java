package smp.jello.core;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import smp.jello.core.events.ServerListPing;

public final class Core extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new ServerListPing(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("Bye bye");
    }
}
