package de.undermain.listener;


import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import de.undermain.config.files;
import de.undermain.mysql.qrys;

public class UpdateListener implements Listener {
	
	public void onMove(PlayerMoveEvent event) {
		
		Player p = event.getPlayer();
		
		int status = qrys.getStatus(p.getName());
		
		if(status == 1) {
			 
			p.sendMessage(files.getObject_Messages.get("Prefix").toString().replaceAll("&","§") + "Dein Ticket wurde beantwortet!");
		}
		
	}

}
