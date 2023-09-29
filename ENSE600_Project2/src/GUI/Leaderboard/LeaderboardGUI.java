package GUI.Leaderboard;

import GUI.Spacer;
import game.Game;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class LeaderboardGUI extends JFrame
{
    public LeaderboardGUI(Game game)
    {
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
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Rank");
        model.addColumn("Player");
        model.addColumn("Score");
        model.addColumn("Date");

        JTable leaderboardTable = new JTable(model);
        
        JScrollPane leaderboardScroll = new JScrollPane(leaderboardTable);
        
        int widthPadding = 100;
        int topPadding = 10;
        int bottomPadding = 30;
        Border paddingBorder = BorderFactory.createEmptyBorder(topPadding, widthPadding, bottomPadding, widthPadding);
        leaderboardScroll.setBorder(paddingBorder);
        add(leaderboardScroll, BorderLayout.CENTER);
        
        setVisible(true);
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
