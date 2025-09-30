package cloud.evaped.citybuild.commands;

import cloud.evaped.citybuild.MySQL.MySQLcoinsTable;
import cloud.evaped.citybuild.main.CityBuildCore;
import cloud.evaped.citybuild.main.CityBuildPlugin;
import cloud.evaped.citybuild.utils.scoreboard.CoreScoreBoard;
import java.util.UUID;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class CoinsCommand implements org.bukkit.command.CommandExecutor
{
  public CoinsCommand() {}
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (sender.hasPermission("citybuild.coins")) {
      if (args.length == 3) {
        try {
          int i = Integer.parseInt(args[2]);
          if (i <= 0) {
            sender.sendMessage(CityBuildCore.instance.translateString("The Amount must be over 0!"));
            if ((sender instanceof Player)) {
              ((Player)sender).playSound(((Player)sender).getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
            }
            return true;
          }
        } catch (NumberFormatException e) {
          sender.sendMessage(CityBuildCore.instance.translateString(args[2] + " is not a number!"));
          if ((sender instanceof Player)) {
            ((Player)sender).playSound(((Player)sender).getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
          }
          return true;
        }
        int coins = Integer.valueOf(args[2]).intValue();
        Player target = org.bukkit.Bukkit.getPlayer(args[1]);
        if (target == null) {
          sender.sendMessage(CityBuildCore.instance.translateString(CityBuildPlugin.instance.getConfig().getString("messages.notOnline")));
          return false;
        }
        if (args[0].equalsIgnoreCase("set")) {
          sender.sendMessage(CityBuildCore.instance.translateString("The Player §b" + args[1] + " §7has now §e" + coins + " §7Coins."));
          MySQLcoinsTable.instance.setCoins(target.getUniqueId().toString(), coins);
        } else if (args[0].equalsIgnoreCase("add")) {
          sender.sendMessage(CityBuildCore.instance
            .translateString("The Player §b" + args[1] + " §7has now §e" + coins + " §7Coins more."));
          MySQLcoinsTable.instance.addCoins(target.getUniqueId().toString(), coins);
        } else if (args[0].equalsIgnoreCase("remove")) {
          sender.sendMessage(CityBuildCore.instance
            .translateString("The Player §b" + args[1] + " §7has now §e" + coins + " §7Coins less."));
          MySQLcoinsTable.instance.removeCoins(target.getUniqueId().toString(), coins);
        } else {
          sender.sendMessage(CityBuildCore.instance.translateString(CityBuildPlugin.instance.getConfig().getString("messages.fSyntax") + "coins <set/add/remove> <Name> <Amount>"));
          
          if ((sender instanceof Player)) {
            ((Player)sender).playSound(((Player)sender).getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
          }
        }
        if (target != null) {
          ((CoreScoreBoard)cloud.evaped.citybuild.utils.scoreboard.CachePlayer.getBoard.get(target.getUniqueId().toString())).updateCoins(target);
        }
      } else {
        sender.sendMessage(CityBuildCore.instance.translateString(CityBuildPlugin.instance
          .getConfig().getString("messages.fSyntax") + "coins <set/add/remove> <Name> <Amount>"));
        if ((sender instanceof Player)) {
          ((Player)sender).playSound(((Player)sender).getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
        }
      }
    }
    else {
      sender.sendMessage(CityBuildCore.instance.translateString(CityBuildPlugin.instance.getConfig().getString("messages.noPerm")));
      if ((sender instanceof Player)) {
        ((Player)sender).playSound(((Player)sender).getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
      }
    }
    
    return false;
  }
}
