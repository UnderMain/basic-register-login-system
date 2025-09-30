package de.sciencecode.cbsystem.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.sciencecode.cbsystem.main.Main;

public class Msg implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player)sender;	
		if (args.length != 2) {
			p.sendMessage(Main.getPrefix() + "§cSyntax: /msg [Name] [Nachricht]");
			return true;
		}
	    Player target = Bukkit.getPlayer(args[0]);
		
	    if (target == p) {
			p.sendMessage(Main.getPrefix() + "§cDu darfst dich nicht selber anschreiben.");
			return true;
		}
	    if (target == null) {
	    	p.sendMessage(Main.getPrefix() + "§cDieser Spieler ist Offline!");
	    	return true;
	    }
			
			if (!ToggleMsg.tmsg.contains(p)) {
				String msg = "";
                for (int i = 1; i < args.length; i++) {
                    msg = (msg + args[i] + " ");
                  }
				p.sendMessage(Main.getPrefix() + "§eDu §8» §a" + target.getName() + " §8| §7" + msg);
				target.sendMessage(Main.getPrefix() + "§e" + p.getName() + " §8» §aDu §8| §7" + msg);
			
				}
		
		return false;
	}

}
