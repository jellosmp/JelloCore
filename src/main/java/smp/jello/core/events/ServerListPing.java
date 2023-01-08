package smp.jello.core.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class ServerListPing implements Listener {
    @EventHandler
    public void onServerPing(ServerListPingEvent event) {
        event.setMotd("                   \\u00A7l\\u00A70✠\\u00A7aJello \\u00A72SMP\\u00A70✠\\u00A7r\\n                \\u00A7o\\u00A7nReleasing Soon...");
    }
}
