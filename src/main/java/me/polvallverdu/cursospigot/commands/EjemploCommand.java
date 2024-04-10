package me.polvallverdu.cursospigot.commands;

import com.destroystokyo.paper.profile.PlayerProfile;
import com.destroystokyo.paper.profile.ProfileProperty;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class EjemploCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        ItemStack fuegoArtificial = new ItemStack(Material.FIREWORK_ROCKET);
        FireworkMeta meta = (FireworkMeta) fuegoArtificial.getItemMeta();

        meta.addEffect(
                FireworkEffect.builder()
                        .trail(true)
                        .withColor(Color.GREEN)
                        .with(FireworkEffect.Type.CREEPER)
                        .build()
        );

        fuegoArtificial.setItemMeta(meta);

        if (sender instanceof Player player) {
            player.getInventory().addItem(fuegoArtificial);
        }

        return true;
    }

}
