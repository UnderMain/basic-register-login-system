package de.sciencecode.cbsystem.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import de.NeonnBukkit.CoinsAPI.API.CoinsAPI;

public class ScoreboardMA implements Listener

{
	@SuppressWarnings("deprecation")
	public static void setBoard(Player p) {

		Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective obj = board.getObjective("CBSystem");

		obj.setDisplayName("§8» §eHeldMC.EU");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);

		Score a1 = obj.getScore("§0");
		Score a2 = obj.getScore("§7Coins:");
		Score a3 = obj.getScore("§8» §a" + CoinsAPI.getCoins(p.getUniqueId().toString()));
		Score a4 = obj.getScore("§e ");
		Score a5 = obj.getScore("§7Spieler Online:");
		Score a6 = obj.getScore("§8» §e" + Bukkit.getOnlinePlayers().size());
		Score a7 = obj.getScore("§1 ");
		Score a8 = obj.getScore("§7Rank:");
		Score a9 = obj.getScore("§8» " + getRank(p));
		Score a10 = obj.getScore("§1");
		Score a11 = obj.getScore("§7TeamSpeak:");
		Score a12 = obj.getScore("§8» §bHeldMC.EU");
		Score a13 = obj.getScore("§3");
		Score a14 = obj.getScore("§7Forum:");
		Score a15 = obj.getScore("§8» §cKommt noch!");
		Score a16 = obj.getScore("§4");

		a1.setScore(14);
		a2.setScore(13);
		a3.setScore(12);
		a4.setScore(11);
		a5.setScore(10);
		a6.setScore(9);
		a7.setScore(8);
		a8.setScore(7);
		a9.setScore(6);
		a10.setScore(5);
		a11.setScore(4);
		a12.setScore(3);
		a13.setScore(2);
		a14.setScore(1);
		a15.setScore(0);
		a16.setScore(-1);

		p.setScoreboard(board);
	
	    String b1 = "§4Owner §8| §4";
	    String b2 = "§4Admin §8| §4";
	    String b3 = "§bSrDev §8| §b";
	    String b4 = "§bDev §8| §b";
	    String b5 = "§cSrMod §8| §c";
	    String b6 = "§cMod §8| §c";
	    String b7 = "§9Sup §8| §9";
	    String b8 = "§eBuilder §8| §e";
	    String b9 = "§5YTber §8| §5";
	    String b10 = "§5JrYTber §8| §5";
	    String b11 = "§6Premium §8| §6";
	    String b12 = "§7Spieler §8| §7";
	    
	    String c1 = "cbsystem.owner";
	    String c2 = "cbsystem.admin";
	    String c3 = "cbsystem.srdev";
	    String c4 = "cbsystem.dev";
	    String c5 = "cbsystem.srmod";
	    String c6 = "cbsystem.mod";
	    String c7 = "cbsystem.sup";
	    String c8 = "cbsystem.builder";
	    String c9 = "cbsystem.yter";
	    String c10 = "cbsystem.jryter";
	    String c11 = "cbsystem.premium";
	    
		if (board.getTeam("aaa") == null) { 
		    Team owner = board.registerNewTeam("aaa");
		    Team admin = board.registerNewTeam("bbb");
		    Team srdev = board.registerNewTeam("ccc");
		    Team dev = board.registerNewTeam("ddd");
		    Team srmod = board.registerNewTeam("eee");
		    Team mod = board.registerNewTeam("fff");
		    Team sup = board.registerNewTeam("ggg");
		    Team builder = board.registerNewTeam("hhh");
		    Team yter = board.registerNewTeam("jjj");
		    Team jryter = board.registerNewTeam("kkk");
		    Team premium = board.registerNewTeam("lll");
		    Team spieler = board.registerNewTeam("mmm");
			
	    
	    for (Player all : Bukkit.getOnlinePlayers()) {
	    	
	      if (all.hasPermission(c1))
	      {
	        owner.setPrefix(b1);
	        owner.addPlayer(all);
	      }
	      else if (all.hasPermission(c2))
	      {
	        admin.setPrefix(b2);
	        admin.addPlayer(all);
	      }
	      else if (all.hasPermission(c3))
	      {
	        srdev.setPrefix(b3);
	        srdev.addPlayer(all);
	      }
	      else if (all.hasPermission(c4))
	      {
	        dev.setPrefix(b4);
	        dev.addPlayer(all);
	      }
	      else if (all.hasPermission(c5))
	      {
	        srmod.setPrefix(b5);
	        srmod.addPlayer(all);
	      }
	      else if (all.hasPermission(c6))
	      {
	        mod.setPrefix(b6);
	        mod.addPlayer(all);
	      }
	      else if (all.hasPermission(c7))
	      {
	        sup.setPrefix(b7);
	        sup.addPlayer(all);
	      }
	      else if (all.hasPermission(c8))
	      {
	        builder.setPrefix(b8);
	        builder.addPlayer(all);
	      }
	      else if (all.hasPermission(c9))
	      {
	        yter.setPrefix(b9);
	        yter.addPlayer(all);
	      }
	      else if (all.hasPermission(c10))
	      {
	        jryter.setPrefix(b10);
	        jryter.addPlayer(all);
	      }
	      else if (all.hasPermission(c11))
	      {
	        premium.setPrefix(b11);
	        premium.addPlayer(all);
	      }
	      else
	      {
	        spieler.setPrefix(b12);
	        spieler.addPlayer(all);
	      }
	    }
	    }
	    }
	 
	 
		
	@EventHandler
	public void onSneak(PlayerToggleSneakEvent e) {
		Player p = e.getPlayer();

		if (p.isSneaking()) {
			setBoard(p);
		}
	}
	
	public static String getRank(Player p) {
		if (p.hasPermission("cbsystem.owner")) {
			return "§cOwner";
		}
		else if (p.hasPermission("cbsystem.admin")) {
			return "§4Admin";
		}
		else if (p.hasPermission("cbsystem.srdev")) {
			return "§bSrDev";
		}
		else if (p.hasPermission("cbsystem.dev")) {
			return "§bDev";
		}
		else if (p.hasPermission("cbsystem.srmod")) {
			return "§cSrMod";
		}
		else if (p.hasPermission("cbsystem.mod")) {
			return "§cMod";
		}
		else if (p.hasPermission("cbsystem.sup")) {
			return "§9Sup";
		}
		else if (p.hasPermission("cbsystem.builder")) {
			return "§eBuilder";
		}
		else if (p.hasPermission("cbsystem.yter")) {
			return "§5YouTuber";
		}
		else if (p.hasPermission("cbsystem.jryter")) {
			return "§5JrYouTuber";
		}
		else if (p.hasPermission("cbsystem.premium")) {
			return "§6Premium";
		}
		else {
			return "Spieler";
		}

	}
	

}
