/*    */ package cloud.evaped.bungeeperms.listener;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.UUID;
/*    */ import org.bukkit.event.player.PlayerQuitEvent;
/*    */ 
/*    */ public class QuitEvent implements org.bukkit.event.Listener
/*    */ {
/*    */   @org.bukkit.event.EventHandler
/*    */   public void onQuit(PlayerQuitEvent e)
/*    */   {
/* 12 */     cloud.evaped.bungeeperms.utils.PlayerManager.getPermissions.remove(e.getPlayer().getUniqueId().toString());
/* 13 */     cloud.evaped.bungeeperms.utils.PlayerManager.getID.remove(e.getPlayer().getUniqueId().toString());
/* 14 */     LoginListener.getAttachment.remove(e.getPlayer().getUniqueId().toString());
/*    */   }
/*    */ }


/* Location:              C:\Users\Emre\Desktop\Webbase\Product\SpigotPermsAddOn.jar!\cloud\evaped\bungeeperms\listener\QuitEvent.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */