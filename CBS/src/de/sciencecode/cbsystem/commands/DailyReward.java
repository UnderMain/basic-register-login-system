package de.sciencecode.cbsystem.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import de.sciencecode.cbsystem.main.Main;
import de.sciencecode.cbsystem.utils.Manager;
import de.sciencecode.cbsystem.utils.ScoreboardMA;

public class DailyReward implements CommandExecutor, Listener {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player)sender;

	    if (!(sender instanceof Player))
	    {
	      sender.sendMessage(Main.getPrefix() + "§cDu musst ein Spieler sein!");
	      return true;
	    }
	    if (args.length == 0) {
	    	Manager.openRewardInv(p);
	    }
		
		return false;
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p = (Player)e.getWhoClicked();
		
		if (e.getInventory().getName().equals("§eTägliche Belohnung")) {
			e.setCancelled(true);
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6Belohnung abholen.")) {
				Manager.setReward(p);
				
				ItemStack is = new ItemStack(Material.DIAMOND, 5);
				p.getInventory().addItem(is);
				
				ScoreboardMA.setBoard(p);
				
				e.getView().close();
				
				Bukkit.broadcastMessage(Main.getPrefix() + "§e" + p.getName() + " §ahat die Tägliche Belohnug abgeholt und bekam dafür tolle Geschenke!");
				
			}
		}
	}

}
