package de.sciencecode.cbsystem.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.sciencecode.cbsystem.main.Main;

public class ChatClear implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (p.hasPermission("cbsystem.cc")) {
			if (sender instanceof Player && args.length == 0) {
				for (int i = 0; i < 150; i++) {
					Bukkit.broadcastMessage("");
				}

					Bukkit.broadcastMessage(Main.getPrefix() + "§aDer Chat wurde von §e" + p.getName() + " §agecleart!");
					return true;
				
			}
		} else {
			p.sendMessage(Main.getPrefix() + "§cDazu hast du keine Rechte!");

		}
		return false;

	}
}
