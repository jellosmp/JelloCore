package smp.jello.jellocore.events;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;
import smp.jello.jellocore.JelloCore;

public class ServerListPing implements Listener {
    final String MOTD_NULL_ERROR = ChatColor.BOLD.toString() + ChatColor.RED + "ERROR: " + ChatColor.RESET.toString() + ChatColor.UNDERLINE + ChatColor.GRAY + "Please contact the server admin. There is a config error in Jello Core. ./plugins/JelloCore/config.yml/motd may be missing, null, or corrupted!";

    FileConfiguration config = JelloCore.getInstance().getConfig();

    @EventHandler
    public void onServerPing(ServerListPingEvent event) {
        String motd = config.getString("motd");
        event.setMotd(motd == null ? MOTD_NULL_ERROR : motd);
    }
}
