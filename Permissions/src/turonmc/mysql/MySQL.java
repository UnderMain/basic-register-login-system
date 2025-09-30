/*     */ package turonmc.mysql;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import java.util.List;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.configuration.file.YamlConfiguration;
/*     */ import org.bukkit.entity.Player;
/*     */ import turonmc.perms.Main;
/*     */ import turonmc.perms.Perm;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MySQL
/*     */ {
/*     */   private String host;
/*     */   private int port;
/*     */   private String user;
/*     */   private String password;
/*     */   private static String database;
/*     */   private static Connection con;
/*     */   
/*     */   public MySQL() throws Exception {
/*  30 */     File file = new File("plugins/Permissions", "database.yml");
/*  31 */     YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);
/*     */     
/*  33 */     String db = "database.";
/*     */     
/*  35 */     yamlConfiguration.addDefault("MySQL", Boolean.valueOf(false));
/*  36 */     yamlConfiguration.addDefault(String.valueOf(db) + "host", "localhost");
/*  37 */     yamlConfiguration.addDefault(String.valueOf(db) + "port", Integer.valueOf(3306));
/*  38 */     yamlConfiguration.addDefault(String.valueOf(db) + "user", "user");
/*  39 */     yamlConfiguration.addDefault(String.valueOf(db) + "password", "password");
/*  40 */     yamlConfiguration.addDefault(String.valueOf(db) + "database", "database");
/*     */     
/*  42 */     yamlConfiguration.options().copyDefaults(true);
/*     */     try {
/*  44 */       yamlConfiguration.save(file);
/*  45 */     } catch (IOException iOException) {}
/*     */     
/*  47 */     this.host = yamlConfiguration.getString(String.valueOf(db) + "host");
/*  48 */     this.port = yamlConfiguration.getInt(String.valueOf(db) + "port");
/*  49 */     this.user = yamlConfiguration.getString(String.valueOf(db) + "user");
/*  50 */     this.password = yamlConfiguration.getString(String.valueOf(db) + "password");
/*  51 */     database = yamlConfiguration.getString(String.valueOf(db) + "database");
/*     */     
/*  53 */     if (yamlConfiguration.getBoolean("MySQL")) {
/*  54 */       connect();
/*     */     }
/*     */   }
/*     */   
/*     */   public Connection connect() {
/*     */     try {
/*  60 */       Class.forName("com.mysql.jdbc.Driver");
/*  61 */       Bukkit.getConsoleSender().sendMessage("§6Verbinde mit MySQL...!");
/*  62 */     } catch (ClassNotFoundException e) {
/*  63 */       Bukkit.getConsoleSender().sendMessage("§cKonnte nicht mit MySQL verbinden!");
/*     */     } 
/*  65 */     Connection con = null;
/*     */     try {
/*  67 */       con = DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" + 
/*  68 */           database + "?user=" + this.user + "&password=" + this.password + "&autoReconnect=true");
/*  69 */       MySQL.con = con;
/*  70 */       Bukkit.getConsoleSender().sendMessage("§aErfolgreich mit MySQL verbunden!");
/*  71 */       createTables();
/*  72 */       return MySQL.con;
/*  73 */     } catch (SQLException e) {
/*  74 */       Bukkit.getConsoleSender().sendMessage("§cKonnte nicht mit MySQL verbinden!");
/*     */       
/*  76 */       return con;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void disconnect() {
/*  81 */     if (isConnected()) {
/*     */       try {
/*  83 */         con.close();
/*  84 */         System.out.println("§aDie MySQL Verbindung wurde getrennt!");
/*  85 */       } catch (SQLException e) {
/*  86 */         e.printStackTrace();
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isConnected() {
/*  93 */     return (con != null);
/*     */   }
/*     */   
/*     */   public static void update(String qry) {
/*  97 */     if (isConnected()) {
/*     */       try {
/*  99 */         Statement st = con.createStatement();
/* 100 */         st.executeUpdate(qry);
/* 101 */         st.close();
/* 102 */       } catch (SQLException e) {
/* 103 */         isConnected();
/* 104 */         System.err.println(e);
/*     */       } 
/* 106 */       boolean def = false;
/* 107 */       String tab = null;
/* 108 */       String chat = null;
/* 109 */       List<String> perms = null;
/* 110 */       for (String all : Perm.getGroups()) {
/* 111 */         def = Main.groupConfig.getBoolean(String.valueOf(all) + ".default");
/* 112 */         tab = Main.groupConfig.getString(String.valueOf(all) + ".tabprefix");
/* 113 */         chat = Main.groupConfig.getString(String.valueOf(all) + ".chatprefix");
/* 114 */         perms = Main.groupConfig.getStringList(String.valueOf(all) + ".permissions");
/* 115 */         Main.groupConfig.set(String.valueOf(all) + ".default", Boolean.valueOf(def));
/* 116 */         Main.groupConfig.set(String.valueOf(all) + ".tabprefix", tab);
/* 117 */         Main.groupConfig.set(String.valueOf(all) + ".chatprefix", chat);
/* 118 */         for (int i = 0; i < perms.size(); i++) {
/* 119 */           update("UPDATE " + database + " SET " + all + ".permissions='" + perms + "';");
/*     */         }
/*     */       } 
/* 122 */       for (Player all : Bukkit.getOnlinePlayers()) {
/* 123 */         all.kickPlayer("§c§lPERMISSION RELOAD");
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public ResultSet getResult(String qry) {
/* 129 */     if (isConnected()) {
/*     */       try {
/* 131 */         return con.createStatement().executeQuery(qry);
/* 132 */       } catch (SQLException e) {
/* 133 */         e.printStackTrace();
/*     */       } 
/*     */     }
/* 136 */     return null;
/*     */   }
/*     */   
/*     */   public void createTables() {
/* 140 */     if (isConnected()) {
/* 141 */       for (String all : Perm.getGroups()) {
/* 142 */         update("CREATE TABLE IF NOT EXISTS " + all + "(State String);");
/* 143 */         update("CREATE TABLE IF NOT EXISTS " + all + ".default" + "(State boolean);");
/* 144 */         update("CREATE TABLE IF NOT EXISTS " + all + ".tabprefix" + "(State String);");
/* 145 */         update("CREATE TABLE IF NOT EXISTS " + all + ".chatprefix" + "(State String);");
/* 146 */         update("CREATE TABLE IF NOT EXISTS " + all + ".permissions" + "(State List);");
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public void addPermission(String groupname, String permission) {
/* 152 */     List<String> perms = Main.groupConfig.getStringList(String.valueOf(groupname) + ".permissions");
/* 153 */     perms.add(permission);
/* 154 */     for (String all : Perm.getGroups()) {
/* 155 */       for (int i = 0; i < perms.size(); i++) {
/* 156 */         update("UPDATE " + database + " SET " + all + ".permissions='" + perms + "';");
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void removePermission(String groupname, String permission) {
/* 162 */     List<String> perms = Main.groupConfig.getStringList(String.valueOf(groupname) + ".permissions");
/* 163 */     perms.remove(permission);
/* 164 */     for (String all : Perm.getGroups()) {
/* 165 */       for (int i = 0; i < perms.size(); i++)
/* 166 */         update("UPDATE " + database + " SET " + all + ".permissions='" + perms + "';"); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\emrei\Downloads\Permissions.jar!\turonmc\mysql\MySQL.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */