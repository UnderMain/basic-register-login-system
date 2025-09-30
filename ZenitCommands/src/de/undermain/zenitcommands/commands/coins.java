package de.undermain.zenitcommands.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.entity.Player;


import de.undermain.zenitcommands.main.Main;

public class coins implements CommandExecutor {
	

	
	@Override
	public boolean onCommand(CommandSender player, Command command, String label, String[] args) {


		
		if(player instanceof Player) {
			
			if(args.length == 0) {
			
				player.sendMessage(Main.prefix + "Du hast 1000 Coins dazu bekommen!");
				
			}
			
		}else
			player.sendMessage(Main.prefix + "§7Nur Spieler können dies ausführen.");
		
		
		return false;
	}

}
