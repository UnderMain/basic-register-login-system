package de.sciencecode.cbsystem.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.sciencecode.cbsystem.main.Main;

public class Plot implements CommandExecutor, Listener {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player)sender;
		
		if (args.length != 0) {
			p.sendMessage(Main.getPrefix() + "§cSyntax: /plot");
			return true;
		}
		Inventory inv = Bukkit.createInventory(null, 9 * 3, "§aPlot §7- §aMenu");
		
		ItemStack placeholder = new ItemStack(Material.STAINED_GLASS_PANE);
		ItemMeta placeholdermeta = placeholder.getItemMeta();
		placeholdermeta.setDisplayName(" ");
		placeholdermeta.addEnchant(Enchantment.DAMAGE_ALL, -1, true);
		placeholdermeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		placeholder.setItemMeta(placeholdermeta);
		
		ItemStack a1 = new ItemStack(Material.SIGN);
		ItemMeta a1meta = a1.getItemMeta();
		a1meta.setDisplayName("§ePlot erstellen.");
		a1.setItemMeta(a1meta);
		
		ItemStack a2 = new ItemStack(Material.REDSTONE_TORCH_ON);
		ItemMeta a2meta = a2.getItemMeta();
		a2meta.setDisplayName("§eZum Plot teleportieren.");
		a2.setItemMeta(a2meta);
		
		ItemStack a3 = new ItemStack(Material.BARRIER);
		ItemMeta a3meta = a3.getItemMeta();
		a3meta.setDisplayName("§cPlot löschen.");
		a3meta.setLore(Arrays.asList("§cAchtung: Dies ist nicht wiederrufbar!", "§eDu musst auf dein Plot stehen."));
		a3.setItemMeta(a3meta);
		
		inv.setItem(0, placeholder);
		inv.setItem(1, placeholder);
		inv.setItem(2, placeholder);
		inv.setItem(3, placeholder);
		inv.setItem(4, placeholder);
		inv.setItem(5, placeholder);
		inv.setItem(6, placeholder);
		inv.setItem(7, placeholder);
		inv.setItem(8, placeholder);
		inv.setItem(9, placeholder);
		inv.setItem(10, placeholder);
		inv.setItem(11, a1);
		inv.setItem(12, placeholder);
		inv.setItem(13, a2);
		inv.setItem(14, placeholder);
		inv.setItem(15, placeholder);
		inv.setItem(16, a3);
		inv.setItem(17, placeholder);
		inv.setItem(18, placeholder);
		inv.setItem(19, placeholder);
		inv.setItem(20, placeholder);
		inv.setItem(21, placeholder);
		inv.setItem(22, placeholder);
		inv.setItem(23, placeholder);
		inv.setItem(24, placeholder);
		inv.setItem(25, placeholder);
		inv.setItem(26, placeholder);


		p.openInventory(inv);
		
		return false;
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p = (Player)e.getWhoClicked();
		
		try {
		if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(" ")) {
			e.setCancelled(true);
		}
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§ePlot erstellen.")) {
			e.setCancelled(true);
			p.performCommand("2 auto");
		}
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eZum Plot teleportieren.")) {
			e.setCancelled(true);
			p.performCommand("2 h");
		}
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cPlot löschen.")) {
			e.setCancelled(true);
			p.performCommand("2 delete");
		}
	} catch (NullPointerException ex) {
		
	}

	}
}
