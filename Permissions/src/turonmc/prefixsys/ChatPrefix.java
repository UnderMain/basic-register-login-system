/*    */ package turonmc.prefixsys;
/*    */ 
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.AsyncPlayerChatEvent;
/*    */ import turonmc.perms.Main;
/*    */ import turonmc.perms.PlayerManager;
/*    */ 
/*    */ public class ChatPrefix
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void onChat(AsyncPlayerChatEvent e) {
/* 16 */     Player p = e.getPlayer();
/* 17 */     String group = PlayerManager.getGroup(p).toString();
/* 18 */     if (Main.groupConfig.getString(String.valueOf(group) + ".chatprefix") != null && !e.getMessage().startsWith("/")) {
/* 19 */       String format = Main.groupConfig.getString(String.valueOf(group) + ".chatprefix");
/* 20 */       e.setCancelled(true);
/* 21 */       Bukkit.broadcastMessage(format.replace("&", "§").replace("%player%", p.getName()).replace("%message%", e.getMessage()));
/* 22 */     } else if (Main.groupConfig.getString(String.valueOf(group) + ".chatprefix") == null || !e.getMessage().startsWith("/")) {
/* 23 */       e.setCancelled(true);
/* 24 */       Bukkit.broadcastMessage("§7" + p.getDisplayName() + " §8| §7" + e.getMessage());
/*    */     } else {
/* 26 */       e.setCancelled(false);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\emrei\Downloads\Permissions.jar!\turonmc\prefixsys\ChatPrefix.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */