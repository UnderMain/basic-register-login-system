package me.daniel.Coins;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Coins implements CommandExecutor{
	
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if(!(cs instanceof Player)){
			return false;
		}
		Player p = (Player)cs;
		if(args.length == 0){
			int coins = CoinsAPI.getCoins(p);
			p.sendMessage(Main.pr + "§7Du hast momentan §e" + coins + " §7Coins");
		}else if(args.length == 1){
			if(p.hasPermission("coinsadd")) {
			if(args[0].equalsIgnoreCase("add")){
				p.sendMessage(Main.pr + "§7Nutze§8: §8/§ecoins add §8<§bSpieler§8> §8<§bAnzahl§8>");
			}else if(args[0].equalsIgnoreCase("remove")){
				p.sendMessage(Main.pr + "§7Nutze§8: /§ecoins remove §8<Spieler§8> §8<Anzahl§8>");
			}else if(args[0].equalsIgnoreCase("set")){
				p.sendMessage(Main.pr + "§7Nutze§8: §8/§ecoins set §8<Spieler§8> §8<Anzahl§8>");
			}else{
				String name = args[0];
				if(CoinsAPI.isRegistered(name)){
					int coins = CoinsAPI.getCoins(name);
					p.sendMessage(Main.pr + "§7Der Spieler §b" + name + "§7 hat momentan §b" + coins + " §7Coins");
				}else{
					p.sendMessage(Main.pr + "§cDieser Spieler ist nicht registriert");
				}
			}
			} else {
				p.sendMessage(Main.pr + "§cDu hast für den Befehl keine Rechte§8!");
			}
		}else if(args.length == 2){
			if(p.hasPermission("coinsadd")) {
			if(args[0].equalsIgnoreCase("add")){
				p.sendMessage(Main.pr + "§7Nutze§8: §8/§ecoins add §8<§bSpieler§8> §8<§bAnzahl§8>");
			}else if(args[0].equalsIgnoreCase("remove")){
				p.sendMessage(Main.pr + "§7Nutze§8: /§ecoins remove §8<Spieler§8> §8<Anzahl§8>");
			}else if(args[0].equalsIgnoreCase("set")){
				p.sendMessage(Main.pr + "§7Nutze§8: §8/§ecoins set §8<Spieler§8> §8<Anzahl§8>");
			}else{
				p.sendMessage(Main.pr + "§7Nutze: §8/§ecoins add§8|§eremove§8|§eset §8<§bSpieler§8> §8<§bAnzahl§8>");
			}
			} else {
				p.sendMessage(Main.pr + "§cDu hast für den Befehl keine Rechte§8!");
			}
		}else if(args.length == 3){
			if(p.hasPermission("coinsadd")) {
			if(args[0].equalsIgnoreCase("add")){
				String name = args[1];
				if(CoinsAPI.isRegistered(name)){
					int coins = Integer.valueOf(args[2]);
					CoinsAPI.addCoins(name, coins);
					p.sendMessage(Main.pr + "§7Du hast erfolgreich §b" + name + "§e " + coins + " §7Coins §ahinzugefügt");
				}
			}else {
				p.sendMessage(Main.pr + "§cDu hast für den Befehl keine Rechte§8!");
			}
			
			}else if(args[0].equalsIgnoreCase("remove")){
				if(p.hasPermission("coinsremove")) {
				String name = args[1];
				if(CoinsAPI.isRegistered(name)){
					int coins = Integer.valueOf(args[2]);
					CoinsAPI.removeCoins(name, coins);
					p.sendMessage(Main.pr + "§7Du hast erfolgreich §b" + name + "§e " + coins + " §7Coins §cabgezogen");
				}
				}else {
					p.sendMessage(Main.pr + "§cDu hast für den Befehl keine Rechte§8!");
				}
				
			}else if(args[0].equalsIgnoreCase("set")){
				String name = args[1];
				if(CoinsAPI.isRegistered(name)){
					int coins = Integer.valueOf(args[2]);
					CoinsAPI.setCoins(name, coins);
					p.sendMessage(Main.pr + "§7Du hast erfolgreich die Coins von §b" + name + "§7 auf §e" + coins + " §7Coins §agesetzt");
				}
			}else{
				p.sendMessage(Main.pr + "§7Nutze: §8/§ecoins add§8|§eremove§8|§eset §8<§bSpieler§8> §8<§bAnzahl§8>");
			}
		}
		return true;
	}

}
