package de.sciencecode.cbsystem.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.sciencecode.cbsystem.main.Main;

public class TPHere implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player)sender;
		
		if (p.hasPermission("cbsystem.tphere")) {
			if (args.length != 1) {
				p.sendMessage(Main.getPrefix() + "§cSyntax: /tphere [Name]");				
			}
			if (args.length == 1) {
				Player target = Bukkit.getPlayer(args[0]);
				
				p.sendMessage(Main.getPrefix() + "§aDu hast §e" + target.getName() + " §aerfolgreich zu dir teleportiert.");
				target.sendMessage(Main.getPrefix() + "§aDu wurdest zu §e" + p.getName() + " §ateleportiert.");
				target.teleport(p.getLocation());
			}
		}

		return false;
	}

}
