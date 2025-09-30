package de.sciencecode.cbsystem.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.sciencecode.cbsystem.main.Main;
import de.sciencecode.cbsystem.utils.Manager;

public class Kurse implements CommandExecutor {
	

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player)sender;
		
		if (args.length != 0) {
			p.sendMessage(Main.getPrefix() + "§cSyntax: /kurse");
			return true;
		}
		
		int kurs1 = Manager.cfg4.getInt("Kurs1");
		int kurs2 = Manager.cfg4.getInt("Kurs2");
		int kurs3 = Manager.cfg4.getInt("Kurs3");
		int kurs4 = Manager.cfg4.getInt("Kurs4");
		int kurs5 = Manager.cfg4.getInt("Kurs5");

		p.sendMessage(Main.getPrefix() + " ");
		p.sendMessage(Main.getPrefix() + "§eKurse:");
		p.sendMessage(Main.getPrefix() + "§aPigSpawner: " + kurs1);
		p.sendMessage(Main.getPrefix() + "§aBeacon: " + kurs2);
		p.sendMessage(Main.getPrefix() + "§aSpawnEgg: " + kurs3);
		p.sendMessage(Main.getPrefix() + "§aXP-Flaschen: " + kurs4);
		p.sendMessage(Main.getPrefix() + "§aDrachenei: " + kurs5);
		p.sendMessage(Main.getPrefix() + "§cDies sind nur Kurse! Der eigentliche Wert ist Shop!");
		p.sendMessage(Main.getPrefix() + " ");

		
		return false;
	}

}
