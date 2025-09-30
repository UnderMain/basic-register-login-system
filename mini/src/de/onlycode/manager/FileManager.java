package de.onlycode.manager;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import de.onlycode.TemplateMain;

public class FileManager {
	
	public File file = new File("plugins/"+ TemplateMain.main.getName(), "config.yml");
	public FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	
	public void register() {
		cfg.options().copyDefaults(true);
		cfg.addDefault("MinPlayer", TemplateMain.main.min);
		cfg.addDefault("MaxPlayer", TemplateMain.main.max);
		saveCfg();
		TemplateMain.main.min = cfg.getInt("MinPlayer");
		TemplateMain.main.max = cfg.getInt("MaxPlayer");
		
	}
	
	
	public void saveCfg() {
		try {
			cfg.save(file);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}

}
