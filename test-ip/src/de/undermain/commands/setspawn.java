package de.undermain.commands;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.undermain.config.files;
import de.undermain.config.methoden;
import de.undermain.main.Main;

public class setspawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player p = (Player) sender;
		String Prefix = files.getObject_config.get("Prefix").toString().replaceAll("&", "§");
		String perm = files.getObject_config.get("NoPerm").toString().replaceAll("&", "§");
		String toomuch = files.getObject_config.get("TooMuchArgs").toString().replaceAll("&", "§");
		String consolemsg = files.getObject_config.get("ConsoleMSG").toString().replaceAll("&", "§");

		if(p.hasPermission("ufc.spawn")) {
			if(sender instanceof Player) {
				if(args.length > 0) {
					p.sendMessage(Prefix + toomuch);
					p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);

				}else {
					Location loc = p.getLocation();
					Main.lm.setSpawn(loc);
					methoden.chat(p);
					p.sendMessage(Prefix + "§7§m---------------------------");
					p.sendMessage(Prefix + "");
					p.sendMessage(Prefix + "§7» Du hast den Spawn gesetzt!");
					p.sendMessage(Prefix + "");
					p.sendMessage(Prefix + "§7§m---------------------------");
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);

				}
			}else {
				p.sendMessage(Prefix + consolemsg);
				p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);

			}
		}else {
			p.sendMessage(Prefix + perm);
			p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);

		}
		return false;
	}

}
