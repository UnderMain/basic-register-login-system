package de.onlycode.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.onlycode.TemplateMain;

public class CMD_setDeathmatch implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (p.hasPermission("system.admin")) {
				if (args.length != 1) {
					p.sendMessage(TemplateMain.main.pr + "§7Benutze §e/setdm <Nummer>");
					return true;
				}

				try {
					int number = Integer.parseInt(args[0]);
					TemplateMain.main.lm.setDeathmatch(number, p.getLocation());
					p.sendMessage(TemplateMain.main.pr + "§7Du hast den Deathmatch - Spawn §e" + number + " §7gesetzt");

				} catch (NumberFormatException ex) {
					p.sendMessage(TemplateMain.main.pr + "§cDu musst eine §eZahl §7eingeben");
				}

			}

		}
		return false;

	}

}
