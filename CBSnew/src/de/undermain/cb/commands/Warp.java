package de.undermain.cb.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.undermain.cb.main.Main;
import de.undermain.cb.utils.Manager;



public class Warp implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player)sender;
		
		if (args.length != 1) {
			p.sendMessage(Main.getPrefix() + "§cSyntax: /warp [Name]");
			return true;
		}
        if (Manager.cfg.getString(args[0]) == null) {
        	p.sendMessage(Main.getPrefix() + "§cDieser Warp existiert nicht!");
        	return true;
        }
        p.teleport(Manager.getConfigLocation(args[0], Manager.cfg));
        p.sendMessage(Main.getPrefix() + "§aDu bist nun beim Warp §e" + args[0] + "§a.");
		return false;
	}

}
