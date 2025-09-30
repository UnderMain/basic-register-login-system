package de.utilities.undermain.main;

import org.bukkit.plugin.java.JavaPlugin;

import de.utiltities.undermain.all.ClickListener;
import de.utiltities.undermain.all.RecipeLoader;

public class Main extends JavaPlugin {

	private static Main plugin;
	public void onEnable() {
		plugin = this;
		new RecipeLoader().registerRecipes();
		System.out.println("§aUtilities wurde aktiviert!");
	    getServer().getPluginManager().registerEvents(new ClickListener(), this);

	}
	
}
