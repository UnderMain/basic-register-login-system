/*    */ package turonmc.perms;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.bukkit.configuration.ConfigurationSection;
/*    */ 
/*    */ 
/*    */ public class Perm
/*    */ {
/*    */   public static ArrayList<String> getGroups() {
/* 11 */     ArrayList<String> groups = new ArrayList<>();
/*    */     
/* 13 */     ConfigurationSection cs = Main.groupConfig.getConfigurationSection("");
/*    */     
/* 15 */     for (String group : cs.getKeys(false)) {
/* 16 */       if (!groups.contains(group)) {
/* 17 */         groups.add(group);
/*    */       }
/*    */     } 
/* 20 */     return groups;
/*    */   }
/*    */   
/*    */   public static void addPermToGroup(String groupname, String permname) {
/* 24 */     List<String> perms = getPermsFromGroup(groupname);
/* 25 */     perms.add(permname);
/* 26 */     Main.groupConfig.set(String.valueOf(groupname) + ".permissions", perms);
/* 27 */     Main.plugin.groupConfigSave();
/*    */   }
/*    */   
/*    */   public static void removePermFromGroup(String groupname, String permname) {
/* 31 */     List<String> perms = getPermsFromGroup(groupname);
/* 32 */     perms.remove(permname);
/* 33 */     Main.groupConfig.set(String.valueOf(groupname) + ".permissions", perms);
/* 34 */     Main.plugin.groupConfigSave();
/*    */   }
/*    */   
/*    */   public static List<String> getPermsFromGroup(String groupname) {
/* 38 */     List<String> perms = Main.groupConfig.getStringList(String.valueOf(groupname) + ".permissions");
/* 39 */     return perms;
/*    */   }
/*    */   
/*    */   public static String getDefaultGroup() {
/* 43 */     ConfigurationSection cs = Main.groupConfig.getConfigurationSection("");
/*    */     
/* 45 */     for (String group : cs.getKeys(false)) {
/* 46 */       if (Main.groupConfig.getBoolean(String.valueOf(group) + ".default")) {
/* 47 */         return group;
/*    */       }
/*    */     } 
/* 50 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\emrei\Downloads\Permissions.jar!\turonmc\perms\Perm.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */