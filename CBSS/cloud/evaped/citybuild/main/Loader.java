package cloud.evaped.citybuild.main;

import cloud.evaped.citybuild.utils.nick.NickData;

public class Loader
{
  public Loader() {}
  
  public void loadAllFiles() {
    new NickData().loadData_NickNames();
    new NickData().loadData_NickSettings();
    new FileManager().loadData_Chat();
    new FileManager().loadData_Tab();
    new cloud.evaped.citybuild.utils.Messages().loadData_Messages();
    new cloud.evaped.citybuild.utils.settings.SettingsData().loadData_Settings();
    new FileManager().loadDefaultMySQLFile();
    new FileManager().loadData_ScoreboardRanks();
  }
}
