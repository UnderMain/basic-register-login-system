package cloud.evaped.citybuild.main;

import cloud.evaped.citybuild.MySQL.MySQL;
import cloud.evaped.citybuild.MySQL.MySQLMethods;
import cloud.evaped.citybuild.MySQL.MySQLcoinsTable;
import cloud.evaped.citybuild.commands.AdventureCommand;
import cloud.evaped.citybuild.commands.CoinsCommand;
import cloud.evaped.citybuild.commands.CreativeCommand;
import cloud.evaped.citybuild.commands.DelWarpCommand;
import cloud.evaped.citybuild.commands.EditCommand;
import cloud.evaped.citybuild.commands.EditItemCommand;
import cloud.evaped.citybuild.commands.EditMapCommand;
import cloud.evaped.citybuild.commands.FeedCommand;
import cloud.evaped.citybuild.commands.FlyCommand;
import cloud.evaped.citybuild.commands.GameModeCommand;
import cloud.evaped.citybuild.commands.HealCommand;
import cloud.evaped.citybuild.commands.LanguageCommand;
import cloud.evaped.citybuild.commands.MSGCommand;
import cloud.evaped.citybuild.commands.MSGToggleCommand;
import cloud.evaped.citybuild.commands.NickCommand;
import cloud.evaped.citybuild.commands.RealNameCommand;
import cloud.evaped.citybuild.commands.SetWarpCommand;
import cloud.evaped.citybuild.commands.SpecModeCommand;
import cloud.evaped.citybuild.commands.SpectatorCommand;
import cloud.evaped.citybuild.commands.SurvivalCommand;
import cloud.evaped.citybuild.commands.WarpCommand;
import cloud.evaped.citybuild.commands.WarpsCommand;
import cloud.evaped.citybuild.listener.AntiCrashListener;
import cloud.evaped.citybuild.listener.AntiEventsListener;
import cloud.evaped.citybuild.listener.ChatListener;
import cloud.evaped.citybuild.listener.DeathListener;
import cloud.evaped.citybuild.listener.InteractListener;
import cloud.evaped.citybuild.listener.JoinListener;
import cloud.evaped.citybuild.listener.LoginListener;
import cloud.evaped.citybuild.listener.QuitListener;
import cloud.evaped.citybuild.listener.RespawnListener;
import cloud.evaped.citybuild.listener.SignChangeListener;
import cloud.evaped.citybuild.listener.UCMListener;
import cloud.evaped.citybuild.listener.WarpSignListener;
import cloud.evaped.citybuild.utils.Actionbar;
import cloud.evaped.citybuild.utils.DeathZone;
import cloud.evaped.citybuild.utils.Messages;
import cloud.evaped.citybuild.utils.OnlineTime;
import cloud.evaped.citybuild.utils.PlayerSaver;
import cloud.evaped.citybuild.utils.RegisterMobs;
import cloud.evaped.citybuild.utils.SpecMode;
import cloud.evaped.citybuild.utils.TeleportESC;
import cloud.evaped.citybuild.utils.Warps;
import cloud.evaped.citybuild.utils.nick.Nick;
import cloud.evaped.citybuild.utils.nick.NickFile;
import cloud.evaped.citybuild.utils.nick.NickManager;
import cloud.evaped.citybuild.utils.scoreboard.CachePlayer;
import cloud.evaped.citybuild.utils.scoreboard.CacheScoreboard;
import cloud.evaped.citybuild.utils.scoreboard.CoreScoreBoard;
import cloud.evaped.citybuild.utils.settings.SettingsFile;
import cloud.evaped.citybuild.utils.settings.SettingsManager;
import com.mojang.authlib.GameProfile;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class CityBuildPlugin extends JavaPlugin
{
  public static boolean debug;
  public static CityBuildPlugin instance;
  public static MySQLMethods mysqlMethods;
  public static boolean BungeeSystem;
  public static String MySQLTable;
  public static boolean Clans;
  public static boolean Maxplayers;
  public static String Maxplayers_msg;
  public static boolean xperms;
  public static int xperms_premium;
  public static String spec_suffix;
  public static boolean anticrash;
  
  public CityBuildPlugin() {}
  
  public void onEnable()
  {
    instance = this;
    debug = true;
    
    loadconfig();
    registerFiles();
    new Loader().loadAllFiles();
    new CacheScoreboard().loadCache();
    
    spec_suffix = getConfig().getString("specmode.suffix");
    BungeeSystem = getConfig().getBoolean("BungeeSystem");
    
    run();
    
    registerCommands();
    registerListener();
    
    Clans = getConfig().getBoolean("Clan.enabled");
    Maxplayers = getConfig().getBoolean("Maxplayers.enabled");
    Maxplayers_msg = getConfig().getString("Maxplayers.kickmsg").replaceAll("&", "§");
    
    xperms = getConfig().getBoolean("xperms.enabled");
    xperms_premium = getConfig().getInt("xperms.premiumid");
    
    anticrash = getConfig().getBoolean("anticrash");
  }
  
  public void onDisable()
  {
    MySQL.instance.disconnect();
    for (Iterator localIterator1 = CityBuildCore.getVanishPlayer.iterator(); localIterator1.hasNext();) { all = (Player)localIterator1.next();
      for (Player all1 : Bukkit.getOnlinePlayers())
        all1.showPlayer(all);
    }
    Player all;
    Nick.instance.unnickPlayerOnReload();
  }
  
  private void run() {
    MySQLTable = getConfig().getString("MySQLTable");
    new CityBuildCore();
    new MySQL();
    new MySQLcoinsTable();
    new CachePlayer();
    new CacheScoreboard();
    new DeathZone();
    new OnlineTime();
    mysqlMethods = new MySQLMethods();
    new SpecMode();
    new PlayerSaver();
    new Actionbar();
    
    Nick.name1 = Nick.getField(GameProfile.class, "name");
    getAllErrorManager();
    for (Player all : Bukkit.getOnlinePlayers()) {
      new CoreScoreBoard(all);
    }
    
    new Nick();
    
    new BukkitRunnable() {
      public void run() {
        new FileManager().loadData_Data();
        new RegisterMobs(CityBuildPlugin.instance).createVillager();
        for (World w : Bukkit.getWorlds()) {
          w.setStorm(false);
          w.setThundering(false);
          w.setTime(0L);
        }
        new Warps(); } }
    
      .runTaskLater(this, 4L);
  }
  
  private void registerCommands() {
    getCommand("feed").setExecutor(new FeedCommand());
    getCommand("heal").setExecutor(new HealCommand());
    getCommand("fly").setExecutor(new FlyCommand());
    getCommand("gamemode").setExecutor(new GameModeCommand());
    getCommand("survival").setExecutor(new SurvivalCommand());
    getCommand("creative").setExecutor(new CreativeCommand());
    getCommand("adventure").setExecutor(new AdventureCommand());
    getCommand("spectator").setExecutor(new SpectatorCommand());
    getCommand("nick").setExecutor(new NickCommand());
    getCommand("realname").setExecutor(new RealNameCommand());
    getCommand("coins").setExecutor(new CoinsCommand());
    getCommand("msg").setExecutor(new MSGCommand());
    getCommand("edit").setExecutor(new EditCommand());
    getCommand("editmap").setExecutor(new EditMapCommand());
    getCommand("edititem").setExecutor(new EditItemCommand());
    getCommand("spawn").setExecutor(new cloud.evaped.citybuild.commands.SpawnCommand());
    getCommand("warp").setExecutor(new WarpCommand());
    getCommand("warps").setExecutor(new WarpsCommand());
    getCommand("setwarp").setExecutor(new SetWarpCommand());
    getCommand("delwarp").setExecutor(new DelWarpCommand());
    getCommand("msgtoggle").setExecutor(new MSGToggleCommand());
    getCommand("specmode").setExecutor(new SpecModeCommand());
    getCommand("language").setExecutor(new LanguageCommand());
  }
  
  private void registerListener() {
    PluginManager pm = Bukkit.getPluginManager();
    pm.registerEvents(new JoinListener(), this);
    pm.registerEvents(new QuitListener(), this);
    pm.registerEvents(new InteractListener(), this);
    pm.registerEvents(new ChatListener(), this);
    pm.registerEvents(new DeathListener(this), this);
    pm.registerEvents(new RespawnListener(), this);
    pm.registerEvents(new AntiEventsListener(), this);
    pm.registerEvents(new WarpSignListener(), this);
    pm.registerEvents(new UCMListener(), this);
    pm.registerEvents(new NickManager(), this);
    pm.registerEvents(new SettingsManager(), this);
    pm.registerEvents(new TeleportESC(this), this);
    pm.registerEvents(new LoginListener(), this);
    pm.registerEvents(new SignChangeListener(), this);
    pm.registerEvents(new AntiCrashListener(), this);
  }
  
  private void registerFiles() {
    FileManager.createchatfile();
    FileManager.createtabfile();
    FileManager.createScoreBoardRanksFile();
    new FileManager().createDefaultMySQLFile();
    NickFile.updateNickNameFile();
    NickFile.updateNickSettingsInvFile();
    Messages.updateMessagesFile();
    SettingsFile.updateSettingsInvFile();
  }
  
  public void loadconfig() {
    getConfig().addDefault("messages.prefix", "§6§lCityBuild §8× §7");
    getConfig().addDefault("messages.noPerm", "You do §cnot have §7the permission to use this feature!");
    getConfig().addDefault("messages.fSyntax", "Wrong syntax. Please try this&8: &c/");
    getConfig().addDefault("messages.noCoins", "You do not have enough coins. You are still missing §6%COINS% §7Coins.");
    getConfig().addDefault("messages.noPlayer", "This Player &cdoesn't &7exists.");
    getConfig().addDefault("messages.notOnline", "&7This Player &cisn't &7online right now.");
    
    getConfig().addDefault("MySQLTable", "citybuildTable");
    getConfig().addDefault("BungeeSystem", Boolean.valueOf(false));
    getConfig().addDefault("EntityExplodeDamage", Boolean.valueOf(false));
    getConfig().addDefault("BlockIgnite", Boolean.valueOf(false));
    getConfig().addDefault("WeatherChange", Boolean.valueOf(false));
    getConfig().addDefault("LeavesDecay", Boolean.valueOf(false));
    getConfig().addDefault("PlayerAchievement", Boolean.valueOf(false));
    getConfig().addDefault("FallDamage", Boolean.valueOf(false));
    getConfig().addDefault("FireDamage", Boolean.valueOf(false));
    getConfig().addDefault("LavaDamage", Boolean.valueOf(false));
    getConfig().addDefault("LightningDamage", Boolean.valueOf(false));
    getConfig().addDefault("PoisenDamage", Boolean.valueOf(false));
    getConfig().addDefault("PlayerDamage", Boolean.valueOf(false));
    getConfig().addDefault("DeathHighMin", Integer.valueOf(-10));
    getConfig().addDefault("DeathHighMax", Integer.valueOf(270));
    getConfig().addDefault("anticrash", Boolean.valueOf(true));
    getConfig().addDefault("DeathZone", Boolean.valueOf(true));
    getConfig().addDefault("UCM_message", "The Command &8× &c%COMMAND% &8× &7does not exists!");
    getConfig().addDefault("Messages.ot_min", "%VALUE% min");
    getConfig().addDefault("Messages.ot_hour", "%VALUE% hours");
    getConfig().addDefault("Messages.noClan", "&c&l/");
    
    getConfig().addDefault("Maxplayers.enabled", Boolean.valueOf(true));
    getConfig().addDefault("Maxplayers.kickmsg", "&8● &7&oThe maxmimum amount of &825 &7&oplayers has been reached. &7Please try again later. &8●");
    
    getConfig().addDefault("xperms.enabled", Boolean.valueOf(false));
    getConfig().addDefault("xperms.premiumid", Integer.valueOf(1));
    getConfig().addDefault("specmode.suffix", " §8[§c§lSM§8]");
    getConfig().addDefault("specmode.broadcaster", "&7•&8● &cYou are in spec-mode &8●&7•");
    
    getConfig().addDefault("Scoreboard.name", "&6&lCity&e&lBuild");
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
    getConfig().addDefault("Scoreboard.list", list02);
    getConfig().addDefault("Scoreboard.clantags", Boolean.valueOf(false));
    getConfig().addDefault("Scoreboard.enabled", Boolean.valueOf(true));
    getConfig().addDefault("WarpSign.layout", "&8&m----&8 [&bWarp&8] &8&m----");
    getConfig().addDefault("WarpSign.nowarp", "This warp does not exists!");
    getConfig().addDefault("Spawn.joinspawn", Boolean.valueOf(true));
    getConfig().addDefault("Villager.plotsettings.name", "&8● &6Plot settings &8●");
    getConfig().addDefault("Villager.plotsettings.kind", "villager");
    getConfig().addDefault("Villager.firstthere.name", "&8● &6You are new? &7Click, to get your own plot! &8●");
    getConfig().addDefault("Villager.firstthere.kind", "golem");
    List<String> list03 = new ArrayList();
    list03.add("&8&m------------------------------------------------");
    list03.add("&r");
    list03.add("&r&6&lPlot Information");
    list03.add("&r");
    list03.add("&r&7On your plot, you can create your own home! Or a shop or a big farm?");
    list03.add("%CREATEPLOT%");
    list03.add("&r");
    list03.add("&8&m------------------------------------------------");
    getConfig().addDefault("Villager.firstthere.messages", list03);
    getConfig().addDefault("Villager.firstthere.createplot", "&cYou do not have a plot? Click to create one!");
    getConfig().addDefault("Villager.firstthere.createplotshow", "&cClick to create one!");
    getConfig().addDefault("Villager.firstthere.command", "/p auto");
    getConfig().addDefault("Onlinetimechat.enabled", Boolean.valueOf(true));
    getConfig().addDefault("Onlinetimechat.time", Integer.valueOf(20));
    getConfig().addDefault("Onlinetimechat.message", "You can only write in &b%TIME% &7min in the chat.");
    getConfig().addDefault("Spawn.cooldown", Integer.valueOf(3));
    getConfig().addDefault("Loading.header", "&8● &6&lLoading &8●");
    getConfig().addDefault("Loading.footer", "§7⬛ ⬛ ⬛");
    getConfig().addDefault("Messages.noCommand", "The command &e%CMD% &7does not exists.");
    
    getConfig().options().copyDefaults(true);
    saveConfig();
  }
  
  private void getAllErrorManager()
  {
    getServer().getConsoleSender().sendMessage(ChatColor.DARK_GRAY + "_________________________________________________________________________________________");
    

    getServer().getConsoleSender().sendMessage(ChatColor.DARK_GRAY + " ");
    System.out.println("This System is made by EVAPED - StyleException");
    System.out.println("© 2018 all rights reserved");
    System.out.println("> https://www.evaped.cloud");
    System.out.println("> Version: normal 2.0.0");
    getServer().getConsoleSender().sendMessage(ChatColor.DARK_GRAY + " ");
    
    ChatColor cc2;
    String s2;
    ChatColor cc2;
    if (MySQL.instance.isConnected()) {
      String s2 = "SUCCSES : The MySQL Database is succsesfully connected";
      cc2 = ChatColor.DARK_GREEN;
    } else {
      s2 = "ERROR : The MySQL Database cannot connect to the server";
      cc2 = ChatColor.DARK_RED;
    }
    getServer().getConsoleSender().sendMessage(cc2 + s2);
    
    getServer().getConsoleSender().sendMessage(ChatColor.DARK_GRAY + " ");
    getServer().getConsoleSender().sendMessage(ChatColor.DARK_GRAY + "_________________________________________________________________________________________");
    
    getServer().getConsoleSender().sendMessage(ChatColor.DARK_GRAY + " ");
  }
}
