package de.undermain.commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.undermain.config.files;
import de.undermain.config.methoden;
import de.undermain.mysql.qrys;

public class lizenzinfo implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player p = (Player) sender;

		String Prefix = files.getObject_config.get("Prefix").toString().replaceAll("&", "§");
		String perm = files.getObject_config.get("NoPerm").toString().replaceAll("&", "§");
		String consolemsg = files.getObject_config.get("ConsoleMSG").toString().replaceAll("&", "§");
		String toomuch = files.getObject_config.get("TooMuchArgs").toString().replaceAll("&", "§");
		
		if(p.hasPermission("ufc.*")) {
			if(sender instanceof Player) {
				if(args.length == 0) {
					methoden.chat(p);
					p.sendMessage(Prefix + "§7§m---------------------------");
					p.sendMessage(Prefix + "§b§lLizenz-Informationen:");
					p.sendMessage(Prefix + "");
					p.sendMessage(Prefix + "§6§l[»] Lizenz: §7" + files.getObject_lizenz.get("Lizenz").toString());
					p.sendMessage(Prefix + "§6§l[»] Status: §aAktiv");
					p.sendMessage(Prefix + "§6§l[»] Produkt: §7" + qrys.produkt());
					p.sendMessage(Prefix + "§6§l[»] Bestellnummer: §7" + qrys.bestellnummer());
					p.sendMessage(Prefix + "§6§l[»] Gebundene IP: §7" + qrys.ip());
					p.sendMessage(Prefix + "");
					p.sendMessage(Prefix + "§7§m---------------------------");
					p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);

				}else {
					p.sendMessage(Prefix + toomuch);
					p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);

				}
				
			}else {
				p.sendMessage(Prefix + consolemsg);
				p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);

			}
			
		}else {
			p.sendMessage(Prefix + perm);
			p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);

		}
		
		
		
		
		
		return false;
	}

}
