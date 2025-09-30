package de.stats.undermain.Main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


import de.stats.undermain.all.files;
import de.stats.undermain.all.ip;
import de.stats.undermain.mysql.MySQLL;
import de.stats.undermain.mysql.mysql;
import de.stats.undermain.mysql.qrys;


public class Main extends JavaPlugin{

	public static int taskID;
	private void registerFiles() {
		new files().createDefaultLizenz();
		new files().createConfig();
		new files().createDefaultMySQLFile();
	}
	private void run() {
			new files().loadDefaultLizenz();
		     new files().loadConfig();
		     new files().loadDefaultMySQLFile();
		}
	public static Main getPlugin() {
		return plugin;
	}
	public static void setPlugin(Main plugin) {
	    Main.plugin = plugin;
	}
	public static Main instance;
	private static Main plugin;
	public static boolean debug;
	
	public void onEnable() {
		setPlugin(this);
		instance = this;
		registerFiles();
		run();
		MySQLL.connect();
		mysql.connect();
		int an = qrys.getRows();
		if(an == 1) {

			try {
				if(ip.getIp().equals(qrys.ip()) || qrys.ip() == null) {
					qrys.setIP(ip.getIp());
					Bukkit.getConsoleSender().sendMessage("");
					Bukkit.getConsoleSender().sendMessage("");
					Bukkit.getConsoleSender().sendMessage("");
					Bukkit.getConsoleSender().sendMessage("");
					Bukkit.getConsoleSender().sendMessage("");
					Bukkit.getConsoleSender().sendMessage("");
					Bukkit.getConsoleSender().sendMessage("");
					Bukkit.getConsoleSender().sendMessage("§3§l___________________________________________________________");
					Bukkit.getConsoleSender().sendMessage(" ");
					Bukkit.getConsoleSender().sendMessage("§6§Stats!");
					Bukkit.getConsoleSender().sendMessage("");
					Bukkit.getConsoleSender().sendMessage("§3§lAuthor: §b§lUnderMain.de");
					Bukkit.getConsoleSender().sendMessage("");
					Bukkit.getConsoleSender().sendMessage("§3§lPlugin-Version: §c§l1.0");
					Bukkit.getConsoleSender().sendMessage("");
					Bukkit.getConsoleSender().sendMessage("§3§lLizenz:  Aktiv & gebunden!");
					Bukkit.getConsoleSender().sendMessage("");
					Bukkit.getConsoleSender().sendMessage("§3§lLizenzserver: " + mysql.msgg);
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
					Bukkit.getConsoleSender().sendMessage("");
					
				}else {
					Bukkit.getConsoleSender().sendMessage("");
					Bukkit.getConsoleSender().sendMessage("");
					Bukkit.getConsoleSender().sendMessage("");
					Bukkit.getConsoleSender().sendMessage("");
					Bukkit.getConsoleSender().sendMessage("");
					Bukkit.getConsoleSender().sendMessage("");
					Bukkit.getConsoleSender().sendMessage("");
					Bukkit.getConsoleSender().sendMessage("");
					Bukkit.getConsoleSender().sendMessage("§3§l___________________________________________________________");
					Bukkit.getConsoleSender().sendMessage("");
					Bukkit.getConsoleSender().sendMessage("§c§lDie Lizenz ist an eine andere IP gebunden! ");
					Bukkit.getConsoleSender().sendMessage("§c§lundermain.de wird benachrichtigt!");
					Bukkit.getConsoleSender().sendMessage("");
					Bukkit.getConsoleSender().sendMessage("§3§lStatus:  §c§lInfos des Leakers an undermain.de übermittelt");
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
					Bukkit.getPluginManager().disablePlugin(this); 
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			
			Bukkit.getConsoleSender().sendMessage("");
			Bukkit.getConsoleSender().sendMessage("");
			Bukkit.getConsoleSender().sendMessage("");
			Bukkit.getConsoleSender().sendMessage("");
			Bukkit.getConsoleSender().sendMessage("");
			Bukkit.getConsoleSender().sendMessage("");
			Bukkit.getConsoleSender().sendMessage("");
			Bukkit.getConsoleSender().sendMessage("");
			Bukkit.getConsoleSender().sendMessage("§3§l___________________________________________________________");
			Bukkit.getConsoleSender().sendMessage("");
			Bukkit.getConsoleSender().sendMessage("§c§lDie eingegebene Lizenz, der Name oder die Email sind/ist falsch!");
			Bukkit.getConsoleSender().sendMessage("");
			Bukkit.getConsoleSender().sendMessage("§3§lStatus: " + mysql.msgg);
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
			Bukkit.getPluginManager().disablePlugin(this); 

		}
		
		
	}
	public void onDisable() {
		
	}
	
}
