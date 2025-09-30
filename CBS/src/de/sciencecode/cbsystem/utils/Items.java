package de.sciencecode.cbsystem.utils;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class Items
{
  public static ItemStack createItem(Material material, int anzahl, int subid, String displayname)
  {
    short neuesubid = (short)subid;
    ItemStack i = new ItemStack(material, anzahl, neuesubid);
    ItemMeta m = i.getItemMeta();
    m.setDisplayName(displayname);
    i.setItemMeta(m);
    
    return i;
  }
  
  public static ItemStack createItemDurability(Material material, int anzahl, int subid, String displayname)
  {
    short neuesubid = (short)subid;
    ItemStack i = new ItemStack(material, anzahl, neuesubid);
    ItemMeta m = i.getItemMeta();
    m.setDisplayName(displayname);
    i.setItemMeta(m);
    i.setDurability((short)60);
    
    return i;
  }
  
  public static ItemStack createHeadItem(String owner, String displayname)
  {
    ItemStack i = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
    SkullMeta sm = (SkullMeta)i.getItemMeta();
    sm.setOwner(owner);
    sm.setDisplayName(displayname);
    i.setItemMeta(sm);
    
    return i;
  }
  
  public static ItemStack createEnchantmentItem(Material material, int anzahl, int subid, String displayname, Enchantment enchantment, int enchantmentID)
  {
    short neuesubid = (short)subid;
    ItemStack i = new ItemStack(material, anzahl, neuesubid);
    ItemMeta m = i.getItemMeta();
    m.setDisplayName(displayname);
    m.addEnchant(enchantment, enchantmentID, true);
    i.setItemMeta(m);
    
    return i;
  }
  
  public static ItemStack createLeatherBoots(String displayname, Color color, String lores)
  {
    ItemStack i = new ItemStack(Material.LEATHER_BOOTS, 1);
    LeatherArmorMeta lam = (LeatherArmorMeta)i.getItemMeta();
    lam.setDisplayName(displayname);
    List<String> lore = new ArrayList<String>();
    lore.add(lores);
    lam.setLore(lore);
    lam.setColor(color);
    i.setItemMeta(lam);
    
    return i;
  }
  
  public static ItemStack createLeatherChest(String displayname, Color color, String lores)
  {
    ItemStack i = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
    LeatherArmorMeta lam = (LeatherArmorMeta)i.getItemMeta();
    lam.setDisplayName(displayname);
    List<String> lore = new ArrayList<String>();
    lore.add(lores);
    lam.setLore(lore);
    lam.setColor(color);
    i.setItemMeta(lam);
    
    return i;
  }
  
  public static ItemStack createLeatherleggings(String displayname, Color color, String lores)
  {
    ItemStack i = new ItemStack(Material.LEATHER_LEGGINGS, 1);
    LeatherArmorMeta lam = (LeatherArmorMeta)i.getItemMeta();
    lam.setDisplayName(displayname);
    List<String> lore = new ArrayList<String>();
    lore.add(lores);
    lam.setLore(lore);
    lam.setColor(color);
    i.setItemMeta(lam);
    
    return i;
  }
  
  @SuppressWarnings("deprecation")
public static ItemStack IDStack(String Display, int id, String lores, int Anzahl, int subid)
  {
    ItemStack istack52 = new ItemStack(id, Anzahl, (short)subid);
    ItemMeta istackMeta52 = istack52.getItemMeta();
    istackMeta52.setDisplayName(Display);
    List<String> lore = new ArrayList<String>();
    lore.add(lores);
    istackMeta52.setLore(lore);
    istack52.setItemMeta(istackMeta52);
    return istack52;
  }
  
  @SuppressWarnings("deprecation")
public static ItemStack IDStack1(String Display, int id, String lores, int Anzahl)
  {
    ItemStack istack52 = new ItemStack(id, Anzahl);
    ItemMeta istackMeta52 = istack52.getItemMeta();
    istackMeta52.setDisplayName(Display);
    List<String> lore = new ArrayList<String>();
    lore.add(lores);
    istackMeta52.setLore(lore);
    istack52.setItemMeta(istackMeta52);
    return istack52;
  }
  
  public static ItemStack Stack(String Display, Material m, String lores, int Anzahl, short Shorts)
  {
    ItemStack istack52 = new ItemStack(m, Anzahl, Shorts);
    ItemMeta istackMeta52 = istack52.getItemMeta();
    istackMeta52.setDisplayName(Display);
    List<String> lore = new ArrayList<String>();
    lore.add(lores);
    istackMeta52.setLore(lore);
    istack52.setItemMeta(istackMeta52);
    return istack52;
  }
  
  @SuppressWarnings("deprecation")
public static ItemStack IDStack(String Display, int id, String lores, int Anzahl, short Shorts)
  {
    ItemStack istack52 = new ItemStack(id, Anzahl, Shorts);
    ItemMeta istackMeta52 = istack52.getItemMeta();
    istackMeta52.setDisplayName(Display);
    List<String> lore = new ArrayList<String>();
    lore.add(lores);
    istackMeta52.setLore(lore);
    istack52.setItemMeta(istackMeta52);
    return istack52;
  }
  
  public static ItemStack Skull(String Display, Material m, String lores, int Anzahl, short Shorts, String Owner)
  {
    ItemStack stack = new ItemStack(m, Anzahl, (short)3);
    SkullMeta meta = (SkullMeta)Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
    meta.setOwner(Owner);
    meta.setDisplayName(Display);
    List<String> lore = new ArrayList<String>();
    lore.add(lores);
    meta.setLore(lore);
    stack.setItemMeta(meta);
    return stack;
  }
  
  public static ItemStack colorArmor(String Display, Material m, String lores, int Anzahl, short Shorts, int RGB1, int RGB2, int RGB3)
  {
    ItemStack istack52 = new ItemStack(m, Anzahl, Shorts);
    LeatherArmorMeta istackMeta52 = (LeatherArmorMeta)istack52.getItemMeta();
    istackMeta52.setColor(Color.fromRGB(RGB1, RGB2, RGB3));
    istackMeta52.setDisplayName(Display);
    List<String> lore = new ArrayList<String>();
    lore.add(lores);
    istackMeta52.setLore(lore);
    istack52.setItemMeta(istackMeta52);
    return istack52;
  }
}
