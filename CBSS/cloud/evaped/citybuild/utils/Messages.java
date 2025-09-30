package cloud.evaped.citybuild.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Messages
{
  public Messages() {}
  
  public static void updateMessagesFile()
  {
    File FILE = new File("plugins/CityBuild/", "messages.yml");
    FileConfiguration file = YamlConfiguration.loadConfiguration(FILE);
    
    file.addDefault("message.feedyou", "You are now saturated.");
    file.addDefault("message.feedother", "&e%PLAYER% &7is now saturated.");
    file.addDefault("message.healyou", "You are now healed.");
    file.addDefault("message.healother", "&e%PLAYER% &7is now healed.");
    file.addDefault("message.flynotgamemode", "Your gamemode isn't &fSURVIVAL&7.");
    file.addDefault("message.flytrue", "You can fly now.");
    file.addDefault("message.flyfalse", "You can not fly anymore.");
    file.addDefault("message.flyothernotgamemode", "&e%PLAYER%&7's gamemode isn't &fSURVIVAL&7.");
    file.addDefault("message.flyothertrue", "&e%PLAYER% &7can fly now.");
    file.addDefault("message.flyotherfalse", "&e%PLAYER% &7can not fly anymore.");
    file.addDefault("message.gamemode0you", "&7Your gamemode is now &fSURVIVAL&7.");
    file.addDefault("message.gamemode1you", "&7Your gamemode is now &fCREATIVE&7.");
    file.addDefault("message.gamemode2you", "&7Your gamemode is now &fADVENTURE&7.");
    file.addDefault("message.gamemode3you", "&7Your gamemode is now &fSPECTATOR&7.");
    file.addDefault("message.gamemode0other", "&e%PLAYER%&7's gamemode is now &fSURVIVAL&7.");
    file.addDefault("message.gamemode1other", "&e%PLAYER%&7's gamemode is now &fCREATIVE&7.");
    file.addDefault("message.gamemode2other", "&e%PLAYER%&7's gamemode is now &fADVENTURE&7.");
    file.addDefault("message.gamemode3other", "&e%PLAYER%&7's gamemode is now &fSPECTATOR&7.");
    file.addDefault("message.msgsender", "&7You &8➟ &6%PLAYER%&8: &7%MESSAGE%");
    file.addDefault("message.msgtarget", "&7&6%PLAYER% &8➟ &7You&8: &7%MESSAGE%");
    file.addDefault("message.msgblocked", "This player has enabled the msgtoggle.");
    file.addDefault("message.msgnorank", "&7The Player &6%PLAYER% &7can't use the msg feauture, because he has no &6premium membership&7.");
    file.addDefault("message.teleport", "You will be teleported in &63sec&7. Do not move!");
    file.addDefault("message.teleportCancel", "You teleportation has been canceld, because you moved!");
    file.addDefault("message.startcoins", Integer.valueOf(2000));
    file.addDefault("message.yourcoins", "You have &e%VALUE%&7.");
    file.addDefault("message.msgtoggleleave", "You &cleft &7the msg toggle mode.");
    file.addDefault("message.msgtogglejoin", "You &ajoined &7the msg toggle mode.");
    file.addDefault("message.msgtogglereminder", "You &aactivated &7the msg-toggle mode!");
    file.addDefault("message.tablist", Boolean.valueOf(true));
    file.addDefault("message.tablist_header", "&r\n&8» &6&lServer&8.&6&lnet &8«\n&r\n&e♬ &8┃ &7Every day &c18&8:&c00 &7Event\n&r\n&8&m------------&7&m[&8&m-------&7&m]&8&m------------");
    file.addDefault("message.tablist_footer", "&8&m------------&7&m[&8&m-------&7&m]&8&m------------\n&r\n§e✪ &8┃ &7TeamSpeak&8: &6ts&7.&6Server&7.&6net\n§e✁ &8┃ &7Web&8: &6web&7.&6Server&7.&6net\n&r");
    
    cloud.evaped.citybuild.main.CityBuildCore.saveFile(file, FILE);
  }
  
  public static HashMap<String, Object> getObject_messages = new HashMap();
  
  public void loadData_Messages()
  {
    File file = new File("plugins/CityBuild/", "messages.yml");
    FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
    
    if (cfg.getConfigurationSection("message") != null) {
      for (String key : cfg.getConfigurationSection("message").getKeys(false)) {
        Object o = cfg.get("message." + key);
        if ((o instanceof String)) {
          String s = (String)o;
          o = s.replaceAll("&", "§");
        } else if ((o instanceof List)) {
          List<?> list = (List)o;
          if ((list.size() > 0) && 
            ((list.get(0) instanceof String)))
          {
            List<String> list1 = (List)o;
            List<String> list2 = new ArrayList();
            for (String s : list1) {
              list2.add(s.replaceAll("&", "§"));
            }
            o = list2;
          }
        }
        
        getObject_messages.put("message." + key, o);
      }
    }
    try
    {
      cfg.save(file);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
