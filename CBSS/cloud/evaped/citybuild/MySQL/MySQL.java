package cloud.evaped.citybuild.MySQL;

import cloud.evaped.citybuild.main.CityBuildPlugin;
import cloud.evaped.citybuild.main.FileManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;





public class MySQL
{
  public static MySQL instance;
  public static Connection con;
  
  public MySQL()
  {
    instance = this;
    connect();
    createTable();
  }
  





  private void connect()
  {
    if (!isConnected()) {
      try {
        String host = FileManager.getObject_MySQL.get("Host").toString();
        int port = Integer.parseInt(FileManager.getObject_MySQL.get("Port") + "");
        String database = FileManager.getObject_MySQL.get("Database").toString();
        String user = FileManager.getObject_MySQL.get("User").toString();
        String password = FileManager.getObject_MySQL.get("Password").toString();
        con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?autoReconnect=true", "" + user, "" + password);
      } catch (Exception e) {
        if (CityBuildPlugin.debug) {
          e.printStackTrace();
        }
      }
    }
  }
  





  public void disconnect()
  {
    if (isConnected()) {
      try {
        con.close();
      } catch (Exception e) {
        if (CityBuildPlugin.debug) {
          e.printStackTrace();
        }
      }
    }
  }
  





  private void createTable()
  {
    if (isConnected()) {
      try
      {
        con.prepareStatement("CREATE TABLE IF NOT EXISTS coinsTable (UUID VARCHAR(40) PRIMARY KEY, name VARCHAR(17), coins INT(20))").executeUpdate();
        con.prepareStatement("CREATE TABLE IF NOT EXISTS nickTable (UUID VARCHAR(40) PRIMARY KEY, name VARCHAR(17), autonick INT(5), premiumnick INT(5))")
          .executeUpdate();
        con.prepareStatement("CREATE TABLE IF NOT EXISTS playerTable (UUID VARCHAR(40) PRIMARY KEY, name VARCHAR(17), rewards1 VARCHAR(11), rewards2 VARCHAR(11), rewards3 VARCHAR(11), rewards4 VARCHAR(11), tickets INT(10), cases INT(10), kills INT(5), death INT(5), chat INT(2), doublejump INT(2), broadcaster INT(2), speed INT(2), terms INT(2), saveInv INT(2), s1 INT(2), s2 INT(2), s3 INT(2), s4 INT(2), s5 INT(2), srtokens INT(10))")
        
          .executeUpdate();
        con.prepareStatement("CREATE TABLE IF NOT EXISTS " + CityBuildPlugin.MySQLTable + " (UUID VARCHAR(40) PRIMARY KEY, name VARCHAR(17), onlinetime BIGINT(20), online TINYINT(2), home1 TINYINT(2), home2 TINYINT(2), home3 TINYINT(2), home4 TINYINT(2), sells INT(10), tokens INT(5), maxtokens INT(5), ads VARCHAR(20))")
        
          .executeUpdate();
      } catch (SQLException e) {
        if (CityBuildPlugin.debug) {
          e.printStackTrace();
        }
      }
    }
  }
  






  public boolean isConnected()
  {
    return con != null;
  }
  






  public void update(String qry)
  {
    if (isConnected()) {
      try {
        con.createStatement().executeUpdate(qry);
      } catch (SQLException e) {
        if (CityBuildPlugin.debug) {
          e.printStackTrace();
        }
      }
    }
  }
  







  public ResultSet getResult(String qry)
  {
    ResultSet rs = null;
    try {
      Statement st = con.createStatement();
      rs = st.executeQuery(qry);
    } catch (SQLException e) {
      connect();
    }
    return rs;
  }
}
