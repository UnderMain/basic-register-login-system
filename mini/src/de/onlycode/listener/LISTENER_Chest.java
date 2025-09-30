package de.onlycode.listener;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import de.onlycode.Gamestate;
import de.onlycode.TemplateMain;

public class LISTENER_Chest implements Listener {

	private HashMap<Location, Inventory> chests = new HashMap<Location, Inventory>();
	private ArrayList<ItemStack> loot;

	public LISTENER_Chest() {
		chests = new HashMap<Location, Inventory>();
		loot = new ArrayList<ItemStack>();
	}

	@EventHandler
	public void onChestOpen(PlayerInteractEvent e) {
		Player p = e.getPlayer();

		if (TemplateMain.main.alive.contains(p) && TemplateMain.main.state == Gamestate.INGAME) {
			if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock().getType().equals((Object) Material.CHEST)) {
				e.setCancelled(true);
				if (chests.containsKey(e.getClickedBlock().getLocation())) {
					Inventory inv = Bukkit.createInventory(null, 27, "§7Truhe");
					p.openInventory(inv);

				} else {
					registerLoot();
					Inventory inv = Bukkit.createInventory(null, 27, "§7Truhe");
					for (int i = 0; i < TemplateMain.main.utils.rndInt(2, 5); i++) {
						inv.setItem(TemplateMain.main.utils.rndInt(0, inv.getSize() - 1), loot.get(TemplateMain.main.utils.rndInt(0, loot.size() - 1)));

					}

					chests.put(e.getClickedBlock().getLocation(), inv);

				}

				p.openInventory(chests.get(e.getClickedBlock().getLocation()));
				p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 1, 1);

			}

		}

	}

	public void registerLoot() {

		loot.clear();
		loot.add(TemplateMain.main.utils.create(Material.WOOD_SWORD, 1));
		loot.add(TemplateMain.main.utils.create(Material.STONE_SWORD, 1));
		loot.add(TemplateMain.main.utils.create(Material.IRON_SWORD, 1));
		loot.add(TemplateMain.main.utils.create(Material.GOLD_HELMET, 1));
		loot.add(TemplateMain.main.utils.create(Material.GOLD_CHESTPLATE, 1));
		loot.add(TemplateMain.main.utils.create(Material.GOLD_LEGGINGS, 1));
		loot.add(TemplateMain.main.utils.create(Material.GOLD_BOOTS, 1));
		loot.add(TemplateMain.main.utils.create(Material.IRON_HELMET, 1));
		loot.add(TemplateMain.main.utils.create(Material.IRON_CHESTPLATE, 1));
		loot.add(TemplateMain.main.utils.create(Material.IRON_LEGGINGS, 1));
		loot.add(TemplateMain.main.utils.create(Material.IRON_BOOTS, 1));
		loot.add(TemplateMain.main.utils.create(Material.DIAMOND_CHESTPLATE, 1));
		loot.add(TemplateMain.main.utils.create(Material.GOLDEN_APPLE, 1));
		loot.add(TemplateMain.main.utils.create(Material.PORK, TemplateMain.main.utils.rndInt(2, 7)));
		loot.add(TemplateMain.main.utils.create(Material.COOKED_BEEF, TemplateMain.main.utils.rndInt(2, 7)));

	}

}
