package me.polvallverdu.cursospigot.commands;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.UUID;


public class EjemploCommand implements CommandExecutor {

    private HashMap<UUID, Integer> counter = new HashMap<>();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            if (counter.containsKey(player.getUniqueId())) {
                int newCounter = counter.get(player.getUniqueId())+1;
                counter.put(player.getUniqueId(), newCounter);

                player.getScoreboard().getTeam("teamejemplo").suffix(Component.text(newCounter));
            } else {
                Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
                Objective objective = scoreboard.registerNewObjective("board", Criteria.DUMMY, Component.text("TÍTULO"));
                objective.setDisplaySlot(DisplaySlot.SIDEBAR);

                Team team = scoreboard.registerNewTeam("teamejemplo");
                team.addEntry("count");
                team.prefix(Component.text("Contador: "));
                team.suffix(Component.text("0"));

                objective.getScore("count").setScore(3);
                objective.getScore("count").customName(Component.text(""));
                objective.getScore(" ").setScore(2);
                objective.getScore("Web: polv.dev").setScore(1);
                counter.put(player.getUniqueId(), 0);

                player.setScoreboard(scoreboard);
            }
        }

        return true;
    }

}
