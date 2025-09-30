/*    */ package cloud.evaped.bungeeperms.utils;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ 
/*    */ public class CustomPermissibleBase extends org.bukkit.permissions.PermissibleBase
/*    */ {
/*  8 */   private String uuid = "";
/*    */   
/*    */   public CustomPermissibleBase(org.bukkit.entity.Player opable) {
/* 11 */     super(opable);
/* 12 */     this.uuid = opable.getUniqueId().toString();
/*    */   }
/*    */   
/*    */   public boolean hasPermission(String permission)
/*    */   {
/* 17 */     permission = permission.toLowerCase();
/* 18 */     if (((List)PlayerManager.getPermissions.get(this.uuid)).contains("-" + permission)) return false;
/* 19 */     if (((List)PlayerManager.getPermissions.get(this.uuid)).contains("*")) return true;
/* 20 */     if (((List)PlayerManager.getPermissions.get(this.uuid)).contains(permission)) return true;
/* 21 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Emre\Desktop\Webbase\Product\SpigotPermsAddOn.jar!\cloud\evaped\bungeeperm\\utils\CustomPermissibleBase.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */