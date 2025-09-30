package de.sciencecode.cbsystem.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import de.sciencecode.cbsystem.main.Main;
import de.sciencecode.cbsystem.utils.Manager;

public class Mute implements CommandExecutor, Listener {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (sender.hasPermission("cbsystem.mute")) {
			if (args.length != 2) {
				sender.sendMessage(Main.getPrefix() + "§cSyntax: /mute [Name] [Grund]");
				return true;
			}
			if (args.length == 2) {
				OfflinePlayer target = Bukkit.getOfflinePlayer(args[0]);
				
				if (target == sender) {
					sender.sendMessage(Main.getPrefix() + "§cDu darfst dich nicht selber muten.");
					return true;
				}
				
				if (Manager.cfg2.getConfigurationSection("Mute").contains(target.getName())) {
					sender.sendMessage(Main.getPrefix() + "§cDieser Spieler ist bereits gemutet!");
					return true;
				}
				
				String reason = "";
                for (int i = 1; i < args.length; i++) {
                	reason = (reason + args[i] + " ");
                  }
				
				Manager.mute(target, reason, sender);
				
				target.getPlayer().sendMessage(" ");
				target.getPlayer().sendMessage(Main.getPrefix() + "§cDu wurdest aus dem Chat gemutet! Grund: §e" + reason);
				target.getPlayer().sendMessage(" ");

				sender.sendMessage(" ");
				sender.sendMessage(Main.getPrefix() + "§aDu hast erfolgreich §c" + target.getName() + " §awegen §c" + reason + " §agemutet!");
				sender.sendMessage(" ");
				
				for (Player all : Bukkit.getOnlinePlayers()) {
					if (all.hasPermission("skypvp.team")) {
						if (all != sender)
						all.sendMessage(" ");
						all.sendMessage(Main.getPrefix() + "§c" + target.getName() + " §awurde von §e" + sender.getName() + " §awegen §e" + reason + " §agemutet!");
						all.sendMessage(" ");

					}
				}

			}
		}
		
		return false;
	}
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		
		try {
			if (!Manager.cfg2.getConfigurationSection("Mute").contains(p.getName())) {
	
			e.setCancelled(true);
			p.sendMessage(" ");
			p.sendMessage(Main.getPrefix() + "§cDu bist gemutet, daher darfst du nicht schreiben!");
			p.sendMessage(" ");
			}
		} catch (NullPointerException ex) {
		}
	}

}
