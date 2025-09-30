/*    */ package turonmc.perms.cmds;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.util.List;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.configuration.file.YamlConfiguration;
/*    */ import org.bukkit.entity.Player;
/*    */ import turonmc.mysql.MySQL;
/*    */ import turonmc.perms.Main;
/*    */ import turonmc.perms.Perm;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CMD_perm
/*    */   implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {

/* 22 */       Player p = (Player)sender;
/* 23 */       if (!p.hasPermission("permissions.*")) {
/* 24 */         p.sendMessage("§7[§cFehler§7] Dazu hast du Keine Rechte!");
/* 25 */       } else if (p.hasPermission("permissions.*")) {
/* 26 */         if (args.length != 1) {
/* 27 */           sendHelp(p);
/* 28 */         } else if (args.length == 1) {
/* 29 */           if (args[0].equalsIgnoreCase("reload")) {
/* 30 */             File file = new File("plugins/Permissions", "database.yml");
/* 31 */             YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);
/* 32 */             if (yamlConfiguration.getBoolean("MySQL")) {
/* 33 */               if (MySQL.isConnected()) {
/* 34 */                 List<String> perms = null;
/* 35 */                 for (String all : Perm.getGroups()) {
/* 36 */                   perms = Main.groupConfig.getStringList(String.valueOf(all) + ".permissions");
/* 37 */                   for (int i = 0; i < perms.size(); i++) {
/* 38 */                     MySQL.update("UPDATE " + yamlConfiguration.getString("database.database") + " SET " + all + ".permissions='" + perms + "';");
/*    */                   }
/*    */                 } 
/*    */               } else {
/* 42 */                 p.sendMessage("§7[§cFehler§7] MySQL ist nicht verbunden!");
/*    */               } 
/*    */             } else {
/* 45 */               p.sendMessage("§7[§cFehler§7] MySQL ist deaktiviert!");
/*    */             } 
/*    */           } else {
/* 48 */             sendHelp(p);
/*    */           } 
/*    */         } 
/*    */       } 

/* 55 */     return false;
/*    */   }
/*    */   
/*    */   public void sendHelp(Player p) {
/* 59 */     p.sendMessage("§6------------------------Help-------------------------");
/* 60 */     p.sendMessage("§c/Perm reload §8- §7Reloade die MySQL verbindung falls aktiv");
/* 61 */     p.sendMessage(" ");
/* 62 */     p.sendMessage("§c/User set <Player> <Group> §8- §7Füge einen Spieler zu einer Gruppe hinzu");
/* 63 */     p.sendMessage("§c/User remove <Player> <Group> §8- §7Entferne einen Spieler aus einer Gruppe");
/* 64 */     p.sendMessage("§c/User info <Player> §8- §7Erhalte eine Info über einen Spieler");
/* 65 */     p.sendMessage(" ");
/* 66 */     p.sendMessage("§c/Group add <Group> <Permission> §8- §7Füge einer Gruppe eine Permission hinzu");
/* 67 */     p.sendMessage("§c/Group remove <Group> <Permission> §8- §7Entferne eine Permission aus einer Gruppe");
/* 68 */     p.sendMessage("§c/Group create <Name> §8- §7Erstelle eine Gruppe");
/* 69 */     p.sendMessage("§c/Group delete <Group> §8- §7Lösche eine Gruppe");
/* 70 */     p.sendMessage("§c/Group list §8- §7Lasse dir alle Gruppen auflisten");
/* 71 */     p.sendMessage("§6------------------------Help-------------------------");
/*    */   }
/*    */ }


/* Location:              C:\Users\emrei\Downloads\Permissions.jar!\turonmc\perms\cmds\CMD_perm.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */