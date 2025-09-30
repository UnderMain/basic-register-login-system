package de.sciencecode.cbsystem.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.sciencecode.cbsystem.main.Main;
import de.sciencecode.cbsystem.utils.Manager;

public class OnlineTime implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player)sender;
		
		if (args.length == 0) {
	        int hours = Manager.cfg5.getInt(p.getName() + ".hours");
	        int minutes = Manager.cfg5.getInt(p.getName() + ".minutes");
	        int seconds = Manager.cfg5.getInt(p.getName() + ".seconds");
			p.sendMessage(Main.getPrefix() + "§aDeine Onlinezeit: §e" + hours + " Stunde(n), " + minutes + " Minute(n), " + seconds + " Sekunde(n)");
		}
		if (args.length == 1) {
			OfflinePlayer target = Bukkit.getOfflinePlayer(args[0]);
			
	        int hours = Manager.cfg5.getInt(target.getName() + ".hours");
	        int minutes = Manager.cfg5.getInt(target.getName() + ".minutes");
	        int seconds = Manager.cfg5.getInt(target.getName() + ".seconds");
			p.sendMessage(Main.getPrefix() + "§aSeine Onlinezeit: §e" + hours + " Stunde(n), " + minutes + " Minute(n), " + seconds + " Sekunde(n)");
		}
		
		return false;
	}

}
