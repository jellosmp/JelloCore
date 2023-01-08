package smp.jello.jellocore.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import smp.jello.jellocore.events.PlayerJoin;

public class WelcomeBook implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;

        new PlayerJoin().onPlayerFirstJoin((Player) sender);

        return true;
    }
}
