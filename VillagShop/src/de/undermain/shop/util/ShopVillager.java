package de.undermain.shop.util;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ShopVillager {
	
	public static final String VILLAGER_NAME = "§6§lShop";
	
	public ShopVillager(Location location) {
		Villager shop = (Villager) location.getWorld().spawnEntity(location, EntityType.VILLAGER);
		shop.setCustomName(ShopVillager.VILLAGER_NAME);
		shop.setCustomNameVisible(true);
		shop.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 500));
	}

}

