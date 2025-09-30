package de.undermain.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import de.undermain.main.mysqlQuerys;

public class QuitListener implements Listener {
	
	@EventHandler
	public void onJoin(PlayerQuitEvent e) {
		
		Player p = e.getPlayer();
		
		mysqlQuerys.deleteName(p.getName());
		
	}
	
}
