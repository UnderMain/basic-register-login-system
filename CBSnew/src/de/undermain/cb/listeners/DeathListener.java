package de.undermain.cb.listeners;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;


import de.undermain.cb.coins.CoinsAPI;


public class DeathListener {

	
	@EventHandler
	public void onDeath (Player e) {
		Player p = e.getPlayer();
	if(!CoinsAPI.isRegistered(p)){
		CoinsAPI.register(p);
	}

		p.performCommand("spawn");
	      p.playSound(p.getLocation(), Sound.CLICK, 3.0F, 1.0F);
    
	
	}
}
	

