package de.sciencecode.cbsystem.commands;

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

public class Rename implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
			Player p = (Player)sender;
			if (p.hasPermission("cbsystem.rename")) {
				if (args.length >= 1) {
					if ((p.getItemInHand() == null) || (p.getItemInHand().getType().equals(Material.AIR))) {
						p.sendMessage(Main.getPrefix() + "§cDu musst ein Item in der Hand halten!");
						p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5.0F, 5.0F);
					} else {
						String name = args[0];
						for (int i = 1; i < args.length; i++) {
							name = name + " " + args[i];
						}
						ItemStack item = p.getItemInHand();
						ItemMeta itemStackMeta = item.getItemMeta();
						itemStackMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
						item.setItemMeta(itemStackMeta);
						p.sendMessage(Main.getPrefix() + "§aDein Item heißt nun: §e" + ChatColor.translateAlternateColorCodes('&', name));
						p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0F, 5.0F);
					}
				} else {
					p.sendMessage(Main.getPrefix() + "§cSyntax: /rename <Name>");
					p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5.0F, 5.0F);
				}
			} else {
				p.sendMessage(Main.getPrefix() + "§cDazu hast du keine Rechte!");
				p.playSound(p.getLocation(), Sound.ANVIL_LAND, 5.0F, 5.0F);
			}
		return false;
	}
}
