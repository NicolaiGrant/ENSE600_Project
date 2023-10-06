package GUI.Leaderboard;

import Database.LeaderboardDB;
import Database.LeaderboardData;
import GUI.Spacer;
import game.Game;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.*;
import javax.swing.border.Border;
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
        
        add(new Spacer(150, 150));
        
        JPanel titlePanel = new JPanel(new GridBagLayout());
        titlePanel.setBackground(game.BACKGROUND);
        JLabel leaderboardTitle = new JLabel("Leaderboard");
        
        Font titleFont = new Font("TW Cen MT Condensed Extra Bold", Font.BOLD, 70);
        leaderboardTitle.setFont(titleFont);
        leaderboardTitle.setForeground(Color.WHITE);
        titlePanel.add(leaderboardTitle);
        
        add(titlePanel, BorderLayout.NORTH);
        
        
        this.model.addColumn("Rank");
        this.model.addColumn("Player");
        this.model.addColumn("Score");
        this.model.addColumn("Date");

        JTable leaderboardTable = new JTable(model);
        
        JScrollPane leaderboardScroll = new JScrollPane(leaderboardTable);
        
        int widthPadding = 100;
        int topPadding = 10;
        int bottomPadding = 30;
        Border paddingBorder = BorderFactory.createEmptyBorder(topPadding, widthPadding, bottomPadding, widthPadding);
        leaderboardScroll.setBorder(paddingBorder);
        add(leaderboardScroll, BorderLayout.CENTER);
        
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
        
        for(LeaderboardData playerData : leaderboardData)
        {
            this.model.addRow(new Object[] {1, playerData.getPlayerName(), playerData.getScore(), playerData.getDate()});
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
