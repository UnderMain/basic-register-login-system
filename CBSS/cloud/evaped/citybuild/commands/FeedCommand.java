package cloud.evaped.citybuild.commands;

import cloud.evaped.citybuild.main.CityBuildCore;
import cloud.evaped.citybuild.main.CityBuildPlugin;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class FeedCommand implements org.bukkit.command.CommandExecutor
{
  public FeedCommand() {}
  
  public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args)
  {
    if (sender.hasPermission("citybuild.feed")) {
      if (args.length == 0) {
        if ((sender instanceof Player)) {
          Player p = (Player)sender;
          p.setFoodLevel(20);
          sender.sendMessage(CityBuildCore.instance.translateString(CityBuildCore.ds_msg.getString("message.feedyou")));
          ((Player)sender).playSound(((Player)sender).getLocation(), Sound.LAVA_POP, 1.0F, 1.0F);
        } else {
          sender.sendMessage("You must be a Player, to use this Command!");
        }
      } else if ((args.length == 1) && (sender.hasPermission("citybuild.feed.other"))) {
        Player target = org.bukkit.Bukkit.getPlayer(args[0]);
        
        if (target != null)
        {
          target.setFoodLevel(20);
          sender.sendMessage(CityBuildCore.instance.translateString(CityBuildCore.ds_msg.getString("message.feedother").replace("%PLAYER%", target.getName())));
          if ((sender instanceof Player)) {
            ((Player)sender).playSound(((Player)sender).getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
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
