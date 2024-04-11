package me.polvallverdu.cursospigot.commands;

import me.polvallverdu.cursospigot.CursoSpigot;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;


public class EjemploCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            World world = player.getWorld();

            for (int i = 0; i < 10; i++) {
                Location loc = player.getLocation().clone().add(0, i, 0);

                Bukkit.getScheduler().runTaskLater(CursoSpigot.getInstance(), () -> {
                    world.spawnParticle(Particle.FLAME, loc, 5);
                }, i*2L);
            }
        }

        return true;
    }

}
