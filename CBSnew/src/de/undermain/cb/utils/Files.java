package de.undermain.cb.utils;

import java.io.File;
import java.util.HashMap;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import de.undermain.cb.main.Main;


/*    */ public class Files
/*    */ {
/* 11 */   public static HashMap<String, Object> getObject_MySQL = new HashMap<String, Object>();
/*    */    public static HashMap<String, Object> getObject_Messages = new HashMap<String, Object>();

/*    */   public void createDefaultMySQLFile() {
/*    */     try {
/* 15 */       File File = new File("plugins/CB-System/", "MySQL.yml");
/* 16 */       FileConfiguration cfg = YamlConfiguration.loadConfiguration(File);
/*    */       
/* 18 */       cfg.addDefault("MySQL.Host", "localhost");
/* 19 */       cfg.addDefault("MySQL.Port", Integer.valueOf(3306));
/* 20 */       cfg.addDefault("MySQL.Database", "database");
/* 21 */       cfg.addDefault("MySQL.User", "root");
/* 22 */       cfg.addDefault("MySQL.Password", "password");
/*    */       
/* 24 */       cfg.options().copyDefaults(true);
/* 25 */       cfg.save(File);
/*    */     } catch (Exception e) {
/* 27 */       if (Main.debug) {
/* 28 */         e.printStackTrace();
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public void loadDefaultMySQLFile() {
/*    */     try {
/* 35 */       File File = new File("plugins/CB-System/", "MySQL.yml");
/* 36 */       FileConfiguration cfg = YamlConfiguration.loadConfiguration(File);
/*    */       
/* 38 */       getObject_MySQL.put("Host", cfg.get("MySQL.Host"));
/* 39 */       getObject_MySQL.put("Port", cfg.get("MySQL.Port"));
/* 40 */       getObject_MySQL.put("Database", cfg.get("MySQL.Database"));
/* 41 */       getObject_MySQL.put("User", cfg.get("MySQL.User"));
/* 42 */       getObject_MySQL.put("Password", cfg.get("MySQL.Password"));
/*    */       
/* 44 */       cfg.save(File);
/*    */     } catch (Exception e) {
/* 46 */       if (Main.debug) {
/* 47 */         e.printStackTrace();
/*    */       }
/*    */     }
/*    */   }
			
		public void createMessageFile() {
			
			try {
				File file = new File("plugins/CB-System/", "messages.yml");
				FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
				
				cfg.addDefault("Tablist.Header", "§f \n §aWillkommen, §e §aauf Deine.EU! \n §f");
				cfg.addDefault("Tablist.Footer", "§f \\n §bErlebe CityBuild in neuer Art und Weise! \\n §f");
				cfg.addDefault("Messages.Spawn", "§aDu bist nun beim §eSpawn§a.");

				 cfg.options().copyDefaults(true);
				cfg.save(file);
				
			}catch (Exception e) {
				
				if (Main.debug) {
				   e.printStackTrace();
				}
			}
			
		}
		
		public void loadMessageFile() {
			
			try {
				File file = new File("plugins/CB-System/", "messages.yml");
				FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
				
				getObject_Messages.put("Tablist.Header", cfg.get("Join.Header"));
				getObject_Messages.put("Tablist.Footer", cfg.get("Join.Footer"));
				getObject_Messages.put("Messages.Spawn", cfg.get("Spawn.Spawn"));

				
				cfg.save(file);
				
			}catch (Exception e) {
				
				if (Main.debug) {
				   e.printStackTrace();
				}
			}
			
		}

/*    */ }

