package de.undermain.cb.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.undermain.cb.main.Main;
import de.undermain.cb.utils.Manager;



public class SetWarp implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player)sender;
		
		if (!p.hasPermission("cbsystem.admin")) {
			p.sendMessage(Main.getPrefix() + "§cDazu hast du keine Rechte!");
			return true;
		}
		if (args.length != 1) {
			p.sendMessage(Main.getPrefix() + "§cSyntax: /setwarp [Name]");
			return true;
		}
        Manager.createConfigLocation(p.getLocation(), args[0], Manager.file, Manager.cfg);
        p.sendMessage(Main.getPrefix() + "§aDu hast erfolgreich den Warp §e" + args[0] + " §agesetzt.");
        
		return false;
	}
	
	

}
