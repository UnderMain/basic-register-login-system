package de.undermain.cb.listeners;

import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.undermain.cb.coins.CoinsAPI;
import de.undermain.cb.utils.Files;
import de.undermain.cb.utils.Manager;

public class Join implements Listener{
	
	
	@EventHandler
	public void onJoin (PlayerJoinEvent e) {
		Player p = e.getPlayer();
	if(!CoinsAPI.isRegistered(p)){
		CoinsAPI.register(p);
	}


	
	//«»✗✗×
	 p.performCommand("spawn");
	    p.setGameMode(GameMode.SURVIVAL);
	    
	    Manager.sendTablistHeaderAndFooder(p, Files.getObject_Messages.get("Header").toString(), Files.getObject_Messages.get("Footer").toString());
	      p.playSound(p.getLocation(), Sound.CLICK, 3.0F, 1.0F);
    
	      //
	      //
	
	
	}
}
