package de.undermain.shop.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.undermain.shop.util.CoinsAPI;
import de.undermain.shop.util.files;



public class coins implements CommandExecutor {

	public static boolean isNumeric(String str) { 
		  try {  
		    Integer.parseInt(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		String Prefix = files.getObject_config.get("Prefix").toString().replaceAll("&", "§");
		String toomuch = files.getObject_config.get("TooMuchArgs").toString().replaceAll("&", "§");
		String einheit = files.getObject_config.get("Einheit").toString();
		int coins = CoinsAPI.getCoins(p);
		if(sender instanceof Player) {
			if(p.hasPermission("coins.all")) {
				if(args.length == 0) {
					p.sendMessage(Prefix  + "§7§m----------------------");
					p.sendMessage(Prefix  + "§7");
					p.sendMessage(Prefix  + "§a§lCoins-Syntax:");
					p.sendMessage(Prefix  + "§7");
					p.sendMessage(Prefix  + "§7/coins - §aDeine Coins");
					p.sendMessage(Prefix  + "§7/coins add <zahl> <name> - §aCoins hinzufügen");
					p.sendMessage(Prefix  + "§7/coins remove <zahl> <name> - §aCoins entfernen");
					p.sendMessage(Prefix  + "§7/coins set <zahl> <name> - §aCoins setzten");
					p.sendMessage(Prefix + "§7 Du hast §a§l" + coins + " " + einheit);
					p.sendMessage(Prefix  + "§7§m----------------------");

				}else if(args[0].equalsIgnoreCase("add")) {
					if(args.length < 3) {
						p.sendMessage(Prefix + "§cZu wenige Argumente");
					}else {
						String chatcoins = args[1];
						Player target = Bukkit.getPlayer(args[2]);
						
						if(target != null) {
							if(!isNumeric(chatcoins)) {
								p.sendMessage(Prefix + "§cArgument 2 muss eine Zahl sein!");
							}else {
								CoinsAPI.addCoins(target, Integer.valueOf(chatcoins));
								p.sendMessage(Prefix + "§7Du hast §a§l" + target.getName() + " §b" + chatcoins + " "  + einheit + "§7 hinzugefügt!");
								int targetcoins = CoinsAPI.getCoins(target);
								p.sendMessage(Prefix + "§7» §a§l" + target.getName() + "§7 hat jetzt §b" + targetcoins + " " + einheit);
								p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
							}
						}else {
							p.sendMessage(Prefix + "§cDer Spieler §a" + args[2] + "§c ist offline!");
						}
					}
				}else if(args[0].equalsIgnoreCase("remove")) {
					if(args.length < 3) {
						p.sendMessage(Prefix + "§cZu wenige Argumente");
					}else {
						String chatcoins = args[1];
						Player target = Bukkit.getPlayer(args[2]);
						if(target != null) {
							if(isNumeric(chatcoins)) {
								int removedCoins = CoinsAPI.removeCoins(target, Integer.valueOf(chatcoins));
								if(removedCoins == 0) {
									p.sendMessage(Prefix + "§7Du hast §a§l" + target.getName() + " §b" + chatcoins + " " + einheit  + "§7 entfernt!");
									int targetcoins = CoinsAPI.getCoins(target);
									p.sendMessage(Prefix + "§7» §a§l" + target.getName() + "§7 hat jetzt §b" + targetcoins + " "  + einheit);
								}else {
									p.sendMessage(Prefix + "§a§l" + target.getName() + " §7 hat zu wenig " + einheit);
								}
							}else {
								p.sendMessage(Prefix + "§cArgument 2 muss eine Zahl sein!");
							}
						}else {
							p.sendMessage(Prefix + "§cDer Spieler §a" + args[2] + "§c ist offline!");
						}
					}
				}else if(args[0].equalsIgnoreCase("set")) {
					if(args.length < 3) {
						p.sendMessage(Prefix + "§cZu wenige Argumente");
					}else {
						String chatcoins = args[1];
						Player target = Bukkit.getPlayer(args[2]);
						if(target != null) {
							if(isNumeric(chatcoins)) {
								CoinsAPI.setCoins(target, Integer.valueOf(chatcoins));
								p.sendMessage(Prefix + "§7Du hast §a§l" + target.getName() + " §b" + chatcoins + " "  + einheit + "§7 gesetzt!");
								int targetcoins = CoinsAPI.getCoins(target);
								p.sendMessage(Prefix + "§7» §a§l" + target.getName() + "§7 hat jetzt §b" + targetcoins + " " + einheit );

							}else {
								p.sendMessage(Prefix + "§cArgument 2 muss eine Zahl sein!");
							}
						}else {
							p.sendMessage(Prefix + "§cDer Spieler §a" + args[2] + "§c ist offline!");
						}
					}
				}else {
					p.sendMessage(Prefix + toomuch);
				}
				
			}else {
				p.sendMessage(Prefix + "§7Du hast §a§l" + coins + " "  + einheit);
			}
		}
		
		
		return false;
	}

}

