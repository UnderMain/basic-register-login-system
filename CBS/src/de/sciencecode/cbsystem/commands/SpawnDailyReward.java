package de.sciencecode.cbsystem.commands;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import de.sciencecode.cbsystem.main.Main;

public class SpawnDailyReward implements CommandExecutor, Listener {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if ((sender instanceof ConsoleCommandSender)) {
			Bukkit.getConsoleSender().sendMessage(Main.getPrefix() + "Dieser Befehl ist nur als Spieler erlaubt!");
			return true;
		}
		Player p = (Player) sender;
		if (p.hasPermission("cbsystem.admin")) {
			if (args.length == 0) {
				if (p.getWorld().getDifficulty() == Difficulty.PEACEFUL) {
					p.getWorld().setDifficulty(Difficulty.EASY);
				}
				Location loc = p.getLocation();
				Zombie v = (Zombie) loc.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
					v.setCustomName("§eTägliche Belohnung");
					v.setCustomNameVisible(true);
					v.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 100000));

						
					p.sendMessage(Main.getPrefix() + "§aDu hast erfolgreich einen §eShop gespawnt!");

			} else {
				p.sendMessage(Main.getPrefix() + "§7Bitte benutze §e/spawndailyreward");
			}
		} else {
			p.sendMessage(Main.getPrefix() + "§cDazu hast du keine Rechte!");
		}
		return true;
	}
	
	@EventHandler(priority=EventPriority.HIGH)
	public void onInt(PlayerInteractEntityEvent e) {
		if (e.getRightClicked() instanceof Zombie) {
	    		e.setCancelled(true);
	    		e.getPlayer().performCommand("dailyreward");
	    	}

		}
}
