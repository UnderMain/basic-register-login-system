package de.undermain.coins.main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class coins implements CommandExecutor{

	/**
	 *
	 */
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(sender instanceof Player) {
			Player p = (Player) sender;
			int coins = de.undermain.base.utils.CoinsAPI.getCoins(p);
			p.sendMessage("Du hast " + coins + " Coins!");
 		}
		
		return false;
	}
	

}
