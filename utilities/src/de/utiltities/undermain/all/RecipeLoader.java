package de.utiltities.undermain.all;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class RecipeLoader {

	public void registerRecipes() {
		ItemStack picke = new ItemStack(Material.PAPER);
		ItemMeta pickeMeta = picke.getItemMeta();
		pickeMeta.setDisplayName("§6§$100");
		pickeMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
		pickeMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

		picke.setItemMeta(pickeMeta);
		ShapelessRecipe pickeRecipe = new ShapelessRecipe(picke);
		pickeRecipe.addIngredient(Material.DIRT);
		pickeRecipe.addIngredient(Material.SAND);
		Bukkit.addRecipe(pickeRecipe);
	}
	
}
