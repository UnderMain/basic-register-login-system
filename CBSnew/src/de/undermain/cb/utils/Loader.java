package de.undermain.cb.utils;


 public class Loader
{
  public Loader() {
    load();
  }
  
  public void load() {
     new Files().loadDefaultMySQLFile();
     new Files().loadMessageFile();
   }
 }
