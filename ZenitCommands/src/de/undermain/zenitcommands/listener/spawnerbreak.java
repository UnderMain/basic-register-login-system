package de.undermain.zenitcommands.listener;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import de.undermain.zenitcommands.main.Main;

public class spawnerbreak implements Listener {
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		
		if(event.getBlock().getType().equals(Material.MOB_SPAWNER)) {
			
			Player p = event.getPlayer();
			
			if(p.getItemInHand().getEnchantments().containsKey(Enchantment.SILK_TOUCH)) {
				
				p.getLocation().getWorld().dropItem(event.getBlock().getLocation(), new ItemStack(Material.MOB_SPAWNER, 1));
				p.sendMessage(Main.prefix + "§7Du hast erfolgreich den Spawner abgebaut!");
			}
		}
	
	}

}
