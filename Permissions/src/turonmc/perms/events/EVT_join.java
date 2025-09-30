/*    */ package turonmc.perms.events;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerJoinEvent;
/*    */ import turonmc.perms.Main;
/*    */ import turonmc.perms.Perm;
/*    */ import turonmc.perms.PlayerManager;
/*    */ 
/*    */ 
/*    */ public class EVT_join
/*    */   implements Listener
/*    */ {
/* 17 */   List<String> players = Main.playerConfig.getStringList("Players");
/*    */   
/*    */   @EventHandler
/*    */   public void onJoin(PlayerJoinEvent e) {
/* 21 */     Player p = e.getPlayer();
/* 22 */     if (!Main.playerConfig.getStringList("Players").contains(p.getUniqueId().toString())) {
/* 23 */       if (Perm.getDefaultGroup() != null) {
/* 24 */         PlayerManager.setGroup(Perm.getDefaultGroup(), p);
/* 25 */         this.players.add(p.getUniqueId().toString());
/* 26 */         Main.playerConfig.set("Players", this.players);
/*    */         try {
/* 28 */           Main.playerConfig.save(Main.playerFile);
/* 29 */         } catch (IOException e1) {
/* 30 */           e1.printStackTrace();
/*    */         } 
/*    */       } 
/*    */     } else {
/* 34 */       PlayerManager.initPerm(p, PlayerManager.getGroup(p));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\emrei\Downloads\Permissions.jar!\turonmc\perms\events\EVT_join.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */