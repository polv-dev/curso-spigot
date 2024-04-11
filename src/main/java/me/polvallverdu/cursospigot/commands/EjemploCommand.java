package me.polvallverdu.cursospigot.commands;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketContainer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;


public class EjemploCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) return true;

        PacketContainer packetContainer = new PacketContainer(PacketType.Play.Server.ANIMATION);

        packetContainer.getIntegers().write(0, player.getEntityId());
        packetContainer.getIntegers().write(1, 0);

        ProtocolLibrary.getProtocolManager().sendServerPacket(player, packetContainer);

        return true;
    }

}
