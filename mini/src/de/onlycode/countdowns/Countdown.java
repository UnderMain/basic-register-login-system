package de.onlycode.countdowns;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;

import de.onlycode.Gamestate;
import de.onlycode.TemplateMain;

public class Countdown {

	public static boolean lobbystarted = false;
	public static boolean restartstarted = false;

	public static int lobbycd;
	public static int friedencd;
	public static int ingamecd;
	public static int deathmatchcd;
	public static int bevorcd;
	public static int restartcd;

	public static int lobby = TemplateMain.main.lobby;
	static int frieden = TemplateMain.main.frieden;
	static int ingame = TemplateMain.main.ingame;
	static int bevor = TemplateMain.main.bevor;
	static int deathmatch = TemplateMain.main.deathmatch;
	static int restart = TemplateMain.main.restart;

	public static void startLobbyCD() {
		TemplateMain.main.state = Gamestate.LOBBY;
		if (lobbystarted == false) {
			lobbystarted = true;
			lobbycd = Bukkit.getScheduler().scheduleSyncRepeatingTask(TemplateMain.main, new Runnable() {

				@Override
				public void run() {

					if (lobby >= 1) {
						if (Bukkit.getOnlinePlayers().size() == TemplateMain.main.min - 1) {
							if (lobby <= 20 && lobby >= 1) {
								lobby = 60;
							}

						}

						if (lobby == 60 || lobby == 30 || lobby == 15 || (lobby <= 5 && lobby >= 1)) {
							for (Player all : Bukkit.getOnlinePlayers()) {
								all.playSound(all.getLocation(), Sound.NOTE_BASS, 1, 1);
								all.sendMessage(TemplateMain.main.pr + "§7Das Spiel startet in §e" + lobby + " §7Sekunden");
							}

						}

						if (lobby <= 60 && lobby >= 1) {
							for (Player all : Bukkit.getOnlinePlayers()) {
								all.setLevel(lobby);

							}

						}

					}

					if (lobby == 1) {
						for (Player all : Bukkit.getOnlinePlayers()) {
							all.sendMessage(TemplateMain.main.pr + "§7Das Spiel startet in §e" + lobby + " §7Sekunde");
						}
					}

					if (lobby == 0) {
						for (Player all : Bukkit.getOnlinePlayers()) {
							TemplateMain.main.utils.clearPlayer(all);
							all.sendMessage(TemplateMain.main.pr + "§eAlle werden in die Arena teleportiert!");
						}
						TemplateMain.main.lm.mapTeleport();
						startFriedenCD();
						Bukkit.getScheduler().cancelTask(lobbycd);

					}

					lobby--;

				}

			}, 0, 20L);

		}

	}

	public static void startFriedenCD() {
		TemplateMain.main.state = Gamestate.FRIEDE;
		friedencd = Bukkit.getScheduler().scheduleSyncRepeatingTask(TemplateMain.main, new Runnable() {

			@SuppressWarnings("deprecation")
			@Override
			public void run() {

				if (frieden >= 1) {
					for (Player all : Bukkit.getOnlinePlayers()) {
						all.setGameMode(GameMode.SURVIVAL);
					}

					if (frieden == 1) {
						for (Player all : Bukkit.getOnlinePlayers()) {
							all.playSound(all.getLocation(), Sound.NOTE_BASS, 1, 1);
							all.sendTitle("§e" + frieden, " ");
							all.setLevel(frieden);
							all.sendMessage(TemplateMain.main.pr + "§7Das Spiel beginnt in §e" + frieden + " §7Sekunde");

						}

					} else {

						if (frieden <= 10 && frieden >= 2) {
							for (Player all : Bukkit.getOnlinePlayers()) {
								all.playSound(all.getLocation(), Sound.NOTE_BASS, 1, 1);
								all.sendTitle("§e" + frieden, " ");
								all.setLevel(frieden);
								all.sendMessage(TemplateMain.main.pr + "§7Das Spiel beginnt in §e" + frieden + " §7Sekunden");
							}

						}

					}

				}

				if (frieden == 0) {

					for (Player all : Bukkit.getOnlinePlayers()) {
						TemplateMain.main.utils.clearPlayer(all);
						all.setLevel(0);
						all.sendMessage(TemplateMain.main.pr + "§eDas Spiel beginnt!");

					}
					startIngameCD();
					Bukkit.getScheduler().cancelTask(friedencd);

				}

				frieden--;

			}

		}, 0, 20L);

	}

	public static void startIngameCD() {
		TemplateMain.main.state = Gamestate.INGAME;
		ingamecd = Bukkit.getScheduler().scheduleSyncRepeatingTask(TemplateMain.main, new Runnable() {

			@Override
			public void run() {
				if (ingame == 0 || TemplateMain.main.alive.size() == TemplateMain.main.dmstart || TemplateMain.main.alive.size() <= TemplateMain.main.dmstart) {

					startBevorDeathmatchCD();
					Bukkit.getScheduler().cancelTask(ingamecd);

				}

				ingame--;
			}

		}, 0, 20L);

	}

	public static void startBevorDeathmatchCD() {
		TemplateMain.main.state = Gamestate.INGAME;
		bevorcd = Bukkit.getScheduler().scheduleSyncRepeatingTask(TemplateMain.main, new Runnable() {

			@Override
			public void run() {

				if (bevor >= 1) {

					if (bevor == 60 || bevor == 30 || bevor == 10 || (bevor <= 5 && bevor >= 1)) {
						if (bevor == 1) {
							for (Player all : Bukkit.getOnlinePlayers()) {
								all.sendMessage(TemplateMain.main.pr + "§7Das Deathmatch beginnt in §e" + bevor + " §7Sekunde");

							}

						} else {

							for (Player all : Bukkit.getOnlinePlayers()) {
								all.sendMessage(TemplateMain.main.pr + "§7Das Deathmatch beginnt in §e" + bevor + " §7Sekunden");

							}
						}

					}

				} else if (bevor == 0) {
					for (Player all : Bukkit.getOnlinePlayers()) {
						all.sendMessage(TemplateMain.main.pr + "§eDas Deathmatch beginnt!");
					}
					TemplateMain.main.lm.mapTeleport2();
					startDeathmatchCD();
					Bukkit.getScheduler().cancelTask(bevorcd);

				}

				bevor--;
			}

		}, 0, 20L);

	}

	public static void startDeathmatchCD() {
		TemplateMain.main.state = Gamestate.DEATHMATCH;
		deathmatchcd = Bukkit.getScheduler().scheduleSyncRepeatingTask(TemplateMain.main, new Runnable() {

			@Override
			public void run() {

				if (deathmatch == 0) {
					startRestartCD();
					Bukkit.getScheduler().cancelTask(deathmatchcd);

				}

				deathmatch--;
			}

		}, 0, 20L);

	}

	public static void startRestartCD() {
		TemplateMain.main.state = Gamestate.RESTARTING;
		if (restartstarted == false) {
			restartstarted = true;
			restartcd = Bukkit.getScheduler().scheduleSyncRepeatingTask(TemplateMain.main, new Runnable() {

				@Override
				public void run() {

					if (restart >= 1) {
						if (restart == 15) {
							for (Player all : Bukkit.getOnlinePlayers()) {
								all.setGameMode(GameMode.ADVENTURE);
								all.teleport(TemplateMain.main.lm.getLocation("lobby"));
								all.showPlayer(all);
								for (Player alive : TemplateMain.main.alive) {
									alive.showPlayer(all);

								}

							}

						}

						if (restart == 15 || (restart <= 5 && restart >= 1)) {
							if (restart == 1) {
								for (Player all : Bukkit.getOnlinePlayers()) {
									all.sendMessage(TemplateMain.main.pr + "§cDer Server restartet in §e" + restart + " §cSekunde");

								}
							} else {
								for (Player all : Bukkit.getOnlinePlayers()) {
									all.sendMessage(TemplateMain.main.pr + "§cDer Server restartet in §e" + restart + " §cSekunden");
								}
							}

						}

					} else if (restart == 0) {
						for (Player all : Bukkit.getOnlinePlayers()) {
							all.kickPlayer(null);
						}
						for (World w : Bukkit.getWorlds()) {
							for (Entity e : w.getEntities()) {
								if (e instanceof Item) {
									e.remove();

								}

							}

						}
						Bukkit.getScheduler().cancelTask(restartcd);
						Bukkit.shutdown();

					}
					restart--;
				}

			}, 0, 20L);

		}

	}

}
