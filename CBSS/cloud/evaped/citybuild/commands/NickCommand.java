package cloud.evaped.citybuild.commands;

import cloud.evaped.citybuild.main.CityBuildCore;
import cloud.evaped.citybuild.main.CityBuildPlugin;
import cloud.evaped.citybuild.utils.nick.Nick;
import cloud.evaped.citybuild.utils.nick.NickInv;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class NickCommand implements org.bukkit.command.CommandExecutor
{
  private NickInv inv;
  
  public NickCommand()
  {
    inv = new NickInv();
  }
  
  public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
    if ((sender instanceof Player)) {
      if (sender.hasPermission("citybuild.nick")) {
        Player p = (Player)sender;
        if (args.length == 0)
        {
          if (Nick.isNicked.containsKey(p)) {
            Nick.instance.unnickPlayer(p, false);
          } else {
            Nick.instance.nickPlayer(p);
          }
        }
        else if (args.length == 1) {
          if (args[0].equalsIgnoreCase("settings")) {
            inv.createNickNameSettingsInv(p);
            ((Player)sender).playSound(((Player)sender).getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
          } else {
            sender.sendMessage(CityBuildCore.instance.translateString(CityBuildPlugin.instance.getConfig().getString("messages.fSyntax") + "nick [settings]").replaceAll("&", "§"));
            if ((sender instanceof Player)) {
              ((Player)sender).playSound(((Player)sender).getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
            }
          }
        } else {
          sender.sendMessage(CityBuildCore.instance.translateString(CityBuildPlugin.instance.getConfig().getString("messages.fSyntax") + "nick [settings]").replaceAll("&", "§"));
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
