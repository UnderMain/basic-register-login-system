package de.zenit.main;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.bukkit.Bukkit;


public class mysql {

   private String host = "";
   private String username = "";
   private String password = "";
   private String database = "";
   private int port;
   private static Connection connection;


   public mysql(String host, String username, String password, String database, int port) {
      this.host = host;
      this.username = username;
      this.password = password;
      this.database = database;
      this.port = port;
      this.connect();
   }

   public void connect() {
      if(!this.isConnected()) {
         try {
            connection = DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database + "?autoReconnect=true", this.username, this.password);
            Bukkit.getConsoleSender().sendMessage("§cVerbindung erfolgreich angemacht du fisch!");

         } catch (SQLException var2) {
             Bukkit.getConsoleSender().sendMessage("§cVerbindung erfolgreich du hurensohn es geht net!");

         }
      }

   }

   public void disconnect() {
      if(this.isConnected()) {
         try {
            connection.close();
            Bukkit.getConsoleSender().sendMessage("§cVerbindung erfolgreich geschlossen!");
         } catch (SQLException var2) {
            ;
         }
      }

   }

   public boolean isConnected() {
      return connection != null;
   }

   public Connection getConnection() {
      return connection;
   }

   public void update(String qry) {
      try {
         PreparedStatement ps = connection.prepareStatement(qry);
         ps.executeUpdate();
         ps.close();
      } catch (SQLException var3) {
         ;
      }

   }

   public ResultSet getResult(String qry) {
      try {
         PreparedStatement var3 = connection.prepareStatement(qry);
         return var3.executeQuery();
      } catch (SQLException var31) {
         return null;
      }
   }
}
