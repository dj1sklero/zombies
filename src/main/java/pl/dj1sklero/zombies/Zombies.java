package pl.dj1sklero.zombies;

import org.bukkit.plugin.java.JavaPlugin;
import pl.dj1sklero.zombies.config.ConfigPLG;

public final class Zombies extends JavaPlugin {

    public final ConfigPLG configPLG;

    public Zombies(){
        this.configPLG = new ConfigPLG(this);
    }

    @Override
    public void onEnable() {
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
