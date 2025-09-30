package de.sciencecode.cbsystem.commands;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.sciencecode.cbsystem.main.Main;

public class ToggleMsg implements CommandExecutor {

	public static ArrayList<Player> tmsg = new ArrayList<Player>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;

		if (p.hasPermission("cbsystem.togglemsg")) {
			if (args.length != 0) {
				p.sendMessage(Main.getPrefix() + "§cSyntax: /togglemsg");
			}
			if (args.length == 0) {
				if (tmsg.contains(p)) {
					tmsg.remove(p);
					p.sendMessage(Main.getPrefix() + "§aDu bekommst nun wieder Nachrichten!");
				
				} else if (!tmsg.contains(p)) {
					tmsg.add(p);
					p.sendMessage(Main.getPrefix() + "§aDu bekommst nun keine Nachrichten mehr.");
		
				} else {
					p.sendMessage(Main.getPrefix() + "§cDazu hast du keine Rechte!");
				}

			}
		}

		return false;
	}

}
