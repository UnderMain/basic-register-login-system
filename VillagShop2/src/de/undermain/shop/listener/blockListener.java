package de.undermain.shop.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import de.undermain.shop.util.CoinsAPI;
import de.undermain.shop.util.files;

public class blockListener implements Listener {

	public static double getRandomIntegerBetweenRange(double min, double max){
	    double x = (int)(Math.random()*((max-min)+1))+min;
	    return x;
	}
	
	@EventHandler
	public void onBlock(BlockBreakEvent e) {
		Player p = e.getPlayer();
		String Prefix = files.getObject_config.get("Prefix").toString().replaceAll("&", "§");
		String DropMSG = files.getObject_config.get("DropMSG").toString().replaceAll("&", "§");

		int drop = Integer.valueOf(files.getObject_config.get("Droprate").toString());
		double rndm = getRandomIntegerBetweenRange(0, 100);
		if(rndm == 0) {
			p.sendMessage(Prefix + DropMSG);
			CoinsAPI.addCoins(p, drop);
		}else if(rndm == 1) {
			p.sendMessage(Prefix + DropMSG);
			CoinsAPI.addCoins(p, drop);
		}else {
			
		}
	}
	
}
