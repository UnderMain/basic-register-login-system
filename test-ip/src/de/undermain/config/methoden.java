package de.undermain.config;

import java.text.DateFormat;
import java.util.GregorianCalendar;

import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import net.minecraft.server.v1_8_R3.NBTTagCompound;
import net.minecraft.server.v1_8_R3.NBTTagList;




public class methoden {

	public static void chat(Player p) {
		for(int i = 0; i < 100; i++) {
			p.sendMessage("");
		}
	}
	
	public static void chats(Player p, String Prefix, String Args, String Level) {
		chat(p);
		p.sendMessage(Prefix + "§7§m--------------------------------------------------");
		p.sendMessage(Prefix + "");
		p.sendMessage(Prefix + "§7» Dein Item hat nun:");
		p.sendMessage(Prefix + "§aVerzauberung: " + Args);
		p.sendMessage(Prefix + "§aLevel: " + Level);
		p.sendMessage(Prefix + "");
		p.sendMessage(Prefix + "§7§m--------------------------------------------------");
		p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);

	}
	
	public static String datum() {
		GregorianCalendar gc = new GregorianCalendar();
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
		return df.format(gc.getTime());
	}

	 public static ItemStack addGlow(ItemStack item){
	        net.minecraft.server.v1_8_R3.ItemStack nmsStack = CraftItemStack.asNMSCopy(item);
	        NBTTagCompound tag = null;
	        if (!nmsStack.hasTag()) {
	            tag = new NBTTagCompound();
	            nmsStack.setTag(tag);
	        }
	        if (tag == null) tag = nmsStack.getTag();
	        NBTTagList ench = new NBTTagList();
	        tag.set("ench", ench);
	        nmsStack.setTag(tag);
	        return CraftItemStack.asCraftMirror(nmsStack);
	    }
	
}
