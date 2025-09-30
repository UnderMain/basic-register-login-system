package de.undermain.shop.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import de.undermain.shop.util.files;

public class giveall implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player p = (Player) sender;
		String Prefix = files.getObject_config.get("Prefix").toString().replaceAll("&", "§");
		String perm = files.getObject_config.get("NoPerm").toString().replaceAll("&", "§");
		String toomuch = files.getObject_config.get("TooMuchArgs").toString().replaceAll("&", "§");
		String ConsoleMSG = files.getObject_config.get("ConsoleMSG").toString().replaceAll("&", "§");
		if(sender instanceof Player) {
			if(p.hasPermission("citybuild.giveall")) {
				if(args.length>0) {
					p.sendMessage(Prefix + toomuch);
				}else {
					
				
				ItemStack hand = new ItemStack(p.getItemInHand());
				if(hand.getType() == Material.AIR) {
					p.sendMessage(Prefix + "§cYou need a Item in your hand!");
            		p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
				}else {
					String itemname = hand.getItemMeta().getDisplayName();
					int anzahl = hand.getAmount();

					for(Player all : Bukkit.getOnlinePlayers()) {
						all.sendMessage(Prefix + "§7Everybody got §e§l" + anzahl +" §b§l"+ itemname +"§7!");
						if(all.getInventory().firstEmpty() == -1) {
							all.getWorld().dropItemNaturally(all.getLocation(), hand);
						} else {
							all.getInventory().addItem(new ItemStack[] { hand });
						}
					}
				}
				}
			}else {
				p.sendMessage(Prefix + perm);
			}
			
		}else {
			sender.sendMessage(Prefix + ConsoleMSG);
		}
		
		
		return false;
	}

}
