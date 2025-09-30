/*    */ package turonmc.prefixsys;
/*    */ 
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerJoinEvent;
/*    */ import turonmc.perms.Main;
/*    */ import turonmc.perms.PlayerManager;
/*    */ 
/*    */ public class TabPrefix
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void onJoin(PlayerJoinEvent e) {
/* 15 */     Player p = e.getPlayer();
/* 16 */     setPrefix(PlayerManager.getGroup(p).toString(), p);
/*    */   }
/*    */   
/*    */   public void setPrefix(String groupname, Player p) {
/* 20 */     if (Main.groupConfig.getString(String.valueOf(groupname) + ".tabprefix") != null) {
/* 21 */       String prefix = Main.groupConfig.getString(String.valueOf(groupname) + ".tabprefix").replace("&", "§").replace("%player%", p.getName());
/* 22 */       p.setPlayerListName(prefix);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\emrei\Downloads\Permissions.jar!\turonmc\prefixsys\TabPrefix.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */