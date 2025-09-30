package de.roboty;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;



public class Main extends JavaPlugin {
	
	
	String prefix = "sad";
	
	
	private static Main plugin;
	
	public void onEnable() {
		plugin = this;
		PluginManager pluginManager = Bukkit.getPluginManager();
		pluginManager.registerEvents(new FirstJoinListener(), this);
		
		
		
	}
	

	
	
	public static Main getPlugin() {
		return plugin;
	}
}
