package de.sciencecode.cbsystem.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.sciencecode.cbsystem.main.Main;

public class Kick implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (p.hasPermission("cbsystem.kick")) {

				if (args.length != 2) {
					p.sendMessage(Main.getPrefix() + "§cSyntax: /kick [Name] [Grund]");
					return true;

				} else if (args.length == 2) {
					Player target = Bukkit.getPlayer(args[0]);

					if (args[0].equalsIgnoreCase("ScienceCode")) {
						p.sendMessage(Main.getPrefix() + "§cDu darfst den Schreiber des Plugins nicht kicken!");
						return true;
					}

					if (target == null) {
						p.sendMessage(Main.getPrefix() + "§cDieser Spieler ist Offline!");
						return true;
					}
					String reason = "";
	                for (int i = 1; i < args.length; i++) {
	                	reason = (reason + args[i] + " ");
	                  }
					
					p.sendMessage(Main.getPrefix() + "§aDu hast erfolgreich §c" + target.getName() + " §awegen §4" + reason + " §agekickt!");
					target.kickPlayer(Main.getPrefix() + "§cDu wurdest vom Server gekickt! \n §cGrund: §e" + reason + " \n\n §aDu wurdest zu unrecht gekickt? Melde dich im TS \n\n\n §eDu wurdest gekickt von §a " + p.getName());
					return false;

				}
			}
		}
		return false;
	}
}
