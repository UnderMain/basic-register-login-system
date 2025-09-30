package de.undermain.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.bukkit.Bukkit;

public class qryss {

    public static void registerPlayer(String player){
		
		UUID uuid1 = Bukkit.getPlayer(player).getUniqueId();

		PreparedStatement st = null;
		
		try {
			st = MySQLL.getConnection().prepareStatement("INSERT INTO playerTable (UUID, name, kills, deaths, ontime) VALUES (?, ?, ?, ?, ?)");
			st.setString(1, uuid1.toString());
			st.setString(2, player);
			st.setInt(3, 0);
			st.setInt(4, 0);
			st.setInt(5, 0);
			st.execute();
			
	
		} catch (SQLException e) {
			e.printStackTrace();

	}
    }
	
    public static int deaths(String player){
    	ResultSet rs = null;
		
		PreparedStatement st = null;
		UUID uuid1 = Bukkit.getPlayer(player).getUniqueId();

		try {
			st = MySQLL.getConnection().prepareStatement("SELECT deaths FROM playerTable WHERE UUID=?");
			st.setString(1, uuid1.toString());
			st.execute();
			rs = st.getResultSet();
			if(rs.next()){
				   int er = rs.getInt(1);
				   return er;
				}	
		} catch (SQLException e) {
			e.printStackTrace();

	}
		return 1000;
    }
    
    public static int kills(String player){
    	ResultSet rs = null;
		
		PreparedStatement st = null;
		UUID uuid1 = Bukkit.getPlayer(player).getUniqueId();

		try {
			st = MySQLL.getConnection().prepareStatement("SELECT kills FROM playerTable WHERE UUID=?");
			st.setString(1, uuid1.toString());
			st.execute();
			rs = st.getResultSet();
			if(rs.next()){
				   int er = rs.getInt(1);
				   return er;
				}	
		} catch (SQLException e) {
			e.printStackTrace();

	}
		return 1000;
    }
    
    public static int ontime(String player){
    	ResultSet rs = null;
		
		PreparedStatement st = null;
		UUID uuid1 = Bukkit.getPlayer(player).getUniqueId();

		try {
			st = MySQLL.getConnection().prepareStatement("SELECT ontime FROM playerTable WHERE UUID=?");
			st.setString(1, uuid1.toString());
			st.execute();
			rs = st.getResultSet();
			if(rs.next()){
				   int er = rs.getInt(1);
				   return er;
				}	
		} catch (SQLException e) {
			e.printStackTrace();

	}
		return 1000;
    }
    public static void setnewDeaths(int tode, String player){
		

		UUID uuid1 = Bukkit.getPlayer(player).getUniqueId();

		PreparedStatement st = null;
		
		try {
			st = MySQLL.getConnection().prepareStatement("UPDATE playerTable SET deaths = ? WHERE UUID = ?");
			st.setInt(1, tode);
			st.setString(2, uuid1.toString());
			st.execute();
			
	
		} catch (SQLException e) {
			e.printStackTrace();

	}
    }
    public static void setnewKills(int kills, String player){
		

		UUID uuid1 = Bukkit.getPlayer(player).getUniqueId();

		PreparedStatement st = null;
		
		try {
			st = MySQLL.getConnection().prepareStatement("UPDATE playerTable SET kills = ? WHERE UUID = ?");
			st.setInt(1, kills);
			st.setString(2, uuid1.toString());
			st.execute();
			
	
		} catch (SQLException e) {
			e.printStackTrace();

	}
    }
    
    public static void updateOntime(int time, String player){
		

		UUID uuid1 = Bukkit.getPlayer(player).getUniqueId();

		PreparedStatement st = null;
		
		try {
			st = MySQLL.getConnection().prepareStatement("UPDATE playerTable SET ontime = ? WHERE UUID = ?");
			st.setInt(1, time);
			st.setString(2, uuid1.toString());
			st.execute();
			
	
		} catch (SQLException e) {
			e.printStackTrace();

	}
    }
}
