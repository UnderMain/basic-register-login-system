package de.zenit.commands;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.zenit.main.Main;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.ClickEvent.Action;
import net.md_5.bungee.api.chat.TextComponent;

public class anleitung implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player p = (Player) sender;
		
		TextComponent comp1 = new TextComponent("§6§lZenitLink §8× §r");
		TextComponent comp12 = new TextComponent("§71. Besuche unsere Website ");;
        TextComponent comp3 = new TextComponent("§b§l[KLICK]");
        comp3.setClickEvent(new ClickEvent(Action.OPEN_URL, "http://www.zenit-netzwerk.de"));
        comp3.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder( "§b§lKlicke zum besuchen!" ).create()));
        comp1.addExtra(comp12);
        comp1.addExtra(comp3);
		
		TextComponent comp122 = new TextComponent("§6§lZenitLink §8× §r");
		TextComponent comp123 = new TextComponent("§72. Führe den Befehl ");;
        TextComponent comp34 = new TextComponent("§b§l- /link [dein-token] -§7");
        TextComponent comp111 = new TextComponent(" aus.");
        comp34.setClickEvent(new ClickEvent(Action.SUGGEST_COMMAND, "/link [dein-token]"));
        comp34.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder( "§b§lKlicke zum eintippen!" ).create()));
        comp122.addExtra(comp123);
        comp122.addExtra(comp34);
        comp122.addExtra(comp111);
		
		if(args.length == 1) {
			
			if(args[0].equals("token")) {
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
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
				p.sendMessage(Main.Prefix + "§7 - Anleitung um deinen Token zu bekommen - ");
				p.sendMessage(Main.Prefix + "");
				p.spigot().sendMessage(comp1);
				p.sendMessage(Main.Prefix + "§72. Erstelle dir ein Konto / Logge dich ein.");
				p.sendMessage(Main.Prefix + "§73. Der Name muss der selbe wie in Minecraft sein!");
				p.sendMessage(Main.Prefix + "§74. Gehe aufs Benutzer-Panel");
				p.sendMessage(Main.Prefix + "§75. In der Info sollte der Support-Token stehen! :)");
				p.sendMessage(Main.Prefix + "");
				p.sendMessage(Main.Prefix + "§6§m------------------------------------------------------");
				
			}else if(args[0].equals("link")) {
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
		    	p.sendMessage("");
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
				p.sendMessage(Main.Prefix + "§7 - Anleitung um deinen Account zu verlinken - ");
				p.sendMessage(Main.Prefix + "§9§oDie Befehle sind anklickbar!");
				p.sendMessage(Main.Prefix + "§71. Habe deinen Token bereit.");
				p.spigot().sendMessage(comp122);
				p.sendMessage(Main.Prefix + "§73. Achte auf die Namen der beiden Accounts!");
				p.sendMessage(Main.Prefix + "§74. Jetzt sollte dein Account verlinkt sein! :)");
				p.sendMessage(Main.Prefix + "§cBei Problemen: Melde dich im Support!");
				p.sendMessage(Main.Prefix + "");
				p.sendMessage(Main.Prefix + "§6§m------------------------------------------------------");
				
			}
			
			
			
			
			
			
			
		}else {
			
			TextComponent prefix = new TextComponent("§6§lZenitLink §8× §r");
			TextComponent comp11 = new TextComponent("§b§l/anleitung token§7 - Anleitung für den Token");
	        comp11.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/anleitung token"));
	        comp11.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder( "§b§lKlicke zum ausführen!" ).create()));
	        prefix.addExtra(comp11);

			TextComponent prefix1 = new TextComponent("§6§lZenitLink §8× §r");
			TextComponent comp13 = new TextComponent("§b§l/anleitung link§7 - Anleitung fürs Verlinken");
	        comp13.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/anleitung link"));
	        comp13.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder( "§b§lKlicke zum ausführen!" ).create()));
	        prefix1.addExtra(comp13);


	    	p.sendMessage("");
	    	p.sendMessage("");
	    	p.sendMessage("");
	    	p.sendMessage("");
	    	p.sendMessage("");
	    	p.sendMessage("");
	    	p.sendMessage("");
	    	p.sendMessage("");
	    	p.sendMessage("");
	    	p.sendMessage("");
	    	p.sendMessage("");
	    	p.sendMessage("");
	    	p.sendMessage("");
	    	p.sendMessage("");
	    	p.sendMessage("");
	    	p.sendMessage("");
	    	p.sendMessage("");
	    	p.sendMessage("");
	    	p.sendMessage("");
	    	p.sendMessage("");
	    	p.sendMessage("");
	    	p.sendMessage("");
	    	p.sendMessage("");
	    	p.sendMessage("");
	    	p.sendMessage("");
	    	p.sendMessage("");
	    	p.sendMessage("");
	    	p.sendMessage("");
	    	p.sendMessage("");
	    	p.sendMessage("");
	    	p.sendMessage("");
	    	p.sendMessage("");
	    	p.sendMessage("");
	    	p.sendMessage("");
	    	p.sendMessage("");
	    	p.sendMessage("");
	    	p.sendMessage("");
	    	p.sendMessage("");
	    	p.sendMessage("");
	    	p.sendMessage("");
	    	p.sendMessage("");
	    	p.sendMessage("");
	    	p.sendMessage("");
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
			p.sendMessage(Main.Prefix + "§7 - Befehle für die Anleitung - ");
			p.sendMessage(Main.Prefix + "");
			p.sendMessage(Main.Prefix + "§9§oDie Befehle sind anklickbar!");
			p.sendMessage(Main.Prefix + "");
			p.spigot().sendMessage(prefix);
			p.sendMessage(Main.Prefix + "");
			p.spigot().sendMessage(prefix1);
			p.sendMessage(Main.Prefix + "");
			p.sendMessage(Main.Prefix + "§6§m------------------------------------------------------");
			
		}
		
		
		
		
		
		return false;
	}
	
	

}
