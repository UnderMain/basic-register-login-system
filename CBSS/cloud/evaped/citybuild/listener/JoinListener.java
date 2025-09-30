package cloud.evaped.citybuild.listener;

import cloud.evaped.citybuild.MySQL.MySQLEnum;
import cloud.evaped.citybuild.MySQL.MySQLMethods;
import cloud.evaped.citybuild.main.CityBuildCore;
import cloud.evaped.citybuild.main.CityBuildPlugin;
import cloud.evaped.citybuild.main.FileManager;
import cloud.evaped.citybuild.utils.DataSaver;
import cloud.evaped.citybuild.utils.SpecMode;
import cloud.evaped.citybuild.utils.TitleAPI;
import cloud.evaped.citybuild.utils.nick.Nick;
import cloud.evaped.citybuild.utils.scoreboard.CoreScoreBoard;
import java.util.ArrayList;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;

public class JoinListener implements Listener
{
  private String s4;
  private String s5;
  private Boolean b4;
  private DataSaver ds_map;
  
  public JoinListener()
  {
    s4 = CityBuildPlugin.instance.getConfig().getString("Loading.header").replaceAll("&", "§");
    s5 = CityBuildPlugin.instance.getConfig().getString("Loading.footer").replaceAll("&", "§");
    b4 = Boolean.valueOf(CityBuildPlugin.instance.getConfig().getBoolean("Spawn.joinspawn"));
    ds_map = new DataSaver(FileManager.getObject_Data);
  }
  
  @EventHandler
  public void onJoin(PlayerJoinEvent e) {
    Player p = e.getPlayer();
    SpecMode.instance.checkSpecMode(p);
    
    e.setJoinMessage(null);
    
    sendLoadAnimation(p);
    execute(p);
    for (Player all : CityBuildCore.getVanishPlayer) {
      p.hidePlayer(all);
    }
  }
  
  public void sendLoadAnimation(final Player p) {
    final String uuid = p.getUniqueId().toString();
    
    TitleAPI.sendTitle(p, Integer.valueOf(10), Integer.valueOf(40), Integer.valueOf(10), s4, s5);
    p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, Integer.MAX_VALUE, 2));
    playerInLoadingScreen.add(uuid);
    p.setAllowFlight(true);
    p.setFlying(true);
    p.setFlySpeed(0.0F);
    if (!p.hasMetadata("spec")) {
      for (Player all : Bukkit.getOnlinePlayers()) {
        p.hidePlayer(all);
        all.hidePlayer(p);
      }
    }
    Bukkit.getScheduler().scheduleSyncDelayedTask(CityBuildPlugin.getPlugin(CityBuildPlugin.class), new Runnable() {
      public void run() {
        p.removePotionEffect(PotionEffectType.BLINDNESS);
        if (!p.hasMetadata("spec")) {
          p.setFlying(false);
          p.setAllowFlight(false);
          p.setGameMode(GameMode.SURVIVAL);
          for (Player all : Bukkit.getOnlinePlayers()) {
            if (all.hasMetadata("spec")) {
              if (p.hasPermission("bungee.specmode")) {
                p.showPlayer(all);
              }
            } else {
              p.showPlayer(all);
            }
            all.showPlayer(p);
          }
        }
        p.setFlySpeed(0.1F);
        JoinListener.playerInLoadingScreen.remove(uuid);
        p.playSound(p.getLocation(), org.bukkit.Sound.WOOD_CLICK, 1.0F, 1.0F);
        TitleAPI.sendTitle(p, Integer.valueOf(10), Integer.valueOf(40), Integer.valueOf(10), "", "");
        new CoreScoreBoard(p);
        
        if (p.hasPermission("citybuild.nick")) {
          int autonick;
          try {
            autonick = CityBuildPlugin.mysqlMethods.loadIntFromMySQL(MySQLEnum.UUID, p.getUniqueId().toString(), "nickTable", "autonick").intValue();
          } catch (Exception e) { int autonick;
            autonick = 0;
          }
          if (autonick == 1)
            Nick.instance.nickPlayer(p); } } }, 5L);
  }
  




  public static ArrayList<String> playerInLoadingScreen = new ArrayList();
  
  @EventHandler
  public void onMove(PlayerToggleFlightEvent e) {
    if (playerInLoadingScreen.contains(e.getPlayer().getUniqueId().toString())) {
      e.setCancelled(true);
    }
  }
  
  public void execute(final Player p)
  {
    new cloud.evaped.citybuild.utils.Tablist(p);
    p.setWalkSpeed(0.2F);
    if (((!p.hasPlayedBefore()) || (b4.booleanValue())) && 
      (ds_map.contains("Location.Spawn"))) {
      Bukkit.getScheduler().scheduleSyncDelayedTask(CityBuildPlugin.getPlugin(CityBuildPlugin.class), new Runnable()
      {
        public void run() { p.teleport(ds_map.getLocation("Location.Spawn")); } }, 1L);
    }
  }
}
