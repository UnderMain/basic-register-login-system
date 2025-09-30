package de.undermain.main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import me.clip.placeholderapi.PlaceholderAPI;


public class Main extends JavaPlugin implements Listener {
	
	@Override
	public void onEnable() {
	
		this.getServer().getPluginManager().registerEvents(this, this);
		
	}
	
	public void setScoreboard(Player p) {
		
	
		
    String withoutPlaceholdersSet = "%player_name% &ajoined the server! He/she is rank &f%vault_rank%";
        
    String withPlaceholdersSet = PlaceholderAPI.setPlaceholders(p.getPlayer(), withoutPlaceholdersSet);
 	
		
	ScoreboardManager sm = Bukkit.getScoreboardManager();
	final Scoreboard board = sm.getNewScoreboard();
	final Objective o = board.registerNewObjective("test", "dummy");
	
	o.setDisplaySlot(DisplaySlot.SIDEBAR);
	o.setDisplayName("§7» §6Zenit§7Netzwerk §7«");
	
	o.getScore("§a ").setScore(11);
	o.getScore("§7» §cDein Rang §7«").setScore(10);
	
	
	if (p.hasPermission("prefix.admin")) {
		o.getScore("§7» §4§lAdmin").setScore(9);
	} else if (p.hasPermission("prefix.mod")) {
		o.getScore("§7» §3§lModerator").setScore(9);
	} else if (p.hasPermission("prefix.supp")) {
		o.getScore("§7» §c§lSupporter").setScore(9);
	} else if (p.hasPermission("prefix.helfer")) {
		o.getScore("§7» §8§lHelfer").setScore(9);
	} else if (p.hasPermission("prefix.vip")) {
		o.getScore("§7» §b§lVIP").setScore(9);
	} else if (p.hasPermission("prefix.premium")) {
		o.getScore("§7» §6§lPremium").setScore(9);
	} else if (p.hasPermission("prefix.elite")) {
		o.getScore("§7» §a§lElite").setScore(9);
	} else if (p.hasPermission("prefix.builder")) {
		o.getScore("§7» §5§lBuilder").setScore(9);
	} else if (p.hasPermission("prefix.developer")) {
		o.getScore("§7» §3§lDeveloper").setScore(9);
	} else  {
		o.getScore("§7» §2§lSpieler").setScore(9);

	}
	
	

	o.getScore("§b ").setScore(8);
	o.getScore("§7» §cKontostand §7« ").setScore(7);
	o.getScore("§7»  %vault_eco_balance%").setScore(6);
	o.getScore("§c ").setScore(5);
	o.getScore("§7» §cShop §7«").setScore(4);
	o.getScore("§7» shop.zenit-netzwerk.de§c").setScore(3);
	o.getScore("").setScore(2);
	o.getScore("§7» §cTeamSpeak §7«").setScore(1);
	o.getScore("§7» ts.zenit-netzwerk.de").setScore(0);
		
	p.setScoreboard(board);
	
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