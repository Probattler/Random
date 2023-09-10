package com.probattler.random;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Random extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        new RandomItemDropper(this);
        Objects.requireNonNull(Bukkit.getPluginCommand("randomreload")).setExecutor(new ReloadConfigCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
