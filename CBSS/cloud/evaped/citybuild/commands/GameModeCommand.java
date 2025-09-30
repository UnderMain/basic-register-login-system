package cloud.evaped.citybuild.commands;

import cloud.evaped.citybuild.main.CityBuildCore;
import cloud.evaped.citybuild.main.CityBuildPlugin;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GameModeCommand implements org.bukkit.command.CommandExecutor
{
  public GameModeCommand() {}
  
  public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args)
  {
    if (args.length == 1) {
      if ((args[0].equalsIgnoreCase("0")) || (args[0].equalsIgnoreCase("1")) || (args[0].equalsIgnoreCase("2")) || (args[0].equalsIgnoreCase("3"))) {
        if ((sender instanceof Player)) {
          if ((sender.hasPermission("citybuild.gamemode")) || (sender.hasPermission("citybuild.gamemode." + args[0]))) {
            Player p = (Player)sender;
            
            if (args[0].equalsIgnoreCase("0")) {
              p.setGameMode(GameMode.SURVIVAL);
              ((Player)sender).playSound(((Player)sender).getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
              sender.sendMessage(CityBuildCore.instance.translateString(CityBuildCore.ds_msg.getString("message.gamemode0you")));
            } else if (args[0].equalsIgnoreCase("1")) {
              p.setGameMode(GameMode.CREATIVE);
              ((Player)sender).playSound(((Player)sender).getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
              sender.sendMessage(CityBuildCore.instance.translateString(CityBuildCore.ds_msg.getString("message.gamemode1you")));
            } else if (args[0].equalsIgnoreCase("2")) {
              p.setGameMode(GameMode.ADVENTURE);
              ((Player)sender).playSound(((Player)sender).getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
              sender.sendMessage(CityBuildCore.instance.translateString(CityBuildCore.ds_msg.getString("message.gamemode2you")));
            } else if (args[0].equalsIgnoreCase("3")) {
              p.setGameMode(GameMode.SPECTATOR);
              ((Player)sender).playSound(((Player)sender).getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
              sender.sendMessage(CityBuildCore.instance.translateString(CityBuildCore.ds_msg.getString("message.gamemode3you")));
            } else {
              sender.sendMessage(CityBuildCore.instance.translateString(CityBuildPlugin.instance.getConfig().getString("messages.fSyntax") + "gm <0-3> [Player]").replaceAll("&", "§"));
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
      } else {
        sender.sendMessage(CityBuildCore.instance.translateString(CityBuildPlugin.instance.getConfig().getString("messages.noPerm")));
        if ((sender instanceof Player)) {
          ((Player)sender).playSound(((Player)sender).getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
        }
      }
    } else if (args.length == 2) {
      if (sender.hasPermission("citybuild.gamemode")) {
        Player target = org.bukkit.Bukkit.getPlayer(args[1]);
        
        if (target != null)
        {
          if (args[0].equalsIgnoreCase("0")) {
            sender.sendMessage(CityBuildCore.instance.translateString(CityBuildCore.ds_msg.getString("message.gamemode0other").replace("%PLAYER%", target.getName())));
            target.setGameMode(GameMode.SURVIVAL);
            ((Player)sender).playSound(((Player)sender).getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
          } else if (args[0].equalsIgnoreCase("1")) {
            sender.sendMessage(CityBuildCore.instance.translateString(CityBuildCore.ds_msg.getString("message.gamemode1other").replace("%PLAYER%", target.getName())));
            target.setGameMode(GameMode.CREATIVE);
            ((Player)sender).playSound(((Player)sender).getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
          } else if (args[0].equalsIgnoreCase("2")) {
            sender.sendMessage(CityBuildCore.instance.translateString(CityBuildCore.ds_msg.getString("message.gamemode2other").replace("%PLAYER%", target.getName())));
            target.setGameMode(GameMode.ADVENTURE);
            ((Player)sender).playSound(((Player)sender).getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
          } else if (args[0].equalsIgnoreCase("3")) {
            sender.sendMessage(CityBuildCore.instance.translateString(CityBuildCore.ds_msg.getString("message.gamemode3other").replace("%PLAYER%", target.getName())));
            target.setGameMode(GameMode.SPECTATOR);
            ((Player)sender).playSound(((Player)sender).getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
          } else {
            sender.sendMessage(CityBuildCore.instance.translateString(CityBuildPlugin.instance.getConfig().getString("messages.fSyntax") + "gm <0-3> [Player]").replaceAll("&", "§"));
            if ((sender instanceof Player)) {
              ((Player)sender).playSound(((Player)sender).getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
            }
          }
        }
        else {
          sender.sendMessage(CityBuildCore.instance.translateString(CityBuildPlugin.instance.getConfig().getString("messages.notOnline")));
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
      sender.sendMessage(CityBuildCore.instance.translateString(CityBuildPlugin.instance.getConfig().getString("messages.fSyntax") + "gm <0-3> [Player]").replaceAll("&", "§"));
      if ((sender instanceof Player)) {
        ((Player)sender).playSound(((Player)sender).getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
      }
    }
    
    return false;
  }
}
