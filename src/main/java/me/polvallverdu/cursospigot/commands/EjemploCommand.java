package me.polvallverdu.cursospigot.commands;

import me.polvallverdu.cursospigot.PlayerListener;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.List;


public class EjemploCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) return true;

        Inventory inventory = Bukkit.createInventory(null, 54, Component.text("Menú"));

        // Item de hierro
        ItemStack hierro = new ItemStack(Material.IRON_INGOT);
        ItemMeta ironMeta = hierro.getItemMeta();

        ironMeta.displayName(Component.text("Hierro").color(NamedTextColor.GRAY));
        ironMeta.lore(
                List.of(
                        Component.text("Esto en un lingote").color(NamedTextColor.RED),
                        Component.text("de hierro").color(NamedTextColor.RED)
                )
        );
        hierro.setItemMeta(ironMeta);

        // Item de oro
        ItemStack oro = new ItemStack(Material.GOLD_INGOT);
        ItemMeta goldMeta = oro.getItemMeta();

        goldMeta.displayName(Component.text("Oro").color(NamedTextColor.GOLD));
        goldMeta.lore(
                List.of(
                        Component.text("Esto en un lingote").color(NamedTextColor.RED),
                        Component.text("de oro").color(NamedTextColor.RED)
                )
        );
        oro.setItemMeta(goldMeta);

        // Item de diamante
        ItemStack diamante = new ItemStack(Material.DIAMOND);
        ItemMeta diamondMeta = diamante.getItemMeta();

        diamondMeta.displayName(Component.text("Diamante").color(NamedTextColor.BLUE));
        diamondMeta.lore(
                List.of(
                        Component.text("Esto en un diamante").color(NamedTextColor.RED)
                )
        );
        diamante.setItemMeta(diamondMeta);

        inventory.setItem(11, hierro);
        inventory.setItem(13, oro);
        inventory.setItem(15, diamante);

        PlayerListener.openedMenu.add(player.getUniqueId());
        player.openInventory(inventory);

        return true;
    }

}
