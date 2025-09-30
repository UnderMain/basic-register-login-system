package de.zenit.commands;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.zenit.main.Main;
import de.zenit.main.mysqlQuerys;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.ClickEvent.Action;


public class token implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player) sender;

		if(sender instanceof Player) {

			mysqlQuerys mq = new mysqlQuerys();
			
			String dToken = new String(mq.getToken(p.getName()));
			String uui1d = new String(mq.getUUID(dToken));
			String name = new String(mq.getName(dToken));
			
			if(uui1d.equals("")) {
			
				TextComponent prefix = new TextComponent("§6§lZenitLink §8× §r");
				TextComponent comp1 = new TextComponent("§r§b§l/link §7§l[Token] - Verlinke deine Accounts");
		        comp1.setClickEvent(new ClickEvent(Action.SUGGEST_COMMAND, "/link [Token]"));
		        comp1.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder( "§b§lKlicke ums einzutippen!" ).create()));
		        prefix.addExtra(comp1);
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
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
				p.sendMessage(Main.Prefix + "§7 - §cBitte verifiziere dich zuerst! §7- ");
				p.sendMessage(Main.Prefix + "");
				p.sendMessage(Main.Prefix);
				p.sendMessage(Main.Prefix + "");
				p.sendMessage(Main.Prefix + "");
				p.spigot().sendMessage(prefix);
				p.sendMessage(Main.Prefix + "");
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
				p.sendMessage(Main.Prefix + "§aDein Benutzername lautet: §b§l" + name);
				p.sendMessage(Main.Prefix + "");
				p.sendMessage(Main.Prefix + "§aDein Token lautet: §b§l" + dToken);
				p.sendMessage(Main.Prefix + "");
				p.sendMessage(Main.Prefix + "§aDeine UUID lautet:");
				p.sendMessage(Main.Prefix + "§7" + uui1d);
				p.sendMessage(Main.Prefix);
				p.sendMessage(Main.Prefix + "§6§m------------------------------------------------------");

			}
			
			
				
			}else {

			}

		return false;
	}
	
	

}
