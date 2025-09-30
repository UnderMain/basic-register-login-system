package de.sciencecode.cbsystem.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import de.sciencecode.cbsystem.main.Main;
import de.sciencecode.cbsystem.utils.Manager;

public class UnBan implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (sender.hasPermission("cbsystem.unban")) {
			if (args.length != 1) {
				sender.sendMessage(Main.getPrefix() + "§cSyntax: /unban [Name]");
				return true;
			}
				OfflinePlayer target = Bukkit.getOfflinePlayer(args[0]);
				
				Manager.unban(target, sender);

				return false;
			}

		return false;
	}
}
