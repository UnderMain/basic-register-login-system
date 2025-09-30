package de.undermain.zenitcommands.main;


import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.undermain.zenitcommands.main.Main;
import de.undermain.zenitcommands.utils.locationmanager;
import de.undermain.zenitcommands.commands.coins;
import de.undermain.zenitcommands.commands.coinss;
import de.undermain.zenitcommands.commands.crates;
import de.undermain.zenitcommands.commands.giveall;
import de.undermain.zenitcommands.listener.autosmelt;
import de.undermain.zenitcommands.listener.feed;
import de.undermain.zenitcommands.listener.heal;
import de.undermain.zenitcommands.listener.playerjoin;
import de.undermain.zenitcommands.listener.spawnerbreak;
import de.undermain.zenitcommands.listener.tag;

public class Main extends JavaPlugin {

    public static Main main;
	public static String prefix = "§6§lCityBuild §8× §7";
	public static String noperm = prefix + "§cDu hast nicht die benötigten Rechte, um dies zu nutzen!";
	public static locationmanager lm;
	public static boolean debug;


	public void onEnable() {

		main = this;
		debug = true;
		PluginManager pluginManager = Bukkit.getPluginManager();

		System.out.println("Â§aZenit-Commands wurde aktiviert!");
		getCommand("crates").setExecutor(new crates());
		getCommand("giveall").setExecutor(new giveall());
		getCommand("addcoins").setExecutor(new coins());
		getCommand("coins").setExecutor(new coinss());
		
		
		pluginManager.registerEvents(new spawnerbreak(), this);
		pluginManager.registerEvents(new playerjoin(), this);
		pluginManager.registerEvents(new heal(), this);
		pluginManager.registerEvents(new feed(), this);
		pluginManager.registerEvents(new tag(), this);
		pluginManager.registerEvents(new autosmelt(), this);
		lm = (new locationmanager());


		
	}



}
