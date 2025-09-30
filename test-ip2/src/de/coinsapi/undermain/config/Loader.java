package de.coinsapi.undermain.config;

public class Loader
{
  public Loader() {
    load();
  }
  
  public void load() {
     new files().loadDefaultLizenz();
     new files().loadConfig();
     new files().loadDefaultMySQLFile();
   }
 }
