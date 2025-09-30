package cloud.evaped.citybuild.commands;

import cloud.evaped.citybuild.main.CityBuildCore;
import cloud.evaped.citybuild.main.CityBuildPlugin;
import cloud.evaped.citybuild.utils.DataSaver;
import java.util.ArrayList;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor
{
  private DataSaver ds_map;
  private Integer i1;
  
  public SpawnCommand()
  {
    ds_map = new DataSaver(cloud.evaped.citybuild.main.FileManager.getObject_Data);
    i1 = Integer.valueOf(CityBuildPlugin.instance.getConfig().getInt("Spawn.cooldown"));
  }
  
  public static ArrayList<Player> getTeleport = new ArrayList();
  
  public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
    if ((sender instanceof Player)) {
      Player p = (Player)sender;
      if (sender.hasPermission("citybuild.spawn")) {
        if (args.length == 0) {
          CityBuildCore.instance.teleportWithCooldown(p, i1, ds_map.getLocation("Location.Spawn"));
        } else {
          sender.sendMessage(CityBuildCore.instance.translateString(CityBuildPlugin.instance.getConfig().getString("messages.fSyntax") + "spawn"));
          if ((sender instanceof Player)) {
            ((Player)sender).playSound(((Player)sender).getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
          }
        }
      } else {
        sender.sendMessage(CityBuildCore.instance.translateString(CityBuildPlugin.instance.getConfig().getString("messages.noPerm")));
        if ((sender instanceof Player)) {
          ((Player)sender).playSound(((Player)sender).getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
        }
      }
    }
    
    return false;
  }
}
