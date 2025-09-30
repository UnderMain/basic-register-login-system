package de.onlycode.manager;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import de.onlycode.TemplateMain;

public class LocationManager {
	
	public File file = new File("plugins/"+ TemplateMain.main.getName(), "locations.yml");
	public FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	public void setLocation(String name,Location loc) {
		cfg.set(name+ ".world", loc.getWorld().getName());
		cfg.set(name+ ".x", loc.getX());
		cfg.set(name+ ".y", loc.getY());
		cfg.set(name+ ".z", loc.getZ());
		
		cfg.set(name+ ".yaw", loc.getYaw());
		cfg.set(name+ ".pitch", loc.getPitch());
		saveCfg();
		
	}
	
	public Location getLocation(String name) {
		Location loc;
		try {
		World w = Bukkit.getWorld(cfg.getString(name+ ".world"));
		double x = cfg.getDouble(name+ ".x");
		double y = cfg.getDouble(name+ ".y");
		double z = cfg.getDouble(name+ ".z");
		loc = new Location(w, x, y, z);
		loc.setYaw(cfg.getInt(name+ ".yaw"));
		loc.setPitch(cfg.getInt(name+ ".pitch"));
		}catch(Exception ex) {
			loc = new Location(Bukkit.getWorlds().get(0), 0, 0, 0);
			
		}
		
		return loc;
		
	}
	
	public void setSpawn(int num,Location loc) {
		String name = "Spawn";
		cfg.set(name+"." +num+ ".world", loc.getWorld().getName());
		cfg.set(name+"." +num+ ".x", loc.getX());
		cfg.set(name+"." +num+ ".y", loc.getY());
		cfg.set(name+"." +num+ ".z", loc.getZ());
		
		cfg.set(name+"." +num+ ".yaw", loc.getYaw());
		cfg.set(name+"." +num+ ".pitch", loc.getPitch());
		saveCfg();
		
	}
	
	public Location getSpawn(int num) {
		String name = "Spawn";
		World w = Bukkit.getWorld(cfg.getString(name+"." +num+ ".world"));
		double x = cfg.getDouble(name+"." +num+ ".x");
		double y = cfg.getDouble(name+"." +num+ ".y");
		double z = cfg.getDouble(name+"." +num+ ".z");
		Location loc = new Location(w, x, y, z);
		loc.setYaw(cfg.getInt(name+"." +num+ ".yaw"));
		loc.setPitch(cfg.getInt(name+"." +num+ ".pitch"));
		return loc;
		
	}
	
	public void saveCfg() {
		
		try {
			cfg.save(file);
		} catch (IOException e) {
		}
		
	}
	
	public void mapTeleport() {
		int count = 1;
		for(Player alive : TemplateMain.main.alive) {
			alive.teleport(getSpawn(count));
			count++;
			
		}
	}
	
	public void setDeathmatch(int num,Location loc) {
		String name = "Deathmatch";
		cfg.set(name+"." +num+ ".world", loc.getWorld().getName());
		cfg.set(name+"." +num+ ".x", loc.getX());
		cfg.set(name+"." +num+ ".y", loc.getY());
		cfg.set(name+"." +num+ ".z", loc.getZ());
		
		cfg.set(name+"." +num+ ".yaw", loc.getYaw());
		cfg.set(name+"." +num+ ".pitch", loc.getPitch());
		saveCfg();
		
	}
	
	public Location getDeathmatch(int num) {
		String name = "Deathmatch";
		World w = Bukkit.getWorld(cfg.getString(name+"." +num+ ".world"));
		double x = cfg.getDouble(name+"." +num+ ".x");
		double y = cfg.getDouble(name+"." +num+ ".y");
		double z = cfg.getDouble(name+"." +num+ ".z");
		Location loc = new Location(w, x, y, z);
		loc.setYaw(cfg.getInt(name+"." +num+ ".yaw"));
		loc.setPitch(cfg.getInt(name+"." +num+ ".pitch"));
		return loc;
		
	}
	
	public void mapTeleport2() {
		int count = 1;
		for(Player alive : TemplateMain.main.alive) {
			alive.teleport(getDeathmatch(count));
			count++;
			
		}
	}

}
