package de.sciencecode.cbsystem.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import de.sciencecode.cbsystem.main.Main;

public class ChatListener implements Listener {
	
	@EventHandler(priority=EventPriority.HIGHEST)
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		
		if (Main.database.contains(p.getUniqueId().toString())) {
					
			e.setFormat("§7Spieler §8| §7" + Main.database.getString(p.getUniqueId().toString()) + " §8» §7" + e.getMessage());

		}

	}

}
