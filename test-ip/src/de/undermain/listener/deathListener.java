package de.undermain.listener;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import de.undermain.mysql.qryss;

public class deathListener implements Listener {

	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player p = e.getEntity();
		int todeDB = qryss.deaths(p.getName());
		int newTode = todeDB + 1;
		qryss.setnewDeaths(newTode, p.getName());
		
		Player killer = p.getKiller();
		
		if(killer instanceof Player) {
			int kills = qryss.kills(killer.getName());
			int newkills = kills + 1;
			qryss.setnewKills(newkills, killer.getName());
		}
		
	}
	
	
	
}
