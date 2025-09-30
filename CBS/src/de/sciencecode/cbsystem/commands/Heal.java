package de.sciencecode.cbsystem.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.sciencecode.cbsystem.main.Main;

public class Heal implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (args.length == 0) {
				if (p.hasPermission("cbsystem.heal")) {
					p.setHealth(20);
					p.sendMessage(Main.getPrefix() + "§aDu wurdest erfolgreich geheilt!");
				} else
					p.sendMessage(Main.getPrefix() + "§cDazu hast du keine Rechte!");
			}
		}
		return false;
	}
}
