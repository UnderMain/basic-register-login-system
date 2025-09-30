package cloud.evaped.citybuild.utils;

import cloud.evaped.citybuild.MySQL.MySQL;
import cloud.evaped.citybuild.main.CityBuildPlugin;
import cloud.evaped.citybuild.utils.scoreboard.CachePlayer;
import cloud.evaped.citybuild.utils.scoreboard.CoreScoreBoard;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class SpecMode
{
  public static SpecMode instance;
  
  public SpecMode()
  {
    instance = this;
  }
  
  public boolean checkSpecMode(Player p) {
    if ((p.hasPermission("bungee.specmode")) && (CityBuildPlugin.BungeeSystem)) {
      if (getSpecMode(p.getUniqueId().toString())) {
        setSpecMode(p);
        return true;
      }
      if (p.hasMetadata("spec")) {
        changeMySQLState(p);
      }
      return false;
    }
    
    if (p.hasMetadata("spec")) {
      changeMySQLState(p);
    }
    return false;
  }
  
  public void manageSpecMode(Player p)
  {
    if ((p.hasPermission("bungee.specmode")) && (CityBuildPlugin.BungeeSystem)) {
      changeMySQLState(p);
    }
  }
  
  public void setSpecMode(Player p) {
    p.setMetadata("spec", new org.bukkit.metadata.FixedMetadataValue(CityBuildPlugin.instance, Boolean.valueOf(true)));
    p.setAllowFlight(true);
    p.setFlying(true);
    if (!CityBuildPlugin.mysqlMethods.containsMySQL(cloud.evaped.citybuild.MySQL.MySQLEnum.UUID, p.getUniqueId().toString(), "teamTable")) {
      registerMySQLState(p);
    }
    p.setGameMode(org.bukkit.GameMode.SPECTATOR);
    
    setSB(p);
  }
  
  public void removeSpecMode(Player p) {
    p.removeMetadata("spec", CityBuildPlugin.instance);
    p.setFlying(false);
    p.setAllowFlight(false);
    p.setFlySpeed(0.2F);
    p.setWalkSpeed(0.2F);
    p.setGameMode(org.bukkit.GameMode.SURVIVAL);
    
    removeSB(p);
  }
  
  public void setSB(final Player p) {
    Bukkit.getScheduler().scheduleSyncDelayedTask(CityBuildPlugin.getPlugin(CityBuildPlugin.class), new Runnable() {
      public void run() {
        for (Iterator localIterator = Bukkit.getOnlinePlayers().iterator(); localIterator.hasNext();) { all = (Player)localIterator.next();
          if (!all.hasPermission("bungee.specmode")) all.hidePlayer(p); }
        Player all;
        String teamname = getBoardgetpgetUniqueIdtoStringpersonalTeam[0];
        if (teamname == null) {
          teamname = new CachePlayer().getTeamPlayer(p);
        }
        for (Player all : Bukkit.getOnlinePlayers()) {
          Scoreboard b = getBoardgetgetUniqueIdtoStringboard;
          Team team = b.getTeam(teamname);
          team.setSuffix(CityBuildPlugin.spec_suffix); } } }, 20L);
  }
  


  public void removeSB(final Player p)
  {
    Bukkit.getScheduler().scheduleSyncDelayedTask(CityBuildPlugin.getPlugin(CityBuildPlugin.class), new Runnable() { public void run() { String teamname;
        String teamname;
        if (((Boolean)cloud.evaped.citybuild.utils.scoreboard.CacheScoreboard.getObject_ScoreBoard.get("clantags")).booleanValue()) {
          teamname = getBoardgetpgetUniqueIdtoStringpersonalTeam[0];
          if (teamname == null) {
            teamname = new CachePlayer().getTeamPlayer(p);
          }
          for (Player all : Bukkit.getOnlinePlayers()) {
            String[] array = ((CoreScoreBoard)CachePlayer.getBoard.get(all.getUniqueId().toString())).getTeamClanTag(p);
            if (array[2].equalsIgnoreCase("none")) {
              getBoardgetgetUniqueIdtoStringboard.getTeam(teamname).setSuffix("");
            } else {
              getBoardgetgetUniqueIdtoStringboard.getTeam(teamname).setSuffix(array[2]);
            }
          }
        } else {
          teamname = getBoardgetpgetUniqueIdtoStringpersonalTeam[0];
          if (teamname == null) {
            teamname = new CachePlayer().getTeamPlayer(p);
          }
          for (Player all : Bukkit.getOnlinePlayers()) {
            String[] array = ((CoreScoreBoard)CachePlayer.getBoard.get(all.getUniqueId().toString())).getTeamClanTag(p);
            if (!array[2].equalsIgnoreCase("none"))
            {

              getBoardgetgetUniqueIdtoStringboard.getTeam(teamname).setSuffix("");
            }
          }
        }
        for (Player all : Bukkit.getOnlinePlayers())
          all.showPlayer(p); } }, 20L);
  }
  


  public void changeMySQLState(Player p)
  {
    int i = 0;
    if (!p.hasMetadata("spec")) {
      i = 1;
      setSpecMode(p);
    } else {
      removeSpecMode(p);
    }
    
    PreparedStatement st = null;
    
    try
    {
      st = MySQL.con.prepareStatement("UPDATE teamTable SET rm=? WHERE UUID=?");
      st.setInt(1, i);
      st.setString(2, p.getUniqueId().toString());
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
  


  public void registerMySQLState(Player p)
  {
    PreparedStatement st = null;
    
    try
    {
      st = MySQL.con.prepareStatement("INSERT INTO teamTable (UUID, name, rm) VALUES (?, ?, ?)");
      st.setString(1, p.getUniqueId().toString());
      st.setString(2, p.getName());
      st.setInt(3, 1);
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
  

  public boolean getSpecMode(String UUID)
  {
    b = false;
    ResultSet rs = null;
    
    try
    {
      rs = MySQL.instance.getResult("SELECT rm FROM teamTable WHERE UUID='" + UUID + "'");
      
      if (rs.next()) {
        int i = rs.getInt("rm");
        if (i != 1) {} }
      return true;

    }
    catch (SQLException e)
    {
      if (CityBuildPlugin.debug) {
        e.printStackTrace();
      }
    } finally {
      if (rs != null) {
        try {
          rs.close();
        } catch (SQLException e) {
          if (CityBuildPlugin.debug) {
            e.printStackTrace();
          }
        }
      }
    }
  }
}
