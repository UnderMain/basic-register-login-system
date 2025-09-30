package cloud.evaped.citybuild.listener;

import cloud.evaped.citybuild.MySQL.MySQLMethods;
import cloud.evaped.citybuild.main.CityBuildCore;
import cloud.evaped.citybuild.main.CityBuildPlugin;
import cloud.evaped.citybuild.utils.nick.Nick;
import cloud.evaped.citybuild.utils.scoreboard.CachePlayer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements org.bukkit.event.Listener
{
  public QuitListener() {}
  
  @EventHandler
  public void onQuit(PlayerQuitEvent e)
  {
    final Player p = e.getPlayer();
    e.setQuitMessage(null);
    final Player player = p;
    CityBuildPlugin.mysqlMethods.setIntFromMySQLNoCacheUpdate(cloud.evaped.citybuild.MySQL.MySQLEnum.UUID, p.getUniqueId().toString(), CityBuildPlugin.MySQLTable, "online", 0);
    
    if (CityBuildCore.getVanishPlayer.contains(p)) {
      for (Player all : org.bukkit.Bukkit.getOnlinePlayers()) {
        p.hidePlayer(all);
      }
      CityBuildCore.getVanishPlayer.remove(p);
    }
    CityBuildCore.getPlayerInEditMode.remove(e.getPlayer());
    
    if (Nick.isNicked.containsKey(p))
    {





      new org.bukkit.scheduler.BukkitRunnable()
      {
        public void run()
        {
          Nick.instance.destroyPlayer(player);
          CachePlayer.getBoard.remove(p.getUniqueId().toString());
          CachePlayer.getTeamName.remove(p.getUniqueId().toString()); } }
      
        .runTaskLater(CityBuildPlugin.instance, 4L);
    } else {
      CachePlayer.getBoard.remove(p.getUniqueId().toString());
      CachePlayer.getTeamName.remove(p.getUniqueId().toString());
    }
    MySQLMethods.getGroupID.remove(p.getName());
  }
}
