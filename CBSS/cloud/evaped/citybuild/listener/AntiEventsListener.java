package cloud.evaped.citybuild.listener;

import cloud.evaped.citybuild.main.CityBuildPlugin;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.Inventory;

public class AntiEventsListener implements org.bukkit.event.Listener
{
  private Boolean b1;
  private Boolean b2;
  public static Boolean b3;
  private Boolean b4;
  private Boolean b5;
  private Boolean b6;
  private Boolean b7;
  private Boolean b8;
  private Boolean b9;
  private Boolean b10;
  private Boolean b11;
  
  public AntiEventsListener()
  {
    b1 = Boolean.valueOf(CityBuildPlugin.instance.getConfig().getBoolean("EntityExplodeDamage"));
    b2 = Boolean.valueOf(CityBuildPlugin.instance.getConfig().getBoolean("BlockIgnite"));
    b3 = Boolean.valueOf(CityBuildPlugin.instance.getConfig().getBoolean("WeatherChange"));
    b4 = Boolean.valueOf(CityBuildPlugin.instance.getConfig().getBoolean("LeavesDecay"));
    b5 = Boolean.valueOf(CityBuildPlugin.instance.getConfig().getBoolean("PlayerAchievement"));
    
    b6 = Boolean.valueOf(CityBuildPlugin.instance.getConfig().getBoolean("FallDamage"));
    b7 = Boolean.valueOf(CityBuildPlugin.instance.getConfig().getBoolean("FireDamage"));
    b8 = Boolean.valueOf(CityBuildPlugin.instance.getConfig().getBoolean("LavaDamage"));
    b9 = Boolean.valueOf(CityBuildPlugin.instance.getConfig().getBoolean("LightningDamage"));
    b10 = Boolean.valueOf(CityBuildPlugin.instance.getConfig().getBoolean("PoisenDamage"));
    b11 = Boolean.valueOf(CityBuildPlugin.instance.getConfig().getBoolean("PlayerDamage"));
  }
  
  @EventHandler
  public void onEntityExplode(EntityExplodeEvent e) {
    if (!b1.booleanValue()) {
      e.setCancelled(true);
    }
  }
  
  @EventHandler
  public void onBlockIgnite(BlockIgniteEvent e) {
    if (!b2.booleanValue()) {
      e.setCancelled(true);
    }
  }
  
  @EventHandler
  public void onWeatherChange(WeatherChangeEvent e) {
    if (!b3.booleanValue()) {
      e.setCancelled(true);
    }
  }
  
  @EventHandler
  public void onLeaveDecay(LeavesDecayEvent e) {
    if (!b4.booleanValue()) {
      e.setCancelled(true);
    }
  }
  
  @EventHandler
  public void onPAAE(PlayerAchievementAwardedEvent e) {
    if (!b5.booleanValue()) {
      e.setCancelled(true);
    }
  }
  
  @EventHandler(priority=EventPriority.HIGHEST)
  public void onDamageNature(EntityDamageEvent e) {
    if ((e.getEntity() instanceof Player)) {
      if ((!b6.booleanValue()) && 
        (e.getCause().equals(EntityDamageEvent.DamageCause.FALL))) {
        e.setCancelled(true);
      }
      
      if ((!b7.booleanValue()) && 
        (e.getCause().equals(EntityDamageEvent.DamageCause.FIRE))) {
        e.setCancelled(true);
      }
      
      if ((!b8.booleanValue()) && 
        (e.getCause().equals(EntityDamageEvent.DamageCause.LAVA))) {
        e.setCancelled(true);
      }
      
      if ((!b9.booleanValue()) && 
        (e.getCause().equals(EntityDamageEvent.DamageCause.LIGHTNING))) {
        e.setCancelled(true);
      }
      
      if ((!b10.booleanValue()) && 
        (e.getCause().equals(EntityDamageEvent.DamageCause.POISON))) {
        e.setCancelled(true);
      }
    }
  }
  
  @EventHandler(priority=EventPriority.HIGHEST)
  public void onDamagePlayer(EntityDamageByEntityEvent e)
  {
    if ((!b11.booleanValue()) && 
      ((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player))) {
      e.setCancelled(true);
    }
  }
  
  @EventHandler
  public void onMobDamageI(EntityDamageEvent e)
  {
    if ((e.getEntity().isCustomNameVisible()) && (cloud.evaped.citybuild.main.CityBuildCore.getEntityNames.contains(e.getEntity().getCustomName()))) {
      e.setCancelled(true);
    }
  }
  
  @EventHandler
  public void onMobDamageII(EntityDamageByEntityEvent e) {
    if ((e.getEntity().isCustomNameVisible()) && (cloud.evaped.citybuild.main.CityBuildCore.getEntityNames.contains(e.getEntity().getCustomName()))) {
      e.setCancelled(true);
    }
  }
  
  @EventHandler(priority=EventPriority.HIGHEST)
  public void onSpecModeBug(InventoryInteractEvent e) {
    if ((e.getInventory().getType() == org.bukkit.event.inventory.InventoryType.CREATIVE) || (e.getInventory().getType() == org.bukkit.event.inventory.InventoryType.PLAYER)) {
      Player p = (Player)e.getWhoClicked();
      if (p.hasMetadata("specmode")) {
        e.setCancelled(false);
      }
    }
  }
}
