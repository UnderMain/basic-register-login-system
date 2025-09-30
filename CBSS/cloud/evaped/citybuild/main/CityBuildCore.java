package cloud.evaped.citybuild.main;

import cloud.evaped.citybuild.commands.SpawnCommand;
import cloud.evaped.citybuild.utils.DataSaver;
import cloud.evaped.citybuild.utils.InvBackground;
import cloud.evaped.citybuild.utils.Messages;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitScheduler;


public class CityBuildCore
{
  CityBuildPlugin plugin;
  private String prefix;
  public static CityBuildCore instance;
  public static DataSaver ds_msg;
  
  public CityBuildCore()
  {
    plugin = CityBuildPlugin.instance;
    try {
      prefix = CityBuildPlugin.instance.getConfig().getString("messages.prefix").replaceAll("&", "§");
    } catch (Exception e) {
      prefix = "";
    }
    instance = this;
    ds_msg = new DataSaver(Messages.getObject_messages);
  }
  
  public static ArrayList<Player> getPlayerInEditMode = new ArrayList();
  public static ArrayList<String> getMutedPlayer = new ArrayList();
  public static ArrayList<Player> getVanishPlayer = new ArrayList();
  public static ArrayList<String> getEntityNames = new ArrayList();
  
  public String translateString(String s) {
    return prefix + s;
  }
  
  public void teleportWithCooldown(final Player p, Integer i, final Location loc) {
    DataSaver ds_msg = new DataSaver(Messages.getObject_messages);
    if (i.intValue() > 0) {
      if (!p.hasPermission("citybuild.spawn.bypass")) {
        SpawnCommand.getTeleport.add(p);
        p.sendMessage(translateString(ds_msg.getString("message.teleport")));
        Bukkit.getScheduler().scheduleSyncDelayedTask(CityBuildPlugin.getPlugin(CityBuildPlugin.class), new Runnable() {
          public void run() {
            if (SpawnCommand.getTeleport.contains(p)) {
              SpawnCommand.getTeleport.remove(p);
              p.teleport(loc);
              p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
            }
          }
        }, 20 * i.intValue());
      } else {
        p.teleport(loc);
        p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
      }
    } else {
      p.teleport(loc);
      p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
    }
  }
  
  public void setGlasInInventory(Inventory inv, int prim, int sec) {
    ItemStack itemPrim = createItem(Material.STAINED_GLASS_PANE, 1, prim, " ");
    for (int i = 0; i < inv.getSize(); i++) {
      inv.setItem(i, itemPrim);
    }
    int[] array = null;
    if (inv.getSize() == 9) {
      array = InvBackground.arraySecOne;
    } else if (inv.getSize() == 18) {
      array = InvBackground.arraySecTwo;
    } else if (inv.getSize() == 27) {
      array = InvBackground.arraySecThree;
    } else if (inv.getSize() == 36) {
      array = InvBackground.arraySecFour;
    } else if (inv.getSize() == 45) {
      array = InvBackground.arraySecFive;
    } else if (inv.getSize() == 54) {
      array = InvBackground.arraySecSix;
    }
    ItemStack itemSec = createItem(Material.STAINED_GLASS_PANE, 1, sec, " ");
    for (int i = 0; i < array.length; i++) {
      inv.setItem(array[i], itemSec);
    }
  }
  
  public ItemStack createItem(Material material, int anzahl, int subid, String displayname) {
    short neuesubid = (short)subid;
    ItemStack i = new ItemStack(material, anzahl, neuesubid);
    ItemMeta m = i.getItemMeta();
    m.setDisplayName(displayname);
    m.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
    m.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
    m.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_UNBREAKABLE });
    m.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_PLACED_ON });
    i.setItemMeta(m);
    
    return i;
  }
  
  public static void saveFile(FileConfiguration file, File FILE) {
    file.options().copyDefaults(true);
    try {
      file.save(FILE);
    } catch (IOException e) {
      if (CityBuildPlugin.debug) {
        e.printStackTrace();
      }
    }
  }
  
  public static void saveItemInFile(FileConfiguration file, String path, int pos, int id, int subid, String name, List<String> lore, Boolean tru)
  {
    file.addDefault(path + ".name", name);
    file.addDefault(path + ".pos", Integer.valueOf(pos));
    file.addDefault(path + ".id", Integer.valueOf(id));
    file.addDefault(path + ".subid", Integer.valueOf(subid));
    file.addDefault(path + ".lore", lore);
    file.addDefault(path + ".enchant", tru);
  }
  
  public static void saveItemInFileLess(FileConfiguration file, String path, int pos, String name, List<String> lore, Boolean tru)
  {
    file.addDefault(path + ".name", name);
    file.addDefault(path + ".pos", Integer.valueOf(pos));
    file.addDefault(path + ".lore", lore);
    file.addDefault(path + ".enchant", tru);
  }
  
  public static void saveHeadInFiles(FileConfiguration file, String path, int pos, String name, List<String> lore, Boolean tru, String skullname)
  {
    file.addDefault(path + ".name", name);
    file.addDefault(path + ".pos", Integer.valueOf(pos));
    file.addDefault(path + ".skullname", skullname);
    file.addDefault(path + ".lore", lore);
    file.addDefault(path + ".enchant", tru);
  }
  
  public static void saveLocationInFiles(FileConfiguration file, String path, int pos, String name, List<String> lore, Boolean tru, String skullname)
  {
    file.addDefault(path + ".world", name);
    file.addDefault(path + ".x", Integer.valueOf(pos));
    file.addDefault(path + ".y", skullname);
    file.addDefault(path + ".lore", lore);
    file.addDefault(path + ".enchant", tru);
  }
  
  public String getDate() {
    Date datetoday = new Date();
    String date = new SimpleDateFormat("dd/MM/yyyy").format(datetoday);
    return date;
  }
}
