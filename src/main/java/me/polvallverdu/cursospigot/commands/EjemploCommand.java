package me.polvallverdu.cursospigot.commands;

import me.polvallverdu.cursospigot.CursoSpigot;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;


public class EjemploCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        long ticksTotales = 5*20;

        for (int i = 5; i > 0; i--) {
            int numero = i;

            Bukkit.getScheduler().runTaskLater(CursoSpigot.getInstance(), () -> {
                Bukkit.broadcast(Component.text("Cuenta atras: " + numero));
            }, ticksTotales - (i*20L));
        }

        return true;
    }

}
