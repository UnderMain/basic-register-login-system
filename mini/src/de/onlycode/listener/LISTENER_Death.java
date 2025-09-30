package de.onlycode.listener;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import de.onlycode.TemplateMain;
import de.onlycode.api.API_SQLStats;

public class LISTENER_Death implements Listener {

	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player p = e.getEntity();

		if (TemplateMain.main.alive.contains(p)) {
			if (TemplateMain.main.lastdmg.containsKey(p)) {
				e.setDeathMessage(TemplateMain.main.pr + "§c" + p.getDisplayName() + " §7wurde von §a" + TemplateMain.main.lastdmg.get(p).getDisplayName() + " §7getötet");
				TemplateMain.main.lastdmg.get(p).addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100, 2));
				TemplateMain.main.lastdmg.get(p).playSound(TemplateMain.main.lastdmg.get(p).getLocation(), Sound.LEVEL_UP, 1, 1);
				API_SQLStats.addDeaths(p.getUniqueId().toString(), 1);
				API_SQLStats.addKills(TemplateMain.main.lastdmg.get(p).getUniqueId().toString(), 1);

			} else {
				e.setDeathMessage(TemplateMain.main.pr + "§c" + p.getDisplayName() + " §7ist gestorben");
				API_SQLStats.addDeaths(p.getUniqueId().toString(), 1);

			}
			TemplateMain.main.alive.remove(p);

			for (Player alive : TemplateMain.main.alive) {
				alive.hidePlayer(p);
			}

		} else {
			e.setDeathMessage(null);

		}
		TemplateMain.main.windetection();

	}

	@EventHandler
	public void onRespawn(PlayerRespawnEvent e) {
		Player p = e.getPlayer();

		ItemStack compass = new ItemStack(Material.COMPASS, 1);
		ItemMeta compassmeta = compass.getItemMeta();
		compassmeta.setDisplayName("§cNavigator §7(Rechtsklick)");
		compass.setItemMeta(compassmeta);
		p.teleport(TemplateMain.main.lm.getLocation("lobby"));
		p.getInventory().addItem(compass);
		p.setAllowFlight(true);
		p.setFlying(true);
	}

}
