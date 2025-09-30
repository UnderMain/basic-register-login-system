package de.onlycode.listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import de.onlycode.TemplateMain;

public class LISTENER_Navigator implements Listener {

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (e.getClickedInventory() != null && e.getCurrentItem() != null) {
			if (!TemplateMain.main.alive.contains(p)) {
				e.setCancelled(true);
				if (e.getClickedInventory().getTitle().equals("§cNavigator §7(Rechtsklick)")) {
					String playerName = e.getCurrentItem().getItemMeta().getDisplayName();
					if (TemplateMain.main.alive.contains(Bukkit.getPlayer(playerName))) {
						Player tar = Bukkit.getPlayer(playerName);
						p.teleport(tar);
						p.sendMessage(TemplateMain.main.pr + "§7Du wurdest zu §e" + tar.getDisplayName() + " §7teleportiert");

					} else {
						p.sendMessage(TemplateMain.main.pr + "§7Dieser Spieler ist nicht mehr am §eLeben");
					}

				}

			}

		}

	}

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (!TemplateMain.main.alive.contains(p)) {
			if (p.getItemInHand().getType() == Material.COMPASS) {
				int length = (TemplateMain.main.alive.size() / 9) + 1;
				Inventory inv = Bukkit.createInventory(null, 9 * length, "§cNavigator §7(Rechtsklick)");
				for (Player alive : TemplateMain.main.alive) {
					ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
					SkullMeta skullmeta = (SkullMeta) head.getItemMeta();
					skullmeta.setOwner(alive.getName());
					skullmeta.setDisplayName(alive.getDisplayName());
					head.setItemMeta(skullmeta);
					inv.addItem(head);

				}
				p.openInventory(inv);

			}

		}

	}

}
