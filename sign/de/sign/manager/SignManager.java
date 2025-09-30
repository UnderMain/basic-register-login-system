/*    */ package de.sign.manager;
/*    */ 
/*    */ import com.google.common.collect.Lists;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.List;
/*    */ import net.minecraft.server.v1_8_R3.ItemStack;
/*    */ import net.minecraft.server.v1_8_R3.NBTTagCompound;
/*    */ import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ 
/*    */ public class SignManager {
/*    */   private ItemStack itemStack;
/*    */   
/*    */   public SignManager(ItemStack itemStack) {
/* 16 */     this.itemStack = itemStack;
/*    */   }
/*    */   
/*    */   public ItemStack sign(String name, String message) {
/*    */     List<String> lore;
/* 21 */     if (!isSigned()) {
/* 22 */       setSigned(true);
/*    */     }
/* 24 */     ItemMeta itemMeta = this.itemStack.getItemMeta();
/*    */     
/* 26 */     if (itemMeta.getLore() == null) {
/* 27 */       lore = Lists.newArrayList();
/*    */     } else {
/* 29 */       lore = itemMeta.getLore();
/*    */     } 
/* 31 */     lore.add("§7" + message.replace('&', '§'));
/* 32 */     lore.add("§7§m-----------------------------------");
/* 33 */     lore.add("§7Signiert von§c " + name + " §7am §c" + fortmatTime(Long.valueOf(System.currentTimeMillis())));
/*    */     
/* 35 */     itemMeta.setLore(lore);
/* 36 */     this.itemStack.setItemMeta(itemMeta);
/* 37 */     return this.itemStack;
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemStack unSign() {
/* 42 */     if (isSigned()) {
/* 43 */       setSigned(false);
/*    */     }
/* 45 */     ItemMeta itemMeta = this.itemStack.getItemMeta();
/* 46 */     List<String> lore = itemMeta.getLore();
/* 47 */     for (int i = 0; i < 3; i++) {
/* 48 */       lore.remove(lore.size() - 1);
/*    */     }
/* 50 */     itemMeta.setLore(lore);
/* 51 */     this.itemStack.setItemMeta(itemMeta);
/* 52 */     return this.itemStack;
/*    */   }
/*    */   
/*    */   public boolean isSigned() {
/*    */     NBTTagCompound nbtTagCompound;
/* 57 */     ItemStack nms = CraftItemStack.asNMSCopy(this.itemStack);
/*    */     
/* 59 */     if (nms.getTag() != null) {
/*    */       
/* 61 */       nbtTagCompound = nms.getTag();
/*    */     }
/*    */     else {
/*    */       
/* 65 */       nbtTagCompound = new NBTTagCompound();
/* 66 */       setSigned(false);
/*    */     } 
/* 68 */     return nbtTagCompound.getBoolean("signed");
/*    */   }
/*    */   
/*    */   public void setSigned(boolean signed) {
/*    */     NBTTagCompound nbtTagCompound;
/* 73 */     ItemStack nms = CraftItemStack.asNMSCopy(this.itemStack);
/*    */     
/* 75 */     if (nms.getTag() != null) {
/* 76 */       nbtTagCompound = nms.getTag();
/*    */     } else {
/* 78 */       nbtTagCompound = new NBTTagCompound();
/*    */     } 
/* 80 */     nbtTagCompound.setBoolean("signed", signed);
/* 81 */     nms.setTag(nbtTagCompound);
/* 82 */     this.itemStack = (ItemStack)CraftItemStack.asCraftMirror(nms);
/*    */   }
/*    */ 
/*    */   
/*    */   private String fortmatTime(Long millis) {
/* 87 */     SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
/* 88 */     return simpleDateFormat.format(millis);
/*    */   }
/*    */ }


/* Location:              G:\Server Dateien\transfer\neuesnetzwerk\reformcloud\templates\CityBuild\default\plugins\ZenitSign.jar!\de\sign\manager\SignManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */