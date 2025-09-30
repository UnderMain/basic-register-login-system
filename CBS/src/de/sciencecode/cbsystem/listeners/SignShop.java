package de.sciencecode.cbsystem.listeners;

import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import de.NeonnBukkit.CoinsAPI.API.CoinsAPI;
import de.sciencecode.cbsystem.main.Main;

public class SignShop
  implements Listener
{
  int ID = 0;
  int subID = 0;
  int price = 0;
  int coinsToCheck = 0;
  
  @EventHandler
  public void onSignChange(SignChangeEvent e)
  {
	Player p = e.getPlayer();
	
	if (p.hasPermission("cbsystem.createsign")) {
    if (e.getLine(0).equalsIgnoreCase("[Shop]")) {
      e.setLine(0, "§8[§eSHOP§8]");
    	}
    }
  }
  
  @SuppressWarnings("deprecation")
@EventHandler
  public void onInteract(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    if ((e.getAction() == Action.RIGHT_CLICK_BLOCK) && 
      ((e.getClickedBlock().getState() instanceof Sign)))
    {
      Sign s = (Sign)e.getClickedBlock().getState();
      if (s.getLine(1).contains(":"))
      {
        String[] array = s.getLine(1).split(":");
        ID = Integer.valueOf(array[0]).intValue();
        subID = Integer.valueOf(array[1]).intValue();
        price = Integer.valueOf(s.getLine(2));
        coinsToCheck = price - 1;
      }
      else
      {
        ID = Integer.valueOf(s.getLine(1)).intValue();
      }
    	
      if (CoinsAPI.getCoins(p.getUniqueId().toString()) < coinsToCheck) {
    	  CoinsAPI.removeCoins(p.getUniqueId().toString(), price);
    	  ItemStack item = new ItemStack(ID, 1, (short)subID);
    	  p.getInventory().addItem(item);
    	  p.sendMessage(Main.getPrefix() + "§aDu hast den Einkauf erfolgreich abgeschlossen.");
          
          } else if (CoinsAPI.getCoins(p.getUniqueId().toString()) > price) {
        	  p.sendMessage(Main.getPrefix() + "§cDazu hast du zu wenige Coins!");
 
          }
    }
  }
}
