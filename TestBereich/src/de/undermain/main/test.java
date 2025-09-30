package de.undermain.main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import cloud.evaped.coinsapi.API.CoinsAPI;


public class test implements CommandExecutor {
	

	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		CoinsAPI api = new CoinsAPI();
		Player p = (Player)sender;
		
		if(p instanceof Player) {
			
			if(args.length == 0) {
				
				int coins = api.getCoins(p);
				
				p.sendMessage("Du hast 1000 Coins dazu bekommen!");
				
			}
			
		}else
			p.sendMessage("§7Nur Spieler können dies ausführen.");
		
		
		return false;
	}

}
