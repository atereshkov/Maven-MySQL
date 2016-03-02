package com.handidevelop.database;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class Main {

    public static void main(String[] args)
    {
        DBWorker dbWorker = new DBWorker();

        String query = "select * from users";

        try {
            Statement statement = dbWorker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next())
            {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setUsername(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                System.out.println(user);
            }

        }
        catch (SQLException e)
        {
            System.out.println("Error.");
            e.printStackTrace();
        }

    }

}
