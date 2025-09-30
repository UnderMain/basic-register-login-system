package de.undermain.main;



import org.bukkit.plugin.java.JavaPlugin;

import de.undermain.mysql.MySQL;


public class Main extends JavaPlugin {
	
	public void onEnable() {
		
		MySQL.connect();


		getCommand("link").setExecutor(new link());

	}
	
	public void onDisable() {
		
		MySQL.disconnect();
		
	}
	

}
