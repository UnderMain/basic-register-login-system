package de.utiltities.undermain.all;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;


public class ClickListener implements Listener{

	
	@EventHandler
	public void onClick(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if(p.getItemInHand().getType() == Material.PAPER) {
			if(p.getInventory().getItemInHand().getItemMeta().getDisplayName().equals("§6§$100")) {
				p.sendMessage("§6Du hast $100 mehr!");
				ItemStack item  = new ItemStack(p.getItemInHand());
				item.setAmount(0);
			}else {
				p.sendMessage("");
			}
		}else {
			p.sendMessage("");
		}
		
	}
}
