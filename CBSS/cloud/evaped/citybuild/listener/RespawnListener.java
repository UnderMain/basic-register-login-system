package cloud.evaped.citybuild.listener;

import cloud.evaped.citybuild.main.FileManager;
import cloud.evaped.citybuild.utils.DataSaver;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class RespawnListener implements Listener
{
  public RespawnListener() {}
  
  @EventHandler(priority=EventPriority.HIGHEST)
  public void onRespawn(PlayerRespawnEvent e)
  {
    Player p = e.getPlayer();
    DataSaver ds_data = new DataSaver(FileManager.getObject_Data);
    e.setRespawnLocation(ds_data.getLocation("Location.Spawn"));
    p.setFireTicks(0);
  }
}
