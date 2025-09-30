package de.undermain.shop.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.undermain.shop.util.files;
import de.undermain.shop.util.methoden;


public class creative implements  CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player p = (Player) sender;
		String Prefix = files.getObject_config.get("Prefix").toString().replaceAll("&", "§");
		String perm = files.getObject_config.get("NoPerm").toString().replaceAll("&", "§");
		String toomuch = files.getObject_config.get("TooMuchArgs").toString().replaceAll("&", "§");
		String ConsoleMSG = files.getObject_config.get("ConsoleMSG").toString().replaceAll("&", "§");

		if(sender instanceof Player) {
			if(p.hasPermission("citybuild.creative")) {
				
				if(args.length == 0) {
					p.setGameMode(GameMode.CREATIVE);
					methoden.chat(p);
					p.sendMessage(Prefix + "§b§m---------------------------");
					p.sendMessage(Prefix + "");
					p.sendMessage(Prefix + "§7» Du bist nun im Creative Modus!");
					p.sendMessage(Prefix + "");
					p.sendMessage(Prefix + "§b§m---------------------------");
					p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
				}else if(args.length == 1) {
					Player t = Bukkit.getPlayer(args[0]);
					if(t != null) {
						methoden.chat(t);
						t.setGameMode(GameMode.CREATIVE);
						t.sendMessage(Prefix + "§7§m---------------------------");
						t.sendMessage(Prefix + "");
						t.sendMessage(Prefix + "§7» Du bist nun im Creative Modus!");
						t.sendMessage(Prefix + "");
						t.sendMessage(Prefix + "§7§m---------------------------");
						t.playSound(t.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
						p.sendMessage(Prefix + "§7» Du hast  §a" + args[0] + "§7 in Creative gesetzt!");
						p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
					}else {
						p.sendMessage(Prefix + "§7» Der Spieler §a" + args[0] + "§7 ist §coffline!");
					}
					
				}else {
					p.sendMessage(Prefix + toomuch);
					p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
				}
				
			}else {
				p.sendMessage(Prefix + perm);
				p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
			}
		}else {
			sender.sendMessage(Prefix + ConsoleMSG);
		}
		
		return false;
	}

}
