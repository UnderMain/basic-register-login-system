/*    */ package cloud.evaped.bungeeperms.main;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.util.HashMap;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.configuration.file.YamlConfiguration;
/*    */ 
/*    */ public class Files
/*    */ {
/* 11 */   public static HashMap<String, Object> getObject_MySQL = new HashMap<String, Object>();
/*    */   
/*    */   public void createDefaultMySQLFile() {
/*    */     try {
/* 15 */       File File = new File("plugins/BungeePerms/", "MySQL.yml");
/* 16 */       FileConfiguration cfg = YamlConfiguration.loadConfiguration(File);
/*    */       
/* 18 */       cfg.addDefault("MySQL.Host", "localhost");
/* 19 */       cfg.addDefault("MySQL.Port", Integer.valueOf(3306));
/* 20 */       cfg.addDefault("MySQL.Database", "database");
/* 21 */       cfg.addDefault("MySQL.User", "root");
/* 22 */       cfg.addDefault("MySQL.Password", "password");
/*    */       
/* 24 */       cfg.options().copyDefaults(true);
/* 25 */       cfg.save(File);
/*    */     } catch (Exception e) {
/* 27 */       if (BungeePermsPlugin.debug) {
/* 28 */         e.printStackTrace();
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public void loadDefaultMySQLFile() {
/*    */     try {
/* 35 */       File File = new File("plugins/BungeePerms/", "MySQL.yml");
/* 36 */       FileConfiguration cfg = YamlConfiguration.loadConfiguration(File);
/*    */       
/* 38 */       getObject_MySQL.put("Host", cfg.get("MySQL.Host"));
/* 39 */       getObject_MySQL.put("Port", cfg.get("MySQL.Port"));
/* 40 */       getObject_MySQL.put("Database", cfg.get("MySQL.Database"));
/* 41 */       getObject_MySQL.put("User", cfg.get("MySQL.User"));
/* 42 */       getObject_MySQL.put("Password", cfg.get("MySQL.Password"));
/*    */       
/* 44 */       cfg.save(File);
/*    */     } catch (Exception e) {
/* 46 */       if (BungeePermsPlugin.debug) {
/* 47 */         e.printStackTrace();
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Emre\Desktop\Webbase\Product\SpigotPermsAddOn.jar!\cloud\evaped\bungeeperms\main\Files.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */