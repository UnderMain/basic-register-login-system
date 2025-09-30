package de.onlycode.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import de.onlycode.Gamestate;
import de.onlycode.TemplateMain;

public class LISTENER_Chat implements Listener {

	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if (TemplateMain.main.state == Gamestate.RESTARTING) {
			//end chat
			for (Player all : Bukkit.getOnlinePlayers()) {
				all.sendMessage("§8[§cEnde§8] §7" + p.getName() + " §8» §f" + e.getMessage());
				return;

			}

		}
		//Am Leben chat
		if (TemplateMain.main.alive.contains(p)) {
			for (Player all : Bukkit.getOnlinePlayers()) {
				all.sendMessage("§7" + p.getName() + " §8» §f" + e.getMessage());
			}
		} else {
			//Toten Chat
			for (Player all : Bukkit.getOnlinePlayers()) {
				if (!TemplateMain.main.alive.contains(all)) {
					all.sendMessage("§8[§cX§8] §8" + p.getName() + " §8» §f" + e.getMessage());
				}

			}

		}
		e.setCancelled(true);
	}

}
