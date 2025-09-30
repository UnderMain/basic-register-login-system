package de.undermain.base.listener;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import de.undermain.base.files.files;
import de.undermain.base.mysql.qryss;


public class joinListener implements Listener{
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		int rows = qryss.getRows(p);
		String Prefix = files.getObject_config.get("Prefix").toString().replaceAll("&", "§");
		qryss.online(p, 1);
		p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
		if(rows >= 1) {


		}else {
			qryss.registerPlayer(p);
			p.kickPlayer(Prefix +"§a§lPlease reconnect, your data has been registered the first time in this server!");
		}
		
	}
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		qryss.online(p, 0);

	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		int blocksBreaked = qryss.blocksBreaked(p.getName());
		int newbb = blocksBreaked + 1;
		qryss.updateBlocksBreaked(p, newbb);
	}
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		int blocksPlaced = qryss.blocksPlaced(p.getName());
		int newbp = blocksPlaced + 1;
		qryss.updateBlocksPlaced(p, newbp);
	}
	@EventHandler
	public void onKill(PlayerDeathEvent e) {
		Player dead = e.getEntity();

		if(e.getEntity().getKiller() instanceof Player) {
			int deaths = qryss.deaths(dead.getName());
			int kills = qryss.kills(e.getEntity().getKiller().getName());
			
			int newd = deaths + 1;
			int newk = kills + 1;
			
			qryss.updateDeaths(dead, newd);
			qryss.updateKills(e.getEntity().getKiller(), newk);
		}else {
			int deaths = qryss.deaths(dead.getName());
			int newd = deaths + 1;
			qryss.updateDeaths(dead, newd);

		}
		

		
		
	}
	
	

}
