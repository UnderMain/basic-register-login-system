package me.daniel.Coins;

import org.bukkit.Bukkit;

import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin{

	public static String pr = "§8[§eCoins§8] §7";
	
	
	public void onEnable() {
		MySQL.connect();
		CoinsAPI.createTable();
		Bukkit.getPluginManager().registerEvents(new Join(), this);
		getCommand("coins").setExecutor(new Coins());
		
		}

	
	
	
	
}
