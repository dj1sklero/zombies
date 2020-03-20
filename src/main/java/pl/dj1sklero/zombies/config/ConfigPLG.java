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

    private static Configuration configuration;
    public static String MYSQL_HOST;
    public static int MYSQL_PORT;
    public static String MYSQL_DATABASE;
    public static String MYSQL_USER;
    public static String MYSQL_PASS;





    private File configFile;
    private YamlConfiguration yamlConfig;

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
            java.nio.file.Files.copy(input, configFile.toPath());
        } catch(IOException e) {
            // Send an error message, etc.
        }
    }

    public YamlConfiguration getConfig() {
        return this.yamlConfig;
    }



    public static void loadSettings() {
        MYSQL_HOST = configuration.getString("settings.mysql.host");
        MYSQL_PORT = configuration.getInt("settings.mysql.port");
        MYSQL_DATABASE = configuration.getString("settings.mysql.database");
        MYSQL_USER = configuration.getString("settings.mysql.user");
        MYSQL_PASS = configuration.getString("settings.mysql.password");
    }

}
