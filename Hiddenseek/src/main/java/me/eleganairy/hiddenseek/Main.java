package me.eleganairy.hiddenseek;

import me.eleganairy.hiddenseek.commands.SpawnSheep;
import me.eleganairy.hiddenseek.commands.TeamSelect;
import org.bukkit.command.TabCompleter;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        System.out.println("The Hiddenseek plugin is working");

        //Events
        getServer().getPluginManager().registerEvents(new TeamSelect(), this);

        //Commands
        getCommand("teamsheep").setExecutor(new SpawnSheep());

    }

}


