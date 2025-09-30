package cloud.evaped.citybuild.listener;

import cloud.evaped.citybuild.main.CityBuildCore;
import cloud.evaped.citybuild.main.CityBuildPlugin;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.help.HelpMap;

public class UCMListener implements Listener
{
  private String s1;
  
  public UCMListener()
  {
    s1 = CityBuildPlugin.instance.getConfig().getString("UCM_message").replaceAll("&", "§");
  }
  
  @EventHandler
  public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent e) {
    Player p = e.getPlayer();
    String msg = e.getMessage().split(" ")[0];
    org.bukkit.help.HelpTopic h = org.bukkit.Bukkit.getHelpMap().getHelpTopic(msg);
    if (h == null) {
      e.setCancelled(true);
      p.sendMessage(CityBuildCore.instance.translateString(s1).replace("%COMMAND%", msg));
    }
  }
}
