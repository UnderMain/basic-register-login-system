package de.undermain.cb.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.undermain.cb.main.Main;
import de.undermain.cb.utils.Manager;



public class Spawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		Player p = (Player) sender;
		
        if (Manager.cfg.getString("Spawn") != null) {

            p.sendMessage(Main.getPrefix() + "§aDu bist nun beim §eSpawn§a."); 
            p.teleport(Manager.getConfigLocation("Spawn", Manager.cfg));
		
        } else {
            p.sendMessage(Main.getPrefix() + "§cEs besteht noch kein Spawn!");

        }
		return false;

	}

}
