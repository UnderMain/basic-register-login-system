package de.undermain.shop.util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class gui {
	
    public Inventory createGui(String name, int reihen, Player inventoryHolder) {
        Inventory inventory = Bukkit.createInventory(inventoryHolder, reihen*9, name);
        return inventory;
    }
    
    public void openInventory(Player player) {
        Inventory inventory = createGui("Test-Inventar", 3, player);
        player.openInventory(inventory);
    }
    
    public void addItem(ItemStack itemStack, Player player) {
        Inventory inventory = createGui("Test-Inventar", 3, player);
        inventory.setItem(0, itemStack);
    }
	
}
