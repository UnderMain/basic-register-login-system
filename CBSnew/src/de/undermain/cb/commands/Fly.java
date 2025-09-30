package de.undermain.cb.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.undermain.cb.main.Main;


public class Fly implements CommandExecutor {

	@Override
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
	    Player p = (Player)sender;
	    if (cmd.getName().equalsIgnoreCase("fly")) {
	      if ((sender instanceof Player))
	      {
	        if (args.length == 0) {
	          if (p.hasPermission("cbsystem.fly") || p.hasPermission("cbsystem.fly.*"))
	          {
	            if (p.getAllowFlight())
	            {
	              p.setAllowFlight(false);
	              p.sendMessage(Main.getPrefix() + "§aDu kannst nun nicht mehr fliegen!");
	            }
	            else
	            {
	              p.setAllowFlight(true);
	              p.sendMessage(Main.getPrefix() + "§aDu kannst nun fliegen!");
	            }
	          }
	          else {
	              sender.sendMessage(Main.getPrefix() + "§cDazu hast du keine Rechte!");
	          }
	        }
	        if (args.length == 1) {
	          if (p.hasPermission("cbsystem.fly.other") || p.hasPermission("cbsystem.fly.*")) {
	            try
	            {
	              Player target = p.getServer().getPlayer(args[0]);
	              if (target.getAllowFlight())
	              {
	                target.setAllowFlight(false);
	                target.sendMessage(Main.getPrefix() + "§eDu kannst nun nicht mehr fliegen!");
	                p.sendMessage("§aDer Spieler §e" + args[0] + " §akann nun nicht mehr fliegen!");
	              }
	              else
	              {
	                target.setAllowFlight(true);
	                target.sendMessage(Main.getPrefix() + "§eDu kannst nun fliegen!");
	                p.sendMessage("§aDer Spieler §e" + args[0] + " §akann nun fliegen!");
	              }
	            }
	            catch (NullPointerException ex)
	            {
	              sender.sendMessage(Main.getPrefix() + "§cDer Spieler §4" + args[0] + " §cist nicht Online!");
	            }
	          } else {
	              sender.sendMessage(Main.getPrefix() + "§cDazu hast du keine Rechte!");
	          }
	        }
	      }
	      else
	      {
	    	  sender.sendMessage(Main.getPrefix() + "§cDu musst ein Spieler sein um dies ausführen zu können!");
	      }
	    }
	    return false;
	  }
	}

