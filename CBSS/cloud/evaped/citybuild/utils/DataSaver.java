package cloud.evaped.citybuild.utils;

import cloud.evaped.citybuild.main.CityBuildPlugin;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

public class DataSaver
{
  private HashMap<String, Object> data;
  
  public DataSaver(HashMap<String, Object> data)
  {
    this.data = data;
  }
  
  public boolean contains(String path) {
    Boolean b = Boolean.valueOf(false);
    if (data.containsKey(path)) {
      b = Boolean.valueOf(true);
    }
    return b.booleanValue();
  }
  
  public Object get(String path) {
    Object o = null;
    try {
      o = data.get(path);
    } catch (Exception e) {
      if (CityBuildPlugin.debug) {
        e.printStackTrace();
      }
    }
    return o;
  }
  
  public int getInt(String path) {
    int i = 0;
    try {
      i = new Long(data.get(path) + "").intValue();
    } catch (Exception e) {
      if (CityBuildPlugin.debug) {
        e.printStackTrace();
      }
    }
    return i;
  }
  
  public String getString(String path) {
    String s = "";
    try {
      s = data.get(path).toString();
    } catch (Exception e) {
      if (CityBuildPlugin.debug) {
        e.printStackTrace();
      }
    }
    return s;
  }
  
  public boolean getBoolean(String path) {
    boolean b = false;
    try {
      b = new Boolean(data.get(path) + "").booleanValue();
    } catch (Exception e) {
      if (CityBuildPlugin.debug) {
        e.printStackTrace();
      }
    }
    return b;
  }
  
  public double getDouble(String path) {
    double d = 0.0D;
    try {
      d = new Double(data.get(path) + "").doubleValue();
    } catch (Exception e) {
      if (CityBuildPlugin.debug) {
        e.printStackTrace();
      }
    }
    return d;
  }
  
  public float getFloat(String path) {
    float f = 0.0F;
    try {
      f = new Float(data.get(path) + "").floatValue();
    } catch (Exception e) {
      if (CityBuildPlugin.debug) {
        e.printStackTrace();
      }
    }
    return f;
  }
  
  public long getLong(String path) {
    long i = 0L;
    try {
      i = new Long(data.get(path) + "").longValue();
    } catch (Exception e) {
      if (CityBuildPlugin.debug) {
        e.printStackTrace();
      }
    }
    return i;
  }
  
  public short getShort(String path) {
    short i = 0;
    try {
      i = new Long(data.get(path) + "").shortValue();
    } catch (Exception e) {
      if (CityBuildPlugin.debug) {
        e.printStackTrace();
      }
    }
    return i;
  }
  
  public ItemStack getItemStack(String path) {
    ItemStack item = null;
    try {
      item = (ItemStack)data.get(path);
    }
    catch (Exception localException) {}
    
    return item;
  }
  
  public Location getLocation(String path) {
    Location loc = null;
    try {
      loc = (Location)data.get(path);
    }
    catch (Exception localException) {}
    
    return loc;
  }
  
  public List<String> getStringList(String path)
  {
    List<String> list = new ArrayList();
    try {
      list = (List)data.get(path);
    }
    catch (Exception localException) {}
    
    return list;
  }
  
  public List<Integer> getIntegerList(String path)
  {
    List<Integer> list = new ArrayList();
    try {
      list = (List)data.get(path);
    }
    catch (Exception localException) {}
    
    return list;
  }
  
  public List<Location> getLocationList(String path)
  {
    List<Location> list = new ArrayList();
    try {
      list = (List)data.get(path);
    }
    catch (Exception localException) {}
    
    return list;
  }
}
