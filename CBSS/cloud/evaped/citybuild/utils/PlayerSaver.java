package cloud.evaped.citybuild.utils;

import cloud.evaped.citybuild.MySQL.MySQL;
import cloud.evaped.citybuild.MySQL.MySQLEnum;
import cloud.evaped.citybuild.MySQL.MySQLMethods;
import cloud.evaped.citybuild.main.CityBuildCore;
import cloud.evaped.citybuild.main.CityBuildPlugin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;


































public class PlayerSaver
{
  private static final ExecutorService EXECUTOR_SERVICE = ;
  public static PlayerSaver instance;
  
  public PlayerSaver() {
    instance = this;
    Player all; for (Iterator localIterator = Bukkit.getOnlinePlayers().iterator(); localIterator.hasNext(); createNewPlayer(all.getUniqueId().toString(), all.getName())) all = (Player)localIterator.next();
  }
  
  public static HashMap<String, HashMap<String, Object>> playerProfile = new HashMap();
  
  public void createNewPlayer(final String uuid, final String name) {
    EXECUTOR_SERVICE.execute(new Runnable()
    {
      public void run() {
        HashMap<String, Object> profile = new HashMap();
        if (!CityBuildPlugin.BungeeSystem) {
          if (!CityBuildPlugin.mysqlMethods.containsMySQL(MySQLEnum.UUID, uuid, "coinsTable")) {
            String update = "INSERT INTO coinsTable (UUID, name, coins) VALUES (?, ?, ?)";
            
            PreparedStatement statement = null;
            try {
              statement = MySQL.con.prepareStatement(update);
              statement.setString(1, uuid);
              statement.setString(2, name);
              statement.setInt(3, CityBuildCore.ds_msg.getInt("message.startcoins"));
              statement.execute();
              




              if (statement != null) {
                try {
                  statement.close();
                } catch (SQLException e) {
                  e.printStackTrace();
                }
              }
              
              profile.put("coinsTable;coins", Integer.valueOf(0));
            }
            catch (SQLException e)
            {
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
          else {
            ResultSet rs = null;
            try {
              rs = MySQL.instance.getResult("SELECT coins FROM coinsTable WHERE UUID='" + uuid + "'");
              
              if (rs.next()) {
                profile.put("coinsTable;coins", Integer.valueOf(rs.getInt("coins")));
              }
              





              if (rs != null) {
                try {
                  rs.close();
                } catch (SQLException e) {
                  e.printStackTrace();
                }
              }
              

              if (PlayerSaver.this.isNameSame(name, uuid)) {
                break label540;
              }
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
          
          PlayerSaver.this.updatePlayersName(uuid, name);
        }
        else {
          ResultSet rs = null;
          try {
            rs = MySQL.instance.getResult("SELECT coins FROM coinsTable WHERE UUID='" + uuid + "'");
            
            if (rs.next()) {
              profile.put("coinsTable;coins", Integer.valueOf(rs.getInt("coins")));
            }
            





            if (rs != null) {
              try {
                rs.close();
              } catch (SQLException e) {
                e.printStackTrace();
              }
            }
            
            if (PlayerSaver.this.isNameSame(name, uuid)) {
              break label540;
            }
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
          
          PlayerSaver.this.updatePlayersName(uuid, name);
        }
        
        label540:
        if (!CityBuildPlugin.mysqlMethods.containsMySQL(MySQLEnum.UUID, uuid, "playerTable")) {
          String update = "INSERT INTO playerTable (UUID, name, rewards1, rewards2, rewards3, rewards4, tickets, cases, kills, death, chat, doublejump, broadcaster, speed, terms, saveInv, s1, s2, s3, s4, s5, srtokens) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
          

          PreparedStatement statement = null;
          try {
            statement = MySQL.con.prepareStatement(update);
            statement.setString(1, uuid);
            statement.setString(2, name);
            
            statement.setString(3, "none");
            statement.setString(4, "none");
            statement.setString(5, "none");
            statement.setString(6, "none");
            
            statement.setInt(7, 0);
            statement.setInt(8, 0);
            
            statement.setInt(9, 0);
            statement.setInt(10, 0);
            
            statement.setInt(11, 1);
            statement.setInt(12, 1);
            statement.setInt(13, 1);
            statement.setInt(14, 1);
            
            statement.setInt(15, 0);
            
            statement.setInt(16, 0);
            statement.setInt(17, 0);
            statement.setInt(18, 0);
            statement.setInt(19, 0);
            statement.setInt(20, 0);
            statement.setInt(21, 0);
            
            statement.setInt(22, 0);
            statement.execute();
            




            if (statement != null) {
              try {
                statement.close();
              } catch (SQLException e) {
                e.printStackTrace();
              }
            }
            

            profile.put("playerTable;srtokens", Integer.valueOf(0));
          }
          catch (SQLException e)
          {
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
          


          Player p = Bukkit.getPlayer(name);
          if (p != null) {
            p.setMetadata("firstjoin", new FixedMetadataValue(CityBuildPlugin.instance, Boolean.valueOf(true)));
          }
        } else {
          String update = "SELECT * FROM playerTable WHERE UUID='" + uuid + "'";
          
          ResultSet statement = null;
          try {
            Statement st = MySQL.con.createStatement();
            statement = st.executeQuery(update);
            if (statement.next()) {
              profile.put("playerTable;srtokens", statement.getObject("srtokens"));
            }
            





            if (statement != null) {
              try {
                statement.close();
              } catch (SQLException e) {
                e.printStackTrace();
              }
            }
            

            if (CityBuildPlugin.BungeeSystem) {
              break label1243;
            }
          }
          catch (SQLException e)
          {
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
        
        if (!CityBuildPlugin.mysqlMethods.containsMySQL(MySQLEnum.UUID, uuid, "nickTable")) {
          String update = "INSERT INTO nickTable (UUID, name, autonick, premiumnick) VALUES (?, ?, ?, ?)";
          
          PreparedStatement statement = null;
          try {
            statement = MySQL.con.prepareStatement(update);
            statement.setString(1, uuid);
            statement.setString(2, name);
            statement.setInt(3, 0);
            statement.setInt(4, 0);
            statement.execute();
            




            if (statement != null) {
              try {
                statement.close();
              } catch (SQLException e) {
                e.printStackTrace();
              }
            }
            



            if (CityBuildPlugin.mysqlMethods.containsMySQL(MySQLEnum.UUID, uuid, CityBuildPlugin.MySQLTable)) {
              break label1602;
            }
          }
          catch (SQLException e)
          {
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
        
        label1243:
        
        String update = "INSERT INTO " + CityBuildPlugin.MySQLTable + " (UUID, name, onlinetime, online, home1, home2, home3, home4, sells, tokens, maxtokens, ads) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        

        PreparedStatement statement = null;
        try {
          statement = MySQL.con.prepareStatement(update);
          statement.setString(1, uuid);
          statement.setString(2, name);
          
          statement.setInt(3, 0);
          statement.setInt(4, 1);
          
          statement.setInt(5, 1);
          statement.setInt(6, 0);
          statement.setInt(7, 0);
          statement.setInt(8, 0);
          
          statement.setInt(9, 0);
          statement.setInt(10, 0);
          statement.setInt(11, 5);
          statement.setString(12, "00/00/0000//0");
          
          statement.execute();
          




          if (statement != null) {
            try {
              statement.close();
            } catch (SQLException e) {
              e.printStackTrace();
            }
          }
          

          profile.put(CityBuildPlugin.MySQLTable + ";onlinetime", Integer.valueOf(0));
        }
        catch (SQLException e)
        {
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
        

        profile.put(CityBuildPlugin.MySQLTable + ";online", Integer.valueOf(1));
        
        Player p = Bukkit.getPlayer(name);
        if (p != null)
          p.setMetadata("firstjoin", new FixedMetadataValue(CityBuildPlugin.instance, Boolean.valueOf(true)));
        break label1903;
        label1602:
        String update = "SELECT * FROM " + CityBuildPlugin.MySQLTable + " WHERE UUID='" + uuid + "'";
        
        ResultSet statement = null;
        try {
          Statement st = MySQL.con.createStatement();
          statement = st.executeQuery(update);
          
          if (statement.next()) {
            profile.put(CityBuildPlugin.MySQLTable + ";onlinetime", Integer.valueOf(statement.getInt("onlinetime")));
            profile.put(CityBuildPlugin.MySQLTable + ";online", Integer.valueOf(statement.getInt("online")));
            profile.put(CityBuildPlugin.MySQLTable + ";sells", Integer.valueOf(statement.getInt("sells")));
            profile.put(CityBuildPlugin.MySQLTable + ";ads", Integer.valueOf(statement.getInt("ads")));
          }
          





          if (statement != null) {
            try {
              statement.close();
            } catch (SQLException e) {
              e.printStackTrace();
            }
          }
          


          if (!PlayerSaver.playerProfile.containsKey(uuid)) {
            break label1942;
          }
        }
        catch (SQLException e)
        {
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
        
        label1903:
        
        PlayerSaver.playerProfile.remove(uuid);
        PlayerSaver.playerProfile.put(uuid, profile);
        break label1954;
        label1942: PlayerSaver.playerProfile.put(uuid, profile);
        label1954:
        CityBuildPlugin.mysqlMethods.setIntFromMySQL(MySQLEnum.UUID, uuid, CityBuildPlugin.MySQLTable, "online", 1);
      }
    });
  }
  
  private void updatePlayersName(final String uuid, final String name)
  {
    EXECUTOR_SERVICE.execute(new Runnable() {
      public void run() { String[] array;
        String[] array;
        if (CityBuildPlugin.BungeeSystem) {
          array = new String[] { CityBuildPlugin.MySQLTable };
        } else {
          array = new String[] { CityBuildPlugin.MySQLTable, "coinsTable", "nickTable" };
        }
        
        String[] arrayOfString1 = array;int i = arrayOfString1.length; for (int j = 0; j < i;) { String anArray = arrayOfString1[j];
          String update = "UPDATE " + anArray + " SET name= ? WHERE UUID= ?";
          
          PreparedStatement statement = null;
          try {
            statement = MySQL.con.prepareStatement(update);
            statement.setString(1, name);
            statement.setString(2, uuid);
            statement.executeUpdate();
            




            if (statement != null) {
              try {
                statement.close();
              } catch (SQLException e) {
                e.printStackTrace();
              }
            }
            j++;



          }
          catch (SQLException e)
          {



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
      }
    });
  }
  
  private boolean isNameSame(String name, String uuid) {
    ResultSet rs = null;
    try {
      rs = MySQL.instance.getResult("SELECT name FROM " + CityBuildPlugin.MySQLTable + " WHERE UUID='" + uuid + "'");
      while (rs.next()) {
        String SQLNAME = rs.getString("name");
        if (!SQLNAME.equalsIgnoreCase(name)) {
          return false;
        }
      }
      












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
          e.printStackTrace();
        }
      }
    }
  }
}
