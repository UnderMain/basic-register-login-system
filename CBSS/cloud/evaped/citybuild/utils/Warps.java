package cloud.evaped.citybuild.utils;

import cloud.evaped.citybuild.main.CityBuildCore;
import cloud.evaped.citybuild.main.FileManager;
import java.io.File;
import java.util.HashMap;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Warps
{
  public static Warps instance;
  private HashMap<String, Location> warps;
  
  public Warps()
  {
    instance = this;
    warps = new HashMap();
    loadWarps();
  }
  
  public void addWarp(Player p, String warp) {
    warp = warp.toLowerCase();
    if (warps.containsKey("warp." + warp)) {
      p.sendMessage(CityBuildCore.instance.translateString("The warp §b" + warp + "§7 already exists!"));
      p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
    } else {
      warps.put("warp." + warp, p.getLocation());
      
      File file = new File("plugins/CityBuild/", "WARPS.yml");
      FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
      FileManager.addDataLocation(file, cfg, p.getLocation(), "locations.warps." + warp);
      try {
        cfg.save(file);
      } catch (Exception localException) {}
      p.sendMessage(CityBuildCore.instance.translateString("You created the warp §b" + warp + "§7!"));
      p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
    }
  }
  
  public void removeWarp(Player p, String warp) {
    warp = warp.toLowerCase();
    if (warps.containsKey("warp." + warp)) {
      warps.remove("warp." + warp);
      
      File file = new File("plugins/CityBuild/", "WARPS.yml");
      FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
      cfg.set("locations.warps." + warp, null);
      try {
        cfg.save(file);
      }
      catch (Exception localException) {}
      p.sendMessage(CityBuildCore.instance.translateString("The warp §b" + warp + "§7 has been removed!"));
      p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
    } else {
      p.sendMessage(CityBuildCore.instance.translateString("The warp §b" + warp + "§7 does not exists!"));
      p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
    }
  }
  
  public void teleportWarp(Player p, String warp) {
    warp = warp.toLowerCase();
    if (warps.containsKey("warp." + warp)) {
      p.teleport((Location)warps.get("warp." + warp));
      p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
    } else {
      p.sendMessage(CityBuildCore.instance.translateString("The warp §b" + warp.toLowerCase() + "§7 does not exists!"));
      p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
    }
  }
  
  public void sendMessages(Player p) {
    String s = CityBuildCore.instance.translateString("All Warps (" + warps.size() + "§7) §8: ");
    int i = 0;
    for (String s1 : warps.keySet()) {
      if (i == 0) {
        s = s + "§b" + s1.replaceAll("warp.", "");
      } else {
        s = s + "§7, §b" + s1.replaceAll("warp.", "");
      }
      i += 1;
    }
    p.sendMessage(s);
  }
  
  public void loadWarps() {
    File file = new File("plugins/CityBuild/", "WARPS.yml");
    FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
    
    if (cfg.getConfigurationSection("locations.warps") != null) {
      for (String key : cfg.getConfigurationSection("locations.warps").getKeys(false)) {
        warps.put("warp." + key, FileManager.getDataLocation(cfg, "locations.warps." + key));
      }
    }
    try
    {
      cfg.save(file);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public void onSignInteract(Player p, Sign s, String s2) {
    if (warps.containsKey("warp." + s.getLine(1))) {
      p.teleport((Location)warps.get("warp." + s.getLine(1)));
      p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
    } else {
      p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
      p.sendMessage(s2);
    }
  }
}
