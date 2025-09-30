package de.sciencecode.cbsystem.listeners;

import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityCombustByBlockEvent;
import org.bukkit.event.entity.EntityCombustByEntityEvent;
import org.bukkit.event.entity.EntityCombustEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class MainListener implements Listener {
	
	@EventHandler
	public void onChange(WeatherChangeEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		e.setDeathMessage("");
	}
	
	@EventHandler
	public void onAttack(EntityDamageByEntityEvent e) {
		Player p = (Player)e.getDamager();
		
		if (p instanceof Player || e.getEntity().getType() == EntityType.ZOMBIE && e.getEntity().getType() == EntityType.VILLAGER || e.getEntity().getType() == EntityType.ZOMBIE) {
			e.setCancelled(true);
		}
	
	}
	
	  @EventHandler(ignoreCancelled=true)
	  public void onCombust(EntityCombustEvent event)
	  {
	    if (event instanceof EntityCombustByEntityEvent || event instanceof EntityCombustByBlockEvent) {
	      return;
	    }
	    World world = event.getEntity().getWorld();
	    if (world.getEnvironment() != World.Environment.NORMAL) {
	      return;
	    }
	    event.setCancelled(true);
	  }

}
