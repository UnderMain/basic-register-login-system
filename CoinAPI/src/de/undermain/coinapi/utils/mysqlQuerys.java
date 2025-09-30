package de.undermain.coinapi.utils;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import de.undermain.coinapi.main.Main;


public class mysqlQuerys {

   
   public static void insertName(String name, String server) {
	      try {
	         PreparedStatement var6 = Main.getInstance().getMySQL().getConnection().prepareStatement("INSERT INTO spielerliste (name, server) VALUES (?, ?)");
	         var6.setString(1, name);
	         var6.setString(2, server);
	         var6.executeUpdate();
	         var6.close();

	      } catch (SQLException var61) {
	         var61.printStackTrace();
	      }

	   }

   public static void deleteName(String name) {
	      try {
	         PreparedStatement var6 = Main.getInstance().getMySQL().getConnection().prepareStatement("DELETE FROM spielerliste WHERE name = ?");
	         var6.setString(1, name);
	         var6.executeUpdate();
	         var6.close();

	      } catch (SQLException var61) {
	         var61.printStackTrace();
	      }

	   }
   
   



}
