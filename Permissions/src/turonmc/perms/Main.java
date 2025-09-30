/*     */ package turonmc.perms;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.configuration.InvalidConfigurationException;
/*     */ import org.bukkit.configuration.file.FileConfiguration;
/*     */ import org.bukkit.configuration.file.YamlConfiguration;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ import org.bukkit.plugin.java.JavaPlugin;
/*     */ import turonmc.mysql.MySQL;
/*     */ import turonmc.perms.cmds.CMD_group;
/*     */ import turonmc.perms.cmds.CMD_perm;
/*     */ import turonmc.perms.cmds.CMD_user;
/*     */ import turonmc.perms.events.EVT_join;
/*     */ import turonmc.prefixsys.ChatPrefix;
/*     */ import turonmc.prefixsys.TabPrefix;
/*     */ 
/*     */ public class Main extends JavaPlugin {
/*  25 */   public static File userFile = new File("plugins/Permissions/users.yml");
/*  26 */   public static File groupFile = new File("plugins/Permissions/groups.yml");
/*  27 */   public static File playerFile = new File("plugins/Permissions/players.yml");
/*     */   
/*  29 */   public static FileConfiguration userConfig = (FileConfiguration)YamlConfiguration.loadConfiguration(userFile);
/*  30 */   public static FileConfiguration groupConfig = (FileConfiguration)YamlConfiguration.loadConfiguration(groupFile);
/*  31 */   public static FileConfiguration playerConfig = (FileConfiguration)YamlConfiguration.loadConfiguration(playerFile);
/*     */   
/*     */   private MySQL mysql;
/*     */   
/*     */   public static Main plugin;
/*     */   
/*     */   public void onEnable() {
/*  38 */     plugin = this;
/*     */     
/*  40 */     saveDefault();
/*     */     
/*  42 */     getCommand("group").setExecutor((CommandExecutor)new CMD_group());
/*  43 */     getCommand("user").setExecutor((CommandExecutor)new CMD_user());
/*  44 */     getCommand("perm").setExecutor((CommandExecutor)new CMD_perm());
/*     */     
/*  46 */     Bukkit.getPluginManager().registerEvents((Listener)new EVT_join(), (Plugin)this);
/*  47 */     Bukkit.getPluginManager().registerEvents((Listener)new ChatPrefix(), (Plugin)this);
/*  48 */     Bukkit.getPluginManager().registerEvents((Listener)new TabPrefix(), (Plugin)this);
/*     */     
/*  50 */     initConfig();
/*     */   }
/*     */ 
/*     */   
/*     */   public void onDisable() {}
/*     */ 
/*     */   
/*     */   public void initConfig() {
/*     */     try {
/*  59 */       this.mysql = new MySQL();
/*  60 */     } catch (Exception exception) {}
/*     */   }
/*     */ 
/*     */   
/*     */   public void saveDefault() {
/*  65 */     if (!userFile.exists()) {
/*  66 */       userConfigSave();
/*     */     }
/*  68 */     if (!groupFile.exists()) {
/*  69 */       ArrayList<String> perm = new ArrayList<>();
/*  70 */       perm.add("PERMISSION");
/*     */       
/*  72 */       groupConfig.set("default.default", Boolean.valueOf(true));
/*  73 */       groupConfig.set("default.chatprefix", "&7Spieler %player% | %message%");
/*  74 */       groupConfig.set("default.tabprefix", "&7Spieler %player%");
/*  75 */       groupConfig.set("default.permissions", perm);
/*  76 */       groupConfigSave();
/*     */     } 
/*  78 */     if (!playerFile.exists()) {
/*  79 */       List<String> players = new ArrayList<>();
/*  80 */       players.add("REMOVE ME!");
/*  81 */       playerConfig.set("Players", players);
/*     */       try {
/*  83 */         playerConfig.save(playerFile);
/*  84 */       } catch (IOException e) {
/*     */         
/*  86 */         e.printStackTrace();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void userConfigSave() {
/*     */     try {
/*  93 */       userConfig.save(userFile);
/*  94 */     } catch (IOException e) {
/*     */       
/*  96 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void groupConfigSave() {
/*     */     try {
/* 102 */       groupConfig.save(groupFile);
/* 103 */     } catch (IOException e) {
/*     */       
/* 105 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void userConfigLoad() {
/*     */     try {
/* 111 */       userConfig.load(userFile);
/* 112 */     } catch (FileNotFoundException e) {
/*     */       
/* 114 */       e.printStackTrace();
/* 115 */     } catch (IOException e) {
/*     */       
/* 117 */       e.printStackTrace();
/* 118 */     } catch (InvalidConfigurationException e) {
/*     */       
/* 120 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void groupConfigLoad() {
/*     */     try {
/* 126 */       groupConfig.load(groupFile);
/* 127 */     } catch (FileNotFoundException e) {
/*     */       
/* 129 */       e.printStackTrace();
/* 130 */     } catch (IOException e) {
/*     */       
/* 132 */       e.printStackTrace();
/* 133 */     } catch (InvalidConfigurationException e) {
/*     */       
/* 135 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\emrei\Downloads\Permissions.jar!\turonmc\perms\Main.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */