package cloud.evaped.citybuild.utils.settings;

import cloud.evaped.citybuild.utils.DataSaver;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.Player.Spigot;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SettingsManager implements org.bukkit.event.Listener
{
  private DataSaver ds_settings;
  
  public SettingsManager()
  {
    ds_settings = new DataSaver(SettingsData.getObject_Settings);
  }
  
  @EventHandler
  public void onClick(InventoryClickEvent e) {
    Player p = (Player)e.getWhoClicked();
    if (e.getAction() == InventoryAction.NOTHING)
      return;
    if (e.getCurrentItem() == null) {
      return;
    }
    if (e.getClickedInventory().getName().equals(ds_settings.getString("inv.settings.name"))) {
      e.setCancelled(true);
      
      if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ds_settings.getString("inv.items.create.name"))) {
        Bukkit.dispatchCommand(p, ds_settings.getString("settings.createcommand"));
        p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
        p.closeInventory();
      }
      
      if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ds_settings.getString("inv.items.home.name"))) {
        Bukkit.dispatchCommand(p, ds_settings.getString("settings.homecommand"));
        p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
        p.closeInventory();
      }
      
      if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ds_settings.getString("inv.items.remove.name"))) {
        for (String s : ds_settings.getStringList("settings.removemessage")) {
          TextComponent select = new TextComponent();
          select.setText(s);
          select.setBold(Boolean.valueOf(true));
          select.setClickEvent(new net.md_5.bungee.api.chat.ClickEvent(net.md_5.bungee.api.chat.ClickEvent.Action.RUN_COMMAND, ds_settings.getString("settings.removecommand")));
          select.setHoverEvent(new HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(ds_settings.getString("settings.removehover")).create()));
          p.spigot().sendMessage(select);
        }
        p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
        p.closeInventory();
      }
      return;
    }
  }
}
