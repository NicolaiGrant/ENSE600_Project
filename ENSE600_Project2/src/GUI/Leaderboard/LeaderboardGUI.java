package GUI.Leaderboard;

import Database.LeaderboardDB;
import Database.LeaderboardData;
import GUI.Colours;
import GUI.MenuDockGUI;
import GUI.Spacer;
import game.Game;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.util.Collections;
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
        leaderboardTable.setBackground(Colours.BLUE.getColour());
        leaderboardTable.setForeground(Color.WHITE);
        leaderboardTable.setFont(new Font("SansSerif", Font.PLAIN, 18));
        leaderboardTable.setRowHeight(30);
        leaderboardTable.setAlignmentX(CENTER_ALIGNMENT);
        leaderboardTable.setShowGrid(true);
        leaderboardTable.setGridColor(Color.WHITE);
        leaderboardTable.setDefaultEditor(Object.class, null);
        leaderboardTable.getTableHeader().setReorderingAllowed(false);
        
        JScrollPane leaderboardScroll = new JScrollPane(leaderboardTable);
        leaderboardScroll.getViewport().setBackground(Colours.BLUE.getColour());
        
        int widthPadding = 150;
        int topPadding = 10;
        int bottomPadding = 20;
        Border paddingBorder = BorderFactory.createEmptyBorder(topPadding, widthPadding, bottomPadding, widthPadding);
        leaderboardScroll.setBorder(paddingBorder);
        add(leaderboardScroll, BorderLayout.CENTER);
        
        add(new LeaderboardDockGUI(game), BorderLayout.SOUTH);
        
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
