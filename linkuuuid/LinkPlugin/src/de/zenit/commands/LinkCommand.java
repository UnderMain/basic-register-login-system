package de.zenit.commands;




import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.zenit.main.Main;
import de.zenit.main.UUIDFetcher;
import de.zenit.main.mysqlQuerys;

public class LinkCommand implements CommandExecutor{

	

	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(args.length == 1) {
				String uuid = "0";
				try {
					uuid = UUIDFetcher.getUUIDByName(p.getName());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

				
				
				int dToken = new mysqlQuerys().getToken(p.getName());
				String uui1d = new mysqlQuerys().getUUID(dToken);
				
				String tokenS = "";
				
				tokenS = String.valueOf(dToken);

				if(uui1d == "none") {
				
					if(tokenS == args[0]) {
					
						mysqlQuerys.insertUUID(uuid, dToken);
					
						
					}else {
						p.sendMessage(Main.Prefix + "§cDer Token stimmt nicht überein§c!");
					}

				}else {
					p.sendMessage(Main.Prefix + "§cDu hast dich schon verifiziert!§c!");

				}
				
			}else {
				p.sendMessage(Main.Prefix + "§cBitte benutze §6/link <username> <token>§c!");
			}
		}
		return false;
	}
	}


