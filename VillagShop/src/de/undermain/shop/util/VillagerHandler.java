package de.undermain.shop.util;


import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class VillagerHandler implements CommandExecutor, Listener {

    public Inventory createGui(String name, int reihen, Player inventoryHolder) {
        Inventory inventory = Bukkit.createInventory(inventoryHolder, reihen*9, name);
        return inventory;
    }
	String Prefix = files.getObject_config.get("Prefix").toString().replaceAll("&", "§");
	String ItemEinsName = files.getObject_config.get("IronName").toString().replaceAll("&", "§");
	String ItemZweiName = files.getObject_config.get("GoldName").toString().replaceAll("&", "§");
	String ItemDreiName = files.getObject_config.get("DiaName").toString().replaceAll("&", "§");

	int IronPreis = Integer.parseInt(files.getObject_config.get("IronPreis").toString().replaceAll("&", "§"));
	int GoldPreis = Integer.parseInt(files.getObject_config.get("GoldPreis").toString().replaceAll("&", "§"));
	int DiaPreis = Integer.parseInt(files.getObject_config.get("DiaPreis").toString().replaceAll("&", "§"));

	String CoinsUsage = files.getObject_config.get("CoinsUsage").toString().replaceAll("&", "§");
	String NoCoins = files.getObject_config.get("NotEnoughCoins").toString().replaceAll("&", "§");
	
	String ILore1 = files.getObject_config.get("IronLore1").toString().replaceAll("&", "§");
	String ILore2 = files.getObject_config.get("IronLore2").toString().replaceAll("&", "§");
	String ILore3 = files.getObject_config.get("IronLore3").toString().replaceAll("&", "§");

	String GLore1 = files.getObject_config.get("GoldLore1").toString().replaceAll("&", "§");
	String GLore2 = files.getObject_config.get("GoldLore2").toString().replaceAll("&", "§");
	String GLore3 = files.getObject_config.get("GoldLore3").toString().replaceAll("&", "§");
	
	String DLore1 = files.getObject_config.get("DiaLore1").toString().replaceAll("&", "§");
	String DLore2 = files.getObject_config.get("DiaLore2").toString().replaceAll("&", "§");
	String DLore3 = files.getObject_config.get("DiaLore3").toString().replaceAll("&", "§");
	


	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(player.hasPermission("tutorial.shop")) {
				if(args.length == 0) {
					new ShopVillager(player.getLocation());
					player.sendMessage("§aDer Shop wurde erfolgreich erstellt.");
				} else
					player.sendMessage("§cBitte benutze §6/shop§c!");
			} else
				player.sendMessage("§cDazu hast du keine Rechte!");
		}
		return false;
	}
	
	@EventHandler
	public void handleShopInteract(PlayerInteractEntityEvent event) {
		if(!(event.getRightClicked() instanceof Villager)) return;
		Villager shop = (Villager) event.getRightClicked();
		
		if(shop.getCustomName().equals(ShopVillager.VILLAGER_NAME)) {
			event.setCancelled(true);
			Player player = event.getPlayer();
			
			ItemStack eins = new ItemStack(Material.IRON_INGOT);
			ItemMeta stickMeta = eins.getItemMeta();
			stickMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
			stickMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			stickMeta.setDisplayName(ItemEinsName);
			ArrayList<String> Ilore = new ArrayList<>();
			Ilore.add(ILore1);
			Ilore.add(ILore2);
			Ilore.add(ILore3);
			stickMeta.setLore(Ilore);
			eins.setItemMeta(stickMeta);
			
			ItemStack zwei = new ItemStack(Material.GOLD_INGOT);
			ItemMeta zweiMeta = zwei.getItemMeta();
			zweiMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
			zweiMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			zweiMeta.setDisplayName(ItemZweiName);
			ArrayList<String> Glore = new ArrayList<>();
			Glore.add(GLore1);
			Glore.add(GLore2);
			Glore.add(GLore3);
			zweiMeta.setLore(Glore);
			zwei.setItemMeta(zweiMeta);
			
			ItemStack drei = new ItemStack(Material.DIAMOND);
			ItemMeta dreiMeta = drei.getItemMeta();
			dreiMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
			dreiMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			dreiMeta.setDisplayName(ItemDreiName);
			ArrayList<String> DLore = new ArrayList<>();
			DLore.add(DLore1);
			DLore.add(DLore2);
			DLore.add(DLore3);
			dreiMeta.setLore(DLore);
			drei.setItemMeta(dreiMeta);
			
			ItemStack dia = new ItemStack(Material.EMERALD);
			ItemMeta diaMeta = dia.getItemMeta();
			diaMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
			diaMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			diaMeta.setDisplayName("§b§lCoins: " + CoinsAPI.getCoins(event.getPlayer()));
			dia.setItemMeta(diaMeta);
			
			ItemStack glas = new ItemStack(Material.STAINED_GLASS_PANE);
	        Inventory inventory = createGui("§6§lSh§6§lop", 3, player);
	        player.openInventory(inventory);
	    	inventory.setItem(0, glas);
	    	inventory.setItem(1, glas);
	    	inventory.setItem(2, glas);
	    	inventory.setItem(3, glas);
	    	inventory.setItem(4, glas);
	    	inventory.setItem(5, glas);
	    	inventory.setItem(6, glas);
	    	inventory.setItem(7, glas);
	    	inventory.setItem(8, glas);
	    	inventory.setItem(9, glas);
	    	inventory.setItem(10, dia);
	    	inventory.setItem(11, glas);
	    	inventory.setItem(12, eins);
	    	inventory.setItem(13, glas);
	    	inventory.setItem(14, zwei);
	    	inventory.setItem(15, glas);
	    	inventory.setItem(16, drei);
	    	inventory.setItem(17, glas);
	    	inventory.setItem(18, glas);
	    	inventory.setItem(19, glas);
	    	inventory.setItem(20, glas);
	    	inventory.setItem(21, glas);
	    	inventory.setItem(22, glas);
	    	inventory.setItem(23, glas);
	    	inventory.setItem(24, glas);
	    	inventory.setItem(25, glas);
	    	inventory.setItem(26, glas);

		}
	}

	@EventHandler
	public void handleShopDamage(EntityDamageByEntityEvent event) {
		if(!(event.getEntity() instanceof Villager)) return;
		Villager shop = (Villager) event.getEntity();
		if(!shop.getCustomName().equals(ShopVillager.VILLAGER_NAME)) return;
		
		event.setCancelled(true);
		if(!(event.getDamager() instanceof Player)) return;
		Player player = (Player) event.getDamager();
		if(player.hasPermission("tutorial.shop.kill")) {
			if(player.getItemInHand().getType() == Material.LAVA_BUCKET) {
				shop.setHealth(0);
				player.sendMessage("§aDu hast den Shop entfernt!");
			}
		}
	}
	
	@EventHandler
    public void onClick(InventoryClickEvent e) {
        ItemStack is = new ItemStack(Material.STAINED_GLASS_PANE);
        ItemStack iron = new ItemStack(Material.IRON_INGOT);
        ItemStack gold = new ItemStack(Material.GOLD_INGOT);
        ItemStack dia = new ItemStack(Material.DIAMOND);
        ItemStack emerald = new ItemStack(Material.EMERALD);

        Player p = (Player) e.getWhoClicked();
    	int coins = CoinsAPI.getCoins(p);

    	String IronCommand = files.getObject_config.get("IronCommand").toString().replaceAll("%player%", p.getName());
    	String GoldCommand = files.getObject_config.get("GoldCommand").toString().replaceAll("%player%", p.getName());
    	String DiaCommand = files.getObject_config.get("DiaCommand").toString().replaceAll("%player%", p.getName());
        
    	String IText1 = files.getObject_config.get("IronText1").toString().replaceAll("&", "§").replaceAll("%coins%", String.valueOf(coins - IronPreis));
    	String IText2 = files.getObject_config.get("IronText2").toString().replaceAll("&", "§").replaceAll("%coins%", String.valueOf(coins - IronPreis));
    	String IText3 = files.getObject_config.get("IronText3").toString().replaceAll("&", "§").replaceAll("%coins%", String.valueOf(coins - IronPreis));
    	String IText4 = files.getObject_config.get("IronText4").toString().replaceAll("&", "§").replaceAll("%coins%", String.valueOf(coins - IronPreis));
    	String IText5 = files.getObject_config.get("IronText5").toString().replaceAll("&", "§").replaceAll("%coins%", String.valueOf(coins - IronPreis));
    	
    	String GText1 = files.getObject_config.get("GoldText1").toString().replaceAll("&", "§").replaceAll("%coins%", String.valueOf(coins - GoldPreis));
    	String GText2 = files.getObject_config.get("GoldText2").toString().replaceAll("&", "§").replaceAll("%coins%", String.valueOf(coins - GoldPreis));
    	String GText3 = files.getObject_config.get("GoldText3").toString().replaceAll("&", "§").replaceAll("%coins%", String.valueOf(coins - GoldPreis));
    	String GText4 = files.getObject_config.get("GoldText4").toString().replaceAll("&", "§").replaceAll("%coins%", String.valueOf(coins - GoldPreis));
    	String GText5 = files.getObject_config.get("GoldText5").toString().replaceAll("&", "§").replaceAll("%coins%", String.valueOf(coins - GoldPreis));
    	
    	String DText1 = files.getObject_config.get("DiaText1").toString().replaceAll("&", "§").replaceAll("%coins%", String.valueOf(coins - DiaPreis));
    	String DText2 = files.getObject_config.get("DiaText2").toString().replaceAll("&", "§").replaceAll("%coins%", String.valueOf(coins - DiaPreis));
    	String DText3 = files.getObject_config.get("DiaText3").toString().replaceAll("&", "§").replaceAll("%coins%", String.valueOf(coins - DiaPreis));
    	String DText4 = files.getObject_config.get("DiaText4").toString().replaceAll("&", "§").replaceAll("%coins%", String.valueOf(coins - DiaPreis));
    	String DText5 = files.getObject_config.get("DiaText5").toString().replaceAll("&", "§").replaceAll("%coins%", String.valueOf(coins - DiaPreis));
    	
		ItemMeta ironMeta = iron.getItemMeta();
		ironMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		ironMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		ironMeta.setDisplayName(ItemEinsName);
		ArrayList<String> Ilore = new ArrayList<>();
		Ilore.add(ILore1);
		Ilore.add(ILore2);
		Ilore.add(ILore3);
		ironMeta.setLore(Ilore);
		iron.setItemMeta(ironMeta);
		
		ItemMeta goldMeta = gold.getItemMeta();
		goldMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		goldMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		goldMeta.setDisplayName(ItemZweiName);
		ArrayList<String> GLore = new ArrayList<>();
		GLore.add(GLore1);
		GLore.add(GLore2);
		GLore.add(GLore3);
		goldMeta.setLore(GLore);
		gold.setItemMeta(goldMeta);
		
		ItemMeta diaMeta = dia.getItemMeta();
		diaMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		diaMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		diaMeta.setDisplayName(ItemDreiName);
		ArrayList<String> DLore = new ArrayList<>();
		DLore.add(DLore1);
		DLore.add(DLore2);
		DLore.add(DLore3);
		diaMeta.setLore(DLore);
		dia.setItemMeta(diaMeta);
		
		ItemMeta emeraldMeta = emerald.getItemMeta();
		emeraldMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		emeraldMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		emeraldMeta.setDisplayName("§b§lCoins: " + CoinsAPI.getCoins(p));
		emerald.setItemMeta(emeraldMeta);
		
        if(e.getView().getTopInventory().getTitle().equals("§6§lSh§6§lop")) {
            if(e.getCurrentItem().equals(is)) {
                e.setCancelled(true);
            }else if(e.getCurrentItem().equals(iron)) {
            	if(CoinsUsage.equals("yes")) {
                	if(coins < IronPreis) {
                        e.setCancelled(true);	
                    	e.getWhoClicked().closeInventory();
                		p.sendMessage(Prefix + NoCoins);
                	}else {
                		e.getWhoClicked().closeInventory();
                		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), IronCommand);
                		CoinsAPI.removeCoins(p, IronPreis);
                		p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
        				p.sendMessage(Prefix  + IText1);
        				p.sendMessage(Prefix  + IText2);
        				p.sendMessage(Prefix  + IText3);
        				p.sendMessage(Prefix  + IText4);
        				p.sendMessage(Prefix  + IText5);
                	}
            	}else {
                    e.setCancelled(true);	
            		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), IronCommand);
            		p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
    				p.sendMessage(Prefix  + IText1);
    				p.sendMessage(Prefix  + IText2);
    				p.sendMessage(Prefix  + IText3);
    				p.sendMessage(Prefix  + IText4);
    				p.sendMessage(Prefix  + IText5);
                	e.getWhoClicked().closeInventory();
            	}
            }else if(e.getCurrentItem().equals(emerald)){
                e.setCancelled(true);	
            }else if(e.getCurrentItem().equals(gold)) {
            	if(CoinsUsage.equals("yes")) {
            		if(coins < GoldPreis) {
                        e.setCancelled(true);	
                    	e.getWhoClicked().closeInventory();
                		p.sendMessage(Prefix + NoCoins);
                	}else {
                		p.closeInventory();
                		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), GoldCommand);
                		CoinsAPI.removeCoins(p, GoldPreis);
                		p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
        				p.sendMessage(Prefix  + GText1);
        				p.sendMessage(Prefix  + GText2);
        				p.sendMessage(Prefix  + GText3);
        				p.sendMessage(Prefix  + GText4);
        				p.sendMessage(Prefix  + GText5);
                	}
            	}else {
            		p.closeInventory();
            		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), GoldCommand);
            		p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
    				p.sendMessage(Prefix  + GText1);
    				p.sendMessage(Prefix  + GText2);
    				p.sendMessage(Prefix  + GText3);
    				p.sendMessage(Prefix  + GText4);
    				p.sendMessage(Prefix  + GText5);
            	}
            }else if(e.getCurrentItem().equals(dia)) {
            	if(CoinsUsage.equals("yes")) {
            		if(coins < DiaPreis) {
                        e.setCancelled(true);	
                    	e.getWhoClicked().closeInventory();
                		p.sendMessage(Prefix + NoCoins);
                	}else {
                		p.closeInventory();
                		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), DiaCommand);
                		CoinsAPI.removeCoins(p, DiaPreis);
        				p.sendMessage(Prefix  + DText1);
        				p.sendMessage(Prefix  + DText2);
        				p.sendMessage(Prefix  + DText3);
        				p.sendMessage(Prefix  + DText4);
        				p.sendMessage(Prefix  + DText5);
                	}

            	}else {
            		p.closeInventory();
            		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), DiaCommand);
            		p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
    				p.sendMessage(Prefix  + DText1);
    				p.sendMessage(Prefix  + DText2);
    				p.sendMessage(Prefix  + DText3);
    				p.sendMessage(Prefix  + DText4);
    				p.sendMessage(Prefix  + DText5);
            	}
            }
        }
        
    }	
	
}