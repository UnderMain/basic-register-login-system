package de.sciencecode.cbsystem.listeners;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

import de.sciencecode.cbsystem.commands.Vanish;
import de.sciencecode.cbsystem.main.Main;
import de.sciencecode.cbsystem.utils.Manager;
import de.sciencecode.cbsystem.utils.ScoreboardMA;

public class JoinQuit
  implements Listener
{
	
  @EventHandler
  public void onJoin(PlayerJoinEvent e)
  {
    Player p = e.getPlayer();
    
	File file1 = new File("plugins/CB-System/data/" + p.getUniqueId().toString() + ".yml");
    YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(file1);
			
    if (!file1.exists()) {
	      Bukkit.broadcastMessage(Main.getPrefix() + "§8---------------------------------");
	      Bukkit.broadcastMessage(Main.getPrefix() + " ");
	      Bukkit.broadcastMessage(Main.getPrefix() + "§aDer Spieler §e" + p.getName() + " §aist neu auf dem Server.");
	      Bukkit.broadcastMessage(Main.getPrefix() + "§aWillkommen! §aDafür erhält er §e500 §aCoins!");
	      Bukkit.broadcastMessage(Main.getPrefix() + " ");
	      Bukkit.broadcastMessage(Main.getPrefix() + "§8---------------------------------");
    }
    
		cfg1.set("Join." + p.getName(), "Ja");
		try {
			cfg1.save(file1);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
			      
    p.performCommand("spawn");
    p.setGameMode(GameMode.SURVIVAL);
    Manager.sendTablistHeaderAndFooder(p, "§f \n §aWillkommen, §e" + p.getName() + " §aauf HeldMC.EU! \n §f", "§f \n §bErlebe CityBuild in neuer Art und Weise! \n §f");
    
    for (Player all : Bukkit.getOnlinePlayers()) {
    ScoreboardMA.setBoard(all);
    }
    
  if (Vanish.vanish.contains(p.getName())) {
    {
    	e.setJoinMessage("");	
    }
    } else if (p.hasPermission("cbsystem.team")) {
        e.setJoinMessage(Main.getPrefix() + "§aDas Teammitglied §e" + p.getName() + " §ahat den Server betreten!");
    }
    else
    {
      e.setJoinMessage(Main.getPrefix() + "§e" + p.getDisplayName() + " §ahat dem Server beigetreten.");
      p.playSound(p.getLocation(), Sound.CLICK, 3.0F, 1.0F);
    }
  }
  
  @EventHandler
  public void onQuit(PlayerQuitEvent e)
  {
    Player p = e.getPlayer();
    
    if (p.hasPermission("cbsystem.team")) {
      e.setQuitMessage(Main.getPrefix() + "§aDas Teammitglied §e" + p.getName() + " §ahat den Server verlassen!");
   
      for (Player all : Bukkit.getOnlinePlayers()) {
    	    ScoreboardMA.setBoard(all);
    	    }
    }
    e.setQuitMessage(Main.getPrefix() + "§e " + p.getName() + " §ahat den Server verlassen.");
    
    new BukkitRunnable()
    {
      public void run()
      {
        for (Player all : Bukkit.getOnlinePlayers()) {
          ScoreboardMA.setBoard(all);
        }
      }
    }.runTaskLater(Main.instance, 1L);
  }
  
	@EventHandler
	public void onQuit1(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		
		if (Main.database.contains(p.getUniqueId().toString())) {
		
		Main.database.set(p.getUniqueId().toString(), null);
		save();
		
		}

	}
	
	  public void save()
	  {
	    try
	    {
	      Main.database.save(Main.file);
	    }
	    catch (IOException ex)
	    {
	    	ex.printStackTrace();
	    }
	  }
  
}