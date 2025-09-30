/*    */ package cloud.evaped.bungeeperms.main;
/*    */ 
/*    */ import cloud.evaped.bungeeperms.listener.LoginListener;
/*    */ import cloud.evaped.bungeeperms.listener.QuitEvent;
/*    */ import cloud.evaped.bungeeperms.utils.MySQL;
/*    */ import cloud.evaped.bungeeperms.utils.PlayerManager;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.plugin.PluginManager;
/*    */ import org.bukkit.plugin.java.JavaPlugin;
/*    */ 
/*    */ public class BungeePermsPlugin extends JavaPlugin
/*    */ {
/*    */   public static BungeePermsPlugin instance;
/*    */   public static boolean debug;
/*    */   
/*    */   public void onEnable()
/*    */   {
/* 18 */     instance = this;
/* 19 */     debug = true;
/* 20 */     registerFiles();
/* 21 */     registerCommands();
/* 22 */     registerListener();
/* 23 */     run();
/*    */   }
/*    */   
/*    */   public void onDisable()
/*    */   {
/* 28 */     MySQL.instance.disconnect();
/*    */   }
/*    */   
/*    */   private void registerFiles() {
/* 32 */     new Files().createDefaultMySQLFile();
/*    */   }
/*    */   
/*    */ 
/*    */   private void registerCommands() {}
/*    */   
/*    */   private void registerListener()
/*    */   {
/* 40 */     PluginManager pm = Bukkit.getPluginManager();
/* 41 */     pm.registerEvents(new LoginListener(), this);
/* 42 */     pm.registerEvents(new QuitEvent(), this);
/*    */   }
/*    */   
/*    */   private void run() {
/* 46 */     new Loader();
/* 47 */     new MySQL();
/* 48 */     new PlayerManager();
/*    */   }
/*    */ }


/* Location:              C:\Users\Emre\Desktop\Webbase\Product\SpigotPermsAddOn.jar!\cloud\evaped\bungeeperms\main\BungeePermsPlugin.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */