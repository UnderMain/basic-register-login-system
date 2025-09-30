package cloud.evaped.citybuild.commands;

import cloud.evaped.citybuild.main.CityBuildCore;
import cloud.evaped.citybuild.main.CityBuildPlugin;
import java.util.HashMap;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class RealNameCommand implements org.bukkit.command.CommandExecutor
{
  public RealNameCommand() {}
  
  public boolean onCommand(CommandSender sender, org.bukkit.command.Command arg1, String arg2, String[] args)
  {
    if (sender.hasPermission("citybuild.realname")) {
      if (args.length == 1) {
        if (cloud.evaped.citybuild.utils.nick.Nick.getPlayerBehindName.containsKey(args[0])) {
          sender.sendMessage(CityBuildCore.instance.translateString("This player is nicked and his name is&8: &c" + (String)cloud.evaped.citybuild.utils.nick.Nick.getPlayerBehindName.get(args[0])));
        } else {
          sender.sendMessage(CityBuildCore.instance.translateString("This player isn't nicked or not online right now."));
          if ((sender instanceof Player)) {
            ((Player)sender).playSound(((Player)sender).getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
          }
        }
      } else {
        sender.sendMessage(CityBuildCore.instance.translateString(CityBuildPlugin.instance.getConfig().getString("messages.fSyntax") + "realname <Player>").replaceAll("&", "§"));
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
    
    return false;
  }
}
