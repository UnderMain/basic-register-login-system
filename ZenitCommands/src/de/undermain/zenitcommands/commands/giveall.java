package de.undermain.zenitcommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import de.undermain.zenitcommands.main.Main;

public class giveall implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		
		if(!(sender instanceof Player)) {
			sender.sendMessage(Main.prefix + "Du musst ein Spieler sein!");
		}
		
		Player p = (Player)sender;
		
		if(!p.hasPermission("zenit.giveall")) {
			p.sendMessage(Main.noperm);
			return true;
		}
		ItemStack hand = p.getItemInHand();
		
		if((hand == null || (hand.getType() == Material.AIR))) {
			p.sendMessage(Main.prefix + "§cDu musst ein Item in der Hand haben!");
			return true;
		}
		
		int anzahl = hand.getAmount();
		String name = hand.getItemMeta() == null ? hand.getType().name() : hand.getItemMeta().getDisplayName() == null ? hand.getType().name() : hand.getItemMeta().getDisplayName();
		
		for(Player all : Bukkit.getOnlinePlayers()) {
			
			all.sendMessage(Main.prefix + "§7Jeder hat §b" + anzahl + "§7 Stück §b" + name + "§7 bekommen!");
			if(all != p) {
				if(all.getInventory().firstEmpty() == -1) {
					all.getWorld().dropItemNaturally(all.getLocation(), hand);
				} else {
					all.getInventory().addItem(new ItemStack[] { hand });
				}
			}
		}
		
		return true;
		
	}

}
