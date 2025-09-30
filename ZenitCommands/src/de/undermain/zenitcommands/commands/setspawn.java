package de.undermain.zenitcommands.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.undermain.zenitcommands.main.Main;

public class setspawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
 
		Player p = (Player)sender;
		Location loc = p.getLocation();
		
		if(p.isOp()) {
			
			Main.lm.setSpawn(loc);
			p.sendMessage(Main.prefix + "§3Du hast den Spawn gesetzt!");
			
		}else {
			 p.sendMessage(Main.noperm);
		}

		
		
		return false;
	}

}
