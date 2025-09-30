package de.stats.undermain.all;

import java.io.File;
import java.util.HashMap;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import de.stats.undermain.Main.Main;



public class files
 {
	
	
	
   public static HashMap<String, String> getObject_lizenz = new HashMap<>();
   public static HashMap<String, String> getObject_config = new HashMap<>();
   public static HashMap<String, Object> getObject_MySQL = new HashMap<String, Object>();

   public void createDefaultLizenz() {
       try {
      File File = new File("plugins/STATS/", "Lizenz.yml");
      FileConfiguration cfg = YamlConfiguration.loadConfiguration(File);
       
       cfg.addDefault("Infos.Lizenz", "XX-XX-XX-XX");
       cfg.addDefault("Infos.Name", "name");
       cfg.addDefault("Infos.Email", "email");

       
       cfg.options().copyDefaults(true);
       cfg.save(File);
     } catch (Exception e) {
       if (Main.debug) {
         e.printStackTrace();
       }
     }
  }
   
   public void loadDefaultLizenz() {
     try {
      File File = new File("plugins/STATS/", "Lizenz.yml");
       FileConfiguration cfg = YamlConfiguration.loadConfiguration(File);
       
       getObject_lizenz.put("Lizenz", "" + cfg.get("Infos.Lizenz"));
       getObject_lizenz.put("Name", "" +cfg.get("Infos.Name"));
       getObject_lizenz.put("Email","" + cfg.get("Infos.Email"));

       
       cfg.save(File);
     } catch (Exception e) {
       if (Main.debug) {
         e.printStackTrace();
      }
     }
   }
   
   
   public void createConfig() {
       try {
      File File = new File("plugins/STATS/", "config.yml");
      FileConfiguration cfg = YamlConfiguration.loadConfiguration(File);
      cfg.addDefault("Settings.Prefix", "&6&lDeinServer &8× &7");
      cfg.addDefault("Settings.NoPerm", "&cDazu hast du keine Rechte!");
      cfg.addDefault("Settings.ConsoleMSG", "&cDu musst ein Spieler sein!");
      cfg.addDefault("Settings.TooMuchArgs", "&cZu viele Argumente!");
      cfg.addDefault("Settings.CoinsEinheit", "Coins");

       cfg.options().copyDefaults(true);
       cfg.save(File);
     } catch (Exception e) {
       if (Main.debug) {
         e.printStackTrace();
       }
     }
  }
   
   public void loadConfig() {
     try {
      File File = new File("plugins/STATS/", "config.yml");
       FileConfiguration cfg = YamlConfiguration.loadConfiguration(File);
       getObject_config.put("Prefix", "" + cfg.get("Settings.Prefix"));
       getObject_config.put("NoPerm", "" +cfg.get("Settings.NoPerm"));
       getObject_config.put("ConsoleMSG", "" +cfg.get("Settings.ConsoleMSG"));
       getObject_config.put("TooMuchArgs", "" +cfg.get("Settings.TooMuchArgs"));
       getObject_config.put("Einheit", "" +cfg.get("Settings.CoinsEinheit"));

       cfg.save(File);
     } catch (Exception e) {
       if (Main.debug) {
         e.printStackTrace();
      }
     }
   }
   
   public void createDefaultMySQLFile() {
       try {
       File File = new File("plugins/STATS/", "MySQL.yml");
      FileConfiguration cfg = YamlConfiguration.loadConfiguration(File);
       
       cfg.addDefault("MySQL.Host", "localhost");
       cfg.addDefault("MySQL.Port", Integer.valueOf(3306));
       cfg.addDefault("MySQL.Database", "database");
       cfg.addDefault("MySQL.User", "root");
       cfg.addDefault("MySQL.Password", "password");
       
       cfg.options().copyDefaults(true);
       cfg.save(File);
     } catch (Exception e) {
       if (Main.debug) {
         e.printStackTrace();
       }
     }
  }
   
   public void loadDefaultMySQLFile() {
     try {
      File File = new File("plugins/STATS/", "MySQL.yml");
       FileConfiguration cfg = YamlConfiguration.loadConfiguration(File);
       
      getObject_MySQL.put("Host", cfg.get("MySQL.Host"));
       getObject_MySQL.put("Port", cfg.get("MySQL.Port"));
       getObject_MySQL.put("Database", cfg.get("MySQL.Database"));
       getObject_MySQL.put("User", cfg.get("MySQL.User"));
       getObject_MySQL.put("Password", cfg.get("MySQL.Password"));
       
       cfg.save(File);
     } catch (Exception e) {
       if (Main.debug) {
         e.printStackTrace();
      }
     }
   }
			

}

