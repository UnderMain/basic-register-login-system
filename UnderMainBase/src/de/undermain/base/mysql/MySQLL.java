package de.undermain.base.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.Bukkit;

import de.undermain.base.files.files;
import de.undermain.base.main.Main;

public class MySQLL {
	

	
	public static String host = files.getObject_config.get("Host").toString();
	public static int port = Integer.parseInt(files.getObject_config.get("Port") + "");
	public static String database = files.getObject_config.get("Database").toString();
	public static String username = files.getObject_config.get("User").toString();
	public static String password = files.getObject_config.get("Password").toString();
	
	public static String msgg = "";
	
	public static Connection con;
	
	public static boolean isConnected(){
		return con != null;
	}
	
	public static void connect(){
		if(!isConnected()){
			try {
				con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?autoReconnect=true", username, password);
				createTable2();
				msgg = "§a§lMySQL Verbunden!";
			} catch (SQLException e) {
				msgg = "§c§lMySQL Getrennt!";
			}
		}
	}
	
	  private static void createTable2() {
		    if (isConnected())
		      try {
		        con.prepareStatement("CREATE TABLE IF NOT EXISTS playerTable (UUID VARCHAR(40) PRIMARY KEY, name VARCHAR(17), kills INT(20), deaths INT(20), blocksPlaced INT(20), blocksBreaked INT(20), ontime INT(20), coins INT(20), online INT(20))")
		          .executeUpdate();

		      } catch (SQLException e) {
		        if (Main.debug)
		          e.printStackTrace(); 
		      }  
		  }
	
	public static void disconnect(){
		try {
			con.close();
			Bukkit.getConsoleSender().sendMessage(files.getObject_config.get("Prefix").toString().replaceAll("&", "§") + "§aDie Verbindung zur Datenbank konnte erfolgreich geschlossen werden");
		} catch (SQLException e) {
			Bukkit.getConsoleSender().sendMessage(files.getObject_config.get("Prefix").toString().replaceAll("&", "§") + "§cDie Verbindung zur Datenbank konnte nicht geschlossen werden");
		}
	}

	public static PreparedStatement getStatement(String sql){
		if(isConnected()){
			PreparedStatement ps;
			try {
				ps = con.prepareStatement(sql);
				return ps;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static ResultSet getResult(String sql){
		if(isConnected()){
			PreparedStatement ps;
			ResultSet rs;
			try {
				ps = getStatement(sql);
				rs = ps.executeQuery();
				return rs;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static Connection getConnection() {
		return con;
	}
}
