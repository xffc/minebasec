package fun.xffc;

import fun.xffc.worlds.World;
import fun.xffc.worlds.WorldManager;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

public class Main extends JavaPlugin {
    public static Logger logger;

    @Override
    public void onEnable() {
        logger = this.getLogger();

        WorldManager worldManager = new WorldManager();
        World debugWorld = worldManager.loadWorld(UUID.randomUUID());

        this.getCommand("join").setExecutor((commandSender, command, label, args) -> {
            if (args.length < 1) {
                commandSender.sendMessage(Component.text("not enough args. /join uuid"));
                return true;
            }

            if (!(commandSender instanceof Player player)) {
                return false;
            }

            player.teleport(debugWorld.getWorld().getSpawnLocation());
            return true;
        });
        this.getCommand("join").setTabCompleter(new TabCompleter() {
            @Override
            public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
                if (args.length == 1) {
                    return worldManager
                            .getLoadedWorlds()
                            .stream()
                            .map(i -> i.getWorld().getName())
                            .toList();
                }

                return null;
            }
        });
        
        this.getCommand("spawn").setExecutor((commandSender, command, label, args) -> {
            if (!(commandSender instanceof Player player)) {
                return false;
            }

            player.teleport(Bukkit.getWorld("world").getSpawnLocation());
            return true;
        });
    }
}