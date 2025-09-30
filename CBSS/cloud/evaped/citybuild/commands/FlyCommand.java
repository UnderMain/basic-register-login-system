package cloud.evaped.citybuild.commands;

import cloud.evaped.citybuild.main.CityBuildCore;
import cloud.evaped.citybuild.main.CityBuildPlugin;
import cloud.evaped.citybuild.utils.DataSaver;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class FlyCommand implements org.bukkit.command.CommandExecutor
{
  public FlyCommand() {}
  
  public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args)
  {
    if (sender.hasPermission("citybuild.fly")) {
      if (args.length == 0) {
        if ((sender instanceof Player)) {
          Player p = (Player)sender;
          
          if (p.getGameMode() == org.bukkit.GameMode.SURVIVAL) {
            if (p.getAllowFlight()) {
              p.setAllowFlight(false);
              p.setFlying(false);
              sender.sendMessage(CityBuildCore.instance.translateString(CityBuildCore.ds_msg.getString("message.flyfalse")));
              ((Player)sender).playSound(((Player)sender).getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
            } else {
              p.setAllowFlight(true);
              p.setFlying(true);
              sender.sendMessage(CityBuildCore.instance.translateString(CityBuildCore.ds_msg.getString("message.flytrue")));
              ((Player)sender).playSound(((Player)sender).getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
            }
          } else {
            sender.sendMessage(CityBuildCore.instance.translateString(CityBuildCore.ds_msg.getString("message.flynotgamemode")));
            ((Player)sender).playSound(((Player)sender).getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
          }
        }
        else
        {
          sender.sendMessage("You must be a Player, to use this Command!");
        }
      } else if ((args.length == 1) && (sender.hasPermission("citybuild.fly.other"))) {
        Player target = org.bukkit.Bukkit.getPlayer(args[0]);
        
        if (target != null)
        {
          if (target.getGameMode() == org.bukkit.GameMode.SURVIVAL) {
            if (target.getAllowFlight()) {
              target.setAllowFlight(false);
              target.setFlying(false);
              sender.sendMessage(CityBuildCore.instance.translateString(CityBuildCore.ds_msg.getString("message.flyotherfalse").replace("%PLAYER%", target.getName())));
              ((Player)sender).playSound(((Player)sender).getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
            } else {
              target.setAllowFlight(true);
              target.setFlying(true);
              sender.sendMessage(CityBuildCore.instance.translateString(CityBuildCore.ds_msg.getString("message.flyothertrue").replace("%PLAYER%", target.getName())));
              ((Player)sender).playSound(((Player)sender).getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
            }
          } else {
            sender.sendMessage(CityBuildCore.instance.translateString(CityBuildCore.ds_msg.getString("message.flyothernotgamemode").replace("%PLAYER%", target.getName())));
            ((Player)sender).playSound(((Player)sender).getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
          }
        }
        else {
          sender.sendMessage(CityBuildCore.instance.translateString(CityBuildPlugin.instance.getConfig().getString("messages.notOnline")));
          if ((sender instanceof Player)) {
            ((Player)sender).playSound(((Player)sender).getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
          }
        }
      } else {
        sender.sendMessage(CityBuildCore.instance.translateString(CityBuildPlugin.instance.getConfig().getString("messages.fSyntax") + "feed [Player]"));
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
