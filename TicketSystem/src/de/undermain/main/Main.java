package de.undermain.main;


import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import de.undermain.mysql.MySQL;
import de.undermain.commands.ticket;
import de.undermain.config.files;
import de.undermain.main.Main;

public class Main extends JavaPlugin {
	
			private void registerFiles() {
					new files().createDefaultMySQLFile();
					new files().createMessageFile();
				}
			
			private void run() {
					new files().loadDefaultMySQLFile();
			     	new files().loadMessageFile();;
				}
			
			public static Main getPlugin() {
					return plugin;
				}
	
	
			public static Main instance;
			private static Main plugin;
			
			public static boolean debug;
	
		public void onEnable() {
				
				instance = this;
		
				registerFiles();
				run();
				MySQL.connect();
				
				//Bukkit.getPluginManager().registerEvents(new Join(), this);
				
				getCommand("ticket").setExecutor(new ticket());
				
				
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
				Bukkit.getConsoleSender().sendMessage("§3§lPlugin-Version: §c§l1.0");
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
			
			
		
			public void onDisable() {
				
				
				
			}
			
}
