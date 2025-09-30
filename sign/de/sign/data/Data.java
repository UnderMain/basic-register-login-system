/*    */ package de.sign.data;
/*    */ 
/*    */ 
/*    */ public class Data
/*    */ {
/*    */   public static String getPrefix() {
/*  7 */     return prefix;
/*    */   }
/*    */   
/* 10 */   private static String prefix = "§6§lCityBuild §8× §r";
/*    */ 
/*    */   
/*    */   public static String getNoPerm() {
/* 14 */     return noPerm;
/*    */   }
/*    */   
/* 17 */   private static String noPerm = String.valueOf(prefix) + "§cDazu hast du keinen Zugriff.";
/*    */ }


/* Location:              G:\Server Dateien\transfer\neuesnetzwerk\reformcloud\templates\CityBuild\default\plugins\ZenitSign.jar!\de\sign\data\Data.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */