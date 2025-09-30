package de.undermain.zenitcommands.listener;

import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import de.undermain.zenitcommands.main.Main;

public class heal implements Listener {
	
	@EventHandler
	public void onSignCreate(SignChangeEvent event) {
		
		Player p = event.getPlayer();		
			if(event.getLine(0).equalsIgnoreCase("[Heilen]")) {
				if(!p.hasPermission("zenit.sign")) {
					p.sendMessage(Main.noperm);
					event.getBlock().setType(Material.AIR);
					return;
				}
				event.setLine(0, "§3§m-----------");
				event.setLine(1, "§8§l[§9Heilen§8§l]");
				event.setLine(2, "§8» Klick «");
				event.setLine(3, "§3§m-----------");
				Sign s = (Sign) event.getBlock().getState();
				s.update();
			}	
	}

	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		
		Player p = event.getPlayer();
		if(event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(event.getClickedBlock().getState() instanceof Sign) {
				Sign s = (Sign) event.getClickedBlock().getState();
				if(s.getLine(1).equalsIgnoreCase("§8§l[§9Heilen§8§l]")) {
					p.setHealth(20);
					p.sendMessage(Main.prefix + "§7Du hast dich geheilt!");
		
				}
			}
		}
	}
	
	
}
