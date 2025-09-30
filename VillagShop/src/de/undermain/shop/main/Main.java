package de.undermain.shop.main;


import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.undermain.shop.commands.coins;
import de.undermain.shop.listener.blockListener;
import de.undermain.shop.listener.joinListener;
import de.undermain.shop.util.MySQLL;
import de.undermain.shop.util.VillagerHandler;
import de.undermain.shop.util.files;

public class Main extends JavaPlugin {
	private static Main plugin;
	public static boolean debug;
	
	private void registerFiles() {
		new files().createConfig();
		new files().createDefaultMySQLFile();
	}

	private void run() {
		     new files().loadConfig();
		     new files().loadDefaultMySQLFile();
		}
	
	public void onEnable() {
		plugin = this;
		registerFiles();
		run();
		MySQLL.connect();
		VillagerHandler villagerHandler = new VillagerHandler();
		
		getCommand("shop").setExecutor(villagerHandler);
		getCommand("coins").setExecutor(new coins());

		PluginManager pluginManager = Bukkit.getPluginManager();
	    getServer().getPluginManager().registerEvents(new joinListener(), this);
	    getServer().getPluginManager().registerEvents(new blockListener(), this);

		pluginManager.registerEvents(villagerHandler, this);
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("§3§l___________________________________________________________");
		Bukkit.getConsoleSender().sendMessage(" ");
		Bukkit.getConsoleSender().sendMessage("§6§lVillager Shop!");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("§3§lAuthor: §b§lUnderMain.de");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("§3§lPlugin-Version: §c§l1.1");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("§3§lMySQL: " + MySQLL.msgg);
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("§3§l___________________________________________________________");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("");	}
	public void onDisable() {
		
	}

	public static Main getPlugin() {
		return plugin;
	}
}
