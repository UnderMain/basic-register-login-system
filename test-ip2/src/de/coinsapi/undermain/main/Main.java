package de.coinsapi.undermain.main;



import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import de.coinsapi.undermain.commands.coins;
import de.coinsapi.undermain.config.files;
import de.coinsapi.undermain.config.ip;
import de.coinsapi.undermain.listener.joinListener;
import de.coinsapi.undermain.mysql.MySQL;
import de.coinsapi.undermain.mysql.MySQLL;
import de.coinsapi.undermain.mysql.qrys;



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

			public int getCoins() {
				
				return 0;
			}
			
			
			public void onEnable() {
				setPlugin(this);
				instance = this;
				registerFiles();
				run();
				MySQLL.connect();
				MySQL.connect();
				int an = qrys.getRows();
				getCommand("coins").setExecutor(new coins());
			    getServer().getPluginManager().registerEvents(new joinListener(), this);
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
							Bukkit.getConsoleSender().sendMessage("§6§lCoinsAPI!");
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
	

