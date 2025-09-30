package cloud.evaped.citybuild.utils.language;

import cloud.evaped.citybuild.main.CityBuildCore;
import cloud.evaped.citybuild.main.FileManager;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Language
{
  private LanguageEnum language;
  private LanguageDLCEnum DLC;
  
  public Language(LanguageEnum language, LanguageDLCEnum DLC, CommandSender sender)
  {
    this.language = language;
    this.DLC = DLC;
    sender.sendMessage(CityBuildCore.instance.translateString("Addon §8§o" + DLC.toString() + " §7has been translated to §8§o" + language.toString()));
    ((Player)sender).playSound(((Player)sender).getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
    execute();
  }
  
  public void execute()
  {
    if (language == LanguageEnum.ENGLISH) {
      if (DLC == LanguageDLCEnum.BASE) {
        try {
          File FILE = new File("plugins/CityBuild/Inventory/", "nicksettings.yml");
          FileConfiguration file = YamlConfiguration.loadConfiguration(FILE);
          
          file.set("settings.addnickname", "Your new name is&8: &e%NAME%&7.");
          file.set("settings.removenickname", "Your name has been removed.");
          
          file.set("settings.normalstate", "&7Normal");
          file.set("settings.premiumstate", "&6Premium");
          file.set("settings.activated", "&aActivated");
          file.set("settings.deactivated", "&cDeactivated");
          file.set("settings.nick", "Your name is now&8: &c%NAME%");
          file.set("settings.unnick", "Your Nickname has been removed.");
          file.set("settings.waitfornick", "Please wait a moment, before you can use this again.");
          
          file.set("inv.settings.name", "&8» &eNick Settings");
          
          List<String> lore = new ArrayList();
          lore.add("&8&m--------------------");
          lore.add("&7Choose whether you want to be");
          lore.add("&7nicked as a normal/premium player");
          lore.add("&7");
          lore.add("&8» %STATE%");
          file.set("inv.items.premiumitem.lore", lore);
          file.set("inv.items.premiumitem.name", "&8● &6Name Type");
          
          List<String> lore1 = new ArrayList();
          lore1.add("&8&m--------------------");
          lore1.add("&7Select, if you want to be nicked by joining.");
          lore1.add("&7");
          lore1.add("&8» %STATE%");
          file.set("inv.items.autonickitem.lore", lore1);
          file.set("inv.items.autonickitem.name", "&8● &6Autonicker");
          
          CityBuildCore.saveFile(file, FILE);
        } catch (Exception localException) {}
        try {
          File FILE = new File("plugins/CityBuild/Inventory", "settings.yml");
          FileConfiguration file = YamlConfiguration.loadConfiguration(FILE);
          
          List<String> list01 = new ArrayList();
          list01.add("&8» &cGot to the plot, you want to remove and click this message to remove this plot.");
          file.set("settings.removemessage", list01);
          file.set("settings.removehover", "&cClick to remove this plot");
          
          file.set("inv.settings.name", "&8» &eSettings");
          
          List<String> lore = new ArrayList();
          lore.add("&8&m--------------------");
          lore.add("&7Create a plot.");
          file.set("inv.items.create.lore", lore);
          file.set("inv.items.create.name", "&8» &aCreate a plot");
          
          List<String> lore1 = new ArrayList();
          lore1.add("&8&m--------------------");
          lore1.add("&7Remove your plot.");
          lore1.add("&cInfo: That can't be undone!");
          file.set("inv.items.remove.lore", lore1);
          file.set("inv.items.remove.name", "&8» &cRemove your plot");
          
          List<String> lore2 = new ArrayList();
          lore2.add("&8&m--------------------");
          lore2.add("&7Teleport to your plot.");
          file.set("inv.items.home.lore", lore2);
          file.set("inv.items.home.name", "&8» &eGo to your plot");
          
          CityBuildCore.saveFile(file, FILE);
        } catch (Exception localException1) {}
        try {
          File FILE = new File("plugins/CityBuild/", "config.yml");
          FileConfiguration file = YamlConfiguration.loadConfiguration(FILE);
          file.set("messages.prefix", "§6§lCityBuild §8× §7");
          file.set("messages.noPerm", "You do §cnot have §7the permission to use this feature!");
          file.set("messages.fSyntax", "Wrong syntax. Please try this&8: &c/");
          file.set("messages.noCoins", "You do not have enough coins. You are still missing §6%COINS% §7Coins.");
          file.set("messages.noPlayer", "This Player &cdoesn't &7exists.");
          file.set("messages.notOnline", "&7This Player &cisn't &7online right now.");
          
          file.set("UCM_message", "The Command &8× &c%COMMAND% &8× &7does not exists!");
          file.set("Messages.ot_min", "%VALUE% min");
          file.set("Messages.ot_hour", "%VALUE% hours");
          file.set("Messages.noClan", "&c&l/");
          
          file.set("Maxplayers.kickmsg", "&8● &7&oThe maxmimum amount of &825 &7&oplayers has been reached. &7Please try again later. &8●");
          
          file.set("Scoreboard.name", "&6&lCity&e&lBuild");
          List<String> list02 = new ArrayList();
          list02.add("&8&m-------------");
          list02.add("");
          list02.add("&8&l× &7&lCoins");
          list02.add("&8➜ &e%COINS%");
          list02.add("");
          list02.add("&8&l× &7&lServer");
          list02.add("&8➜ &eCityBuild-1");
          list02.add("");
          list02.add("&8&l× &7&lOnlinetime");
          list02.add("&8➜ &e%TIME%");
          list02.add("");
          file.set("Scoreboard.list", list02);
          file.set("WarpSign.layout", "&8&m----&8 [&bWarp&8] &8&m----");
          file.set("WarpSign.nowarp", "This warp does not exists!");
          file.set("Villager.plotsettings.name", "&8┃ &a&lPlot settings");
          file.set("Villager.plotsettings.kind", "villager");
          file.set("Villager.firstthere.name", "&8┃ &a&lYou are new? &7Click, to get your own plot!");
          file.set("Villager.firstthere.kind", "golem");
          List<String> list03 = new ArrayList();
          list03.add("&8&m------------------------------------------------");
          list03.add("&r");
          list03.add("&r&6&lPlot Information");
          list03.add("&r");
          list03.add("&r&7On your plot, you can create your own home! Or a shop or a big farm?");
          list03.add("%CREATEPLOT%");
          list03.add("&r");
          list03.add("&8&m------------------------------------------------");
          file.set("Villager.firstthere.messages", list03);
          file.set("Villager.firstthere.createplot", "&cYou do not have a plot? Click to create one!");
          file.set("Villager.firstthere.createplotshow", "&cClick to create one!");
          file.set("Onlinetimechat.message", "You can only write in &b%TIME% &7min in the chat.");
          file.set("Loading.header", "&8● &6&lLoading &8●");
          file.set("Loading.footer", "§7⬛ ⬛ ⬛");
          file.set("Messages.noCommand", "The command &e%CMD% &7does not exists.");
          CityBuildCore.saveFile(file, FILE);
        } catch (Exception localException2) {}
        try {
          File FILE = new File("plugins/CityBuild/", "messages.yml");
          FileConfiguration file = YamlConfiguration.loadConfiguration(FILE);
          
          file.set("message.feedyou", "You are now saturated.");
          file.set("message.feedother", "&e%PLAYER% &7is now saturated.");
          file.set("message.healyou", "You are now healed.");
          file.set("message.healother", "&e%PLAYER% &7is now healed.");
          file.set("message.flynotgamemode", "Your gamemode isn't &fSURVIVAL&7.");
          file.set("message.flytrue", "You can fly now.");
          file.set("message.flyfalse", "You can not fly anymore.");
          file.set("message.flyothernotgamemode", "&e%PLAYER%&7's gamemode isn't &fSURVIVAL&7.");
          file.set("message.flyothertrue", "&e%PLAYER% &7can fly now.");
          file.set("message.flyotherfalse", "&e%PLAYER% &7can not fly anymore.");
          file.set("message.gamemode0you", "&7Your gamemode is now &fSURVIVAL&7.");
          file.set("message.gamemode1you", "&7Your gamemode is now &fCREATIVE&7.");
          file.set("message.gamemode2you", "&7Your gamemode is now &fADVENTURE&7.");
          file.set("message.gamemode3you", "&7Your gamemode is now &fSPECTATOR&7.");
          file.set("message.gamemode0other", "&e%PLAYER%&7's gamemode is now &fSURVIVAL&7.");
          file.set("message.gamemode1other", "&e%PLAYER%&7's gamemode is now &fCREATIVE&7.");
          file.set("message.gamemode2other", "&e%PLAYER%&7's gamemode is now &fADVENTURE&7.");
          file.set("message.gamemode3other", "&e%PLAYER%&7's gamemode is now &fSPECTATOR&7.");
          file.set("message.msgsender", "&7You &8➟ &6%PLAYER%&8: &7%MESSAGE%");
          file.set("message.msgtarget", "&7&6%PLAYER% &8➟ &7You&8: &7%MESSAGE%");
          file.set("message.msgblocked", "This player has enabled the msgtoggle.");
          file.set("message.msgnorank", "&7The Player &6%PLAYER% &7can't use the msg feauture, because he has no &6premium membership&7.");
          file.set("message.teleport", "You will be teleported in &63sec&7. Do not move!");
          file.set("message.teleportCancel", "You teleportation has been canceld, because you moved!");
          file.set("message.yourcoins", "You have &e%VALUE%&7.");
          file.set("message.msgtoggleleave", "You &cleft &7the msg toggle mode.");
          file.set("message.msgtogglejoin", "You &ajoined &7the msg toggle mode.");
          file.set("message.msgtogglereminder", "You &aactivated &7the msg-toggle mode!");
          
          CityBuildCore.saveFile(file, FILE);
        } catch (Exception localException3) {}
      } else if (DLC == LanguageDLCEnum.ESSENTIALS) {
        try {
          File FILE = new File("plugins/CityBuild/DLC/Essentials", "messages.yml");
          FileConfiguration file = YamlConfiguration.loadConfiguration(FILE);
          
          file.set("message.clearBypass", "This player has a bypass permission!");
          file.set("message.clearYou", "You have cleared your Inventory!");
          file.set("message.clearOther", "You have cleared the Inventory of %PLAYER%!");
          file.set("message.ccYou", "You have cleared the chat! Use &c/cc global &7to clear all players chat.");
          file.set("message.ccAll", "&6%PLAYER% &7has cleared the chat!");
          file.set("message.fixMsg", "You have been fixed!");
          file.set("message.fixTenSec", "You must wait at least &610sec&7.");
          file.set("message.killYou", "You died because of a &5mystic spell&7!");
          file.set("message.killOther", "The Player &6%PLAYER% &7is now dead.");
          file.set("message.payOverNull", "The amount must be over 0!");
          file.set("message.payMustBeNumber", "This is not a number!");
          file.set("message.payYou", "You paid &6%AMOUNT% &7to %PLAYER%.");
          file.set("message.payOther", "You received &6%AMOUNT% &7from %PLAYER%.");
          file.set("message.repair", "Your item is repaired.");
          file.set("message.skull", "You have now the skull from &6%PLAYER%&7.");
          file.set("message.speedOverNull", "The amount mst be over null and lower than 11");
          file.set("message.speedMustBeNumber", "This is not a number.");
          file.set("message.tcLayout", "&8[&cTeamChat&8] &7%PLAYER%&8: &f%MESSAGE%");
          file.set("message.timeDay", "The time is now &6Day&7.");
          file.set("message.timeNight", "The time is now &6Night&7.");
          file.set("message.timeLong", "The time is now &6%TIME%&7.");
          file.set("message.tpYou", "You have been teleported to &6%PLAYER%&7.");
          file.set("message.tpOther", "&6%PLAYER1%&7 has been teleported to &6%PLAYER2%&7.");
          file.set("message.tpYouCord", "You have been teleported to X: &6%X%&7, Y: &6%Y%&7, Z: &6%Z%&7.");
          file.set("message.tpOtherCord", "&6%PLAYER%&7 have been teleported to X: &6%X%&7, Y: &6%Y%&7, Z: &6%Z%&7.");
          file.set("message.tpaAcceptButton", "§7[§aAccept§7]");
          file.set("message.tpaDenyButton", "§7[§cDeny§7]");
          file.set("message.tpaAcceptMSG", "§aClick, to accept §8[§f/tpaccept§8]");
          file.set("message.tpaDenyMSG", "§cClick, to deny §8[§f/tpdeny§8]");
          file.set("message.tpaSend", "You send a teleporting request to &6%PLAYER%&7.");
          file.set("message.tpaGet", "You get a teleporting request from &6%PLAYER%&7. Click to:");
          file.set("message.tpaDenyYou", "You denied the request from &6%PLAYER%&7.");
          file.set("message.tpaDenyOther", "&6%PLAYER% &7denied your request.");
          file.set("message.tpaNoRequest", "You didn't get a request.");
          file.set("message.tpall", "&6%VALUE% &7players were teleported to your location.");
          file.set("message.tphere", "The Player &6%PLAYER% &7was teleported to your location.");
          file.set("message.trashInvName", "&7» &6Trash");
          file.set("message.vanishspec", "You have to leave the spectator mode, to enter the vanish mode!");
          
          List<String> list = new ArrayList();
          list.add("Requirement for &5YouTuber:");
          list.add("&8- §7100 Abos");
          list.add("&8- §75 Videos");
          list.add("&8- §71 Video from our Network");
          file.set("message.yt", list);
          file.set("message.shop", "You can find our shop here: &fhttps://bn1ck.com");
          file.set("message.ts", "You can find our ts here: &fts.bn1ck.com");
          file.set("message.adsdaily", "You can not make any advertisments today!");
          file.set("message.adsmsg", "&4&lAdvertisment &7» &f%MESSAGE%");
          file.set("message.boldtrue", "You write now &a&lbold&7.");
          file.set("message.boldfalse", "You don't write &a&lbold&7 anymore.");
          file.set("message.rename", "You renamed the item to &f%NAME%&7.");
          file.set("message.skinchange", "You &asuccsesfully &7changed your skin.");
          file.set("message.skinremove", "You &asuccsesfully &7cleared the skin.");
          file.set("message.skincooldown", "You have to wait before changing your skin again.");
          file.set("message.skincooldownalready", "You already have another skin.");
          file.set("message.skincooldownnot", "You don't have another skin.");
          file.set("message.noads_false", "You don't hide advertisments anymore.");
          file.set("message.noads_true", "You hide advertisments.");
          file.set("message.money", "Der Spieler &b%NAME% &7hat &e%COINS%&7 Coins.");
          file.set("message.moneytop", "%NAME% &8- &e%COINS% &7Coins.");
          file.set("message.tptoggle_act", "You toggle the tp.");
          file.set("message.tptoggle_deact", "You do not toggle the tp anymore.");
          file.set("message.tptoggle", "This player has activated tptoggle. Try /tpo.");
          file.set("message.tablist_header", "&r\n&8» &6&lServer&8.&6&lnet &8«\n&r\n&e♬ &8┃ &7Every day &c18&8:&c00 &7Event\n&r\n&8&m------------&7&m[&8&m-------&7&m]&8&m------------");
          file.set("message.tablist_footer", "&8&m------------&7&m[&8&m-------&7&m]&8&m------------\n&r\n§e✪ &8┃ &7TeamSpeak&8: &6ts&7.&6Server&7.&6net\n§e✁ &8┃ &7Web&8: &6web&7.&6Server&7.&6net\n&r");
          
          CityBuildCore.saveFile(file, FILE);
        } catch (Exception localException4) {}
        try {
          File FILE = new File("plugins/CityBuild/DLC/Essentials/Inventory", "Home.yml");
          FileConfiguration file = YamlConfiguration.loadConfiguration(FILE);
          
          file.set("settings.teleport", "You will be teleportet in &63sec&7. Don't move!");
          file.set("settings.cancelmsg", "The teleportation has been canceld, because you moved.");
          
          file.set("inv.settings.name", "&7» &6Homes");
          
          List<String> lore2 = new ArrayList();
          lore2.add("&8&m--------------------");
          lore2.add("&7You do not have this plot! You");
          lore2.add("&7can buy this slot for &e5000 Coins&7.");
          file.set("inv.items.notbuy.name", "&8» &4Not bought &7(&8Plot %VALUE%&7)");
          file.set("inv.items.notbuy.lore", lore2);
          
          List<String> lore3 = new ArrayList();
          lore3.add("&8&m--------------------");
          lore3.add("&7Click to set a new location!");
          file.set("inv.items.noloc.name", "&8» &6No location &7(&8Plot %VALUE%&7)");
          file.set("inv.items.noloc.lore", lore3);
          
          List<String> lore4 = new ArrayList();
          lore4.add("&8&m--------------------");
          lore4.add("&8[&7RIGHT CLICK&8] &7Set new location");
          lore4.add("&8[&7LEFT CLICK&8] &7Teleport");
          file.set("inv.items.teleport.name", "&8» &aTeleport &7(&8Plot %VALUE%&7)");
          file.set("inv.items.teleport.lore", lore4);
          
          CityBuildCore.saveFile(file, FILE);
        } catch (Exception localException5) {}
      } else if (DLC == LanguageDLCEnum.CHESTSHOP) {
        try {
          File FILE = new File("plugins/CityBuild/DLC/Shop/", "AdminShop.yml");
          FileConfiguration file = YamlConfiguration.loadConfiguration(FILE);
          
          file.set("settings.buysign", "&8&m-----&8 [&2Buy&8] &8&m-----");
          file.set("settings.buysignamount", "&7Amount: &a");
          file.set("settings.buysignprice", "&7Price&8: &a");
          file.set("settings.sellsign", "&8&m-----&8 [&6Sell&8] &8&m-----");
          file.set("settings.sellsignamount", "&7Amount: &e");
          file.set("settings.sellsignprice", "&7Price: &e");
          file.set("settings.falseitem", "You can't sell this item here.");
          file.set("settings.moreitems", "You need items to sell them here.");
          file.set("settings.needitems", "You need items in your hand to sell.");
          
          FileManager.saveFILE(file, FILE);
        } catch (Exception localException6) {}
        try {
          File FILE = new File("plugins/CityBuild/DLC/Shop/", "PlayerShop.yml");
          FileConfiguration file = YamlConfiguration.loadConfiguration(FILE);
          
          file.set("settings.signconf0", "&8&m-----------------");
          file.set("settings.signconf1", "&cDrop the item, you ");
          file.set("settings.signconf2", "&cwant so sell");
          file.set("settings.signconf3", "&8&m-----------------");
          
          file.set("settings.sign0", "&8&m-&8 [&cShop&8] &8&m-");
          file.set("settings.sign1", "&7Amount&8: &c%AMOUNT%");
          file.set("settings.sign2", "&7Price&8: &c%PRICE%");
          file.set("settings.sign3", "&8&m-----------------");
          
          file.set("settings.mysqltable", "cbshopTable");
          file.set("settings.nochest", "There must be a chest under the sign!");
          file.set("settings.outofstock", "This shop is out of stock!");
          file.set("settings.destroyshop", "You succsesfully destroyed your shop!");
          file.set("settings.mustnostock", "There must be no stock in the shop, to destroy it!");
          file.set("settings.notyourshop", "This is not your shop!");
          file.set("settings.shopfill", "This shop is being filled at the moment!");
          file.set("settings.invfull", "Your Inventory is full!");
          file.set("settings.nocoins", "You are still missing &6%COINS% &7Coins!");
          file.set("settings.alreadyedit", "Somebody already edit the shop!");
          file.set("settings.cancelFinish", "You succsesfully canceled the setup!");
          file.set("settings.cancelNoSetup", "You are not setting up a store!");
          file.set("settings.setup", "Drop the item you want to sell&8: &6&l%AMOUNT%&7x &6&l%PRICE% &6Coins");
          file.set("settings.nolizenz", "You need more lizenz to create a new store!");
          file.set("settings.someitems", "There are still some items in this store!");
          
          file.set("settings.clearlaggenable", Boolean.valueOf(true));
          file.set("settings.clearlaggOneMin", "&8× &7All items on the floor will be deleted in &6one minute &8×");
          file.set("settings.clearlaggOneSec", "&8× &7All items on the floor will be deleted in &6one second &8×");
          file.set("settings.clearlagg", "&8× &7All items on the floor will be deleted in &6%SECONDS% seconds &8×");
          file.set("settings.clearlaggFinish", "&8× &6%INT% &7items have been deleted &8×");
          file.set("settings.cleartime", Integer.valueOf(300));
          
          file.set("inv.settings.name", "&8» &eShop Modifier");
          file.set("inv.settings.size", Integer.valueOf(54));
          
          FileManager.saveFILE(file, FILE);
        }
        catch (Exception localException7) {}
        try {
          File FILE = new File("plugins/CityBuild/DLC/Shop/", "StatsMob.yml");
          FileConfiguration file = YamlConfiguration.loadConfiguration(FILE);
          
          file.set("settings.mobname", "&8┃ &a&lStats");
          file.set("settings.noCoins", "You don't have enough coins. You need &6%COINS% &7more!");
          
          file.set("inv.settings.name", "&8» &eShopmanager");
          file.set("inv.settings.name1", "&8» &eLicense shop");
          
          List<String> lore = new ArrayList();
          lore.add("&8&m--------------------");
          lore.add("&7Your alltime stats.");
          file.set("inv.items.stats.name", "&8» &aYour Sells&8: &e%SELLS%");
          file.set("inv.items.stats.lore", lore);
          
          List<String> lore1 = new ArrayList();
          lore1.add("&8&m--------------------");
          lore1.add("&7Buy some license, to create more shops!");
          file.set("inv.items.licenceshop.name", "&8» &aLicense Shop");
          file.set("inv.items.licenceshop.lore", lore1);
          
          List<String> lore2 = new ArrayList();
          lore2.add("&8&m--------------------");
          lore2.add("&7If you need more license, you can");
          lore2.add("&7buy some here!");
          file.set("inv.items.licenses.name", "&8» &e&l%SHOPS%&7 / &a&l%LICENSE%");
          file.set("inv.items.licenses.lore", lore2);
          
          List<String> lore3 = new ArrayList();
          lore3.add("&8&m--------------------");
          lore3.add("&7Price&8: &e500");
          file.set("inv.items.sell1.name", "&8» &a1 license");
          file.set("inv.items.sell1.lore", lore3);
          
          List<String> lore4 = new ArrayList();
          lore4.add("&8&m--------------------");
          lore4.add("&7Price&8: &e900");
          file.set("inv.items.sell2.name", "&8» &a2 license");
          file.set("inv.items.sell2.lore", lore4);
          
          List<String> lore5 = new ArrayList();
          lore5.add("&8&m--------------------");
          lore5.add("&bBEST CHOICE!");
          lore5.add("&7Price&8: &e2000");
          file.set("inv.items.sell3.name", "&8» &a5 license");
          file.set("inv.items.sell3.lore", lore5);
          
          List<String> lore6 = new ArrayList();
          lore6.add("&8&m--------------------");
          lore6.add("&7Price&8: &e3800");
          file.set("inv.items.sell4.name", "&8» &a10 license");
          file.set("inv.items.sell4.lore", lore6);
          CityBuildCore.saveFile(file, FILE);
        } catch (Exception localException8) {}
      } else if (DLC == LanguageDLCEnum.CRATES) {
        try {
          File FILE = new File("plugins/CityBuild/DLC/Crates/Animation", "Run.yml");
          FileConfiguration file = YamlConfiguration.loadConfiguration(FILE);
          file.set("inv.settings.name", "&8» &eLoad win...");
          file.set("inv.items.win.name", "&7» &6Your win");
          FileManager.saveFILE(file, FILE);
        } catch (Exception localException9) {}
        try {
          File FILE = new File("plugins/CityBuild/DLC/Crates/Animation", "End.yml");
          FileConfiguration file = YamlConfiguration.loadConfiguration(FILE);
          file.set("inv.settings.name", "&8» &eYour win");
          FileManager.saveFILE(file, FILE);
        } catch (Exception localException10) {}
        try {
          File FILE = new File("plugins/CityBuild/DLC/Crates/Inventory", "Books.yml");
          FileConfiguration file = YamlConfiguration.loadConfiguration(FILE);
          
          file.set("settings.coins", "You get &e%VALUE% &7coins!");
          file.set("settings.perms", "You get new skills!");
          file.set("settings.permscommand", "pex user %PLAYER% add %VALUE%");
          file.set("settings.alreadyperms", "You already have this skill!");
          file.set("settings.ranks", "You get a new rank&8: &f%VALUE%");
          file.set("settings.rankcommand", "pex user %PLAYER% group set %VALUE%");
          
          List<String> lore = new ArrayList();
          lore.add("&8&m--------------------");
          lore.add("&7Get some nice coins!");
          file.set("books.coins.name", "&8» &e&lCoin - Book&7: &f%VALUE%");
          file.set("books.coins.lore", lore);
          
          List<String> lore1 = new ArrayList();
          lore1.add("&8&m--------------------");
          lore1.add("&7Get this permission!");
          file.set("books.perms.name", "&8» &a&lPerm - Book&7: &f%VALUE%");
          file.set("books.perms.lore", lore1);
          
          List<String> lore2 = new ArrayList();
          lore2.add("&8&m--------------------");
          lore2.add("&7Get this Rank!");
          lore2.add("&cThere are no refunds!");
          file.set("books.rank.name", "&8» &2&lRank - Book&7: &f%VALUE%");
          file.set("books.rank.lore", lore2);
          
          FileManager.saveFILE(file, FILE);
        } catch (Exception localException11) {}
        try {
          File FILE = new File("plugins/CityBuild/DLC/Crates/Inventory", "Preview.yml");
          FileConfiguration file = YamlConfiguration.loadConfiguration(FILE);
          
          file.set("inv.settings.name", "&8» &ePreview");
          
          FileManager.saveFILE(file, FILE);
        } catch (Exception localException12) {}
        try {
          File FILE = new File("plugins/CityBuild/DLC/Crates/Inventory", "Keys.yml");
          FileConfiguration file = YamlConfiguration.loadConfiguration(FILE);
          
          file.set("settings.notkey", "Please hold a key in your hand!");
          file.set("settings.invfull", "Your inventory is full!");
          
          List<String> lore = new ArrayList();
          lore.add("&8&m--------------------");
          lore.add("&7Go to a &bvote crate");
          lore.add("&7and redeem this key!");
          file.set("keys.vote.name", "&8» &bVote key");
          file.set("keys.vote.lore", lore);
          
          List<String> lore1 = new ArrayList();
          lore1.add("&8&m--------------------");
          lore1.add("&7Go to a &9rare crate");
          lore1.add("&7and redeem this key!");
          file.set("keys.crate1.name", "&8» &9Rare key");
          file.set("keys.crate1.lore", lore1);
          
          List<String> lore2 = new ArrayList();
          lore2.add("&8&m--------------------");
          lore2.add("&7Go to a &6epic crate");
          lore2.add("&7and redeem this key!");
          file.set("keys.crate2.name", "&8» &6Epic key");
          file.set("keys.crate2.lore", lore2);
          
          List<String> lore3 = new ArrayList();
          lore3.add("&8&m--------------------");
          lore3.add("&7Go to a &5legendary crate");
          lore3.add("&7and redeem this key!");
          file.set("keys.crate3.name", "&8» &5Legendary key");
          file.set("keys.crate3.lore", lore3);
          
          List<String> lore4 = new ArrayList();
          lore4.add("&8&m--------------------");
          lore4.add("&7Go to a &esummer crate");
          lore4.add("&7and redeem this key!");
          file.set("keys.crate4.name", "&8» &eSummer key");
          file.set("keys.crate4.lore", lore4);
          
          CityBuildCore.saveFile(file, FILE);
        } catch (Exception localException13) {}
        try {
          File FILE = new File("plugins/CityBuild/DLC/Crates/Inventory", "Keysshop.yml");
          FileConfiguration file = YamlConfiguration.loadConfiguration(FILE);
          
          file.set("settings.mobname", "&8● &6Key Shop &8●");
          file.set("settings.key1bought", "You bought one &9rare key &7for &e300 coins&7.");
          file.set("settings.key2bought", "You bought one &6epic key &7for &b600 coins&7.");
          file.set("settings.key3bought", "You bought one &5legendary key &7for &b1000 coins&7.");
          file.set("settings.key4bought", "You bought one &esummer key &7for &b1400 coins&7.");
          file.set("inv.settings.name", "&8» &eKey Shop");
          
          List<String> lore4 = new ArrayList();
          lore4.add("&8&m--------------------");
          lore4.add("&7Buy one &9rare key&7!");
          lore4.add("&7Price&8: &e300");
          file.set("inv.items.key1.name", "&8» &9Rare key");
          file.set("inv.items.key1.lore", lore4);
          
          List<String> lore5 = new ArrayList();
          lore5.add("&8&m--------------------");
          lore5.add("&7Buy one &eepic key&7!");
          lore5.add("&7Price&8: &e600");
          file.set("inv.items.key2.name", "&8» &6Epic key");
          file.set("inv.items.key2.lore", lore5);
          
          List<String> lore6 = new ArrayList();
          lore6.add("&8&m--------------------");
          lore6.add("&7Buy one &5legendary key&7!");
          lore6.add("&7Price&8: &e1000");
          file.set("inv.items.key3.name", "&8» &5Legendary key");
          file.set("inv.items.key3.lore", lore6);
          
          List<String> lore7 = new ArrayList();
          lore7.add("&8&m--------------------");
          lore7.add("&7Buy one &esummer key&7!");
          lore7.add("&7Price&8: &e1400");
          file.set("inv.items.key4.name", "&8» &eSummer key");
          file.set("inv.items.key4.lore", lore7);
          
          FileManager.saveFILE(file, FILE);
        } catch (Exception localException14) {}
      } else if (DLC == LanguageDLCEnum.BANMANAGER) {
        try {
          File FILE = new File("plugins/CityBuild/DLC/BanManager/Ban", "settings.yml");
          FileConfiguration file = YamlConfiguration.loadConfiguration(FILE);
          
          file.set("settings.banmessage", "&4You are banned from the Server. \n &7Reason&8: &a%REASON% \n \n &7Time&8: &a%HOWLONG%\n&7By&8: &a%BY% \n &7Date&8: &a%DATE% &7- &a%TIME%\n&7");
          
          file.set("settings.timeperm", "§4PERMANENT");
          file.set("settings.timelayout", "§a%DAY% d, %HOUR% h, %MIN% m, %SEC% s");
          List<String> list1 = new ArrayList();
          list1.add("&a&lNew Ban &7from &2%BY%");
          list1.add("&8");
          list1.add("&7Banned Player&8: &a%PLAYER%");
          list1.add("&7Time&8: &a%TIME%");
          list1.add("&7Reason&8: &a%REASON%");
          file.set("settings.banmsglong", list1);
          file.set("settings.noplayer", "This Player does not exist!");
          file.set("settings.notbanned", "This Player is not banned!");
          file.set("settings.unbanned", "The Player &4%NAME% &7is unbanned by &f%EXECUTOR%&7!");
          file.set("settings.banlistlayout", "&8[&7#&a%INT%&8] &7%REASON% &8- &7%TIME%");
          List<String> list2 = new ArrayList();
          list2.add("_Suffix_");
          file.set("settings.cantban", list2);
          file.set("settings.banpointspermban", Integer.valueOf(5));
          
          FileManager.saveFILE(file, FILE);
        } catch (Exception localException15) {}
        try {
          File FILE = new File("plugins/CityBuild/DLC/BanManager/", "check.yml");
          FileConfiguration file = YamlConfiguration.loadConfiguration(FILE);
          
          file.set("settings.unban", "Click this message to unban &a%PLAYER%&7.");
          file.set("settings.unbanhover", "Click to unban &a%PLAYER%&7.");
          file.set("settings.unmute", "Click to unmute &a%PLAYER%&7.");
          file.set("settings.unmutehover", "Click this message to unmute &a%PLAYER%&7.");
          
          file.set("inv.settings.name", "&7» &6Check Player");
          
          List<String> lore = new ArrayList();
          lore.add("&8&m--------------------");
          lore.add("&7This player is banned:");
          lore.add("&7Time&8: &c%HOWLONG%");
          lore.add("&7By&8: &c%BY%");
          lore.add("&7Reason&8: &c%REASON%");
          lore.add("&7Date&8: &c%DATE% &7- &c%TIME%");
          
          file.set("inv.items.bantrue.name", "&8» &4Ban");
          file.set("inv.items.bantrue.lore", lore);
          
          List<String> lore1 = new ArrayList();
          lore1.add("&8&m--------------------");
          lore1.add("&7This player is muted:");
          lore1.add("&7Time&8: &c%HOWLONG%");
          lore1.add("&7By&8: &c%BY%");
          lore1.add("&7Reason&8: &c%REASON%");
          lore1.add("&7Date&8: &c%DATE% &7- &c%TIME%");
          
          file.set("inv.items.mutetrue.name", "&8» &4Mute");
          file.set("inv.items.mutetrue.lore", lore1);
          
          List<String> lore2 = new ArrayList();
          lore2.add("&8&m--------------------");
          lore2.add("&7This player is not banned.");
          
          file.set("inv.items.banfalse.name", "&8» &aBan");
          file.set("inv.items.banfalse.lore", lore2);
          
          List<String> lore3 = new ArrayList();
          lore3.add("&8&m--------------------");
          lore3.add("&7This player is not muted.");
          
          file.set("inv.items.mutefalse.name", "&8» &aMute");
          file.set("inv.items.mutefalse.lore", lore3);
          
          file.set("inv.items.stats.name", "&8» &aPlayer&8: %NAME%");
          
          FileManager.saveFILE(file, FILE);
        } catch (Exception localException16) {}
        try {
          File FILE = new File("plugins/CityBuild/DLC/BanManager/", "utils.yml");
          FileConfiguration file = YamlConfiguration.loadConfiguration(FILE);
          
          file.set("settings.maintenance", Boolean.valueOf(false));
          file.set("settings.kickmessagemaintenance", "&cThis server is in maintence mode! \n &7We are working on our systems to improve our \n &7network. &8Try again later! \n \n &bTwitter&8: &f@evapedcloud \n &9WebSite&8: &fhttps://bn1ck.com");
          file.set("settings.deactivated", "The maintence mode is now &cdeactivated&7!");
          file.set("settings.activated", "The maintence mode is now &aactivated&7!");
          file.set("settings.kickmessage", "&7You were kicked from the server.");
          file.set("settings.kickmessagereason", "&7You were kicked from the server. \n &7Reason&8: &c%REASON%");
          file.set("settings.cantkick", "You can not kick this player.");
          file.set("settings.kickall", "You kicked &6%INT% &7players from the server.");
          
          FileManager.saveFILE(file, FILE);
        } catch (Exception localException17) {}
        try {
          File FILE = new File("plugins/CityBuild/DLC/BanManager/Mute", "settings.yml");
          FileConfiguration file = YamlConfiguration.loadConfiguration(FILE);
          
          file.set("settings.mutemessage", "&4You have been muted. &7Reason&8: &a%REASON%&7, Time&8: &a%HOWLONG%&7, By&8: &a%BY%&7, Date&8: &a%DATE% &7- &a%TIME%\n&7");
          file.set("settings.timeperm", "§4PERMANENT");
          file.set("settings.timelayout", "§a%DAY% d, %HOUR% h, %MIN% m, %SEC% s");
          List<String> list1 = new ArrayList();
          list1.add("&a&lNew Mute &7from &2%BY%");
          list1.add("&8");
          list1.add("&7Muted Player&8: &a%PLAYER%");
          list1.add("&7Time&8: &a%TIME%");
          list1.add("&7Reason&8: &a%REASON%");
          file.set("settings.mutemsglong", list1);
          file.set("settings.mutemsgshort", "New Mute&8: &4%NAME% &8(&f%TIME%&8) &7- &c%REASON%");
          file.set("settings.noplayer", "This Player does not exist!");
          file.set("settings.notmuted", "This Player is not muted!");
          file.set("settings.unmuted", "The Player &4%NAME% &7is unmuted by &f%EXECUTOR%&7!");
          file.set("settings.mutelistlayout", "&8[&7#&a%INT%&8] &7%REASON% &8- &7%TIME%");
          List<String> list2 = new ArrayList();
          list2.add("_Suffix_");
          file.set("settings.cantmute", list2);
          file.set("settings.banpointspermmute", Integer.valueOf(5));
          
          FileManager.saveFILE(file, FILE);
        } catch (Exception localException18) {}
        try {
          File FILE = new File("plugins/CityBuild/DLC/BanManager/Report", "confirm.yml");
          FileConfiguration file = YamlConfiguration.loadConfiguration(FILE);
          
          file.set("inv.settings.name", "&7» &6Bestätigung");
          
          List<String> lore = new ArrayList();
          lore.add("&8&m--------------------");
          lore.add("&8➟ &7%REASON%");
          file.set("inv.items.reason.subid", "&8» &aYour reason&8:");
          file.set("inv.items.reason.enchant", lore);
          
          List<String> lore1 = new ArrayList();
          lore1.add("&8&m--------------------");
          lore1.add("&7Click, to report this player.");
          lore1.add("&7Every abuse will be punished.");
          file.set("inv.items.confirmation.subid", "&8» &aConfirm your action");
          file.set("inv.items.confirmation.enchant", lore1);
          
          List<String> lore4 = new ArrayList();
          file.set("inv.items.player.subid", "&8» &7Player&8: &a%PLAYER%");
          file.set("inv.items.player.enchant", lore4);
          
          FileManager.saveFILE(file, FILE);
        } catch (Exception localException19) {}
        try {
          File FILE = new File("plugins/CityBuild/DLC/BanManager/Report", "interface.yml");
          FileConfiguration file = YamlConfiguration.loadConfiguration(FILE);
          
          file.set("settings.reportteam", "New Report&8: &c%TARGET% &8(&7Reason&8: &4%REASON%&8) &7by&8: &a%PLAYER%");
          file.set("settings.reportteamhover", "&7Click to claim this report.");
          
          file.set("settings.notOnline", "&7This Player is not online.");
          file.set("settings.delay", Integer.valueOf(30));
          file.set("settings.delaymsg", "You must wait at least &e30 sec&7 to report a player again!");
          file.set("settings.alreadyreport", "Thanks for your report, but this player is already reported!");
          file.set("settings.invalidsession", "Invalid Session. Please try again!");
          
          file.set("settings.reportclose", "You closed the report of &6%PLAYER%&7!");
          file.set("settings.reportcloseleft", "The report of &6%PLAYER%&7 has been closed, because the player left the game!");
          file.set("settings.reportclaim", "You claimed the report of &6%PLAYER%&7!");
          file.set("settings.alreadyclaim", "This report is already claimed!");
          file.set("settings.notReport", "This player is not reported!");
          file.set("settings.cannowreport", "You can now report players again!");
          file.set("settings.reportconfirm", "Thanks for your report, a teammember will claim your report.");
          
          file.set("inv.settings.name", "&7» &6Unclaimed reports");
          
          List<String> lore = new ArrayList();
          lore.add("&8&m--------------------");
          lore.add("&7Reporter&8: &c%PLAYER%");
          lore.add("&7Reason&8: &c%REASON%");
          file.set("inv.items.player.name", "&8» &aReport&8: &c%TARGET%");
          file.set("inv.items.player.lore", lore);
          
          List<String> lore3 = new ArrayList();
          lore3.add("&8&m--------------------");
          lore3.add("&7There are no reports");
          file.set("inv.items.noreports.name", "&8» &cNo reports");
          file.set("inv.items.noreports.lore", lore);
          
          FileManager.saveFILE(file, FILE);
        } catch (Exception localException20) {}
      } else if (DLC == LanguageDLCEnum.DISGUISE) {
        try {
          File FILE = new File("plugins/CityBuild/DLC/Disguise", "inventory.yml");
          FileConfiguration file = YamlConfiguration.loadConfiguration(FILE);
          List<String> list1 = new ArrayList();
          list1.add("&8&m--------------------");
          list1.add("&aYou can &2disguise &ain that");
          list1.add("&amob!");
          file.set("settings.lore_perms", list1);
          
          List<String> list2 = new ArrayList();
          list2.add("&8&m--------------------");
          list2.add("&cYou can't &4disguise &cin that");
          list2.add("&cmob! You need a &6premium membershop&c,");
          list2.add("&cto execute this action!");
          file.set("settings.lore_perms_not", list2);
          file.set("settings.disguised", "You are already disguised. /undisguise to disguise again.");
          file.set("settings.disguised_not", "You are not disguised. /disguise to disguise.");
          
          CityBuildCore.saveFile(file, FILE);


        }
        catch (Exception localException21) {}

      }
      


    }
    else if (DLC == LanguageDLCEnum.BASE) {
      try {
        File FILE = new File("plugins/CityBuild/Inventory/", "nicksettings.yml");
        FileConfiguration file = YamlConfiguration.loadConfiguration(FILE);
        
        file.set("settings.addnickname", "Dein Name ist nun&8: &e%NAME%&7.");
        file.set("settings.removenickname", "Dein Nickname wurde entfernt.");
        
        file.set("settings.normalstate", "&7Normal");
        file.set("settings.premiumstate", "&6Premium");
        file.set("settings.activated", "&aAktiviert");
        file.set("settings.deactivated", "&cDeaktiviert");
        file.set("settings.nick", "Dein Name ist nun&8: &c%NAME%");
        file.set("settings.unnick", "Dein Nickname wurde entfernt.");
        file.set("settings.waitfornick", "Bitte warte einen moment, bevor du dies wieder nutzen kannst.");
        
        file.set("inv.settings.name", "&8» &eNick Settings");
        
        List<String> lore = new ArrayList();
        lore.add("&8&m--------------------");
        lore.add("&7Wähle, ob du als Premium, oder als");
        lore.add("&7normaler Spieler genickt werden willst.");
        lore.add("&7");
        lore.add("&8» %STATE%");
        file.set("inv.items.premiumitem.lore", lore);
        file.set("inv.items.premiumitem.name", "&8● &6Name Type");
        
        List<String> lore1 = new ArrayList();
        lore1.add("&8&m--------------------");
        lore1.add("&7Wähle, ob du beim joinen genickt");
        lore1.add("&7werden willst.");
        lore1.add("&7");
        lore1.add("&8» %STATE%");
        file.set("inv.items.autonickitem.lore", lore1);
        file.set("inv.items.autonickitem.name", "&8● &6Autonicker");
        
        CityBuildCore.saveFile(file, FILE);
      } catch (Exception localException22) {}
      try {
        File FILE = new File("plugins/CityBuild/Inventory", "settings.yml");
        FileConfiguration file = YamlConfiguration.loadConfiguration(FILE);
        
        List<String> list01 = new ArrayList();
        list01.add("&8» &cGehe zu deinem Plot, welches du entfernen möchtest, und klicke diese Nachricht an.");
        file.set("settings.removemessage", list01);
        file.set("settings.removehover", "&cKlicke, um das Plot zu löschen");
        
        file.set("inv.settings.name", "&8» &eEinstellungen");
        
        List<String> lore = new ArrayList();
        lore.add("&8&m--------------------");
        lore.add("&7Erstelle ein plot.");
        file.set("inv.items.create.lore", lore);
        file.set("inv.items.create.name", "&8» &aPlot erstellen");
        
        List<String> lore1 = new ArrayList();
        lore1.add("&8&m--------------------");
        lore1.add("&7Entferne ein Plot.");
        lore1.add("&cInfo: Dies kann nicht rückgängig gemacht werden!");
        file.set("inv.items.remove.lore", lore1);
        file.set("inv.items.remove.name", "&8» &cPlot löschen");
        
        List<String> lore2 = new ArrayList();
        lore2.add("&8&m--------------------");
        lore2.add("&7Teleportiere dich zu deinem Plot.");
        file.set("inv.items.home.lore", lore2);
        file.set("inv.items.home.name", "&8» &eZum Plot teleportieren");
        
        CityBuildCore.saveFile(file, FILE);
      } catch (Exception localException23) {}
      try {
        File FILE = new File("plugins/CityBuild/", "config.yml");
        FileConfiguration file = YamlConfiguration.loadConfiguration(FILE);
        file.set("messages.prefix", "§6§lCityBuild §8× §7");
        file.set("messages.noPerm", "Du hast nicht die benötigten Recht, um dies zu nutzen!");
        file.set("messages.fSyntax", "Falsche Zusammensetzung. Probiere dies&8: &c/");
        file.set("messages.noCoins", "Du hast nicht genügend Coins. Dir fehlen noch §6%COINS% §7Coins.");
        file.set("messages.noPlayer", "Der Spieler existiert nicht.");
        file.set("messages.notOnline", "Der Spieler ist momentan nicht online.");
        
        file.set("UCM_message", "Der Befehl &8× &c%COMMAND% &8× &7existiert nicht!");
        file.set("Messages.ot_min", "%VALUE% Min");
        file.set("Messages.ot_hour", "%VALUE% Stunden");
        file.set("Messages.noClan", "&c&l/");
        
        file.set("Maxplayers.kickmsg", "&8● &7&oDie maximale Anzahl an &825 &7&oSpielern wurde erreicht. &7Versuche es später nochmal. &8●");
        
        file.set("Scoreboard.name", "&6&lCity&e&lBuild");
        List<String> list02 = new ArrayList();
        list02.add("&8&m-------------");
        list02.add("");
        list02.add("&8&l× &7&lCoins");
        list02.add("&8➜ &e%COINS%");
        list02.add("");
        list02.add("&8&l× &7&lServer");
        list02.add("&8➜ &eCityBuild-1");
        list02.add("");
        list02.add("&8&l× &7&lOnlinezeit");
        list02.add("&8➜ &e%TIME%");
        list02.add("");
        file.set("Scoreboard.list", list02);
        file.set("WarpSign.layout", "&8&m----&8 [&bWarp&8] &8&m----");
        file.set("WarpSign.nowarp", "Dieser Warp existiert nicht!");
        file.set("Villager.plotsettings.name", "&8┃ &a&lPlot Einstellungen");
        file.set("Villager.firstthere.name", "&8┃ &a&lDu bist neu? &7Klicke um ein Plot zu erstellen!");
        List<String> list03 = new ArrayList();
        list03.add("&8&m------------------------------------------------");
        list03.add("&r");
        list03.add("&r&6&lPlot Informationen");
        list03.add("&r");
        list03.add("&r&7Auf deinem Plot kannst du dein eigenes Haus bauen! Oder ein Shop oder eine große Farm?");
        list03.add("%CREATEPLOT%");
        list03.add("&r");
        list03.add("&8&m------------------------------------------------");
        file.set("Villager.firstthere.messages", list03);
        file.set("Villager.firstthere.createplot", "&cDu hast noch kein Plot? Klicke, um ein Plot zu erstellen!");
        file.set("Villager.firstthere.createplotshow", "&cKlicke, um ein Plot zu erstellen!");
        file.set("Onlinetimechat.message", "Du kannst erst in &b%TIME% &7Minuten in den Chat schreiben.");
        file.set("Loading.header", "&8● &6&lLade &8●");
        file.set("Loading.footer", "§7⬛ ⬛ ⬛");
        file.set("Messages.noCommand", "Der Befehl &e%CMD% &7existiert nicht.");
        CityBuildCore.saveFile(file, FILE);
      } catch (Exception localException24) {}
      try {
        File FILE = new File("plugins/CityBuild/", "messages.yml");
        FileConfiguration file = YamlConfiguration.loadConfiguration(FILE);
        
        file.set("message.feedyou", "Du bist nun gesättigt.");
        file.set("message.feedother", "&e%PLAYER% &7ist nun gesättigt.");
        file.set("message.healyou", "Du bist nun geheilt.");
        file.set("message.healother", "&e%PLAYER% &7ist nun geheilt.");
        file.set("message.flynotgamemode", "Du musst im &fSURVIVAL&7 Gamemode sein.");
        file.set("message.flytrue", "Du kannst nun fliegen.");
        file.set("message.flyfalse", "Du kannst nicht mehr fliegen.");
        file.set("message.flyothernotgamemode", "&e%PLAYER%&7's Gamemode ist nicht &fSURVIVAL&7.");
        file.set("message.flyothertrue", "&e%PLAYER% &7kann nun fliegen.");
        file.set("message.flyotherfalse", "&e%PLAYER% &7kann nicht mehr fliegen.");
        file.set("message.gamemode0you", "&7Dein Spielmodus ist nun &fSURVIVAL&7.");
        file.set("message.gamemode1you", "&7Dein Spielmodus ist nun &fCREATIVE&7.");
        file.set("message.gamemode2you", "&7Dein Spielmodus ist nun &fADVENTURE&7.");
        file.set("message.gamemode3you", "&7Dein Spielmodus ist nun &fSPECTATOR&7.");
        file.set("message.gamemode0other", "&e%PLAYER%&7's Spielmodus ist nun &fSURVIVAL&7.");
        file.set("message.gamemode1other", "&e%PLAYER%&7's Spielmodus ist nun &fCREATIVE&7.");
        file.set("message.gamemode2other", "&e%PLAYER%&7's Spielmodus ist nun &fADVENTURE&7.");
        file.set("message.gamemode3other", "&e%PLAYER%&7's Spielmodus ist nun &fSPECTATOR&7.");
        file.set("message.msgsender", "&7Du &8➟ &6%PLAYER%&8: &7%MESSAGE%");
        file.set("message.msgtarget", "&7&6%PLAYER% &8➟ &7Dir&8: &7%MESSAGE%");
        file.set("message.msgblocked", "Der Spieler hat Private Nachrichten deaktiviert.");
        file.set("message.msgnorank", "&7Der Spieler &6%PLAYER% &7kann das private Nachrichten Feature nicht nutzen, der er kein &6Premium&7 Spieler ist.");
        file.set("message.teleport", "Du wirst in &63sec&7 teleportiert. Nicht bewegen!");
        file.set("message.teleportCancel", "Deine Teleportation wurde abgebrochen, da du dich bewegt hast!");
        file.set("message.yourcoins", "Du hast &e%VALUE%&7 coins.");
        file.set("message.msgtoggleleave", "Du hast den private Nachrichten Toggle verlassen.");
        file.set("message.msgtogglejoin", "Du hast den private Nachrichten Toggle betreten.");
        file.set("message.msgtogglereminder", "Du hast private Nachrichten &cdeaktiviert&7!");
        
        CityBuildCore.saveFile(file, FILE);
      } catch (Exception localException25) {}
    } else if (DLC == LanguageDLCEnum.ESSENTIALS) {
      try {
        File FILE = new File("plugins/CityBuild/DLC/Essentials", "messages.yml");
        FileConfiguration file = YamlConfiguration.loadConfiguration(FILE);
        
        file.set("message.clearBypass", "Der Spieler hat eine Bypass Permission!");
        file.set("message.clearYou", "Du hast dein Inventar geleert!");
        file.set("message.clearOther", "Du hast das Inventar von %PLAYER% geleert!");
        file.set("message.ccYou", "Du hast den Chat geleert! Nutze &c/cc global &7um für jeden Spieler den Chat zu leeren.");
        file.set("message.ccAll", "&6%PLAYER% &7hat den chat geleert!");
        file.set("message.fixMsg", "Du wurdest gefixt!");
        file.set("message.fixTenSec", "Du musst &610sec&7 warten.");
        file.set("message.killYou", "Du wurdest von einem &5Zauber&7 getötet!");
        file.set("message.killOther", "Der Spieler &6%PLAYER% &7ist nun tot.");
        file.set("message.payOverNull", "Der Wert muss größer als 0 sein!");
        file.set("message.payMustBeNumber", "Das ist keine Zahl!");
        file.set("message.payYou", "Du hast &6%AMOUNT% &7an %PLAYER% gezahlt.");
        file.set("message.payOther", "Du hast &6%AMOUNT% &7von %PLAYER% bekommen.");
        file.set("message.repair", "Dein Item wurde reperiert.");
        file.set("message.skull", "Du hast nun den Kopf von &6%PLAYER%&7.");
        file.set("message.speedOverNull", "Der Wert muss über 0 und kleiner als 11 sein");
        file.set("message.speedMustBeNumber", "Dies ist keine Zahl.");
        file.set("message.tcLayout", "&8[&cTeamChat&8] &7%PLAYER%&8: &f%MESSAGE%");
        file.set("message.timeDay", "Die Zeit ist nun auf &6Tag&7 gestellt.");
        file.set("message.timeNight", "Die Zeit ist nun auf &6Nacht&7 gestellt.");
        file.set("message.timeLong", "Die Zeit ist nun auf &6%TIME%&7 gestellt.");
        file.set("message.tpYou", "Du wurdest zu &6%PLAYER%&7 teleportiert.");
        file.set("message.tpOther", "&6%PLAYER1%&7 wurde zu &6%PLAYER2%&7 teleportiert.");
        file.set("message.tpYouCord", "Du wurdest zu folgenden Koordinaten teleportiert: X: &6%X%&7, Y: &6%Y%&7, Z: &6%Z%&7.");
        file.set("message.tpOtherCord", "&6%PLAYER%&7 wurde zu folgenden Koordinaten teleportiert: X: &6%X%&7, Y: &6%Y%&7, Z: &6%Z%&7.");
        file.set("message.tpaAcceptButton", "§7[§aAnnehmen§7]");
        file.set("message.tpaDenyButton", "§7[§cAblehnen§7]");
        file.set("message.tpaAcceptMSG", "§aKlicke, um anzunehmen §8[§f/tpaccept§8]");
        file.set("message.tpaDenyMSG", "§cKlicke, um abzulehnen §8[§f/tpdeny§8]");
        file.set("message.tpaSend", "Du hast eine Anfrage an &6%PLAYER%&7 gesendet.");
        file.set("message.tpaGet", "Du hast eine Anfrage von &6%PLAYER%&7 erhalten. Klicke bitte:");
        file.set("message.tpaDenyYou", "Du hast die Anfrage von &6%PLAYER%&7 angenommen.");
        file.set("message.tpaDenyOther", "&6%PLAYER% &7hat deine Anfrage angenommen.");
        file.set("message.tpaNoRequest", "Du hast keine Anfrage erhalten.");
        file.set("message.tpall", "&6%VALUE% &7wurde zu deiner Position teleportiert.");
        file.set("message.tphere", "Der Spieler &6%PLAYER% &7wurde zu deiner Position teleportiert.");
        file.set("message.trashInvName", "&7» &6Müll");
        
        List<String> list = new ArrayList();
        list.add("Was der YouTuber Rang benötigt &5YouTuber:");
        list.add("&8- §7100 Abos");
        list.add("&8- §75 Videos");
        list.add("&8- §71 Video von dem Netzwerk");
        file.set("message.yt", list);
        file.set("message.shop", "Du kannst den Shop hier erreichen: &fhttps://bn1ck.com");
        file.set("message.ts", "Du kannst den Ts hier erreichen: &fts.bn1ck.com");
        file.set("message.ads1", Integer.valueOf(5));
        file.set("message.ads2", Integer.valueOf(3));
        file.set("message.ads3", Integer.valueOf(1));
        file.set("message.adsdaily", "Du kannst keine Werbung mehr heute machen!");
        file.set("message.adsmsg", "&4&lWerbung &7» &f%MESSAGE%");
        file.set("message.boldtrue", "Du schreibst nun &a&lFETT&7.");
        file.set("message.boldfalse", "Du schreibst nicht mehr &a&lFETT&7.");
        file.set("message.rename", "Du hast das Item zu &f%NAME%&7 umbenannt.");
        file.set("message.skinchange", "Du hast deinen Skin geändert.");
        file.set("message.skinremove", "Du hast deinen Skin wieder zurückgesetzt.");
        file.set("message.skincooldown", "Du musst dafür noch einen kurzen Moment warten.");
        file.set("message.skincooldownalready", "Du hast bereits einen anderen Skin.");
        file.set("message.skincooldownnot", "Du hast keinen anderen Skin.");
        file.set("message.skincooldownvalue", Integer.valueOf(10));
        file.set("message.noads_false", "Du erhälst nun wieder Werbung.");
        file.set("message.noads_true", "Du erhälst nun keine Werbung mehr.");
        file.set("message.money", "Der Spieler &b%NAME% &7hat &e%COINS%&7 Coins.");
        file.set("message.moneytop", "%NAME% &8- &e%COINS% &7Coins.");
        file.set("message.tptoggle_act", "Du erlaubst das Teleportieren zu dir nicht mehr.");
        file.set("message.tptoggle_deact", "Du erlaubst das Teleportieren zu dir wieder.");
        file.set("message.tptoggle", "Dieser Spieler hat den TpToggle aktiviert. Versuche /tpo.");
        file.set("message.tablist_header", "&r\n&8» &6&lServer&8.&6&lde &8«\n&r\n&e♬ &8┃ &7Jeden Tag &c18&8:&c00 &7Event\n&r\n&8&m------------&7&m[&8&m-------&7&m]&8&m------------");
        file.set("message.tablist_footer", "&8&m------------&7&m[&8&m-------&7&m]&8&m------------\n&r\n§e✪ &8┃ &7TeamSpeak&8: &6ts&7.&6Server&7.&6de\n§e✁ &8┃ &7Web&8: &6web&7.&6Server&7.&6de\n&r");
        
        CityBuildCore.saveFile(file, FILE);
      } catch (Exception localException26) {}
      try {
        File FILE = new File("plugins/CityBuild/DLC/Essentials/Inventory", "Home.yml");
        FileConfiguration file = YamlConfiguration.loadConfiguration(FILE);
        
        file.set("settings.teleport", "Du wirst in &63sec&7 teleportiert. Nicht bewegen!");
        file.set("settings.cancelmsg", "Die Teleportation wurde abgebrochen, da du dich bewegt hast.");
        
        file.set("inv.settings.name", "&7» &6Homes");
        
        List<String> lore2 = new ArrayList();
        lore2.add("&8&m--------------------");
        lore2.add("&7Du hast diesen Slot nicht gekauft. Das");
        lore2.add("&7kannst du für &e5000 Coins&7 tuhen.");
        file.set("inv.items.notbuy.name", "&8» &4Nicht gekauft &7(&8Slot %VALUE%&7)");
        file.set("inv.items.notbuy.lore", lore2);
        
        List<String> lore3 = new ArrayList();
        lore3.add("&8&m--------------------");
        lore3.add("&7Klicke, um eine neue Location zu platzieren!");
        file.set("inv.items.noloc.name", "&8» &6Keine Location &7(&8Slot %VALUE%&7)");
        file.set("inv.items.noloc.lore", lore3);
        
        List<String> lore4 = new ArrayList();
        lore4.add("&8&m--------------------");
        lore4.add("&8[&7RECHTS KLICK&8] &7Setzte die neue Position");
        lore4.add("&8[&7LINKS KLICK&8] &7Teleportieren");
        file.set("inv.items.teleport.name", "&8» &aTeleportieren &7(&8Slot %VALUE%&7)");
        file.set("inv.items.teleport.lore", lore4);
        
        CityBuildCore.saveFile(file, FILE);
      } catch (Exception localException27) {}
    } else if (DLC == LanguageDLCEnum.CHESTSHOP) {
      try {
        File FILE = new File("plugins/CityBuild/DLC/Shop/", "AdminShop.yml");
        FileConfiguration file = YamlConfiguration.loadConfiguration(FILE);
        
        file.set("settings.buysign", "&8&m--&8 [&2Kaufen&8] &8&m--");
        file.set("settings.buysignamount", "&7Anzahl: &a");
        file.set("settings.buysignprice", "&7Preis&8: &a");
        file.set("settings.sellsign", "&8&m--&8 [&6Verkaufen&8] &8&m--");
        file.set("settings.sellsignamount", "&7Anzahl: &e");
        file.set("settings.sellsignprice", "&7Preis: &e");
        file.set("settings.falseitem", "Du kannst das Item hier nicht verkaufen.");
        file.set("settings.moreitems", "Du brauchst mehr Items, um diese zu verkaufen.");
        file.set("settings.needitems", "Du hast kein Item in der Hand.");
        
        FileManager.saveFILE(file, FILE);
      } catch (Exception localException28) {}
      try {
        File FILE = new File("plugins/CityBuild/DLC/Shop/", "PlayerShop.yml");
        FileConfiguration file = YamlConfiguration.loadConfiguration(FILE);
        
        file.set("settings.signconf0", "&8&m-----------------");
        file.set("settings.signconf1", "&cDrop das Item, welches");
        file.set("settings.signconf2", "&cdu verkaufen willst.");
        file.set("settings.signconf3", "&8&m-----------------");
        
        file.set("settings.sign0", "&8&m-&8 [&cShop&8] &8&m-");
        file.set("settings.sign1", "&7Anzahl&8: &c%AMOUNT%");
        file.set("settings.sign2", "&7Preis&8: &c%PRICE%");
        file.set("settings.sign3", "&8&m-----------------");
        
        file.set("settings.mysqltable", "cbshopTable");
        file.set("settings.nochest", "Eine Kiste muss unter dem Schild sein!");
        file.set("settings.outofstock", "Der Shop ist ausverkauft!");
        file.set("settings.destroyshop", "Du hast diesen Shop erfolgreich gelöscht!");
        file.set("settings.mustnostock", "Es dürfen keine Items mehr im Shop sein, damit du diesen löschen kannst!");
        file.set("settings.notyourshop", "Das ist nicht dein Shop!");
        file.set("settings.shopfill", "Dieser Shop wird bereits befüllt!");
        file.set("settings.invfull", "Dein Inventar ist voll!");
        file.set("settings.nocoins", "Dir fehlen noch &6%COINS% &7Coins!");
        file.set("settings.alreadyedit", "Jemand bearbeitet gerade den Shop!");
        file.set("settings.cancelFinish", "Du hast das Setup erfolgreich abgebrochen!");
        file.set("settings.cancelNoSetup", "Du setzt gerade keinen Store auf!");
        file.set("settings.setup", "Drope das Item, welches du verkaufen willst&8: &6&l%AMOUNT%&7x &6&l%PRICE% &6Coins");
        file.set("settings.nolizenz", "Du brauchst mehr Shop Lizenzen!");
        file.set("settings.someitems", "Es sind noch Items im Shop!");
        
        file.set("settings.clearlaggOneMin", "&8× &7Alle Items auf dem Boden werden in &6einer Minute&7 entfernt &8×");
        file.set("settings.clearlaggOneSec", "&8× &7Alle Items auf dem Boden werden in &6einer Sekunde&7 entfernt &8×");
        file.set("settings.clearlagg", "&8× &7Alle Items auf dem Boden werden in &6%SECONDS% Sekunden&7 entfernt &8×");
        file.set("settings.clearlaggFinish", "&8× &6%INT% &7Items wurden entfernt &8×");
        
        file.set("inv.settings.name", "&8» &eShop Modifier");
        
        FileManager.saveFILE(file, FILE);
      } catch (Exception localException29) {}
      try {
        File FILE = new File("plugins/CityBuild/DLC/Shop/", "StatsMob.yml");
        FileConfiguration file = YamlConfiguration.loadConfiguration(FILE);
        
        file.set("settings.mobname", "&8┃ &a&lStatistiken");
        file.set("settings.noCoins", "Du hast nicht genügend Coins. Dir fehlen noch &6%COINS%&7!");
        
        file.set("inv.settings.name", "&8» &eShopmanager");
        file.set("inv.settings.name1", "&8» &eLizenz Shop");
        
        List<String> lore = new ArrayList();
        lore.add("&8&m--------------------");
        lore.add("&7Deine gesamten Verkaufs-Statistiken.");
        file.set("inv.items.stats.name", "&8» &aDeine Verkäufe&8: &e%SELLS%");
        file.set("inv.items.stats.lore", lore);
        
        List<String> lore1 = new ArrayList();
        lore1.add("&8&m--------------------");
        lore1.add("&7Kaufe einige Lizensen!");
        file.set("inv.items.licenceshop.name", "&8» &aLizenz Shop");
        file.set("inv.items.licenceshop.lore", lore1);
        
        List<String> lore2 = new ArrayList();
        lore2.add("&8&m--------------------");
        lore2.add("&7Wenn du mehr Lizenzen benötigst,");
        lore2.add("&7kaufe diese hier!");
        file.set("inv.items.licenses.name", "&8» &e&l%SHOPS%&7 / &a&l%LICENSE%");
        file.set("inv.items.licenses.lore", lore2);
        
        List<String> lore3 = new ArrayList();
        lore3.add("&8&m--------------------");
        lore3.add("&7Preis&8: &e500");
        file.set("inv.items.sell1.name", "&8» &a1 Lizenzen");
        file.set("inv.items.sell1.lore", lore3);
        
        List<String> lore4 = new ArrayList();
        lore4.add("&8&m--------------------");
        lore4.add("&7Preis&8: &e900");
        file.set("inv.items.sell2.name", "&8» &a2 Lizenzen");
        file.set("inv.items.sell2.lore", lore4);
        
        List<String> lore5 = new ArrayList();
        lore5.add("&8&m--------------------");
        lore5.add("&bBESTE WAHL!");
        lore5.add("&7Preis&8: &e2000");
        file.set("inv.items.sell3.name", "&8» &a5 Lizenzen");
        file.set("inv.items.sell3.lore", lore5);
        
        List<String> lore6 = new ArrayList();
        lore6.add("&8&m--------------------");
        lore6.add("&7Preis&8: &e3800");
        file.set("inv.items.sell4.name", "&8» &a10 Lizenzen");
        file.set("inv.items.sell4.lore", lore6);
        CityBuildCore.saveFile(file, FILE);
      }
      catch (Exception localException30) {}
    } else if (DLC == LanguageDLCEnum.CRATES) {
      try {
        File FILE = new File("plugins/CityBuild/DLC/Crates/Animation", "Run.yml");
        FileConfiguration file = YamlConfiguration.loadConfiguration(FILE);
        file.set("inv.settings.name", "&8» &eLade Gewinn...");
        file.set("inv.items.win.name", "&7» &eDein Gewinn");
        FileManager.saveFILE(file, FILE);
      } catch (Exception localException31) {}
      try {
        File FILE = new File("plugins/CityBuild/DLC/Crates/Animation", "End.yml");
        FileConfiguration file = YamlConfiguration.loadConfiguration(FILE);
        file.set("inv.settings.name", "&8» &eDein Gewinn");
        FileManager.saveFILE(file, FILE);
      } catch (Exception localException32) {}
      try {
        File FILE = new File("plugins/CityBuild/DLC/Crates/Inventory", "Books.yml");
        FileConfiguration file = YamlConfiguration.loadConfiguration(FILE);
        
        file.set("settings.coins", "Du hast &e%VALUE% &7Coins erhalten!");
        file.set("settings.perms", "Du hast neue Skills erhalten!");
        file.set("settings.permscommand", "pex user %PLAYER% add %VALUE%");
        file.set("settings.alreadyperms", "Du hast diese Fähigkeit bereits!");
        file.set("settings.ranks", "Du hast einen neuen Rang erhalten&8: &f%VALUE%");
        file.set("settings.rankcommand", "pex user %PLAYER% group set %VALUE%");
        
        List<String> lore = new ArrayList();
        lore.add("&8&m--------------------");
        lore.add("&7Bekomme einige Coins!");
        file.set("books.coins.name", "&8» &e&lCoin - Buch&7: &f%VALUE%");
        file.set("books.coins.lore", lore);
        
        List<String> lore1 = new ArrayList();
        lore1.add("&8&m--------------------");
        lore1.add("&7Bekomme diese Skills!");
        file.set("books.perms.name", "&8» &a&lPerm - Buch&7: &f%VALUE%");
        file.set("books.perms.lore", lore1);
        
        List<String> lore2 = new ArrayList();
        lore2.add("&8&m--------------------");
        lore2.add("&7Bekomme diesen Rang!");
        file.set("books.rank.name", "&8» &2&lRang - Buch&7: &f%VALUE%");
        file.set("books.rank.lore", lore2);
        
        FileManager.saveFILE(file, FILE);
      } catch (Exception localException33) {}
      try {
        File FILE = new File("plugins/CityBuild/DLC/Crates/Inventory", "Preview.yml");
        FileConfiguration file = YamlConfiguration.loadConfiguration(FILE);
        
        file.set("inv.settings.name", "&8» &eVorschau");
        
        FileManager.saveFILE(file, FILE);
      } catch (Exception localException34) {}
      try {
        File FILE = new File("plugins/CityBuild/DLC/Crates/Inventory", "Keys.yml");
        FileConfiguration file = YamlConfiguration.loadConfiguration(FILE);
        
        file.set("settings.notkey", "Bitte halte ein Item in der Hand!");
        file.set("settings.invfull", "Dein Inventar ist voll!");
        
        List<String> lore = new ArrayList();
        lore.add("&8&m--------------------");
        lore.add("&7Gehe zu einer Vote Kiste");
        lore.add("&7und löse den Schlüssel ein!");
        file.set("keys.vote.name", "&8» &bVote Schlüssel");
        file.set("keys.vote.lore", lore);
        
        List<String> lore1 = new ArrayList();
        lore1.add("&8&m--------------------");
        lore1.add("&7Gehe zu einer seltenen Kiste");
        lore1.add("&7und löse den Schlüssel ein!");
        file.set("keys.crate1.name", "&8» &9Seltener Schlüssel");
        file.set("keys.crate1.lore", lore1);
        
        List<String> lore2 = new ArrayList();
        lore2.add("&8&m--------------------");
        lore2.add("&7Gehe zu einer &6epischen Kiste");
        lore2.add("&7und löse den Schlüssel ein!");
        file.set("keys.crate2.name", "&8» &6Epischer Schlüssel");
        file.set("keys.crate2.lore", lore2);
        
        List<String> lore3 = new ArrayList();
        lore3.add("&8&m--------------------");
        lore3.add("&7Gehe zu einer &5legendären Kiste");
        lore3.add("&7und löse den Schlüssel ein!");
        file.set("keys.crate3.name", "&8» &5Legendärer Schlüssel");
        file.set("keys.crate3.lore", lore3);
        
        List<String> lore4 = new ArrayList();
        lore4.add("&8&m--------------------");
        lore4.add("&7Gehe zu einer &eSommer Kiste");
        lore4.add("&7und löse den Schlüssel ein!");
        file.set("keys.crate4.name", "&8» &eSommer Schlüssel");
        file.set("keys.crate4.lore", lore4);
        
        CityBuildCore.saveFile(file, FILE);
      } catch (Exception localException35) {}
      try {
        File FILE = new File("plugins/CityBuild/DLC/Crates/Inventory", "Keysshop.yml");
        FileConfiguration file = YamlConfiguration.loadConfiguration(FILE);
        
        file.set("settings.mobname", "&8● &6Schlüssel Shop &8●");
        file.set("settings.key1bought", "Du hast einen &9Seltener Schlüssel &7für &e300 Coins&7 gekauft.");
        file.set("settings.key2bought", "Du hast einen &6Epischer Schlüssel &7für &b600 Coins&7 gekauft.");
        file.set("settings.key3bought", "Du hast einen &5Legendärer Schlüssel &7für &b1000 Coins&7 gekauft.");
        file.set("settings.key4bought", "Du hast einen &eSommer Schlüssel &7für &b1400 Coins&7 gekauft.");
        file.set("inv.settings.name", "&8» &eSchlüssel Shop");
        
        List<String> lore4 = new ArrayList();
        lore4.add("&8&m--------------------");
        lore4.add("&7Kaufe einen &9seltenen Schlüssel&7!");
        lore4.add("&7Preis&8: &e300");
        file.set("inv.items.key1.name", "&8» &9Seltener Schlüssel");
        file.set("inv.items.key1.lore", lore4);
        
        List<String> lore5 = new ArrayList();
        lore5.add("&8&m--------------------");
        lore5.add("&7Kaufe einen &eepischen Schlüssel&7!");
        lore5.add("&7Preis&8: &e600");
        file.set("inv.items.key2.name", "&8» &6Epischer Schlüssel");
        file.set("inv.items.key2.lore", lore5);
        
        List<String> lore6 = new ArrayList();
        lore6.add("&8&m--------------------");
        lore6.add("&7Kaufe einen &5legendären Schlüssel&7!");
        lore6.add("&7Preis&8: &e1000");
        file.set("inv.items.key3.name", "&8» &5Legendärer Schlüssel");
        file.set("inv.items.key3.lore", lore6);
        
        List<String> lore7 = new ArrayList();
        lore7.add("&8&m--------------------");
        lore7.add("&7Kaufe einen &eSommer Schlüssel&7!");
        lore7.add("&7Preis&8: &e1400");
        file.set("inv.items.key4.name", "&8» &eSommer Schlüssel");
        file.set("inv.items.key4.lore", lore7);
        
        FileManager.saveFILE(file, FILE);
      } catch (Exception localException36) {}
    } else if (DLC == LanguageDLCEnum.BANMANAGER) {
      try {
        File FILE = new File("plugins/CityBuild/DLC/BanManager/Ban", "settings.yml");
        FileConfiguration file = YamlConfiguration.loadConfiguration(FILE);
        
        file.set("settings.banmessage", "&4Du wurdest vom server gebannt. \n &7Grund&8: &a%REASON% \n \n &7Zeit&8: &a%HOWLONG%\n&7Von&8: &a%BY% \n &7Datum&8: &a%DATE% &7- &a%TIME%\n&7");
        
        file.set("settings.timeperm", "§4PERMANENT");
        file.set("settings.timelayout", "§a%DAY% d, %HOUR% h, %MIN% m, %SEC% s");
        List<String> list1 = new ArrayList();
        list1.add("&a&lNeuer Ban &7von &2%BY%");
        list1.add("&8");
        list1.add("&7Gebannter Spieler&8: &a%PLAYER%");
        list1.add("&7Zeit&8: &a%TIME%");
        list1.add("&7Grund&8: &a%REASON%");
        file.set("settings.banmsglong", list1);
        file.set("settings.noplayer", "Der Spieler existiert nicht!");
        file.set("settings.notbanned", "Der Spieler ist nicht gabannt!");
        file.set("settings.unbanned", "Der Spieler &4%NAME% &7wurde von &f%EXECUTOR%&7 entbannt!");
        file.set("settings.banlistlayout", "&8[&7#&a%INT%&8] &7%REASON% &8- &7%TIME%");
        
        FileManager.saveFILE(file, FILE);
      } catch (Exception localException37) {}
      try {
        File FILE = new File("plugins/CityBuild/DLC/BanManager/", "check.yml");
        FileConfiguration file = YamlConfiguration.loadConfiguration(FILE);
        
        file.set("settings.unban", "Klicke diese Nachricht um &a%PLAYER%&7 zu entbannen.");
        file.set("settings.unbanhover", "Klicke, um zu entbannen.");
        file.set("settings.unmute", "Klicke diese Nachricht um &a%PLAYER%&7 zu entmuten.");
        file.set("settings.unmutehover", "Klicke, um zu entmuten.");
        
        file.set("inv.settings.name", "&7» &6Spieler überprüfen");
        
        List<String> lore = new ArrayList();
        lore.add("&8&m--------------------");
        lore.add("&7Dieser Spieler wurde gebannt:");
        lore.add("&7Zeit&8: &c%HOWLONG%");
        lore.add("&7Von&8: &c%BY%");
        lore.add("&7Grund&8: &c%REASON%");
        lore.add("&7Datum&8: &c%DATE% &7- &c%TIME%");
        
        file.set("inv.items.bantrue.name", "&8» &4Ban");
        file.set("inv.items.bantrue.lore", lore);
        
        List<String> lore1 = new ArrayList();
        lore1.add("&8&m--------------------");
        lore1.add("&7Dieser Spieler wurde gemuted:");
        lore1.add("&7Zeit&8: &c%HOWLONG%");
        lore1.add("&7Von&8: &c%BY%");
        lore1.add("&7Grund&8: &c%REASON%");
        lore1.add("&7Datum&8: &c%DATE% &7- &c%TIME%");
        
        file.set("inv.items.mutetrue.name", "&8» &4Mute");
        file.set("inv.items.mutetrue.lore", lore1);
        
        List<String> lore2 = new ArrayList();
        lore2.add("&8&m--------------------");
        lore2.add("&7Dieser Spieler ist nicht gebannt.");
        
        file.set("inv.items.banfalse.name", "&8» &aBan");
        file.set("inv.items.banfalse.lore", lore2);
        
        List<String> lore3 = new ArrayList();
        lore3.add("&8&m--------------------");
        lore3.add("&7Dieser Spieler ist nicht gemuted.");
        
        file.set("inv.items.mutefalse.name", "&8» &aMute");
        file.set("inv.items.mutefalse.lore", lore3);
        
        file.set("inv.items.stats.name", "&8» &aSpieler&8: %NAME%");
        
        FileManager.saveFILE(file, FILE);
      } catch (Exception localException38) {}
      try {
        File FILE = new File("plugins/CityBuild/DLC/BanManager/", "utils.yml");
        FileConfiguration file = YamlConfiguration.loadConfiguration(FILE);
        
        file.set("settings.kickmessagemaintenance", "&cDer Server ist in Wartungen! \n &7Wir abreiten gerade an unseren Systemen \n &7network. &8Try again later! \n \n &bTwitter&8: &f@evapedcloud \n &9WebSite&8: &fhttps://bn1ck.com");
        file.set("settings.deactivated", "Die Wartungen sind &cdeaktiviert&7!");
        file.set("settings.activated", "Die Wartungen sind &aaktiviert&7!");
        file.set("settings.kickmessage", "&7Du wurdest vom Server geworfen.");
        file.set("settings.kickmessagereason", "&7Du wurdest von dem Server geworfen. \n &7Grund&8: &c%REASON%");
        file.set("settings.cantkick", "Du kannst diesen Spieler nicht kicken.");
        file.set("settings.kickall", "Du hast &6%INT% &7vom Server geworfen.");
        
        FileManager.saveFILE(file, FILE);
      } catch (Exception localException39) {}
      try {
        File FILE = new File("plugins/CityBuild/DLC/BanManager/Mute", "settings.yml");
        FileConfiguration file = YamlConfiguration.loadConfiguration(FILE);
        
        file.set("settings.mutemessage", "&4Du wurdest gemuted. &7Grund&8: &a%REASON%&7, Zeit&8: &a%HOWLONG%&7, von&8: &a%BY%&7, Datum&8: &a%DATE% &7- &a%TIME%\n&7");
        file.set("settings.timeperm", "§4PERMANENT");
        file.set("settings.timelayout", "§a%DAY% d, %HOUR% h, %MIN% m, %SEC% s");
        List<String> list1 = new ArrayList();
        list1.add("&a&lNeuer Mute &7von &2%BY%");
        list1.add("&8");
        list1.add("&7Gemutete Spieler&8: &a%PLAYER%");
        list1.add("&7Zeit&8: &a%TIME%");
        list1.add("&7Grund&8: &a%REASON%");
        file.set("settings.mutemsglong", list1);
        file.set("settings.mutemsgshort", "Neuer Mute&8: &4%NAME% &8(&f%TIME%&8) &7- &c%REASON%");
        file.set("settings.noplayer", "Dieser Spieler existiert nicht!");
        file.set("settings.notmuted", "Dieser Spieler ist nicht gemutet!");
        file.set("settings.unmuted", "Der Spieler &4%NAME% &7wurde von &f%EXECUTOR%&7 gemutet!");
        file.set("settings.mutelistlayout", "&8[&7#&a%INT%&8] &7%REASON% &8- &7%TIME%");
        List<String> list2 = new ArrayList();
        list2.add("_Suffix_");
        file.set("settings.cantmute", list2);
        
        FileManager.saveFILE(file, FILE);
      } catch (Exception localException40) {}
      try {
        File FILE = new File("plugins/CityBuild/DLC/BanManager/Report", "confirm.yml");
        FileConfiguration file = YamlConfiguration.loadConfiguration(FILE);
        
        file.set("inv.settings.name", "&7» &6Bestätigung");
        
        List<String> lore = new ArrayList();
        lore.add("&8&m--------------------");
        lore.add("&8➟ &7%REASON%");
        file.set("inv.items.reason.subid", "&8» &aDein Grund&8:");
        file.set("inv.items.reason.enchant", lore);
        
        List<String> lore1 = new ArrayList();
        lore1.add("&8&m--------------------");
        lore1.add("&7Click, to report this player.");
        lore1.add("&7Every abuse will be punished.");
        file.set("inv.items.confirmation.subid", "&8» &aAktion bestätigen");
        file.set("inv.items.confirmation.enchant", lore1);
        
        List<String> lore4 = new ArrayList();
        file.set("inv.items.player.subid", "&8» &7Spieler&8: &a%PLAYER%");
        file.set("inv.items.player.enchant", lore4);
        
        FileManager.saveFILE(file, FILE);
      } catch (Exception localException41) {}
      try {
        File FILE = new File("plugins/CityBuild/DLC/BanManager/Report", "interface.yml");
        FileConfiguration file = YamlConfiguration.loadConfiguration(FILE);
        
        file.set("settings.reportteam", "Neuer Report&8: &c%TARGET% &8(&7Grund&8: &4%REASON%&8) &7von&8: &a%PLAYER%");
        file.set("settings.reportteamhover", "&7Klicken, um zu reporten.");
        
        file.set("settings.notOnline", "&7Dieser Spieler ist nicht online.");
        file.set("settings.delay", Integer.valueOf(30));
        file.set("settings.delaymsg", "Du musst erst &e30 sec&7 warten, bevor du diesen Spieler wieder reporten kannst!");
        file.set("settings.alreadyreport", "Danke für deinen Report, dieser Spieler wurde bereits reportet!");
        file.set("settings.invalidsession", "Ungültige Sitzung, versuche es erneut!");
        
        file.set("settings.reportclose", "Du hast den Report von &6%PLAYER%&7 geschlossen!");
        file.set("settings.reportcloseleft", "Der Report von &6%PLAYER%&7 wurde geschlossen, da der Spieler das Spiel verlassen hat!");
        file.set("settings.reportclaim", "Du hast den Report von &6%PLAYER%&7 angenommen!");
        file.set("settings.alreadyclaim", "Dieser Report wurde bereits angenommen!");
        file.set("settings.notReport", "Dieser Spieler wurde nicht reportet!");
        file.set("settings.cannowreport", "Du kannst nun wieder Spieler reporten!");
        file.set("settings.reportconfirm", "Danke für deinen Report, ein Teammitglied wird sich darum kümmern.");
        
        file.set("inv.settings.name", "&7» &6Ungeclaimte Reports");
        
        List<String> lore = new ArrayList();
        lore.add("&8&m--------------------");
        lore.add("&7Reporter&8: &c%PLAYER%");
        lore.add("&7Grund&8: &c%REASON%");
        file.set("inv.items.player.name", "&8» &aReport&8: &c%TARGET%");
        file.set("inv.items.player.lore", lore);
        
        List<String> lore3 = new ArrayList();
        lore3.add("&8&m--------------------");
        lore3.add("&7Es sind keine Reports offen!");
        file.set("inv.items.noreports.name", "&8» &cKeine Reports");
        file.set("inv.items.noreports.lore", lore);
        
        FileManager.saveFILE(file, FILE);
      } catch (Exception localException42) {}
    } else if (DLC == LanguageDLCEnum.DISGUISE) {
      try {
        File FILE = new File("plugins/CityBuild/DLC/Disguise", "inventory.yml");
        FileConfiguration file = YamlConfiguration.loadConfiguration(FILE);
        List<String> list1 = new ArrayList();
        list1.add("&8&m--------------------");
        list1.add("&aDu kannst dich in dieses Mob");
        list1.add("&averwandeln!");
        file.set("settings.lore_perms", list1);
        
        List<String> list2 = new ArrayList();
        list2.add("&8&m--------------------");
        list2.add("&cDu kannst dich nicht in dieses Mob");
        list2.add("&cverwandeln! Du benötigst &6Premium&c,");
        list2.add("&cum dies zu nutzen!");
        file.set("settings.lore_perms_not", list2);
        file.set("settings.disguised", "Du bist bereits verwandelt. /undisguise um dich zurück zu verwandeln.");
        file.set("settings.disguised_not", "Du bist nicht verwandelt. /disguise um dich zu verwandeln.");
        
        CityBuildCore.saveFile(file, FILE);
      }
      catch (Exception localException43) {}
    }
  }
}
