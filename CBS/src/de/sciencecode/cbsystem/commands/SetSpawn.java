package de.sciencecode.cbsystem.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.sciencecode.cbsystem.main.Main;
import de.sciencecode.cbsystem.utils.Manager;

public class SetSpawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player)sender;
		
		if (p.hasPermission("cbsystem.admin")) {
            Manager.createConfigLocation(p.getLocation(), "Spawn", Manager.file, Manager.cfg);
            p.sendMessage(Main.getPrefix() + "§aDu hast erfolgreich den Spawn gesetzt!");

		} else {
	          p.sendMessage(Main.getPrefix() + "§cDazu hast du keine Rechte!");

		}
		
		return false;
	}

}
