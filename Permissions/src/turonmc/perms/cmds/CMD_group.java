/*     */ package turonmc.perms.cmds;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.entity.Player;
/*     */ import turonmc.perms.Main;
/*     */ import turonmc.perms.Perm;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CMD_group
/*     */   implements CommandExecutor
/*     */ {
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
/*  18 */     List<String> players = new ArrayList<>();
/*  19 */     players.add("REMOVE ME!");
/*  20 */     players.add("REMOVE ME!!");
/*  21 */     players.add("REMOVE ME!!!");
/*     */     
/*  23 */     if (sender instanceof Player) {
/*  24 */       Player p = (Player)sender;
/*  25 */       if (!p.hasPermission("permissions.*")) {
/*  26 */         p.sendMessage("§7[§cFehler§7] Dazu hast du Keine Rechte!");
/*  27 */       } else if (p.hasPermission("permissions.*")) {
/*  28 */         if (args.length == 0) {
/*  29 */           sendGroupHelp(p);
/*  30 */         } else if (args.length == 1) {
/*  31 */           if (args[0].equalsIgnoreCase("list")) {
/*  32 */             for (String all : Perm.getGroups()) {
/*  33 */               p.sendMessage("§2" + all);
/*     */             }
/*     */           } else {
/*  36 */             sendGroupHelp(p);
/*     */           } 
/*  38 */         } else if (args.length == 2) {
/*  39 */           if (args[0].equalsIgnoreCase("delete")) {
/*  40 */             if (Main.groupConfig.get(args[1]) != null) {
/*  41 */               if (Main.groupConfig.getBoolean(String.valueOf(args[1]) + ".default")) {
/*  42 */                 p.sendMessage("§7[§cFehler§7] Du darfst die Default Gruppe nicht Löschen!");
/*     */               } else {
/*  44 */                 Main.groupConfig.set(args[1], null);
/*  45 */                 Main.plugin.groupConfigSave();
/*  46 */                 p.sendMessage("§6Die Gruppe §c" + args[1] + " §6wurde erfolgreich gelöscht!");
/*     */               } 
/*     */             } else {
/*  49 */               p.sendMessage("§7[§cFehler§7] Diese Gruppe existiert nicht!");
/*     */             } 
/*  51 */           } else if (args[0].equalsIgnoreCase("create")) {
/*  52 */             if (Main.groupConfig.get(args[1]) == null) {
/*  53 */               Main.groupConfig.set(String.valueOf(args[1]) + ".default", Boolean.valueOf(false));
/*  54 */               Main.groupConfig.set(String.valueOf(args[1]) + ".permissions", players);
/*  55 */               Main.plugin.groupConfigSave();
/*  56 */               p.sendMessage("§6Die Gruppe §c" + args[1] + " §6wurde erfolgreich erstellt!");
/*     */             } else {
/*  58 */               p.sendMessage("§7[§cFehler§7] Diese Gruppe existiert bereits!");
/*     */             } 
/*     */           } else {
/*  61 */             sendGroupHelp(p);
/*     */           } 
/*  63 */         } else if (args.length == 3) {
/*  64 */           if (args[0].equalsIgnoreCase("remove")) {
/*  65 */             List<String> perms = Main.groupConfig.getStringList(String.valueOf(args[1]) + ".permissions");
/*  66 */             if (Main.groupConfig.get(args[1]) != null) {
/*  67 */               if (perms.contains(args[2])) {
/*  68 */                 perms.remove(args[2]);
/*  69 */                 Main.groupConfig.set(String.valueOf(args[1]) + ".permissions", perms);
/*  70 */                 Main.plugin.groupConfigSave();
/*  71 */                 p.sendMessage("§6Die Permission wurde erfolgreich entfernt!");
/*     */               } else {
/*  73 */                 p.sendMessage("§7[§cFehler§7] Diese Gruppe besitzt die Permission nicht!");
/*     */               } 
/*     */             } else {
/*  76 */               p.sendMessage("§7[§cFehler§7] Diese Gruppe existiert nicht!");
/*     */             } 
/*  78 */           } else if (args[0].equalsIgnoreCase("add")) {
/*  79 */             List<String> perms = Main.groupConfig.getStringList(String.valueOf(args[1]) + ".permissions");
/*  80 */             if (Main.groupConfig.get(args[1]) != null) {
/*  81 */               if (!perms.contains(args[2])) {
/*  82 */                 perms.add(args[2]);
/*  83 */                 Main.groupConfig.set(String.valueOf(args[1]) + ".permissions", perms);
/*  84 */                 Main.plugin.groupConfigSave();
/*  85 */                 p.sendMessage("§6Die Permission wurde erfolgreich hinzugefügt!");
/*     */               } else {
/*  87 */                 p.sendMessage("§7[§cFehler§7] Diese Gruppe besitzt die Permission bereits!");
/*     */               } 
/*     */             } else {
/*  90 */               p.sendMessage("§7[§cFehler§7] Diese Gruppe existiert nicht!");
/*     */             } 
/*     */           } else {
/*  93 */             sendGroupHelp(p);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } else {
/*  98 */       sender.sendMessage("§7[§cFehler§7] Du musst ein Spieler sein!");
/*     */     } 
/* 100 */     return false;
/*     */   }
/*     */   
/*     */   public void sendGroupHelp(Player p) {
/* 104 */     p.sendMessage("§c/Group add <Group> <Permission> §8- §7Füge einer Gruppe eine Permission hinzu");
/* 105 */     p.sendMessage("§c/Group remove <Group> <Permission> §8- §7Entferne eine Permission aus einer Gruppe");
/* 106 */     p.sendMessage("§c/Group create <Name> §8- §7Erstelle eine Gruppe");
/* 107 */     p.sendMessage("§c/Group delete <Group> §8- §7Lösche eine Gruppe");
/* 108 */     p.sendMessage("§c/Group list §8- §7Lasse dir alle Gruppen auflisten!");
/*     */   }
/*     */ }


/* Location:              C:\Users\emrei\Downloads\Permissions.jar!\turonmc\perms\cmds\CMD_group.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */