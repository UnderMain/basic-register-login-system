/*    */ package cloud.evaped.bungeeperms.listener;
/*    */ 
/*    */ import cloud.evaped.bungeeperms.main.BungeePermsPlugin;
/*    */ import cloud.evaped.bungeeperms.utils.CustomPermissibleBase;
/*    */ import cloud.evaped.bungeeperms.utils.PlayerManager;
/*    */ import java.lang.reflect.Field;
/*    */ import java.util.HashMap;
/*    */ import java.util.UUID;
/*    */ import org.bukkit.craftbukkit.v1_8_R3.entity.CraftHumanEntity;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.EventPriority;
/*    */ import org.bukkit.event.player.PlayerLoginEvent;
/*    */ import org.bukkit.permissions.PermissionAttachment;
/*    */ 
/*    */ public class LoginListener implements org.bukkit.event.Listener
/*    */ {
/* 18 */   public static HashMap<String, PermissionAttachment> getAttachment = new HashMap();
/*    */   
/*    */   @EventHandler(priority=EventPriority.LOWEST)
/*    */   public void onPreLogin(PlayerLoginEvent e) {
/* 22 */     execute(e);
/* 23 */     if (!PlayerManager.getID.containsKey(e.getPlayer().getUniqueId().toString())) execute(e);
/* 24 */     if (!e.getPlayer().hasPermission((String)PlayerManager.getID.get(e.getPlayer().getUniqueId().toString()))) {
/* 25 */       execute(e);
/* 26 */       if (!e.getPlayer().hasPermission((String)PlayerManager.getID.get(e.getPlayer().getUniqueId().toString()))) execute(e);
/*    */     }
/* 28 */     PermissionAttachment att = e.getPlayer().addAttachment(BungeePermsPlugin.instance);
/* 29 */     for (String s : (java.util.List)PlayerManager.getPermissions.get(e.getPlayer().getUniqueId().toString())) {
/* 30 */       att.setPermission(s, true);
/*    */     }
/* 32 */     getAttachment.put(e.getPlayer().getUniqueId().toString(), att);
/*    */   }
/*    */   
/*    */   private void execute(PlayerLoginEvent e) {
/* 36 */     PlayerManager.instance.createPlayer(e.getPlayer());
/*    */     try {
/* 38 */       Field f = CraftHumanEntity.class.getDeclaredField("perm");
/* 39 */       f.setAccessible(true);
/* 40 */       f.set(e.getPlayer(), new CustomPermissibleBase(e.getPlayer()));
/* 41 */       f.setAccessible(false);
/*    */     } catch (Exception e1) {
/* 43 */       if (BungeePermsPlugin.debug) {
/* 44 */         e1.printStackTrace();
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Emre\Desktop\Webbase\Product\SpigotPermsAddOn.jar!\cloud\evaped\bungeeperms\listener\LoginListener.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */