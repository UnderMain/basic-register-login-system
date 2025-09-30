package de.undermain.shop.commands;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import de.undermain.shop.util.ItemBuilder;
import de.undermain.shop.util.files;
import de.undermain.shop.util.methoden;



public class item implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		String Prefix = files.getObject_config.get("Prefix").toString().replaceAll("&", "§");
		String perm = files.getObject_config.get("NoPerm").toString().replaceAll("&", "§");
		String toomuch = files.getObject_config.get("TooMuchArgs").toString().replaceAll("&", "§");
		Player p = (Player) sender;
		ItemBuilder is = new ItemBuilder(p.getItemInHand());

		if(p.hasPermission("ufc.item")) {
			
			if(args.length == 0) {
				p.sendMessage(Prefix + "§7§m---------------------------");
				p.sendMessage(Prefix + "");
				p.sendMessage(Prefix + "§6§lItem-Meta:");
				p.sendMessage(Prefix + "");
				p.sendMessage(Prefix + "§7» /item name <name>");
				p.sendMessage(Prefix + "§7» /item enchant <enchantment> <level>");
				p.sendMessage(Prefix + "§7» /item infdurability");
				p.sendMessage(Prefix + "");
				p.sendMessage(Prefix + "");
				p.sendMessage(Prefix + "§7§m---------------------------");
				p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
			}else if (args[0].equalsIgnoreCase("name")) {
				ItemStack inHand = p.getItemInHand();
				if(inHand.getType() == Material.AIR) {
					p.sendMessage(Prefix + "§cBitte halte ein Item in der Hand");
					p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);

				}else {
					StringBuilder builder = new StringBuilder();
					for(int i = 1; i < args.length; i++) {
						if (i == args.length) {
							builder.append(args[i]);
						}else {
							builder.append(args[i] + " ");
						}
					}
					if(args.length >=  2) {
						String name = builder.toString().replaceAll("&", "§");
						is.setName(name);
						p.sendMessage(Prefix + "§7§m---------------------------");
						p.sendMessage(Prefix + "");
						p.sendMessage(Prefix + "");
						p.sendMessage(Prefix + "§7» Dein Item heißt nun: §a" + name);
						p.sendMessage(Prefix + "");
						p.sendMessage(Prefix + "");
						p.sendMessage(Prefix + "§7§m---------------------------");
						p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);

					}else {
						p.sendMessage(Prefix + "§7§m---------------------------");
						p.sendMessage(Prefix + "");
						p.sendMessage(Prefix + "§7» §cUngültiger Name!");
						p.sendMessage(Prefix + "");
						p.sendMessage(Prefix + "§7§m---------------------------");
						p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);

					}
					
				}
			}else if(args[0].equalsIgnoreCase("enchant")) {
				
				ItemStack inHand = p.getItemInHand();
				if(inHand.getType() == Material.AIR) {
					p.sendMessage(Prefix + "§cBitte halte ein Item in der Hand");
					p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);

				}else if(args.length>0){
					p.sendMessage(Prefix + "§7§m---------------------------");
					p.sendMessage(Prefix + "§6§lVerfügbare Enchantments:");
					p.sendMessage(Prefix + "");
					p.sendMessage(Prefix + "§7» ARROW_DAMAGE, ARROW_FIRE, ARROW_INFINITE, ARROW_KNOCKBACK, DAMAGE_ALL");
					p.sendMessage(Prefix + "§7» DAMAGE_ARTHROPODS, DAMAGE_UNDEAD, DEPTH_STRIDER, DIG_SPEED, DURABILITY");
					p.sendMessage(Prefix + "§7» FIRE_ASPECT, KNOCKBACK, LOOT_BONUS_BLOCKS, LOOT_BONUS_MOBS, LUCK, LURE");
					p.sendMessage(Prefix + "§7» OXYGEN, PROTECTION_ENVIRONMENTAL, PROTECTION_EXPLOSIONS, PROTECTION_FALL");
					p.sendMessage(Prefix + "§7» PROTECTION_FIRE. PROTECTION_PROJECTILE, SILK_TOUCH, THORNS, WATER_WORKER");
					p.sendMessage(Prefix + "");
					p.sendMessage(Prefix + "§7§m---------------------------");
					p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);

					if(args.length > 1) {
						

						if(args.length  < 2) {
							
							p.sendMessage("Bitte Level eintragen");
							p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);

						}else if (args.length > 2){
							if(args[1].equalsIgnoreCase("ARROW_DAMAGE")) {
								is.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, Integer.parseInt(args[2]));
								methoden.chats(p, Prefix, args[1], args[2]);
							}else if(args[1].equalsIgnoreCase("ARROW_FIRE")) {
								is.addUnsafeEnchantment(Enchantment.ARROW_FIRE, Integer.parseInt(args[2]));
								methoden.chats(p, Prefix, args[1], args[2]);
							}else if(args[1].equalsIgnoreCase("ARROW_INFINITE")) {
								is.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, Integer.parseInt(args[2]));
								methoden.chats(p, Prefix, args[1], args[2]);
							}else if(args[1].equalsIgnoreCase("ARROW_KNOCKBACK")) {
								is.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, Integer.parseInt(args[2]));
								methoden.chats(p, Prefix, args[1], args[2]);
							}else if(args[1].equalsIgnoreCase("DAMAGE_ALL")) {
								is.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, Integer.parseInt(args[2]));
								methoden.chats(p, Prefix, args[1], args[2]);
							}else if(args[1].equalsIgnoreCase("DAMAGE_ARTHROPODS")) {
								is.addUnsafeEnchantment(Enchantment.DAMAGE_ARTHROPODS, Integer.parseInt(args[2]));
								methoden.chats(p, Prefix, args[1], args[2]);
							}else if(args[1].equalsIgnoreCase("DAMAGE_UNDEAD")) {
								is.addUnsafeEnchantment(Enchantment.DAMAGE_UNDEAD, Integer.parseInt(args[2]));
								methoden.chats(p, Prefix, args[1], args[2]);
							}else if(args[1].equalsIgnoreCase("DEPTH_STRIDER")) {
								is.addUnsafeEnchantment(Enchantment.DEPTH_STRIDER, Integer.parseInt(args[2]));
								methoden.chats(p, Prefix, args[1], args[2]);
							}else if(args[1].equalsIgnoreCase("DIG_SPEED")) {
								is.addUnsafeEnchantment(Enchantment.DIG_SPEED, Integer.parseInt(args[2]));
								methoden.chats(p, Prefix, args[1], args[2]);
							}else if(args[1].equalsIgnoreCase("DURABILITY")) {
								is.addUnsafeEnchantment(Enchantment.DURABILITY, Integer.parseInt(args[2]));
								methoden.chats(p, Prefix, args[1], args[2]);
							}else if(args[1].equalsIgnoreCase("FIRE_ASPECT")) {
								is.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, Integer.parseInt(args[2]));
								methoden.chats(p, Prefix, args[1], args[2]);
							}else if(args[1].equalsIgnoreCase("KNOCKBACK")) {
								is.addUnsafeEnchantment(Enchantment.KNOCKBACK, Integer.parseInt(args[2]));
								methoden.chats(p, Prefix, args[1], args[2]);
							}else if(args[1].equalsIgnoreCase("LOOT_BONUS_BLOCKS")) {
								is.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, Integer.parseInt(args[2]));
								methoden.chats(p, Prefix, args[1], args[2]);
							}else if(args[1].equalsIgnoreCase("LOOT_BONUS_MOBS")) {
								is.addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, Integer.parseInt(args[2]));
								methoden.chats(p, Prefix, args[1], args[2]);
							}else if(args[1].equalsIgnoreCase("LUCK")) {
								is.addUnsafeEnchantment(Enchantment.LUCK, Integer.parseInt(args[2]));
								methoden.chats(p, Prefix, args[1], args[2]);
							}else if(args[1].equalsIgnoreCase("LURE")) {
								is.addUnsafeEnchantment(Enchantment.LURE, Integer.parseInt(args[2]));
								methoden.chats(p, Prefix, args[1], args[2]);
							}else if(args[1].equalsIgnoreCase("OXYGEN")) {
								is.addUnsafeEnchantment(Enchantment.OXYGEN, Integer.parseInt(args[2]));
								methoden.chats(p, Prefix, args[1], args[2]);
							}else if(args[1].equalsIgnoreCase("PROTECTION_ENVIRONMENTAL")) {
								is.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, Integer.parseInt(args[2]));
								methoden.chats(p, Prefix, args[1], args[2]);
							}else if(args[1].equalsIgnoreCase("PROTECTION_EXPLOSIONS")) {
								is.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, Integer.parseInt(args[2]));
								methoden.chats(p, Prefix, args[1], args[2]);
							}else if(args[1].equalsIgnoreCase("PROTECTION_FALL")) {
								is.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, Integer.parseInt(args[2]));
								methoden.chats(p, Prefix, args[1], args[2]);
							}else if(args[1].equalsIgnoreCase("PROTECTION_FIRE")) {
								is.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, Integer.parseInt(args[2]));
								methoden.chats(p, Prefix, args[1], args[2]);
							}else if(args[1].equalsIgnoreCase("PROTECTION_PROJECTILE")) {
								is.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, Integer.parseInt(args[2]));
								methoden.chats(p, Prefix, args[1], args[2]);
							}else if(args[1].equalsIgnoreCase("SILK_TOUCH")) {
								is.addUnsafeEnchantment(Enchantment.SILK_TOUCH, Integer.parseInt(args[2]));
								methoden.chats(p, Prefix, args[1], args[2]);
							}else if(args[1].equalsIgnoreCase("THORNS")) {
								is.addUnsafeEnchantment(Enchantment.THORNS, Integer.parseInt(args[2]));
								methoden.chats(p, Prefix, args[1], args[2]);
							}else if(args[1].equalsIgnoreCase("WATER_WORKER")) {
								is.addUnsafeEnchantment(Enchantment.WATER_WORKER, Integer.parseInt(args[2]));
								methoden.chats(p, Prefix, args[1], args[2]);
							
							}else {
								p.sendMessage(Prefix + "§7§m---------------------------");
							p.sendMessage(Prefix + "");
							p.sendMessage(Prefix + "§7» §cUngültige Verzauberung!");
							p.sendMessage(Prefix + "");
							p.sendMessage(Prefix + "§7§m---------------------------");
							p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);

						}
						}
			     }
			}
			}else if(args[0].equalsIgnoreCase("infdurability")) {
				
				methoden.chat(p);
				p.sendMessage(Prefix + "§7§m---------------------------");
				p.sendMessage(Prefix + "");
				p.sendMessage(Prefix + "");
				p.sendMessage(Prefix + "§7» Dein Item hat unendliche Haltbarkeit!");
				p.sendMessage(Prefix + "");
				p.sendMessage(Prefix + "");
				p.sendMessage(Prefix + "§7§m---------------------------");
				is.setInfinityDurability();
				p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);

				
			}else {
				p.sendMessage(Prefix + toomuch);
				p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);

			}
			
		
	}else {
		p.sendMessage(Prefix + perm);
		p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);

	}
		return false;
	}
}

