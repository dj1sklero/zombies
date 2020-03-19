package pl.dj1sklero.zombies.config;

import pl.dj1sklero.zombies.Zombies;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {
}


    Connection connection;


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
                connection = DriverManager.getConnection("jdbc:mysql://" + this.plugin.host + ":" + this.plugin.port + "/" + this.plugin.database + "?useSSL=false", this.plugin.username, this.plugin.password );
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }