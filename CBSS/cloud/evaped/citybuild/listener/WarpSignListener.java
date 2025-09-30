package cloud.evaped.citybuild.listener;

import cloud.evaped.citybuild.main.CityBuildCore;
import cloud.evaped.citybuild.main.CityBuildPlugin;
import cloud.evaped.citybuild.utils.Warps;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class WarpSignListener implements Listener
{
  private String s1;
  private String s2;
  
  public WarpSignListener()
  {
    s1 = CityBuildPlugin.instance.getConfig().getString("WarpSign.layout").replaceAll("&", "§");
    s2 = CityBuildCore.instance.translateString(CityBuildPlugin.instance.getConfig().getString("WarpSign.nowarp").replaceAll("&", "§"));
  }
  
  @EventHandler
  public void onSignChange(SignChangeEvent e) {
    Player p = e.getPlayer();
    if ((p.hasPermission("citybuild.warpsign")) && 
      (e.getLine(0).equalsIgnoreCase("[Warp]")) && (e.getLine(1) != null)) {
      e.setLine(0, s1);
    }
  }
  
  @EventHandler
  public void onInteract(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    
    if ((e.getAction() == Action.RIGHT_CLICK_BLOCK) && ((e.getClickedBlock().getState() instanceof Sign)))
    {
      Sign s = (Sign)e.getClickedBlock().getState();
      if (!s.getLine(0).equals(s1)) { return;
      }
      Warps.instance.onSignInteract(p, s, s2);
    }
  }
}
