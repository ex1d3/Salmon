package org.ex1de.salmon.listener;

import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerFishListener implements Listener {
    private final JavaPlugin plugin;

    public PlayerFishListener(final JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerFishHandler(PlayerFishEvent e) {
        Entity entity = e.getCaught();

        if (entity == null) {
            return;
        }

        String playerName = e.getPlayer().getName();
        String fishedItemName = entity.getName();

        plugin.getLogger().info(String.format("%s fished a %s", playerName, fishedItemName));
    }
}
