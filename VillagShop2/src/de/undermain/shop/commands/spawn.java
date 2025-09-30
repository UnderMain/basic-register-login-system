package de.undermain.shop.commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class spawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player p = (Player) sender;
		
		if(sender instanceof Player) {
			if(p.hasPermission("citybuild.spawn")) {
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);

			}
		}

		return false;
	}

}
