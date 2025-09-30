package cloud.evaped.citybuild.utils.settings;

import cloud.evaped.citybuild.main.CityBuildCore;
import cloud.evaped.citybuild.utils.DataSaver;
import cloud.evaped.citybuild.utils.InvAnimation;
import cloud.evaped.citybuild.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class SettingsInv
{
  private DataSaver ds_settings;
  private ItemBuilder ib;
  
  public SettingsInv()
  {
    ds_settings = new DataSaver(SettingsData.getObject_Settings);
    ib = new ItemBuilder();
  }
  
  public void createSettingsInv(Player p) {
    Inventory inv = Bukkit.createInventory(null, ds_settings.getInt("inv.settings.size"), 
      ChatColor.translateAlternateColorCodes('&', ds_settings.getString("inv.settings.name")));
    if ((ds_settings.getBoolean("inv.settings.glasenabled")) && (!ds_settings.getBoolean("inv.settings.animation"))) {
      CityBuildCore.instance.setGlasInInventory(inv, ds_settings.getInt("inv.settings.glascolorPRIM"), ds_settings.getInt("inv.settings.glascolorSEC"));
    }
    
    inv.setItem(ds_settings.getInt("inv.items.create.pos"), ib.createItemWithLore(ds_settings, "inv.items.create", 1));
    inv.setItem(ds_settings.getInt("inv.items.remove.pos"), ib.createItemWithLore(ds_settings, "inv.items.remove", 1));
    inv.setItem(ds_settings.getInt("inv.items.home.pos"), ib.createItemWithLore(ds_settings, "inv.items.home", 1));
    
    if (ds_settings.getBoolean("inv.settings.animation")) {
      new InvAnimation(p, inv, ds_settings.getInt("inv.settings.glascolorPRIM"), ds_settings.getInt("inv.settings.glascolorSEC"));
    } else {
      p.openInventory(inv);
    }
  }
}
