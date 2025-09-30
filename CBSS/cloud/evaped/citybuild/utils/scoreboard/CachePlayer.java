package cloud.evaped.citybuild.utils.scoreboard;

import cloud.evaped.citybuild.MySQL.MySQLEnum;
import cloud.evaped.citybuild.MySQL.MySQLMethods;
import cloud.evaped.citybuild.main.FileManager;
import cloud.evaped.citybuild.utils.DataSaver;
import cloud.evaped.citybuild.utils.nick.Nick;
import java.util.HashMap;
import java.util.UUID;
import org.bukkit.entity.Player;

public class CachePlayer
{
  private DataSaver ds_tab;
  public static CachePlayer instance;
  
  public CachePlayer()
  {
    ds_tab = new DataSaver(FileManager.getObject_Tab);
    instance = this;
    for (Player all : org.bukkit.Bukkit.getOnlinePlayers()) {
      loadPlayer(all);
    }
  }
  
  public static HashMap<String, String> getTeamName = new HashMap();
  public static HashMap<String, CoreScoreBoard> getBoard = new HashMap();
  
  void loadPlayer(Player p) {
    getTeamName.put(p.getUniqueId().toString(), getTeamPlayer(p));
  }
  
  public String getTeamPlayer(Player p) {
    String s = "999Team";
    if (Nick.isNicked.containsKey(p))
    {
      if (cloud.evaped.citybuild.main.CityBuildPlugin.mysqlMethods.loadIntFromMySQL(MySQLEnum.UUID, p.getUniqueId().toString(), "nickTable", "premiumnick").intValue() == 1) {
        int i1 = ds_tab.getInt("nick.numberforpremium");
        if (i1 < 10) {
          return "0" + i1 + "Team";
        }
        return i1 + "Team";
      }
      
      return s;
    }
    for (int i = 1; i <= FileManager.getTeamSize; i++) {
      if ((ds_tab.contains(i + ".perm")) && 
        (p.hasPermission(ds_tab.getString(i + ".perm")))) {
        if (i < 10) {
          return "0" + i + "Team";
        }
        return i + "Team";
      }
    }
    
    return s;
  }
}
