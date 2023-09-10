package com.probattler.random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class ReloadConfigCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (player.isOp()) {
                Random.getPlugin(Random.class).reloadConfig();
                String a = Random.getPlugin(Random.class).getConfig().getString("RandomizeDrops");
                assert a != null;
                if (a.equalsIgnoreCase("true")) {
                    player.sendMessage(ChatColor.YELLOW + "Successfully Reloaded Config!");
                    player.sendMessage(ChatColor.YELLOW + "Drop Randomization is set to " + ChatColor.GREEN + a + "!");
                } else if (a.equalsIgnoreCase("false")) {
                    player.sendMessage(ChatColor.YELLOW + "Successfully Reloaded Config!");
                    player.sendMessage(ChatColor.YELLOW + "Drop Randomization is set to " + ChatColor.RED + a + "!");
                }
            } else {
                player.sendMessage(ChatColor.RED + "You need to be an operator to use this command!");
            }
        } else if (commandSender instanceof ConsoleCommandSender) {
            Random.getPlugin(Random.class).reloadConfig();
            String a = Random.getPlugin(Random.class).getConfig().getString("RandomizeDrops");
            assert a != null;
            if (a.equalsIgnoreCase("true")) {
                Bukkit.getLogger().info(ChatColor.YELLOW + "Successfully Reloaded Config!");
                Bukkit.getLogger().info(ChatColor.YELLOW + "Drop Randomization is set to " + ChatColor.GREEN + a + "!");
            } else if (a.equalsIgnoreCase("false")) {
                Bukkit.getLogger().info(ChatColor.YELLOW + "Successfully Reloaded Config!");
                Bukkit.getLogger().info(ChatColor.YELLOW + "Drop Randomization is set to " + ChatColor.RED + a + "!");
            }
        }
        return false;
    }
}
