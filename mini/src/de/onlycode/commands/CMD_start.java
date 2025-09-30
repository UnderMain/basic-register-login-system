package de.onlycode.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import de.onlycode.TemplateMain;

public class CMD_start implements CommandExecutor {

	@SuppressWarnings("static-access")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (cmd.getName().equalsIgnoreCase("start")) {
			if (args.length == 0) {
				if (sender.hasPermission("Deine.Permission")) {
					if (TemplateMain.main.cd.lobby > 5) {
						TemplateMain.main.cd.lobby = 5;
						sender.sendMessage(TemplateMain.main.pr + "§7Du hast das Spiel §evorzeitig §7gestartet");

					} else {
						sender.sendMessage(TemplateMain.main.pr + "§cDas Spiel startet bereits");

					}

				}

			}

		}

		return false;
	}

}
