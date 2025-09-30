package de.onlycode.listener;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import de.onlycode.Gamestate;
import de.onlycode.TemplateMain;

public class LISTENER_Move implements Listener {

	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if (TemplateMain.main.state == Gamestate.FRIEDE) {
			if (e.getFrom().getX() != e.getTo().getX() || e.getFrom().getY() != e.getTo().getY() || e.getFrom().getZ() != e.getTo().getZ()) {
				Location loc = e.getFrom();
				p.teleport(loc.setDirection(e.getTo().getDirection()));
			}

		}

	}

}
