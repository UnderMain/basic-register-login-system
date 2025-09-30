package de.undermain.cb.main;


import java.io.File;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import de.undermain.cb.coins.Coins;
import de.undermain.cb.coins.CoinsAPI;
import de.undermain.cb.coins.MySQL;
import de.undermain.cb.commands.Fly;
import de.undermain.cb.commands.GiveAll;
import de.undermain.cb.commands.SetSpawn;
import de.undermain.cb.commands.SetWarp;
import de.undermain.cb.commands.Spawn;
import de.undermain.cb.commands.TP;
import de.undermain.cb.commands.Warp;
import de.undermain.cb.commands.gm;
import de.undermain.cb.listeners.Join;
import de.undermain.cb.utils.Files;
import de.undermain.cb.utils.Loader;




public class Main extends JavaPlugin {

	public static String pr = "§6§lCitybuild §8× §r";
	public static Main instance;
	private static Main plugin;
	
	public static HashMap<String, Object> getObject_MySQL = new HashMap<String, Object>();
	public static boolean debug;

	public static String getPrefix() {
		return "§6§lCitybuild §8× §r";
		
	}
	
	public static File file = new File("plugins//CB-System//mysql.yml");
	public static YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file); 
	
	public void onEnable() {
		
		instance = this;

		registerFiles();
		run();

		MySQL.connect();
		CoinsAPI.createTable();
		Bukkit.getPluginManager().registerEvents(new Join(), this);
	
		getCommand("coins").setExecutor(new Coins());
		getCommand("gamemode").setExecutor(new gm());
		getCommand("tp").setExecutor(new TP());
		getCommand("setwarp").setExecutor(new SetWarp());
		getCommand("warp").setExecutor(new Warp());
		getCommand("spawn").setExecutor(new Spawn());
		getCommand("setspawn").setExecutor(new SetSpawn());
		getCommand("giveall").setExecutor(new GiveAll());
		getCommand("fly").setExecutor(new Fly());

		
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("§3§l___________________________________________________________");
		Bukkit.getConsoleSender().sendMessage(" ");
		Bukkit.getConsoleSender().sendMessage("§a§lCitybuild-System wurde aktiviert!");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("§3§lAuthor: §c§lUnderMain / Zenit-Netzwerk.de");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("§3§lPlugin-Version: §c§l1.0");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("§3§lLizenz: §6§lPremium");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("§3§lStatus: " + MySQL.msgg);
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("§3§l___________________________________________________________");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("");

		
	}

	public static Main getPlugin() {
		return plugin;
	}

			private void registerFiles() {
		   new Files().createDefaultMySQLFile();
		   new Files().createMessageFile();
		 }
			
			private void run() {
				new Loader();
			}
	
}
