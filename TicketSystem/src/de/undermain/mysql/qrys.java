package de.undermain.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class qrys {

static String nachricht = "";
	
	 public static int setTicket(String name, String email, String nachricht, String thema, int status){ 			
			PreparedStatement st = null;
			
			try {
				st = MySQL.getConnection().prepareStatement("INSERT INTO ticket (Name, Email, Nachricht, Thema, Status) VALUES (?, ?, ?, ?, ?)");
				st.setString(1, name);
				st.setString(2, email);
				st.setString(3, nachricht);
				st.setString(4, thema);
				st.setInt(5, status);
				st.execute();
						
			} catch (SQLException e) {
				e.printStackTrace();

		}
			return 0;
	    }
	    
	    
	    public static int getStatus(String player){
	    	ResultSet rs;
			
			PreparedStatement st;
			
			try {
				st = MySQL.getConnection().prepareStatement("SELECT Status FROM ticket WHERE Name=?");
				st.setString(1, player);
				st.execute();
				rs = st.getResultSet();
				return rs.getInt(1);
		
			} catch (SQLException e) {
				e.printStackTrace();

		}
			return 0;
	    }
	    
	    public static int getToken(String player){
	    	ResultSet rs = null;
			
			PreparedStatement st = null;
			
			try {
				st = MySQL.getConnection().prepareStatement("SELECT token FROM ticket WHERE Name=? AND Status=?");
				st.setString(1, player);
				st.setInt(2, 0);
				st.execute();
				rs = st.getResultSet();
				
				return rs.getInt(1);
		
			} catch (SQLException e) {
				e.printStackTrace();

		}
			return 0;
	    }

	    public static String getThema(String player){
	    	ResultSet rs = null;
			
			PreparedStatement st = null;
			
			try {
				st = MySQL.getConnection().prepareStatement("SELECT Thema FROM ticket WHERE Status=? AND Name=?");
				st.setInt(1, 1);
				st.setString(2, player);
				st.execute();
				rs = st.getResultSet();
				return rs.getString(1);
		
			} catch (SQLException e) {
				e.printStackTrace();

		}
			return null;
	    }
	    
	    
	    public static String getTickets(String name) {
	    	
	    		    	
	    	String sql = "SELECT ID, Name, Thema, token, status FROM ticket WHERE Name='" + name + "'";
	    	try {
				Statement st = MySQL.getConnection().createStatement();
				ResultSet rs = st.executeQuery(sql);
				
				while(rs.next()) {
					nachricht = ("ID: " + rs.getString(1) + " Thema: " + rs.getString(3) + " Token: " + rs.getInt(4));
				}
					
			} catch (SQLException e) {

				
				e.printStackTrace();
			}
			return nachricht;
	    	
	    	
	    }
	    
	
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
}
