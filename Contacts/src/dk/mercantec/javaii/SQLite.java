package dk.mercantec.javaii;

/**
 * Created by computer on 19-02-2015.
 */
import java.sql.*;
import java.util.ArrayList;

public class SQLite {
    public void SQLiteInsert(String SQLStatement) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:contact.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            statement.execute(SQLStatement);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }

    public ArrayList<ArrayList<ArrayList<String>>> SQLiteSelect(String SQLStatement) {
        ArrayList<ArrayList<ArrayList<String>>> myResult = new ArrayList<ArrayList<ArrayList<String>>>();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:contact.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            statement.execute(SQLStatement);
            ResultSet result = statement.getResultSet();

            for(int i = 0; i < result.getFetchSize(); i++) {
                myResult.get(0).add((ArrayList<String>) result.getArray(i));
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return myResult;
    }
}
