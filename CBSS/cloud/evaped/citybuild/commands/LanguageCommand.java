package cloud.evaped.citybuild.commands;

import cloud.evaped.citybuild.main.CityBuildCore;
import cloud.evaped.citybuild.main.CityBuildPlugin;
import cloud.evaped.citybuild.utils.language.Language;
import cloud.evaped.citybuild.utils.language.LanguageDLCEnum;
import cloud.evaped.citybuild.utils.language.LanguageEnum;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class LanguageCommand implements org.bukkit.command.CommandExecutor
{
  public LanguageCommand() {}
  
  public boolean onCommand(CommandSender sender, org.bukkit.command.Command arg1, String arg2, String[] args)
  {
    if (sender.hasPermission("citybuild.language")) {
      if (args.length == 2)
      {
        if (args[0].equalsIgnoreCase("EN")) {
          if (args[1].equalsIgnoreCase("BASE")) {
            new Language(LanguageEnum.ENGLISH, LanguageDLCEnum.BASE, sender);
          } else if (args[1].equalsIgnoreCase("CRATES")) {
            new Language(LanguageEnum.ENGLISH, LanguageDLCEnum.CRATES, sender);
          } else if (args[1].equalsIgnoreCase("CHESTSHOP")) {
            new Language(LanguageEnum.ENGLISH, LanguageDLCEnum.CHESTSHOP, sender);
          } else if (args[1].equalsIgnoreCase("ESSENTIALS")) {
            new Language(LanguageEnum.ENGLISH, LanguageDLCEnum.ESSENTIALS, sender);
          } else if (args[1].equalsIgnoreCase("BANMANAGER")) {
            new Language(LanguageEnum.ENGLISH, LanguageDLCEnum.BANMANAGER, sender);
          } else if (args[1].equalsIgnoreCase("DISGUISE")) {
            new Language(LanguageEnum.ENGLISH, LanguageDLCEnum.DISGUISE, sender);
          } else {
            sender.sendMessage(CityBuildCore.instance.translateString(CityBuildPlugin.instance.getConfig().getString("messages.fSyntax") + "language <EN/DE> <BASE,CRATES,CHESTSHOP,BANMANAGER,DISGUISE,ESSENTIALS>").replaceAll("&", "§"));
            if ((sender instanceof Player)) {
              ((Player)sender).playSound(((Player)sender).getLocation(), org.bukkit.Sound.BAT_TAKEOFF, 1.0F, 1.0F);
            }
          }
        } else if (args[0].equalsIgnoreCase("DE")) {
          if (args[1].equalsIgnoreCase("BASE")) {
            new Language(LanguageEnum.GERMAN, LanguageDLCEnum.BASE, sender);
          } else if (args[1].equalsIgnoreCase("CRATES")) {
            new Language(LanguageEnum.GERMAN, LanguageDLCEnum.CRATES, sender);
          } else if (args[1].equalsIgnoreCase("CHESTSHOP")) {
            new Language(LanguageEnum.GERMAN, LanguageDLCEnum.CHESTSHOP, sender);
          } else if (args[1].equalsIgnoreCase("ESSENTIALS")) {
            new Language(LanguageEnum.GERMAN, LanguageDLCEnum.ESSENTIALS, sender);
          } else if (args[1].equalsIgnoreCase("BANMANAGER")) {
            new Language(LanguageEnum.GERMAN, LanguageDLCEnum.BANMANAGER, sender);
          } else if (args[1].equalsIgnoreCase("DISGUISE")) {
            new Language(LanguageEnum.GERMAN, LanguageDLCEnum.DISGUISE, sender);
          } else {
            sender.sendMessage(CityBuildCore.instance.translateString(CityBuildPlugin.instance.getConfig().getString("messages.fSyntax") + "language <EN/DE> <BASE,CRATES,CHESTSHOP,BANMANAGER,DISGUISE,ESSENTIALS>").replaceAll("&", "§"));
            if ((sender instanceof Player)) {
              ((Player)sender).playSound(((Player)sender).getLocation(), org.bukkit.Sound.BAT_TAKEOFF, 1.0F, 1.0F);
            }
          }
        } else {
          sender.sendMessage(CityBuildCore.instance.translateString(CityBuildPlugin.instance.getConfig().getString("messages.fSyntax") + "language <EN/DE> <BASE,CRATES,CHESTSHOP,BANMANAGER,DISGUISE,ESSENTIALS>").replaceAll("&", "§"));
          if ((sender instanceof Player)) {
            ((Player)sender).playSound(((Player)sender).getLocation(), org.bukkit.Sound.BAT_TAKEOFF, 1.0F, 1.0F);
          }
        }
      } else {
        sender.sendMessage(CityBuildCore.instance.translateString(CityBuildPlugin.instance.getConfig().getString("messages.fSyntax") + "language <EN/DE> <BASE,CRATES,CHESTSHOP,BANMANAGER,DISGUISE,ESSENTIALS>").replaceAll("&", "§"));
        if ((sender instanceof Player)) {
          ((Player)sender).playSound(((Player)sender).getLocation(), org.bukkit.Sound.BAT_TAKEOFF, 1.0F, 1.0F);
        }
      }
    } else {
      sender.sendMessage(CityBuildCore.instance.translateString(CityBuildPlugin.instance.getConfig().getString("messages.noPerm")));
      if ((sender instanceof Player)) {
        ((Player)sender).playSound(((Player)sender).getLocation(), org.bukkit.Sound.BAT_TAKEOFF, 1.0F, 1.0F);
      }
    }
    
    return false;
  }
}
