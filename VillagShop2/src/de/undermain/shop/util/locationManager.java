package de.undermain.shop.util;

import java.io.File;
import java.io.IOException;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class locationManager {
  public static File Config = new File("plugins/Citybuild-System", "locations.yml");
  
  public static FileConfiguration cfg = (FileConfiguration)YamlConfiguration.loadConfiguration(Config);
  
  public void setSpawn(Location loc) {
    String name = "Spawn";
    cfg.set(String.valueOf(name) + ".world", loc.getWorld().getName());
    cfg.set(String.valueOf(name) + ".x", Double.valueOf(loc.getX()));
    cfg.set(String.valueOf(name) + ".y", Double.valueOf(loc.getY()));
    cfg.set(String.valueOf(name) + ".z", Double.valueOf(loc.getZ()));
    cfg.set(String.valueOf(name) + ".yaw", Float.valueOf(loc.getYaw()));
    cfg.set(String.valueOf(name) + ".pitch", Float.valueOf(loc.getPitch()));
    try {
      cfg.save(Config);
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
  
  public Location getSpawm() {
    String name = "Spawn";
    World w = Bukkit.getWorld(cfg.getString(String.valueOf(name) + ".world"));
    double x = cfg.getDouble(String.valueOf(name) + ".x");
    double y = cfg.getDouble(String.valueOf(name) + ".y");
    double z = cfg.getDouble(String.valueOf(name) + ".z");
    Location loc = new Location(w, x, y, z);
    loc.setYaw(cfg.getInt(String.valueOf(name) + ".yaw"));
    loc.setPitch(cfg.getInt(String.valueOf(name) + ".pitch"));
    return loc;
  }
}