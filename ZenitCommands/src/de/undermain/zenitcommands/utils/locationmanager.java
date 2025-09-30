package de.undermain.zenitcommands.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class locationmanager {
	
	
	
	public static File Config = new File("plugins/spawns", "locs.yml");
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(Config);
	
	
	public void setSpawn(Location loc) {
		
		String name = "Spawn";
		
		cfg.set(name + ".world", loc.getWorld().getName());
		cfg.set(name + ".x", loc.getX());
		cfg.set(name + ".y", loc.getY());
		cfg.set(name + ".Z", loc.getZ());
		cfg.set(name + ".yaw", loc.getYaw());
		cfg.set(name + ".pitch", loc.getPitch());
		
		try {
			cfg.save(Config);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public Location getSpawm() {
		String name = "Spawn";
		
		World w = Bukkit.getWorld(cfg.getString(name + ".world"));
		double x = cfg.getDouble(cfg.getString(name + ".x"));
		double y = cfg.getDouble(cfg.getString(name + ".y"));
		double z = cfg.getDouble(cfg.getString(name + ".z"));

		Location loc = new Location(w, x, y, z);
		loc.setYaw(cfg.getInt(name + ".yaw"));
		loc.setPitch(cfg.getInt(name + ".pitch"));

		return loc;
		
	}
	

	
	
	
	

}
