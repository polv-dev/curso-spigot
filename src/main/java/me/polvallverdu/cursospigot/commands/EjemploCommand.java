package me.polvallverdu.cursospigot.commands;

import me.polvallverdu.cursospigot.CursoSpigot;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;


public class EjemploCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;

        Component[] components = new Component[]{
                Component.text("Hola, soy un holograma :D"),
                Component.text("LÍNEA 2 :)"),
                Component.text("LÍNEA 3 :("),
        };

        Location loc = player.getLocation().clone();

        for (int i = components.length - 1; i >= 0; i--) {
            Component component = components[i];

            ArmorStand as = (ArmorStand) player.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
            as.setInvisible(true);
            as.setInvulnerable(true);
            as.setGravity(false);

            as.setCustomNameVisible(true);
            as.customName(component);

            loc.add(0, 0.5, 0);
        }

        return true;
    }

}
