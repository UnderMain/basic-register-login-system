package de.undermain.shop.util;


public class loader
{
  public loader() {
    load();
  }
  
  public void load() {
     new files().loadConfig();
     new files().loadDefaultMySQLFile();
   }
 }
