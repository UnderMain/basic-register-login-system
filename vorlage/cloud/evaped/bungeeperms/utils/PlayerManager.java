/*     */ package cloud.evaped.bungeeperms.utils;
/*     */ 
/*     */ import cloud.evaped.bungeeperms.main.BungeePermsPlugin;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.UUID;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ public class PlayerManager
/*     */ {
/*  14 */   public static HashMap<String, List<String>> getPermissions = new HashMap();
/*  15 */   public static HashMap<String, String> getID = new HashMap();
/*     */   public static PlayerManager instance;
/*     */   
/*     */   public PlayerManager() {
/*  19 */     instance = this;
/*     */   }
/*     */   
/*     */   public void createPlayer(Player p) {
/*  23 */     String name = p.getName();
/*  24 */     String UUID = p.getUniqueId().toString();
/*  25 */     String group = getPlayersGroup(UUID);
/*  26 */     if ((playerExistsUUID(UUID)) && 
/*  27 */       (!existsGroupID(getPlayersGroupID(name)))) {
/*  28 */       group = "default";
/*     */     }
/*     */     
/*     */ 
/*  32 */     String permissions = getPlayerPerms(name);
/*  33 */     String[] permissionsArray = permissions.split(";");
/*  34 */     String groupPermissions = getGroupPermissions(group);
/*  35 */     String[] groupPermissionsArray = groupPermissions.split(";");
/*     */     
/*  37 */     List<String> permissionsForPlayer = new ArrayList();
/*  38 */     for (int i = 1; i < permissionsArray.length; i++) {
/*  39 */       permissionsForPlayer.add(permissionsArray[i]);
/*     */     }
/*  41 */     for (int i = 1; i < groupPermissionsArray.length; i++) {
/*  42 */       if (!permissionsForPlayer.contains(groupPermissionsArray[i])) {
/*  43 */         permissionsForPlayer.add(groupPermissionsArray[i]);
/*     */       }
/*     */     }
/*  46 */     String id = UUID.randomUUID().toString();
/*  47 */     permissionsForPlayer.add(id);
/*  48 */     if (getPermissions.containsKey(UUID)) {
/*  49 */       getPermissions.remove(UUID);
/*  50 */       getPermissions.put(UUID, permissionsForPlayer);
/*     */     } else {
/*  52 */       getPermissions.put(UUID, permissionsForPlayer);
/*     */     }
/*  54 */     if (getID.containsKey(UUID)) {
/*  55 */       getID.remove(UUID);
/*  56 */       getID.put(UUID, id);
/*     */     } else {
/*  58 */       getID.put(UUID, id);
/*     */     }
/*     */   }
/*     */   
/*     */   private String getPlayersGroup(String UUID) {
/*  63 */     group = "null";
/*  64 */     ResultSet rs = null;
/*     */     try {
/*  66 */       rs = MySQL.instance.getResult("SELECT groupid FROM permsTable WHERE UUID='" + UUID + "'");
/*     */       
/*  68 */       if ((rs != null) && (rs.next())) {}
/*  69 */       return getGroupNameByID(rs.getInt("groupid"));
/*     */     }
/*     */     catch (SQLException e)
/*     */     {
/*  73 */       if (BungeePermsPlugin.debug) {
/*  74 */         e.printStackTrace();
/*     */       }
/*     */     } finally {
/*  77 */       if (rs != null) {
/*     */         try {
/*  79 */           rs.close();
/*     */         } catch (SQLException e) {
/*  81 */           if (BungeePermsPlugin.debug) {
/*  82 */             e.printStackTrace();
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private int getPlayersGroupID(String name)
/*     */   {
/*     */     try {
/*  92 */       ResultSet rs = MySQL.instance.getResult("SELECT * FROM permsTable WHERE name='" + name + "'");
/*  93 */       if ((rs != null) && (rs.next())) {
/*  94 */         return rs.getInt("groupid");
/*     */       }
/*  96 */       rs.close();
/*  97 */       return -1;
/*     */     } catch (SQLException e) {}
/*  99 */     return -1;
/*     */   }
/*     */   
/*     */   private boolean playerExistsUUID(String UUID)
/*     */   {
/*     */     try {
/* 105 */       ResultSet rs = MySQL.instance.getResult("SELECT * FROM permsTable WHERE UUID='" + UUID + "'");
/* 106 */       if (rs.next()) {
/* 107 */         return rs.getObject("UUID") != null;
/*     */       }
/* 109 */       rs.close();
/* 110 */       return false;
/*     */     } catch (SQLException e) {}
/* 112 */     return false;
/*     */   }
/*     */   
/*     */   private String getPlayerPerms(String name)
/*     */   {
/* 117 */     String permissions = "";
/*     */     try {
/* 119 */       ResultSet rs = MySQL.instance.getResult("SELECT * FROM permsTable WHERE name='" + name + "'");
/* 120 */       if (rs.next()) {
/* 121 */         permissions = rs.getString("permissions");
/*     */       }
/* 123 */       rs.close();
/*     */     }
/*     */     catch (SQLException localSQLException) {}
/* 126 */     return permissions;
/*     */   }
/*     */   
/*     */   private String getGroupNameByID(int groupid) {
/*     */     try {
/* 131 */       ResultSet rs = MySQL.instance.getResult("SELECT * FROM groupsTable WHERE groupid='" + groupid + "'");
/* 132 */       if (rs.next()) {
/* 133 */         return rs.getString("name");
/*     */       }
/* 135 */       return "null";
/*     */     } catch (SQLException e) {}
/* 137 */     return "null";
/*     */   }
/*     */   
/*     */   private String getGroupPermissions(String name)
/*     */   {
/*     */     try {
/* 143 */       ResultSet rs = MySQL.instance.getResult("SELECT * FROM groupsTable WHERE name='" + name + "'");
/* 144 */       if (rs.next()) {
/* 145 */         return rs.getString("permissions");
/*     */       }
/* 147 */       rs.close();
/* 148 */       return ";";
/*     */     } catch (SQLException e) {}
/* 150 */     return ";";
/*     */   }
/*     */   
/*     */   private boolean existsGroupID(int groupid)
/*     */   {
/*     */     try {
/* 156 */       ResultSet rs = MySQL.instance.getResult("SELECT * FROM groupsTable WHERE groupid='" + groupid + "'");
/* 157 */       if (rs.next()) {
/* 158 */         return rs.getObject("groupid") != null;
/*     */       }
/* 160 */       rs.close();
/* 161 */       return false;
/*     */     } catch (SQLException e) {}
/* 163 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Emre\Desktop\Webbase\Product\SpigotPermsAddOn.jar!\cloud\evaped\bungeeperm\\utils\PlayerManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */