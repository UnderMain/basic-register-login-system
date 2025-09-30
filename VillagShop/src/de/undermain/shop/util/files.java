package de.undermain.shop.util;

import java.io.File;
import java.util.HashMap;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import de.undermain.shop.main.Main;




public class files
 {
	
	
	
   public static HashMap<String, String> getObject_config = new HashMap<>();
   public static HashMap<String, Object> getObject_MySQL = new HashMap<String, Object>();


   

   
   
   public void createConfig() {
       try {
      File File = new File("plugins/Villager-Shop/", "config.yml");
      FileConfiguration cfg = YamlConfiguration.loadConfiguration(File);
      cfg.addDefault("Settings.Prefix", "&6&lDeinServer &8× &7");
      cfg.addDefault("Settings.NoPerm", "&cDazu hast du keine Rechte!");
      cfg.addDefault("Settings.ConsoleMSG", "&cDu musst ein Spieler sein!");
      cfg.addDefault("Settings.TooMuchArgs", "&cZu viele Argumente!");
      cfg.addDefault("Settings.CoinsEinheit", "Coins");
      cfg.addDefault("Settings.NoCoins", "&c&lDu hast nicht genug Coins!");
      cfg.addDefault("Settings.CoinsUsage", "yes");

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

      cfg.addDefault("Coins.Drop100Blocks", "10");
      cfg.addDefault("Coins.DropMessage", "Du hast 10 Coins bekommen!");

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
      File File = new File("plugins/Villager-Shop/", "config.yml");
       FileConfiguration cfg = YamlConfiguration.loadConfiguration(File);
       getObject_config.put("Prefix", "" + cfg.get("Settings.Prefix"));
       getObject_config.put("NoPerm", "" +cfg.get("Settings.NoPerm"));
       getObject_config.put("ConsoleMSG", "" +cfg.get("Settings.ConsoleMSG"));
       getObject_config.put("TooMuchArgs", "" +cfg.get("Settings.TooMuchArgs"));
       getObject_config.put("Einheit", "" +cfg.get("Settings.CoinsEinheit"));
       getObject_config.put("NotEnoughCoins", "" +cfg.get("Settings.NoCoins"));
       getObject_config.put("CoinsUsage", "" +cfg.get("Settings.CoinsUsage"));
       
       getObject_config.put("IronName", "" +cfg.get("Items.IronName"));
       getObject_config.put("IronPreis", "" +cfg.get("Items.IronPreis"));
       getObject_config.put("IronCommand", "" +cfg.get("Items.IronCommand"));
       getObject_config.put("IronText1", "" +cfg.get("Items.IronText1"));
       getObject_config.put("IronText2", "" +cfg.get("Items.IronText2"));
       getObject_config.put("IronText3", "" +cfg.get("Items.IronText3"));
       getObject_config.put("IronText4", "" +cfg.get("Items.IronText4"));
       getObject_config.put("IronText5", "" +cfg.get("Items.IronText5"));
       getObject_config.put("IronLore1", "" +cfg.get("Items.IronLore1"));
       getObject_config.put("IronLore2", "" +cfg.get("Items.IronLore2"));
       getObject_config.put("IronLore3", "" +cfg.get("Items.IronLore3"));

       getObject_config.put("GoldName", "" +cfg.get("Items.GoldName"));
       getObject_config.put("GoldPreis", "" +cfg.get("Items.GoldPreis"));
       getObject_config.put("GoldCommand", "" +cfg.get("Items.GoldCommand"));
       getObject_config.put("GoldText1", "" +cfg.get("Items.GoldText1"));
       getObject_config.put("GoldText2", "" +cfg.get("Items.GoldText2"));
       getObject_config.put("GoldText3", "" +cfg.get("Items.GoldText3"));
       getObject_config.put("GoldText4", "" +cfg.get("Items.GoldText4"));
       getObject_config.put("GoldText5", "" +cfg.get("Items.GoldText5"));
       getObject_config.put("GoldLore1", "" +cfg.get("Items.GoldLore1"));
       getObject_config.put("GoldLore2", "" +cfg.get("Items.GoldLore2"));
       getObject_config.put("GoldLore3", "" +cfg.get("Items.GoldLore3"));
       
       getObject_config.put("DiaName", "" +cfg.get("Items.DiaName"));
       getObject_config.put("DiaPreis", "" +cfg.get("Items.DiaPreis"));
       getObject_config.put("DiaCommand", "" +cfg.get("Items.DiaCommand"));
       getObject_config.put("DiaText1", "" +cfg.get("Items.DiaText1"));
       getObject_config.put("DiaText2", "" +cfg.get("Items.DiaText2"));
       getObject_config.put("DiaText3", "" +cfg.get("Items.DiaText3"));
       getObject_config.put("DiaText4", "" +cfg.get("Items.DiaText4"));
       getObject_config.put("DiaText5", "" +cfg.get("Items.DiaText5"));
       getObject_config.put("DiaLore1", "" +cfg.get("Items.DiaLore1"));
       getObject_config.put("DiaLore2", "" +cfg.get("Items.DiaLore2"));
       getObject_config.put("DiaLore3", "" +cfg.get("Items.DiaLore3"));
       
       getObject_config.put("Droprate", "" +cfg.get("Coins.Drop100Blocks"));
       getObject_config.put("DropMSG", "" +cfg.get("Coins.DropMessage"));

       cfg.save(File);
     } catch (Exception e) {
       if (Main.debug) {
         e.printStackTrace();
      }
     }
   }
   
   public void createDefaultMySQLFile() {
       try {
       File File = new File("plugins/Villager-Shop/", "MySQL.yml");
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
      File File = new File("plugins/Villager-Shop/", "MySQL.yml");
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
