package de.sciencecode.cbsystem.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatPrefix implements Listener {
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		String msg = e.getMessage();
		
		if (p.hasPermission("cbsystem.owner")) {
			e.setFormat("§4Owner §8| §4" + p.getName() + " §8» §7" + msg);
		}
		else if (p.hasPermission("cbsystem.admin")) {
			e.setFormat("§4Admin §8| §4" + p.getName() + " §8» §7" + msg);
		}
		else if (p.hasPermission("cbsystem.srdev")) {
			e.setFormat("§bSrDev §8| §b" + p.getName() + " §8» §7" + msg);
		}
		else if (p.hasPermission("cbsystem.dev")) {
			e.setFormat("§bDev §8| §b" + p.getName() + " §8» §7" + msg);
		}
		else if (p.hasPermission("cbsystem.srmod")) {
			e.setFormat("§cSrMod §8| §c" + p.getName() + " §8» §7" + msg);
		}
		else if (p.hasPermission("cbsystem.mod")) {
			e.setFormat("§cMod §8| §c" + p.getName() + " §8» §7" + msg);
		}
		else if (p.hasPermission("cbsystem.sup")) {
			e.setFormat("§9Sup §8| §9" + p.getName() + " §8» §7" + msg);
		}
		else if (p.hasPermission("cbsystem.builder")) {
			e.setFormat("§eBuilder §8| §e" + p.getName() + " §8» §7" + msg);
		}
		else if (p.hasPermission("cbsystem.yter")) {
			e.setFormat("§5YouTuber §8| §5" + p.getName() + " §8» §7" + msg);
		}
		else if (p.hasPermission("cbsystem.jryter")) {
			e.setFormat("§5JrYouTuber §8| §5" + p.getName() + " §8» §7" + msg);
		}
		else if (p.hasPermission("cbsystem.premium")) {
			e.setFormat("§6Premium §8| §6" + p.getName() + " §8» §7" + msg);
		} else {
			e.setFormat("§7Spieler §8| §7" + p.getName() + " §8» §7" + msg);
		}

	}

}
