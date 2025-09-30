/*    */ package cloud.evaped.bungeeperms.utils;
/*    */ 
/*    */ import cloud.evaped.bungeeperms.main.Files;
/*    */ import java.sql.Connection;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.SQLException;
/*    */ import java.sql.Statement;
/*    */ 
/*    */ public class MySQL
/*    */ {
/*    */   public static MySQL instance;
/*    */   public static Connection con;
/*    */   
/*    */   public MySQL()
/*    */   {
/* 17 */     instance = this;
/* 18 */     connect();
/*    */   }
/*    */   
/*    */ 
/*    */   public void connect()
/*    */   {
/* 24 */     if (!isConnected()) {
/*    */       try {
/* 26 */         String host = Files.getObject_MySQL.get("Host").toString();
/* 27 */         int port = Integer.parseInt(Files.getObject_MySQL.get("Port") + "");
/* 28 */         String database = Files.getObject_MySQL.get("Database").toString();
/* 29 */         String user = Files.getObject_MySQL.get("User").toString();
/* 30 */         String password = Files.getObject_MySQL.get("Password").toString();
/* 31 */         con = java.sql.DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?autoReconnect=true", "" + user, "" + password);
/*    */       } catch (Exception e) {
/* 33 */         if (cloud.evaped.bungeeperms.main.BungeePermsPlugin.debug) {
/* 34 */           e.printStackTrace();
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public void disconnect() {
/* 41 */     if (isConnected()) {
/*    */       try {
/* 43 */         con.close();
/*    */       } catch (Exception e) {
/* 45 */         if (cloud.evaped.bungeeperms.main.BungeePermsPlugin.debug) {
/* 46 */           e.printStackTrace();
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean isConnected() {
/* 53 */     return con != null;
/*    */   }
/*    */   
/*    */   public ResultSet getResult(String qry) {
/* 57 */     ResultSet rs = null;
/*    */     try {
/* 59 */       Statement st = con.createStatement();
/* 60 */       rs = st.executeQuery(qry);
/*    */     } catch (SQLException e) {
/* 62 */       connect();
/*    */     }
/* 64 */     return rs;
/*    */   }
/*    */   
/*    */   public static Connection getConnection() {
/* 68 */     return con;
/*    */   }
/*    */ }
