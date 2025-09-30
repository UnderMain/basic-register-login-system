package de.undermain.base.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.undermain.base.files.files;
import de.undermain.base.mysql.qryss;
import de.undermain.base.utils.CoinsAPI;

public class stats implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player p = (Player) sender;
		
		String Prefix = files.getObject_config.get("Prefix").toString().replaceAll("&", "§");

		int kills = qryss.kills(p.getName());
		int deaths = qryss.deaths(p.getName());
		int blocksB = qryss.blocksBreaked(p.getName());
		int blocksP = qryss.blocksPlaced(p.getName());
		int ontime = qryss.ontime(p.getName());
		int coins = CoinsAPI.coins(p);
		
		if(sender instanceof Player) {
			p.sendMessage(Prefix + "§a§m---------------------------------------------");
			p.sendMessage(Prefix + "§7Stats von§e " + p.getName());
			p.sendMessage(Prefix + "§7Ontime: §e§l" + ontime);
			p.sendMessage(Prefix + "§7Coins: §e§l" + coins);
			p.sendMessage(Prefix + "§7Kills: §e§l" + kills);
			p.sendMessage(Prefix + "§7Deaths: §e§l" + deaths);
			p.sendMessage(Prefix + "§7Blocks Placed: §e§l" + blocksP);
			p.sendMessage(Prefix + "§7Blocks Breaked: §e§l" + blocksB);
			p.sendMessage(Prefix + "§a§m---------------------------------------------");

		}
		
		return false;
	}
	

}
