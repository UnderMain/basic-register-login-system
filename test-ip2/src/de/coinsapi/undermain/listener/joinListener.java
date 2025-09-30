package de.coinsapi.undermain.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import de.coinsapi.undermain.config.files;
import de.coinsapi.undermain.mysql.qryss;

public class joinListener implements Listener{

	private static int taskID;
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		String prefix = files.getObject_config.get("Prefix").replaceAll("&", "§");
		String kick = files.getObject_config.get("Kick").replaceAll("&", "§");
		int rows = qryss.getRows(p);
		if(rows >= 1) {
			
		}else {
			qryss.registerPlayer(p);
			qryss.registerPlayer2(p);
			p.kickPlayer(prefix + kick);

		}

		
	}
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		if(Bukkit.getOnlinePlayers().size() >= 1) {
			Bukkit.getScheduler().cancelTask(taskID);
		}
	}



	
}
