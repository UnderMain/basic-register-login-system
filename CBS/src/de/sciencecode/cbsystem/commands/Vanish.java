package de.sciencecode.cbsystem.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.sciencecode.cbsystem.main.Main;

public class Vanish implements CommandExecutor {

	public static ArrayList<String> vanish = new ArrayList<String>();
	public static ArrayList<Player> players = new ArrayList<>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;

		if (p.hasPermission("cbsystem.vanish")) {
			if (args.length == 0) {
				if (vanish.contains(p.getName())) {
					vanish.remove(p.getName());
					for (Player all : Bukkit.getOnlinePlayers()) {
						all.showPlayer(p);
						players.remove(p);
						p.sendMessage(Main.getPrefix() + "§aDu bist nun nicht mehr im Vanish");
					    Bukkit.broadcastMessage(Main.getPrefix() + "§aDas Teammitglied §e" + p.getName() + " §ahat den Server betreten!");
						return false;
					}
				} else {
					for (Player all : Bukkit.getOnlinePlayers()) {
						all.hidePlayer(p);
					}
					vanish.add(p.getName());
					p.sendMessage(Main.getPrefix() + "§aDu bist nun im Vanish");
					players.add(p);
				    Bukkit.broadcastMessage(Main.getPrefix() + "§aDas Teammitglied §e" + p.getName() + " §ahat den Server verlassen!");
				    return false;

				}
			} else if (args.length == 1) {

			} else {
				p.sendMessage(Main.getPrefix() + "§cSyntax: /vanish");
			}
		} else {
			p.sendMessage(Main.getPrefix() + "§cDazu hast du keine Rechte");
		}
		return false;
	}
}