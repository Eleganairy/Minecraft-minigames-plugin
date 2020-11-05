package me.eleganairy.hiddenseek.commands;

import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;

import java.util.List;

public class SpawnSheep implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (args.length > 0) {
                if (args[0].equalsIgnoreCase("all")) {
                    Sheep sheep0 = (Sheep) p.getWorld().spawnEntity(p.getLocation(), EntityType.SHEEP);
                    Sheep sheep1 = (Sheep) p.getWorld().spawnEntity(p.getLocation(), EntityType.SHEEP);

                    sheep0.setCustomName(ChatColor.BLUE + "Team Blue");
                    sheep0.setCustomNameVisible(true);
                    sheep0.setColor(DyeColor.BLUE);

                    sheep1.setCustomName(ChatColor.GREEN + "Team Green");
                    sheep1.setCustomNameVisible(true);
                    sheep1.setColor(DyeColor.GREEN);

                    p.sendMessage("Spawned Blue and Green team selector");
                }
            } else {
                p.sendMessage(ChatColor.RED + "Please select a team");
            }
        }

        return false;
    }

}
