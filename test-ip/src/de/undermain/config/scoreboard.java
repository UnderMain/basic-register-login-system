package de.undermain.config;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;


public class scoreboard {

	public static HashMap<Scoreboard, Player> scoreboards = new HashMap<>();
	
	   public static void setScoreboard(Player player) {
		   
		   final Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
		   final Objective obj = scoreboard.registerNewObjective("score", "ufc");
		   
		   Team adminPrefix = scoreboard.registerNewTeam("1 - Admin");
		   Team spielerPrefix = scoreboard.registerNewTeam("2 - Spieler");
		   adminPrefix.setPrefix("§4");
		   spielerPrefix.setPrefix("§7");
		   

		   
		   Bukkit.getOnlinePlayers().forEach(players -> {
			   if(players.isOp()) {
				   adminPrefix.addEntry(players.getName());
				   
			   }else {
				   spielerPrefix.addEntry(players.getName());
			   }
		   });
		   obj.setDisplayName("§7§l×§b§l Citybuild §7§l×");
		   obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		   obj.getScore("").setScore(10);
		   obj.getScore("§4§l» §cDeine Coins:").setScore(9);
		   obj.getScore("").setScore(8);
		   obj.getScore("").setScore(7);
		   obj.getScore("").setScore(6);
		   obj.getScore("").setScore(5);
		   obj.getScore("").setScore(4);
		   obj.getScore("").setScore(3);
		   obj.getScore("").setScore(2);
		   obj.getScore("").setScore(1);
		   obj.getScore("").setScore(0);

	   }
	

	
}
