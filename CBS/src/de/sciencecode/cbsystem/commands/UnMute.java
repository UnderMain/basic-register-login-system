package de.sciencecode.cbsystem.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import de.sciencecode.cbsystem.main.Main;
import de.sciencecode.cbsystem.utils.Manager;

public class UnMute implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (sender.hasPermission("cbsystem.unmute")) {
			if (args.length != 1) {
				sender.sendMessage(Main.getPrefix() + "§cSyntax: /unmute [Name]");
			}
			if (args.length == 1) {	
				OfflinePlayer target = Bukkit.getOfflinePlayer(args[0]);

				Manager.unmute(target, sender);
				
				sender.sendMessage(" ");
				sender.sendMessage(Main.getPrefix() + "§aDu hast erfolgreich §e" + args[0] + " §aentmutet!");
				sender.sendMessage(" ");

			}
		}

		
		return false;
	}

}
