package cloud.evaped.citybuild.utils;

import cloud.evaped.citybuild.main.CityBuildCore;
import cloud.evaped.citybuild.main.CityBuildPlugin;
import cloud.evaped.citybuild.main.FileManager;
import java.lang.reflect.Field;
import java.util.ArrayList;
import net.minecraft.server.v1_8_R3.EntityLiving;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.MushroomCow;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Rabbit;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Witch;
import org.bukkit.entity.Wolf;
import org.bukkit.entity.Zombie;
import org.bukkit.scheduler.BukkitScheduler;

public class RegisterMobs
{
  private CityBuildPlugin plugin;
  
  public RegisterMobs(CityBuildPlugin plugin)
  {
    this.plugin = plugin;
  }
  
  public void createVillager() {
    Bukkit.getScheduler().scheduleSyncDelayedTask(CityBuildPlugin.getPlugin(CityBuildPlugin.class), new Runnable() {
      public void run() {
        spawnMob("plotsettings");
        spawnMob("firstthere"); } }, 2L);
  }
  

  public void spawnMob(String kind)
  {
    DataSaver ds_data = new DataSaver(FileManager.getObject_Data);
    for (World w : Bukkit.getWorlds()) {
      for (org.bukkit.entity.Entity e : w.getEntities()) {
        if ((e.isCustomNameVisible()) && (!(e instanceof Player)) && 
          (e.getCustomName().equals(ChatColor.translateAlternateColorCodes('&', plugin
          .getConfig().getString("Villager." + kind + ".name"))))) {
          e.remove();
        }
      }
    }
    

    if (ds_data.getLocation("Location.Villager." + kind) == null) { return;
    }
    org.bukkit.entity.Entity entity = getEntityByNumber(ds_data.getLocation("Location.Villager." + kind), plugin.getConfig().getString("Villager." + kind + ".kind"));
    entity.setCustomName(plugin.getConfig().getString("Villager." + kind + ".name").replaceAll("&", "§"));
    entity.setCustomNameVisible(true);
    CityBuildCore.getEntityNames.add(entity.getCustomName());
    
    CraftEntity craftentity = (CraftEntity)entity;
    NBTTagCompound tag = new NBTTagCompound();
    craftentity.getHandle().c(tag);
    tag.setBoolean("PersistenceRequired", true);
    tag.setBoolean("CanPickUpLoot", false);
    tag.setBoolean("NoAI", true);
    EntityLiving el = (EntityLiving)craftentity.getHandle();
    el.a(tag);
    
    NBTTagCompound compound = new NBTTagCompound();
    craftentity.getHandle().e(compound);
    compound.setInt("Silent", 1);
    craftentity.getHandle().f(compound);
    try
    {
      Field invulnerableField = net.minecraft.server.v1_8_R3.Entity.class.getDeclaredField("invulnerable");
      invulnerableField.setAccessible(true);
      invulnerableField.setBoolean(craftentity.getHandle(), true);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
  
  public org.bukkit.entity.Entity getEntityByNumber(Location loc, String s)
  {
    org.bukkit.entity.Entity entity = null;
    if (s.equals("chicken")) {
      entity = loc.getWorld().spawn(loc, Chicken.class);
    }
    if (s.equals("rabbit")) {
      entity = loc.getWorld().spawn(loc, Rabbit.class);
    }
    if (s.equals("sheep")) {
      entity = loc.getWorld().spawn(loc, Sheep.class);
    }
    if (s.equals("pig")) {
      entity = loc.getWorld().spawn(loc, org.bukkit.entity.Pig.class);
    }
    if (s.equals("cow")) {
      entity = loc.getWorld().spawn(loc, Cow.class);
    }
    if (s.equals("mushroomcow")) {
      entity = loc.getWorld().spawn(loc, MushroomCow.class);
    }
    if (s.equals("ocelot")) {
      entity = loc.getWorld().spawn(loc, Ocelot.class);
    }
    if (s.equals("wolf")) {
      entity = loc.getWorld().spawn(loc, Wolf.class);
    }
    if (s.equals("spider")) {
      entity = loc.getWorld().spawn(loc, Spider.class);
    }
    if (s.equals("cavespider")) {
      entity = loc.getWorld().spawn(loc, CaveSpider.class);
    }
    if (s.equals("enderman")) {
      entity = loc.getWorld().spawn(loc, Enderman.class);
    }
    if (s.equals("creeper")) {
      entity = loc.getWorld().spawn(loc, Creeper.class);
    }
    if (s.equals("pigzombie")) {
      entity = loc.getWorld().spawn(loc, PigZombie.class);
    }
    if (s.equals("blaze")) {
      entity = loc.getWorld().spawn(loc, Blaze.class);
    }
    if (s.equals("witch")) {
      entity = loc.getWorld().spawn(loc, Witch.class);
    }
    if (s.equals("villager")) {
      entity = loc.getWorld().spawn(loc, Villager.class);
    }
    if (s.equals("golem")) {
      entity = loc.getWorld().spawn(loc, IronGolem.class);
    }
    if (s.equals("zombie")) {
      entity = loc.getWorld().spawn(loc, Zombie.class);
    }
    if (entity == null) {
      entity = loc.getWorld().spawn(loc, Villager.class);
    }
    return entity;
  }
}
