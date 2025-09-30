package cloud.evaped.citybuild.utils;

import cloud.evaped.citybuild.main.CityBuildPlugin;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitScheduler;



public class InvAnimation
{
  private Player p;
  private Inventory inv;
  private HashMap<Integer, ItemStack> content;
  private ItemBuilder ib;
  private int colorPrim = 0;
  private int colorSec = 7;
  

  public InvAnimation(Player p, Inventory inv, int prim, int sec)
  {
    this.p = p;
    this.inv = inv;
    ib = new ItemBuilder();
    colorPrim = prim;
    colorSec = sec;
    createInvContent();
    runAnimation();
  }
  
  private void runAnimation()
  {
    if (p.hasMetadata("animation")) {
      p.playSound(p.getLocation(), Sound.ITEM_BREAK, 1.0F, 1.0F);
      return;
    }
    
    p.setMetadata("animation", new FixedMetadataValue(CityBuildPlugin.instance, Boolean.valueOf(true)));
    Inventory inv = Bukkit.createInventory(null, this.inv.getSize(), this.inv.getTitle());
    p.openInventory(inv);
    
    if (inv.getSize() == 9) {
      startAnimationForOne(inv);
    } else if (inv.getSize() == 18) {
      startAnimationForTwo(inv);
    } else if (inv.getSize() == 27) {
      startAnimationForThree(inv);
    } else if (inv.getSize() == 36) {
      startAnimationForFour(inv);
    } else if (inv.getSize() == 45) {
      startAnimationForFive(inv);
    } else if (inv.getSize() == 54) {
      startAnimationForSix(inv);
    }
  }
  
  private void createInvContent()
  {
    HashMap<Integer, ItemStack> map = new HashMap();
    for (int i = 0; i < inv.getContents().length; i++) {
      if ((inv.getContents()[i] != null) && (inv.getContents()[i].getType() != Material.STAINED_GLASS_PANE)) {
        map.put(Integer.valueOf(i), inv.getContents()[i]);
      }
    }
    content = map;
  }
  
  private void startAnimationForOne(final Inventory inv)
  {
    final AtomicInteger count2 = new AtomicInteger();
    count2.set(Bukkit.getScheduler().scheduleSyncRepeatingTask(CityBuildPlugin.instance, new Runnable() {
      int time = 7;
      ItemStack loading = ib.createItem(Material.STAINED_GLASS_PANE, 1, colorSec, " ");
      ItemStack loading1 = ib.createItem(Material.STAINED_GLASS_PANE, 1, colorPrim, " ");
      
      public void run() {
        time -= 1;
        if (time == 5) {
          inv.setItem(0, loading);
          inv.setItem(1, loading1);
          inv.setItem(7, loading1);
          inv.setItem(8, loading);
          p.playSound(p.getLocation(), Sound.NOTE_BASS, 1.0F, 1.0F);
        } else if (time == 3) {
          inv.setItem(2, loading1);
          inv.setItem(3, loading1);
          inv.setItem(4, loading);
          inv.setItem(5, loading1);
          inv.setItem(6, loading1);
          p.playSound(p.getLocation(), Sound.NOTE_BASS, 1.0F, 1.0F);
        } else if (time == 0) {
          for (Integer i : content.keySet()) {
            inv.setItem(i.intValue(), (ItemStack)content.get(i));
          }
          p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
          p.removeMetadata("animation", CityBuildPlugin.instance);
          Bukkit.getScheduler().cancelTask(count2.get()); } } }, 0L, 2L));
  }
  




  private void startAnimationForTwo(final Inventory inv)
  {
    final AtomicInteger count2 = new AtomicInteger();
    count2.set(Bukkit.getScheduler().scheduleSyncRepeatingTask(CityBuildPlugin.instance, new Runnable() {
      int time = 7;
      ItemStack loading = ib.createItem(Material.STAINED_GLASS_PANE, 1, colorSec, " ");
      ItemStack loading1 = ib.createItem(Material.STAINED_GLASS_PANE, 1, colorPrim, " ");
      
      public void run() {
        time -= 1;
        if (time == 5) {
          inv.setItem(0, loading);
          inv.setItem(1, loading1);
          inv.setItem(2, loading1);
          inv.setItem(6, loading1);
          inv.setItem(7, loading1);
          inv.setItem(8, loading);
          inv.setItem(9, loading);
          inv.setItem(10, loading1);
          inv.setItem(16, loading1);
          inv.setItem(17, loading);
          p.playSound(p.getLocation(), Sound.NOTE_BASS, 1.0F, 1.0F);
        } else if (time == 3) {
          inv.setItem(3, loading1);
          inv.setItem(4, loading);
          inv.setItem(5, loading1);
          inv.setItem(11, loading1);
          inv.setItem(12, loading1);
          inv.setItem(13, loading);
          inv.setItem(14, loading1);
          inv.setItem(15, loading1);
          

          p.playSound(p.getLocation(), Sound.NOTE_BASS, 1.0F, 1.0F);
        } else if (time == 0) {
          for (Integer i : content.keySet()) {
            inv.setItem(i.intValue(), (ItemStack)content.get(i));
          }
          p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
          p.removeMetadata("animation", CityBuildPlugin.instance);
          Bukkit.getScheduler().cancelTask(count2.get()); } } }, 0L, 2L));
  }
  




  private void startAnimationForThree(final Inventory inv)
  {
    final AtomicInteger count2 = new AtomicInteger();
    count2.set(Bukkit.getScheduler().scheduleSyncRepeatingTask(CityBuildPlugin.instance, new Runnable() {
      int time = 7;
      ItemStack loading = ib.createItem(Material.STAINED_GLASS_PANE, 1, colorSec, " ");
      ItemStack loading1 = ib.createItem(Material.STAINED_GLASS_PANE, 1, colorPrim, " ");
      
      public void run() {
        time -= 1;
        if (time == 5) {
          inv.setItem(0, loading);
          inv.setItem(1, loading1);
          inv.setItem(2, loading1);
          inv.setItem(3, loading1);
          inv.setItem(4, loading1);
          inv.setItem(5, loading1);
          inv.setItem(6, loading1);
          inv.setItem(7, loading1);
          inv.setItem(8, loading);
          inv.setItem(9, loading);
          inv.setItem(17, loading);
          inv.setItem(18, loading);
          inv.setItem(19, loading1);
          inv.setItem(20, loading1);
          inv.setItem(21, loading1);
          inv.setItem(22, loading1);
          inv.setItem(23, loading1);
          inv.setItem(24, loading1);
          inv.setItem(25, loading1);
          inv.setItem(26, loading);
          p.playSound(p.getLocation(), Sound.NOTE_BASS, 1.0F, 1.0F);
        } else if (time == 3) {
          inv.setItem(10, loading);
          inv.setItem(11, loading1);
          inv.setItem(12, loading1);
          inv.setItem(13, loading);
          inv.setItem(14, loading1);
          inv.setItem(15, loading1);
          inv.setItem(16, loading);
          p.playSound(p.getLocation(), Sound.NOTE_BASS, 1.0F, 1.0F);
        } else if (time == 0) {
          for (Integer i : content.keySet()) {
            inv.setItem(i.intValue(), (ItemStack)content.get(i));
          }
          p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
          p.removeMetadata("animation", CityBuildPlugin.instance);
          Bukkit.getScheduler().cancelTask(count2.get()); } } }, 0L, 2L));
  }
  




  private void startAnimationForFour(final Inventory inv)
  {
    final AtomicInteger count2 = new AtomicInteger();
    count2.set(Bukkit.getScheduler().scheduleSyncRepeatingTask(CityBuildPlugin.instance, new Runnable() {
      int time = 7;
      ItemStack loading = ib.createItem(Material.STAINED_GLASS_PANE, 1, colorSec, " ");
      ItemStack loading1 = ib.createItem(Material.STAINED_GLASS_PANE, 1, colorPrim, " ");
      
      public void run() {
        time -= 1;
        if (time == 5) {
          inv.setItem(0, loading);
          inv.setItem(1, loading1);
          inv.setItem(2, loading1);
          inv.setItem(3, loading);
          inv.setItem(4, loading1);
          inv.setItem(5, loading);
          inv.setItem(6, loading1);
          inv.setItem(7, loading1);
          inv.setItem(8, loading);
          inv.setItem(9, loading1);
          inv.setItem(18, loading1);
          inv.setItem(17, loading1);
          inv.setItem(26, loading1);
          inv.setItem(27, loading);
          inv.setItem(28, loading1);
          inv.setItem(29, loading1);
          inv.setItem(30, loading);
          inv.setItem(31, loading1);
          inv.setItem(32, loading);
          inv.setItem(33, loading1);
          inv.setItem(34, loading1);
          inv.setItem(35, loading);
          p.playSound(p.getLocation(), Sound.NOTE_BASS, 1.0F, 1.0F);
        } else if (time == 3) {
          inv.setItem(10, loading);
          inv.setItem(11, loading1);
          inv.setItem(12, loading1);
          inv.setItem(13, loading);
          inv.setItem(14, loading1);
          inv.setItem(15, loading1);
          inv.setItem(16, loading);
          inv.setItem(19, loading);
          inv.setItem(20, loading1);
          inv.setItem(21, loading1);
          inv.setItem(22, loading);
          inv.setItem(23, loading1);
          inv.setItem(24, loading1);
          inv.setItem(25, loading);
          p.playSound(p.getLocation(), Sound.NOTE_BASS, 1.0F, 1.0F);
        } else if (time == 0) {
          for (Integer i : content.keySet()) {
            inv.setItem(i.intValue(), (ItemStack)content.get(i));
          }
          p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
          p.removeMetadata("animation", CityBuildPlugin.instance);
          Bukkit.getScheduler().cancelTask(count2.get()); } } }, 0L, 2L));
  }
  




  private void startAnimationForFive(final Inventory inv)
  {
    final AtomicInteger count2 = new AtomicInteger();
    count2.set(Bukkit.getScheduler().scheduleSyncRepeatingTask(CityBuildPlugin.instance, new Runnable() {
      int time = 9;
      ItemStack loading = ib.createItem(Material.STAINED_GLASS_PANE, 1, colorSec, " ");
      ItemStack loading1 = ib.createItem(Material.STAINED_GLASS_PANE, 1, colorPrim, " ");
      
      public void run() {
        time -= 1;
        if (time == 7) {
          inv.setItem(0, loading);
          inv.setItem(1, loading1);
          inv.setItem(2, loading1);
          inv.setItem(3, loading1);
          inv.setItem(4, loading);
          inv.setItem(5, loading1);
          inv.setItem(6, loading1);
          inv.setItem(7, loading1);
          inv.setItem(8, loading);
          inv.setItem(36, loading);
          inv.setItem(37, loading1);
          inv.setItem(38, loading1);
          inv.setItem(39, loading1);
          inv.setItem(40, loading);
          inv.setItem(41, loading1);
          inv.setItem(42, loading1);
          inv.setItem(43, loading1);
          inv.setItem(44, loading);
          inv.setItem(9, loading1);
          inv.setItem(18, loading1);
          inv.setItem(27, loading1);
          inv.setItem(17, loading1);
          inv.setItem(26, loading1);
          inv.setItem(35, loading1);
          p.playSound(p.getLocation(), Sound.NOTE_BASS, 1.0F, 1.0F);
        } else if (time == 5) {
          inv.setItem(10, loading);
          inv.setItem(11, loading1);
          inv.setItem(12, loading1);
          inv.setItem(13, loading);
          inv.setItem(14, loading1);
          inv.setItem(15, loading1);
          inv.setItem(16, loading);
          inv.setItem(28, loading);
          inv.setItem(29, loading1);
          inv.setItem(30, loading1);
          inv.setItem(31, loading);
          inv.setItem(32, loading1);
          inv.setItem(33, loading1);
          inv.setItem(34, loading);
          inv.setItem(19, loading);
          inv.setItem(25, loading);
          p.playSound(p.getLocation(), Sound.NOTE_BASS, 1.0F, 1.0F);
        } else if (time == 3) {
          inv.setItem(20, loading);
          inv.setItem(21, loading);
          inv.setItem(22, loading1);
          inv.setItem(23, loading);
          inv.setItem(24, loading);
          p.playSound(p.getLocation(), Sound.NOTE_BASS, 1.0F, 1.0F);
        } else if (time == 0) {
          for (Integer i : content.keySet()) {
            inv.setItem(i.intValue(), (ItemStack)content.get(i));
          }
          p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
          p.removeMetadata("animation", CityBuildPlugin.instance);
          Bukkit.getScheduler().cancelTask(count2.get()); } } }, 0L, 2L));
  }
  






  private void startAnimationForSix(final Inventory inv)
  {
    final AtomicInteger count2 = new AtomicInteger();
    count2.set(Bukkit.getScheduler().scheduleSyncRepeatingTask(CityBuildPlugin.instance, new Runnable() {
      int time = 9;
      ItemStack loading = ib.createItem(Material.STAINED_GLASS_PANE, 1, colorSec, " ");
      ItemStack loading1 = ib.createItem(Material.STAINED_GLASS_PANE, 1, colorPrim, " ");
      
      public void run() {
        time -= 1;
        if (time == 7) {
          inv.setItem(0, loading);
          inv.setItem(1, loading1);
          inv.setItem(2, loading1);
          inv.setItem(3, loading);
          inv.setItem(4, loading);
          inv.setItem(5, loading);
          inv.setItem(6, loading1);
          inv.setItem(7, loading1);
          inv.setItem(8, loading);
          inv.setItem(9, loading1);
          inv.setItem(18, loading1);
          inv.setItem(27, loading1);
          inv.setItem(36, loading1);
          inv.setItem(17, loading1);
          inv.setItem(26, loading1);
          inv.setItem(35, loading1);
          inv.setItem(44, loading1);
          inv.setItem(45, loading);
          inv.setItem(46, loading1);
          inv.setItem(47, loading1);
          inv.setItem(48, loading);
          inv.setItem(49, loading);
          inv.setItem(50, loading);
          inv.setItem(51, loading1);
          inv.setItem(52, loading1);
          inv.setItem(53, loading);
          p.playSound(p.getLocation(), Sound.NOTE_BASS, 1.0F, 1.0F);
        } else if (time == 5) {
          inv.setItem(10, loading);
          inv.setItem(11, loading1);
          inv.setItem(12, loading1);
          inv.setItem(13, loading1);
          inv.setItem(14, loading1);
          inv.setItem(15, loading1);
          inv.setItem(16, loading);
          inv.setItem(19, loading);
          inv.setItem(28, loading);
          inv.setItem(25, loading);
          inv.setItem(34, loading);
          inv.setItem(37, loading);
          inv.setItem(38, loading1);
          inv.setItem(39, loading1);
          inv.setItem(40, loading1);
          inv.setItem(41, loading1);
          inv.setItem(42, loading1);
          inv.setItem(43, loading);
          p.playSound(p.getLocation(), Sound.NOTE_BASS, 1.0F, 1.0F);
        } else if (time == 3) {
          inv.setItem(20, loading);
          inv.setItem(21, loading1);
          inv.setItem(22, loading);
          inv.setItem(23, loading1);
          inv.setItem(24, loading);
          inv.setItem(29, loading);
          inv.setItem(30, loading1);
          inv.setItem(31, loading);
          inv.setItem(32, loading1);
          inv.setItem(33, loading);
          p.playSound(p.getLocation(), Sound.NOTE_BASS, 1.0F, 1.0F);
        } else if (time == 0) {
          for (Integer i : content.keySet()) {
            inv.setItem(i.intValue(), (ItemStack)content.get(i));
          }
          p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
          p.removeMetadata("animation", CityBuildPlugin.instance);
          Bukkit.getScheduler().cancelTask(count2.get()); } } }, 0L, 2L));
  }
}
