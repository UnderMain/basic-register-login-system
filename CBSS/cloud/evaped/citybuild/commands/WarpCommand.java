package cloud.evaped.citybuild.commands;

import cloud.evaped.citybuild.main.CityBuildCore;
import cloud.evaped.citybuild.main.CityBuildPlugin;
import cloud.evaped.citybuild.utils.Warps;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WarpCommand implements CommandExecutor
{
  public WarpCommand() {}
  
  public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args)
  {
    if ((sender instanceof Player)) {
      if (sender.hasPermission("citybuild.warp")) {
        Player p = (Player)sender;
        if (args.length == 1) {
          Warps.instance.teleportWarp(p, args[0]);
        } else {
          p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
          Warps.instance.sendMessages(p);
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
