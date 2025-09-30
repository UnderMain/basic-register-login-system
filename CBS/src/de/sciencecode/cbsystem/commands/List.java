package de.sciencecode.cbsystem.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.sciencecode.cbsystem.main.Main;

public class List
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
    if ((cmd.getName().equalsIgnoreCase("list")) && 
      ((sender instanceof Player))) {
      if (Bukkit.getOnlinePlayers().size() == 1) {
        p.sendMessage(Main.getPrefix() + "§aEs ist gerade §e" + Bukkit.getOnlinePlayers().size() + "§a Spieler Online.");
      } else if (Bukkit.getOnlinePlayers().size() >= 1) {
        p.sendMessage(Main.getPrefix() + "§aEs sind gerade §e" + Bukkit.getOnlinePlayers().size() + "§a Spieler Online.");
      }
    }
    return false;
  }
}
