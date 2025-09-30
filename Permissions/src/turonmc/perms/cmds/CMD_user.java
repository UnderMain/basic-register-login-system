/*    */ package turonmc.perms.cmds;
/*    */ 
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ import turonmc.perms.Main;
/*    */ import turonmc.perms.Perm;
/*    */ import turonmc.perms.PlayerManager;
/*    */ 
/*    */ 
/*    */ public class CMD_user
/*    */   implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
/* 17 */     
/* 18 */       Player p = (Player)sender;
/* 19 */       if (!p.hasPermission("permissions.*")) {
/* 20 */         p.sendMessage("§7[§cFehler§7] Dazu hast du Keine Rechte!");
/* 21 */       } else if (p.hasPermission("permissions.*")) {
/* 22 */         if (args.length == 0) {
/* 23 */           sendUserHelp(p);
/* 24 */         } else if (args.length == 2) {
/* 25 */           if (args[0].equalsIgnoreCase("info")) {
/* 26 */             Player target = Bukkit.getPlayer(args[1]);
/* 27 */             p.sendMessage(
/* 28 */                 "§c" + target.getName() + " §6ist in der Gruppe §c" + PlayerManager.getGroup(target));
/* 29 */           } else if (args[0].equalsIgnoreCase("setdefault")) {
/* 30 */             Player target = Bukkit.getPlayer(args[1]);
/* 31 */             PlayerManager.setGroup(Perm.getDefaultGroup(), target);
/* 32 */             target.kickPlayer("§aNeuer Rang!");
/* 33 */             p.sendMessage("§6Der Spieler §c" + target.getName() + " §6ist nun in der §cdefault §6Gruppe");
/*    */           } else {
/* 35 */             sendUserHelp(p);
/*    */           } 
/* 37 */         } else if (args.length == 3) {
/* 38 */           if (args[0].equalsIgnoreCase("set")) {
/* 39 */             Player target = Bukkit.getPlayer(args[1]);
/* 40 */             if (target != null) {
/* 41 */               if (Main.groupConfig.getString(args[2]) != null) {
/* 42 */                 PlayerManager.setGroup(args[2], target);
/* 43 */                 target.kickPlayer("§aNeuer Rang!");
/* 44 */                 p.sendMessage("§6Der Spieler §c" + target.getName() + " §6ist nun in der Gruppe §c" + 
/* 45 */                     args[2]);
/*    */               } else {
/* 47 */                 p.sendMessage("§7[§cFehler§7] Die Gruppe existiert nicht!");
/*    */               } 
/*    */             } else {
/* 50 */               p.sendMessage("§7[§cFehler§7] Der Spieler §c" + args[1] + " §7ist nicht online!");
/* 51 */               return false;
/*    */             } 
/*    */           } else {
/* 54 */             sendUserHelp(p);
/*    */           } 
/*    */         } else {
/* 57 */           sendUserHelp(p);
/*    */         } 
/*    */       } 

/* 63 */     return false;
/*    */   }
/*    */   
/*    */   public void sendUserHelp(Player p) {
/* 67 */     p.sendMessage("§c/User set <Player> <Group> §8- §7Füge einen Spieler zu einer Gruppe hinzu");
/* 68 */     p.sendMessage("§c/User remove <Player> <Group> §8- §7Entferne einen Spieler aus einer Gruppe");
/* 69 */     p.sendMessage("§c/User info <Player> §8- §7Erhalte eine Info über einen Spieler");
/*    */   }
/*    */ }


/* Location:              C:\Users\emrei\Downloads\Permissions.jar!\turonmc\perms\cmds\CMD_user.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */