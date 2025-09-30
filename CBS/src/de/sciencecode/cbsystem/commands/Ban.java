package de.sciencecode.cbsystem.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

import de.sciencecode.cbsystem.main.Main;
import de.sciencecode.cbsystem.utils.Manager;

public class Ban implements CommandExecutor, Listener {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {		
		
		if (!sender.hasPermission("cbsystem.ban")) {
			sender.sendMessage(Main.getPrefix() + "§cDazu hast du keine Rechte!");
			return true;
		}
		if (args.length != 2) {
			sender.sendMessage(Main.getPrefix() + "§cSyntax: /ban [Name] [Grund]");
			return true;
		}
			if (args.length == 2) {
				OfflinePlayer target = Bukkit.getOfflinePlayer(args[0]);
				
				if (args[0].equalsIgnoreCase("ScienceCode")) {
					sender.sendMessage(Main.getPrefix() + "§cDu darfst den Schreiber des Plugins nicht bannen!");
					return true;
				}
				
				String reason = "";
                for (int i = 1; i < args.length; i++) {
                	reason = (reason + args[i] + " ");
                  }
				
				Manager.ban(target, reason, sender);

			}
		
		return false;
	}
	
	@EventHandler(priority=EventPriority.HIGH)
	public void onLogin(PlayerLoginEvent e) {
		Player p = e.getPlayer();
		
		if (e.getResult() == Result.KICK_BANNED) {
		
		e.setKickMessage(Main.getPrefix() + "§cDu wurdest PERMAMENT vom Server gebannt! \n\n §eGrund: §a" + Manager.cfg1.getString("Ban." + p.getName()) + "\n\n §eZu unrecht gebannt? Schreibe ein Entbannungsantrag im Forum!");
		}
	}
	
}