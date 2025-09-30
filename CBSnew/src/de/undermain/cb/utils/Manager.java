package de.undermain.cb.utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.undermain.cb.main.Main;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerListHeaderFooter;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;

public class Manager {

	public static File file = new File("plugins/CB-System/warps.yml");
	public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	public static File file1 = new File("plugins/CB-System/banns.yml");
	public static YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(file1);
	
	public static File file2 = new File("plugins/CB-System/mutes.yml");
	public static YamlConfiguration cfg2 = YamlConfiguration.loadConfiguration(file2);
	
	public static File file3 = new File("plugins/CB-System/homes.yml");
	public static YamlConfiguration cfg3 = YamlConfiguration.loadConfiguration(file3);
	
	public static File file4 = new File("plugins/CB-System/kurse.yml");
	public static YamlConfiguration cfg4 = YamlConfiguration.loadConfiguration(file4);
	
	public static File file5 = new File("plugins/CB-System/onlinetime.yml");
	public static YamlConfiguration cfg5 = YamlConfiguration.loadConfiguration(file5);
	
	public static ArrayList<Player> cooldown = new ArrayList<Player>();
	
	public static void createConfigLocation(Location loc, String path, File file, YamlConfiguration cfg) {
		cfg.set(path + ".World", loc.getWorld().getName());
		cfg.set(path + ".X", Double.valueOf(loc.getX()));
		cfg.set(path + ".Y", Double.valueOf(loc.getY()));
		cfg.set(path + ".Z", Double.valueOf(loc.getZ()));
		cfg.set(path + ".Yaw", Float.valueOf(loc.getYaw()));
		cfg.set(path + ".Pitch", Float.valueOf(loc.getPitch()));
		try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Location getConfigLocation(String path, YamlConfiguration cfg) {
		World w = Bukkit.getWorld(cfg.getString(path + ".World"));
		double x = cfg.getDouble(path + ".X");
		double y = cfg.getDouble(path + ".Y");
		double z = cfg.getDouble(path + ".Z");
		float yaw = (float) cfg.getDouble(path + ".Yaw");
		float pitch = (float) cfg.getDouble(path + ".Pitch");

		return new Location(w, x, y, z, yaw, pitch);
	}
	
	
	@SuppressWarnings("deprecation")
	public static void ban(OfflinePlayer target, String reason, CommandSender sender) {
		
		if (target.isBanned()) {
			sender.sendMessage(Main.getPrefix() + "§cDieser Spieler ist bereits gebannt!");
		} else if (!target.isBanned()) {	
			
		  target.setBanned(true);
		  
		  if (target.isOnline()) {
			  
			  target.setBanned(true);
			  cfg1.set("Ban." + target.getName(), reason);
				try {
					cfg1.save(file1);
				} catch (IOException e) {
					e.printStackTrace();
				}
	          target.getPlayer().kickPlayer(Main.getPrefix() + "§cDu wurdest PERMAMENT vom Server gebannt! \n\n §eGrund: §a" + reason + "\n\n §eZu unrecht gebannt? Schreibe ein Entbannungsantrag im Forum!");

		  	}
		  }
		
        for (Player all : Bukkit.getOnlinePlayers()) {
      	  if (all != sender) {
      		  all.sendMessage(" ");
      		  all.sendMessage(Main.getPrefix() + "§c" + target.getName() + " §awurde von §c" + sender.getName() + " §awegen §c" + reason + "§agebannt");
      		  all.sendMessage(" ");
      		  
      	  }
        }
	}
	
	@SuppressWarnings("deprecation")
	public static void unban(OfflinePlayer target, CommandSender sender) {
		
	if (!target.isBanned()) {
		sender.sendMessage(Main.getPrefix() + "§cDieser Spieler ist nicht gebannt!");
	} else if (target.isBanned()) {
		
		target.setBanned(false);
		  cfg1.set("Ban." + target.getName(), null);
		  try {
			cfg1.save(file1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sender.sendMessage(Main.getPrefix() + "§aDu hast erfolgreich §e" + target.getName() + " §avom Server entbannt!");
		
		}
				
	}
	 
	public static void mute(OfflinePlayer target, String reason, CommandSender sender) {
		
		cfg2.set("Mute." + target.getName(), reason);
		try {
			cfg2.save(file2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sender.sendMessage(Main.getPrefix() + "§aDu hast erfolgreich §e" + target.getName() + " §avom Server gemutet!");
	}
	
	public static void unmute(OfflinePlayer target, CommandSender sender) {
		
		if (!cfg2.getConfigurationSection("Mute").contains(target.getName())) {
			sender.sendMessage(Main.getPrefix() + "§cDieser Spieler ist nicht gemutet!");
		}
		cfg2.set("Mute." + target.getName(), null);
		try {
			cfg2.save(file2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void openRewardInv(Player p) {
		
	      Inventory inv = Bukkit.createInventory(null, 9 * 3, "§eTägliche Belohnung");
	      
	      if (getAllowReward(p)) {
	    
	      ItemStack placeholder = new ItemStack(Material.STAINED_GLASS_PANE, 1);
	      ItemMeta placeholdermeta = placeholder.getItemMeta();
	      placeholdermeta.setDisplayName(" ");
	      placeholder.setItemMeta(placeholdermeta);
	      
	      ItemStack abholen = new ItemStack(Material.STORAGE_MINECART, 1);
	      ItemMeta abholenmeta = abholen.getItemMeta();
	      abholenmeta.setDisplayName("§6Belohnung abholen.");
	      abholenmeta.setLore(Arrays.asList("§7Rechtsklick um sie abzuholen."));
	      abholen.setItemMeta(abholenmeta);
	      
	      inv.setItem(0, placeholder);
	      inv.setItem(1, placeholder);
	      inv.setItem(2, placeholder);
	      inv.setItem(3, placeholder);
	      inv.setItem(4, placeholder);
	      inv.setItem(5, placeholder);
	      inv.setItem(6, placeholder);
	      inv.setItem(7, placeholder);
	      inv.setItem(8, placeholder);
	      inv.setItem(9, placeholder);
	      inv.setItem(10, placeholder);
	      inv.setItem(11, placeholder);
	      inv.setItem(12, placeholder);
	      inv.setItem(13, abholen);
	      inv.setItem(14, placeholder);
	      inv.setItem(15, placeholder);
	      inv.setItem(16, placeholder);
	      inv.setItem(17, placeholder);
	      inv.setItem(18, placeholder);
	      inv.setItem(19, placeholder);
	      inv.setItem(20, placeholder);
	      inv.setItem(21, placeholder);
	      inv.setItem(22, placeholder);
	      inv.setItem(23, placeholder);
	      inv.setItem(24, placeholder);
	      inv.setItem(25, placeholder);
	      inv.setItem(26, placeholder);
	      
	      p.openInventory(inv);
	      
	      } else {
	    	  
		      ItemStack placeholder = new ItemStack(Material.STAINED_GLASS_PANE, 1);
		      ItemMeta placeholdermeta = placeholder.getItemMeta();
		      placeholdermeta.setDisplayName(" ");
		      placeholder.setItemMeta(placeholdermeta);
		      
		      long current = System.currentTimeMillis();
		      long release = getRewTime(p);
		      long millis = release - current;
		      
		      ItemStack abholen = new ItemStack(Material.MINECART, 1);
		      ItemMeta abholenmeta = abholen.getItemMeta();
		      abholenmeta.setDisplayName("§cDu hast deine heutige Belohnung bereits abgeholt!");
		      abholenmeta.setLore(Arrays.asList(getRemainingTime(millis)));
		      abholen.setItemMeta(abholenmeta);
		      
		      inv.setItem(0, placeholder);
		      inv.setItem(1, placeholder);
		      inv.setItem(2, placeholder);
		      inv.setItem(3, placeholder);
		      inv.setItem(4, placeholder);
		      inv.setItem(5, placeholder);
		      inv.setItem(6, placeholder);
		      inv.setItem(7, placeholder);
		      inv.setItem(8, placeholder);
		      inv.setItem(9, placeholder);
		      inv.setItem(10, placeholder);
		      inv.setItem(11, placeholder);
		      inv.setItem(12, placeholder);
		      inv.setItem(13, abholen);
		      inv.setItem(14, placeholder);
		      inv.setItem(15, placeholder);
		      inv.setItem(16, placeholder);
		      inv.setItem(17, placeholder);
		      inv.setItem(18, placeholder);
		      inv.setItem(19, placeholder);
		      inv.setItem(20, placeholder);
		      inv.setItem(21, placeholder);
		      inv.setItem(22, placeholder);
		      inv.setItem(23, placeholder);
		      inv.setItem(24, placeholder);
		      inv.setItem(25, placeholder);
		      inv.setItem(26, placeholder);

		      p.openInventory(inv);
		      
	      }
	
	}
	
	  public static boolean getAllowReward(Player p)
	  {
	    long current = System.currentTimeMillis();
	    long millis = getRewTime(p);
	    return current > millis;
	  }
	  
	  public static long getRewTime(Player p)
	  {
		File file = new File("plugins/SkyPvP-System/data/dailyrewards.yml");
	    FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	    return cfg.getLong(p.getUniqueId() + ".millis");
	  }

	  public static void setReward(Player p)
	  {
		File file = new File("plugins/SkyPvP-System/data/dailyrewards.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);	    
		long toSet = System.currentTimeMillis() + 86400000L;
	    cfg.set(p.getUniqueId() + ".millis", Long.valueOf(toSet));
	    try
	    {
	      cfg.save(file);
	    }
	    catch (IOException e)
	    {
	      e.printStackTrace();
	    }
	  }
	  
	  public static String getRemainingTime(long millis)
	  {
	    long seconds = millis / 1000L;
	    long minutes = 0L;
	    while (seconds > 60L)
	    {
	      seconds -= 60L;
	      minutes += 1L;
	    }
	    long hours = 0L;
	    while (minutes > 60L)
	    {
	      minutes -= 60L;
	      hours += 1L;
	    }
	    return "§e" + hours + " Stunde(n) " + minutes + " Minute(n) " + seconds + " Sekunde(n)";
	  }
	  
	  public static Location getHome(Player p, String name)
	  {
	    try
	    {
	      cfg3.load(file3);
	    }
	    catch (IOException|InvalidConfigurationException e1)
	    {
	      e1.printStackTrace();
	    }
	    String world = cfg3.getString("Homes." + p.getName() + "." + name + ".world");
	    double x = cfg3.getDouble("Homes." + p.getName() + "." + name + ".x");
	    double y = cfg3.getDouble("Homes." + p.getName() + "." + name + ".y");
	    double z = cfg3.getDouble("Homes." + p.getName() + "." + name + ".z");
	    double pitch = cfg3.getDouble("Homes." + p.getName() + "." + name + ".pitch");
	    double yaw = cfg3.getDouble("Homes." + p.getName() + "." + name + ".yaw");
	    
	    Location loc = new Location(Bukkit.getWorld(world), x, y, z);
	    loc.setPitch((float)pitch);
	    loc.setYaw((float)yaw);
	    return loc;
	  }
	  
	  public static boolean ifHomeExist(Player p, String name)
	  {
	    if (cfg3.contains("Homes." + p.getName() + "." + name)) {
	      return true;
	    }
	    return false;
	  }
	  
	  public static void newHome(Player p, String name)
	  {
	    String world = p.getWorld().getName();
	    double x = p.getLocation().getX();
	    double y = p.getLocation().getY();
	    double z = p.getLocation().getZ();
	    double pitch = p.getLocation().getPitch();
	    double yaw = p.getLocation().getYaw();
	    try
	    {
	      cfg3.load(file3);
	    }
	    catch (IOException|InvalidConfigurationException e1)
	    {
	      e1.printStackTrace();
	    }
	    if (!cfg3.contains("Homes." + p.getName() + "." + name))
	    {
	      cfg3.set("Homes." + p.getName() + "." + name + ".world", world);
	      cfg3.set("Homes." + p.getName() + "." + name + ".x", Double.valueOf(x));
	      cfg3.set("Homes." + p.getName() + "." + name + ".y", Double.valueOf(y));
	      cfg3.set("Homes." + p.getName() + "." + name + ".z", Double.valueOf(z));
	      cfg3.set("Homes." + p.getName() + "." + name + ".pitch", Double.valueOf(pitch));
	      cfg3.set("Homes." + p.getName() + "." + name + ".yaw", Double.valueOf(yaw));
	      try
	      {
	        cfg3.save(file3);
	      }
	      catch (Exception localException1) {}
	    }
	    else
	    {
	      p.sendMessage(Main.getPrefix() + "§cDer Home §e" + name + " §cexistiert bereits!");
	    }
	  }
	  
	  public static void remHome(Player p, String name) {
		  cfg3.set("Homes." + p.getName() + "." + name, null);
		  try {
			cfg3.save(file3);
		} catch (IOException e) {
			e.printStackTrace();
		}
	  }
	 
	  public static void setHeadDelay(Player p) {
		  cooldown.add(p);
		  startHeadDelay(p);
	  }
	  
	  static int time = 60*60*24*7;
	  
	  public static void startHeadDelay(Player p) {
          Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
          {
            public void run()
            {
              Manager.cooldown.remove(p);
            }
          }, 20 * time);
        }
	  
	  public static void startTimer()
	  {
	    Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.instance, new Runnable()
	    {
	      public void run()
	      {
	        for (Player all : Bukkit.getOnlinePlayers())
	        {
	          int hours = cfg5.getInt(all.getName() + ".hours");
	          int minutes = cfg5.getInt(all.getName() + ".minutes");
	          int seconds = cfg5.getInt(all.getName() + ".seconds");
	          
	          seconds++;
	          cfg5.set(all.getName() + ".seconds", Integer.valueOf(seconds));
	          try {
				cfg5.save(file5);
			} catch (IOException e2) {
				e2.printStackTrace();
			}
	          if (seconds == 60)
	          {
	        	cfg5.set(all.getName() + ".seconds", Integer.valueOf(0));
	            minutes++;
	            cfg5.set(all.getName() + ".minutes", Integer.valueOf(minutes));
		          try {
					cfg5.save(file5);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	            if (minutes == 60)
	            {
	            	cfg5.set(all.getName() + ".minutes", Integer.valueOf(0));
	              hours++;
	              cfg5.set(all.getName() + ".hours", Integer.valueOf(hours));
		          try {
					cfg5.save(file5);
				} catch (IOException e) {
					e.printStackTrace();
				}
	            }
	          }
	        }
	      }
	    }, 20L, 20L);
	  }
	  
	  public static void sendTablistHeaderAndFooder(Player p, String header, String footer) {
		  if (header == null) header = "";
		  if (footer == null) footer = "";
		  
		  IChatBaseComponent tabheader = ChatSerializer.a("{\"text\":\"" + header + "\"}");
		  IChatBaseComponent tabfooter = ChatSerializer.a("{\"text\":\"" + footer + "\"}");
		  
		  PacketPlayOutPlayerListHeaderFooter headpacket = new PacketPlayOutPlayerListHeaderFooter(tabheader);
		  
		  try {
			  Field field = headpacket.getClass().getDeclaredField("b");
			  field.setAccessible(true);
			  field.set(headpacket, tabfooter);
		  } catch (Exception ex) {
			  ex.printStackTrace();
		  } finally {
			  ((CraftPlayer)p).getHandle().playerConnection.sendPacket(headpacket);
		  }

	  }
	  
}
