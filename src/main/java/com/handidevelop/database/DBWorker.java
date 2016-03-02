package com.handidevelop.database;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBWorker {

    private static final String URL = "jdbc:mysql://localhost:3306/dbtest?autoReconnect=true&useSSL=true";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private Connection connection;

    public DBWorker()
    {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            if (!connection.isClosed())
            {
                System.out.println("Соединение с БД установлено.");
            }
        }
        catch (SQLException e)
        {
            System.err.println("Error");
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
