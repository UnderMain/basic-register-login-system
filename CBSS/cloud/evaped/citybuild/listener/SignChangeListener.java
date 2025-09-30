package cloud.evaped.citybuild.listener;

import org.bukkit.event.block.SignChangeEvent;

public class SignChangeListener implements org.bukkit.event.Listener
{
  public SignChangeListener() {}
  
  @org.bukkit.event.EventHandler
  public void onSignChange(SignChangeEvent e) {
    if (e.getPlayer().hasPermission("citybuild.colorsign")) {
      for (int i = 0; i < 4; i++) {
        e.setLine(i, e.getLine(i).replaceAll("&", "§"));
      }
    }
  }
}
