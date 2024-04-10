package me.polvallverdu.cursospigot.commands;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;


public class EjemploCommand implements CommandExecutor {

    private BossBar bossBar;

    public EjemploCommand() {
        bossBar = Bukkit.createBossBar("Visita polv.dev", BarColor.WHITE, BarStyle.SOLID);
        bossBar.setVisible(true);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            bossBar.addPlayer(player);
        }

        return true;
    }

}
