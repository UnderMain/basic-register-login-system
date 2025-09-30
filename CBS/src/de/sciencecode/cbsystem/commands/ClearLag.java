package de.sciencecode.cbsystem.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;

import de.sciencecode.cbsystem.main.Main;

public class ClearLag implements CommandExecutor {
	
	int cd = 5;
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player)sender;
		
		if (p.hasPermission("cbsystem.clearlag")) {
			Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.instance, new Runnable() {

				@Override
				public void run() {
					ClearLag.this.cd -= 1;
					Bukkit.broadcastMessage(Main.getPrefix() + "§cAchtung: In §e" + ClearLag.this.cd + " §cSekunden werden alle am Boden liegenden Items entfernt!");
					if (ClearLag.this.cd == 0) {
						Bukkit.broadcastMessage(Main.getPrefix() + "§aAlle am Boden liegenden Items wurden erfolgreich entfernt!");
						for (Player all : Bukkit.getOnlinePlayers()) {
							for (Entity ent : Bukkit.getWorld(all.getWorld().getName()).getEntities()) {
								if ((ent instanceof Item)) {
									ent.remove();
								}
							}
							all.playSound(all.getLocation(), Sound.ANVIL_LAND, 20.0F, 20.0F);
							Bukkit.getScheduler().cancelAllTasks();
							Bukkit.reload();
								
							}
						}
				}
			}, 0L, 20L);
		} else {
			p.sendMessage(Main.getPrefix() + "§cDazu hast du keine Rechte!");
		}
		return false;
	}
}
