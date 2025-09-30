package cloud.evaped.citybuild.utils.scoreboard;

import cloud.evaped.citybuild.MySQL.MySQL;
import cloud.evaped.citybuild.main.CityBuildPlugin;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScoreboardUtils
{
  public static ScoreboardUtils instance;
  
  public ScoreboardUtils()
  {
    instance = this;
  }
  
  public List<String> getClantag(String UUID) {
    List<String> list = new ArrayList();
    ResultSet rs = null;
    
    try
    {
      rs = MySQL.instance.getResult("SELECT tag,color FROM clanTable WHERE members LIKE '%" + UUID + "%'");
      
      if (rs.next()) {
        list.add(rs.getString("tag"));
        list.add(rs.getString("color"));
        return list;
      }
      





      if (rs != null) {
        try {
          rs.close();
        } catch (SQLException e) {
          if (CityBuildPlugin.debug) {
            e.printStackTrace();
          }
        }
      }
      

      list.add("none");
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
    

    list.add("e");
    return list;
  }
}
