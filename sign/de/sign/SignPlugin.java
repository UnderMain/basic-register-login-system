/*    */ package de.sign;
/*    */ 
/*    */ import de.sign.commands.SignCommand;
/*    */ import de.sign.data.Data;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.plugin.PluginManager;
/*    */ import org.bukkit.plugin.java.JavaPlugin;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SignPlugin
/*    */   extends JavaPlugin
/*    */ {
/*    */   public void onEnable() {
/* 16 */     loadCommands();
/* 17 */     loadListener(Bukkit.getPluginManager());
/*    */     
/* 19 */     log("§aPlugin geladen.");
/*    */   }
/*    */ 
/*    */   
/*    */   private void loadCommands() {
/* 24 */     getCommand("sign").setExecutor((CommandExecutor)new SignCommand());
/*    */   }
/*    */ 
/*    */   
/*    */   public static void log(String message) {
/* 29 */     Bukkit.getConsoleSender().sendMessage(String.valueOf(Data.getPrefix()) + message);
/*    */   }
/*    */   
/*    */   public void onDisable() {}
/*    */   
/*    */   private void loadListener(PluginManager pluginManager) {}
/*    */ }


/* Location:              G:\Server Dateien\transfer\neuesnetzwerk\reformcloud\templates\CityBuild\default\plugins\ZenitSign.jar!\de\sign\SignPlugin.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */