package de.undermain.commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.undermain.config.Title;
import de.undermain.config.files;
import de.undermain.main.Main;

public class spawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player p = (Player) sender;
		String Prefix = files.getObject_config.get("Prefix").toString().replaceAll("&", "§");
		String toomuch = files.getObject_config.get("TooMuchArgs").toString().replaceAll("&", "§");
		if(sender instanceof Player) {
			if(args.length == 0) {
				p.teleport(Main.lm.getSpawm());
				p.sendMessage(Prefix + "§7Du bist nun am §6Spawn§7!");
				p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
				Title.sendTitle(p, Integer.valueOf(10), Integer.valueOf(40), Integer.valueOf(10), "§bSpawn", "§7Wilkommen am Spawn!");

			}else {
				p.sendMessage(Prefix + toomuch);
			}
		}
		return false;
	}
}
