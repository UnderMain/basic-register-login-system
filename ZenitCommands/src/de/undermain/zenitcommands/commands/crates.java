package de.undermain.zenitcommands.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.undermain.zenitcommands.main.Main;


public class crates implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


		
		if(sender instanceof Player) {
			
			if(args.length == 0) {
				
				sender.sendMessage(Main.prefix + "�7Du �ffnest die Crates Hilfe..");
			}
			
		}else
			sender.sendMessage(Main.prefix + "�7Nur Spieler k�nnen dies ausf�hren.");
		
		
		return false;
	}

}
