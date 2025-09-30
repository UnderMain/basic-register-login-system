package de.undermain.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.UUID;

import org.bukkit.Bukkit;

public class qry  {
	
	

    public static int getToken(String player){ 
		ResultSet rs = null;
		
		PreparedStatement st = null;
		
		try {
			st = MySQL.getConnection().prepareStatement("SELECT token FROM users WHERE uidUsers=" + player);
			rs = st.executeQuery();
			rs.last();
			
			return rs.getInt(1);
	
		} catch (SQLException e) {
			e.printStackTrace();

	}
		return 0;
    }
    
    
    public static int getUUID(String player){
    	ResultSet rs = null;
		
		PreparedStatement st = null;
		
		try {
			st = MySQL.getConnection().prepareStatement("SELECT UUID FROM users WHERE uidUsers=?");
			st.setString(1, player);
			st.execute();
			rs = st.getResultSet();
			return rs.getInt(1);
	
		} catch (SQLException e) {
			e.printStackTrace();

	}
		return 0;
    }
    
    public static void setUUID(String player){
		
		UUID uuid1 = Bukkit.getPlayer(player).getUniqueId();

		PreparedStatement st = null;
		
		try {
			st = MySQL.getConnection().prepareStatement("INSERT INTO users (UUID) VALUES (?)");
			st.setString(1, uuid1.toString());
			st.execute();
			
	
		} catch (SQLException e) {
			e.printStackTrace();

	}
    }
    
    public static String getName(String token){
    	ResultSet rs = null;
		
		PreparedStatement st = null;
		
		try {
			st = MySQL.getConnection().prepareStatement("SELECT uidUsers FROM users WHERE token=?");
			st.setString(1, token);
			st.execute();
			rs = st.getResultSet();
			
			return rs.getString(1);
	
		} catch (SQLException e) {
			e.printStackTrace();

	}
		return null;
    }
    
    
}
