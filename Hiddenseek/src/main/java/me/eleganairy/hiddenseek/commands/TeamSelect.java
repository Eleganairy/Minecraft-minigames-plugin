package me.eleganairy.hiddenseek.commands;

import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerShearEntityEvent;

import java.util.ArrayList;

public class TeamSelect implements Listener {

    private ArrayList<String> partyMembersBlue = new ArrayList<>();
    private ArrayList<String> partyMembersGreen = new ArrayList<>();
    private String blueMembersMessage = ChatColor.DARK_BLUE + "Party joined together with: %s";
    private String greenMembersMessage = ChatColor.DARK_GREEN + "Party joined together with: %s";

    @EventHandler
    public void onShearSheep(PlayerShearEntityEvent e) {

        Player p = e.getPlayer();
        String pName = p.getDisplayName();

        Sheep sheep = (Sheep) e.getEntity();
        DyeColor color = sheep.getColor();

        if (color.name() == "BLUE") {
            e.setCancelled(true);

            if (!partyMembersBlue.contains(pName)) {
                p.getScoreboardTags().clear();
                p.addScoreboardTag(ChatColor.BLUE + "Team Blue");

                partyMembersBlue.add(pName);
                partyMembersGreen.remove(pName);
                p.sendMessage(String.format(blueMembersMessage, partyMembersBlue));
            } else {
                p.sendMessage(ChatColor.RED + "You're already in this party");
            }
        }
        if (color.name() == "GREEN") {
            e.setCancelled(true);

            if (!partyMembersGreen.contains(pName)) {
                p.getScoreboardTags().clear();
                p.addScoreboardTag(ChatColor.GREEN + "Team Green");

                partyMembersGreen.add(pName);
                partyMembersBlue.remove(pName);
                p.sendMessage(String.format(greenMembersMessage, partyMembersGreen));
            } else {
                p.sendMessage(ChatColor.RED + "You're already in this party");
            }
        }

    }

}
