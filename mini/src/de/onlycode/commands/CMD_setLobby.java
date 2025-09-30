package de.onlycode.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.onlycode.TemplateMain;

public class CMD_setLobby implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(sender instanceof Player) {
			Player p = (Player)sender;
		if(p.hasPermission("system.admin")) {
		if(args.length != 0) {
			p.sendMessage(TemplateMain.main.pr + "§7Benutze §e/setlobby");
			return true;
		}
		TemplateMain.main.lm.setLocation("lobby", p.getLocation());
		p.sendMessage(TemplateMain.main.pr + "§7Du hast die §eLobby §7gesetzt");
		
		}
		
		}
		return false;
		
	}

}
