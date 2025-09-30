package cloud.evaped.citybuild.utils;

import cloud.evaped.citybuild.main.CityBuildCore;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.bukkit.entity.Player;

public class Tablist
{
  private Player p;
  
  public Tablist(Player p)
  {
    this.p = p;
    sendTablist();
  }
  
  private Class<?> getNmsClass(String nmsClassName) throws ClassNotFoundException {
    return Class.forName("net.minecraft.server." + 
      org.bukkit.Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3] + "." + nmsClassName);
  }
  
  private void sendTablist()
  {
    if (!CityBuildCore.ds_msg.getBoolean("message.tablist")) { return;
    }
    try
    {
      Object header = getNmsClass("IChatBaseComponent$ChatSerializer").getMethod("a", new Class[] { String.class }).invoke(null, new Object[] { "{'text': '" + CityBuildCore.ds_msg.getString("message.tablist_header") + "'}" });
      

      Object footer = getNmsClass("IChatBaseComponent$ChatSerializer").getMethod("a", new Class[] { String.class }).invoke(null, new Object[] {"{'text': '" + CityBuildCore.ds_msg.getString("message.tablist_footer") + "'}" });
      


      Object ppoplhf = getNmsClass("PacketPlayOutPlayerListHeaderFooter").getConstructor(new Class[] {getNmsClass("IChatBaseComponent") }).newInstance(new Object[] { header });
      
      Field f = ppoplhf.getClass().getDeclaredField("b");
      f.setAccessible(true);
      f.set(ppoplhf, footer);
      
      Object nmsp = p.getClass().getMethod("getHandle", new Class[0]).invoke(p, new Object[0]);
      Object pcon = nmsp.getClass().getField("playerConnection").get(nmsp);
      
      pcon.getClass().getMethod("sendPacket", new Class[] { getNmsClass("Packet") }).invoke(pcon, new Object[] { ppoplhf });
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
