package de.undermain.config;

public class Loader
{
  public Loader() {
    load();
  }
  
  public void load() {
     new files().loadDefaultMySQLFile();
     new files().loadMessageFile();
   }
 }
