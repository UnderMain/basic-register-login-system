package de.zenit.main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class mysqlQuerys {



   public String getName(String token) {
	         try {
         PreparedStatement var6 = Main.getInstance().getMySQL().getConnection().prepareStatement("SELECT uidUsers FROM users WHERE token = ?");
         var6.setString(1, token);
         ResultSet rs = var6.executeQuery();
  
         
     	

     	if(rs.next()) {
	         
 	 		return rs.getString("uidUsers");
 	         }else {
 	        	 return null;
 	         }
      } catch (SQLException var61) {
         var61.printStackTrace();
         return null;
      }
	
	  

   }
   
   public String getToken(String name) {
	      try {
	         PreparedStatement var6 = Main.getInstance().getMySQL().getConnection().prepareStatement("SELECT token FROM users WHERE uidUsers = ?");
	         var6.setString(1, name);
	         ResultSet rs = var6.executeQuery();	         
	         
	 		
	 		 if(rs.next()) {
		         
	 	 		return rs.getString("token");
	 	         }else {
	 	        	 return null;
	 	         }

	      } catch (SQLException var61) {
	         var61.printStackTrace();
	         return null;
	      }
		

	   }
   
   public String getUUID(String token) {
	      try {
	         PreparedStatement var6 = Main.getInstance().getMySQL().getConnection().prepareStatement("SELECT UUID FROM users WHERE token = ?");
	         var6.setString(1, token);
	         ResultSet rs = var6.executeQuery();	         
	         
	         if(rs.next()) {
	         
	 		return rs.getString("UUID");
	         }else {
	        	 return null;
	         }

	      } catch (SQLException var61) {
	         var61.printStackTrace();
	         return null;

	      }
		
	   }
   
   public static void insertUUID(String uuid, String token) {
	      try {
	         PreparedStatement var6 = Main.getInstance().getMySQL().getConnection().prepareStatement("UPDATE users SET UUID = ? WHERE token = ?");
	         var6.setString(1, uuid);
	         var6.setString(2, token);
	         var6.executeUpdate();
	         var6.close();

	      } catch (SQLException var61) {
	         var61.printStackTrace();
	      }

	   }




}