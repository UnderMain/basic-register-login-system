package de.onlycode.api;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;

public class API_Stuff {
	
	public ItemStack create(Material mat, int amount) {
		return new ItemStack(mat, amount);
		
	}
	
	public ItemStack createCustom(Material mat, int amount, short id, String display) {
		ItemStack it = new ItemStack(mat,id);
		ItemMeta meta = it.getItemMeta();
		meta.setDisplayName(display);
		it.setItemMeta(meta);
		return it;
		
	}
	
	public void clearPlayer(Player p) {
		p.setHealth(20);
		p.setFoodLevel(20);
		p.setLevel(0);
		p.setExp(0);
		p.getInventory().clear();
		p.getInventory().setArmorContents(null);
		for(PotionEffect effect : p.getActivePotionEffects()) {
			p.removePotionEffect(effect.getType());
			
		}
	}
	
	public int rndInt(int min, int max) {
		Random r = new Random();
		int i = r.nextInt((max-min) + 1) +min;
		return i;
		
	}
}
