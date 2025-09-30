package cloud.evaped.citybuild.utils;

import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle.EnumTitleAction;
import net.minecraft.server.v1_8_R3.PlayerConnection;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;

public class TitleAPI
{
  public TitleAPI() {}
  
  public static void sendTitle(org.bukkit.entity.Player p, Integer fadeIn, Integer stay, Integer fadeOut, String title, String subtitle)
  {
    PlayerConnection connection = getHandleplayerConnection;
    
    PacketPlayOutTitle PacketPlayOutTime = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TIMES, null, fadeIn.intValue(), stay.intValue(), fadeOut.intValue());
    connection.sendPacket(PacketPlayOutTime);
    if (subtitle != null) {
      net.minecraft.server.v1_8_R3.IChatBaseComponent TitleSub = net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + subtitle + "\"}");
      PacketPlayOutTitle PacketPlayOutSubTitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, TitleSub);
      connection.sendPacket(PacketPlayOutSubTitle);
    }
    if (title != null) {
      net.minecraft.server.v1_8_R3.IChatBaseComponent Title = net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + title + "\"}");
      PacketPlayOutTitle PacketPlayOutSubTitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, Title);
      connection.sendPacket(PacketPlayOutSubTitle);
    }
  }
}
