package de.undermain.listener;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.help.HelpTopic;

import de.undermain.config.Title;
import de.undermain.config.files;
import de.undermain.config.methoden;
import de.undermain.main.Main;
import de.undermain.mysql.qryss;

public class JoinQuitListener implements Listener {

	private static int taskID;
	
    @EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
    	Player p = e.getPlayer();
		String Prefix = files.getObject_config.get("Prefix").toString().replaceAll("&", "§");
		String join = files.getObject_config.get("JoinMessage").toString();
		String joinmsg = files.getObject_config.get("JoinMessages").toString().replaceAll("%player%", p.getName());
		String joinss = joinmsg.replaceAll("&", "§");
		String sc = files.getObject_config.get("Scoreboard").toString();
		String spawnTP = files.getObject_config.get("SpawnTP").toString();
		String spawnMSG = files.getObject_config.get("SpawnMSG").toString();
		String spawnTitle = files.getObject_config.get("SpawnTitle").toString().replaceAll("&", "§");
		String spawnTitle1 = files.getObject_config.get("SpawnT1").toString().replaceAll("&", "§");
		String spawnTitle2 = files.getObject_config.get("SpawnT2").toString().replaceAll("&", "§");
		startOntime(p);

		p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
			if(join.equals("true")) {
				e.setJoinMessage(Prefix + joinss);
			}else {
				e.setJoinMessage(null);
			}
			if(spawnTP.equals("true")) {
				p.teleport(Main.lm.getSpawm());
				}
			if(spawnMSG.equals("true")) {
				methoden.chat(p);
				p.sendMessage(Prefix + files.getObject_config.get("SZeile1").toString().replaceAll("&", "§").replaceAll("%player%", p.getName()));
				p.sendMessage(Prefix + files.getObject_config.get("SZeile2").toString().replaceAll("&", "§").replaceAll("%player%", p.getName()));
				p.sendMessage(Prefix + files.getObject_config.get("SZeile3").toString().replaceAll("&", "§").replaceAll("%player%", p.getName()));
				p.sendMessage(Prefix + files.getObject_config.get("SZeile4").toString().replaceAll("&", "§").replaceAll("%player%", p.getName()));
				p.sendMessage(Prefix + files.getObject_config.get("SZeile5").toString().replaceAll("&", "§").replaceAll("%player%", p.getName()));
				p.sendMessage(Prefix + files.getObject_config.get("SZeile6").toString().replaceAll("&", "§").replaceAll("%player%", p.getName()));
			}
			
			if(spawnTitle.equals("true")) {
				Title.sendTitle(p, Integer.valueOf(10), Integer.valueOf(40), Integer.valueOf(10), spawnTitle1, spawnTitle2);
			}
					

		if(sc.equals("true")) {
			for(@SuppressWarnings("unused") Player players : Bukkit.getOnlinePlayers()) {

			}
		}
		if(!p.hasPlayedBefore()) {
			qryss.registerPlayer(p.getName());
		}
		
		

		
	}
    
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
    	Player p = e.getPlayer();
		String Prefix = files.getObject_config.get("Prefix").toString().replaceAll("&", "§");
		String quit = files.getObject_config.get("QuitMessage").toString();
		String quitmsg = files.getObject_config.get("QuitMessages").toString().replaceAll("%player%", p.getName());
		String quitss = quitmsg.replaceAll("&", "§");
	
			if(quit.equals("true")) {
				e.setQuitMessage(Prefix + quitss);
			}else {
				e.setQuitMessage(null);
			}
			
			Bukkit.getScheduler().cancelTask(taskID);
		
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
		String ukcON = files.getObject_config.get("ukcON");
	    String cmd = e.getMessage().split(" ")[0];
	    String block = files.getObject_config.get("Block").toString();
		Player p = e.getPlayer();
	    HelpTopic ht = Bukkit.getHelpMap().getHelpTopic(cmd);
		String Prefix = files.getObject_config.get("Prefix").toString().replaceAll("&", "§");
		String ukcMSG = files.getObject_config.get("UKC").toString().replaceAll("&", "§").replaceAll("%cmd%", cmd);
		
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
    
	public static void startOntime(Player p) {
		 taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
				
			@Override
			public void run() {
				int ontime = qryss.ontime(p.getName());
				int newot = ontime + 1;
				qryss.updateOntime(newot, p.getName());
			}
		}, 1200, 1200);
	}
	
}
