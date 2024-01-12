package org.ex1de.salmon;

import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;
import org.ex1de.salmon.command.FishingStatsCommand;
import org.ex1de.salmon.listener.PlayerFishListener;

public final class Salmon extends JavaPlugin {

    @Override
    public void onEnable() {
        Server server = this.getServer();

        server.getPluginManager().registerEvents(new PlayerFishListener(this), this);

        this.getCommand("fishing_stats").setExecutor(new FishingStatsCommand(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
