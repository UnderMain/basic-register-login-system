package cloud.evaped.citybuild.MySQL;

import cloud.evaped.citybuild.main.CityBuildPlugin;
import cloud.evaped.citybuild.utils.PlayerSaver;
import cloud.evaped.citybuild.utils.nick.Nick;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.bukkit.entity.Player;

public class MySQLMethods
{
  private static final ExecutorService EXECUTOR_SERVICE = ;
  public static HashMap<Integer, String> getGroupsPrefix = new HashMap();
  public static HashMap<String, Integer> getGroupID = new HashMap();
  
  public MySQLMethods() {
    loadGroupsPrefix();
  }
  
  private String getTypeMySQLEnum(MySQLEnum type) {
    if (type == MySQLEnum.NAME) {
      return "name";
    }
    return "UUID";
  }
  










  public String loadStringFromCache(String uuid, String table, String identifier)
  {
    return "" + ((HashMap)PlayerSaver.playerProfile.get(uuid)).get(new StringBuilder().append(table).append(";").append(identifier).toString());
  }
  










  public Integer loadIntFromCache(String uuid, String table, String identifier)
  {
    return Integer.valueOf(Integer.parseInt("" + ((HashMap)PlayerSaver.playerProfile.get(uuid)).get(new StringBuilder().append(table).append(";").append(identifier).toString())));
  }
  










  public Long loadLongFromCache(String uuid, String table, String identifier)
  {
    return new Long("" + ((HashMap)PlayerSaver.playerProfile.get(uuid)).get(new StringBuilder().append(table).append(";").append(identifier).toString()));
  }
  










  public String loadStringFromMySQL(MySQLEnum type, String identifier, String table, String field)
  {
    s = "";
    
    String update = "SELECT * FROM " + table + " WHERE " + getTypeMySQLEnum(type) + "='" + identifier + "'";
    ResultSet statement = null;
    try
    {
      Statement st = MySQL.con.createStatement();
      statement = st.executeQuery(update);
      if (statement.next()) {}
      return statement.getString(field);
    }
    catch (SQLException e) {
      if (CityBuildPlugin.debug) {
        e.printStackTrace();
      }
    } finally {
      if (statement != null) {
        try {
          statement.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
  }
  












  public Integer loadIntFromMySQL(MySQLEnum type, String identifier, String table, String field)
  {
    int i = 0;
    try
    {
      Statement st = MySQL.con.createStatement();
      ResultSet rs = st.executeQuery("SELECT " + field + " FROM " + table + " WHERE " + getTypeMySQLEnum(type) + "='" + identifier + "'");
      if (rs.next()) {
        i = rs.getInt(field);
      }
    } catch (SQLException e) {
      if (CityBuildPlugin.debug) {
        e.printStackTrace();
      }
    }
    

    return Integer.valueOf(i);
  }
  










  public Long loadLongFromMySQL(MySQLEnum type, String identifier, String table, String field)
  {
    l = Long.valueOf(0L);
    
    String update = "SELECT * FROM " + table + " WHERE " + getTypeMySQLEnum(type) + "='" + identifier + "'";
    ResultSet statement = null;
    try
    {
      Statement st = MySQL.con.createStatement();
      statement = st.executeQuery(update);
      if (statement.next()) {}
      return Long.valueOf(statement.getLong(field));
    }
    catch (SQLException e) {
      if (CityBuildPlugin.debug) {
        e.printStackTrace();
      }
    } finally {
      if (statement != null) {
        try {
          statement.close();
        } catch (SQLException e) {
          if (CityBuildPlugin.debug) {
            e.printStackTrace();
          }
        }
      }
    }
  }
  














  public void setStringFromMySQL(final MySQLEnum type, final String identifier, final String table, final String field, final String value)
  {
    if (type == MySQLEnum.UUID) {
      ((HashMap)PlayerSaver.playerProfile.get(identifier)).remove(table + ";" + field);
      ((HashMap)PlayerSaver.playerProfile.get(identifier)).put(table + ";" + field, value);
    }
    
    EXECUTOR_SERVICE.execute(new Runnable() {
      public void run() {
        String update = "UPDATE " + table + " SET " + field + "= ? WHERE " + MySQLMethods.this.getTypeMySQLEnum(type) + "= ?";
        PreparedStatement p = null;
        try
        {
          p = MySQL.con.prepareStatement(update);
          p.setString(1, value);
          p.setString(2, identifier);
          p.executeUpdate(); return;
        } catch (SQLException e) {
          if (CityBuildPlugin.debug) {
            e.printStackTrace();
          }
        } finally {
          if (p != null) {
            try {
              p.close();
            } catch (SQLException e) {
              if (CityBuildPlugin.debug) {
                e.printStackTrace();
              }
            }
          }
        }
      }
    });
  }
  












  public void setIntFromMySQL(final MySQLEnum type, final String identifier, final String table, final String field, final int value)
  {
    if (type == MySQLEnum.UUID) {
      ((HashMap)PlayerSaver.playerProfile.get(identifier)).remove(table + ";" + field);
      ((HashMap)PlayerSaver.playerProfile.get(identifier)).put(table + ";" + field, Integer.valueOf(value));
    }
    
    EXECUTOR_SERVICE.execute(new Runnable() {
      public void run() {
        String update = "UPDATE " + table + " SET " + field + "= ? WHERE " + MySQLMethods.this.getTypeMySQLEnum(type) + "= ?";
        PreparedStatement p = null;
        try
        {
          p = MySQL.con.prepareStatement(update);
          p.setInt(1, value);
          p.setString(2, identifier);
          p.executeUpdate(); return;
        } catch (SQLException e) {
          if (CityBuildPlugin.debug) {
            e.printStackTrace();
          }
        } finally {
          if (p != null) {
            try {
              p.close();
            } catch (SQLException e) {
              if (CityBuildPlugin.debug) {
                e.printStackTrace();
              }
            }
          }
        }
      }
    });
  }
  
  public void setIntFromMySQLNoCacheUpdate(final MySQLEnum type, final String identifier, final String table, final String field, final int value) {
    EXECUTOR_SERVICE.execute(new Runnable() {
      public void run() {
        String update = "UPDATE " + table + " SET " + field + "= ? WHERE " + MySQLMethods.this.getTypeMySQLEnum(type) + "= ?";
        PreparedStatement p = null;
        try
        {
          p = MySQL.con.prepareStatement(update);
          p.setInt(1, value);
          p.setString(2, identifier);
          p.executeUpdate(); return;
        } catch (SQLException e) {
          if (CityBuildPlugin.debug) {
            e.printStackTrace();
          }
        } finally {
          if (p != null) {
            try {
              p.close();
            } catch (SQLException e) {
              if (CityBuildPlugin.debug) {
                e.printStackTrace();
              }
            }
          }
        }
      }
    });
  }
  












  public void setLongFromMySQL(final MySQLEnum type, String identifier, final String table, final String field, final long value)
  {
    if (type == MySQLEnum.UUID) {
      ((HashMap)PlayerSaver.playerProfile.get(identifier)).remove(table + ";" + field);
      ((HashMap)PlayerSaver.playerProfile.get(identifier)).put(table + ";" + field, Long.valueOf(value));
    }
    
    EXECUTOR_SERVICE.execute(new Runnable()
    {
      public void run() {
        String update = "UPDATE " + table + " SET " + field + "= ? WHERE " + MySQLMethods.this.getTypeMySQLEnum(type) + "= ?";
        PreparedStatement p = null;
        try
        {
          p = MySQL.con.prepareStatement(update);
          p.setLong(1, value);
          p.setString(2, val$identifier);
          p.executeUpdate(); return;
        } catch (SQLException e) {
          if (CityBuildPlugin.debug) {
            e.printStackTrace();
          }
        } finally {
          if (p != null) {
            try {
              p.close();
            } catch (SQLException e) {
              e.printStackTrace();
            }
          }
        }
      }
    });
  }
  







  public boolean containsMySQL(MySQLEnum type, String identifier)
  {
    try
    {
      ResultSet rs = MySQL.instance.getResult("SELECT * FROM coinsTable WHERE " + getTypeMySQLEnum(type) + "='" + identifier + "'");
      if (rs.next()) {
        return rs.getString(getTypeMySQLEnum(type)) != null;
      }
      rs.close();
      return false;
    } catch (Exception e) {}
    return false;
  }
  









  public boolean containsMySQL(MySQLEnum type, String identifier, String table)
  {
    try
    {
      ResultSet rs = MySQL.instance.getResult("SELECT * FROM " + table + " WHERE " + getTypeMySQLEnum(type) + "='" + identifier + "'");
      if (rs.next()) {
        return rs.getString(getTypeMySQLEnum(type)) != null;
      }
      rs.close();
      return false;
    } catch (Exception e) {}
    return false;
  }
  











  public List<String> getTopValues(int size, String type, String table, String field)
  {
    List<String> list = new ArrayList();
    try {
      ResultSet rs = MySQL.instance.getResult("SELECT " + type + " FROM " + table + " ORDER BY " + field + " DESC LIMIT " + size);
      
      while (rs.next()) {
        list.add(rs.getString(type));
      }
      rs.close();
    } catch (Exception e) {
      if (CityBuildPlugin.debug) {
        e.printStackTrace();
      }
    }
    return list;
  }
  
  public HashMap<String, Integer> getTopValues(int size, String type, String type2, String table, String field) {
    HashMap<String, Integer> map = new HashMap();
    try {
      ResultSet rs = MySQL.instance.getResult("SELECT " + type + "," + type2 + " FROM " + table + " ORDER BY " + field + " DESC LIMIT " + size);
      
      while (rs.next()) {
        map.put(rs.getString(type), Integer.valueOf(rs.getInt(type2)));
      }
      rs.close();
    } catch (Exception e) {
      if (CityBuildPlugin.debug) {
        e.printStackTrace();
      }
    }
    return map;
  }
  
  public String getRankingValues(String UUID) {
    String s = "-1";
    try {
      ResultSet rs = MySQL.instance.getResult("SELECT UUID FROM coinsTable ORDER BY coins DESC");
      int counter = 0;
      while (rs.next()) {
        counter += 1;
        if (rs.getString("UUID").equalsIgnoreCase(UUID)) {
          break;
        }
      }
      s = counter + "";
      rs.close();
    } catch (Exception e) {
      if (CityBuildPlugin.debug) {
        e.printStackTrace();
      }
    }
    return s;
  }
  
  public String getClanTag(String UUID) {
    tag = "none";
    ResultSet rs = null;
    
    try
    {
      rs = MySQL.instance.getResult("SELECT clan FROM friendsTable WHERE UUID='" + UUID + "'");
      
      if (rs.next()) {}
      return rs.getString("clan");
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
  

  public String getRankedName(Player p)
  {
    String name = p.getName();
    if (!CityBuildPlugin.xperms) return name;
    String FINALNAME = name;
    
    if (Nick.isNicked.containsKey(p))
    {
      if (CityBuildPlugin.mysqlMethods.loadIntFromMySQL(MySQLEnum.UUID, p.getUniqueId().toString(), "nickTable", "premiumnick").intValue() == 1) {
        FINALNAME = (String)getGroupsPrefix.get(Integer.valueOf(CityBuildPlugin.xperms_premium)) + name;
      } else {
        FINALNAME = (String)getGroupsPrefix.get(Integer.valueOf(-1)) + name;
      }
      
      return FINALNAME;
    }
    try {
      int groupid;
      int groupid;
      if (getGroupID.containsKey(name)) {
        groupid = ((Integer)getGroupID.get(name)).intValue();
      } else {
        groupid = getPlayersGroupID(name);
        getGroupID.put(name, Integer.valueOf(getPlayersGroupID(name)));
      }
      FINALNAME = (String)getGroupsPrefix.get(Integer.valueOf(groupid)) + name;
    } catch (Exception e) {
      if (CityBuildPlugin.debug) {
        e.printStackTrace();
      }
    }
    
    return FINALNAME;
  }
  
  public String getUUID(String name) {
    ResultSet rs = null;
    try {
      rs = MySQL.instance.getResult("SELECT UUID FROM coinsTable WHERE name='" + name + "'");
      if ((rs != null) && (rs.next())) {
        return rs.getString("UUID");
      }
      












      return null;
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
          e.printStackTrace();
        }
      }
    }
  }
  
  public String getName(String UUID)
  {
    ResultSet rs = null;
    try {
      rs = MySQL.instance.getResult("SELECT name FROM coinsTable WHERE UUID='" + UUID + "'");
      if (rs.next()) {
        return rs.getString("name");
      }
      












      return null;
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
          e.printStackTrace();
        }
      }
    }
  }
  
  public int getPlayersGroupID(String name)
  {
    try {
      ResultSet rs = MySQL.instance.getResult("SELECT * FROM permsTable WHERE name='" + name + "'");
      if (rs.next()) {
        return rs.getInt("groupid");
      }
      rs.close();
      return -1;
    } catch (SQLException e) {}
    return -1;
  }
  
  private void loadGroupsPrefix()
  {
    if (!CityBuildPlugin.xperms) return;
    ResultSet rs = null;
    try
    {
      rs = MySQL.instance.getResult("SELECT groupid,prefix FROM groupsTable");
      
      while (rs.next()) {
        if (rs.getString("prefix") != null) {
          getGroupsPrefix.put(Integer.valueOf(rs.getInt("groupid")), rs.getString("prefix").replaceAll("&", "§"));
        }
      }
      return;
    } catch (SQLException e) {
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
