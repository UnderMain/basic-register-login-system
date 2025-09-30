package cloud.evaped.citybuild.utils;

import cloud.evaped.citybuild.main.CityBuildPlugin;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Actionbar
{
  public Actionbar()
  {
    execute();
  }
  
  private void execute() {
    if (CityBuildPlugin.BungeeSystem) {
      final String s = CityBuildPlugin.instance.getConfig().getString("specmode.broadcaster").replaceAll("&", "§");
      Bukkit.getScheduler().scheduleSyncRepeatingTask(CityBuildPlugin.instance, new Runnable() {
        public void run() {
          for (Player all : )
            if (all.hasMetadata("spec"))
              Actionbar.this.sendActionBar(all, s); } }, 0L, 20L);
    }
  }
  



  private void sendActionBar(Player p, String msg)
  {
    CraftPlayer player = (CraftPlayer)p;
    net.minecraft.server.v1_8_R3.IChatBaseComponent cbc = net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + msg + "\"}");
    PacketPlayOutChat ppoc = new PacketPlayOutChat(cbc, (byte)2);
    getHandleplayerConnection.sendPacket(ppoc);
  }
}
