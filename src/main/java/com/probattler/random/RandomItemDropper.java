package com.probattler.random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class RandomItemDropper implements Listener {
    public RandomItemDropper(Random plugin){
        Bukkit.getPluginManager().registerEvents(this,plugin);
    }

    @EventHandler
    public void onMine(BlockBreakEvent event) {
        String choice = Random.getPlugin(Random.class).getConfig().getString("RandomizeDrops");
        List<ItemStack> items = new ArrayList<>();
        assert choice != null;
        if (choice.equalsIgnoreCase("true")) {
            for (Material material : Material.values()) {
                items.add(new ItemStack(material));
            }
            java.util.Random random = new java.util.Random();
            int randomno = random.nextInt(items.size());
            ItemStack randomitem = items.get(randomno);
            event.setDropItems(false);
            event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), randomitem);
        }
    }
}
