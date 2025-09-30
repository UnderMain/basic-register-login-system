package de.zenit.commands;




import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.zenit.main.Main;
import de.zenit.main.UUIDFetcher;
import de.zenit.main.mysqlQuerys;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.ClickEvent.Action;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;

public class LinkCommand implements CommandExecutor{

	

	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		
		if(sender instanceof Player) {
			
			if(args.length == 1) {
				

				String uuid = "0";
				try {
					uuid = UUIDFetcher.getUUIDByName(p.getName());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				String Tuuid = "";
				Tuuid = UUIDFetcher.convertUUID(uuid);
				
				mysqlQuerys mq = new mysqlQuerys();
				
				String dToken = new String(mq.getToken(p.getName()));
				String uui1d = new String(mq.getUUID(dToken));
				
							if(uui1d.equals("")) {
								
								if(dToken.equals(args[0])) {
							
								mysqlQuerys.insertUUID(Tuuid, dToken);
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
								p.sendMessage(Main.Prefix + "§6§m------------------------------------------------------");
								p.sendMessage(Main.Prefix + "");
								p.sendMessage(Main.Prefix + "");
								p.sendMessage(Main.Prefix + "§a Super! Du hast deinen Account verlinkt!");
								p.sendMessage(Main.Prefix + "");
								p.sendMessage(Main.Prefix + "§7§l/accountinfo§7 - §aFür Infos über deinen Account!");
								p.sendMessage(Main.Prefix + "");
								p.sendMessage(Main.Prefix + "");
								p.sendMessage(Main.Prefix + "§aFalls du Fragen oder Probleme hast, komm in den TS3!");
								p.sendMessage(Main.Prefix + "");
								p.sendMessage(Main.Prefix + "§6§m------------------------------------------------------");					
							}else {
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
								p.sendMessage(Main.Prefix + "§6§m------------------------------------------------------");
								p.sendMessage(Main.Prefix + "");
								p.sendMessage(Main.Prefix + "");
								p.sendMessage(Main.Prefix + "§c Dein Token stimmt nicht überein!");
								p.sendMessage(Main.Prefix + "");
								p.sendMessage(Main.Prefix + "§c/anleitung token - Hier siehst du alle Schritte!");
								p.sendMessage(Main.Prefix + "§cFalls es trotzdem nicht funktioniert, komme in den TS3!");
								p.sendMessage(Main.Prefix + "");
								p.sendMessage(Main.Prefix + "");
								p.sendMessage(Main.Prefix + "");
								p.sendMessage(Main.Prefix + "§6§m------------------------------------------------------");
							}
						
						}else {
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
							p.sendMessage(Main.Prefix + "§6§m------------------------------------------------------");
							p.sendMessage(Main.Prefix + "");
							p.sendMessage(Main.Prefix + "");
							p.sendMessage(Main.Prefix + "§c Du hast deinen Account bereits verlinkt!");
							p.sendMessage(Main.Prefix + "");
							p.sendMessage(Main.Prefix + "§cFalls du es nicht gewesen warst oder dein Account sich");
							p.sendMessage(Main.Prefix + "§c geändert hat, komme bitte in den Support im TS3!");
							p.sendMessage(Main.Prefix + "");
							p.sendMessage(Main.Prefix + "");
							p.sendMessage(Main.Prefix + "");
							p.sendMessage(Main.Prefix + "§6§m------------------------------------------------------");

						}	
			}else {
				
				TextComponent prefix = new TextComponent("§6§lZenitLink §8× §r");
				TextComponent comp1 = new TextComponent("§r§b§l/link §7§l[Token] - Verlinke deine Accounts");
		        comp1.setClickEvent(new ClickEvent(Action.SUGGEST_COMMAND, "/link [Token]"));
		        comp1.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder( "§b§lKlicke ums einzutippen!" ).create()));
		        prefix.addExtra(comp1);

				TextComponent prefix1 = new TextComponent("§6§lZenitLink §8× §r");
				TextComponent comp13 = new TextComponent("§b§l/accountinfo§7 - Gibt Infos über deinen Account");
		        comp13.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/accountinfo"));
		        comp13.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder( "§b§lKlicke ums auszuführen!" ).create()));
		        prefix1.addExtra(comp13);

				TextComponent prefix2 = new TextComponent("§6§lZenitLink §8× §r");
				TextComponent comp12 = new TextComponent("§b§l/anleitung§7 - §7Zeigt eine Anleitung");
		        comp12.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/anleitung"));
		        comp12.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder( "§b§lKlicke ums auszuführen!" ).create()));
		        prefix2.addExtra(comp12);
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
				p.sendMessage(Main.Prefix + "§6§m------------------------------------------------------");
				p.sendMessage(Main.Prefix + "");
				p.sendMessage(Main.Prefix + "§7 - Befehle zum Verlinken - ");
				p.sendMessage(Main.Prefix + "§9§oDie Befehle sind anklickbar!");
				p.spigot().sendMessage(prefix);
				p.sendMessage(Main.Prefix + "");
				p.spigot().sendMessage(prefix1);
				p.sendMessage(Main.Prefix + "");
				p.spigot().sendMessage(prefix2);
				p.sendMessage(Main.Prefix + "");
				p.sendMessage(Main.Prefix + "§6§m------------------------------------------------------");
			}
		}
		return false;
	}

	}


