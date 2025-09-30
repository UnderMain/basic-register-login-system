package de.undermain.shop.listener;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.help.HelpTopic;

import de.undermain.shop.main.Main;
import de.undermain.shop.util.CoinsAPI;
import de.undermain.shop.util.Title;
import de.undermain.shop.util.files;
import de.undermain.shop.util.methoden;
import de.undermain.shop.util.qryss;



public class joinListener implements Listener {
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		int coins = CoinsAPI.getCoins(p);
		int ontime = qryss.ontime(p.getName())/60;
		String Prefix = files.getObject_config.get("Prefix").toString().replaceAll("&", "§");
		String spawnMSGS = files.getObject_config.get("SpawnMSG").toString().replaceAll("&", "§");
		String spawnTitleS = files.getObject_config.get("SpawnTitle").toString().replaceAll("&", "§");
		String spawnTPS = files.getObject_config.get("SpawnTP").toString().replaceAll("&", "§");

		String spawnMSG1 = files.getObject_config.get("SpawnMSG1").toString().replaceAll("&", "§").replaceAll("%player%", p.getName()).replaceAll("%coins%", String.valueOf(coins)).replaceAll("%ontime%", String.valueOf(ontime)).replaceAll("%online%", String.valueOf(Bukkit.getOnlinePlayers().size()));
		String spawnMSG2 = files.getObject_config.get("SpawnMSG2").toString().replaceAll("&", "§").replaceAll("%player%", p.getName()).replaceAll("%coins%", String.valueOf(coins)).replaceAll("%ontime%", String.valueOf(ontime)).replaceAll("%online%", String.valueOf(Bukkit.getOnlinePlayers().size()));
		String spawnMSG3 = files.getObject_config.get("SpawnMSG3").toString().replaceAll("&", "§").replaceAll("%player%", p.getName()).replaceAll("%coins%", String.valueOf(coins)).replaceAll("%ontime%", String.valueOf(ontime)).replaceAll("%online%", String.valueOf(Bukkit.getOnlinePlayers().size()));
		String spawnMSG4 = files.getObject_config.get("SpawnMSG4").toString().replaceAll("&", "§").replaceAll("%player%", p.getName()).replaceAll("%coins%", String.valueOf(coins)).replaceAll("%ontime%", String.valueOf(ontime)).replaceAll("%online%", String.valueOf(Bukkit.getOnlinePlayers().size()));
		String spawnMSG5 = files.getObject_config.get("SpawnMSG5").toString().replaceAll("&", "§").replaceAll("%player%", p.getName()).replaceAll("%coins%", String.valueOf(coins)).replaceAll("%ontime%", String.valueOf(ontime)).replaceAll("%online%", String.valueOf(Bukkit.getOnlinePlayers().size()));
		String spawnMSG6 = files.getObject_config.get("SpawnMSG6").toString().replaceAll("&", "§").replaceAll("%player%", p.getName()).replaceAll("%coins%", String.valueOf(coins)).replaceAll("%ontime%", String.valueOf(ontime)).replaceAll("%online%", String.valueOf(Bukkit.getOnlinePlayers().size()));
		String spawnMSG7 = files.getObject_config.get("SpawnMSG7").toString().replaceAll("&", "§").replaceAll("%player%", p.getName()).replaceAll("%coins%", String.valueOf(coins)).replaceAll("%ontime%", String.valueOf(ontime)).replaceAll("%online%", String.valueOf(Bukkit.getOnlinePlayers().size()));
		String spawnMSG8 = files.getObject_config.get("SpawnMSG8").toString().replaceAll("&", "§").replaceAll("%player%", p.getName()).replaceAll("%coins%", String.valueOf(coins)).replaceAll("%ontime%", String.valueOf(ontime)).replaceAll("%online%", String.valueOf(Bukkit.getOnlinePlayers().size()));
		String spawnMSG9 = files.getObject_config.get("SpawnMSG9").toString().replaceAll("&", "§").replaceAll("%player%", p.getName()).replaceAll("%coins%", String.valueOf(coins)).replaceAll("%ontime%", String.valueOf(ontime)).replaceAll("%online%", String.valueOf(Bukkit.getOnlinePlayers().size()));

		String spawnTitle1 = files.getObject_config.get("spawnTitle1").toString().replaceAll("&", "§");
		String spawnTitle2 = files.getObject_config.get("spawnTitle2").toString().replaceAll("&", "§");

		int rows = qryss.getRows(p);
		
		p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
		if(rows >= 1) {

		}else {
			qryss.registerPlayer(p);
			p.kickPlayer(Prefix +"§a§lPlease reconnect, your data has been registered the first time in this server!");
		}
		
		if(spawnTitleS.equals("true")) {
			Title.sendTitle(p, Integer.valueOf(10), Integer.valueOf(40), Integer.valueOf(10), spawnTitle1, spawnTitle2);
		}
		
		if(spawnMSGS.equals("true")) {
			e.setJoinMessage(null);
			methoden.chat(p);
			p.sendMessage(Prefix + spawnMSG1);
			p.sendMessage(Prefix + spawnMSG2);
			p.sendMessage(Prefix + spawnMSG3);
			p.sendMessage(Prefix + spawnMSG4);
			p.sendMessage(Prefix + spawnMSG5);
			p.sendMessage(Prefix + spawnMSG6);
			p.sendMessage(Prefix + spawnMSG7);
			p.sendMessage(Prefix + spawnMSG8);
			p.sendMessage(Prefix + spawnMSG9);


		}else {
			e.setJoinMessage(null);
		}
		
		if(spawnTPS.equals("true")) {
			p.teleport(Main.lm.getSpawm());		
		}else {
			
		}


		
	}
	
	
	@EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
    	String msg = event.getMessage().replaceAll("&", "§");
    	String chat1 = files.getObject_config.get("Chat").toString().replaceAll("&", "§");
    	String chat = chat1.replaceAll("%player%", event.getPlayer().getName()).replaceAll("%msg%", msg);
    	String chats = files.getObject_config.get("ChatManager").toString();
		String OP = files.getObject_config.get("OP").toString();
    	if(chats.equals("true")) {
    		if(OP.equals("true")) {
        		if(event.getPlayer().isOp()) {
                	event.setFormat("§c§l»");
                	Bukkit.broadcastMessage("§c§l»");
                	Bukkit.broadcastMessage(chat);

        		}else {
                	event.setFormat(chat);
        		}
    		}else {
            	event.setFormat(chat);

    		}

    	}
    	
    }
	
	@EventHandler
	public void onFailCommand(PlayerCommandPreprocessEvent e) {
		String ukcON = files.getObject_config.get("UKC");
	    String cmd = e.getMessage().split(" ")[0];
	    String block = files.getObject_config.get("Block").toString();
		Player p = e.getPlayer();
	    HelpTopic ht = Bukkit.getHelpMap().getHelpTopic(cmd);
		String Prefix = files.getObject_config.get("Prefix").toString().replaceAll("&", "§");
		String ukcMSG = files.getObject_config.get("UKCM").toString().replaceAll("&", "§").replaceAll("%cmd%", cmd);
		
		if(!(e.isCancelled())) {
			if(ukcON.equals("true")) {
					 if (ht == null) {
							p.sendMessage(Prefix + ukcMSG);
							p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
							e.setCancelled(true);
					 }
			}

			
		}
		if(block.equals("true")) {
			if(cmd.equalsIgnoreCase("/?") || cmd.equalsIgnoreCase("/pl") || cmd.equalsIgnoreCase("/plugins") || cmd.equalsIgnoreCase("/")) {
				
				if(p.isOp()) {

				}else {
					p.sendMessage(Prefix + ukcMSG);
					e.setCancelled(true);
				}

			}else if(cmd.equalsIgnoreCase("/help")) {
				p.sendMessage(Prefix + files.getObject_config.get("Help1").toString().replaceAll("&", "§"));
				p.sendMessage(Prefix + files.getObject_config.get("Help2").toString().replaceAll("&", "§"));
				p.sendMessage(Prefix + files.getObject_config.get("Help3").toString().replaceAll("&", "§"));
				p.sendMessage(Prefix + files.getObject_config.get("Help4").toString().replaceAll("&", "§"));
				p.sendMessage(Prefix + files.getObject_config.get("Help5").toString().replaceAll("&", "§"));
				p.sendMessage(Prefix + files.getObject_config.get("Help6").toString().replaceAll("&", "§"));
				p.sendMessage(Prefix + files.getObject_config.get("Help7").toString().replaceAll("&", "§"));
				p.sendMessage(Prefix + files.getObject_config.get("Help8").toString().replaceAll("&", "§"));
				p.sendMessage(Prefix + files.getObject_config.get("Help9").toString().replaceAll("&", "§"));
				p.sendMessage(Prefix + files.getObject_config.get("Help10").toString().replaceAll("&", "§"));
				e.setCancelled(true);
			}
		}

		
	}
}
