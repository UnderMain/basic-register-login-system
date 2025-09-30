package de.sciencecode.cbsystem.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Bewerbung implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player)sender;
		
		if (args.length == 0) {
			p.sendMessage(" ");
			p.sendMessage("§eBewerbungs Status:");
			p.sendMessage(" ");
			p.sendMessage("§bDeveloper §8| §aOFFEN");
			p.sendMessage("§9Supporter §8| §aOFFEN");
			p.sendMessage("§eBuilder §8| §aOFFEN");
			p.sendMessage(" ");
			p.sendMessage("§eNähere Infos:");
			p.sendMessage(" ");
			p.sendMessage("§c/bewerbung [Dev/Sup/Builder]");
			p.sendMessage(" ");
		}
		if (args.length == 1) {
			if (args[0].equalsIgnoreCase("dev")) {
				p.sendMessage(" ");
				p.sendMessage("§eStatus §8| §aOFFEN");
				p.sendMessage(" ");
				p.sendMessage("§e- §a15 Jahre");
				p.sendMessage("§e- §a1/2 Jahr Erfahrung");
				p.sendMessage(" ");
			} else if (args[0].equalsIgnoreCase("sup")) {
				p.sendMessage(" ");
				p.sendMessage("§eStatus §8| §aOFFEN");
				p.sendMessage(" ");
				p.sendMessage("§e- §a14 Jahre");
				p.sendMessage("§e- §aGutes Mikro");
				p.sendMessage("§e- §aNetter Typ :O");
				p.sendMessage(" ");
			} else if (args[0].equalsIgnoreCase("builder")) {
				p.sendMessage(" ");
				p.sendMessage("§eStatus §8| §aOFFEN");
				p.sendMessage(" ");
				p.sendMessage("§e- §a13 Jahre");
				p.sendMessage("§e- §eErfahrung im Bauen");
				p.sendMessage("§e- §aNetter Typ :O");
				p.sendMessage(" ");
			}
		}
		
		
		return false;
	}

}
