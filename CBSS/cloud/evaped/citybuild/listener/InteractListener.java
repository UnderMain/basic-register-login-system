package cloud.evaped.citybuild.listener;

import cloud.evaped.citybuild.main.CityBuildCore;
import cloud.evaped.citybuild.main.CityBuildPlugin;
import cloud.evaped.citybuild.main.FileManager;
import cloud.evaped.citybuild.utils.settings.SettingsInv;
import java.io.File;
import java.util.ArrayList;
import net.md_5.bungee.api.chat.ClickEvent.Action;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.HoverEvent.Action;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Player.Spigot;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;

public class InteractListener implements Listener
{
  private String s1;
  private String s2;
  private String s3;
  private String s4;
  private String s5;
  private java.util.List<String> list1;
  private SettingsInv inv;
  
  public InteractListener()
  {
    s1 = CityBuildPlugin.instance.getConfig().getString("Villager.firstthere.createplot").replaceAll("&", "§");
    s2 = CityBuildPlugin.instance.getConfig().getString("Villager.firstthere.createplotshow").replaceAll("&", "§");
    s3 = CityBuildPlugin.instance.getConfig().getString("Villager.firstthere.command");
    s4 = CityBuildPlugin.instance.getConfig().getString("Villager.firstthere.name").replaceAll("&", "§");
    s5 = CityBuildPlugin.instance.getConfig().getString("Villager.plotsettings.name").replaceAll("&", "§");
    
    list1 = CityBuildPlugin.instance.getConfig().getStringList("Villager.firstthere.messages");
    inv = new SettingsInv();
  }
  
  public static ArrayList<Player> hasClicked = new ArrayList();
  
  @EventHandler
  public void onEntityinteract(PlayerInteractEntityEvent e) {
    final Player p = e.getPlayer();
    
    if ((e.getRightClicked().getType() != org.bukkit.entity.EntityType.PLAYER) && (e.getRightClicked().isCustomNameVisible())) { File File;
      if ((CityBuildCore.getPlayerInEditMode.contains(p)) && (p.isSneaking()) && (p.getItemInHand().getType() == Material.REDSTONE)) {
        if (e.getRightClicked().getCustomName().equals(s4)) {
          e.setCancelled(true);
          File File = new File("plugins/CityBuild/", "DATA.yml");
          FileConfiguration cfg = YamlConfiguration.loadConfiguration(File);
          
          cfg.set("Location.Villager.firstthere", null);
          
          FileManager.saveFILE(cfg, File);
          e.getRightClicked().remove();
          return; }
        if (e.getRightClicked().getCustomName().equals(s5)) {
          e.setCancelled(true);
          p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
          File = new File("plugins/CityBuild/", "DATA.yml");
          FileConfiguration cfg = YamlConfiguration.loadConfiguration(File);
          
          cfg.set("Location.Villager.plotsettings", null);
          
          FileManager.saveFILE(cfg, File);
          e.getRightClicked().remove();
          return;
        }
      }
      if (e.getRightClicked().getCustomName().equals(s4)) {
        e.setCancelled(true);
        
        if (!hasClicked.contains(p)) {
          for (String s : list1) {
            if (s.contains("%CREATEPLOT%")) {
              TextComponent select = new TextComponent();
              select.setText(s1);
              select.setBold(Boolean.valueOf(true));
              select.setClickEvent(new net.md_5.bungee.api.chat.ClickEvent(ClickEvent.Action.RUN_COMMAND, s3));
              select.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(s2).create()));
              p.spigot().sendMessage(select);
            } else {
              p.sendMessage(s.replaceAll("&", "§"));
            }
          }
          p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
          hasClicked.add(p);
          org.bukkit.Bukkit.getScheduler().scheduleSyncDelayedTask(CityBuildPlugin.getPlugin(CityBuildPlugin.class), new Runnable()
          {
            public void run() { InteractListener.hasClicked.remove(p); } }, 100L);
        }
      }
      

      if (e.getRightClicked().getCustomName().equals(s5)) {
        e.setCancelled(true);
        
        inv.createSettingsInv(p);
        
        p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
      }
    }
  }
}
