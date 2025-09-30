package de.undermain.cb.commands;

import java.io.File;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import de.undermain.cb.main.Main;
import de.undermain.cb.utils.Manager;



public class Home implements CommandExecutor {
	public static File file = new File("plugins/CB-System/homes.yml");
	public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player)sender;
		
		if (args.length == 0) {
			p.sendMessage(Main.getPrefix() + "§cSyntax: /home [Name]");
			return true;
		}
			if (Manager.ifHomeExist(p, args[0])) {
				p.sendMessage(Main.getPrefix() + "§aDu bist nun bei deinen Home §e" + args[0] + "§a.");

				Location loc = Manager.getHome(p, args[0]);
				p.teleport(loc);
			} else {
				p.sendMessage(Main.getPrefix() + "§cDein Home §e" + args[0] + " §cexistiert nicht.");
			}
		return false;
	}
}
