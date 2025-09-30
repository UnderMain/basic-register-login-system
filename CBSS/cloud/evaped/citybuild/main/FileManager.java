package cloud.evaped.citybuild.main;

import cloud.evaped.citybuild.utils.DataSaver;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

public class FileManager
{
  public FileManager() {}
  
  public static ItemStack createItem(org.bukkit.Material mat, int amount, int subid, String name)
  {
    ItemStack i = new ItemStack(mat, amount, (short)subid);
    org.bukkit.inventory.meta.ItemMeta m = i.getItemMeta();
    m.setDisplayName(name);
    i.setItemMeta(m);
    return i;
  }
  
  public static void saveFILE(FileConfiguration file, File FILE) {
    file.options().copyDefaults(true);
    try {
      file.save(FILE);
    }
    catch (java.io.IOException localIOException) {}
  }
  
  public static void itemFile(FileConfiguration file, String path, int pos, int id, int subid, String name, List<String> lore, Boolean enchant, Boolean enabled)
  {
    file.addDefault(path + ".name", name);
    file.addDefault(path + ".pos", Integer.valueOf(pos));
    file.addDefault(path + ".id", Integer.valueOf(id));
    file.addDefault(path + ".subid", Integer.valueOf(subid));
    file.addDefault(path + ".lore", lore);
    file.addDefault(path + ".enchant", enchant);
    file.addDefault(path + ".enabled", enabled);
  }
  
  public static void addDataLocation(File file, FileConfiguration cfg, Location loc, String path) {
    cfg.set(path + ".world", loc.getWorld().getName());
    cfg.set(path + ".x", Double.valueOf(loc.getX()));
    cfg.set(path + ".y", Double.valueOf(loc.getY()));
    cfg.set(path + ".z", Double.valueOf(loc.getZ()));
    cfg.set(path + ".yaw", Float.valueOf(loc.getYaw()));
    cfg.set(path + ".pitch", Float.valueOf(loc.getPitch()));
    saveFILE(cfg, file);
  }
  
  public static Location getDataLocation(FileConfiguration cfg, String path) {
    Location loc = null;
    String world = cfg.getString(path + ".world");
    double x = cfg.getDouble(path + ".x");
    double y = cfg.getDouble(path + ".y");
    double z = cfg.getDouble(path + ".z");
    float yaw = (float)cfg.getDouble(path + ".yaw");
    float pitch = (float)cfg.getDouble(path + ".pitch");
    loc = new Location(org.bukkit.Bukkit.getWorld(world), x, y, z, yaw, pitch);
    return loc;
  }
  
  public static Location getDataLocationDataSaver(DataSaver ds, String path) { Location loc = null;
    String world = ds.getString(path + ".world");
    double x = ds.getDouble(path + ".x");
    double y = ds.getDouble(path + ".y");
    double z = ds.getDouble(path + ".z");
    float yaw = ds.getFloat(path + ".yaw");
    float pitch = ds.getFloat(path + ".pitch");
    loc = new Location(org.bukkit.Bukkit.getWorld(world), x, y, z, yaw, pitch);
    return loc;
  }
  
  public static HashMap<String, Object> getObject_MySQL = new HashMap();
  
  public void createDefaultMySQLFile() {
    try {
      File File = new File("plugins/CityBuild/", "MySQL.yml");
      FileConfiguration cfg = YamlConfiguration.loadConfiguration(File);
      
      cfg.addDefault("MySQL.Host", "localhost");
      cfg.addDefault("MySQL.Port", Integer.valueOf(3306));
      cfg.addDefault("MySQL.Database", "database");
      cfg.addDefault("MySQL.User", "root");
      cfg.addDefault("MySQL.Password", "password");
      
      cfg.options().copyDefaults(true);
      cfg.save(File);
    } catch (Exception e) {
      if (CityBuildPlugin.debug) {
        e.printStackTrace();
      }
    }
  }
  
  public void loadDefaultMySQLFile() {
    try {
      File File = new File("plugins/CityBuild/", "MySQL.yml");
      FileConfiguration cfg = YamlConfiguration.loadConfiguration(File);
      
      getObject_MySQL.put("Host", cfg.get("MySQL.Host"));
      getObject_MySQL.put("Port", cfg.get("MySQL.Port"));
      getObject_MySQL.put("Database", cfg.get("MySQL.Database"));
      getObject_MySQL.put("User", cfg.get("MySQL.User"));
      getObject_MySQL.put("Password", cfg.get("MySQL.Password"));
      
      cfg.save(File);
    } catch (Exception e) {
      if (CityBuildPlugin.debug) {
        e.printStackTrace();
      }
    }
  }
  
  public static void createtabfile() {
    File FILE = new File("plugins/CityBuild/Utils/", "tab.yml");
    FileConfiguration file = YamlConfiguration.loadConfiguration(FILE);
    
    file.addDefault("#1", "You can create up to 30 diffrent Ranks. Just Copy and Paste one of our templates and change the number (1-30), design and permission.");
    file.addDefault("#2", "All Prefixes cannot be longer than 16 chars (Colorcodes incl.)!");
    file.addDefault("#3", "If you have questions, go to our Help-Site: https://byte-ware.net/games/lobby.");
    
    file.addDefault("1.prefix", "&4Owner &7┃ &4");
    file.addDefault("1.perm", "tab.owner");
    
    file.addDefault("2.prefix", "&4Admin &7┃ &4");
    file.addDefault("2.perm", "tab.admin");
    
    file.addDefault("3.prefix", "&cMod &7┃ &c");
    file.addDefault("3.perm", "tab.mod");
    
    file.addDefault("4.prefix", "§bSup §7┃ §2");
    file.addDefault("4.perm", "tab.supp");
    
    file.addDefault("5.prefix", "§bTSup §7┃ §d");
    file.addDefault("5.perm", "tab.premium3");
    
    file.addDefault("6.prefix", "§b");
    file.addDefault("6.perm", "tab.premium2");
    
    file.addDefault("7.prefix", "§6");
    file.addDefault("7.perm", "tab.premium1");
    
    file.addDefault("default.prefix", "§a");
    file.addDefault("nick.numberforpremium", Integer.valueOf(7));
    
    saveFILE(file, FILE);
  }
  
  public static void createchatfile() {
    File FILE = new File("plugins/CityBuild/Utils/", "chat.yml");
    FileConfiguration file = YamlConfiguration.loadConfiguration(FILE);
    
    file.addDefault("#1", "You can create up to 30 diffrent Ranks. Just Copy and Paste one of our templates and change the number (1-30), design and permission.");
    file.addDefault("#2", "If you have questions, go to our Help-Site: https://byte-ware.net/games/lobby.");
    
    file.addDefault("1.format", "&4&lOwner &7• &4%PLAYER% &7» &f%MESSAGE%");
    file.addDefault("1.perm", "chat.owner");
    
    file.addDefault("2.format", "&4&lAdmin &7• &4%PLAYER% &7» &f%MESSAGE%");
    file.addDefault("2.perm", "chat.admin");
    
    file.addDefault("3.format", "&c&lMod &7• &c%PLAYER% &7» &f%MESSAGE%");
    file.addDefault("3.perm", "chat.mod");
    
    file.addDefault("4.format", "§b§lSup §7• §2%PLAYER% §7» §f%MESSAGE%");
    file.addDefault("4.perm", "chat.supp");
    
    file.addDefault("5.format", "§b§lTSup §7• §d%PLAYER% §7» §f%MESSAGE%");
    file.addDefault("5.perm", "chat.premium3");
    
    file.addDefault("6.format", "§b%PLAYER% §7» §f%MESSAGE%");
    file.addDefault("6.perm", "chat.premium2");
    
    file.addDefault("7.format", "§6%PLAYER% §7» §f%MESSAGE%");
    file.addDefault("7.perm", "chat.premium1");
    
    file.addDefault("default.format", "§a%PLAYER% §7» §f%MESSAGE%");
    file.addDefault("nick.numberforpremium", Integer.valueOf(7));
    
    saveFILE(file, FILE);
  }
  
  public static void createScoreBoardRanksFile() {
    File FILE = new File("plugins/CityBuild/Utils/", "scoreboardranks.yml");
    FileConfiguration file = YamlConfiguration.loadConfiguration(FILE);
    
    file.addDefault("#1", "You can create up to 30 diffrent Ranks. Just Copy and Paste one of our templates and change the number (1-30), design and permission.");
    

    file.addDefault("1.format", "&4&lOwner");
    file.addDefault("1.perm", "sb.owner");
    
    file.addDefault("2.format", "&4&lAdmin");
    file.addDefault("2.perm", "sb.admin");
    
    file.addDefault("3.format", "&c&lMod");
    file.addDefault("3.perm", "sb.mod");
    
    file.addDefault("4.format", "§b§lSup");
    file.addDefault("4.perm", "sb.supp");
    
    file.addDefault("5.format", "§b§lPremium");
    file.addDefault("5.perm", "sb.premium3");
    
    file.addDefault("6.format", "§b§lPremium");
    file.addDefault("6.perm", "sb.premium2");
    
    file.addDefault("7.format", "§6§lPremium");
    file.addDefault("7.perm", "sb.premium1");
    
    file.addDefault("default.format", "§a§lPlayer");
    file.addDefault("nick.numberforpremium", Integer.valueOf(7));
    file.addDefault("nick.replaced", Boolean.valueOf(true));
    
    saveFILE(file, FILE);
  }
  
  public static HashMap<String, Object> getObject_Chat = new HashMap();
  public static HashMap<String, Object> getObject_Tab = new HashMap();
  public static HashMap<String, Object> getObject_Data = new HashMap();
  public static HashMap<String, Object> getObject_Scoreboardnames = new HashMap();
  
  public void loadData_Chat() {
    File file = new File("plugins/CityBuild/Utils/", "chat.yml");
    FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
    
    List<String> getSectionsItems = new ArrayList();
    if (cfg.getConfigurationSection("default") != null)
      for (String key : cfg.getConfigurationSection("default").getKeys(false)) {
        Object o = cfg.get("default." + key);
        if ((o instanceof String)) {
          String s = (String)o;
          o = s.replaceAll("&", "§");
        } else if ((o instanceof List)) {
          List<?> list = (List)o;
          if ((list.size() > 0) && 
            ((list.get(0) instanceof String)))
          {
            List<String> list1 = (List)o;
            List<String> list2 = new ArrayList();
            for (Iterator localIterator2 = list1.iterator(); localIterator2.hasNext();) { s = (String)localIterator2.next();
              list2.add(s.replaceAll("&", "§"));
            }
            o = list2;
          }
        }
        
        getObject_Chat.put("default." + key, o);
      }
    String s;
    if (cfg.getConfigurationSection("nick") != null)
      for (??? = cfg.getConfigurationSection("nick").getKeys(false).iterator(); ???.hasNext();) { key = (String)???.next();
        getObject_Chat.put("nick." + key, cfg.get("nick." + key));
      }
    String key;
    for (int i = 1; i < 33; i++) {
      if (cfg.getConfigurationSection(i + "") != null) {
        for (String key : cfg.getConfigurationSection(i + "").getKeys(false)) {
          Object o = cfg.get(i + "." + key);
          if ((o instanceof String)) {
            String s = (String)o;
            o = s.replaceAll("&", "§");
          } else if ((o instanceof List)) {
            List<?> list = (List)o;
            if ((list.size() > 0) && 
              ((list.get(0) instanceof String)))
            {
              List<String> list1 = (List)o;
              Object list2 = new ArrayList();
              for (String s : list1) {
                ((List)list2).add(s.replaceAll("&", "§"));
              }
              o = list2;
            }
          }
          
          getObject_Chat.put(i + "." + key, o);
        }
        getSectionsItems.clear();
      }
    }
    try
    {
      cfg.save(file);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public void loadData_Tab()
  {
    File file = new File("plugins/CityBuild/Utils/", "tab.yml");
    FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
    
    List<String> getSectionsItems = new ArrayList();
    if (cfg.getConfigurationSection("default") != null) {
      for (String key : cfg.getConfigurationSection("default").getKeys(false)) {
        Object o = cfg.get("default." + key);
        if ((o instanceof String)) {
          String s = (String)o;
          o = s.replaceAll("&", "§");
        } else if ((o instanceof List)) {
          List<?> list = (List)o;
          if ((list.size() > 0) && 
            ((list.get(0) instanceof String)))
          {
            List<String> list1 = (List)o;
            List<String> list2 = new ArrayList();
            for (String s : list1) {
              list2.add(s.replaceAll("&", "§"));
            }
            o = list2;
          }
        }
        
        getObject_Tab.put("default." + key, o);
      }
    }
    if (cfg.getConfigurationSection("nick") != null)
      for (??? = cfg.getConfigurationSection("nick").getKeys(false).iterator(); ???.hasNext();) { key = (String)???.next();
        Object o = cfg.get("nick." + key);
        if ((o instanceof String)) {
          String s = (String)o;
          o = s.replaceAll("&", "§");
        } else if ((o instanceof List)) {
          List<?> list = (List)o;
          if ((list.size() > 0) && 
            ((list.get(0) instanceof String)))
          {
            List<String> list1 = (List)o;
            List<String> list2 = new ArrayList();
            for (??? = list1.iterator(); ???.hasNext();) { s = (String)???.next();
              list2.add(s.replaceAll("&", "§"));
            }
            o = list2;
          }
        }
        
        getObject_Tab.put("nick." + key, o); }
    String key;
    String s;
    for (int i = 1; i < 33; i++) {
      if (cfg.getConfigurationSection(i + "") != null) {
        for (String key : cfg.getConfigurationSection(i + "").getKeys(false)) {
          Object o = cfg.get(i + "." + key);
          if ((o instanceof String)) {
            String s = (String)o;
            o = s.replaceAll("&", "§");
          } else if ((o instanceof List)) {
            List<?> list = (List)o;
            if ((list.size() > 0) && 
              ((list.get(0) instanceof String)))
            {
              List<String> list1 = (List)o;
              Object list2 = new ArrayList();
              for (String s : list1) {
                ((List)list2).add(s.replaceAll("&", "§"));
              }
              o = list2;
            }
          }
          
          getObject_Tab.put(i + "." + key, o);
        }
        getTeamSize += 1;
        getSectionsItems.clear();
      }
    }
    try
    {
      cfg.save(file);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public void loadData_ScoreboardRanks()
  {
    File FILE = new File("plugins/CityBuild/Utils/", "scoreboardranks.yml");
    FileConfiguration cfg = YamlConfiguration.loadConfiguration(FILE);
    
    List<String> getSectionsItems = new ArrayList();
    if (cfg.getConfigurationSection("default") != null) {
      for (String key : cfg.getConfigurationSection("default").getKeys(false)) {
        Object o = cfg.get("default." + key);
        if ((o instanceof String)) {
          String s = (String)o;
          o = s.replaceAll("&", "§");
        } else if ((o instanceof List)) {
          List<?> list = (List)o;
          if ((list.size() > 0) && 
            ((list.get(0) instanceof String)))
          {
            List<String> list1 = (List)o;
            List<String> list2 = new ArrayList();
            for (String s : list1) {
              list2.add(s.replaceAll("&", "§"));
            }
            o = list2;
          }
        }
        
        getObject_Scoreboardnames.put("default." + key, o);
      }
    }
    if (cfg.getConfigurationSection("nick") != null)
      for (??? = cfg.getConfigurationSection("nick").getKeys(false).iterator(); ???.hasNext();) { key = (String)???.next();
        Object o = cfg.get("nick." + key);
        if ((o instanceof String)) {
          String s = (String)o;
          o = s.replaceAll("&", "§");
        } else if ((o instanceof List)) {
          List<?> list = (List)o;
          if ((list.size() > 0) && 
            ((list.get(0) instanceof String)))
          {
            List<String> list1 = (List)o;
            List<String> list2 = new ArrayList();
            for (??? = list1.iterator(); ???.hasNext();) { s = (String)???.next();
              list2.add(s.replaceAll("&", "§"));
            }
            o = list2;
          }
        }
        
        getObject_Scoreboardnames.put("nick." + key, o); }
    String key;
    String s;
    for (int i = 1; i < 33; i++) {
      if (cfg.getConfigurationSection(i + "") != null) {
        for (String key : cfg.getConfigurationSection(i + "").getKeys(false)) {
          Object o = cfg.get(i + "." + key);
          if ((o instanceof String)) {
            String s = (String)o;
            o = s.replaceAll("&", "§");
          } else if ((o instanceof List)) {
            List<?> list = (List)o;
            if ((list.size() > 0) && 
              ((list.get(0) instanceof String)))
            {
              List<String> list1 = (List)o;
              Object list2 = new ArrayList();
              for (String s : list1) {
                ((List)list2).add(s.replaceAll("&", "§"));
              }
              o = list2;
            }
          }
          
          getObject_Scoreboardnames.put(i + "." + key, o);
        }
        getSectionsItems.clear();
      }
    }
    try
    {
      cfg.save(FILE);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  

  public static int getTeamSize = 0;
  
  public void loadData_Data() {
    File file = new File("plugins/CityBuild/", "DATA.yml");
    FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
    
    if (!getObject_Data.isEmpty()) {
      getObject_Data.clear();
    }
    
    if (cfg.contains("Location.Spawn")) {
      getObject_Data.put("Location.Spawn", getDataLocation(cfg, "Location.Spawn"));
    }
    if (cfg.contains("Location.Villager.firstthere")) {
      getObject_Data.put("Location.Villager.firstthere", getDataLocation(cfg, "Location.Villager.firstthere"));
      getObject_Data.put("Location.Villager.firstthere.world", cfg.getString("Location.Villager.firstthere.world"));
    }
    if (cfg.contains("Location.Villager.plotsettings")) {
      getObject_Data.put("Location.Villager.plotsettings", getDataLocation(cfg, "Location.Villager.plotsettings"));
      getObject_Data.put("Location.Villager.plotsettings.world", cfg.getString("Location.Villager.plotsettings.world"));
    }
    try
    {
      cfg.save(file);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
