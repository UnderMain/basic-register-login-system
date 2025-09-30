package de.onlycode;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.onlycode.api.API_MySQL;
import de.onlycode.api.API_Stuff;
import de.onlycode.commands.CMD_setDeathmatch;
import de.onlycode.commands.CMD_setLobby;
import de.onlycode.commands.CMD_setSpawn;
import de.onlycode.commands.CMD_start;
import de.onlycode.commands.CMD_stats;
import de.onlycode.countdowns.Countdown;
import de.onlycode.listener.LISTENER_Chat;
import de.onlycode.listener.LISTENER_Chest;
import de.onlycode.listener.LISTENER_Death;
import de.onlycode.listener.LISTENER_Move;
import de.onlycode.listener.LISTENER_Navigator;
import de.onlycode.listener.LISTENER_Online;
import de.onlycode.listener.LISTENER_Stuff;
import de.onlycode.manager.FileManager;
import de.onlycode.manager.LocationManager;

public class TemplateMain extends JavaPlugin implements Listener {

	public static TemplateMain main;
	public static Plugin plugin;

	public Gamestate state;
	public ArrayList<Player> alive;
	public String pr = "§8[§aDeine Prefix§8] ";
	public FileManager fm;
	public LocationManager lm;
	public Countdown cd;
	public API_Stuff utils;
	public LISTENER_Chest lc;
	public API_MySQL mysql;

	public int min = 5;
	public int dmstart = 4;
	public int max = 20;

	public int lobby = 60;
	public int frieden = 10;
	public int ingame = 60 * 30;
	public int deathmatch = 60 * 5;
	public int bevor = 60;
	public int restart = 15;

	public HashMap<Player, Player> lastdmg;

	@Override
	public void onEnable() {
		plugin = this;
		main = this;
		utils = new API_Stuff();
		state = Gamestate.LOBBY;
		lc = new LISTENER_Chest();
		alive = new ArrayList<Player>();
		lastdmg = new HashMap<Player, Player>();
		fm = new FileManager();
		lm = new LocationManager();
		cd = new Countdown();
		fm.saveCfg();
		fm.register();
		lm.saveCfg();
		ConnectMySQL();

		System.out.println("§7=========================");
		System.out.println("§7==   §ePlugin Template   §7==");
		System.out.println("§7== §eby byCode §7& §eOnlyKev §7==");
		System.out.println("§7=========================");

		getCommand("setdm").setExecutor(new CMD_setDeathmatch());
		getCommand("setlobby").setExecutor(new CMD_setLobby());
		getCommand("setspawn").setExecutor(new CMD_setSpawn());
		getCommand("start").setExecutor(new CMD_start());
		getCommand("stats").setExecutor(new CMD_stats());

		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new LISTENER_Chat(), this);
		pm.registerEvents(new LISTENER_Chest(), this);
		pm.registerEvents(new LISTENER_Death(), this);
		pm.registerEvents(new LISTENER_Move(), this);
		pm.registerEvents(new LISTENER_Navigator(), this);
		pm.registerEvents(new LISTENER_Online(), this);
		pm.registerEvents(new LISTENER_Stuff(), this);
		pm.registerEvents(this, this);
		lc.registerLoot();

	}

	@Override
	public void onDisable() {
		System.out.println("§7=========================");
		System.out.println("§7==   §ePlugin Template   §7==");
		System.out.println("§7== §eby byCode §7& §eOnlyKev §7==");
		System.out.println("§7=========================");
	}

	private void ConnectMySQL() {
		mysql = new API_MySQL("localhost", "Database", "User", "Passwort");
		mysql.update("CREATE TABLE IF NOT EXISTS Stats(UUID varchar(64), KILLS int, DEATHS int);");
	}

	@SuppressWarnings({ "static-access", "deprecation" })
	public void windetection() {
		if (state == Gamestate.INGAME || state == Gamestate.DEATHMATCH) {
			if (Bukkit.getOnlinePlayers().size() == 0) {
				cd.startRestartCD();

			} else {
				Bukkit.getScheduler().cancelTask(cd.deathmatchcd);
				if (alive.size() == 1) {
					Player winner = alive.get(0);
					for (Player all : Bukkit.getOnlinePlayers()) {
						TemplateMain.main.utils.clearPlayer(all);
						all.teleport(TemplateMain.main.lm.getLocation("lobby"));
						all.sendTitle("§e" + winner.getName(), "§ehat gewonnen§7!");
						all.sendMessage(
								TemplateMain.main.pr + "§a" + winner.getDisplayName() + " §ehat das Spiel gewonnen!");

					}
					cd.startRestartCD();

				}

			}

		}

	}

}
