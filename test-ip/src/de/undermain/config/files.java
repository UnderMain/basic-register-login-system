package de.undermain.config;

import java.io.File;
import java.util.HashMap;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import de.undermain.main.Main;


public class files
 {
	
	
	
   public static HashMap<String, String> getObject_lizenz = new HashMap<>();
   public static HashMap<String, String> getObject_config = new HashMap<>();
   public static HashMap<String, Object> getObject_MySQL = new HashMap<String, Object>();

   public void createDefaultLizenz() {
       try {
      File File = new File("plugins/UFC/", "Lizenz.yml");
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
      File File = new File("plugins/UFC/", "Lizenz.yml");
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
      File File = new File("plugins/UFC/", "config.yml");
      FileConfiguration cfg = YamlConfiguration.loadConfiguration(File);
      
       cfg.addDefault("Switch.JoinMessage", "true");
       cfg.addDefault("Switch.QuitMessage", "true");
       cfg.addDefault("Switch.ChatManager", "true");
       cfg.addDefault("Switch.Scoreboard", "true");
       cfg.addDefault("Switch.SpawnTeleport", "true");
       cfg.addDefault("Switch.SpawnNachricht", "true");
       cfg.addDefault("Switch.SpawnTitle", "true");
       cfg.addDefault("Switch.UnknownCommand", "true");
       cfg.addDefault("Switch.OPimChatHervorheben", "true");
       cfg.addDefault("Switch.PluginsUndHelpBlock", "true");

       cfg.addDefault("Settings.Prefix", "&6&lDeinServer &8× &7");
       cfg.addDefault("Settings.NoPerm", "&cDazu hast du keine Rechte!");
       cfg.addDefault("Settings.ConsoleMSG", "&cDu musst ein Spieler sein!");
       cfg.addDefault("Settings.TooMuchArgs", "&cZu viele Argumente!");
       cfg.addDefault("Settings.JoinMessages", "&7Der Spieler &b%player%&7 ist dem Server beigetreten!");
       cfg.addDefault("Settings.QuitMessages", "&7Der Spieler &b%player%&7 hat den Server verlassen!");
       cfg.addDefault("Settings.Chat", "&6%player% &7» &b%msg%");
       cfg.addDefault("Settings.Sign", "&7Signiert von &a%player% &7am §a%date%");
       cfg.addDefault("Settings.UnknownCommand", "&7Der Befehl ×&b&l %cmd% &7× existiert nicht!");
       cfg.addDefault("Settings.SpawnTitleZeile1", "&7&l×&b&l Citybuild &7&l×");
       cfg.addDefault("Settings.SpawnTitleZeile2", "&7Viel Spaß beim bauen!");

       cfg.addDefault("SpawnNachricht.SZeile1", "&7&m---------------------------------");
       cfg.addDefault("SpawnNachricht.SZeile2", "");
       cfg.addDefault("SpawnNachricht.SZeile3", "&3&lWilkommen auf dem Server,");
       cfg.addDefault("SpawnNachricht.SZeile4", "&a&l%player%");
       cfg.addDefault("SpawnNachricht.SZeile5", "");
       cfg.addDefault("SpawnNachricht.SZeile6", "&7&m---------------------------------");
       
       cfg.addDefault("Scoreboard.Titel", "&7&m----&a&lUFC&7&m----");
       cfg.addDefault("Scoreboard.Zeile1", "-");
       cfg.addDefault("Scoreboard.Zeile2", "&7» &6Name:");
       cfg.addDefault("Scoreboard.Zeile3", "&a× %name%");
       cfg.addDefault("Scoreboard.Zeile4", "-");
       cfg.addDefault("Scoreboard.Zeile5", "&7» &6Online:");
       cfg.addDefault("Scoreboard.Zeile6", "&a× %online%");
       cfg.addDefault("Scoreboard.Zeile7", "-");

       cfg.addDefault("Help.Help1", "&7&m---------------------------------");
       cfg.addDefault("Help.Help2", "");
       cfg.addDefault("Help.Help3", "&7× &bHilfe &7×");
       cfg.addDefault("Help.Help4", "&7");
       cfg.addDefault("Help.Help5", "&7 - &b/befehl1");
       cfg.addDefault("Help.Help6", "&7 - &b/befehl2");
       cfg.addDefault("Help.Help7", "&7 - &b/befehl3");
       cfg.addDefault("Help.Help8", "&7 - &b/befehl4");
       cfg.addDefault("Help.Help9", "");
       cfg.addDefault("Help.Help10", "&7&m---------------------------------");

       
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
      File File = new File("plugins/UFC/", "config.yml");
       FileConfiguration cfg = YamlConfiguration.loadConfiguration(File);
      
       getObject_config.put("JoinMessage", "" +cfg.get("Switch.JoinMessage"));
       getObject_config.put("QuitMessage", "" +cfg.get("Switch.QuitMessage"));
       getObject_config.put("ChatManager", "" +cfg.get("Switch.ChatManager"));
       getObject_config.put("Scoreboard", "" +cfg.get("Switch.Scoreboard"));
       getObject_config.put("SpawnTP", "" +cfg.get("Switch.SpawnTeleport"));
       getObject_config.put("SpawnMSG", "" +cfg.get("Switch.SpawnNachricht"));
       getObject_config.put("SpawnTitle", "" +cfg.get("Switch.SpawnTitle"));
       getObject_config.put("ukcON", "" +cfg.get("Switch.UnknownCommand"));
       getObject_config.put("OP", "" +cfg.get("Switch.OPimChatHervorheben"));
       getObject_config.put("Block", "" +cfg.get("Switch.PluginsUndHelpBlock"));

       getObject_config.put("Prefix", "" + cfg.get("Settings.Prefix"));
       getObject_config.put("NoPerm", "" +cfg.get("Settings.NoPerm"));
       getObject_config.put("ConsoleMSG", "" +cfg.get("Settings.ConsoleMSG"));
       getObject_config.put("TooMuchArgs", "" +cfg.get("Settings.TooMuchArgs"));
       getObject_config.put("JoinMessages", "" +cfg.get("Settings.JoinMessages"));
       getObject_config.put("QuitMessages", "" +cfg.get("Settings.QuitMessages"));
       getObject_config.put("Chat", "" +cfg.get("Settings.Chat"));
       getObject_config.put("Sign", "" +cfg.get("Settings.Sign"));
       getObject_config.put("UKC", "" +cfg.get("Settings.UnknownCommand"));
       getObject_config.put("SpawnT1", "" +cfg.get("Settings.SpawnTitleZeile1"));
       getObject_config.put("SpawnT2", "" +cfg.get("Settings.SpawnTitleZeile2"));


       getObject_config.put("SZeile1", "" +cfg.get("SpawnNachricht.SZeile1"));
       getObject_config.put("SZeile2", "" +cfg.get("SpawnNachricht.SZeile2"));
       getObject_config.put("SZeile3", "" +cfg.get("SpawnNachricht.SZeile3"));
       getObject_config.put("SZeile4", "" +cfg.get("SpawnNachricht.SZeile4"));
       getObject_config.put("SZeile5", "" +cfg.get("SpawnNachricht.SZeile5"));
       getObject_config.put("SZeile6", "" +cfg.get("SpawnNachricht.SZeile6"));
       
       getObject_config.put("Zeile1", "" +cfg.get("Scoreboard.Zeile1"));
       getObject_config.put("Zeile2", "" +cfg.get("Scoreboard.Zeile2"));
       getObject_config.put("Zeile3", "" +cfg.get("Scoreboard.Zeile3"));
       getObject_config.put("Zeile4", "" +cfg.get("Scoreboard.Zeile4"));
       getObject_config.put("Zeile5", "" +cfg.get("Scoreboard.Zeile5"));
       getObject_config.put("Zeile6", "" +cfg.get("Scoreboard.Zeile6"));       
       getObject_config.put("Zeile7", "" +cfg.get("Scoreboard.Zeile7"));
       getObject_config.put("Titel", "" +cfg.get("Scoreboard.Titel"));

       getObject_config.put("Help1", "" +cfg.get("Help.Help1"));
       getObject_config.put("Help2", "" +cfg.get("Help.Help2"));
       getObject_config.put("Help3", "" +cfg.get("Help.Help3"));
       getObject_config.put("Help4", "" +cfg.get("Help.Help4"));
       getObject_config.put("Help5", "" +cfg.get("Help.Help5"));
       getObject_config.put("Help6", "" +cfg.get("Help.Help6"));       
       getObject_config.put("Help7", "" +cfg.get("Help.Help7"));
       getObject_config.put("Help8", "" +cfg.get("Help.Help8"));
       getObject_config.put("Help9", "" +cfg.get("Help.Help9"));
       getObject_config.put("Help10", "" +cfg.get("Help.Help10"));


       cfg.save(File);
     } catch (Exception e) {
       if (Main.debug) {
         e.printStackTrace();
      }
     }
   }
   
   public void createDefaultMySQLFile() {
       try {
       File File = new File("plugins/UFC/", "MySQL.yml");
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
      File File = new File("plugins/UFC/", "MySQL.yml");
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

