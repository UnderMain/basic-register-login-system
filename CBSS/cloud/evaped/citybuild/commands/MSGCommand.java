package cloud.evaped.citybuild.commands;

import cloud.evaped.citybuild.main.CityBuildCore;
import cloud.evaped.citybuild.main.CityBuildPlugin;
import cloud.evaped.citybuild.utils.DataSaver;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MSGCommand implements org.bukkit.command.CommandExecutor
{
  public MSGCommand() {}
  
  public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args)
  {
    if (sender.hasPermission("citybuild.msg")) {
      if (args.length >= 1)
      {
        String m = "";
        for (int i = 1; i != args.length; i++) {
          m = m + args[i] + " ";
        }
        
        Player target = org.bukkit.Bukkit.getPlayer(args[0]);
        
        if (target != null) {
          if (!target.hasMetadata("msgtoggle")) {
            if (target.hasPermission("citybuild.msg")) {
              target.sendMessage(CityBuildCore.instance.translateString(CityBuildCore.ds_msg.getString("message.msgtarget").replace("%PLAYER%", sender.getName()).replaceAll("%MESSAGE%", m)));
              sender.sendMessage(CityBuildCore.instance.translateString(CityBuildCore.ds_msg.getString("message.msgsender").replace("%PLAYER%", target.getName()).replaceAll("%MESSAGE%", m)));
              target.playSound(target.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
              if ((sender instanceof Player)) {
                Player p = (Player)sender;
                ((Player)sender).playSound(((Player)sender).getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
                if (p.hasMetadata("msgtoggle")) {
                  sender.sendMessage(CityBuildCore.instance.translateString(CityBuildCore.ds_msg.getString("message.msgtogglereminder")));
                }
              }
            } else {
              if ((sender instanceof Player)) {
                ((Player)sender).playSound(((Player)sender).getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
              }
              sender.sendMessage(CityBuildCore.instance.translateString(CityBuildCore.ds_msg.getString("message.msgnorank").replace("%PLAYER%", target.getName())));
            }
          } else {
            sender.sendMessage(CityBuildCore.instance.translateString(CityBuildCore.ds_msg.getString("message.msgblocked").replace("%PLAYER%", target.getName())));
            if ((sender instanceof Player)) {
              ((Player)sender).playSound(((Player)sender).getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
            }
          }
        } else {
          sender.sendMessage(CityBuildCore.instance.translateString(CityBuildPlugin.instance.getConfig().getString("messages.notOnline")));
          if ((sender instanceof Player)) {
            ((Player)sender).playSound(((Player)sender).getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
          }
        }
      } else {
        sender.sendMessage(CityBuildCore.instance.translateString(CityBuildPlugin.instance.getConfig().getString("messages.fSyntax") + "msg <Player> <Message>").replaceAll("&", "§"));
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
