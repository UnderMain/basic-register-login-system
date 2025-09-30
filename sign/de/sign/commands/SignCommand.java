/*    */ package de.sign.commands;
/*    */ 
/*    */ import de.sign.data.Data;
/*    */ import de.sign.manager.SignManager;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ public class SignCommand
/*    */   implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
/* 16 */     if (!(sender instanceof Player)) {
/*    */       
/* 18 */       sender.sendMessage(String.valueOf(Data.getPrefix()) + "Du musst ein Spieler sein.");
/* 19 */       return false;
/*    */     } 
/* 21 */     Player player = (Player)sender;
/* 22 */     if (player.hasPermission("sign.use")) {
/*    */       
/* 24 */       if (args.length >= 1) {
/*    */         
/* 26 */         if (player.getItemInHand().getType() != Material.AIR) {
/*    */           
/* 28 */           if (player.getItemInHand().getAmount() == 1) {
/*    */             
/* 30 */             SignManager signManager = new SignManager(player.getItemInHand());
/* 31 */             if (args[0].equalsIgnoreCase("del")) {
/*    */               
/* 33 */               if (player.hasPermission("sign.owner.del")) {
/* 34 */                 if (signManager.isSigned()) {
/*    */                   
/* 36 */                   player.setItemInHand(signManager.unSign());
/* 37 */                   player.sendMessage(String.valueOf(Data.getPrefix()) + "§aDu hast erfolgreich die signatur entfernt.");
/*    */                 }
/*    */                 else {
/*    */                   
/* 41 */                   player.sendMessage(String.valueOf(Data.getPrefix()) + "§cDas Item wurde noch nicht signiert.");
/*    */                 } 
/*    */               } else {
/* 44 */                 player.sendMessage(String.valueOf(Data.getPrefix()) + "Usage: /sign <Message>");
/*    */               } 
/*    */             } else {
/*    */               
/* 48 */               StringBuilder stringBuilder = new StringBuilder(); byte b; int i; String[] arrayOfString;
/* 49 */               for (i = (arrayOfString = args).length, b = 0; b < i; ) { String arg = arrayOfString[b];
/* 50 */                 stringBuilder.append(arg).append(" "); b++; }
/*    */               
/* 52 */               if (!signManager.isSigned())
/*    */               {
/* 54 */                 player.setItemInHand(signManager.sign(player.getName(), stringBuilder.toString()));
/* 55 */                 player.sendMessage(String.valueOf(Data.getPrefix()) + "§aItem erfolgreich signiert.");
/*    */               }
/*    */               else
/*    */               {
/* 59 */                 player.sendMessage(String.valueOf(Data.getPrefix()) + "§cDas Item wurde breits signiert.");
/*    */               }
/*    */             
/*    */             } 
/*    */           } else {
/*    */             
/* 65 */             player.sendMessage(String.valueOf(Data.getPrefix()) + "§cDu darfst nur ein Item gleichzeitig signieren.");
/*    */           } 
/*    */         } else {
/*    */           
/* 69 */           player.sendMessage(String.valueOf(Data.getPrefix()) + "§cDu musst ein Item in der Hand halten.");
/*    */         }
/*    */       
/*    */       } else {
/*    */         
/* 74 */         player.sendMessage(String.valueOf(Data.getPrefix()) + "Usage: /sign <Message>");
/*    */       } 
/*    */     } else {
/*    */       
/* 78 */       player.sendMessage(Data.getNoPerm());
/*    */     } 
/* 80 */     return false;
/*    */   }
/*    */ }


/* Location:              G:\Server Dateien\transfer\neuesnetzwerk\reformcloud\templates\CityBuild\default\plugins\ZenitSign.jar!\de\sign\commands\SignCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */