package me.polvallverdu.cursospigot.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;


public class EjemploCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            ItemStack espada = new ItemStack(Material.DIAMOND_SWORD);
            espada.addEnchantment(Enchantment.DAMAGE_ALL, 3);

            Inventory inventory = player.getInventory();
            inventory.clear();
            inventory.addItem(espada);
        }

        return true;
    }

}
