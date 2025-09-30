package cloud.evaped.citybuild.commands;

import cloud.evaped.citybuild.main.CityBuildCore;
import cloud.evaped.citybuild.main.CityBuildPlugin;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class MSGToggleCommand implements org.bukkit.command.CommandExecutor
{
  public MSGToggleCommand() {}
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if ((sender instanceof Player)) {
      Player p = (Player)sender;
      
      if (sender.hasPermission("citybuild.msgtoggle")) {
        if (args.length >= 0) {
          if (p.hasMetadata("msgtoggle")) {
            p.removeMetadata("msgtoggle", CityBuildPlugin.instance);
            p.sendMessage(CityBuildCore.instance.translateString(CityBuildCore.ds_msg.getString("message.msgtoggleleave")));
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
          } else {
            p.setMetadata("msgtoggle", new org.bukkit.metadata.FixedMetadataValue(CityBuildPlugin.instance, Boolean.valueOf(true)));
            p.sendMessage(CityBuildCore.instance.translateString(CityBuildCore.ds_msg.getString("message.msgtogglejoin")));
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
          }
        } else {
          sender.sendMessage(CityBuildCore.instance.translateString(CityBuildPlugin.instance.getConfig().getString("messages.fSyntax") + "msgtoggle"));
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
    }
    
    return false;
  }
}
