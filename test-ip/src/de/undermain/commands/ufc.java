package de.undermain.commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.undermain.config.files;
import de.undermain.config.methoden;

public class ufc implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player p = (Player) sender;
		String ukcMSG = files.getObject_config.get("UKC").toString().replaceAll("&", "§").replaceAll("%cmd%", "/ufc");
		String Prefix = files.getObject_config.get("Prefix").toString().replaceAll("&", "§");
		if(p.hasPermission("ufc.info") || p.isOp()) {
			if(sender instanceof Player) {
				methoden.chat(p);
				p.sendMessage("§7§m---------------------------");
				p.sendMessage("§b§lUFC - utilities for citybuild");
				p.sendMessage("§7- §a/setspawn /spawn");
				p.sendMessage("§7- §a/c /s (Gamemodes)");
				p.sendMessage("§7- §a/heal /feed");
				p.sendMessage("§7- §a/item <name/enchant/infdurability>");
				p.sendMessage("§7- §a/sign");
				p.sendMessage("§7- §a/cc (Clearchat)");
				p.sendMessage("§7- §a/lizenzinfo");
				p.sendMessage("§7§m---------------------------");
				p.playSound(p.getLocation(), Sound.ENDERDRAGON_GROWL, 1.0F, 1.0F);

			}
		}else {
			p.sendMessage(Prefix + ukcMSG);
			p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);

		}
		
		
		return false;
	}

}
