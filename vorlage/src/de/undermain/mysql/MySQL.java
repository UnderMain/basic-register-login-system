package de.undermain.mysql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MySQL {
	

	
	public static String host = "178.254.1.105";
	public static int port = Integer.parseInt("3306");
	public static String database = "lizenz-dev";
	public static String username = "lizenz-dev";
	public static String password = "lizenz-dev";
	
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
		} catch (SQLException e) {
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
