package de.undermain.commands;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import de.undermain.config.ItemBuilder;
import de.undermain.config.files;
import de.undermain.config.methoden;

public class sign implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player p = (Player) sender;
		String Prefix = files.getObject_config.get("Prefix").toString().replaceAll("&", "§");
		String perm = files.getObject_config.get("NoPerm").toString().replaceAll("&", "§");
		ItemBuilder ib = new ItemBuilder(p.getItemInHand());
		if(p.hasPermission("ufc.sign")) {
			if(args.length == 0) {
				p.sendMessage(Prefix + "§7§m---------------------------");
				p.sendMessage(Prefix +"");
				p.sendMessage(Prefix +"§7» /sign <text>");
				p.sendMessage(Prefix +"");
				p.sendMessage(Prefix + "§7§m---------------------------");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);

			}

			if(args.length >= 1) {
				StringBuilder builder = new StringBuilder();
				for(int i = 0; i<args.length; i++) {
					if (i == args.length) {
						builder.append(args[i]);
					}else {
						builder.append(args[i] + " ");
					}
				}
				
				String datum = methoden.datum();
				
				String text = builder.toString().replaceAll("&", "§");
				
				Material mat = p.getItemInHand().getType();
			     ItemStack stack = new ItemStack(mat);
			     stack = methoden.addGlow(stack);

			     if(p.getItemInHand().getType() == Material.AIR) {
			    	 p.sendMessage(Prefix + "§cBitte halte ein Item in der Hand!");
						p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);

			     }else {
			    	 
					        ib.addLoreLine("§3§m---------------------------------");
							ib.addLoreLine("");
							ib.addLoreLine("§6»" + text);
							ib.addLoreLine(files.getObject_config.get("Sign").toString().replaceAll("&", "§").replaceAll("%player%", p.getName()).replaceAll("%date%", datum));
							ib.addLoreLine("");
					        ib.addLoreLine("§3§m---------------------------------");


							p.sendMessage(Prefix + "§7§m---------------------------");
							p.sendMessage(Prefix +"");
							p.sendMessage(Prefix +"§7» Dein Item wurde gesigned! ");
							p.sendMessage(Prefix +"");
							p.sendMessage(Prefix + "§7§m---------------------------");
							p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);

					       
			     
			     
			     }
			     
			     

			}else {
				p.sendMessage(Prefix + "§cBitte gebe einen Text ein!");
			}
		}else {
			p.sendMessage(Prefix + perm);
		}
		return false;
	}

}
