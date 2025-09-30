package cloud.evaped.citybuild.listener;

import cloud.evaped.citybuild.main.CityBuildPlugin;
import cloud.evaped.citybuild.utils.PlayerSaver;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerLoginEvent;

public class LoginListener implements org.bukkit.event.Listener
{
  public LoginListener() {}
  
  @org.bukkit.event.EventHandler
  public void onLogin(PlayerLoginEvent e)
  {
    Player p = e.getPlayer();
    
    if ((CityBuildPlugin.Maxplayers) && 
      (Bukkit.getOnlinePlayers().size() >= Bukkit.getMaxPlayers())) {
      if (p.hasPermission("citybuild.premiumjoin")) {
        e.allow();
      } else {
        e.disallow(org.bukkit.event.player.PlayerLoginEvent.Result.KICK_FULL, CityBuildPlugin.Maxplayers_msg);
      }
    }
    

    PlayerSaver.instance.createNewPlayer(p.getUniqueId().toString(), p.getName());
    p.setMetadata("loading", new org.bukkit.metadata.FixedMetadataValue(CityBuildPlugin.instance, Boolean.valueOf(true)));
  }
}
