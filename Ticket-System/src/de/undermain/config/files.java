package de.undermain.config;

import java.io.File;
import java.util.HashMap;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import de.undermain.main.Main;

public class files
{
  public static HashMap<String, Object> getObject_MySQL = new HashMap<String, Object>();
  public static HashMap<String, Object> getObject_Messages = new HashMap<String, Object>();


  public void createDefaultMySQLFile() {
      try {
      File File = new File("plugins/Ticket-System/", "MySQL.yml");
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
     File File = new File("plugins/Ticket-System/", "MySQL.yml");
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
  
	public void createMessageFile() {
		
		try {
			File file = new File("plugins/Ticket-System/", "config.yml");
			FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
			
			cfg.addDefault("Server.Prefix", "§6§lTicket-System §8× §r");
			cfg.addDefault("Server.NoPerm", "§c§lKeine Rechte!");

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
			File file = new File("plugins/Ticket-System/", "config.yml");
			FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
			
			getObject_Messages.put("Prefix", cfg.get("Server.Prefix"));
			getObject_Messages.put("NoPerm", cfg.get("Server.NoPerm"));

			cfg.save(file);
			
		}catch (Exception e) {
			
			if (Main.debug) {
			   e.printStackTrace();
			}
		}
		
	}
			

		


 }


