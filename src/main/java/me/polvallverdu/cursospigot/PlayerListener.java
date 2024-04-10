package me.polvallverdu.cursospigot;

import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (event.hasItem() && event.getItem().getType() == Material.DIAMOND_HOE) {
            Arrow arrow = player.launchProjectile(Arrow.class);

            arrow.setDamage(4D);
        }
    }

}
