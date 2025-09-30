package de.sciencecode.cbsystem.commands;

import java.util.Arrays;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.sciencecode.cbsystem.main.Main;

public class GiveAll
  implements CommandExecutor
{
	
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
      Player p = (Player)sender;
      if (p.hasPermission("cbsystem.admin"))
      {
        if ((p.getItemInHand() == null) || (p.getItemInHand().getType().equals(Material.AIR)))
        {
          p.sendMessage(Main.getPrefix() + "§cDu musst ein Item in der Hand halten!");
          p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5.0F, 5.0F);
        }
        else
        {
          ItemStack s1 = p.getItemInHand();
          String name = s1.getItemMeta().getDisplayName() == null ? s1.getType().name() : s1.getItemMeta().getDisplayName();
          for (Player all : Bukkit.getOnlinePlayers())
          {
            if (all != p)
            {
              ItemMeta ms1 = s1.getItemMeta();
              ms1.setLore(Arrays.asList("§bDieses Item wurde beim GiveAll verschenkt!"));
              s1.setItemMeta(ms1);
              all.getInventory().addItem(s1);
            }
            all.sendMessage(Main.getPrefix() + "§aAlle Spieler haben das Item §e" + ChatColor.translateAlternateColorCodes('&', name) + " §avon §e" + p.getName() + " §aerhalten!");
            all.playSound(all.getLocation(), Sound.LEVEL_UP, 5.0F, 5.0F);
          }
        }
      }
      else
      {
        p.sendMessage(Main.getPrefix() + "§cDazu hast du keine Rechte!");
        p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5.0F, 5.0F);
      }
    return false;
  }
}
