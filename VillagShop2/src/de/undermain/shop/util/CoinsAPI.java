package de.undermain.shop.util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;


public class CoinsAPI {

    private static void updateCoins(HumanEntity p, int zahl){
		PreparedStatement st = null;
		UUID uuid1 = Bukkit.getPlayer(p.getName()).getUniqueId();
		try {
			st = MySQLL.getConnection().prepareStatement("UPDATE playerTable SET coins = ? WHERE UUID = ?");
			st.setInt(1, zahl);
			st.setString(2, uuid1.toString());
			st.execute();
		} catch (SQLException e) {
			e.printStackTrace();
	}
    }
    
    private static int coins(HumanEntity p){
    	ResultSet rs = null;
		PreparedStatement st = null;
		UUID uuid1 = Bukkit.getPlayer(p.getName()).getUniqueId();
		try {
			st = MySQLL.getConnection().prepareStatement("SELECT coins FROM playerTable WHERE UUID=?");
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
	
	public static void addCoins(Player p, int zahl) {
		int coins = coins(p);
		int neuecoins = coins + zahl;
		updateCoins(p, neuecoins);
	}
	
	public static void setCoins(Player p, int zahl) {
		updateCoins(p, zahl);
	}
	
	public static int removeCoins(HumanEntity p, int zahl) {
		int coins = coins(p);
		if(zahl > coins) {
			return -1;
		}else if(zahl <= coins) {
			int neuecoins = coins - zahl;
			updateCoins(p, neuecoins);
			return 0;
		}
		return -1;
	}
	
	public static int getCoins(HumanEntity p) {
		int coins = coins(p);
		return coins;
	}
	

	
	
	
}
