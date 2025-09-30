package cloud.evaped.citybuild.commands;

import cloud.evaped.citybuild.main.CityBuildCore;
import cloud.evaped.citybuild.main.CityBuildPlugin;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class SpectatorCommand implements org.bukkit.command.CommandExecutor
{
  public SpectatorCommand() {}
  
  public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args)
  {
    if (sender.hasPermission("citybuild.gamemode"))
    {
      if (args.length == 0) {
        if ((sender instanceof Player)) {
          Player p = (Player)sender;
          
          p.setGameMode(GameMode.SPECTATOR);
          ((Player)sender).playSound(((Player)sender).getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
          sender.sendMessage(CityBuildCore.instance.translateString(CityBuildCore.ds_msg.getString("message.gamemode3you")));
        }
        else {
          sender.sendMessage(CityBuildPlugin.instance.getConfig().getString("messages.prefix") + "You must be a Player, to use this Command!");
        }
      }
      else if (args.length == 1) {
        Player target = org.bukkit.Bukkit.getPlayer(args[0]);
        
        if (target != null)
        {
          sender.sendMessage(CityBuildCore.instance.translateString(CityBuildCore.ds_msg.getString("message.gamemode3other").replace("%PLAYER%", target.getName())));
          target.setGameMode(GameMode.SPECTATOR);
          ((Player)sender).playSound(((Player)sender).getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
        }
        else {
          sender.sendMessage(CityBuildCore.instance.translateString(CityBuildPlugin.instance.getConfig().getString("messages.notOnline")));
          if ((sender instanceof Player)) {
            ((Player)sender).playSound(((Player)sender).getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
          }
        }
      } else {
        sender.sendMessage(CityBuildCore.instance.translateString(CityBuildPlugin.instance.getConfig().getString("messages.fSyntax") + "gmspec [Player]"));
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
