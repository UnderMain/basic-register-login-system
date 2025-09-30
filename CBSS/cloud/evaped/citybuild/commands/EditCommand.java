package cloud.evaped.citybuild.commands;

import cloud.evaped.citybuild.main.CityBuildCore;
import cloud.evaped.citybuild.main.CityBuildPlugin;
import java.util.ArrayList;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EditCommand implements org.bukkit.command.CommandExecutor
{
  public EditCommand() {}
  
  public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args)
  {
    if ((sender instanceof Player)) {
      Player p = (Player)sender;
      if (p.hasPermission("citybuild.editmode")) {
        if (args.length == 0) {
          if (!CityBuildCore.getPlayerInEditMode.contains(p)) {
            p.playSound(p.getLocation(), Sound.LAVA_POP, 1.0F, 1.0F);
            p.setGameMode(GameMode.CREATIVE);
            p.setFlying(true);
            p.sendMessage(CityBuildCore.instance
              .translateString("§8§m------------------------------------------------"));
            p.sendMessage(CityBuildCore.instance.translateString("You are now in §bedit mode§7! You can use §b/editmap, /editshop, /editcase §7for setup!"));
            
            p.sendMessage("");
            sendInfoMessgae(p);
            p.sendMessage("");
            p.sendMessage(CityBuildCore.instance.translateString("§8§m------------------------------------------------"));
            CityBuildCore.getPlayerInEditMode.add(p);
          } else {
            p.playSound(p.getLocation(), Sound.LAVA_POP, 1.0F, 1.0F);
            p.setGameMode(GameMode.SURVIVAL);
            p.sendMessage(CityBuildCore.instance.translateString("You are no longer in §bedit mode§7!"));
            CityBuildCore.getPlayerInEditMode.remove(p);
          }
        } else {
          p.sendMessage(CityBuildCore.instance
            .translateString(CityBuildPlugin.instance.getConfig().getString("messages.fSyntax") + "edit"));
          p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
        }
      } else {
        p.sendMessage(CityBuildCore.instance.translateString(CityBuildPlugin.instance.getConfig().getString("messages.noPerm")));
        p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
      }
    } else {
      sender.sendMessage("You must be a Player, to use this Command!");
    }
    
    return false;
  }
  

  public void sendInfoMessgae(Player p)
  {
    String s2 = "";
    if (cloud.evaped.citybuild.MySQL.MySQL.instance.isConnected()) {
      s2 = "The MySQL Database is §asuccsesfully §7connected";
    } else {
      s2 = "The MySQL Database §ccannot connect §7to the server";
    }
    p.sendMessage(CityBuildCore.instance.translateString(s2));
  }
}
