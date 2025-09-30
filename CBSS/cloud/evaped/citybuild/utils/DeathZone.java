package cloud.evaped.citybuild.utils;

import cloud.evaped.citybuild.main.CityBuildPlugin;
import cloud.evaped.citybuild.main.FileManager;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;

public class DeathZone
{
  private DataSaver ds_map;
  private int high;
  private int high1;
  private boolean enabled;
  
  public DeathZone()
  {
    high = CityBuildPlugin.instance.getConfig().getInt("DeathHighMin");
    high1 = CityBuildPlugin.instance.getConfig().getInt("DeathHighMax");
    enabled = CityBuildPlugin.instance.getConfig().getBoolean("DeathZone");
    ds_map = new DataSaver(FileManager.getObject_Data);
    
    startStateChanger();
  }
  
  private void startStateChanger() {
    if (!enabled) return;
    Bukkit.getScheduler().scheduleSyncRepeatingTask(CityBuildPlugin.getPlugin(CityBuildPlugin.class), new Runnable()
    {
      public void run() {
        List<Player> editList = cloud.evaped.citybuild.main.CityBuildCore.getPlayerInEditMode;
        for (Player all : Bukkit.getOnlinePlayers())
          if ((!editList.contains(all)) && (
            (all.getLocation().getY() < high) || (high1 < all.getLocation().getY()))) {
            all.setFallDistance(0.0F);
            all.teleport(ds_map.getLocation("Location.Spawn"));
            all.playSound(all.getLocation(), org.bukkit.Sound.BAT_TAKEOFF, 1.0F, 1.0F); } } }, 0L, 15L);
  }
}
