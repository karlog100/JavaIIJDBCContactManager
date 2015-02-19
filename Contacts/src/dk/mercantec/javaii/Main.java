package dk.mercantec.javaii;

import java.sql.*;
import dk.mercantec.javaii.SQLite;

public class Main {

    public static void main(String[] args) {

        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection("jdbc:sqlite:contact.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            statement.executeUpdate("drop table if exists internal");
            statement.executeUpdate("create table internal (id integer, name string, phone string, email string, department string)");
            statement.executeUpdate("drop table if exists external");
            statement.executeUpdate("create table external (id integer, name string, phone string, email string, company string)");
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
        finally
        {
            try
            {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e)
            {
                System.err.println(e);
            }
        }

        SQLite mySQL = new SQLite();
        mySQL.SQLiteInsert("INSERT INTO internal VALUES(name, phone, email, department)";

        UI ui = new UI(new Contacts());
        while (true) {
            ui.MainMenu().Show();
        }
    }
}
