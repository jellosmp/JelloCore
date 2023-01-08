package smp.jello.jellocore.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import smp.jello.jellocore.JelloCore;

public class ReloadConfig implements CommandExecutor {
    JelloCore plugin = JelloCore.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        plugin.reloadConfig();
        sender.sendMessage(ChatColor.GRAY + "[Jelly Core] plugin.reloadConfig() has been called!");
        return true;
    }
}
