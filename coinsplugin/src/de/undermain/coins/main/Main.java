package de.undermain.coins.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

	public void onEnable() {
		getCommand("coins").setExecutor(new coins());
		getCommand("ontime").setExecutor(new ontime());
		de.undermain.base.mysql.MySQLL.connect();
		Bukkit.getConsoleSender().sendMessage("§d§lUnderMain Coins!");

	}
	
}
