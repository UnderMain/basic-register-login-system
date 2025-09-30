/*    */ package turonmc.perms;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ 
/*    */ public class PlayerManager
/*    */ {
/*    */   public static void initPerm(Player p, String groupname) {
/* 11 */     if (Main.userConfig.getString(String.valueOf(p.getUniqueId().toString()) + ".group") != null) {
/*    */ 
/*    */       
/* 14 */       List<String> list = Perm.getPermsFromGroup(groupname);
/*    */       
/* 16 */       for (String permname : list) {
/* 17 */         p.addAttachment((Plugin)Main.plugin, permname, false);
/*    */       }
/*    */     } 
/* 20 */     Main.userConfig.set(String.valueOf(p.getUniqueId().toString()) + ".group", groupname);
/* 21 */     Main.plugin.userConfigSave();
/* 22 */     Main.plugin.userConfigLoad();
/*    */     
/* 24 */     List<String> perms = Perm.getPermsFromGroup(groupname);
/*    */     
/* 26 */     for (String permname : perms) {
/* 27 */       p.addAttachment((Plugin)Main.plugin, permname, true);
/*    */     }
/*    */   }
/*    */   
/*    */   public static String getGroup(Player p) {
/* 32 */     return Main.userConfig.getString(String.valueOf(p.getUniqueId().toString()) + ".group");
/*    */   }
/*    */   
/*    */   public static void setGroup(String groupname, Player p) {
/* 36 */     initPerm(p, groupname);
/*    */   }
/*    */   
/*    */   public static Player nameToPlayer(String name) {
/* 40 */     Player p = Bukkit.getPlayer(name);
/* 41 */     return p;
/*    */   }
/*    */   
/*    */   public static String playerToName(Player p) {
/* 45 */     String name = p.getName();
/* 46 */     return name;
/*    */   }
/*    */ }


/* Location:              C:\Users\emrei\Downloads\Permissions.jar!\turonmc\perms\PlayerManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */