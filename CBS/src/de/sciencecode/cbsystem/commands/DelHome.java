package de.sciencecode.cbsystem.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.sciencecode.cbsystem.main.Main;
import de.sciencecode.cbsystem.utils.Manager;

public class DelHome implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player)sender;
		
		if (args.length != 1) {
			p.sendMessage(Main.getPrefix() + "§cSyntax: /delhome [Name]");
			return true;
		}
        if (!Manager.ifHomeExist(p, args[0])) {
        	p.sendMessage(Main.getPrefix() + "§cDer Home §e" + args[0] + " §cexistiert nicht!");
        	return true;
        }
        Manager.remHome(p, args[0]);
        p.sendMessage(Main.getPrefix() + "§aDu hast erfolgreich dein Home §e" + args[0] + " §aentfernt!");
        
		
		return false;
	}

}
