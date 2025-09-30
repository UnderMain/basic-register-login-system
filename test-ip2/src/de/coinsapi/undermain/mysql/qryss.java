package de.coinsapi.undermain.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;


public class qryss {

    public static void registerPlayer(Player player){
		
		UUID uuid1 = Bukkit.getPlayer(player.getName()).getUniqueId();

		PreparedStatement st = null;
		
		try {
			st = MySQLL.getConnection().prepareStatement("INSERT INTO coinsTable (UUID, name, coins) VALUES (?, ?, ?)");
			st.setString(1, uuid1.toString());
			st.setString(2, player.getName());
			st.setInt(3, 0);
			st.execute();
			
	
		} catch (SQLException e) {
			e.printStackTrace();

	}
    }
    
    public static void registerPlayer2(Player player){
		
		UUID uuid1 = Bukkit.getPlayer(player.getName()).getUniqueId();

		PreparedStatement st = null;
		
		try {
			st = MySQLL.getConnection().prepareStatement("INSERT INTO playerTable (UUID, name, kills, deaths, ontime) VALUES (?, ?, ?, ?, ?)");
			st.setString(1, uuid1.toString());
			st.setString(2, player.getName());
			st.setInt(3, 0);
			st.setInt(4, 0);
			st.setInt(5,  0);
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
    
    
    public static int getRows(Player player){
    	ResultSet rs = null;
		PreparedStatement st = null;
		UUID uuid1 = Bukkit.getPlayer(player.getName()).getUniqueId();
		try {
			st = MySQLL.getConnection().prepareStatement("SELECT COUNT(*) AS rowcount FROM coinsTable WHERE UUID=?");
			st.setString(1, uuid1.toString());
			st.execute();
			rs = st.getResultSet();
			rs.next();
			int count = rs.getInt("rowcount");
			rs.close();
			return count;
	
		} catch (SQLException e) {
			e.printStackTrace();

	}
		return 100;
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
	
}
