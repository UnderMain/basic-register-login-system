package de.undermain.shop.main;


import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.undermain.shop.commands.chatclear;
import de.undermain.shop.commands.coins;
import de.undermain.shop.commands.creative;
import de.undermain.shop.commands.giveall;
import de.undermain.shop.commands.heal;
import de.undermain.shop.commands.item;
import de.undermain.shop.commands.ontime;
import de.undermain.shop.commands.setspawn;
import de.undermain.shop.commands.setwarp;
import de.undermain.shop.commands.spawn;
import de.undermain.shop.commands.survival;
import de.undermain.shop.commands.warp;
import de.undermain.shop.listener.blockListener;
import de.undermain.shop.listener.joinListener;
import de.undermain.shop.util.MySQLL;
import de.undermain.shop.util.VillagerHandler;
import de.undermain.shop.util.files;
import de.undermain.shop.util.locationManager;

public class Main extends JavaPlugin {
	private static Main plugin;
	public static boolean debug;
	public static locationManager lm;

	private void registerFiles() {
		new files().createConfig();
		new files().createDefaultMySQLFile();
		new files().createDefaultVillagerFile();
	}

	private void run() {
		     new files().loadConfig();
		     new files().loadDefaultMySQLFile();
		     new files().loadDefaultVillagerFile();

		}
	
	public void onEnable() {
		plugin = this;
		registerFiles();
		run();
		MySQLL.connect();
		VillagerHandler villagerHandler = new VillagerHandler();
		lm = new locationManager();

		getCommand("shop").setExecutor(villagerHandler);
		
		getCommand("coins").setExecutor(new coins());
		getCommand("setwarp").setExecutor(new setwarp());
		getCommand("warp").setExecutor(new warp());

		getCommand("setspawn").setExecutor(new setspawn());
		getCommand("spawn").setExecutor(new spawn());
		getCommand("creative").setExecutor(new creative());
		getCommand("survival").setExecutor(new survival());
		getCommand("heal").setExecutor(new heal());
		getCommand("item").setExecutor(new item());
		getCommand("ontime").setExecutor(new ontime());
		getCommand("giveall").setExecutor(new giveall());
		getCommand("chatclear").setExecutor(new chatclear());

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
