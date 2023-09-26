package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LeaderboardDatabase 
{
    private static final String USER_NAME = "pdc"; //your DB username
    private static final String PASSWORD = "pdc"; //your DB password
    private static final String URL = "jdbc:derby:BookStoreDB_Ebd; create=true";  //url of the DB host

    Connection conn;
    
    public LeaderboardDatabase()
    {
        establishConnection();
    }
    
    public void establishConnection() 
    {     
        try
        {
            conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            System.out.println(URL + " connected...");
        }
        catch(SQLException ex)
        {
            System.err.println("SQLException: " + ex.getMessage());
        }   
    }
    
    public void closeConnections() 
    {
        if (conn != null) 
        {
            try 
            {
                conn.close();
            } 
            catch (SQLException ex) 
            {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public ResultSet queryDB(String sql) 
    {
        Connection connection = this.conn;
        Statement statement = null;
        ResultSet resultSet = null;

        try 
        {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

        } 
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        }
        return resultSet;
    }

    public void updateDB(String sql) 
    {
        Connection connection = this.conn;
        Statement statement = null;
        ResultSet resultSet = null;

        try 
        {
            statement = connection.createStatement();
            statement.executeUpdate(sql);

        } 
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        }
    }
}
