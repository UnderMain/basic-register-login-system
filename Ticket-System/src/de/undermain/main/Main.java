package de.undermain.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import de.undermain.config.files;
import de.undermain.mysql.MySQL;

public class Main extends JavaPlugin {
	
	
	public static boolean debug;
	
	public static Main instance;
	
	private static Main plugin;
	
	//Die Config Files werden erstellt
	private void registerFiles() {
		new files().createDefaultMySQLFile();
		new files().createMessageFile();
	}

	//Die Files werden geladen
	private void run() {
			new files().loadDefaultMySQLFile();
	     	new files().loadMessageFile();;
		}


	public static Main getPlugin() {
			return plugin;
		}

	public void onEnable() {
		
		instance = this;

		registerFiles();
		run();
		MySQL.connect();
		
		//Bukkit.getPluginManager().registerEvents(new Join(), this);
		
		getCommand("setlogin").setExecutor(new setLogin());
		getCommand("status").setExecutor(new status());
		getCommand("check").setExecutor(new check());
		getCommand("deluser").setExecutor(new deleteUser());



		
		
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
		Bukkit.getConsoleSender().sendMessage("§a§lTicket-System wurde aktiviert!");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("§3§lAuthor: §b§lUnderMain / Zenit-Netzwerk.de");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("§3§lPlugin-Version: §c§l1.1");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("§3§lLizenz: §7§lStandart");
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
	
}
