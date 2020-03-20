package pl.dj1sklero.zombies;

import org.bukkit.plugin.java.JavaPlugin;
import pl.dj1sklero.zombies.config.ConfigPLG;
import pl.dj1sklero.zombies.config.MySQL;
import pl.dj1sklero.zombies.ulepszenia.Personalne;

public final class Zombies extends JavaPlugin {
    public final ConfigPLG configPLG;
    public final MySQL mySQL;
    public final Personalne Personalne;




    public Zombies(){
        this.configPLG = new ConfigPLG(this);
        this.mySQL = new MySQL(this);
        this.Personalne = new Personalne(this);
    }

    public String host, database, username, password;
    public int port;


    @Override
    public void onEnable() {
        this.getLogger().info("Uruchamiam sie!");
        this.configPLG.ConfigManager(this ,"config");


        this.mySQL.openConnection();

    }

    @Override
    public void onDisable() {

    }
}
