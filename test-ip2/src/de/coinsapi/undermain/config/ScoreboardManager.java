package de.coinsapi.undermain.config;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import de.coinsapi.undermain.mysql.qryss;

public class ScoreboardManager {

	 public static void setScoreboard(Player p) {
	        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
	        Objective obj = board.registerNewObjective("aaa", "bbb");
	        
	        
	        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
	        obj.setDisplayName("§6Stats");
	    
	        obj.getScore("§1").setScore(14);
	        obj.getScore(updateTeam(board, "Time", "§7§lOnlinezeit: ", "§6" + qryss.ontime(p.getName()), ChatColor.YELLOW)).setScore(12);
	        obj.getScore(updateTeam(board, "Kills", "§7§lKills: ", "§6" + qryss.kills(p.getName()), ChatColor.BLUE)).setScore(6);
	        obj.getScore(updateTeam(board, "Deaths", "§7§lDeaths: ", "§6" + qryss.deaths(p.getName()), ChatColor.RED)).setScore(4);
	        obj.getScore(updateTeam(board, "Coins", "§7§lCoins: ", "§6" + CoinsAPI.getCoins(p), ChatColor.GREEN)).setScore(2);
	        obj.getScore("§5").setScore(0);
	        
	        p.setScoreboard(board);
	    }
	    
	    public static void updateScoreboard(Player p) {
	        Scoreboard board = p.getScoreboard();
	        Objective obj = board.getObjective("aaa");
	        
	        obj.getScore(updateTeam(board, "Time", "§7§lOnlinezeit: ", "§6" + qryss.ontime(p.getName()), ChatColor.YELLOW)).setScore(12);
	        obj.getScore(updateTeam(board, "Kills", "§7§lKills: ", "§6" + qryss.kills(p.getName()), ChatColor.BLUE)).setScore(6);
	        obj.getScore(updateTeam(board, "Deaths", "§7§lDeaths: ", "§6" + qryss.deaths(p.getName()), ChatColor.RED)).setScore(4);
	        obj.getScore(updateTeam(board, "Coins", "§7§lCoins: ", "§6" + CoinsAPI.getCoins(p), ChatColor.GREEN)).setScore(2);
	        
	    }

	    public static Team getTeam(Scoreboard board, String Team, String prefix, String suffix) {
	        Team team = board.getTeam(Team);
	        if(team == null) {
	            team = board.registerNewTeam(Team);
	        }
	        team.setPrefix(prefix);
	        team.setSuffix(suffix);
	        team.setAllowFriendlyFire(false);
	        team.setCanSeeFriendlyInvisibles(true);
	        
	        return team;
	    }
	    
	    public static String updateTeam(Scoreboard board, String Team, String prefix, String suffix, ChatColor entry) {
	        Team team = board.getTeam(Team);
	        if(team == null) {
	            team = board.registerNewTeam(Team);
	        }
	        team.setPrefix(prefix);
	        team.setSuffix(suffix);
	        team.addEntry(entry.toString());
	        
	        return entry.toString();
	    }
	    
}
