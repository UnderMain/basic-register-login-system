package de.undermain.mysql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.Bukkit;

import de.undermain.config.files;

public class MySQL {
	

	
	public static String host = files.getObject_MySQL.get("Host").toString();
	public static int port = Integer.parseInt(files.getObject_MySQL.get("Port") + "");
	public static String database = files.getObject_MySQL.get("Database").toString();
	public static String username = files.getObject_MySQL.get("User").toString();
	public static String password = files.getObject_MySQL.get("Password").toString();
	
	public static String msgg = "";
	
	public static Connection con;
	
	public static boolean isConnected(){
		return con != null;
	}
	
	public static void connect(){
		if(!isConnected()){
			try {
				con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?autoReconnect=true", username, password);
				msgg = "§a§lMySQL Verbunden!";
			} catch (SQLException e) {
				msgg = "§c§lMySQL Getrennt!";
			}
		}
	}
	
	public static void disconnect(){
		try {
			con.close();
			Bukkit.getConsoleSender().sendMessage(files.getObject_Messages.get("Prefix").toString() + "§aDie Verbindung zur Datenbank konnte erfolgreich geschlossen werden");
		} catch (SQLException e) {
			Bukkit.getConsoleSender().sendMessage(files.getObject_Messages.get("Prefix").toString() + "§cDie Verbindung zur Datenbank konnte nicht geschlossen werden");
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
