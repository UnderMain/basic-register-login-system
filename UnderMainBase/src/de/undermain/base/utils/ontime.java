package de.undermain.base.utils;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import de.undermain.base.main.Main;
import de.undermain.base.mysql.MySQLL;
import de.undermain.base.mysql.qryss;

public class ontime {

	private static int taskID;
	
	public void onTime(Player p) {
		int ontime = qryss.ontime(p.getName());
		int newot = ontime + 1;
		qryss.insertOT(p, newot);
	}
	
	  
	  public ontime() {
		  int spieler = Bukkit.getOnlinePlayers().size();
		  
		  if(spieler > 0) {
			  updateOnlineTime();
		  }else {
			  Bukkit.getScheduler().cancelTask(taskID);
		  }
	  }
	  
	  public static void disableOntime() {
		  Bukkit.getScheduler().cancelTask(taskID);
	  }
	  

	  
	  public static void updateOnlineTime() {
		  
		  taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {

			@Override
			public void run() {
				
				PreparedStatement st = null;
				
				try {
					st = MySQLL.getConnection().prepareStatement("UPDATE playerTable SET ontime = ontime+1 WHERE online=?");
					st.setInt(1, 1);
					st.executeUpdate();
			
				} catch (SQLException e) {
					e.printStackTrace();

			}
				
			}
			  
			  
			  
		  }, 0, 20 * 60);
		  
	  }
}
