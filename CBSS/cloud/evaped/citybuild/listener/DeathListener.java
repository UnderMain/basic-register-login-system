package cloud.evaped.citybuild.listener;

import cloud.evaped.citybuild.main.CityBuildPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scheduler.BukkitScheduler;

public class DeathListener implements Listener
{
  CityBuildPlugin plugin;
  
  public DeathListener(CityBuildPlugin plugin)
  {
    this.plugin = plugin;
  }
  
  @org.bukkit.event.EventHandler
  public void onDeath(PlayerDeathEvent e) {
    if ((e.getEntity().getPlayer() instanceof Player)) {
      final Player p = e.getEntity();
      e.setDeathMessage(null);
      org.bukkit.Bukkit.getScheduler().scheduleSyncDelayedTask(CityBuildPlugin.getPlugin(CityBuildPlugin.class), new Runnable()
      {
        public void run() { p.spigot().respawn(); } }, 1L);
    }
  }
}
