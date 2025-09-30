package de.onlycode.listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.onlycode.Gamestate;
import de.onlycode.TemplateMain;
import de.onlycode.api.API_ActionBar;
import de.onlycode.api.API_SQLStats;

public class LISTENER_Online implements Listener {

	@SuppressWarnings("static-access")
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();

		TemplateMain.main.alive.remove(p);

		API_SQLStats.createPlayer(p.getUniqueId().toString());
		API_ActionBar.sendActionBarTime(p, "§cTeams verboten!", 20 * 500);
		if (TemplateMain.main.state == Gamestate.LOBBY) {
			TemplateMain.main.alive.add(p);
			e.setJoinMessage("§7» §a" + p.getDisplayName() + " §7ist dem Server beigetreten");
			p.teleport(TemplateMain.main.lm.getLocation("lobby"));
			TemplateMain.main.utils.clearPlayer(p);
			if (TemplateMain.main.alive.size() >= TemplateMain.main.min || TemplateMain.main.alive.size() == TemplateMain.main.min) {
				TemplateMain.main.cd.startLobbyCD();
			}

			if (TemplateMain.main.alive.size() >= 10 || TemplateMain.main.alive.size() == 10) {
				if (TemplateMain.main.cd.lobby > 3) {
					TemplateMain.main.cd.lobby = 3;

				}

			}

		} else {

			for (Player alive : TemplateMain.main.alive) {
				alive.hidePlayer(p);

			}
			TemplateMain.main.utils.clearPlayer(p);
			ItemStack compass = new ItemStack(Material.COMPASS, 1);
			ItemMeta compassmeta = compass.getItemMeta();
			compassmeta.setDisplayName("§cNavigator §7(Rechtsklick)");
			compass.setItemMeta(compassmeta);
			p.getInventory().addItem(compass);
			p.setAllowFlight(true);
			p.setFlying(true);
			e.setJoinMessage(null);
		}

	}

	@EventHandler
	public void onLogin(PlayerLoginEvent e) {
		if (TemplateMain.main.state != Gamestate.LOBBY) {
			Player p = e.getPlayer();
			for (Player alive : TemplateMain.main.alive) {
				alive.hidePlayer(p);

			}

			ItemStack compass = new ItemStack(Material.COMPASS, 1);
			ItemMeta compassmeta = compass.getItemMeta();
			compassmeta.setDisplayName("§cNavigator §7(Rechtsklick)");
			compass.setItemMeta(compassmeta);
			p.getInventory().addItem(compass);
			p.setAllowFlight(true);
			p.setFlying(true);
			return;

		} else {

			Player p = e.getPlayer();
			if (TemplateMain.main.alive.size() >= TemplateMain.main.max) {
				if (p.hasPermission("system.fulljoin")) {
					if (Bukkit.getOfflinePlayers().length >= Bukkit.getMaxPlayers()) {
						for (Player players : Bukkit.getOnlinePlayers()) {
							if (!players.hasPermission("Deine.Fulljoin.permission")) {
								players.kickPlayer("§cYou're kickedt\n§cThe Playerlimit is reached! \n§7You need §6Premium §7to join full servers. ");
								e.allow();
								return;

							}

						}
						e.disallow(Result.KICK_OTHER, ("§cYou're kickedt\n§cThe Playerlimit is reached! \n§7You need §6Premium §7to join full servers. "));

					} else {
						e.disallow(Result.KICK_FULL, "§cYou're kickedt\n§cThe Playerlimit is reached! \n§7You need §6Premium §7to join full servers. ");

					}

				}

			}

		}

	}

	@EventHandler
	public void onPing(ServerListPingEvent e) {
		e.setMaxPlayers(TemplateMain.main.max);
		if (TemplateMain.main.state == Gamestate.LOBBY) {
			e.setMotd("§0[§aLobby§0]");
		} else if (TemplateMain.main.state == Gamestate.INGAME) {
			e.setMotd("§0[§cIngame§0]");
		} else if (TemplateMain.main.state == Gamestate.DEATHMATCH) {
			e.setMotd("§0[§cDeathmatch§0]");
		} else if (TemplateMain.main.state == Gamestate.RESTARTING) {
			e.setMotd("§0[§4Restarting§0]");
		}

	}

	@EventHandler
	public void onLeave(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		TemplateMain.main.alive.remove(p);

		if (TemplateMain.main.state == Gamestate.INGAME || TemplateMain.main.state == Gamestate.DEATHMATCH) {
			if (TemplateMain.main.alive.contains(p)) {
				p.setHealth(0.0);
				e.setQuitMessage(TemplateMain.main.pr + "§c" + p.getDisplayName() + " §7ist gestorben");
				API_SQLStats.addDeaths(p.getUniqueId().toString(), 1);
			} else {
				e.setQuitMessage(null);
			}
		} else {
			e.setQuitMessage("§7« §c" + p.getDisplayName() + " §7hat das Spiel verlassen");

		}

	}

}
