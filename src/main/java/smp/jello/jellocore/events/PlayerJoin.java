package smp.jello.jellocore.events;

import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import smp.jello.jellocore.JelloCore;
import smp.jello.jellocore.util.Book;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class PlayerJoin implements Listener {
    JelloCore plugin = JelloCore.getInstance();
    NamespacedKey isFirstLogin = new NamespacedKey(plugin, "IS_FIRST_LOGIN");

    private final String WELCOME_JSON_DEFAULT = """
{
    "author": "Server",
    "title": "Welcome",
    "pages": [
        "Welcome\nHow are you?"
    ]
}""";
    private final Path WELCOME_JSON_PATH = Paths.get(plugin.getDataFolder().getPath(), "welcomebook.json");

    public PlayerJoin() {
        if (Files.exists(WELCOME_JSON_PATH)) return;
        try {
            Files.write(WELCOME_JSON_PATH, WELCOME_JSON_DEFAULT.getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        PersistentDataContainer playerData = player.getPersistentDataContainer();
        if (playerData.getOrDefault(isFirstLogin, PersistentDataType.INTEGER, 0) == 0) {
            playerData.set(isFirstLogin, PersistentDataType.INTEGER, 1);
            event.setJoinMessage(ChatColor.BOLD.toString() + ChatColor.DARK_GREEN + "[Jello SMP] " + ChatColor.RESET + ChatColor.WHITE + "Welcome, " + player.getName() + " for their first time!");
        }
        onPlayerFirstJoin(player);
    }

    public void onPlayerFirstJoin(Player player) {
        Book.openBook(player, Book.bookFromJSON(WELCOME_JSON_PATH));
    }
}
