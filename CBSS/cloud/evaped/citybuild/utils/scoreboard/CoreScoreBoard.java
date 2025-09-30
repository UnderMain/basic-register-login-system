package cloud.evaped.citybuild.utils.scoreboard;

import cloud.evaped.citybuild.MySQL.MySQL;
import cloud.evaped.citybuild.MySQL.MySQLEnum;
import cloud.evaped.citybuild.MySQL.MySQLMethods;
import cloud.evaped.citybuild.main.CityBuildCore;
import cloud.evaped.citybuild.main.CityBuildPlugin;
import cloud.evaped.citybuild.main.FileManager;
import cloud.evaped.citybuild.utils.DataSaver;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class CoreScoreBoard
{
  public Scoreboard board;
  private Player p;
  private HashMap<String, String> teams;
  private Boolean clantag;
  public String[] personalTeam;
  
  public CoreScoreBoard(Player p)
  {
    this.p = p;
    HashMap<String, Object> map = CacheScoreboard.getObject_ScoreBoard;
    
    board = Bukkit.getScoreboardManager().getNewScoreboard();
    
    Objective o = board.registerNewObjective("aaa", "bbb");
    o.setDisplaySlot(org.bukkit.scoreboard.DisplaySlot.SIDEBAR);
    o.setDisplayName((String)map.get("displayname"));
    
    int coins = 0;
    String ot = "";
    String tag = "";
    String date = CityBuildCore.instance.getDate();
    try {
      coins = CityBuildPlugin.mysqlMethods.loadIntFromMySQL(MySQLEnum.UUID, p.getUniqueId().toString(), "coinsTable", "coins").intValue();
      if (CityBuildPlugin.BungeeSystem) {
        tag = CityBuildPlugin.mysqlMethods.loadStringFromMySQL(MySQLEnum.UUID, p.getUniqueId().toString(), "friendsTable", "clan");
        ot = getOnlineTimeFormat(p.getName());
      }
    } catch (Exception e) {
      if (CityBuildPlugin.debug) {
        e.printStackTrace();
      }
    }
    
    List<String> list1 = (List)map.get("scoreboard");
    String rankname = getScoreboardRankName(p);
    for (int i = 0; i < list1.size(); i++)
    {





      String s = ((String)list1.get(i)).replace("%COINS%", "" + coins).replace("%DATE%", "" + date).replace("%NAME%", p.getName()).replace("%TIME%", getOnlineTime()).replace("%ONLINETIME%", ot).replace("%CLAN%", tag).replace("%RANK%", rankname);
      
      String suffix = null;
      Team st = board.registerNewTeam("st" + i);
      String prefix;
      if (s.length() >= 16) {
        String prefix = s.substring(0, 16);
        if (s.length() >= 17) {
          suffix = ChatColor.getLastColors(prefix) + s.substring(16);
        }
        if ((suffix != null) && (suffix.length() >= 16)) suffix = suffix.substring(0, 16);
      } else {
        prefix = s;
      }
      st.setPrefix(prefix);
      if (suffix != null) {
        st.setSuffix(suffix);
      }
      
      st.addEntry((String)getScoreboardColor().get(i));
      o.getScore((String)getScoreboardColor().get(i)).setScore(list1.size() - i);
    }
    
    teams = ((HashMap)map.get("teams"));
    clantag = ((Boolean)map.get("clantags"));
    
    setTeams();
  }
  
  private void setTeams()
  {
    new CachePlayer().loadPlayer(p);
    Team team; if (!clantag.booleanValue()) {
      team = board.registerNewTeam("999Team");
      team.setPrefix(CacheScoreboard.ds_tab.getString("default.prefix"));
      for (String s : teams.keySet()) {
        try {
          Team team1 = board.registerNewTeam(s);
          team1.setPrefix((String)teams.get(s));
        } catch (Exception localException) {}
      }
      for (??? = Bukkit.getOnlinePlayers().iterator(); ???.hasNext();) { all = (Player)???.next();
        String TEAMNAME = (String)CachePlayer.getTeamName.get(all.getUniqueId().toString());
        if (TEAMNAME == null) {
          new CachePlayer().loadPlayer(all);
          TEAMNAME = (String)CachePlayer.getTeamName.get(all.getUniqueId().toString());
        }
        board.getTeam(TEAMNAME).addPlayer(all); }
      Player all;
      String teamname = (String)CachePlayer.getTeamName.get(p.getUniqueId().toString());
      for (Player all : Bukkit.getOnlinePlayers()) {
        if ((all != p) && 
          (CachePlayer.getBoard.containsKey(all.getUniqueId().toString()))) {
          getBoardgetgetUniqueIdtoStringboard.getTeam(teamname).addPlayer(p);
        }
      }
      setBoard();
    } else {
      personalTeam = getTeamClanTag(p);
      if (!Bukkit.getOnlinePlayers().isEmpty()) {
        for (Player all : Bukkit.getOnlinePlayers()) {
          if (all != p) {
            CoreScoreBoard cb = (CoreScoreBoard)CachePlayer.getBoard.get(all.getUniqueId().toString());
            if (cb != null) {
              Team team = board.registerNewTeam(personalTeam[0]);
              team.setPrefix(personalTeam[1]);
              team.setSuffix(personalTeam[2]);
              team.addPlayer(p);
              Team team1 = board.registerNewTeam(personalTeam[0]);
              team1.setPrefix(personalTeam[1]);
              team1.setSuffix(personalTeam[2]);
              team1.addPlayer(all);
            }
          }
        }
        Team team1 = board.registerNewTeam(personalTeam[0]);
        team1.setPrefix(personalTeam[1]);
        team1.setSuffix(personalTeam[2]);
        team1.addPlayer(p);
      }
      setBoard();
    }
    CachePlayer.getBoard.put(p.getUniqueId().toString(), this);
  }
  
  public String[] getTeamClanTag(Player p) {
    String[] array = { "", "", "" };
    array[0] = ((String)CachePlayer.getTeamName.get(p.getUniqueId().toString()) + "" + randomInt(p.getUniqueId().toString()));
    array[1] = ((String)teams.get(CachePlayer.getTeamName.get(p.getUniqueId().toString())));
    
    List<String> info = ScoreboardUtils.instance.getClantag(p.getUniqueId().toString());
    if (p.hasMetadata("spec")) {
      array[2] = CityBuildPlugin.spec_suffix;
    }
    else if (!((String)info.get(0)).equals("none")) {
      array[2] = (" §8[§" + (String)info.get(1) + (String)info.get(0) + "§8]");
    }
    

    return array;
  }
  
  private String[] getFakeTeamClanTag(Player p) {
    String[] array = { "", "", "" };
    array[0] = ((String)CachePlayer.getTeamName.get(p.getUniqueId().toString()) + "" + randomInt(p.getUniqueId().toString()));
    array[1] = ((String)teams.get(CachePlayer.getTeamName.get(p.getUniqueId().toString())));
    return array;
  }
  
  private void setBoard() {
    p.setScoreboard(board);
  }
  
  private String randomInt(String uuid) {
    Random r = new Random();
    int i = r.nextInt(1000);
    String id = uuid.split("-")[2] + i;
    return id;
  }
  
  public void nickPlayer() {
    CachePlayer.getTeamName.remove(p.getUniqueId().toString());
    CachePlayer.getTeamName.put(p.getUniqueId().toString(), new CachePlayer().getTeamPlayer(p));
    String teamname; if (!clantag.booleanValue()) {
      teamname = (String)CachePlayer.getTeamName.get(p.getUniqueId().toString());
      if (teamname == null) {
        teamname = new CachePlayer().getTeamPlayer(p);
      }
      for (Player all : Bukkit.getOnlinePlayers()) {
        getBoardgetgetUniqueIdtoStringboard.getTeam(teamname).addPlayer(p);
      }
    } else {
      String oldname = personalTeam[0];
      personalTeam = getFakeTeamClanTag(p);
      for (Player all : Bukkit.getOnlinePlayers()) {
        if (all != p) {
          CoreScoreBoard cb = (CoreScoreBoard)CachePlayer.getBoard.get(all.getUniqueId().toString());
          Team team = board.registerNewTeam(personalTeam[0]);
          team.setPrefix(personalTeam[1]);
          team.addPlayer(p);
        }
      }
      board.getTeam(oldname).unregister();
      Team team1 = board.registerNewTeam(personalTeam[0]);
      team1.setPrefix(personalTeam[1]);
      team1.addPlayer(p);
    }
  }
  
  public void unnickPlayer() {
    CachePlayer.getTeamName.remove(p.getUniqueId().toString());
    CachePlayer.getTeamName.put(p.getUniqueId().toString(), new CachePlayer().getTeamPlayer(p));
    String teamname; if (!clantag.booleanValue()) {
      teamname = (String)CachePlayer.getTeamName.get(p.getUniqueId().toString());
      if (teamname == null) {
        teamname = new CachePlayer().getTeamPlayer(p);
      }
      for (Player all : Bukkit.getOnlinePlayers()) {
        getBoardgetgetUniqueIdtoStringboard.getTeam(teamname).addPlayer(p);
      }
    } else {
      String oldname = personalTeam[0];
      personalTeam = getTeamClanTag(p);
      for (Player all : Bukkit.getOnlinePlayers()) {
        if (all != p) {
          CoreScoreBoard cb = (CoreScoreBoard)CachePlayer.getBoard.get(all.getUniqueId().toString());
          board.getTeam(oldname).unregister();
          Team team = board.registerNewTeam(personalTeam[0]);
          team.setPrefix(personalTeam[1]);
          team.setSuffix(personalTeam[2]);
          team.addPlayer(p);
        }
      }
      board.getTeam(oldname).unregister();
      Team team1 = board.registerNewTeam(personalTeam[0]);
      team1.setPrefix(personalTeam[1]);
      team1.setSuffix(personalTeam[2]);
      team1.addPlayer(p);
    }
  }
  
  private List<String> getScoreboardColor() {
    List<String> list = new java.util.ArrayList();
    list.add(ChatColor.BLACK.toString());
    list.add(ChatColor.DARK_AQUA.toString());
    list.add(ChatColor.AQUA.toString());
    list.add(ChatColor.BLUE.toString());
    list.add(ChatColor.DARK_BLUE.toString());
    list.add(ChatColor.DARK_GRAY.toString());
    list.add(ChatColor.YELLOW.toString());
    list.add(ChatColor.WHITE.toString());
    list.add(ChatColor.DARK_GREEN.toString());
    list.add(ChatColor.GREEN.toString());
    list.add(ChatColor.DARK_RED.toString());
    list.add(ChatColor.RED.toString());
    list.add(ChatColor.GOLD.toString());
    list.add(ChatColor.GRAY.toString());
    list.add(ChatColor.LIGHT_PURPLE.toString());
    list.add(ChatColor.DARK_PURPLE.toString());
    return list;
  }
  
  public void updateCoins(Player p) {
    if (CacheScoreboard.getObject_ScoreBoard.containsKey("pos_coins")) {
      Team team = board.getTeam("st" + CacheScoreboard.getObject_ScoreBoard.get("pos_coins"));
      String s = "" + CacheScoreboard.getObject_ScoreBoard.get("field_coins");
      s = s.replace("%COINS%", "" + CityBuildPlugin.mysqlMethods.loadIntFromCache(p.getUniqueId().toString(), "coinsTable", "coins"));
      

      String suffix = "";
      String prefix; if (s.length() >= 16) {
        String prefix = s.substring(0, 16);
        if (s.length() >= 17) {
          suffix = ChatColor.getLastColors(prefix) + s.substring(16);
        }
        if ((!suffix.equals("")) && (suffix.length() >= 16)) {
          suffix = suffix.substring(0, 16);
        }
      } else {
        prefix = s;
      }
      
      team.setPrefix(prefix);
      team.setSuffix(suffix);
    }
  }
  
  public void updateOnlineTime(Player p) {
    if (CacheScoreboard.getObject_ScoreBoard.containsKey("pos_time")) {
      Team team = board.getTeam("st" + CacheScoreboard.getObject_ScoreBoard.get("pos_time"));
      String s = "" + CacheScoreboard.getObject_ScoreBoard.get("field_time");
      s = s.replace("%TIME%", "" + getOnlineTime());
      

      String suffix = "";
      String prefix; if (s.length() >= 16) {
        String prefix = s.substring(0, 16);
        if (s.length() >= 17) {
          suffix = ChatColor.getLastColors(prefix) + s.substring(16);
        }
        if ((!suffix.equals("")) && (suffix.length() >= 16)) {
          suffix = suffix.substring(0, 16);
        }
      } else {
        prefix = s;
      }
      
      team.setPrefix(prefix);
      team.setSuffix(suffix);
    }
  }
  
  private String getOnlineTime() {
    int time = CityBuildPlugin.mysqlMethods.loadIntFromMySQL(MySQLEnum.UUID, p.getUniqueId().toString(), CityBuildPlugin.MySQLTable, "onlinetime").intValue();
    
    if (time < 60) {
      return CityBuildPlugin.instance.getConfig().getString("Messages.ot_min").replace("%VALUE%", "" + time);
    }
    int hour = 0;
    while (time >= 60) {
      time -= 60;
      hour += 1;
    }
    return CityBuildPlugin.instance.getConfig().getString("Messages.ot_hour").replace("%VALUE%", "" + hour);
  }
  

  public void updateScoreboardRank(Player p)
  {
    if (CacheScoreboard.getObject_ScoreBoard.containsKey("pos_rank")) {
      Team team = board.getTeam("st" + CacheScoreboard.getObject_ScoreBoard.get("pos_rank"));
      String s = "" + CacheScoreboard.getObject_ScoreBoard.get("field_rank");
      s = s.replace("%RANK%", "" + getScoreboardRankName(p));
      

      String suffix = "";
      String prefix; if (s.length() >= 16) {
        String prefix = s.substring(0, 16);
        if (s.length() >= 17) {
          suffix = ChatColor.getLastColors(prefix) + s.substring(16);
        }
        if ((!suffix.equals("")) && (suffix.length() >= 16)) {
          suffix = suffix.substring(0, 16);
        }
      } else {
        prefix = s;
      }
      
      team.setPrefix(prefix);
      team.setSuffix(suffix);
    }
  }
  
  private String getScoreboardRankName(Player p) {
    DataSaver ds_sbrank = new DataSaver(FileManager.getObject_Scoreboardnames);
    String s = ds_sbrank.getString("default.format");
    if ((cloud.evaped.citybuild.utils.nick.Nick.isNicked.containsKey(p)) && (ds_sbrank.getBoolean("nick.replaced"))) {
      if (CityBuildPlugin.mysqlMethods.loadIntFromMySQL(MySQLEnum.UUID, p.getUniqueId().toString(), "nickTable", "premiumnick").intValue() == 1) {
        int i1 = ds_sbrank.getInt("nick.numberforpremium");
        return ds_sbrank.getString(i1 + ".format");
      }
      return s;
    }
    
    for (int i = 0; i <= FileManager.getTeamSize; i++) {
      if ((ds_sbrank.contains(i + ".perm")) && 
        (p.hasPermission(ds_sbrank.getString(i + ".perm")))) {
        return ds_sbrank.getString(i + ".format");
      }
    }
    
    return s;
  }
  
  public String getOnlineTimeFormat(String name) {
    long ot = getOnlineTime(name);
    if (ot < 60L) {
      return CityBuildPlugin.instance.getConfig().getString("Messages.ot_min").replace("%VALUE%", ot + "");
    }
    ot /= 60L;
    return CityBuildPlugin.instance.getConfig().getString("Messages.ot_hour").replace("%VALUE%", ot + "");
  }
  
  public long getOnlineTime(String name)
  {
    ResultSet rs = null;
    try
    {
      rs = MySQL.instance.getResult("SELECT onlinetime FROM friendsTable WHERE name='" + name + "'");
      
      if (rs.next()) {
        return rs.getLong("onlinetime");
      }
      















      return 0L;
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
