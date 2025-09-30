package de.undermain.main;


import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import de.undermain.commands.chatclear;
import de.undermain.commands.creative;
import de.undermain.commands.heal;
import de.undermain.commands.item;
import de.undermain.commands.lizenzinfo;
import de.undermain.commands.ontime;
import de.undermain.commands.setspawn;
import de.undermain.commands.sign;
import de.undermain.commands.spawn;
import de.undermain.commands.survival;
import de.undermain.commands.ufc;
import de.undermain.config.files;
import de.undermain.config.ip;
import de.undermain.config.locationManager;
import de.undermain.listener.JoinQuitListener;
import de.undermain.listener.deathListener;
import de.undermain.mysql.MySQL;
import de.undermain.mysql.MySQLL;
import de.undermain.mysql.qrys;

public class Main extends JavaPlugin{
	private static Main plugin;

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
			public static boolean debug;
			public static boolean legal;
			public static locationManager lm;

			public void onEnable() {
				

				setPlugin(this);
				instance = this;
				registerFiles();
				run();
				MySQL.connect();
				MySQLL.connect();
				
				lm = new locationManager();

				getCommand("lizenzinfo").setExecutor(new lizenzinfo());
				getCommand("c").setExecutor(new creative());
				getCommand("s").setExecutor(new survival());
				getCommand("item").setExecutor(new item());
				getCommand("cc").setExecutor(new chatclear());
				getCommand("heal").setExecutor(new heal());
				getCommand("sign").setExecutor(new sign());
				getCommand("setspawn").setExecutor(new setspawn());
				getCommand("spawn").setExecutor(new spawn());
				getCommand("ufc").setExecutor(new ufc());
				getCommand("ontime").setExecutor(new ontime());

			    getServer().getPluginManager().registerEvents(new JoinQuitListener(), this);
			    getServer().getPluginManager().registerEvents(new deathListener(), this);


				int an = qrys.getRows();

				if(an == 1) {

					try {
						if(ip.getIp().equals(qrys.ip()) || qrys.ip() == null) {
							qrys.setIP(ip.getIp());
							legal = true;

							Bukkit.getConsoleSender().sendMessage("");
							Bukkit.getConsoleSender().sendMessage("");
							Bukkit.getConsoleSender().sendMessage("");
							Bukkit.getConsoleSender().sendMessage("");
							Bukkit.getConsoleSender().sendMessage("");
							Bukkit.getConsoleSender().sendMessage("");
							Bukkit.getConsoleSender().sendMessage("");
							Bukkit.getConsoleSender().sendMessage("§3§l___________________________________________________________");
							Bukkit.getConsoleSender().sendMessage(" ");
							Bukkit.getConsoleSender().sendMessage("§6§lUFC - utilities for citybuild §a§lwurde aktiviert!");
							Bukkit.getConsoleSender().sendMessage("");
							Bukkit.getConsoleSender().sendMessage("§3§lAuthor: §b§lUnderMain.de");
							Bukkit.getConsoleSender().sendMessage("");
							Bukkit.getConsoleSender().sendMessage("§3§lPlugin-Version: §c§l1.0");
							Bukkit.getConsoleSender().sendMessage("");
							Bukkit.getConsoleSender().sendMessage("§3§lLizenz:  Aktiv & gebunden!");
							Bukkit.getConsoleSender().sendMessage("");
							Bukkit.getConsoleSender().sendMessage("§3§lLizenzserver: " + MySQL.msgg);
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
					Bukkit.getPluginManager().disablePlugin(this); 

				}
				
				}		
		
				
				
				
			
			
			public void onDisable() {
				
			}
			
		   
	   
	   }
	

