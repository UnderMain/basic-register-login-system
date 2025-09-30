package de.undermain.shop.commands;

import java.io.File;
import java.io.IOException;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import de.undermain.shop.util.files;

public class setwarp implements CommandExecutor{
	
	  public static File Config = new File("plugins/Citybuild-System", "warps.yml");
	  
	  public static FileConfiguration cfg = (FileConfiguration)YamlConfiguration.loadConfiguration(Config);
	  public void setWarp(Location loc, String name) {
		    
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
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player p = (Player) sender;
		String Prefix = files.getObject_config.get("Prefix").toString().replaceAll("&", "§");
		String perm = files.getObject_config.get("NoPerm").toString().replaceAll("&", "§");
		String ConsoleMSG = files.getObject_config.get("ConsoleMSG").toString().replaceAll("&", "§");
		if(sender instanceof Player) {
			if(p.hasPermission("citybuild.setwarp")) {
				if(args.length == 0 || args.length >1) {
					p.sendMessage(Prefix + "§cSyntax -/setwarp [name]");
				}else {
					String name = args[0];
					Location loc = p.getLocation();
					setWarp(loc, name);
					p.sendMessage(Prefix + "§aYou have set the Warp §c" + name +"§a!");
				}
				
			}else {
				p.sendMessage(Prefix + perm);
			}
		}else {
			sender.sendMessage(Prefix + ConsoleMSG);
		}
		
		return false;
	}
	
}
