package de.sciencecode.cbsystem.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.sciencecode.cbsystem.main.Main;

public class Rang
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
    if (p.hasPermission("cbsystem.rang"))
    {
      if (args.length == 2)
      {
        if (Bukkit.getPlayer(args[0]) != null)
        {
          Player target = Bukkit.getPlayer(args[0]);
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), 
            "pex user " + target.getName() + " group set " + args[1]);
          p.sendMessage(Main.getPrefix() + "§aDer Spieler §e" + p.getName() + " §ahat nun den Rang §e" + args[1]);
          target.kickPlayer("§cDu wurdest vom Server gekickt! \n\n §aGrund: §eNeuer Rang [" + args[1] + "]");
        }
        else
        {
        	p.sendMessage(Main.getPrefix() + "§cDieser Spieler ist nicht Online!");
        }
      }
      else {
        p.sendMessage(Main.getPrefix() + "§cSyntax: /rang [Spieler] [Gruppe]");
      }
    }
    else {
    	p.sendMessage(Main.getPrefix() + "§cDazu hast du keine Rechte!");
    }
    return false;
  }
}
