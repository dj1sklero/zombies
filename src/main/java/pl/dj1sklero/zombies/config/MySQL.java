package pl.dj1sklero.zombies.config;

import pl.dj1sklero.zombies.Zombies;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {

    private final Zombies plugin;

    Connection connection;

    public MySQL(Zombies plugin) {
        this.plugin = plugin;
    }

    public void openConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("polaczenie juz nawiazane");
        }

        synchronized (this) {
            try {
                if (connection != null && !connection.isClosed()) {
                    return;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {
                System.out.println("probuje laczyc");
                connection = DriverManager.getConnection("jdbc:mysql://" + this.plugin.configPLG.yamlConfig.getString("host") + ":" + this.plugin.configPLG.yamlConfig.getString("port") + "/" + this.plugin.configPLG.yamlConfig.getString("database") + "?useSSL=false", this.plugin.configPLG.yamlConfig.getString("user"), this.plugin.configPLG.yamlConfig.getString("password"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}