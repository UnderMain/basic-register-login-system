package de.sciencecode.cbsystem.main;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

import de.sciencecode.cbsystem.commands.Ban;
import de.sciencecode.cbsystem.commands.Bewerbung;
import de.sciencecode.cbsystem.commands.ChatClear;
import de.sciencecode.cbsystem.commands.ClearLag;
import de.sciencecode.cbsystem.commands.DailyReward;
import de.sciencecode.cbsystem.commands.DelHome;
import de.sciencecode.cbsystem.commands.DelWarp;
import de.sciencecode.cbsystem.commands.EnderChest;
import de.sciencecode.cbsystem.commands.Fly;
import de.sciencecode.cbsystem.commands.GM;
import de.sciencecode.cbsystem.commands.GiveAll;
import de.sciencecode.cbsystem.commands.Head;
import de.sciencecode.cbsystem.commands.Heal;
import de.sciencecode.cbsystem.commands.Home;
import de.sciencecode.cbsystem.commands.Kick;
import de.sciencecode.cbsystem.commands.Kurse;
import de.sciencecode.cbsystem.commands.List;
import de.sciencecode.cbsystem.commands.Msg;
import de.sciencecode.cbsystem.commands.Mute;
import de.sciencecode.cbsystem.commands.Nick;
import de.sciencecode.cbsystem.commands.OnlineTime;
import de.sciencecode.cbsystem.commands.Plot;
import de.sciencecode.cbsystem.commands.Rang;
import de.sciencecode.cbsystem.commands.Rename;
import de.sciencecode.cbsystem.commands.SetHome;
import de.sciencecode.cbsystem.commands.SetSpawn;
import de.sciencecode.cbsystem.commands.SetWarp;
import de.sciencecode.cbsystem.commands.Spawn;
import de.sciencecode.cbsystem.commands.SpawnDailyReward;
import de.sciencecode.cbsystem.commands.SpawnShop;
import de.sciencecode.cbsystem.commands.TP;
import de.sciencecode.cbsystem.commands.TPA;
import de.sciencecode.cbsystem.commands.TPAHere;
import de.sciencecode.cbsystem.commands.TPHere;
import de.sciencecode.cbsystem.commands.ToggleMsg;
import de.sciencecode.cbsystem.commands.UnBan;
import de.sciencecode.cbsystem.commands.UnMute;
import de.sciencecode.cbsystem.commands.Vanish;
import de.sciencecode.cbsystem.commands.Warp;
import de.sciencecode.cbsystem.listeners.BuyItems;
import de.sciencecode.cbsystem.listeners.ChatListener;
import de.sciencecode.cbsystem.listeners.ChatPrefix;
import de.sciencecode.cbsystem.listeners.JoinQuit;
import de.sciencecode.cbsystem.listeners.MainListener;
import de.sciencecode.cbsystem.listeners.SignShop;
import de.sciencecode.cbsystem.utils.Manager;
import de.sciencecode.cbsystem.utils.ScoreboardMA;
import de.sciencecode.cbsystem.utils.ShopManager;
import de.sciencecode.cbsystem.main.Main;
import de.sciencecode.cbsystem.utils.GameProfileFetcher;
import de.sciencecode.cbsystem.utils.UUIDFetcher;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityDestroy;
import net.minecraft.server.v1_8_R3.PacketPlayOutNamedEntitySpawn;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerInfo;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerInfo.EnumPlayerInfoAction;

public class Main extends JavaPlugin {
	
	public static FileConfiguration database;
	public static File file;
	public static Main instance;
	public static HashMap<String, Long> banned = new HashMap<String, Long>();
	
	public void onEnable() {
		
		instance = this;

		System.out.println("---------------------");
		System.out.println("CBSystem ~ Aktiviert");
		System.out.println("---------------------");
		
		setupFiles();
		
		registerCommands();
		registerListeners();
		
		Manager.startTimer();
		
		Manager.cfg4.set("Kurs1", Integer.valueOf(100000));
		Manager.cfg4.set("Kurs2", Integer.valueOf(3000));
		Manager.cfg4.set("Kurs3", Integer.valueOf(30000));
		Manager.cfg4.set("Kurs4", Integer.valueOf(5000));
		Manager.cfg4.set("Kurs5", Integer.valueOf(6000));

		
		File file = new File("plugins/CB-System/mutes.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

		if (!file.exists()) {
			try {
				cfg.save(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void onDisable() {
		System.out.println("---------------------");
		System.out.println("CBSystem ~ Deaktiviert");
		System.out.println("---------------------");

	}
	
	public void registerCommands() {
		getCommand("rang").setExecutor(new Rang());
		getCommand("clearlag").setExecutor(new ClearLag());
		getCommand("warp").setExecutor(new Warp());
		getCommand("setwarp").setExecutor(new SetWarp());
		getCommand("delwarp").setExecutor(new DelWarp());
		getCommand("plot").setExecutor(new Plot());
		getCommand("ban").setExecutor(new Ban());
		getCommand("unban").setExecutor(new UnBan());
		getCommand("mute").setExecutor(new Mute());
		getCommand("unmute").setExecutor(new UnMute());
		getCommand("msg").setExecutor(new Msg());
		getCommand("togglemsg").setExecutor(new ToggleMsg());
		getCommand("spawndailyreward").setExecutor(new SpawnDailyReward());
		getCommand("spawnshop").setExecutor(new SpawnShop());
		getCommand("gamemode").setExecutor(new GM());
		getCommand("fly").setExecutor(new Fly());
		getCommand("giveall").setExecutor(new GiveAll());
		getCommand("chatclear").setExecutor(new ChatClear());
		getCommand("enderchest").setExecutor(new EnderChest());
		getCommand("tpa").setExecutor(new TPA());
		getCommand("tpahere").setExecutor(new TPAHere());
		getCommand("heal").setExecutor(new Heal());
		getCommand("list").setExecutor(new List());
		getCommand("home").setExecutor(new Home());
		getCommand("sethome").setExecutor(new SetHome());
		getCommand("delhome").setExecutor(new DelHome());
		getCommand("vanish").setExecutor(new Vanish());
		getCommand("rename").setExecutor(new Rename());
		getCommand("head").setExecutor(new Head());
		getCommand("tp").setExecutor(new TP());
		getCommand("tphere").setExecutor(new TPHere());
		getCommand("spawn").setExecutor(new Spawn());
		getCommand("setspawn").setExecutor(new SetSpawn());
		getCommand("dailyreward").setExecutor(new DailyReward());
		getCommand("kurse").setExecutor(new Kurse());
		getCommand("onlinetime").setExecutor(new OnlineTime());
		getCommand("kick").setExecutor(new Kick());
		getCommand("bewerbung").setExecutor(new Bewerbung());
		getCommand("nick").setExecutor(new Nick());

	}
	
	public void registerListeners() {
		getServer().getPluginManager().registerEvents(new ScoreboardMA(), this);
		getServer().getPluginManager().registerEvents(new JoinQuit(), this);
		getServer().getPluginManager().registerEvents(new Plot(), this);
		getServer().getPluginManager().registerEvents(new ChatPrefix(), this);
		getServer().getPluginManager().registerEvents(new Ban(), this);
		getServer().getPluginManager().registerEvents(new Mute(), this);
		getServer().getPluginManager().registerEvents(new DailyReward(), this);
		getServer().getPluginManager().registerEvents(new ShopManager(), this);
		getServer().getPluginManager().registerEvents(new MainListener(), this);
		getServer().getPluginManager().registerEvents(new SignShop(), this);
		getServer().getPluginManager().registerEvents(new SpawnDailyReward(), this);
		getServer().getPluginManager().registerEvents(new ChatListener(), this);
		getServer().getPluginManager().registerEvents(new BuyItems(), this);

	}
	
	public static String getPrefix() {
		return "§eTestMC.NET §8| ";
		
	}
	
	  private void setupFiles()
	  {
	    if (!Main.instance.getDataFolder().exists()) {
	      Main.instance.getDataFolder().mkdirs();
	    }
	    file = new File(Main.instance.getDataFolder(), "database.yml");
	    if (!file.exists()) {
	      try
	      {
	        file.createNewFile();
	      }
	      catch (IOException ex)
	      {
	        Bukkit.getPluginManager().disablePlugin(this);
	      }
	    }
	    database = YamlConfiguration.loadConfiguration(file);
	  }
	
	public static void changeSkin(CraftPlayer cp, String nameFromPlayer) {
		GameProfile skingp = cp.getProfile();
		
			try {
				skingp = GameProfileFetcher.fetch(UUIDFetcher.getUUID(nameFromPlayer));
			} catch (IOException e) {
				cp.sendMessage("§eSkin §8| §cKonnte Skin nicht laden.");
			}

		Collection<Property> props = skingp.getProperties().get("textures");
		cp.getProfile().getProperties().removeAll("textures");
		
		cp.getProfile().getProperties().putAll("textures", props);
		cp.sendMessage("§eSkin §8| §aDu hast nun den Skin von §e" + nameFromPlayer);
		
		PacketPlayOutEntityDestroy destroy = new PacketPlayOutEntityDestroy(cp.getEntityId());
		sendPacket(destroy);
		
		PacketPlayOutPlayerInfo tabremove = new PacketPlayOutPlayerInfo(EnumPlayerInfoAction.REMOVE_PLAYER, cp.getHandle());
		sendPacket(tabremove);	
						
		new BukkitRunnable() {
			
			@Override
			public void run() {
								
				PacketPlayOutPlayerInfo tabadd = new PacketPlayOutPlayerInfo(EnumPlayerInfoAction.ADD_PLAYER, cp.getHandle());
				sendPacket(tabadd);
			
				PacketPlayOutNamedEntitySpawn spawn = new PacketPlayOutNamedEntitySpawn(cp.getHandle());
				
				for (Player all : Bukkit.getOnlinePlayers()) {
					
					if (!all.getName().equals(cp.getName())) {
					
					((CraftPlayer)all).getHandle().playerConnection.sendPacket(spawn);
					
					}
				}
				
			}
		}.runTaskLater(Main.instance, 4);
		
		new BukkitRunnable() {
			
			@Override
			public void run() {
				if (cp.getWorld().getName().equals("world")) {
					cp.teleport(Bukkit.getWorld("world_nether").getSpawnLocation());
					cp.teleport(Bukkit.getWorld("world").getSpawnLocation());
				} else {
					cp.teleport(Bukkit.getWorld("world").getSpawnLocation());
				}
			}
		}.runTaskLater(Main.instance, 2L);
		
	}
	
	@SuppressWarnings("rawtypes")
	public static void sendPacket(Packet packet) {
		
		for (Player all : Bukkit.getOnlinePlayers()) {
			
			((CraftPlayer)all).getHandle().playerConnection.sendPacket(packet);
		}
		
	}

}
