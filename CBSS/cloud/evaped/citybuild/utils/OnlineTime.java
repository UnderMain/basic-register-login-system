package cloud.evaped.citybuild.utils;

import cloud.evaped.citybuild.MySQL.MySQL;
import cloud.evaped.citybuild.main.CityBuildPlugin;
import cloud.evaped.citybuild.utils.scoreboard.CachePlayer;
import cloud.evaped.citybuild.utils.scoreboard.CoreScoreBoard;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;

public class OnlineTime
{
  private static final ExecutorService EXECUTOR_SERVICE = ;
  
  public OnlineTime() {
    updateOnlineTime();
  }
  
  private void updateOnlineTime() {
    Bukkit.getScheduler().scheduleSyncRepeatingTask(CityBuildPlugin.getPlugin(CityBuildPlugin.class), new Runnable()
    {
      public void run() {
        OnlineTime.EXECUTOR_SERVICE.execute(new Runnable() {
          public void run() {
            PreparedStatement st = null;
            
            try
            {
              st = MySQL.con.prepareStatement("UPDATE " + CityBuildPlugin.MySQLTable + " SET onlinetime = onlinetime+1 WHERE online = ?");
              
              st.setString(1, "1");
              
              st.executeUpdate(); return;
            }
            catch (SQLException e) {
              if (CityBuildPlugin.debug) {
                e.printStackTrace();
              }
            } finally {
              if (st != null) {
                try {
                  st.close();
                } catch (SQLException e) {
                  if (CityBuildPlugin.debug) {
                    e.printStackTrace();
                  }
                }
              }
            }
          }
        });
        

        for (Player all : Bukkit.getOnlinePlayers())
          if (CachePlayer.getBoard.containsKey(all.getUniqueId().toString()))
            ((CoreScoreBoard)CachePlayer.getBoard.get(all.getUniqueId().toString())).updateOnlineTime(all); } }, 100L, 2400L);
  }
}
