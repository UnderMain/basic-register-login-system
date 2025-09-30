package cloud.evaped.citybuild.commands;

import cloud.evaped.citybuild.main.CityBuildCore;
import cloud.evaped.citybuild.main.CityBuildPlugin;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class SetWarpCommand implements org.bukkit.command.CommandExecutor
{
  public SetWarpCommand() {}
  
  public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args)
  {
    if ((sender instanceof Player)) {
      if (sender.hasPermission("citybuild.setwarp")) {
        if (args.length == 1) {
          Player p = (Player)sender;
          cloud.evaped.citybuild.utils.Warps.instance.addWarp(p, args[0]);
        } else {
          sender.sendMessage(CityBuildCore.instance.translateString(CityBuildPlugin.instance.getConfig().getString("messages.fSyntax") + "setwarp <name>").replaceAll("&", "§"));
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
    } else {
      sender.sendMessage("You must be a Player, to use this Command!");
    }
    
    return false;
  }
}
