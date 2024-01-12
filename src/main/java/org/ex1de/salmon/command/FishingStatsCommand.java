package org.ex1de.salmon.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FishingStatsCommand implements CommandExecutor, TabCompleter {
    private final JavaPlugin plugin;

    public FishingStatsCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(
            @NotNull CommandSender sender,
            @NotNull Command command,
            @NotNull String label,
            @NotNull String[] args
    ) {
        return true;
    }

    @Override
    @NotNull
    public List<String> onTabComplete(
            @NotNull CommandSender sender,
            @NotNull Command command,
            @NotNull String label,
            @NotNull String[] args
    ) {
        if (args.length == 1) {
            List<Player> players = new ArrayList<>(
                    plugin.getServer().getOnlinePlayers()
            );

            return players.stream()
                    .map(Player::getName)
                    .filter(name ->
                            name.startsWith(args[CommandArgs.Nickname])
                    )
                    .collect(Collectors.toList());
        }

        return new ArrayList<>();
    }

    private static final class CommandArgs {
        public static int Nickname = 0;
    }
}
