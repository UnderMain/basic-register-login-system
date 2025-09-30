package de.undermain.shop.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.undermain.shop.util.files;


public class heal implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player) sender;
		String Prefix = files.getObject_config.get("Prefix").toString().replaceAll("&", "§");
		String perm = files.getObject_config.get("NoPerm").toString().replaceAll("&", "§");
		String toomuch = files.getObject_config.get("TooMuchArgs").toString().replaceAll("&", "§");
		
		if(p.hasPermission("ufc.heal")) {
			
			if(args.length == 0) {
				
				p.setHealth(20);
				p.sendMessage(Prefix +"§b§m--------------------------------------");
				p.sendMessage(Prefix +"");
				p.sendMessage(Prefix +"§7Du hast dich §ageheilt");
				p.sendMessage(Prefix +"");
				p.sendMessage(Prefix +"§b§m--------------------------------------");
				p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);

				
			}else if(args[0].equals("all")) {
			
				for(Player on : Bukkit.getOnlinePlayers()) {
					on.setHealth(20);
					on.sendMessage(Prefix + "§7Du wurdest von §a" + p.getName() + "§7 geheilt!");
					on.playSound(on.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);

				}

				
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
