package de.stats.undermain.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.stats.undermain.all.files;



public class qrys {

	public static String lizenz = files.getObject_lizenz.get("Lizenz");
	public static String name = files.getObject_lizenz.get("Name");
	public static String email = files.getObject_lizenz.get("Email");
	
    public static String ip(){
    	ResultSet rs = null;
		
		PreparedStatement st = null;

		try {
			st = mysql.getConnection().prepareStatement("SELECT ip FROM lizenz WHERE lizenz=? AND name=? AND email=?");
			st.setString(1, lizenz);
			st.setString(2, name);
			st.setString(3, email);
			st.execute();
			rs = st.getResultSet();
			if(rs.next()){
				   String er = rs.getString(1);
				   return er;
				}	
		} catch (SQLException e) {
			e.printStackTrace();

	}
		return "fehler";
    }
    
    public static void setIP(String ip){
		


		PreparedStatement st = null;
		
		try {
			st = mysql.getConnection().prepareStatement("UPDATE lizenz SET ip = ? WHERE lizenz = ? AND name = ? AND email = ?");
			st.setString(1, ip);
			st.setString(2, lizenz);
			st.setString(3, name);
			st.setString(4, email);
			st.execute();
			
	
		} catch (SQLException e) {
			e.printStackTrace();

	}
    }
    
    public static int getRows(){
    	ResultSet rs = null;
		PreparedStatement st = null;
		
		
		
		try {
			st = mysql.getConnection().prepareStatement("SELECT COUNT(*) AS rowcount FROM lizenz WHERE lizenz=? AND name=? AND email=?");
			st.setString(1, lizenz);
			st.setString(2, name);
			st.setString(3, email);
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
	
	
}
