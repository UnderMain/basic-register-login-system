package de.undermain.shop.util;

import java.text.DateFormat;
import java.util.GregorianCalendar;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class methoden {
	public static void chat(Player p) {
		for(int i = 0; i < 100; i++) {
			p.sendMessage("");
		}
	}
	public static void chats(Player p, String Prefix, String Args, String Level) {
		chat(p);
		p.sendMessage(Prefix + "§7§m--------------------------------------------------");
		p.sendMessage(Prefix + "");
		p.sendMessage(Prefix + "§7» Dein Item hat nun:");
		p.sendMessage(Prefix + "§aVerzauberung: " + Args);
		p.sendMessage(Prefix + "§aLevel: " + Level);
		p.sendMessage(Prefix + "");
		p.sendMessage(Prefix + "§7§m--------------------------------------------------");
		p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);

	}
	
	public static String datum() {
		GregorianCalendar gc = new GregorianCalendar();
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
		return df.format(gc.getTime());
	}
}
