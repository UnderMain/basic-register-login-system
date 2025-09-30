package de.undermain.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.undermain.listener.JoinListener;
import de.undermain.listener.QuitListener;
import de.undermain.main.Main;
import de.undermain.main.mysql;


	
	public class Main extends JavaPlugin {

		public static String Prefix = "§6§lZenitLink §8× §r";
		
		   private static Main instance;
		   mysql mySQL;

		   
		
		
		public void onEnable() {
			this.connectToMySQL("localhost", "abs", "abs", "abs", 3306);

			PluginManager pm = Bukkit.getPluginManager();
			
			pm.registerEvents(new JoinListener(), this);
			pm.registerEvents(new QuitListener(), this);

			
		    instance = this;
		   

		}
		
		   private void connectToMySQL(String host, String user, String password, String database, int port) {
			      this.mySQL = new mysql(host, user, password, database, port);
			   }

		   public static Main getInstance() {
			      return instance;
			   }


			   public mysql getMySQL() {
			      return this.mySQL;
			   }

}
	

