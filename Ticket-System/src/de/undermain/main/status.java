package de.undermain.main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.undermain.config.files;
import de.undermain.mysql.qrys;

public class status implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
 
		Player p = (Player) sender;
		
		if(args.length < 1) {
			
			String status = qrys.getStatusUser(p.getName());
			String statuss = "";
			String hinweis = "";
			String hinweis2 = "";
			
			if(status == null) {
				statuss = "§a§lwurden noch nicht gesetzt!";
				hinweis = "§7/setlogin <email> <passwort>";
			}else {
				statuss = "§c§lwurden gesetzt!";
				hinweis = "§7Falls du diese ändern möchtest,";
				hinweis2 = "§7melde dich bei einem Admin!";
			}
			

			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage(files.getObject_Messages.get("Prefix") + "§6§m----------------------------------");
			p.sendMessage(files.getObject_Messages.get("Prefix") + "");
			p.sendMessage(files.getObject_Messages.get("Prefix") + "§7Hallo §b§l" + p.getName() + "!");
			p.sendMessage(files.getObject_Messages.get("Prefix") + "");
			p.sendMessage(files.getObject_Messages.get("Prefix") + "§7Deine Daten " + statuss);
			p.sendMessage(files.getObject_Messages.get("Prefix")  + "");
			p.sendMessage(files.getObject_Messages.get("Prefix") + hinweis);
			p.sendMessage(files.getObject_Messages.get("Prefix") + hinweis2);
			p.sendMessage(files.getObject_Messages.get("Prefix") + "");
			p.sendMessage(files.getObject_Messages.get("Prefix") + "§6§m----------------------------------");

			
		}
		
		return false;
	}

}
