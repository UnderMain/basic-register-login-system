package cloud.evaped.citybuild.commands;

import cloud.evaped.citybuild.main.CityBuildCore;
import cloud.evaped.citybuild.main.CityBuildPlugin;
import cloud.evaped.citybuild.main.FileManager;
import cloud.evaped.citybuild.utils.RegisterMobs;
import java.io.File;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class EditMapCommand implements CommandExecutor
{
  public EditMapCommand() {}
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if ((sender instanceof Player)) {
      Player p = (Player)sender;
      if (p.hasPermission("citybuild.editmap")) {
        if (CityBuildCore.getPlayerInEditMode.contains(p)) {
          if (args.length == 1)
          {
            if (args[0].equalsIgnoreCase("setspawn")) {
              File File = new File("plugins/CityBuild/", "DATA.yml");
              FileConfiguration cfg = YamlConfiguration.loadConfiguration(File);
              
              FileManager.addDataLocation(File, cfg, p.getLocation(), "Location.Spawn");
              p.sendMessage(CityBuildCore.instance.translateString("You succsesfully set the §eSpawn §7location."));
              
              FileManager.saveFILE(cfg, File);
            } else {
              p.sendMessage(CityBuildCore.instance.translateString("Map Edit Commands:"));
              p.sendMessage(CityBuildCore.instance.translateString("§b/editmap setSpawn §8- §7Create a map"));
              p.sendMessage(CityBuildCore.instance.translateString("§b/editmap setVillager firstthere §8- §7Set villager for players, who joined the first time"));
              p.sendMessage(CityBuildCore.instance.translateString("§b/editmap setVillager plotsettings §8- §7Set villager for plot settings"));
            }
          }
          else if (args.length == 2) {
            if (args[0].equalsIgnoreCase("setVillager")) {
              if (args[1].equalsIgnoreCase("firstthere")) {
                File File = new File("plugins/CityBuild/", "DATA.yml");
                FileConfiguration cfg = YamlConfiguration.loadConfiguration(File);
                
                FileManager.addDataLocation(File, cfg, p.getLocation(), "Location.Villager.firstthere");
                p.sendMessage(CityBuildCore.instance.translateString("You succsesfully set the location for §evillager 'first there'§7."));
                new FileManager().loadData_Data();
                new RegisterMobs(CityBuildPlugin.instance).createVillager();
                
                FileManager.saveFILE(cfg, File);
              } else if (args[1].equalsIgnoreCase("plotsettings")) {
                File File = new File("plugins/CityBuild/", "DATA.yml");
                FileConfiguration cfg = YamlConfiguration.loadConfiguration(File);
                
                FileManager.addDataLocation(File, cfg, p.getLocation(), "Location.Villager.plotsettings");
                p.sendMessage(CityBuildCore.instance.translateString("You succsesfully set the location for §evillager 'plot settings'§7."));
                new FileManager().loadData_Data();
                new RegisterMobs(CityBuildPlugin.instance).createVillager();
                
                FileManager.saveFILE(cfg, File);
              } else {
                p.sendMessage(CityBuildCore.instance.translateString("Map Edit Commands:"));
                p.sendMessage(CityBuildCore.instance.translateString("§b/editmap setSpawn §8- §7Create a map"));
                p.sendMessage(CityBuildCore.instance.translateString("§b/editmap setVillager firstthere §8- §7Set villager for players, who joined the first time"));
                p.sendMessage(CityBuildCore.instance.translateString("§b/editmap setVillager plotsettings §8- §7Set villager for plot settings"));
              }
            } else {
              p.sendMessage(CityBuildCore.instance.translateString("Map Edit Commands:"));
              p.sendMessage(CityBuildCore.instance.translateString("§b/editmap setSpawn §8- §7Create a map"));
              p.sendMessage(CityBuildCore.instance.translateString("§b/editmap setVillager firstthere §8- §7Set villager for players, who joined the first time"));
              p.sendMessage(CityBuildCore.instance.translateString("§b/editmap setVillager plotsettings §8- §7Set villager for plot settings"));
            }
          } else {
            p.sendMessage(CityBuildCore.instance.translateString("Map Edit Commands:"));
            p.sendMessage(CityBuildCore.instance.translateString("§b/editmap setSpawn §8- §7Create a map"));
            p.sendMessage(CityBuildCore.instance.translateString("§b/editmap setVillager firstthere §8- §7Set villager for players, who joined the first time"));
            p.sendMessage(CityBuildCore.instance.translateString("§b/editmap setVillager plotsettings §8- §7Set villager for plot settings"));
          }
        } else {
          p.sendMessage("You must be in edit-mode to use this feature (§c/edit§7).");
          
          p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
        }
      } else {
        sender.sendMessage(CityBuildCore.instance.translateString(CityBuildPlugin.instance.getConfig().getString("messages.noPerm")));
        if ((sender instanceof Player)) {
          ((Player)sender).playSound(((Player)sender).getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
        }
      }
    } else {
      sender.sendMessage("You must be a Player, to use this Command!");
    }
    
    return false;
  }
}
