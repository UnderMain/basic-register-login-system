package de.undermain.coinapi.main;


import org.bukkit.plugin.java.JavaPlugin;

import de.undermain.coinapi.utils.mysql;




	
	public class Main extends JavaPlugin {

		public static String Prefix = "§6§lCoinAPI §8× §r";
		
		   private static Main instance;
		   mysql mySQL;

		   
		
		
		public void onEnable() {
			this.connectToMySQL("localhost", "abs", "abs", "abs", 3306);
			
			
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
	

