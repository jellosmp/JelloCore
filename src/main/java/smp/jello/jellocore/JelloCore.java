package smp.jello.jellocore;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import smp.jello.jellocore.commands.ReloadConfig;
import smp.jello.jellocore.commands.WelcomeBook;
import smp.jello.jellocore.events.PlayerJoin;
import smp.jello.jellocore.events.ServerListPing;

public final class JelloCore extends JavaPlugin {
    FileConfiguration config = this.getConfig();

    private static JelloCore _instance;

    @Override
    public void onEnable() {
        _instance = this;

        config.addDefault("motd", ChatColor.BOLD.toString() + ChatColor.GREEN + "Jello" + ChatColor.DARK_GREEN + " SMP");
        config.options().copyDefaults(true);
        saveConfig();

        Bukkit.getPluginManager().registerEvents(new ServerListPing(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(), this);

        getCommand("reloadconfig").setExecutor(new ReloadConfig());
        getCommand("welcomebook").setExecutor(new WelcomeBook());
    }

    @Override
    public void onDisable() {
        getLogger().info("Bye bye");
    }

    public static JelloCore getInstance() {
        return _instance;
    }
}
