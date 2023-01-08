package smp.jello.jellocore.util;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

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

    /**
     * Creates a book from data contained in the JSON String
     *
     * @param jsonString The JSON as a string
     * @return The ItemStack containing the Book
     */
    public static ItemStack bookFromJSON(String jsonString) {
        ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
        BookMeta bookMeta = (BookMeta) book.getItemMeta();

        JSONObject json;

        try {
            json = new JSONObject(jsonString);
        } catch (JSONException e) {
            bookMeta.setAuthor("Error");
            bookMeta.setTitle("Error");
            bookMeta.addPage("Error: Failed to load from JSON\nJSONException");
            book.setItemMeta(bookMeta);
            return book;
        }

        bookMeta.setAuthor(json.getString("author"));
        bookMeta.setTitle(json.getString("title"));

        json.getJSONArray("pages").iterator().forEachRemaining(page -> {
            bookMeta.addPage((String) page);
        });

        book.setItemMeta(bookMeta);
        return book;
    }

    /**
     * Reads the JSON file then creates a book from the data in that JSON file
     *
     * @param jsonPath Path to a file containing JSON
     * @return The ItemStack containing the Book
     */
    public static ItemStack bookFromJSON(Path jsonPath) {
        try {
            return bookFromJSON(Files.readString(jsonPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
