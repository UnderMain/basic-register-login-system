package cloud.evaped.citybuild.utils.nick;

import cloud.evaped.citybuild.MySQL.MySQLEnum;
import cloud.evaped.citybuild.MySQL.MySQLMethods;
import cloud.evaped.citybuild.main.CityBuildPlugin;
import cloud.evaped.citybuild.utils.DataSaver;
import java.util.UUID;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.meta.ItemMeta;

public class NickManager implements org.bukkit.event.Listener
{
  private NickInv inv;
  private DataSaver ds_nicksettings;
  
  public NickManager()
  {
    inv = new NickInv();
    ds_nicksettings = new DataSaver(NickData.getObject_nicksettings);
  }
  
  @org.bukkit.event.EventHandler
  public void onClick(InventoryClickEvent e) {
    Player p = (Player)e.getWhoClicked();
    
    if (e.getAction() == org.bukkit.event.inventory.InventoryAction.NOTHING)
      return;
    if (e.getCurrentItem() == null) {
      return;
    }
    
    if (e.getClickedInventory().getName().equals(ds_nicksettings.getString("inv.settings.name"))) {
      e.setCancelled(true);
      

      if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ds_nicksettings.getString("inv.items.autonickitem.name"))) {
        p.playSound(p.getLocation(), org.bukkit.Sound.WOOD_CLICK, 1.0F, 1.0F);
        
        if (CityBuildPlugin.mysqlMethods.loadIntFromMySQL(MySQLEnum.UUID, p.getUniqueId().toString(), "nickTable", "autonick").intValue() == 0) {
          CityBuildPlugin.mysqlMethods.setIntFromMySQL(MySQLEnum.UUID, p.getUniqueId().toString(), "nickTable", "autonick", 1);
          inv.updateAutonick(e.getClickedInventory(), p, 1);
        } else {
          CityBuildPlugin.mysqlMethods.setIntFromMySQL(MySQLEnum.UUID, p.getUniqueId().toString(), "nickTable", "autonick", 0);
          inv.updateAutonick(e.getClickedInventory(), p, 0);
        }
        return;
      }
      
      if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ds_nicksettings.getString("inv.items.premiumitem.name"))) {
        p.playSound(p.getLocation(), org.bukkit.Sound.WOOD_CLICK, 1.0F, 1.0F);
        if (CityBuildPlugin.mysqlMethods.loadIntFromMySQL(MySQLEnum.UUID, p.getUniqueId().toString(), "nickTable", "premiumnick").intValue() == 0) {
          CityBuildPlugin.mysqlMethods.setIntFromMySQL(MySQLEnum.UUID, p.getUniqueId().toString(), "nickTable", "premiumnick", 1);
          inv.updatePremiumnick(e.getClickedInventory(), 1);
        } else {
          CityBuildPlugin.mysqlMethods.setIntFromMySQL(MySQLEnum.UUID, p.getUniqueId().toString(), "nickTable", "premiumnick", 0);
          inv.updatePremiumnick(e.getClickedInventory(), 0);
        }
        return;
      }
    }
  }
}
