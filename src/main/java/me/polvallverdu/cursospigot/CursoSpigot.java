package me.polvallverdu.cursospigot;

import me.polvallverdu.cursospigot.commands.EjemploCommand;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.plugin.java.JavaPlugin;

public final class CursoSpigot extends JavaPlugin {

    @Override
    public void onEnable() {
        WorldCreator worldCreator = new WorldCreator("curso");
        worldCreator.generateStructures(false);
        World world = Bukkit.createWorld(worldCreator);

        getCommand("ejemplo").setExecutor(new EjemploCommand());

        Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);

        System.out.println("¡El plugin ha sido cargado correctamente!");
    }

    @Override
    public void onDisable() {
        System.out.println("El plugin se ha deshabilitado :(");
    }

}
