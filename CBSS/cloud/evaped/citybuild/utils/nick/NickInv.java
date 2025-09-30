package cloud.evaped.citybuild.utils.nick;

import cloud.evaped.citybuild.MySQL.MySQLEnum;
import cloud.evaped.citybuild.MySQL.MySQLMethods;
import cloud.evaped.citybuild.main.CityBuildCore;
import cloud.evaped.citybuild.main.CityBuildPlugin;
import cloud.evaped.citybuild.utils.DataSaver;
import cloud.evaped.citybuild.utils.ItemBuilder;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class NickInv
{
  private DataSaver ds_nicksettings;
  private ItemBuilder ib;
  
  public NickInv()
  {
    ds_nicksettings = new DataSaver(NickData.getObject_nicksettings);
    ib = new ItemBuilder();
  }
  
  public void createNickNameSettingsInv(Player p) {
    Inventory inv = org.bukkit.Bukkit.createInventory(null, ds_nicksettings.getInt("inv.settings.size"), ds_nicksettings
      .getString("inv.settings.name").replaceAll("&", "§"));
    if ((!ds_nicksettings.getBoolean("inv.settings.animation")) && (ds_nicksettings.getBoolean("inv.settings.glasenabled"))) {
      CityBuildCore.instance.setGlasInInventory(inv, ds_nicksettings.getInt("inv.settings.glascolorPRIM"), ds_nicksettings.getInt("inv.settings.glascolorSEC"));
    }
    
    String normal = ds_nicksettings.getString("settings.normalstate").replaceAll("&", "§");
    String premium = ds_nicksettings.getString("settings.premiumstate").replaceAll("&", "§");
    String act = ds_nicksettings.getString("settings.activated").replaceAll("&", "§");
    String deact = ds_nicksettings.getString("settings.deactivated").replaceAll("&", "§");
    
    if (CityBuildPlugin.mysqlMethods.loadIntFromMySQL(MySQLEnum.UUID, p.getUniqueId().toString(), "nickTable", "autonick").intValue() == 0) {
      inv.setItem(ds_nicksettings.getInt("inv.items.autonickitem.pos"), ib
        .createItemWithReplacement(ds_nicksettings, "inv.items.autonickitem", 1, "%STATE%", deact));
    } else {
      inv.setItem(ds_nicksettings.getInt("inv.items.autonickitem.pos"), ib
        .createItemWithReplacement(ds_nicksettings, "inv.items.autonickitem", 1, "%STATE%", act));
    }
    
    if (CityBuildPlugin.mysqlMethods.loadIntFromMySQL(MySQLEnum.UUID, p.getUniqueId().toString(), "nickTable", "premiumnick").intValue() == 0) {
      inv.setItem(ds_nicksettings.getInt("inv.items.premiumitem.pos"), ib
        .createItemWithReplacement(ds_nicksettings, "inv.items.premiumitem", 1, "%STATE%", normal));
    } else {
      inv.setItem(ds_nicksettings.getInt("inv.items.premiumitem.pos"), ib
        .createItemWithReplacement(ds_nicksettings, "inv.items.premiumitem", 1, "%STATE%", premium));
    }
    
    if (ds_nicksettings.getBoolean("inv.settings.animation")) {
      new cloud.evaped.citybuild.utils.InvAnimation(p, inv, ds_nicksettings.getInt("inv.settings.glascolorPRIM"), ds_nicksettings.getInt("inv.settings.glascolorSEC"));
    } else {
      p.openInventory(inv);
    }
  }
  
  public void updateAutonick(Inventory inv, Player p, int i) {
    String act = ds_nicksettings.getString("settings.activated").replaceAll("&", "§");
    String deact = ds_nicksettings.getString("settings.deactivated").replaceAll("&", "§");
    
    if (i == 0) {
      inv.setItem(ds_nicksettings.getInt("inv.items.autonickitem.pos"), ib
        .createItemWithReplacement(ds_nicksettings, "inv.items.autonickitem", 1, "%STATE%", deact));
    } else {
      inv.setItem(ds_nicksettings.getInt("inv.items.autonickitem.pos"), ib
        .createItemWithReplacement(ds_nicksettings, "inv.items.autonickitem", 1, "%STATE%", act));
    }
  }
  
  public void updatePremiumnick(Inventory inv, int i) {
    String normal = ds_nicksettings.getString("settings.normalstate").replaceAll("&", "§");
    String premium = ds_nicksettings.getString("settings.premiumstate").replaceAll("&", "§");
    
    if (i == 0) {
      inv.setItem(ds_nicksettings.getInt("inv.items.premiumitem.pos"), ib
        .createItemWithReplacement(ds_nicksettings, "inv.items.premiumitem", 1, "%STATE%", normal));
    } else {
      inv.setItem(ds_nicksettings.getInt("inv.items.premiumitem.pos"), ib
        .createItemWithReplacement(ds_nicksettings, "inv.items.premiumitem", 1, "%STATE%", premium));
    }
  }
}
