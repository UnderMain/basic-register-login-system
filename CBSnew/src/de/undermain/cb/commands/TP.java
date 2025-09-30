package de.undermain.cb.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.undermain.cb.main.Main;


public class TP implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if ((p.hasPermission("cbsystem.tp")) && (args.length == 0)) {
			p.sendMessage(Main.pr + "§cSyntax: /tp [Spieler]");
			return true;
		}
		Player target = Bukkit.getServer().getPlayer(args[0]);
		if (target == null) {
			p.sendMessage(Main.pr + "§cDer Spieler §e" + args[0] + " §cist nicht Online!");
			return true;
		}
		p.sendMessage(Main.pr + "§7Du hast dich zu §e" + args[0] + "§7 teleportiert.");
		p.teleport(target.getLocation());
		return true;
	}

}