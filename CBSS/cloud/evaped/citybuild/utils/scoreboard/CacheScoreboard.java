package cloud.evaped.citybuild.utils.scoreboard;

import cloud.evaped.citybuild.main.CityBuildPlugin;
import cloud.evaped.citybuild.main.FileManager;
import cloud.evaped.citybuild.utils.DataSaver;
import java.util.HashMap;
import java.util.List;
import org.bukkit.configuration.file.FileConfiguration;

public class CacheScoreboard
{
  public static CacheScoreboard instance;
  public static DataSaver ds_tab;
  
  public CacheScoreboard()
  {
    instance = this;
    loadCache();
    ds_tab = new DataSaver(FileManager.getObject_Tab);
    new ScoreboardUtils();
  }
  
  public static HashMap<String, Object> getObject_ScoreBoard = new HashMap();
  
  public void loadCache() {
    DataSaver ds_tab = new DataSaver(FileManager.getObject_Tab);
    getObject_ScoreBoard.put("displayname", CityBuildPlugin.instance.getConfig().getString("Scoreboard.name").replaceAll("&", "§"));
    List<String> list1 = CityBuildPlugin.instance.getConfig().getStringList("Scoreboard.list");
    List<String> list2 = new java.util.ArrayList();
    for (int i = 0; i < list1.size(); i++) {
      String s = ((String)list1.get(i)).replaceAll("&", "§");
      if (((String)list1.get(i)).contains("%COINS%")) {
        getObject_ScoreBoard.put("pos_coins", Integer.valueOf(i));
        getObject_ScoreBoard.put("field_coins", s);
      } else if (((String)list1.get(i)).contains("%NAME%")) {
        getObject_ScoreBoard.put("pos_name", Integer.valueOf(i));
        getObject_ScoreBoard.put("field_name", s);
      } else if (((String)list1.get(i)).contains("%DATE%")) {
        getObject_ScoreBoard.put("pos_date", Integer.valueOf(i));
        getObject_ScoreBoard.put("field_date", s);
      } else if (((String)list1.get(i)).contains("%TIME%")) {
        getObject_ScoreBoard.put("pos_time", Integer.valueOf(i));
        getObject_ScoreBoard.put("field_time", s);
      }
      list2.add(s);
    }
    getObject_ScoreBoard.put("scoreboard", list2);
    
    HashMap<String, String> map = new HashMap();
    for (int i = 1; i < 31; i++) {
      if (ds_tab.contains(i + ".prefix")) {
        map.put(getTeamName(Integer.valueOf(i)), ds_tab.getString(i + ".prefix"));
      }
    }
    map.put("999Team", ds_tab.getString("default.prefix"));
    getObject_ScoreBoard.put("teams", map);
    getObject_ScoreBoard.put("clantags", Boolean.valueOf(CityBuildPlugin.instance.getConfig().getBoolean("Scoreboard.clantags")));
  }
  
  private String getTeamName(Integer inte) {
    String s;
    String s;
    if (inte.intValue() < 10) {
      s = "0" + inte + "Team";
    } else {
      s = inte + "Team";
    }
    return s;
  }
}
