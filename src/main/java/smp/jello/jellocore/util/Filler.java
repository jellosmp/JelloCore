package smp.jello.jellocore.util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Filler {
    public static String fillString(String string, Player player) {
        return string
                .replaceAll(":playername:", player.getName());
    }

    public static String fillString(String string) {
        return string
                .replaceAll(":playercount:", String.valueOf(Bukkit.getServer().getOnlinePlayers().size()));
    }
}
