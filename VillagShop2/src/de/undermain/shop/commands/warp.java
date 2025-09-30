package de.undermain.shop.commands;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import de.undermain.shop.util.files;

public class warp implements CommandExecutor{
	  public static File Config = new File("plugins/Citybuild-System", "locations.yml");
	  
	  public static FileConfiguration cfg = (FileConfiguration)YamlConfiguration.loadConfiguration(Config);
	  
	  public Location getWarp(String name) {
		    World w = Bukkit.getWorld(cfg.getString(String.valueOf(name) + ".world"));
		    double x = cfg.getDouble(String.valueOf(name) + ".x");
		    double y = cfg.getDouble(String.valueOf(name) + ".y");
		    double z = cfg.getDouble(String.valueOf(name) + ".z");
		    Location loc = new Location(w, x, y, z);
		    loc.setYaw(cfg.getInt(String.valueOf(name) + ".yaw"));
		    loc.setPitch(cfg.getInt(String.valueOf(name) + ".pitch"));
		    return loc;
		  }
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player p = (Player) sender;
		String Prefix = files.getObject_config.get("Prefix").toString().replaceAll("&", "§");
		String perm = files.getObject_config.get("NoPerm").toString().replaceAll("&", "§");
		String ConsoleMSG = files.getObject_config.get("ConsoleMSG").toString().replaceAll("&", "§");
		
		if(sender instanceof Player) {
			if(p.hasPermission("citybuild.warp")) {
				
				
					p.teleport(getWarp(args[0]));
					p.sendMessage(Prefix + "you teleport to " + args[0]);

				
			}else {
				p.sendMessage(Prefix + perm);
			}
		}else {
			sender.sendMessage(Prefix + ConsoleMSG);
		}
		
		return false;
	}

}
