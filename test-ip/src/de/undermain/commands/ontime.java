package de.undermain.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.undermain.config.files;
import de.undermain.config.methoden;
import de.undermain.mysql.qryss;

public class ontime implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player p = (Player) sender;
		String Prefix = files.getObject_config.get("Prefix").toString().replaceAll("&", "§");
		String toomuch = files.getObject_config.get("TooMuchArgs").toString().replaceAll("&", "§");
		if(sender instanceof Player)  {
			if(args.length == 0) {
				int ontime = qryss.ontime(p.getName());
				String m = "§7 Minuten";
				if(ontime == 1) {
					m = "§7 Minute";
				}

				
				methoden.chat(p);
				p.sendMessage(Prefix + "§7§m---------------------------");
				p.sendMessage(Prefix + "§7Hallo §b" + p.getName() + ",");
				p.sendMessage(Prefix + "§7deine Ontime beträgt:");
				p.sendMessage(Prefix + "§7» §a"+ ontime + m);
				p.sendMessage(Prefix + "§7§m---------------------------");
			}else {
				p.sendMessage(Prefix+toomuch);
			}
		}
		
		
		return false;
	}

}
