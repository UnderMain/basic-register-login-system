package de.undermain.base.files;

import java.io.File;
import java.util.HashMap;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import de.undermain.base.main.Main;


public class files
{
	


  public static HashMap<String, Object> getObject_config = new HashMap<String, Object>();

  
  public void createDefaultMySQLFile() {
      try {
      File File = new File("plugins/undermain/base/", "config.yml");
     FileConfiguration cfg = YamlConfiguration.loadConfiguration(File);
      
      cfg.addDefault("MySQL.Host", "localhost");
      cfg.addDefault("MySQL.Port", Integer.valueOf(3306));
      cfg.addDefault("MySQL.Database", "database");
      cfg.addDefault("MySQL.User", "root");
      cfg.addDefault("MySQL.Password", "password");
      cfg.addDefault("General.Prefix", "&6&lDeinServer &8× &7");
      cfg.addDefault("General.CoinUnit", "$");

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
        File File = new File("plugins/undermain/base/", "config.yml");
      FileConfiguration cfg = YamlConfiguration.loadConfiguration(File);
      
     getObject_config.put("Host", cfg.get("MySQL.Host"));
     getObject_config.put("Port", cfg.get("MySQL.Port"));
     getObject_config.put("Database", cfg.get("MySQL.Database"));
     getObject_config.put("User", cfg.get("MySQL.User"));
     getObject_config.put("Password", cfg.get("MySQL.Password"));
     getObject_config.put("Prefix", cfg.get("General.Prefix"));
     getObject_config.put("CoinUnit", cfg.get("General.CoinUnit"));

      cfg.save(File);
    } catch (Exception e) {
      if (Main.debug) {
        e.printStackTrace();
     }
    }
  }
  
 
  }
			


