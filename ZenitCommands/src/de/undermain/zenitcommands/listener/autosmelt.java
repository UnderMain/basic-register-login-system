package de.undermain.zenitcommands.listener;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class autosmelt implements Listener {
	

	@EventHandler
	public void onMine(BlockBreakEvent event) {
		
		Player p = event.getPlayer();
		
		if(event.getBlock().getType().equals(Material.IRON_ORE)) {
			
			this.giveItems(p, Material.IRON_INGOT);
			
		} else if(event.getBlock().getType().equals(Material.GOLD_ORE)) {
		
			this.giveItems(p, Material.GOLD_INGOT);

			
		} else if(event.getBlock().getType().equals(Material.DIAMOND_ORE)) {
		
			this.giveItems(p, Material.DIAMOND);
			event.getBlock().setType(Material.AIR);
		}
		
		
		
	}

	public void giveItems(Player p, Material material) {
		
		ItemStack item = p.getItemInHand();
		Random random = new Random();
		@SuppressWarnings("unused")
		int loot;
		int level = item.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS);
		if(level == 1) {
			loot = 2;
			
		} else if(level == 2) {
			loot = random.nextInt(1) +2;
			
		} else if(level == 3) {
			loot = random.nextInt(2) +2;
		} else {
			loot = 1;
		}
	};

}

