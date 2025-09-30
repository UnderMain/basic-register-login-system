import java.util.Random;

import org.bukkit.event.block.BlockBreakEvent;

public class autosmelt implements Listener {
	
	
	@EventHandler
	public void onMine(BlockBreakEvent event) {
		
		Player p = event.getPlayer();
		ItemStack drop = null;
		
		if(event.getBlock().getType().equals(Material.IRON_ORE)) {
			
			drop = this.getDrop(p, Material.IRON_INGOT);
			
		} else if(event.getBlock().getType().equals(Material.GOLD_ORE)) {
		
			drop = this.getDrop(p, Material.GOLD_INGOT);
			
		} else if(event.getBlock().getType().equals(Material.DIAMOND_ORE)) {
		
			drop = this.getDrop(p, Material.DIAMOND);
					
		}
	
		
		
	}

	public ItemStack getDrop(Player p, Material material) {
		
		ItemStack item = p.getItemInHand();
		Random random = new Random();
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
		
		return new ItemStack(material, loot);	
		
	}

}