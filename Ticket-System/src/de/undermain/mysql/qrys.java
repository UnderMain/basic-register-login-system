package de.undermain.mysql;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.bukkit.Bukkit;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;


public class qrys {
	
	
	 public static int setLogin(String username, String email, String passwort, String name){ 			
			PreparedStatement st = null;
			UUID uuid1 = Bukkit.getPlayer(name).getUniqueId();

			try {
				st = MySQL.getConnection().prepareStatement("INSERT INTO user (username, email, passwort, uuid, status) VALUES (?, ?, ?, ?, ?)");
				st.setString(1, username);
				st.setString(2, email);
				st.setString(3, passwort);
				st.setString(4, uuid1.toString());
				st.setString(5, "fertig");

				st.execute();
						
			} catch (SQLException e) {
				e.printStackTrace();

		}
			return 0;
	    }

	    public static int getStatus(String username){
	    	ResultSet rs = null;
			PreparedStatement st = null;
			UUID uuid1 = Bukkit.getPlayer(username).getUniqueId();

			try {
				st = MySQL.getConnection().prepareStatement("SELECT status FROM ticket WHERE uuid=?");
				st.setString(1, uuid1.toString());
				st.execute();
				rs = st.getResultSet();
				return rs.getInt(1);
		
			} catch (SQLException e) {
				e.printStackTrace();

		}
			return 0;
	    }
	    
	    
	    public static  void deleteUser(String username){
			PreparedStatement st = null;
			try {
				st = MySQL.getConnection().prepareStatement("DELETE FROM user WHERE uuid=?");
				st.setString(1, username);
				st.execute();

		
			} catch (SQLException e) {
				e.printStackTrace();

		}
			
	    }
	    
	    public static String getStatusUser(String name) {
	    	
			UUID uuid1 = Bukkit.getPlayer(name).getUniqueId();

		      try {
		         PreparedStatement var6 = MySQL.getConnection().prepareStatement("SELECT status FROM user WHERE uuid = ?");
		         var6.setString(1, uuid1.toString());
		         ResultSet rs = var6.executeQuery();	         
		         
		 		
		 		 if(rs.next()) {
			         
		 	 		return rs.getString("status");
		 	         }else {
		 	        	 return null;
		 	         }

		      } catch (SQLException var61) {
		         var61.printStackTrace();
		         return null;
		      }
			

		   }
	    
	    public static String getUUIDchecked(String uuid) {
	    	
		      try {
		         PreparedStatement var6 = MySQL.getConnection().prepareStatement("SELECT * FROM user WHERE uuid = ?");
		         var6.setString(1, uuid);
		         ResultSet rs = var6.executeQuery();	         
		         
		 		 if(rs.next()) {
			         
		 	 		return "vorhanden";
		 	         }else {
		 	        	 return null;
		 	         }

		      } catch (SQLException var61) {
		         var61.printStackTrace();
		         return null;
		      }
			

		   }
	    
	    public static String getName(String uuid) {
	        String url = "https://api.mojang.com/user/profiles/"+uuid.replace("-", "")+"/names";
	        try {
	            String nameJson = IOUtils.toString(new URL(url));           
	            JSONArray nameValue = (JSONArray) JSONValue.parseWithException(nameJson);
	            String playerSlot = nameValue.get(nameValue.size()-1).toString();
	            JSONObject nameObject = (JSONObject) JSONValue.parseWithException(playerSlot);
	            return nameObject.get("name").toString();
	        } catch (IOException | ParseException e) {
	            e.printStackTrace();
	        }
	        return "error";
	    }
	    
	  //  DELETE FROM `user` WHERE `user`.`ID` = 21
	  
}
