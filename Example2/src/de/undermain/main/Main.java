package de.undermain.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import de.undermain.config.files;
import de.undermain.config.ip;
import de.undermain.config.messages;
import de.undermain.mysql.MySQL;
import de.undermain.mysql.MySQLL;
import de.undermain.mysql.qrys;


public class Main extends JavaPlugin {

	public static Main instance;
	private static Main plugin;
	public static boolean debug;
	
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
	
	public void onEnable() {
		setPlugin(this);
		instance = this;
		registerFiles();
		run();
		
		MySQL.connect();
		MySQLL.connect();
		
		int an = qrys.getRows();
		
		if(an == 1) {
			try {
				if(ip.getIp().equals(qrys.ip()) || qrys.ip() == null) {
					qrys.setIP(ip.getIp());
					messages.plugin("UnderMain", "1.1", "UnderMain");					
				}else {
					messages.leak();
					Bukkit.getPluginManager().disablePlugin(this); 
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			messages.faslch();
			Bukkit.getPluginManager().disablePlugin(this); 
		}

		}		

	
}
