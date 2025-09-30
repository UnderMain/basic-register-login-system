package cloud.evaped.citybuild.commands;

import cloud.evaped.citybuild.main.CityBuildCore;
import cloud.evaped.citybuild.main.CityBuildPlugin;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EditItemCommand implements org.bukkit.command.CommandExecutor
{
  public EditItemCommand() {}
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if ((sender instanceof Player)) {
      Player p = (Player)sender;
      if (p.hasPermission("citybuild.edititems")) {
        if (CityBuildCore.getPlayerInEditMode.contains(p)) {
          if (p.getItemInHand() != null) {
            if (args.length >= 1) {
              ItemStack item = p.getItemInHand();
              ItemMeta itemm = item.getItemMeta();
              if (args[0].equalsIgnoreCase("enchant")) {
                if (args.length == 3) {
                  if (args[1].equalsIgnoreCase("ARROW_DAMAGE")) {
                    itemm.addEnchant(Enchantment.ARROW_DAMAGE, Integer.valueOf(args[2]).intValue(), true);
                    p.sendMessage(CityBuildCore.instance.translateString("This Item has now this Enchant§8: &6ARROW_DAMAGE " + args[2] + "&7.")
                      .replaceAll("&", "§"));
                    item.setItemMeta(itemm);
                  } else if (args[1].equalsIgnoreCase("ARROW_FIRE")) {
                    itemm.addEnchant(Enchantment.ARROW_FIRE, Integer.valueOf(args[2]).intValue(), true);
                    p.sendMessage(CityBuildCore.instance.translateString("This Item has now this Enchant§8: &6ARROW_FIRE " + args[2] + "&7.")
                      .replaceAll("&", "§"));
                    item.setItemMeta(itemm);
                  } else if (args[1].equalsIgnoreCase("ARROW_INFINITE")) {
                    itemm.addEnchant(Enchantment.ARROW_INFINITE, Integer.valueOf(args[2]).intValue(), true);
                    p.sendMessage(CityBuildCore.instance
                      .translateString("This Item has now this Enchant§8: &6ARROW_INFINITE " + args[2] + "&7.")
                      .replaceAll("&", "§"));
                    item.setItemMeta(itemm);
                  } else if (args[1].equalsIgnoreCase("ARROW_KNOCKBACK")) {
                    itemm.addEnchant(Enchantment.ARROW_KNOCKBACK, Integer.valueOf(args[2]).intValue(), true);
                    p.sendMessage(CityBuildCore.instance
                      .translateString("This Item has now this Enchant§8: &6ARROW_KNOCKBACK " + args[2] + "&7.")
                      .replaceAll("&", "§"));
                    item.setItemMeta(itemm);
                  } else if (args[1].equalsIgnoreCase("DAMAGE_ALL")) {
                    itemm.addEnchant(Enchantment.DAMAGE_ALL, Integer.valueOf(args[2]).intValue(), true);
                    p.sendMessage(CityBuildCore.instance.translateString("This Item has now this Enchant§8: &6DAMAGE_ALL " + args[2] + "&7.")
                      .replaceAll("&", "§"));
                    item.setItemMeta(itemm);
                  } else if (args[1].equalsIgnoreCase("DEPTH_STRIDER")) {
                    itemm.addEnchant(Enchantment.DEPTH_STRIDER, Integer.valueOf(args[2]).intValue(), true);
                    p.sendMessage(CityBuildCore.instance
                      .translateString("This Item has now this Enchant§8: &6DEPTH_STRIDER " + args[2] + "&7.")
                      .replaceAll("&", "§"));
                    item.setItemMeta(itemm);
                  } else if (args[1].equalsIgnoreCase("DIG_SPEED")) {
                    itemm.addEnchant(Enchantment.DIG_SPEED, Integer.valueOf(args[2]).intValue(), true);
                    p.sendMessage(CityBuildCore.instance.translateString("This Item has now this Enchant§8: &6DIG_SPEED " + args[2] + "&7.")
                      .replaceAll("&", "§"));
                    item.setItemMeta(itemm);
                  } else if (args[1].equalsIgnoreCase("DURABILITY")) {
                    itemm.addEnchant(Enchantment.DURABILITY, Integer.valueOf(args[2]).intValue(), true);
                    p.sendMessage(CityBuildCore.instance.translateString("This Item has now this Enchant§8: &6DURABILITY " + args[2] + "&7.")
                      .replaceAll("&", "§"));
                    item.setItemMeta(itemm);
                  } else if (args[1].equalsIgnoreCase("FIRE_ASPECT")) {
                    itemm.addEnchant(Enchantment.FIRE_ASPECT, Integer.valueOf(args[2]).intValue(), true);
                    p.sendMessage(CityBuildCore.instance.translateString("This Item has now this Enchant§8: &6FIRE_ASPECT " + args[2] + "&7.")
                      .replaceAll("&", "§"));
                    item.setItemMeta(itemm);
                  } else if (args[1].equalsIgnoreCase("KNOCKBACK")) {
                    itemm.addEnchant(Enchantment.KNOCKBACK, Integer.valueOf(args[2]).intValue(), true);
                    p.sendMessage(CityBuildCore.instance.translateString("This Item has now this Enchant§8: &6KNOCKBACK " + args[2] + "&7.")
                      .replaceAll("&", "§"));
                    item.setItemMeta(itemm);
                  } else if (args[1].equalsIgnoreCase("LUCK")) {
                    itemm.addEnchant(Enchantment.LUCK, Integer.valueOf(args[2]).intValue(), true);
                    p.sendMessage(CityBuildCore.instance.translateString("This Item has now this Enchant§8: &6LUCK " + args[2] + "&7.")
                      .replaceAll("&", "§"));
                    item.setItemMeta(itemm);
                  } else if (args[1].equalsIgnoreCase("LURE")) {
                    itemm.addEnchant(Enchantment.LURE, Integer.valueOf(args[2]).intValue(), true);
                    p.sendMessage(CityBuildCore.instance.translateString("This Item has now this Enchant§8: &6LURE " + args[2] + "&7.")
                      .replaceAll("&", "§"));
                    item.setItemMeta(itemm);
                  } else if (args[1].equalsIgnoreCase("OXYGEN")) {
                    itemm.addEnchant(Enchantment.OXYGEN, Integer.valueOf(args[2]).intValue(), true);
                    p.sendMessage(CityBuildCore.instance.translateString("This Item has now this Enchant§8: &6OXYGEN " + args[2] + "&7.")
                      .replaceAll("&", "§"));
                    item.setItemMeta(itemm);
                  } else if (args[1].equalsIgnoreCase("PROTECTION_ENVIRONMENTAL")) {
                    itemm.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, Integer.valueOf(args[2]).intValue(), true);
                    
                    p.sendMessage(CityBuildCore.instance.translateString("This Item has now this Enchant§8: &6PROTECTION_ENVIRONMENTAL " + args[2] + "&7.")
                    
                      .replaceAll("&", "§"));
                    item.setItemMeta(itemm);
                  } else if (args[1].equalsIgnoreCase("PROTECTION_EXPLOSIONS")) {
                    itemm.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, Integer.valueOf(args[2]).intValue(), true);
                    
                    p.sendMessage(CityBuildCore.instance.translateString("This Item has now this Enchant§8: &6PROTECTION_EXPLOSIONS " + args[2] + "&7.")
                    
                      .replaceAll("&", "§"));
                    item.setItemMeta(itemm);
                  } else if (args[1].equalsIgnoreCase("PROTECTION_FALL")) {
                    itemm.addEnchant(Enchantment.PROTECTION_FALL, Integer.valueOf(args[2]).intValue(), true);
                    p.sendMessage(CityBuildCore.instance
                      .translateString("This Item has now this Enchant§8: &6PROTECTION_FALL " + args[2] + "&7.")
                      .replaceAll("&", "§"));
                    item.setItemMeta(itemm);
                  } else if (args[1].equalsIgnoreCase("PROTECTION_FIRE")) {
                    itemm.addEnchant(Enchantment.PROTECTION_FIRE, Integer.valueOf(args[2]).intValue(), true);
                    p.sendMessage(CityBuildCore.instance
                      .translateString("This Item has now this Enchant§8: &6PROTECTION_FIRE " + args[2] + "&7.")
                      .replaceAll("&", "§"));
                    item.setItemMeta(itemm);
                  } else if (args[1].equalsIgnoreCase("PROTECTION_PROJECTILE")) {
                    itemm.addEnchant(Enchantment.PROTECTION_PROJECTILE, Integer.valueOf(args[2]).intValue(), true);
                    
                    p.sendMessage(CityBuildCore.instance.translateString("This Item has now this Enchant§8: &6PROTECTION_PROJECTILE " + args[2] + "&7.")
                    
                      .replaceAll("&", "§"));
                    item.setItemMeta(itemm);
                  } else if (args[1].equalsIgnoreCase("SILK_TOUCH")) {
                    itemm.addEnchant(Enchantment.SILK_TOUCH, Integer.valueOf(args[2]).intValue(), true);
                    p.sendMessage(CityBuildCore.instance.translateString("This Item has now this Enchant§8: &6SILK_TOUCH " + args[2] + "&7.")
                      .replaceAll("&", "§"));
                    item.setItemMeta(itemm);
                  } else if (args[1].equalsIgnoreCase("THORNS")) {
                    itemm.addEnchant(Enchantment.THORNS, Integer.valueOf(args[2]).intValue(), true);
                    p.sendMessage(CityBuildCore.instance.translateString("This Item has now this Enchant§8: &6THORNS " + args[2] + "&7.")
                      .replaceAll("&", "§"));
                    item.setItemMeta(itemm);
                  } else if (args[1].equalsIgnoreCase("WATER_WORKER")) {
                    itemm.addEnchant(Enchantment.WATER_WORKER, Integer.valueOf(args[2]).intValue(), true);
                    p.sendMessage(CityBuildCore.instance.translateString("This Item has now this Enchant§8: &6WATER_WORKER " + args[2] + "&7.")
                      .replaceAll("&", "§"));
                    item.setItemMeta(itemm);
                  } else {
                    p.sendMessage(CityBuildCore.instance.translateString("Item Edit Commands:"));
                    
                    p.sendMessage(CityBuildCore.instance.translateString("§b/edititem rename <displayname> - rename your item"));
                    
                    p.sendMessage(CityBuildCore.instance.translateString("§b/edititem enchant <Enchantment> <level> - enchant your item"));
                    
                    p.sendMessage(CityBuildCore.instance.translateString("There are now these Enchants:"));
                    
                    p.sendMessage(CityBuildCore.instance.translateString("§fARROW_DAMAGE, ARROW_FIRE, ARROW_INFINITE, ARROW_KNOCKBACK, DAMAGE_ALL, DEPTH_STRIDER, DIG_SPEED, DURABILITY, FIRE_ASPECT, KNOCKBACK, LUCK, OXYGEN, PROTECTION_ENVIRONMENTAL, PROTECTION_EXPLOSIONS, PROTECTION_FALL, PROTECTION_FIRE, PROTECTION_FIRE,PROTECTION_PROJECTILE, SILK_TOUCH, THORNS, WATER_WORKER"));
                  }
                }
                else
                {
                  p.sendMessage(CityBuildCore.instance.translateString("Item Edit Commands:"));
                  
                  p.sendMessage(CityBuildCore.instance.translateString("§b/edititem rename <displayname> - rename your item"));
                  
                  p.sendMessage(CityBuildCore.instance.translateString("§b/edititem enchant <Enchantment> <level> - enchant your item"));
                  
                  p.sendMessage(CityBuildCore.instance.translateString("There are now these Enchants:"));
                  
                  p.sendMessage(CityBuildCore.instance.translateString("§fARROW_DAMAGE, ARROW_FIRE, ARROW_INFINITE, ARROW_KNOCKBACK, DAMAGE_ALL, DEPTH_STRIDER, DIG_SPEED, DURABILITY, FIRE_ASPECT, KNOCKBACK, LUCK, OXYGEN, PROTECTION_ENVIRONMENTAL, PROTECTION_EXPLOSIONS, PROTECTION_FALL, PROTECTION_FIRE, PROTECTION_FIRE,PROTECTION_PROJECTILE, SILK_TOUCH, THORNS, WATER_WORKER"));
                }
                
              }
              else if (args[0].equalsIgnoreCase("rename")) {
                String m = "";
                for (int i = 1; i < args.length; i++) {
                  if (i == 1) {
                    m = m + args[i];
                  } else {
                    m = " " + m + args[i];
                  }
                }
                
                itemm.setDisplayName(org.bukkit.ChatColor.translateAlternateColorCodes('&', m));
                item.setItemMeta(itemm);
              }
              else {
                p.sendMessage(CityBuildCore.instance.translateString("Item Edit Commands:"));
                
                p.sendMessage(CityBuildCore.instance.translateString("§b/edititem rename <displayname> - rename your item"));
                
                p.sendMessage(CityBuildCore.instance.translateString("§b/edititem enchant <Enchantment> <level> - enchant your item"));
                
                p.sendMessage(CityBuildCore.instance.translateString("There are now these Enchants:"));
                
                p.sendMessage(CityBuildCore.instance.translateString("§fARROW_DAMAGE, ARROW_FIRE, ARROW_INFINITE, ARROW_KNOCKBACK, DAMAGE_ALL, DEPTH_STRIDER, DIG_SPEED, DURABILITY, FIRE_ASPECT, KNOCKBACK, LUCK, OXYGEN, PROTECTION_ENVIRONMENTAL, PROTECTION_EXPLOSIONS, PROTECTION_FALL, PROTECTION_FIRE, PROTECTION_FIRE,PROTECTION_PROJECTILE, SILK_TOUCH, THORNS, WATER_WORKER"));
              }
            }
            else
            {
              p.sendMessage(CityBuildCore.instance.translateString("Item Edit Commands:"));
              
              p.sendMessage(CityBuildCore.instance.translateString("§b/edititem rename <displayname> - rename your item"));
              
              p.sendMessage(CityBuildCore.instance.translateString("§b/edititem enchant <Enchantment> <level> - enchant your item"));
              
              p.sendMessage(CityBuildCore.instance.translateString("There are now these Enchants:"));
              
              p.sendMessage(CityBuildCore.instance.translateString("§fARROW_DAMAGE, ARROW_FIRE, ARROW_INFINITE, ARROW_KNOCKBACK, DAMAGE_ALL, DEPTH_STRIDER, DIG_SPEED, DURABILITY, FIRE_ASPECT, KNOCKBACK, LUCK, OXYGEN, PROTECTION_ENVIRONMENTAL, PROTECTION_EXPLOSIONS, PROTECTION_FALL, PROTECTION_FIRE, PROTECTION_FIRE,PROTECTION_PROJECTILE, SILK_TOUCH, THORNS, WATER_WORKER"));
            }
            

          }
          else {
            p.sendMessage(CityBuildCore.instance.translateString("You must hold an Item in your Hand!"));
          }
        }
        else {
          p.sendMessage(CityBuildCore.instance.translateString("You must be in edit-mode to use this feature (§c/edit§7)."));
          
          p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
        }
      } else {
        p.sendMessage(CityBuildCore.instance.translateString(CityBuildPlugin.instance.getConfig().getString("messages.noPerm")));
        p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
      }
    } else {
      sender.sendMessage("You must be a Player, to use this Command!");
    }
    
    return false;
  }
}
