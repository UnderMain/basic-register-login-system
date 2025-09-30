package de.sciencecode.cbsystem.commands;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.sciencecode.cbsystem.main.Main;

public class TPAHere implements CommandExecutor{
	
	public static HashMap<Player, ArrayList<Player>> req = new HashMap<Player, ArrayList<Player>>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player)sender;
				if(args.length == 0){
					p.sendMessage(Main.getPrefix() + "§cSyntax: /tpahere [Name]");
				}else if(args.length == 1){
					Player target = Bukkit.getPlayer(args[0]);
					if(target == null){
						p.sendMessage(Main.getPrefix() + "§cDieser Spieler ist nicht Online!");
					} else {
						
						if(req.containsKey(target)){
							
							if(req.get(target).contains(p)){
								
								p.sendMessage(Main.getPrefix() + "§aDu hast erfolgreich eine TPA-Here Anfrage an §e" + target.getName() + " §ageschickt!");
								
								target.sendMessage(Main.getPrefix() + "§aDu hast eine TPA-Here Anfrage von §e" + p.getName() + " §aerhalten.");
								
								target.sendMessage(Main.getPrefix() + "§aNutze §6/tpahere annehmen " + p.getName() + " §8- Um sie anzunehmen");
								
								target.sendMessage(Main.getPrefix() + "§aNutze §6/tpahere ablehnen " + p.getName() + " §8- Um sie abzulehnen");
								
								
							} else {
								
								p.sendMessage(Main.getPrefix() + "§aDu hast erfolgreich eine TPA-Here Anfrage an §e" + target.getName() + " §ageschickt!");
								
								target.sendMessage(Main.getPrefix() + "§aDu hast eine TPA-Here Anfrage von §e" + p.getName() + " §aerhalten.");
								
								target.sendMessage(Main.getPrefix() + "§aNutze §6/tpahere annehmen " + p.getName() + " §8- Um sie anzunehmen");
								
								target.sendMessage(Main.getPrefix() + "§aNutze §6/tpahere ablehnen " + p.getName() + " §8- Um sie abzulehnen");
								
								req.get(target).add(p);
								
							}
						}else{
							
							p.sendMessage(Main.getPrefix() + "§aDu hast erfolgreich eine TPA-Here Anfrage an §e" + target.getName() + " §ageschickt!");
							
							target.sendMessage(Main.getPrefix() + "§aDu hast eine TPA-Here Anfrage von §e" + p.getName() + " §aerhalten.");
							
							target.sendMessage(Main.getPrefix() + "§aNutze §6/tpahere annehmen " + p.getName() + " §8- Um sie anzunehmen");
							
							target.sendMessage(Main.getPrefix() + "§aNutze §6/tpahere ablehnen " + p.getName() + " §8- Um sie abzulehnen");
							
							
							ArrayList<Player> anfr = new ArrayList<Player>();
							anfr.add(target);
							req.put(target, anfr);
							
							req.get(target).add(p);
						
						}
						
						
					}
				}else if(args.length == 2) {
					
					
					if(args[0].equalsIgnoreCase("annehmen")) {
						
						Player target = Bukkit.getPlayer(args[1]);
						
						if (target == null) {
						
							p.sendMessage(Main.getPrefix() + "§cDieser Spieler ist nicht Online!");

						}else{
							
							if(req.containsKey(p)){
								
								if(req.get(p).contains(target)){
									p.sendMessage(Main.getPrefix() + "§aDu hast die Anfrage von §e" + target.getName() + " §aerfolgreich angenommen.");
									target.sendMessage(Main.getPrefix() + "§aDeine Anfrage zu §e" + p.getName() + " §awurde erfolgreich angenommen.");
									req.get(p).remove(target);
									p.teleport(target);
									
								}else{
									
									p.sendMessage(Main.getPrefix() + "§cDu hast keine Anfragen von diesem Spieler erhalten!");
									
								}
								
							}else{
								
								p.sendMessage(Main.getPrefix() + "§cDu hast keine Anfragen von diesem Spieler erhalten!");
								
							}
							
							
						}
						
					}else if(args[0].equalsIgnoreCase("ablehnen")) {
						
						Player target = Bukkit.getPlayer(args[1]);
						
						if (target == null){
							p.sendMessage(Main.getPrefix() + "§cDer Spieler ist nicht online");
						} else {
							
							if(req.containsKey(p)){
								if(req.get(p).contains(target)){
									p.sendMessage(Main.getPrefix() + "§aDu hast die Anfrage von §e" + target.getName() + " §aerfolgreich abgelehnt.");
									target.sendMessage(Main.getPrefix() + "§aDeine Anfrage zu §e" + p.getName() + " §awurde abgelehnt.");
									req.get(p).remove(target);
								} else {
									p.sendMessage(Main.getPrefix() + "§cDu hast keine Anfragen von diesem Spieler erhalten!");
								}
							} else {
								p.sendMessage(Main.getPrefix() + "§cDu hast keine Anfragen von diesem Spieler erhalten!");
							}
						}
				
				} else {
					
					p.sendMessage(Main.getPrefix() + "§cSyntax: /tpahere [Name]");
					p.sendMessage(Main.getPrefix() + "§cSyntax: /tpahere annehmen [Name]");
					p.sendMessage(Main.getPrefix() + "§cSyntax: /tpahere ablehnen [Name]");

				
				}
		} else {
			
			p.sendMessage(Main.getPrefix() + "§cSyntax: /tpahere [Name]");
			p.sendMessage(Main.getPrefix() + "§cSyntax: /tpahere annehmen [Name]");
			p.sendMessage(Main.getPrefix() + "§cSyntax: /tpahere ablehnen [Name]");
			
		}
		return false;
	}
}
