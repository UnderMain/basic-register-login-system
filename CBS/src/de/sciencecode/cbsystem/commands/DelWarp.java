package de.sciencecode.cbsystem.commands;

import java.io.IOException;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.sciencecode.cbsystem.main.Main;
import de.sciencecode.cbsystem.utils.Manager;

public class DelWarp implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (p.hasPermission("cbsystem.removewarp")) {
			if (args.length == 1) {
				if (Manager.cfg.getString(args[0]) == null) {
					p.sendMessage(Main.getPrefix() + "§cDieser Warp existiert nicht!");
					return true;
				}
				Manager.cfg.set(args[0], null);
				try {
					Manager.cfg.save(Manager.file);
				} catch (IOException e) {
					e.printStackTrace();
				}
				p.sendMessage(Main.getPrefix() + "§aDu hast den Warp §e" + args[0] + "§a erfolgreich enfernt!");
			}
		}
		return false;
	}
}
