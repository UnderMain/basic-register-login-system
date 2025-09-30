package de.sciencecode.cbsystem.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.sciencecode.cbsystem.main.Main;

public class GM implements CommandExecutor {
	
  public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
	  
	  
    if (!(sender instanceof Player)) {
      sender.sendMessage(Main.getPrefix() + "Du musst ein Spieler sein, um dies auführen zu können!");
    }
    Player p = (Player)sender;
    if (args.length == 1)
    {
      if (args[0].equalsIgnoreCase("1"))
      {
        if (p.hasPermission("cbsystem.gm"))
        {
          p.setGameMode(GameMode.CREATIVE);
          p.sendMessage(Main.getPrefix() + "§aDu bist nun im §e" + p.getGameMode() + " §aModus");
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§cDazu hast du keine Rechte!");
        }
      }
      else if (args[0].equalsIgnoreCase("2"))
      {
        if (p.hasPermission("cbsystem.gm"))
        {
          p.setGameMode(GameMode.ADVENTURE);
          p.sendMessage(Main.getPrefix() + "§aDu bist nun im §e" + p.getGameMode() + " §aModus");
        }
        else
        {
            p.sendMessage(Main.getPrefix() + "§cDazu hast du keine Rechte!");
        }
      }
      else if (args[0].equalsIgnoreCase("3"))
      {
        if (p.hasPermission("cbsystem.gm"))
        {
          p.setGameMode(GameMode.SPECTATOR);
          p.sendMessage(Main.getPrefix() + "§aDu bist nun im §e" + p.getGameMode() + " §aModus");
        }
        else
        {
            p.sendMessage(Main.getPrefix() + "§cDazu hast du keine Rechte!");
        }
      }
      else if (args[0].equalsIgnoreCase("0"))
      {
        if (p.hasPermission("cbsystem.gm"))
        {
          p.setGameMode(GameMode.SURVIVAL);
          p.sendMessage(Main.getPrefix() + "§aDu bist nun im §e" + p.getGameMode() + " §aModus");
        }
        else
        {
            p.sendMessage(Main.getPrefix() + "§cDazu hast du keine Rechte!");
        }
      }
      else {
    	  p.sendMessage(Main.getPrefix() + "§cSyntax: /gamemode [Gamemode] [Name]");
      }
    }
    else if (args.length == 2) {
      try
      {
        Player target = Bukkit.getPlayer(args[1]);
        if (args[0].equalsIgnoreCase("1"))
        {
          if (p.hasPermission("cbsystem.gm"))
          {
            target.setGameMode(GameMode.CREATIVE);
            target.sendMessage(Main.getPrefix() + "§aDein Spielmodus wurde geändert auf §e" + target.getGameMode());
            p.sendMessage(Main.getPrefix() + "§aDer Spielmodus von " + target.getName() + " §awurde geändert auf §e" + target.getGameMode());
          }
          else
          {
              p.sendMessage(Main.getPrefix() + "§cDazu hast du keine Rechte!");
          }
        }
        else if (args[0].equalsIgnoreCase("2"))
        {
          if (p.hasPermission("cbsystem.gm"))
          {
            target.setGameMode(GameMode.ADVENTURE);
            target.sendMessage(Main.getPrefix() + "§aDein Spielmodus wurde geändert auf §e" + target.getGameMode());
            p.sendMessage(Main.getPrefix() + "§aDer Spielmodus von " + target.getName() + " §awurde geändert auf §e" + target.getGameMode());
          }
          else
          {
              p.sendMessage(Main.getPrefix() + "§cDazu hast du keine Rechte!");
          }
        }
        else if (args[0].equalsIgnoreCase("3"))
        {
          if (p.hasPermission("cbsystem.gm"))
          {
            target.setGameMode(GameMode.SPECTATOR);
            target.sendMessage(Main.getPrefix() + "§aDein Spielmodus wurde geändert auf §e" + target.getGameMode());
            p.sendMessage(Main.getPrefix() + "§aDer Spielmodus von " + target.getName() + " §awurde geändert auf §e" + target.getGameMode());
          }
          else
          {
              p.sendMessage(Main.getPrefix() + "§cDazu hast du keine Rechte!");
          }
        }
        else if (args[0].equalsIgnoreCase("0"))
        {
          if (p.hasPermission("cbsystem.gm"))
          {
            target.setGameMode(GameMode.SURVIVAL);
            target.sendMessage(Main.getPrefix() + "§aDein Spielmodus wurde geändert auf §e" + target.getGameMode());
            p.sendMessage(Main.getPrefix() + "§aDer Spielmodus von " + target.getName() + " §awurde geändert auf §e" + target.getGameMode());
          }
          else
          {
              p.sendMessage(Main.getPrefix() + "§cDazu hast du keine Rechte!");
          }
        }
        else {
      	  p.sendMessage(Main.getPrefix() + "§cSyntax: /gamemode [Gamemode] [Name]");
        }
      }
      catch (NullPointerException ex)
      {
        p.sendMessage(Main.getPrefix() + "§cDieser Spieler ist nicht Online!!");
      }
    } else {
    	  p.sendMessage(Main.getPrefix() + "§cSyntax: /gamemode [Gamemode] [Name]");
    }
    return true;
  }
}
