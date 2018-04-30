package dao.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class ConnectionUtils
{

    private static Connection connection;

    public static Connection getConnection()
    {
        return connection;
    }

    public static void setConnection(Connection connection)
    {
        ConnectionUtils.connection = connection;
    }

    public static boolean createConnection() throws ClassNotFoundException
    {
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            setConnection(DriverManager.getConnection("jdbc:sqlserver://localhost\\ZRK:1433;databaseName=Taxi","adminTaxi","250897"));
            return true;
        }
        catch (SQLException ex)
        {
            return false;
        }
    }

    public static void closeConnection() throws SQLException
    {
        getConnection().close();
    }
}
