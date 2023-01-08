package smp.jello.jellocore.util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Book {
    /**
     * Opens a book for a player
     *
     * @param player The player to open the book for
     * @param book The book that will be opened
     */
    public static void openBook(Player player, ItemStack book) {
        player.openBook(book);
    }

    /**
     * Opens a book for all players
     *
     * @param book The book that will be opened
     */
    public static void openBookAll(ItemStack book) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            openBook(player, book);
        }
    }
}
