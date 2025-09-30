package de.undermain.shop.util;

import java.io.File;
import java.util.HashMap;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import de.undermain.shop.main.Main;




public class files
 {
	
	
	
   public static HashMap<String, String> getObject_config = new HashMap<>();
   public static HashMap<String, String> getObject_villager = new HashMap<>();

   public static HashMap<String, Object> getObject_MySQL = new HashMap<String, Object>();


   

   
   
   public void createConfig() {
       try {
      File File = new File("plugins/Citybuild-System/", "config.yml");
      FileConfiguration cfg = YamlConfiguration.loadConfiguration(File);
      cfg.addDefault("Settings.Prefix", "&6&lDeinServer &8× &7");
      cfg.addDefault("Settings.NoPerm", "&cDazu hast du keine Rechte!");
      cfg.addDefault("Settings.ConsoleMSG", "&cDu musst ein Spieler sein!");
      cfg.addDefault("Settings.TooMuchArgs", "&cZu viele Argumente!");
      cfg.addDefault("Settings.NoCoins", "&c&lDu hast nicht genug Coins!");
      cfg.addDefault("Settings.UnknownCommand.Usage", "true");
      cfg.addDefault("Settings.UnknownCommand.Message", "&c&lDieser Befehl ist unbekannt!");
      cfg.addDefault("Settings.BlockCommands", "true");


      cfg.addDefault("Spawn.Message", "true");
      cfg.addDefault("Spawn.Message.Usage", "true");

      cfg.addDefault("Spawn.Message.Row1", "&b&m---------------------------------------");
      cfg.addDefault("Spawn.Message.Row2", "&7");
      cfg.addDefault("Spawn.Message.Row3", "&7WIlkommen &e%player%&7!");
      cfg.addDefault("Spawn.Message.Row4", "&7");
      cfg.addDefault("Spawn.Message.Row5", "&7» Du hast &a%coins% &7Coins!");
      cfg.addDefault("Spawn.Message.Row6", "&7» Du hast eine Ontime von &a%ontime%&7h");
      cfg.addDefault("Spawn.Message.Row7", "&7» Es sind gerade &a%online% &7Spieler online");
      cfg.addDefault("Spawn.Message.Row8", "&7");
      cfg.addDefault("Spawn.Message.Row9", "&b&m---------------------------------------");

      cfg.addDefault("Spawn.Teleport", "true");
      cfg.addDefault("Spawn.Title", "true");
      cfg.addDefault("Spawn.Title.Usage", "true");
      cfg.addDefault("Spawn.Title.Header", "&bCitybuild");
      cfg.addDefault("Spawn.Title.Footer", "&7Welcome to the Server!");
      
      cfg.addDefault("Coins.Usage", "true");
      cfg.addDefault("Coins.Drop.Every100Blocks", "10");
      cfg.addDefault("Coins.Drop.Message", "Du hast 10 Coins bekommen!");
      cfg.addDefault("Coins.Einheit", "Coins");

      cfg.addDefault("Chat.Usage", "true");
      cfg.addDefault("Chat.OPIsolate", "true");
      cfg.addDefault("Chat.Format", "&3%player% &8» &7%msg%");

      cfg.addDefault("Help.Row1", "&b&m---------------------------------------");
      cfg.addDefault("Help.Row2", "&7");
      cfg.addDefault("Help.Row3", "&7Here you can find the important Commands:");
      cfg.addDefault("Help.Row4", "&7");
      cfg.addDefault("Help.Row5", "&7» &a/coins");
      cfg.addDefault("Help.Row6", "&7» &a/spawn");
      cfg.addDefault("Help.Row7", "&7» &a/shop");
      cfg.addDefault("Help.Row8", "&7» &a/stats");
      cfg.addDefault("Help.Row9", "&7");
      cfg.addDefault("Help.Row10", "&b&m---------------------------------------");

      
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
      File File = new File("plugins/Citybuild-System/", "config.yml");
       FileConfiguration cfg = YamlConfiguration.loadConfiguration(File);
       getObject_config.put("Prefix", "" + cfg.get("Settings.Prefix"));
       getObject_config.put("NoPerm", "" +cfg.get("Settings.NoPerm"));
       getObject_config.put("ConsoleMSG", "" +cfg.get("Settings.ConsoleMSG"));
       getObject_config.put("TooMuchArgs", "" +cfg.get("Settings.TooMuchArgs"));
       getObject_config.put("Einheit", "" +cfg.get("Coins.Einheit"));
       getObject_config.put("NotEnoughCoins", "" +cfg.get("Settings.NoCoins"));
       getObject_config.put("CoinsUsage", "" +cfg.get("Coins.Usage"));
       
       getObject_config.put("UKC", "" +cfg.get("Settings.UnknownCommand.Usage"));
       getObject_config.put("UKCM", "" +cfg.get("Settings.UnknownCommand.Message"));

       getObject_config.put("Block", "" +cfg.get("Settings.BlockCommands"));

       getObject_config.put("SpawnTP", "" +cfg.get("Spawn.Teleport"));
       getObject_config.put("SpawnMSG", "" +cfg.get("Spawn.Message.Usage"));
       getObject_config.put("SpawnMSG1", "" +cfg.get("Spawn.Message.Row1"));
       getObject_config.put("SpawnMSG2", "" +cfg.get("Spawn.Message.Row2"));
       getObject_config.put("SpawnMSG3", "" +cfg.get("Spawn.Message.Row3"));
       getObject_config.put("SpawnMSG4", "" +cfg.get("Spawn.Message.Row4"));
       getObject_config.put("SpawnMSG5", "" +cfg.get("Spawn.Message.Row5"));
       getObject_config.put("SpawnMSG6", "" +cfg.get("Spawn.Message.Row6"));
       getObject_config.put("SpawnMSG7", "" +cfg.get("Spawn.Message.Row7"));
       getObject_config.put("SpawnMSG8", "" +cfg.get("Spawn.Message.Row8"));
       getObject_config.put("SpawnMSG9", "" +cfg.get("Spawn.Message.Row9"));

       
       getObject_config.put("SpawnTitle", "" +cfg.get("Spawn.Title.Usage"));
       getObject_config.put("spawnTitle1", "" +cfg.get("Spawn.Title.Header"));
       getObject_config.put("spawnTitle2", "" +cfg.get("Spawn.Title.Footer"));

       getObject_config.put("ChatManager", "" +cfg.get("Chat.Usage"));
       getObject_config.put("Chat", "" +cfg.get("Chat.Format"));
       getObject_config.put("OP", "" +cfg.get("Chat.OPIsolate"));

       getObject_config.put("Help1", "" +cfg.get("Help.Row1"));
       getObject_config.put("Help2", "" +cfg.get("Help.Row2"));
       getObject_config.put("Help3", "" +cfg.get("Help.Row3"));
       getObject_config.put("Help4", "" +cfg.get("Help.Row4"));
       getObject_config.put("Help5", "" +cfg.get("Help.Row5"));
       getObject_config.put("Help6", "" +cfg.get("Help.Row6"));
       getObject_config.put("Help7", "" +cfg.get("Help.Row7"));
       getObject_config.put("Help8", "" +cfg.get("Help.Row8"));
       getObject_config.put("Help9", "" +cfg.get("Help.Row9"));
       getObject_config.put("Help10", "" +cfg.get("Help.Row10"));

       getObject_config.put("Droprate", "" +cfg.get("Coins.Drop.Every100Blocks"));
       getObject_config.put("DropMSG", "" +cfg.get("Coins.Drop.Message"));

       cfg.save(File);
     } catch (Exception e) {
       if (Main.debug) {
         e.printStackTrace();
      }
     }
   }
   
   public void createDefaultMySQLFile() {
       try {
       File File = new File("plugins/Citybuild-System/", "MySQL.yml");
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
         File File = new File("plugins/Citybuild-System/", "MySQL.yml");
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
   
   public void createDefaultVillagerFile() {
       try {
       File File = new File("plugins/Citybuild-System/", "villager.yml");
      FileConfiguration cfg = YamlConfiguration.loadConfiguration(File);
       
      cfg.addDefault("Items.IronName", "&6&lPremium");
      cfg.addDefault("Items.IronPreis", "100");
      cfg.addDefault("Items.IronCommand", "heal");
      cfg.addDefault("Items.IronText1", "&7&m----------------------");
      cfg.addDefault("Items.IronText2", "&7Du hast nun den &6&lPremium &7Rang");
      cfg.addDefault("Items.IronText3", "&7Dir wurden &e100 &7Coins abgezogen");
      cfg.addDefault("Items.IronText4", "&7Du hast nun &e%coins% &7Coins");
      cfg.addDefault("Items.IronText5", "&7&m----------------------");
      cfg.addDefault("Items.IronLore1", "&7» Dies ist der &6&lPremium &7Rang");
      cfg.addDefault("Items.IronLore2", "&7» Kostet &e100 &7Coins");
      cfg.addDefault("Items.IronLore3", "&7» Dieser ist sehr cool!");

      cfg.addDefault("Items.GoldName", "&b&lPremium +");
      cfg.addDefault("Items.GoldPreis", "400");
      cfg.addDefault("Items.GoldCommand", "coins %player% add 1000");
      cfg.addDefault("Items.GoldText1", "&7&m----------------------");
      cfg.addDefault("Items.GoldText2", "&7Du hast nun den &b&lPremium + &7Rang");
      cfg.addDefault("Items.GoldText3", "&7Dir wurden &e400 &7Coins abgezogen");
      cfg.addDefault("Items.GoldText4", "&7Du hast nun &e%coins% &7Coins");
      cfg.addDefault("Items.GoldText5", "&7&m----------------------");
      cfg.addDefault("Items.GoldLore1", "&7» Dies ist der &b&lPremium+ &7Rang");
      cfg.addDefault("Items.GoldLore2", "&7» Kostet &e400 &7Coins");
      cfg.addDefault("Items.GoldLore3", "&7» Dieser ist sehr cool!");
      
      cfg.addDefault("Items.DiaName", "&4&lGott");
      cfg.addDefault("Items.DiaPreis", "1000");
      cfg.addDefault("Items.DiaCommand", "op %player%");
      cfg.addDefault("Items.DiaText1", "&7&m----------------------");
      cfg.addDefault("Items.DiaText2", "&7Du hast nun den &4&lGott &7Rang");
      cfg.addDefault("Items.DiaText3", "&7Dir wurden &e1000 &7Coins abgezogen");
      cfg.addDefault("Items.DiaText4", "&7Du hast nun &e%coins% &7Coins");
      cfg.addDefault("Items.DiaText5", "&7&m----------------------");
      cfg.addDefault("Items.DiaLore1", "&7» Dies ist der &4&lGott&7 Rang");
      cfg.addDefault("Items.DiaLore2", "&7» Kostet &e1000 &7Coins");
      cfg.addDefault("Items.DiaLore3", "&7» Dieser ist sehr cool!");
       
       cfg.options().copyDefaults(true);
       cfg.save(File);
     } catch (Exception e) {
       if (Main.debug) {
         e.printStackTrace();
       }
     }
  }
   
   public void loadDefaultVillagerFile() {
     try {
      File File = new File("plugins/Citybuild-System/", "villager.yml");
       FileConfiguration cfg = YamlConfiguration.loadConfiguration(File);
       
       getObject_villager.put("IronName", "" +cfg.get("Items.IronName"));
       getObject_villager.put("IronPreis", "" +cfg.get("Items.IronPreis"));
       getObject_villager.put("IronCommand", "" +cfg.get("Items.IronCommand"));
       getObject_villager.put("IronText1", "" +cfg.get("Items.IronText1"));
       getObject_villager.put("IronText2", "" +cfg.get("Items.IronText2"));
       getObject_villager.put("IronText3", "" +cfg.get("Items.IronText3"));
       getObject_villager.put("IronText4", "" +cfg.get("Items.IronText4"));
       getObject_villager.put("IronText5", "" +cfg.get("Items.IronText5"));
       getObject_villager.put("IronLore1", "" +cfg.get("Items.IronLore1"));
       getObject_villager.put("IronLore2", "" +cfg.get("Items.IronLore2"));
       getObject_villager.put("IronLore3", "" +cfg.get("Items.IronLore3"));

       getObject_villager.put("GoldName", "" +cfg.get("Items.GoldName"));
       getObject_villager.put("GoldPreis", "" +cfg.get("Items.GoldPreis"));
       getObject_villager.put("GoldCommand", "" +cfg.get("Items.GoldCommand"));
       getObject_villager.put("GoldText1", "" +cfg.get("Items.GoldText1"));
       getObject_villager.put("GoldText2", "" +cfg.get("Items.GoldText2"));
       getObject_villager.put("GoldText3", "" +cfg.get("Items.GoldText3"));
       getObject_villager.put("GoldText4", "" +cfg.get("Items.GoldText4"));
       getObject_villager.put("GoldText5", "" +cfg.get("Items.GoldText5"));
       getObject_villager.put("GoldLore1", "" +cfg.get("Items.GoldLore1"));
       getObject_villager.put("GoldLore2", "" +cfg.get("Items.GoldLore2"));
       getObject_villager.put("GoldLore3", "" +cfg.get("Items.GoldLore3"));
       
       getObject_villager.put("DiaName", "" +cfg.get("Items.DiaName"));
       getObject_villager.put("DiaPreis", "" +cfg.get("Items.DiaPreis"));
       getObject_villager.put("DiaCommand", "" +cfg.get("Items.DiaCommand"));
       getObject_villager.put("DiaText1", "" +cfg.get("Items.DiaText1"));
       getObject_villager.put("DiaText2", "" +cfg.get("Items.DiaText2"));
       getObject_villager.put("DiaText3", "" +cfg.get("Items.DiaText3"));
       getObject_villager.put("DiaText4", "" +cfg.get("Items.DiaText4"));
       getObject_villager.put("DiaText5", "" +cfg.get("Items.DiaText5"));
       getObject_villager.put("DiaLore1", "" +cfg.get("Items.DiaLore1"));
       getObject_villager.put("DiaLore2", "" +cfg.get("Items.DiaLore2"));
       getObject_villager.put("DiaLore3", "" +cfg.get("Items.DiaLore3"));
       
       cfg.save(File);
     } catch (Exception e) {
       if (Main.debug) {
         e.printStackTrace();
      }
     }
   }
			

}
