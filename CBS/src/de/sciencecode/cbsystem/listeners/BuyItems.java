package de.sciencecode.cbsystem.listeners;

import de.NeonnBukkit.CoinsAPI.API.CoinsAPI;
import de.sciencecode.cbsystem.main.Main;
import de.sciencecode.cbsystem.utils.Items;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class BuyItems
  implements Listener
{
  @EventHandler
  public void onC(InventoryClickEvent e1)
  {
    Player p = (Player)e1.getWhoClicked();
    if (e1.getInventory().getName().equalsIgnoreCase("§cShop")) {
      if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cHolzschwert §8- §b5 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 4)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c5 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createItem(Material.WOOD_SWORD, 1, 0, "§cSkyPvP §8|  §bShop") });
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 5);
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§cDu hast nicht genügend Coins um dies zu kaufen!");
          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cHolzschwert §8- §b10 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 9)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c10 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createEnchantmentItem(Material.WOOD_SWORD, 1, 0, "§cSkyPvP §8|  §bShop", Enchantment.DAMAGE_ALL, 1) });
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 10);
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
        }
        else
        {
            p.sendMessage(Main.getPrefix() + "§cDu hast nicht genügend Coins um dies zu kaufen!");
          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cHolzschwert §8- §b20 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 19)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c20 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createEnchantmentItem(Material.WOOD_SWORD, 1, 0, "§cSkyPvP §8|  §bShop", Enchantment.DAMAGE_ALL, 2) });
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 20);
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
        }
        else
        {
            p.sendMessage(Main.getPrefix() + "§cDu hast nicht genügend Coins um dies zu kaufen!");
          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cHolzschwert §8- §b35 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 34)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c35 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createEnchantmentItem(Material.WOOD_SWORD, 1, 0, "§cSkyPvP §8|  §bShop", Enchantment.DAMAGE_ALL, 3) });
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 35);
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
        }
        else
        {
            p.sendMessage(Main.getPrefix() + "§cDu hast nicht genügend Coins um dies zu kaufen!");
          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cHolzschwert §8- §b60 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 59)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c60 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createEnchantmentItem(Material.WOOD_SWORD, 1, 0, "§cSkyPvP §8|  §bShop", Enchantment.DAMAGE_ALL, 4) });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 60);
        }
        else
        {
            p.sendMessage(Main.getPrefix() + "§cDu hast nicht genügend Coins um dies zu kaufen!");
          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cSteinschwert §8- §b30 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 29)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c30 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createItem(Material.STONE_SWORD, 1, 0, "§cSkyPvP §8|  §bShop") });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 30);
        }
        else
        {
            p.sendMessage(Main.getPrefix() + "§cDu hast nicht genügend Coins um dies zu kaufen!");
          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cSteinschwert §8- §b45 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 44)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c45 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createEnchantmentItem(Material.STONE_SWORD, 1, 0, "§cSkyPvP §8|  §bShop", Enchantment.DAMAGE_ALL, 1) });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 45);
        }
        else
        {
            p.sendMessage(Main.getPrefix() + "§cDu hast nicht genügend Coins um dies zu kaufen!");
          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cSteinschwert §8- §b60 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 59)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c60 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createEnchantmentItem(Material.STONE_SWORD, 1, 0, "§cSkyPvP §8|  §bShop", Enchantment.DAMAGE_ALL, 2) });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 60);
        }
        else
        {
            p.sendMessage(Main.getPrefix() + "§cDu hast nicht genügend Coins um dies zu kaufen!");
          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cSteinschwert §8- §b80 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 79)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c80 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createEnchantmentItem(Material.STONE_SWORD, 1, 0, "§cSkyPvP §8|  §bShop", Enchantment.DAMAGE_ALL, 3) });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 80);
        }
        else
        {
            p.sendMessage(Main.getPrefix() + "§cDu hast nicht genügend Coins um dies zu kaufen!");
          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cSteinschwert §8- §b100 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 99)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c100 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createEnchantmentItem(Material.STONE_SWORD, 1, 0, "§cSkyPvP §8|  §bShop", Enchantment.DAMAGE_ALL, 4) });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 100);
        }
        else
        {
            p.sendMessage(Main.getPrefix() + "§cDu hast nicht genügend Coins um dies zu kaufen!");
          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cEisenschwert §8- §b50 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 49)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c50 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createItem(Material.IRON_SWORD, 1, 0, "§cSkyPvP §8|  §bShop") });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 50);
        }
        else
        {
            p.sendMessage(Main.getPrefix() + "§cDu hast nicht genügend Coins um dies zu kaufen!");
          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cEisenschwert §8- §b70 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 69)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c70 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createEnchantmentItem(Material.IRON_SWORD, 1, 0, "§cSkyPvP §8|  §bShop", Enchantment.DAMAGE_ALL, 1) });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 70);
        }
        else
        {
            p.sendMessage(Main.getPrefix() + "§cDu hast nicht genügend Coins um dies zu kaufen!");
          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cEisenschwert §8- §b90 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 89)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c90 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createEnchantmentItem(Material.IRON_SWORD, 1, 0, "§cSkyPvP §8|  §bShop", Enchantment.DAMAGE_ALL, 2) });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 90);
        }
        else
        {
            p.sendMessage(Main.getPrefix() + "§cDu hast nicht genügend Coins um dies zu kaufen!");
          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cEisenschwert §8- §b120 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 119)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c120 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createEnchantmentItem(Material.IRON_SWORD, 1, 0, "§cSkyPvP §8|  §bShop", Enchantment.DAMAGE_ALL, 3) });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 120);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§7Du hast §cnicht §7gen§gend Coins um diesen Kauf zu tätigen.");
          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cEisenschwert §8- §b150 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 149)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c150 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createEnchantmentItem(Material.IRON_SWORD, 1, 0, "§cSkyPvP §8|  §bShop", Enchantment.DAMAGE_ALL, 4) });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 150);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§7Du hast §cnicht §7gen§gend Coins um diesen Kauf zu tätigen.");
          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cDiamantschwert §8- §b80 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 79)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c80 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createItem(Material.DIAMOND_SWORD, 1, 0, "§cSkyPvP §8|  §bShop") });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 80);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§7Du hast §cnicht §7gen§gend Coins um diesen Kauf zu tätigen.");
          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cDiamantschwert §8- §b100 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 99)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c70 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createEnchantmentItem(Material.DIAMOND_SWORD, 1, 0, "§cSkyPvP §8|  §bShop", Enchantment.DAMAGE_ALL, 1) });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 100);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§7Du hast §cnicht §7gen§gend Coins um diesen Kauf zu tätigen.");
          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cDiamantschwert §8- §b130 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 129)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c70 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createEnchantmentItem(Material.DIAMOND_SWORD, 1, 0, "§cSkyPvP §8|  §bShop", Enchantment.DAMAGE_ALL, 2) });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 130);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§7Du hast §cnicht §7gen§gend Coins um diesen Kauf zu tätigen.");
          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cDiamantschwert §8- §b180 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 179)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c180 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createEnchantmentItem(Material.DIAMOND_SWORD, 1, 0, "§cSkyPvP §8|  §bShop", Enchantment.DAMAGE_ALL, 3) });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 180);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§7Du hast §cnicht §7gen§gend Coins um diesen Kauf zu tätigen.");
          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cDiamantschwert §8- §b230 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 229)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c230 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createEnchantmentItem(Material.DIAMOND_SWORD, 1, 0, "§cSkyPvP §8|  §bShop", Enchantment.DAMAGE_ALL, 4) });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 230);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§7Du hast §cnicht §7gen§gend Coins um diesen Kauf zu tätigen.");
          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aEisenhelm §8- §b20 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 19)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c20 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createItem(Material.IRON_HELMET, 1, 0, "§cSkyPvP §8|  §bShop") });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 20);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§cDu hast nicht genügend Coins um dies zu kaufen!");          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aEisenbrustplatte §8- §b60 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 59)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c60 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createItem(Material.IRON_CHESTPLATE, 1, 0, "§cSkyPvP §8|  §bShop") });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 60);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§7Du hast §cnicht §7gen§gend Coins um diesen Kauf zu tätigen.");
          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aEisenhelm §8- §b40 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 39)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c40 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createEnchantmentItem(Material.IRON_HELMET, 1, 0, "§cSkyPvP §8|  §bShop", Enchantment.PROTECTION_ENVIRONMENTAL, 1) });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 40);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§7Du hast §cnicht §7gen§gend Coins um diesen Kauf zu tätigen.");
          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aEisenbrustplatte §8- §b90 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 89)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c90 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createEnchantmentItem(Material.IRON_CHESTPLATE, 1, 0, "§cSkyPvP §8|  §bShop", Enchantment.PROTECTION_ENVIRONMENTAL, 1) });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 90);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§7Du hast §cnicht §7gen§gend Coins um diesen Kauf zu tätigen.");
          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aEisenhose §8- §b30 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 29)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c30 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createItem(Material.IRON_LEGGINGS, 1, 0, "§cSkyPvP §8|  §bShop") });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 30);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§7Du hast §cnicht §7gen§gend Coins um diesen Kauf zu tätigen.");
          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aEisenhose §8- §b60 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 59)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c60 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createEnchantmentItem(Material.IRON_LEGGINGS, 1, 0, "§cSkyPvP §8|  §bShop", Enchantment.PROTECTION_ENVIRONMENTAL, 1) });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 60);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§7Du hast §cnicht §7gen§gend Coins um diesen Kauf zu tätigen.");
          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aEisenschuhe §8- §b20 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 19)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c20 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createItem(Material.IRON_BOOTS, 1, 0, "§cSkyPvP §8|  §bShop") });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 20);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§7Du hast §cnicht §7gen§gend Coins um diesen Kauf zu tätigen.");
          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aEisenschuhe §8- §b40 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 39)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c40 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createEnchantmentItem(Material.IRON_BOOTS, 1, 0, "§cSkyPvP §8|  §bShop", Enchantment.PROTECTION_ENVIRONMENTAL, 1) });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 40);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§7Du hast §cnicht §7gen§gend Coins um diesen Kauf zu tätigen.");
          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aDiamanthelm §8- §b60 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 59)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c60 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createItem(Material.DIAMOND_HELMET, 1, 0, "§cSkyPvP §8|  §bShop") });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 60);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§7Du hast §cnicht §7gen§gend Coins um diesen Kauf zu tätigen.");
          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aDiamanthelm §8- §b100 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 99)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c100 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createEnchantmentItem(Material.DIAMOND_HELMET, 1, 0, "§cSkyPvP §8|  §bShop", Enchantment.PROTECTION_ENVIRONMENTAL, 2) });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 100);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§7Du hast §cnicht §7gen§gend Coins um diesen Kauf zu tätigen.");
          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aDiamanthelm §8- §b80 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 79)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c80 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createEnchantmentItem(Material.DIAMOND_HELMET, 1, 0, "§cSkyPvP §8|  §bShop", Enchantment.PROTECTION_ENVIRONMENTAL, 1) });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 80);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§7Du hast §cnicht §7gen§gend Coins um diesen Kauf zu tätigen.");
          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aDiamantbrustplatte §8- §b120 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 119)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c120 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createItem(Material.DIAMOND_CHESTPLATE, 1, 0, "§cSkyPvP §8|  §bShop") });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 120);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§7Du hast §cnicht §7gen§gend Coins um diesen Kauf zu tätigen.");
          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aDiamantbrustplatte §8- §b160 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 159)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c160 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createEnchantmentItem(Material.DIAMOND_CHESTPLATE, 1, 0, "§cSkyPvP §8|  §bShop", Enchantment.PROTECTION_ENVIRONMENTAL, 1) });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 160);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§7Du hast §cnicht §7gen§gend Coins um diesen Kauf zu tätigen.");
          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aDiamantbrustplatte §8- §b200 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 199)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c200 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createEnchantmentItem(Material.DIAMOND_CHESTPLATE, 1, 0, "§cSkyPvP §8|  §bShop", Enchantment.PROTECTION_ENVIRONMENTAL, 2) });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 200);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§7Du hast §cnicht §7gen§gend Coins um diesen Kauf zu tätigen.");
          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aDiamanthose §8- §b80 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 79)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c80 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createItem(Material.DIAMOND_LEGGINGS, 1, 0, "§cSkyPvP §8|  §bShop") });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 80);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§7Du hast §cnicht §7gen§gend Coins um diesen Kauf zu tätigen.");
          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aDiamanthose §8- §b110 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 109)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c110 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createEnchantmentItem(Material.DIAMOND_LEGGINGS, 1, 0, "§cSkyPvP §8|  §bShop", Enchantment.PROTECTION_ENVIRONMENTAL, 1) });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 110);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§7Du hast §cnicht §7gen§gend Coins um diesen Kauf zu tätigen.");
          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aDiamanthose §8- §b150 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 149)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c150 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createEnchantmentItem(Material.DIAMOND_LEGGINGS, 1, 0, "§cSkyPvP §8|  §bShop", Enchantment.PROTECTION_ENVIRONMENTAL, 2) });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 150);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§7Du hast §cnicht §7gen§gend Coins um diesen Kauf zu tätigen.");
          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aDiamantschuhe §8- §b60 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 59)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c60 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createItem(Material.DIAMOND_BOOTS, 1, 0, "§cSkyPvP §8|  §bShop") });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 60);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§7Du hast §cnicht §7gen§gend Coins um diesen Kauf zu tätigen.");
          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aDiamantschuhe §8- §b80 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 79)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c80 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createEnchantmentItem(Material.DIAMOND_BOOTS, 1, 0, "§cSkyPvP §8|  §bShop", Enchantment.PROTECTION_ENVIRONMENTAL, 1) });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 80);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§7Du hast §cnicht §7gen§gend Coins um diesen Kauf zu tätigen.");
          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aDiamantschuhe §8- §b100 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 99)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c100 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createEnchantmentItem(Material.DIAMOND_BOOTS, 1, 0, "§cSkyPvP §8|  §bShop", Enchantment.PROTECTION_ENVIRONMENTAL, 2) });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 100);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§7Du hast §cnicht §7gen§gend Coins um diesen Kauf zu tätigen.");
          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eHolz §8- §b32 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 31)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c32 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createItem(Material.WOOD, 8, 0, "§cSkyPvP §8|  §bShop") });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 32);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§cDu hast nicht genügend Coins um dies zu kaufen!");      
		  p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eHolz §8- §b64 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 63)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c64 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createItem(Material.WOOD, 16, 0, "§cSkyPvP §8|  §bShop") });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 64);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§cDu hast nicht genügend Coins um dies zu kaufen!");        
		  p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eHolz §8- §b128 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 127)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c128 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createItem(Material.WOOD, 32, 0, "§cSkyPvP §8|  §bShop") });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 128);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§cDu hast nicht genügend Coins um dies zu kaufen!");    
		  p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eHolz §8- §b256 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 255)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c256 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createItem(Material.WOOD, 64, 0, "§cSkyPvP §8|  §bShop") });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 256);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§cDu hast nicht genügend Coins um dies zu kaufen!");      
		  p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eStein §8- §b32 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 31)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c32 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createItem(Material.STONE, 8, 0, "§cSkyPvP §8|  §bShop") });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 32);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§cDu hast nicht genügend Coins um dies zu kaufen!");       
		  p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eStein §8- §b64 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 63)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c64 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createItem(Material.STONE, 16, 0, "§cSkyPvP §8|  §bShop") });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 64);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§cDu hast nicht genügend Coins um dies zu kaufen!");        
		  p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eStein §8- §b128 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 127)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c128 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createItem(Material.STONE, 32, 0, "§cSkyPvP §8|  §bShop") });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 128);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§cDu hast nicht genügend Coins um dies zu kaufen!");        
		  p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eStein §8- §b256 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 255)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c256 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createItem(Material.STONE, 64, 0, "§cSkyPvP §8|  §bShop") });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 256);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§cDu hast nicht genügend Coins um dies zu kaufen!");          
		  p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eCobblestone §8- §b32 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 31)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c32 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createItem(Material.COBBLESTONE, 8, 0, "§cSkyPvP §8|  §bShop") });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 32);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§cDu hast nicht genügend Coins um dies zu kaufen!");       
		  p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eCobblestone §8- §b64 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 63)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c64 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createItem(Material.COBBLESTONE, 16, 0, "§cSkyPvP §8|  §bShop") });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 64);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§cDu hast nicht genügend Coins um dies zu kaufen!");      
		  p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eCobblestone §8- §b128 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 127)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c128 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createItem(Material.COBBLESTONE, 32, 0, "§cSkyPvP §8|  §bShop") });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 128);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§cDu hast nicht genügend Coins um dies zu kaufen!");      
		  p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eCobblestone §8- §b256 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 255)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c256 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createItem(Material.COBBLESTONE, 64, 0, "§cSkyPvP §8|  §bShop") });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 256);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§cDu hast nicht genügend Coins um dies zu kaufen!");      
		  p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eQuarz §8- §b64 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 63)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c64 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createItem(Material.QUARTZ_BLOCK, 8, 0, "§cSkyPvP §8|  §bShop") });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 64);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§cDu hast nicht genügend Coins um dies zu kaufen!");      
		  p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eQuarz §8- §b128 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 127)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c128 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createItem(Material.QUARTZ_BLOCK, 16, 0, "§cSkyPvP §8|  §bShop") });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 128);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§cDu hast nicht genügend Coins um dies zu kaufen!");      
		  p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eQuarz §8- §b256 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 255)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c256 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createItem(Material.QUARTZ_BLOCK, 32, 0, "§cSkyPvP §8|  §bShop") });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 256);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§cDu hast nicht genügend Coins um dies zu kaufen!");      
		  p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eQuarz §8- §b512 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 511)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c512 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createItem(Material.QUARTZ_BLOCK, 64, 0, "§cSkyPvP §8|  §bShop") });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 512);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§cDu hast nicht genügend Coins um dies zu kaufen!");       
		  p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eGras §8- §b64 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 63)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c64 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createItem(Material.GRASS, 8, 0, "§cSkyPvP §8|  §bShop") });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 64);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§cDu hast nicht genügend Coins um dies zu kaufen!");      
		  p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eGras §8- §b128 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 127)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c128 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createItem(Material.GRASS, 16, 0, "§cSkyPvP §8|  §bShop") });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 128);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§7Du hast §cnicht §7gen§gend Coins um diesen Kauf zu tätigen.");
          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eGras §8- §b256 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 255)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c256 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createItem(Material.GRASS, 32, 0, "§cSkyPvP §8|  §bShop") });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 256);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§cDu hast nicht genügend Coins um dies zu kaufen!");     
		  p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eGras §8- §b512 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 511)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c512 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createItem(Material.GRASS, 64, 0, "§cSkyPvP §8|  §bShop") });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 512);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§cDu hast nicht genügend Coins um dies zu kaufen!"); 
		  p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Eichensetzling §8- §b64 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 63)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c64 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createItem(Material.SAPLING, 16, 0, "§cSkyPvP §8|  §bShop") });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 64);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§7Du hast §cnicht §7gen§gend Coins um diesen Kauf zu tätigen.");
          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Eichensetzling §8- §b64 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 63)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c64 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createItem(Material.SAPLING, 16, 0, "§cSkyPvP §8|  §bShop") });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 64);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§7Du hast §cnicht §7gen§gend Coins um diesen Kauf zu tätigen.");
          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Fichtensetzling §8- §b64 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 63)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c64 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createItem(Material.SAPLING, 16, 1, "§cSkyPvP §8|  §bShop") });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 64);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§cDu hast nicht genügend Coins um dies zu kaufen!");   
		  p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Birkensetzling §8- §b64 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 63)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c64 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createItem(Material.SAPLING, 16, 2, "§cSkyPvP §8|  §bShop") });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 64);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§7Du hast §cnicht §7gen§gend Coins um diesen Kauf zu tätigen.");
          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Akaziensetzling §8- §b64 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 63)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c64 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createItem(Material.SAPLING, 16, 4, "§cSkyPvP §8|  §bShop") });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 64);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§cDu hast nicht genügend Coins um dies zu kaufen!");      
		  p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Samen §8- §b64 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 63)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c64 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createItem(Material.SEEDS, 16, 0, "§cSkyPvP §8|  §bShop") });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 64);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§cDu hast nicht genügend Coins um dies zu kaufen!");   
		  p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Melonenkerne §8- §b64 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 63)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c64 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createItem(Material.MELON_SEEDS, 16, 0, "§cSkyPvP §8|  §bShop") });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 64);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§cDu hast nicht genügend Coins um dies zu kaufen!");      
		  p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3K§rbiskerne §8- §b64 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 63)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c64 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createItem(Material.PUMPKIN_SEEDS, 16, 0, "§cSkyPvP §8|  §bShop") });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 64);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§cDu hast nicht genügend Coins um dies zu kaufen!");       
		  p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Zuckerrohr §8- §b64 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 63)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c64 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createItem(Material.SUGAR_CANE, 16, 0, "§cSkyPvP §8|  §bShop") });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 64);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§cDu hast nicht genügend Coins um dies zu kaufen!");       
		  p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Zaubertisch §8- §b256 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 255)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c256 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createItem(Material.ENCHANTMENT_TABLE, 1, 4, "§cSkyPvP §8|  §bShop") });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 256);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§cDu hast nicht genügend Coins um dies zu kaufen!");         
		  p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Werkbank §8- §b32 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 31)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c32 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createItem(Material.WORKBENCH, 16, 45, "§cSkyPvP §8|  §bShop") });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 32);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§cDu hast nicht genügend Coins um dies zu kaufen!");        
		  p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Bücherregal §8- §b128 Coins"))
      {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 127)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c128 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createItem(Material.BOOKSHELF, 4, 0, "§cSkyPvP §8|  §bShop") });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 128);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§cDu hast nicht genügend Coins um dies zu kaufen!");        
		  p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Amboss §8- §b128 Coins")) {
        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 127)
        {
          p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
          p.sendMessage(Main.getPrefix() + "§aDir wurden §c128 §eCoins abgezogen!");
          p.getInventory().addItem(new ItemStack[] { Items.createItem(Material.ANVIL, 1, 0, "§cSkyPvP §8|  §bShop") });
          p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
          CoinsAPI.removeCoins(p.getUniqueId().toString(), 128);
        }
        else
        {
          p.sendMessage(Main.getPrefix() + "§cDu hast nicht genügend Coins um dies zu kaufen!");        
		  p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }
      }
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§9Enderperle §8- §b356 Coins")) {
          if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 355)
          {
            p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
            p.sendMessage(Main.getPrefix() + "§aDir wurden §c356 §eCoins abgezogen!");
            p.getInventory().addItem(new ItemStack[] { Items.createItem(Material.ENDER_PEARL, 16, 0, "§cSkyPvP §8|  §bShop") });
            p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
            CoinsAPI.removeCoins(p.getUniqueId().toString(), 356);
          }
          else
          {
            p.sendMessage(Main.getPrefix() + "§cDu hast nicht genügend Coins um dies zu kaufen!");      
			p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
          }
      }
      
      else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eBogen §8- §b128 Coins")) {
          if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 127)
          {
            p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
            p.sendMessage(Main.getPrefix() + "§aDir wurden §c127 §eCoins abgezogen!");
            p.getInventory().addItem(new ItemStack[] { Items.createItem(Material.BOW, 1, 0, "§cSkyPvP §8|  §bShop") });
            p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
            CoinsAPI.removeCoins(p.getUniqueId().toString(), 127);
            
          }
          else
          {
            p.sendMessage(Main.getPrefix() + "§cDu hast nicht genügend Coins um dies zu kaufen!");        
            p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
          }
      
      }       else if (e1.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Pfeile §8- §b16 Coins")) {
          if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 15)
          {
            p.sendMessage(Main.getPrefix() + "§aDein Kauf wurde §eerfolgreich §aabgeschlossen!");
            p.sendMessage(Main.getPrefix() + "§aDir wurden §c16 §eCoins abgezogen!");
            p.getInventory().addItem(new ItemStack[] { Items.createItem(Material.ARROW, 16, 0, "§cSkyPvP §8|  §bShop") });
            p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
            CoinsAPI.removeCoins(p.getUniqueId().toString(), 15);
            
          }
          else
          {
            p.sendMessage(Main.getPrefix() + "§cDu hast nicht genügend Coins um dies zu kaufen!");       
			p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
          }
    }
  }
  }
}
