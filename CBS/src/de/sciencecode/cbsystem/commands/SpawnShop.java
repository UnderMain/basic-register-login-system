package de.sciencecode.cbsystem.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import de.sciencecode.cbsystem.main.Main;

public class SpawnShop implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if ((sender instanceof ConsoleCommandSender)) {
			Bukkit.getConsoleSender().sendMessage(Main.getPrefix() + "Dieser Befehl ist nur als Spieler erlaubt!");
			return true;
		}
		Player p = (Player) sender;
		if (p.hasPermission("cbsystem.admin")) {
			if (args.length == 0) {
				Location loc = p.getLocation();
				Villager v = (Villager) loc.getWorld().spawnEntity(loc, EntityType.VILLAGER);
					v.setCustomName("§cShop");
					v.setCustomNameVisible(true);
					v.setProfession(Villager.Profession.PRIEST);
					v.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 100000));
					p.sendMessage(Main.getPrefix() + "§aDu hast erfolgreich einen §eShop gespawnt!");

			} else {
				p.sendMessage(Main.getPrefix() + "§7Bitte benutze §e/spawnshop");
			}
		} else {
			p.sendMessage(Main.getPrefix() + "§cDazu hast du keine Rechte!");
		}
		return true;
	}

}
