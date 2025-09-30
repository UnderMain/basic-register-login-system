package de.undermain.main;


import java.util.Collection;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public static String prefix = "Â§6Â§lCityBuild Â§8Ã— Â§7";
	
	  public void onEnable()
	  {
	    getLogger().info("Zenit-Giveall Plugin");
	  }
	  
	  public void onDisable()
	  {
	    getLogger().info("Zenit-Giveall Plugin");
	  }
	  
	  public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args)
	  {
	    if (!commandSender.hasPermission("giveall.use"))
	    {
	      commandSender.sendMessage(prefix + "§cDazu hast du keine Rechte.");
	      return true;
	    }
	    if (!(commandSender instanceof Player))
	    {
	      commandSender.sendMessage(prefix + "Nur Spieler können diesen Befehl ausführen!");
	      return true;
	    }
	    Player senderPlayer = (Player)commandSender;
	    String senderName = ((Player)commandSender).getDisplayName();
	    if ((senderPlayer.getItemInHand() == null) || (senderPlayer.getItemInHand().getType().equals(Material.AIR)))
	    {
	      senderPlayer.sendMessage(prefix + "Um jedem etwas zu geben halte bitte ein Item in deiner Hand!");
	      return true;
	    }
	    if (args.length == 2)
	    {
	      ItemStack currentItemInHand;
	      Material currentItemName;
	      Location senderLocation;
	      Double maxDistance;
	      if (args[0].equalsIgnoreCase("distance"))
	      {
	        currentItemInHand = senderPlayer.getItemInHand();
	        currentItemName = senderPlayer.getItemInHand().getType();
	        Collection<? extends Player> players = getServer().getOnlinePlayers();
	        senderLocation = senderPlayer.getLocation();
	        maxDistance = Double.valueOf(Double.parseDouble(args[1]));
	        for (Player player : players) {
	          if (player != senderPlayer)
	          {
	            Location playerLocation = player.getLocation();
	            Double playerSenderDistance = Double.valueOf(senderLocation.distance(playerLocation));
	            if (playerSenderDistance.doubleValue() <= maxDistance.doubleValue())
	            {
	              player.getInventory().addItem(new ItemStack[] { currentItemInHand });
	              player.sendMessage(prefix +"§3§lDu hast " + currentItemName + "§3§lvon " + senderName + " §3§lerhalten!");
	            }
	          }
	          else
	          {
	            player.sendMessage(prefix + "§3§lDu hast erfolgreich jedem das Item " + currentItemName + " §3§lgegeben!");
	          
	        
	      


	