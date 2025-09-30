package de.undermain.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.undermain.config.files;
import de.undermain.mysql.qrys;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ClickEvent.Action;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;


public class ticket implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player p = (Player) sender;
		
		StringBuilder builder = new StringBuilder();
		
		if(p.hasPermission("ticket.write")) {
		
				if (args.length < 2) {
					
					TextComponent prefix = new TextComponent(files.getObject_Messages.get("Prefix").toString().replaceAll("&","§"));
					TextComponent comp = new TextComponent("§r§b§l/ticket §7§l[Email] [Thema] [Nachricht] - Liste alle Tickets auf");
			        comp.setClickEvent(new ClickEvent(Action.SUGGEST_COMMAND, "/ticket [Email] [Thema] [Nachricht]"));
			        comp.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder( "§b§lKlicke ums einzutippen!" ).create()));
			        prefix.addExtra(comp);
			        
					TextComponent prefix1 = new TextComponent(files.getObject_Messages.get("Prefix").toString().replaceAll("&","§"));
					TextComponent comp1 = new TextComponent("§r§b§l/ticket §7§l[list] - Schreibe ein Ticket");
			        comp1.setClickEvent(new ClickEvent(Action.SUGGEST_COMMAND, "/ticket list"));
			        comp1.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder( "§b§lKlicke ums einzutippen!" ).create()));
			        prefix1.addExtra(comp1);
					
			    	p.sendMessage("");
			    	p.sendMessage("");
			    	p.sendMessage("");
			    	p.sendMessage("");
			    	p.sendMessage("");
			    	p.sendMessage("");
			    	p.sendMessage("");
			    	p.sendMessage("");
			    	p.sendMessage("");
			    	p.sendMessage("");
			    	p.sendMessage("");
			    	p.sendMessage("");
			    	p.sendMessage("");
			    	p.sendMessage("");
			    	p.sendMessage("");
			    	p.sendMessage("");
			    	p.sendMessage("");
			    	p.sendMessage("");
			    	p.sendMessage("");
			    	p.sendMessage("");
			    	p.sendMessage("");
			    	p.sendMessage("");
			    	p.sendMessage("");
			    	p.sendMessage("");
			    	p.sendMessage("");
			    	p.sendMessage("");
			    	p.sendMessage("");
			    	p.sendMessage("");
			    	p.sendMessage("");
			    	p.sendMessage("");
			    	p.sendMessage("");
			    	p.sendMessage("");
			    	p.sendMessage("");
			    	p.sendMessage("");
			    	p.sendMessage("");
			    	p.sendMessage("");
			    	p.sendMessage("");
			    	p.sendMessage("");
			    	p.sendMessage("");
			    	p.sendMessage("");
			    	p.sendMessage("");
			    	p.sendMessage("");
			    	p.sendMessage("");
			    	p.sendMessage("");
			    	p.sendMessage("");
			    	p.sendMessage("");
			    	p.sendMessage("");
			    	p.sendMessage("");
			    	p.sendMessage("");
			    	p.sendMessage("");
			    	p.sendMessage("");
			    	p.sendMessage("");
		    		p.sendMessage(files.getObject_Messages.get("Prefix").toString().replaceAll("&","§") + "§b§m---------------------------------------");
		    		p.sendMessage(files.getObject_Messages.get("Prefix").toString().replaceAll("&","§") + "");
					p.spigot().sendMessage(prefix1);
					p.sendMessage(files.getObject_Messages.get("Prefix").toString().replaceAll("&","§") + "");
					p.spigot().sendMessage(prefix);
					p.sendMessage(files.getObject_Messages.get("Prefix").toString().replaceAll("&","§") + "");
		    		p.sendMessage(files.getObject_Messages.get("Prefix").toString().replaceAll("&","§") + "§7Falls deine Nachricht länger sein sollte,");
		    		p.sendMessage(files.getObject_Messages.get("Prefix").toString().replaceAll("&","§") + "§7besuche bitte " + files.getObject_Messages.get("Website").toString().replaceAll("&","§"));
		    		p.sendMessage(files.getObject_Messages.get("Prefix").toString().replaceAll("&","§") + "§7Fasse das Thema bitte in einem Wort!");	
		    		p.sendMessage(files.getObject_Messages.get("Prefix").toString().replaceAll("&","§") + "");
		    		p.sendMessage(files.getObject_Messages.get("Prefix").toString().replaceAll("&","§") + "§b§m---------------------------------------");
					
		    		
		    		
		    		if (args[0].equalsIgnoreCase("list")) {
		    			
		    			String ltl = qrys.getTickets(p.getName());
		    			
				    	p.sendMessage("");
				    	p.sendMessage("");
				    	p.sendMessage("");
				    	p.sendMessage("");
				    	p.sendMessage("");
				    	p.sendMessage("");
				    	p.sendMessage("");
				    	p.sendMessage("");
				    	p.sendMessage("");
				    	p.sendMessage("");
				    	p.sendMessage("");
				    	p.sendMessage("");
				    	p.sendMessage("");
				    	p.sendMessage("");
				    	p.sendMessage("");
				    	p.sendMessage("");
				    	p.sendMessage("");
				    	p.sendMessage("");
				    	p.sendMessage("");
				    	p.sendMessage("");
				    	p.sendMessage("");
				    	p.sendMessage("");
				    	p.sendMessage("");
				    	p.sendMessage("");
				    	p.sendMessage("");
				    	p.sendMessage("");
				    	p.sendMessage("");
				    	p.sendMessage("");
				    	p.sendMessage("");
				    	p.sendMessage("");
				    	p.sendMessage("");
				    	p.sendMessage("");
				    	p.sendMessage("");
				    	p.sendMessage("");
				    	p.sendMessage("");
				    	p.sendMessage("");
				    	p.sendMessage("");
				    	p.sendMessage("");
				    	p.sendMessage("");
				    	p.sendMessage("");
				    	p.sendMessage("");
				    	p.sendMessage("");
				    	p.sendMessage("");
				    	p.sendMessage("");
				    	p.sendMessage("");
				    	p.sendMessage("");
				    	p.sendMessage("");
				    	p.sendMessage("");
				    	p.sendMessage("");
				    	p.sendMessage("");
				    	p.sendMessage("");
				    	p.sendMessage("");
			    		p.sendMessage(files.getObject_Messages.get("Prefix").toString().replaceAll("&","§") + "§b§m---------------------------------------");
			    		p.sendMessage(files.getObject_Messages.get("Prefix").toString().replaceAll("&","§") + "");
						p.sendMessage(files.getObject_Messages.get("Prefix").toString().replaceAll("&","§") + "");
						p.sendMessage(files.getObject_Messages.get("Prefix").toString().replaceAll("&","§") + "");
						p.sendMessage(files.getObject_Messages.get("Prefix").toString().replaceAll("&","§") + "");
						p.sendMessage(files.getObject_Messages.get("Prefix").toString().replaceAll("&","§") + "");
			    		p.sendMessage(files.getObject_Messages.get("Prefix").toString().replaceAll("&","§") + ltl);
			    		p.sendMessage(files.getObject_Messages.get("Prefix").toString().replaceAll("&","§") + "");
			    		p.sendMessage(files.getObject_Messages.get("Prefix").toString().replaceAll("&","§") + "");	
			    		p.sendMessage(files.getObject_Messages.get("Prefix").toString().replaceAll("&","§") + "");
			    		p.sendMessage(files.getObject_Messages.get("Prefix").toString().replaceAll("&","§") + "§b§m---------------------------------------");
		    			
		    		}
		    		
		    		
				}
				
				if (args.length >= 2) {
					
							for(int i = 2;i<args.length;i++) {
							
								if (i == args.length) {
									builder.append(args[i]);
								}else {
									builder.append(args[i] + " ");
								}
								
							}
							
							String email = args[0];
							String thema = args[1];
							String nachricht = builder.toString();
							int status = 1;
							
							
							if(status == qrys.getStatus(p.getName())) {
						    	p.sendMessage("");
						    	p.sendMessage("");
						    	p.sendMessage("");
						    	p.sendMessage("");
						    	p.sendMessage("");
						    	p.sendMessage("");
						    	p.sendMessage("");
						    	p.sendMessage("");
						    	p.sendMessage("");
						    	p.sendMessage("");
						    	p.sendMessage("");
						    	p.sendMessage("");
						    	p.sendMessage("");
						    	p.sendMessage("");
						    	p.sendMessage("");
						    	p.sendMessage("");
						    	p.sendMessage("");
						    	p.sendMessage("");
						    	p.sendMessage("");
						    	p.sendMessage("");
						    	p.sendMessage("");
						    	p.sendMessage("");
						    	p.sendMessage("");
						    	p.sendMessage("");
						    	p.sendMessage("");
						    	p.sendMessage("");
						    	p.sendMessage("");
						    	p.sendMessage("");
						    	p.sendMessage("");
						    	p.sendMessage("");
						    	p.sendMessage("");
						    	p.sendMessage("");
						    	p.sendMessage("");
						    	p.sendMessage("");
						    	p.sendMessage("");
						    	p.sendMessage("");
						    	p.sendMessage("");
						    	p.sendMessage("");
						    	p.sendMessage("");
						    	p.sendMessage("");
						    	p.sendMessage("");
						    	p.sendMessage("");
						    	p.sendMessage("");
						    	p.sendMessage("");
						    	p.sendMessage("");
						    	p.sendMessage("");
						    	p.sendMessage("");
						    	p.sendMessage("");
						    	p.sendMessage("");
						    	p.sendMessage("");
						    	p.sendMessage("");
						    	p.sendMessage("");
							    		p.sendMessage(files.getObject_Messages.get("Prefix").toString().replaceAll("&","§") + "§b§m---------------------------------------");
							    		p.sendMessage(files.getObject_Messages.get("Prefix").toString().replaceAll("&","§") + "");
							    		p.sendMessage(files.getObject_Messages.get("Prefix").toString().replaceAll("&","§") + "§7Du hast leider schon ein Ticket geöffnet ");
							    		p.sendMessage(files.getObject_Messages.get("Prefix").toString().replaceAll("&","§") + "§7Warte bitte bis dieses bearbeitet wurde");
							    		p.sendMessage(files.getObject_Messages.get("Prefix").toString().replaceAll("&","§") + "§7Das Thema vom letzten Ticket:");
							    		p.sendMessage(files.getObject_Messages.get("Prefix").toString().replaceAll("&","§") + "" + qrys.getThema(p.getName()));	
							    		p.sendMessage(files.getObject_Messages.get("Prefix").toString().replaceAll("&","§") + "");	
							    		p.sendMessage(files.getObject_Messages.get("Prefix").toString().replaceAll("&","§") + "§b§m---------------------------------------");
							}else {
								
								
								if(args[0].contains("@")) {
								
									
									qrys.setTicket(p.getName(), email, nachricht, thema, status);
							    	p.sendMessage("");
							    	p.sendMessage("");
							    	p.sendMessage("");
							    	p.sendMessage("");
							    	p.sendMessage("");
							    	p.sendMessage("");
							    	p.sendMessage("");
							    	p.sendMessage("");
							    	p.sendMessage("");
							    	p.sendMessage("");
							    	p.sendMessage("");
							    	p.sendMessage("");
							    	p.sendMessage("");
							    	p.sendMessage("");
							    	p.sendMessage("");
							    	p.sendMessage("");
							    	p.sendMessage("");
							    	p.sendMessage("");
							    	p.sendMessage("");
							    	p.sendMessage("");
							    	p.sendMessage("");
							    	p.sendMessage("");
							    	p.sendMessage("");
							    	p.sendMessage("");
							    	p.sendMessage("");
							    	p.sendMessage("");
							    	p.sendMessage("");
							    	p.sendMessage("");
							    	p.sendMessage("");
							    	p.sendMessage("");
							    	p.sendMessage("");
							    	p.sendMessage("");
							    	p.sendMessage("");
							    	p.sendMessage("");
							    	p.sendMessage("");
							    	p.sendMessage("");
							    	p.sendMessage("");
							    	p.sendMessage("");
							    	p.sendMessage("");
							    	p.sendMessage("");
							    	p.sendMessage("");
							    	p.sendMessage("");
							    	p.sendMessage("");
							    	p.sendMessage("");
							    	p.sendMessage("");
							    	p.sendMessage("");
							    	p.sendMessage("");
							    	p.sendMessage("");
							    	p.sendMessage("");
							    	p.sendMessage("");
							    	p.sendMessage("");
							    	p.sendMessage("");
						    		p.sendMessage(files.getObject_Messages.get("Prefix").toString().replaceAll("&","§") + "§b§m---------------------------------------");
						    		p.sendMessage(files.getObject_Messages.get("Prefix").toString().replaceAll("&","§") + "");
						    		p.sendMessage(files.getObject_Messages.get("Prefix").toString().replaceAll("&","§") + "§2§lVielen Dank!");
						    		p.sendMessage(files.getObject_Messages.get("Prefix").toString().replaceAll("&","§") + "");	
						    		p.sendMessage(files.getObject_Messages.get("Prefix").toString().replaceAll("&","§") + "§7Dein Ticket wurde erfasst!");
						    		p.sendMessage(files.getObject_Messages.get("Prefix").toString().replaceAll("&","§") + "");	
						    		p.sendMessage(files.getObject_Messages.get("Prefix").toString().replaceAll("&","§") + "§7Dir wird eine Email mit der Antwort geschickt!");
						    		p.sendMessage(files.getObject_Messages.get("Prefix").toString().replaceAll("&","§") + "");
						    		p.sendMessage(files.getObject_Messages.get("Prefix").toString().replaceAll("&","§") + "§b§m---------------------------------------");
							
							
									
								}
								

							}
					
				}
		
		
		}else {
			
			sender.sendMessage(files.getObject_Messages.get("Prefix").toString().replaceAll("&","§") + files.getObject_Messages.get("NoPerms").toString().replaceAll("&","§"));
			
		}
		return false;
	}
}
