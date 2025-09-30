package cloud.evaped.citybuild.listener;

import cloud.evaped.citybuild.MySQL.MySQLMethods;
import cloud.evaped.citybuild.main.CityBuildCore;
import cloud.evaped.citybuild.main.CityBuildPlugin;
import cloud.evaped.citybuild.utils.DataSaver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements org.bukkit.event.Listener
{
  private DataSaver ds_chat;
  private Boolean b1;
  private Integer i1;
  private String s1;
  
  public ChatListener()
  {
    ds_chat = new DataSaver(cloud.evaped.citybuild.main.FileManager.getObject_Chat);
    b1 = Boolean.valueOf(CityBuildPlugin.instance.getConfig().getBoolean("Onlinetimechat.enabled"));
    i1 = Integer.valueOf(CityBuildPlugin.instance.getConfig().getInt("Onlinetimechat.time"));
    s1 = CityBuildPlugin.instance.getConfig().getString("Onlinetimechat.message").replaceAll("&", "§");
  }
  
  @EventHandler
  public void onChat(AsyncPlayerChatEvent e)
  {
    e.setCancelled(true);
    Player p = e.getPlayer();
    

    if (!CityBuildCore.getMutedPlayer.contains(p.getUniqueId().toString())) {
      if (b1.booleanValue()) {
        int online = CityBuildPlugin.mysqlMethods.loadIntFromCache(p.getUniqueId().toString(), CityBuildPlugin.MySQLTable, "onlinetime").intValue();
        if ((online < i1.intValue()) && 
          (!p.hasPermission("citybuild.bypass.chat"))) {
          p.sendMessage(CityBuildCore.instance.translateString(s1.replace("%TIME%", Integer.valueOf(i1.intValue() - online) + "")));
          p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
          return;
        }
      }
      
      p.playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0F, 1.0F);
      String msg;
      String msg;
      if (!p.hasPermission("citybuild.colorchat")) {
        msg = e.getMessage();
      } else {
        msg = org.bukkit.ChatColor.translateAlternateColorCodes('&', e.getMessage());
      }
      


      String format = ds_chat.getString("default.format").replace("%PLAYER%", p.getName()).replaceAll("&", "§").replace("%MESSAGE%", msg);
      Boolean b = Boolean.valueOf(true);
      for (int i = 1; i < 30; i++) {
        if ((ds_chat.contains(i + ".format")) && 
          (b.booleanValue()) && 
          (p.hasPermission(ds_chat.getString(i + ".perm"))))
        {
          format = ds_chat.getString(i + ".format").replace("%PLAYER%", p.getName()).replaceAll("&", "§").replace("%MESSAGE%", msg);
          b = Boolean.valueOf(false);
        }
      }
      

      if (cloud.evaped.citybuild.utils.nick.Nick.isNicked.containsKey(p)) {
        if (CityBuildPlugin.mysqlMethods.loadIntFromMySQL(cloud.evaped.citybuild.MySQL.MySQLEnum.UUID, p.getUniqueId().toString(), "nickTable", "premiumnick").intValue() == 0)
        {
          format = ds_chat.getString("default.format").replace("%PLAYER%", p.getName()).replaceAll("&", "§").replace("%MESSAGE%", msg);
        } else {
          int i = ds_chat.getInt("nick.numberforpremium");
          
          format = ds_chat.getString(i + ".format").replace("%PLAYER%", p.getName()).replaceAll("&", "§").replace("%MESSAGE%", msg);
        }
      }
      
      if (p.hasMetadata("boldwrite")) {
        sendBoldMessage(p, e.getMessage().replaceAll("&", "§"));
      } else {
        sendMessage(format);
      }
    }
  }
  
  private void sendMessage(String format) {
    for (Player all : ) {
      all.sendMessage(format);
    }
  }
  
  private void sendBoldMessage(Player p, String msg) {
    for (Player all : ) {
      all.sendMessage("§7 §8»");
      all.sendMessage(" §f" + p.getName() + "§8: §a§l" + msg);
      all.sendMessage("§7 §8»");
    }
  }
}
