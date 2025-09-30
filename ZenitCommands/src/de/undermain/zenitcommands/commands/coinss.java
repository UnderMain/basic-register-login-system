package de.undermain.zenitcommands.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


import cloud.evaped.coinsapi.API.CoinsAPI;
import de.undermain.zenitcommands.main.Main;

public class coinss implements CommandExecutor {

	CoinsAPI api = new CoinsAPI();
	
	@Override
	public boolean onCommand(CommandSender player, Command command, String label, String[] args) {


		
		if(player instanceof Player) {
			
			if(args.length == 0) {
			
				Player p = (Player) player;
				
				de.undermain.base.API.BaseAPI.coins(p);
				
				
			}
			
		}else
			player.sendMessage(Main.prefix + "§7Nur Spieler können dies ausführen.");
		
		
		return false;
	}
	
}
