package de.undermain.base.main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import de.undermain.base.commands.stats;
import de.undermain.base.files.files;
import de.undermain.base.listener.joinListener;
import de.undermain.base.utils.CoinsAPI;
import de.undermain.base.utils.ontime;





public class Main extends JavaPlugin{
	private static Main plugin;
	public static boolean debug;
	public static void registerFiles() {
		new files().createDefaultMySQLFile();
	}

	public static int Coins(Player p) {
		return CoinsAPI.getCoins(p);
	}
	
	public static void run() {
		     new files().loadDefaultMySQLFile();

		}
	
	public void onEnable() {
		setPlugin(this);
		registerFiles();
		run();
		ontime.updateOnlineTime();
	    getServer().getPluginManager().registerEvents(new joinListener(), this);
		getCommand("stats").setExecutor(new stats());

		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("§3§l___________________________________________________________");
		Bukkit.getConsoleSender().sendMessage(" ");
		Bukkit.getConsoleSender().sendMessage("§d§lUnderMain Base API!");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("§3§lAuthor: §b§lUnderMain.de");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("§3§lPlugin-Version: §c§l1.1");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("§3§lDu brauchst dieses Plugin!");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("§3§l___________________________________________________________");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("");	
	}
	public void onDisable() {
		ontime.disableOntime();
	}

	public static Main getPlugin() {
		return plugin;
	}

	public static void setPlugin(Main plugin) {
		Main.plugin = plugin;
	}
}
