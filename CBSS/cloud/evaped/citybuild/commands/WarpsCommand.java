package cloud.evaped.citybuild.commands;

import cloud.evaped.citybuild.main.CityBuildCore;
import cloud.evaped.citybuild.main.CityBuildPlugin;
import cloud.evaped.citybuild.utils.Warps;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class WarpsCommand implements org.bukkit.command.CommandExecutor
{
  public WarpsCommand() {}
  
  public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args)
  {
    if ((sender instanceof Player)) {
      Player p = (Player)sender;
      if (sender.hasPermission("citybuild.warps")) {
        if (args.length == 0) {
          Warps.instance.sendMessages(p);
        } else {
          sender.sendMessage(CityBuildCore.instance.translateString(CityBuildPlugin.instance.getConfig().getString("messages.fSyntax") + "warps").replaceAll("&", "§"));
          p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
        }
      } else {
        sender.sendMessage(CityBuildCore.instance.translateString(CityBuildPlugin.instance.getConfig().getString("messages.noPerm")));
        p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
      }
    } else {
      sender.sendMessage("You must be a Player, to use this Command!");
    }
    return false;
  }
}
