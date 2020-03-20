package pl.dj1sklero.zombies.config;

import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.YamlConfiguration;
import pl.dj1sklero.zombies.Zombies;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ConfigPLG {
    private Zombies plugin;

    public ConfigPLG(Zombies plugin) {
        this.plugin = plugin;
    }

    public File configFile;
    public YamlConfiguration yamlConfig;

    public void ConfigManager(Zombies plugin, String filename) {
        this.plugin = plugin;
        this.configFile = new File(plugin.getDataFolder(), filename);

        if(!configFile.exists()) {
            saveDefaultConfiguration();
        }

        this.yamlConfig = YamlConfiguration.loadConfiguration(configFile);
    }

        private void saveDefaultConfiguration() {
        // Add code for copying contents of myConfig.yml here.
        try {
            InputStream input = plugin.getResource(configFile.getName());

            // Output file MUST NOT EXIST! If it does, an IOException is thrown
          //  java.nio.file.Files.copy(input, configFile.toPath());

            yamlConfig.addDefault("host","localhost");
            yamlConfig.addDefault("port","3306");
            yamlConfig.addDefault("database","database");
            yamlConfig.addDefault("user","root");
            yamlConfig.addDefault("password","");
            yamlConfig.save(configFile);

        } catch(IOException e) {
            // Send an error message, etc.
        }
    }


}
