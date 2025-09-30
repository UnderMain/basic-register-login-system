package de.undermain.shop.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.undermain.shop.util.files;


public class chatclear implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player p = (Player) sender;
		String Prefix = files.getObject_config.get("Prefix").toString().replaceAll("&", "§");
		String perm = files.getObject_config.get("NoPerm").toString().replaceAll("&", "§");
		String toomuch = files.getObject_config.get("TooMuchArgs").toString().replaceAll("&", "§");
		if(p.hasPermission("ufc.chatclear")) {
			
			if(args.length == 0) {
				
				for(int i = 0; i<150; i++) {
					Bukkit.broadcastMessage("");
				}
				Bukkit.broadcastMessage(Prefix +"§b§m--------------------------------------");
				Bukkit.broadcastMessage(Prefix +"");
				Bukkit.broadcastMessage(Prefix +"§7Chat wurde von §a" + p.getName() + "§7 geleert!");
				Bukkit.broadcastMessage(Prefix +"");
				Bukkit.broadcastMessage(Prefix +"§b§m--------------------------------------");
				p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);


			}else {
				p.sendMessage(Prefix + toomuch);
				p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
			}
			
		}else {
			p.sendMessage(Prefix + perm);
			p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
		}
		
		
		return false;
	}

}
