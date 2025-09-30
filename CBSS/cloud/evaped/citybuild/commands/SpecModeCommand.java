package cloud.evaped.citybuild.commands;

import cloud.evaped.citybuild.main.CityBuildCore;
import cloud.evaped.citybuild.main.CityBuildPlugin;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpecModeCommand implements org.bukkit.command.CommandExecutor
{
  public SpecModeCommand() {}
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if ((sender instanceof Player)) {
      if (sender.hasPermission("bungee.specmode")) {
        Player p = (Player)sender;
        if (args.length == 0) {
          cloud.evaped.citybuild.utils.SpecMode.instance.manageSpecMode(p);
          p.playSound(p.getLocation(), Sound.WOOD_CLICK, 1.0F, 1.0F);
        } else {
          p.sendMessage(CityBuildCore.instance.translateString(CityBuildPlugin.instance.getConfig().getString("messages.fSyntax") + "specmode"));
          p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
        }
      }
    } else {
      sender.sendMessage("You must be a Player, to use this Command!");
    }
    
    return false;
  }
}
