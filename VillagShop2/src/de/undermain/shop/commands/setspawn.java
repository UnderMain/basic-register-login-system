package de.undermain.shop.commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.undermain.shop.main.Main;
import de.undermain.shop.util.files;

public class setspawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		String Prefix = files.getObject_config.get("Prefix").toString().replaceAll("&", "§");
		String NoPerm = files.getObject_config.get("NoPerm").toString().replaceAll("&", "§");
		String ConsoleMSG = files.getObject_config.get("ConsoleMSG").toString().replaceAll("&", "§");

		Player p = (Player) sender;
		if(sender instanceof Player) {
			if(p.hasPermission("citybuild.setspawn")) {
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
				Main.lm.setSpawn(p.getLocation());
				p.sendMessage(Prefix + "§7You set the spawn!");
			}else {
				p.sendMessage(Prefix + NoPerm);
			}
		}else {
			sender.sendMessage(Prefix + ConsoleMSG);
		}
		
		
		return false;
	}

}
