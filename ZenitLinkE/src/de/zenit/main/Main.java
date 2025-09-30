package de.zenit.main;


import org.bukkit.plugin.java.JavaPlugin;


import de.zenit.commands.LinkCommand;
import de.zenit.commands.anleitung;
import de.zenit.commands.token;

public class Main extends JavaPlugin {

		public static String Prefix = "§6§lZenitLink §8× §r";
		
		   private static Main instance;
		   mysql mySQL;

		   
		
		
		public void onEnable() {
			this.connectToMySQL("localhost", "underRTMlr", "underRTMlr", "underRTMlr", 3306);
			getCommand("link").setExecutor(new LinkCommand());
			getCommand("accountinfo").setExecutor(new token());
			getCommand("anleitung").setExecutor(new anleitung());
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
