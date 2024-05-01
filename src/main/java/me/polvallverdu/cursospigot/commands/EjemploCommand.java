package me.polvallverdu.cursospigot.commands;

import me.polvallverdu.cursospigot.CursoSpigot;
import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;


public class EjemploCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        sender.sendMessage(Component.text(CursoSpigot.getInstance().getConfig().getInt("numero_de_la_suerte")));

        return true;
    }

}
