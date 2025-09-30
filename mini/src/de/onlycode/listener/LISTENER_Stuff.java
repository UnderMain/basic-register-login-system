package de.onlycode.listener;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

import de.onlycode.Gamestate;
import de.onlycode.TemplateMain;

public class LISTENER_Stuff implements Listener {

	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		if (TemplateMain.main.state == Gamestate.LOBBY || TemplateMain.main.state == Gamestate.RESTARTING) {
			if (!TemplateMain.main.alive.contains(e.getPlayer())) {
				e.setCancelled(true);
			}
		}

	}

	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		if (TemplateMain.main.state == Gamestate.LOBBY || TemplateMain.main.state == Gamestate.RESTARTING) {
			if (!TemplateMain.main.alive.contains(e.getPlayer())) {
				e.setCancelled(true);
			}
		}

	}

	@EventHandler
	public void onLoseFeed(FoodLevelChangeEvent e) {

		if (TemplateMain.main.state == Gamestate.DEATHMATCH || TemplateMain.main.state == Gamestate.INGAME) {
			if (TemplateMain.main.alive.contains(e.getEntity())) {
				e.setCancelled(false);

			} else {
				e.setCancelled(true);
			}

		} else {
			e.setCancelled(true);
		}

	}

	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		if (!TemplateMain.main.alive.contains(e.getPlayer())) {
			e.setCancelled(true);
			return;

		}

		if (TemplateMain.main.state == Gamestate.DEATHMATCH || TemplateMain.main.state == Gamestate.INGAME) {
			e.setCancelled(false);

		} else {
			e.setCancelled(true);
		}

	}

	@EventHandler
	public void onPick(PlayerPickupItemEvent e) {
		if (!TemplateMain.main.alive.contains(e.getPlayer())) {
			e.setCancelled(true);
			return;

		}

		if (TemplateMain.main.state == Gamestate.DEATHMATCH || TemplateMain.main.state == Gamestate.INGAME) {
			e.setCancelled(false);

		} else {
			e.setCancelled(true);
		}

	}

	@EventHandler
	public void onDamage(EntityDamageEvent e) {

		if (!TemplateMain.main.alive.contains(e.getEntity())) {
			e.setCancelled(true);

		}

		if (TemplateMain.main.state == Gamestate.LOBBY || TemplateMain.main.state == Gamestate.RESTARTING) {
			if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
				e.setCancelled(true);
			}

		}

	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onEntDmgByEnt(EntityDamageByEntityEvent e) {
		if (TemplateMain.main.state == Gamestate.INGAME || TemplateMain.main.state == Gamestate.DEATHMATCH) {
			e.setCancelled(false);
			if (TemplateMain.main.alive.contains(e.getDamager())) {
				e.setCancelled(false);
				e.getEntity().getWorld().playEffect(e.getEntity().getLocation(), Effect.STEP_SOUND, Material.REDSTONE_BLOCK.getId());

			}

			if ((TemplateMain.main.alive.contains(e.getEntity())) && (TemplateMain.main.alive.contains(e.getDamager()))) {
				e.setCancelled(false);
			} else {
				e.setCancelled(true);
			}

			if ((TemplateMain.main.alive.contains(e.getEntity())) && (!TemplateMain.main.alive.contains(e.getDamager()))) {
				e.setCancelled(true);
			}
			if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player))) {
				TemplateMain.main.lastdmg.put((Player) e.getEntity(), (Player) e.getDamager());
			}

		} else {
			e.setCancelled(true);
		}
	}
}
