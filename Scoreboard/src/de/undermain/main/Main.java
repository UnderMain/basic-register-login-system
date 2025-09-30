package de.undermain.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import me.clip.placeholderapi.PlaceholderAPI;
import net.milkbowl.vault.economy.Economy;



public class Main extends JavaPlugin implements Listener {
	
	@Override
	public void onEnable() {
	
		this.getServer().getPluginManager().registerEvents(this, this);
		
	
	  if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
          Bukkit.getPluginManager().registerEvents(this, this);
      } else {
          throw new RuntimeException("Could not find PlaceholderAPI!! Plugin can not work without it!");
      }
  }
	
	public static Economy economy = null;

	private boolean setupEconomy()
	{
	RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
	if (economyProvider != null) {
	economy = economyProvider.getProvider();
	}

	return (economy != null);
	}

	String kontostand = PlaceholderAPI.setPlaceholders(null, "%vault_eco_balance%");
	
	public void setScoreboard(Player p) {
		
	ScoreboardManager sm = Bukkit.getScoreboardManager();
	final Scoreboard board = sm.getNewScoreboard();
	final Objective o = board.registerNewObjective("test", "dummy");

	
	o.setDisplaySlot(DisplaySlot.SIDEBAR);
	o.setDisplayName("§7» §6Zenit§7Netzwerk §7«");
	
	o.getScore("§a ").setScore(12);
	o.getScore("§7» §cDein Rang §7«").setScore(11);
	
	
	if (p.hasPermission("prefix.admin")) {
		o.getScore("§4§lAdmin").setScore(10);
	} else if (p.hasPermission("prefix.mod")) {
		o.getScore("§3§lModerator").setScore(10);
	} else if (p.hasPermission("prefix.supp")) {
		o.getScore("§c§lSupporter").setScore(10);
	} else if (p.hasPermission("prefix.helfer")) {
		o.getScore("§8§lHelfer").setScore(10);
	} else if (p.hasPermission("prefix.vip")) {
		o.getScore("§b§lVIP").setScore(10);
	} else if (p.hasPermission("prefix.premium")) {
		o.getScore("§6§lPremium").setScore(10);
	} else if (p.hasPermission("prefix.elite")) {
		o.getScore("§a§lElite").setScore(10);
	} else if (p.hasPermission("prefix.builder")) {
		o.getScore("§5§lBuilder").setScore(10);
	} else if (p.hasPermission("prefix.developer")) {
		o.getScore("§3§lDeveloper").setScore(10);
	} else  {
		o.getScore("§2§lSpieler").setScore(10);

	}
	


	o.getScore("").setScore(9);
	o.getScore("§7§l» §3§lOnline ").setScore(8);
	o.getScore("§7" + Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers()).setScore(7);
	o.getScore("").setScore(6);
	o.getScore("§7§l» §3§lKontostand ").setScore(5);
	o.getScore("§7" + kontostand ).setScore(4);
	o.getScore("").setScore(3);
    o.getScore("§7§l» §3§lShop ").setScore(2);
	o.getScore("§7shop.zenit-netzwerk.de ").setScore(1);
	o.getScore("").setScore(0);
		
	p.setScoreboard(board);
	


	}
	
	private ChatColor getBalance(Player p) {
		// TODO Auto-generated method stub
		return null;
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		
		new BukkitRunnable() {
			@Override
			public void run() {
				
				for (Player all : Bukkit.getOnlinePlayers()) {
					setScoreboard(all);
				}
				
			}
		}.runTaskLater(this, 1);
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		
		new BukkitRunnable() {	
			@Override
			public void run() {
				
				for (Player all : Bukkit.getOnlinePlayers()) {
					setScoreboard(all);
				}
				
			}
		}.runTaskLater(this, 1);
	}

}