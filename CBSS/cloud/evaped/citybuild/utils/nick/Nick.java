package cloud.evaped.citybuild.utils.nick;

import cloud.evaped.citybuild.main.CityBuildCore;
import cloud.evaped.citybuild.main.CityBuildPlugin;
import cloud.evaped.citybuild.utils.DataSaver;
import cloud.evaped.citybuild.utils.scoreboard.CoreScoreBoard;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.PropertyMap;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityDestroy;
import net.minecraft.server.v1_8_R3.PacketPlayOutNamedEntitySpawn;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerInfo;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerInfo.EnumPlayerInfoAction;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Nick
{
  private CityBuildCore core;
  private DataSaver ds_nicknames;
  private DataSaver ds_nicksettings;
  public static Nick instance;
  public static Field name1;
  
  public Nick()
  {
    instance = this;
    core = CityBuildCore.instance;
    ds_nicknames = new DataSaver(NickData.getObject_nicknames);
    ds_nicksettings = new DataSaver(NickData.getObject_nicksettings);
    makeList();
    for (Player all : Bukkit.getOnlinePlayers()) {
      if ((all.hasPermission("CityBuild.nick")) && 
        (CityBuildPlugin.mysqlMethods.loadIntFromMySQL(cloud.evaped.citybuild.MySQL.MySQLEnum.UUID, all
        .getUniqueId().toString(), "nickTable", "autonick").intValue() == 1))
      {
        instance.nickPlayer(all);
      }
    }
  }
  



  private static ArrayList<String> getNickNameList = new ArrayList();
  
  public static HashMap<Player, String> isNicked = new HashMap();
  public static HashMap<String, String> getOldName = new HashMap();
  public static HashMap<String, String> getPlayerBehindName = new HashMap();
  private static HashMap<String, String> getPlayerBehindUUID = new HashMap();
  
  private void makeList() {
    java.util.List<String> list = ds_nicknames.getStringList("Nickname.list");
    getNickNameList.addAll(list);
    for (Player all : Bukkit.getOnlinePlayers()) {
      if (getNickNameList.contains(all.getName())) {
        getNickNameList.remove(all.getName());
      }
    }
  }
  
  private String getRandomNickName() {
    java.util.Random r = new java.util.Random();
    if (getNickNameList.size() == 0) {
      return null;
    }
    int i = r.nextInt(getNickNameList.size() - 1);
    String name = (String)getNickNameList.get(i);
    getNickNameList.remove(name);
    return name;
  }
  
  private static String getUUID(String name)
  {
    return Bukkit.getOfflinePlayer(name).getUniqueId().toString().replaceAll("-", "");
  }
  
  public void nickPlayer(final Player p)
  {
    final String s = getRandomNickName();
    if (s == null) {
      return;
    }
    if (isNicked.containsKey(p)) {
      unnickPlayer(p, false);
      new BukkitRunnable()
      {
        public void run() {
          String oldnickname = (String)Nick.isNicked.get(p);
          Nick.getPlayerBehindUUID.remove(oldnickname);
          Nick.getPlayerBehindName.remove(oldnickname);
          Nick.isNicked.remove(p);
          Nick.isNicked.put(p, s);
          Nick.getPlayerBehindUUID.put(s, p.getUniqueId().toString());
          Nick.getPlayerBehindName.put(s, Nick.getOldName.get(p.getUniqueId().toString()));
          Nick.getNickNameList.add(oldnickname);
          Nick.getNickNameList.remove(s); } }
      
        .runTaskLater(CityBuildPlugin.instance, 8L);
    } else {
      isNicked.put(p, s);
      getOldName.put(p.getUniqueId().toString(), CityBuildPlugin.mysqlMethods.loadStringFromMySQL(cloud.evaped.citybuild.MySQL.MySQLEnum.UUID, p.getUniqueId().toString(), "coinsTable", "name"));
      getPlayerBehindUUID.put(s, p.getUniqueId().toString());
      getPlayerBehindName.put(s, getOldName.get(p.getUniqueId().toString()));
      getNickNameList.remove(s);
      p.sendMessage(core.translateString(ds_nicksettings.getString("settings.nick").replace("%NAME%", s)));
    }
    setName(p, s);
    ((CoreScoreBoard)cloud.evaped.citybuild.utils.scoreboard.CachePlayer.getBoard.get(p.getUniqueId().toString())).nickPlayer();
  }
  
  public void unnickPlayer(Player p, boolean quit)
  {
    String uuid = p.getUniqueId().toString();
    getNickNameList.add(isNicked.get(p));
    String name = (String)getOldName.get(uuid);
    setName(p, name);
    String oldnickname = (String)isNicked.get(p);
    getPlayerBehindUUID.remove(oldnickname);
    getPlayerBehindName.remove(oldnickname);
    isNicked.remove(p);
    getOldName.remove(uuid);
    if (!quit) {
      ((CoreScoreBoard)cloud.evaped.citybuild.utils.scoreboard.CachePlayer.getBoard.get(p.getUniqueId().toString())).unnickPlayer();
      p.sendMessage(core.translateString(ds_nicksettings.getString("settings.unnick")));
    }
    if (p.hasMetadata("loading")) {
      p.removeMetadata("loading", CityBuildPlugin.instance);
    }
  }
  
  public void unnickPlayerOnReload() {
    for (Player p : isNicked.keySet()) {
      String name = (String)getOldName.get(p.getUniqueId().toString());
      setNameQuick(p, name);
      destroyPlayer(p);
      p.sendMessage(CityBuildCore.instance.translateString(ds_nicksettings.getString("settings.unnick")));
    }
  }
  
  public void destroyPlayer(Player p) {
    if (p.hasMetadata("loading")) {
      p.removeMetadata("loading", CityBuildPlugin.instance);
    }
    String uuid = p.getUniqueId().toString();
    CraftPlayer cp = (CraftPlayer)p;
    PacketPlayOutEntityDestroy destroy = new PacketPlayOutEntityDestroy(new int[] { cp.getEntityId() });
    sendPacket(destroy);
    
    PacketPlayOutPlayerInfo removeTab = new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.REMOVE_PLAYER, new EntityPlayer[] {cp.getHandle() });
    sendPacket(removeTab);
    cloud.evaped.citybuild.utils.scoreboard.CachePlayer.getBoard.remove(uuid);
    cloud.evaped.citybuild.utils.scoreboard.CachePlayer.getTeamName.remove(uuid);
  }
  
  private void setName(final Player p, String nick) {
    final CraftPlayer cp = (CraftPlayer)p;
    try
    {
      name1.set(cp.getProfile(), nick);
    }
    catch (Exception localException) {}
    

    PacketPlayOutEntityDestroy destroy = new PacketPlayOutEntityDestroy(new int[] { cp.getEntityId() });
    sendPacket(destroy);
    
    PacketPlayOutPlayerInfo removeTab = new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.REMOVE_PLAYER, new EntityPlayer[] {cp.getHandle() });
    sendPacket(removeTab);
    new BukkitRunnable()
    {
      public void run()
      {
        PacketPlayOutPlayerInfo addTab = new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER, new EntityPlayer[] { cp.getHandle() });
        Nick.sendPacket(addTab);
        PacketPlayOutNamedEntitySpawn spawn = new PacketPlayOutNamedEntitySpawn(cp.getHandle());
        Nick.sendPacket(spawn, p); } }
    
      .runTaskLater(CityBuildPlugin.instance, 2L);
    setSkin(cp, nick);
  }
  
  private void setNameQuick(Player p, String nick) {
    CraftPlayer cp = (CraftPlayer)p;
    try
    {
      name1.set(cp.getProfile(), nick);
    }
    catch (Exception localException) {}
    
    PacketPlayOutEntityDestroy destroy = new PacketPlayOutEntityDestroy(new int[] { cp.getEntityId() });
    sendPacket(destroy);
    
    PacketPlayOutPlayerInfo removeTab = new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.REMOVE_PLAYER, new EntityPlayer[] {cp.getHandle() });
    sendPacket(removeTab);
    
    PacketPlayOutPlayerInfo addTab = new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER, new EntityPlayer[] {cp.getHandle() });
    sendPacket(addTab);
    PacketPlayOutNamedEntitySpawn spawn = new PacketPlayOutNamedEntitySpawn(cp.getHandle());
    sendPacket(spawn, p);
    setSkinQuick(cp, nick);
  }
  
  private void setSkin(final CraftPlayer p, String nick) {
    try {
      GameProfile gp = p.getProfile();
      gp.getProperties().clear();
      Skin skin = new Skin(getUUID(nick));
      
      if (skin.getSkinName() != null) {
        gp.getProperties().put(skin.getSkinName(), new com.mojang.authlib.properties.Property(skin
          .getSkinName(), skin.getSkinValue(), skin.getSkinSignatur()));
      }
      






      new BukkitRunnable()
      {
        public void run()
        {
          for (Player all : )
            all.hidePlayer(p); } }
      

        .runTaskLater(CityBuildPlugin.instance, 1L);
      new BukkitRunnable()
      {
        public void run() {
          for (Player all : )
            all.showPlayer(p); } }
      

        .runTaskLater(CityBuildPlugin.instance, 5L);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  private void setSkinQuick(CraftPlayer p, String nick)
  {
    try {
      GameProfile gp = p.getProfile();
      gp.getProperties().clear();
      getUUID(nick);
      Skin skin = new Skin(getUUID(nick));
      
      if (skin.getSkinName() != null) {
        gp.getProperties().put(skin.getSkinName(), new com.mojang.authlib.properties.Property(skin
          .getSkinName(), skin.getSkinValue(), skin.getSkinSignatur()));
      }
      for (Player all : Bukkit.getOnlinePlayers()) {
        all.hidePlayer(p);
      }
      for (Player all : Bukkit.getOnlinePlayers()) {
        all.showPlayer(p);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  private static void sendPacket(Packet<?> packet)
  {
    for (Player all : ) {
      getHandleplayerConnection.sendPacket(packet);
    }
  }
  
  private static void sendPacket(Packet<?> packet, Player p) {
    for (Player all : ) {
      if (all != p) {
        getHandleplayerConnection.sendPacket(packet);
      }
    }
  }
  
  public static Field getField(Class<?> clazz, String name) {
    try {
      Field f = clazz.getDeclaredField(name);
      f.setAccessible(true);
      return f;
    } catch (Exception e) {}
    return null;
  }
}
