package de.sciencecode.cbsystem.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import de.sciencecode.cbsystem.main.Main;
import de.sciencecode.cbsystem.utils.Manager;

public class Head implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (!p.hasPermission("cbsystem.head")) {
			p.sendMessage(Main.getPrefix() + "§cDazu hast du keine Rechte!");
			return true;
		}
		if (args.length == 1) {
			if (Manager.cooldown.contains(p)) {

				p.sendMessage(Main.getPrefix() + "§cDu darfst dies nur 1x pro Woche benutzen!");
				return true;
			}

			if (!p.hasPermission("skypvp.owner")) {

				Manager.setHeadDelay(p);

			}

			ItemStack is = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
			SkullMeta im = (SkullMeta) is.getItemMeta();
			im.setOwner(args[0]);
			im.setDisplayName(args[0]);
			p.sendMessage(Main.getPrefix() + "§aDu hast den Kopf von §e" + im.getDisplayName() + "§a erhalten!");
			is.setItemMeta(im);
			p.getInventory().addItem(new ItemStack[] { is });
			p.updateInventory();
			return true;
		}
		p.sendMessage(Main.getPrefix() + "§cSyntax: /kopf [Spieler]");

		return false;
	}
}
