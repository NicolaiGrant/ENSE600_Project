package GUI.Leaderboard;

import Database.LeaderboardDB;
import Database.LeaderboardData;
import game.Game;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Collections;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class LeaderboardGUI extends JFrame
{
    private Game game;
    private LeaderboardDB leaderboardDB;
    private DefaultTableModel model;
    
    public LeaderboardGUI(Game game)
    {
        this.game = game;
        this.leaderboardDB = game.getLeaderboardDB();
        this.model = new DefaultTableModel();
        
        setTitle("Leaderboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        getContentPane().setBackground(game.BACKGROUND);
        setScreenSize();
        
        add(new CenterPanel(game, model));
        
        populateLeaderboardTable();
        setVisible(true);
    }
    
    public LeaderboardDB getDatabase()
    {
        return this.leaderboardDB;
    }
    
    public void populateLeaderboardTable()
    {
        List<LeaderboardData> leaderboardData = getDatabase().getLeaderboardData();
        Collections.sort(leaderboardData, Collections.reverseOrder()); // Sort the lsit by score so it is in order of rank
        
        int rank = 1;
        
        for(LeaderboardData playerData : leaderboardData)
        {
            this.model.addRow(new Object[] {rank, playerData.getPlayerName(), playerData.getScore(), playerData.getDate()});
            rank++;
        }
    }
    
    public void clearLeaderboardTable() 
    {
        int rowCount = model.getRowCount();
        
        for (int i = rowCount - 1; i >= 0; i--) 
        {
            model.removeRow(i);
        }
    }
    
    public void setScreenSize()
    {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        int frameWidth = screenWidth / 2 + 200;
        int frameHeight = screenHeight / 2 + 200;
        setSize(frameWidth, frameHeight);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setVisible(true);
    }
}
