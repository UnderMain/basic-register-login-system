package de.sciencecode.cbsystem.commands;

import java.io.File;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import de.sciencecode.cbsystem.main.Main;
import de.sciencecode.cbsystem.utils.Manager;

public class SetHome
  implements CommandExecutor
{
  public static File file = new File("plugins/CB-System/homes.yml");
  public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
    {
        if (args.length == 0)
        {
          p.sendMessage(Main.getPrefix() + "§cSyntax: /sethome [Name]");
        }
        else if (args.length == 1)
        {
          try
          {
            cfg.load(file);
          }
          catch (Exception localException) {}
          if (!Manager.ifHomeExist(p, args[0]))
          {
        	  Manager.newHome(p, args[0]);
            p.sendMessage(Main.getPrefix() + "§aDu hast dein Home §e" + args[0] + " §aerfolgreich gesetzt!");
          }
          else
          {
            p.sendMessage(Main.getPrefix() + "§cDer Home §e" + args[0] + " §cexistiert bereits.");
          }
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§cSyntax: /sethome [Name]");
        }
      }
    return false;
  }
}
