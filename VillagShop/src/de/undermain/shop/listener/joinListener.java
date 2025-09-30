package de.undermain.shop.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.undermain.shop.util.qryss;



public class joinListener implements Listener {
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		int rows = qryss.getRows(p);
		if(rows >= 1) {
			
		}else {
			qryss.registerPlayer(p);

		}
		
	}
}
