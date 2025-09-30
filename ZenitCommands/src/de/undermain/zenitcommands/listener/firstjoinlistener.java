package de.undermain.zenitcommands.listener;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.undermain.zenitcommands.main.Main;




public class firstjoinlistener implements Listener {
	
	@EventHandler
	public void onFirstJoin(PlayerJoinEvent event) {
		
		Player p = event.getPlayer();
		
		p.teleport(Main.lm.getSpawm());
		p.sendMessage(Main.prefix + "§7Wilkommen auf dem Server!");

	}

}
