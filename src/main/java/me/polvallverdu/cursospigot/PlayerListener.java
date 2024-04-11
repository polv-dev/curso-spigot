package me.polvallverdu.cursospigot;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PlayerListener implements Listener {

    public static List<UUID> openedMenu = new ArrayList<>();

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!openedMenu.contains(event.getWhoClicked().getUniqueId())) {
            return;
        }

        event.setCancelled(true);

        ItemStack item = event.getCurrentItem();

        if (item == null || item.getType() == Material.AIR) {
            return;
        }

        Player player = (Player) event.getWhoClicked();

        switch (item.getType()) {
            case IRON_INGOT -> {
                player.getInventory().addItem(new ItemStack(Material.IRON_INGOT));
                player.closeInventory();
            }
            case GOLD_INGOT -> {
                player.getInventory().addItem(new ItemStack(Material.GOLD_INGOT));
                player.closeInventory();
            }
            case DIAMOND -> {
                player.getInventory().addItem(new ItemStack(Material.DIAMOND));
                player.closeInventory();
            }
            default -> {
                player.playSound(player, Sound.ENTITY_VILLAGER_NO, 10f, 1f);
            }
        }
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        openedMenu.remove(event.getPlayer().getUniqueId());
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        openedMenu.remove(event.getPlayer().getUniqueId());
    }

}
