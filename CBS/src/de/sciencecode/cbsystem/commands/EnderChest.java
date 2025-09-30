package de.sciencecode.cbsystem.commands;

import java.util.ArrayList;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.sciencecode.cbsystem.main.Main;

public class EnderChest
  implements CommandExecutor
{
  public static ArrayList<UUID> enderchest = new ArrayList<UUID>();
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if ((cmd.getName().equalsIgnoreCase("enderchest")) || (cmd.getName().equalsIgnoreCase("ec")))
    {
      if (!(sender instanceof Player))
      {
        sender.sendMessage(Main.getPrefix() + "Du musst ein Spieler sein!");
        return true;
      }
      Player p = (Player)sender;
      if (!p.hasPermission("cbsystem.ec"))
      {
        p.sendMessage(Main.getPrefix() + "§cDazu hast du keine Rechte!");
        return true;
      }
      if (args.length == 0)
      {
        p.openInventory(p.getEnderChest());
        p.sendMessage(Main.getPrefix() + "§aDu hast deine §eEnderChest §aerfolgreich geöffnet!");
      }
      else if (args.length == 1)
      {
        if (!p.hasPermission("cbsystem.ec.others"))
        {
          p.sendMessage(Main.getPrefix() + "§cDazu hast du keine Rechte!");
          return true;
        }
        Player target = Bukkit.getPlayer(args[0]);
        if (target == null)
        {
          p.sendMessage(Main.getPrefix() + "§cDieser Spieler ist nicht online!");
          return true;
        }
        p.openInventory(target.getEnderChest());
        p.sendMessage(Main.getPrefix() + "§aDu schaust nun in die §eEnderchest §avon §e" + target.getName() + "§a.");
        enderchest.contains(p.getUniqueId());
      }
      else
      {
        p.sendMessage(Main.getPrefix() + "§cSyntax: §c/" + label + "[Spieler]");
      }
      return false;
    }
    return false;
  }
}
