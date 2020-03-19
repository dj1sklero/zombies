package pl.dj1sklero.zombies;

import org.bukkit.plugin.java.JavaPlugin;
import pl.dj1sklero.zombies.config.ConfigPLG;
import pl.dj1sklero.zombies.config.MySQL;

public final class Zombies extends JavaPlugin {

    public final ConfigPLG configPLG;
    public final MySQL mySQL;


    public Zombies(){
        this.configPLG = new ConfigPLG(this);
        this.mySQL = new MySQL(this);

    }

    @Override
    public void onEnable() {


    }

    @Override
    public void onDisable() {

    }
}
