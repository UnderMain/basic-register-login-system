package de.undermain.main;





import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.undermain.mysql.qry;


public class link implements CommandExecutor {


	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player)sender;
		
				
		
	    if (sender instanceof Player) {

			
		    if (cmd.getName().equalsIgnoreCase("link")) {
		        if (args.length == 2) {

	        		int token = qry.getToken(p.getName());
	        		
		        		String tokenS  = "";
		        		
		        		try {
			        		tokenS = String.valueOf(token);
		        		}catch(NumberFormatException e) {
		        			e.printStackTrace();
		        		}
		        		
		        		
		        		
		        		
		        		if(qry.getUUID(p.getName()) == 0) {
		        			
		        			if(tokenS == args[2]) {
		        				
		        				String nameS = qry.getName(tokenS);

		        				if(nameS == args[1]) {
		        					
		        					qry.setUUID(p.getName());
		        					
		        				}
		        				
		        				
		        			}
		        			
		        		}
		        	
		        }
		    }
			
	    }
	    


	    
		
		
		return false;
	}

}
