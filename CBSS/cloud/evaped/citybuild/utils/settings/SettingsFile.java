package cloud.evaped.citybuild.utils.settings;

import cloud.evaped.citybuild.main.CityBuildCore;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.configuration.file.FileConfiguration;

public class SettingsFile
{
  public SettingsFile() {}
  
  public static void updateSettingsInvFile()
  {
    File FILE = new File("plugins/CityBuild/Inventory", "settings.yml");
    FileConfiguration file = org.bukkit.configuration.file.YamlConfiguration.loadConfiguration(FILE);
    
    file.addDefault("settings.createcommand", "p auto");
    file.addDefault("settings.removecommand", "/p delete");
    List<String> list01 = new ArrayList();
    list01.add("&8» &cGot to the plot, you want to remove and click this message to remove this plot.");
    file.addDefault("settings.removemessage", list01);
    file.addDefault("settings.removehover", "&cClick to remove this plot");
    file.addDefault("settings.homecommand", "p home");
    
    file.addDefault("inv.settings.name", "&8» &eSettings");
    file.addDefault("inv.settings.size", Integer.valueOf(27));
    file.addDefault("inv.settings.glasenabled", Boolean.valueOf(true));
    file.addDefault("inv.settings.animation", Boolean.valueOf(true));
    file.addDefault("inv.settings.glascolorPRIM", Integer.valueOf(0));
    file.addDefault("inv.settings.glascolorSEC", Integer.valueOf(7));
    
    List<String> lore = new ArrayList();
    lore.add("&8&m--------------------");
    lore.add("&7Create a plot.");
    CityBuildCore.saveItemInFile(file, "inv.items.create", 11, 307, 0, "&8» &aCreate a plot", lore, Boolean.valueOf(false));
    
    List<String> lore1 = new ArrayList();
    lore1.add("&8&m--------------------");
    lore1.add("&7Remove your plot.");
    lore1.add("&cInfo: That can't be undone!");
    CityBuildCore.saveItemInFile(file, "inv.items.remove", 13, 46, 0, "&8» &cRemove your plot", lore1, Boolean.valueOf(false));
    
    List<String> lore2 = new ArrayList();
    lore2.add("&8&m--------------------");
    lore2.add("&7Teleport to your plot.");
    CityBuildCore.saveItemInFile(file, "inv.items.home", 15, 368, 0, "&8» &eGo to your plot", lore2, Boolean.valueOf(false));
    
    CityBuildCore.saveFile(file, FILE);
  }
}
