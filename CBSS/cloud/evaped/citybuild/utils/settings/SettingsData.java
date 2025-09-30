package cloud.evaped.citybuild.utils.settings;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

public class SettingsData
{
  public static HashMap<String, Object> getObject_Settings = new HashMap();
  
  public SettingsData() {}
  
  public void loadData_Settings() { File file = new File("plugins/CityBuild/Inventory", "settings.yml");
    FileConfiguration cfg = org.bukkit.configuration.file.YamlConfiguration.loadConfiguration(file);
    
    List<String> getSectionsItems = new ArrayList();
    if (cfg.getConfigurationSection("settings") != null) {
      for (String key : cfg.getConfigurationSection("settings").getKeys(false)) {
        Object o = cfg.get("settings." + key);
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
        
        getObject_Settings.put("settings." + key, o);
      }
    }
    if (cfg.getConfigurationSection("inv.settings") != null)
      for (String key : cfg.getConfigurationSection("inv.settings").getKeys(false)) {
        o = cfg.get("inv.settings." + key);
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
        
        getObject_Settings.put("inv.settings." + key, o);
      }
    Object o;
    if (cfg.getConfigurationSection("inv.items") != null) {
      for (String key : cfg.getConfigurationSection("inv.items").getKeys(false)) {
        getSectionsItems.add(key);
        getObject_Settings.put("inv.items." + key, "XXX");
      }
      for (??? = getSectionsItems.iterator(); ???.hasNext();) { key = (String)???.next();
        for (String key1 : cfg.getConfigurationSection("inv.items." + key).getKeys(false)) {
          Object o = cfg.get("inv.items." + key + "." + key1);
          if ((o instanceof String)) {
            String s = (String)o;
            o = s.replaceAll("&", "§");
          } else if ((o instanceof List)) {
            List<?> list = (List)o;
            if ((list.size() > 0) && 
              ((list.get(0) instanceof String)))
            {
              Object list1 = (List)o;
              List<String> list2 = new ArrayList();
              for (String s : (List)list1) {
                list2.add(s.replaceAll("&", "§"));
              }
              o = list2;
            }
          }
          
          getObject_Settings.put("inv.items." + key + "." + key1, o);
        } }
      String key;
      getSectionsItems.clear();
    }
    try
    {
      cfg.save(file);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
