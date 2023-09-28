package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LeaderboardDB 
{
    DBManager dbManager;
    Connection conn;
    Statement statement;
    
    String leaderboard = "LEADERBOARD";

    public LeaderboardDB() {
        dbManager = new DBManager();
        conn = dbManager.getConnection();
        try {
            statement = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
    public void createLeaderboardTable()
    {
        checkExistingTable("LEADERBOARD");        
        
        String sqlCreateTable = "CREATE TABLE LEADERBOARD (PLAYER VARCHAR(20), SCORE INT, DATE VARCHAR(20))";
        dbManager.updateDB(sqlCreateTable);
            
        // String sqlInsertRecords = "INSERT INTO PROMOTION VALUES ('Fiction', 0), ('Non-fiction', 10), ('Textbook', 30)";
        //dbManager.updateDB(sqlInsertRecords);
    }
    
    public void updateTable(String playerName, int score, String date)
    {
        String sqlInsertRecords = "INSERT INTO LEADERBOARD VALUES ('" + playerName+ "', " + score + ", '" + date + "')";
        dbManager.updateDB(sqlInsertRecords);
    }
    
    public void getTable()
    {
        try 
         {
            String query = "SELECT * FROM LEADERBOARD";
            ResultSet rs = dbManager.queryDB(query);
            
            while(rs.next())
            {
                String playerName = rs.getString("PLAYER");
                int score = rs.getInt("SCORE");
                String date = rs.getString("DATE");
                System.out.println("Player: " + playerName + ", Score: " + score + ", Date: " + date);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public boolean isPlyerInDB(String playerName)
    {
        // Returns true if the input player name is in the database
        
        try 
         {
            String query = "SELECT * FROM LEADERBOARD";
            ResultSet rs = dbManager.queryDB(query);
            
            while(rs.next())
            {
                if(rs.getString("PLAYER").equals(playerName))
                {
                    return true;
                }
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return false;
    }
            

    public void checkExistingTable(String tableName)
    {
        try
        {
            ResultSet tables = conn.getMetaData().getTables(null, null, tableName, null);
 
            if (tables.next()) 
            {
                dbManager.updateDB("DROP TABLE " + tableName);
            }
        } 
        catch (SQLException ex) 
        {
            System.err.println("SQLException: " + ex.getMessage());
        }
    }

    public void closeConnection() {
        this.dbManager.closeConnections();
    }

    public static void main(String[] args) {
        LeaderboardDB leaderboard = new LeaderboardDB();
        leaderboard.createLeaderboardTable();
        leaderboard.updateTable("Nicolai", 10, "28/09/2023");
        leaderboard.getTable();
        
        System.out.println(leaderboard.isPlyerInDB("Bob"));
        
        leaderboard.closeConnection();
        
    }
}
