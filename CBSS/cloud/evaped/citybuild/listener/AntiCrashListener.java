package cloud.evaped.citybuild.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class AntiCrashListener implements org.bukkit.event.Listener
{
  public AntiCrashListener() {}
  
  @org.bukkit.event.EventHandler(priority=EventPriority.HIGHEST)
  public void onBookInteract(org.bukkit.event.player.PlayerEditBookEvent e)
  {
    if ((!e.getPlayer().hasPermission("citybuild.anticrash.bypass")) && (!cloud.evaped.citybuild.main.CityBuildPlugin.anticrash)) {
      e.setCancelled(true);
    }
  }
  
  @org.bukkit.event.EventHandler(priority=EventPriority.HIGHEST)
  public void onInteract(PlayerInteractEvent e) {
    if ((!e.getPlayer().hasPermission("citybuild.anticrash.bypass")) && (!cloud.evaped.citybuild.main.CityBuildPlugin.anticrash)) {
      try {
        if (e.getItem().getType() == Material.BOOK_AND_QUILL) {
          e.setCancelled(true);
        }
        if (e.getItem().getType() == Material.WRITTEN_BOOK) {
          e.setCancelled(true);
        }
        if (e.getItem().getType() == Material.NAME_TAG) {
          e.setCancelled(true);
        }
      } catch (Exception localException) {}
    }
  }
  
  @org.bukkit.event.EventHandler(priority=EventPriority.HIGHEST)
  public void onBuild(BlockPlaceEvent e) {
    if ((!e.getPlayer().hasPermission("citybuild.anticrash.bypass")) && (!cloud.evaped.citybuild.main.CityBuildPlugin.anticrash)) {
      try {
        if (e.getBlockPlaced().getType() == Material.ARMOR_STAND) {
          e.setCancelled(true);
        }
      } catch (Exception localException) {}
    }
  }
  
  @org.bukkit.event.EventHandler(priority=EventPriority.HIGHEST)
  public void onSignChange(SignChangeEvent e) {
    if ((!e.getPlayer().hasPermission("citybuild.anticrash.bypass")) && (!cloud.evaped.citybuild.main.CityBuildPlugin.anticrash)) {
      try {
        for (int i = 0; i < 4; i++) {
          String line = e.getLine(i).toLowerCase();
          if ((line.contains("wolfram")) || (line.length() > 30)) {
            e.setCancelled(true);
            e.getPlayer().kickPlayer("Ups, something went wrong...");
            e.setLine(i, "...");
          }
        }
      }
      catch (Exception localException) {}
    }
  }
}
