package cloud.evaped.citybuild.utils;

import cloud.evaped.citybuild.commands.SpawnCommand;
import cloud.evaped.citybuild.main.CityBuildCore;
import cloud.evaped.citybuild.main.CityBuildPlugin;
import java.util.ArrayList;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;

public class TeleportESC implements org.bukkit.event.Listener
{
  CityBuildPlugin plugin;
  private CityBuildCore core;
  private DataSaver ds_msg;
  
  public TeleportESC(CityBuildPlugin plugin)
  {
    this.plugin = plugin;
    core = new CityBuildCore();
    ds_msg = new DataSaver(Messages.getObject_messages);
  }
  
  @EventHandler
  public void onMove(PlayerMoveEvent e) {
    Player p = e.getPlayer();
    
    if (SpawnCommand.getTeleport.contains(p)) {
      p.playSound(p.getLocation(), Sound.ITEM_BREAK, 1.0F, 1.0F);
      SpawnCommand.getTeleport.remove(p);
      p.sendMessage(core.translateString(ds_msg.getString("message.teleportCancel")));
    }
  }
}
