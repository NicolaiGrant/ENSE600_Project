package GUI.Leaderboard;

import GUI.Colours;
import GUI.Spacer;
import game.Game;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class CenterPanel extends JPanel 
{
    private static final Color BACKGROUND = new Color(93, 139, 186);
    private DefaultTableModel model;
    
    public CenterPanel(Game game) 
    {
        this.model = new DefaultTableModel();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Title
        JPanel titlePanel = new JPanel(new GridBagLayout());
        titlePanel.setBackground(game.BACKGROUND);
        JLabel leaderboardTitle = new JLabel("Leaderboard");
        
        Font titleFont = new Font("TW Cen MT Condensed Extra Bold", Font.BOLD, 70);
        leaderboardTitle.setFont(titleFont);
        leaderboardTitle.setForeground(Color.WHITE);
        titlePanel.add(leaderboardTitle);
        
        add(titlePanel);
        
        // Leaderboard Table
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
        leaderboardScroll.setPreferredSize(new Dimension(1000, 800));
        add(leaderboardScroll, BorderLayout.CENTER);
        
        
        // Menu Dock
        JPanel centeringPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centeringPanel.setBackground(BACKGROUND);
        
        LeaderboardDockGUI leaderboardDock = new LeaderboardDockGUI(game);
        centeringPanel.add(leaderboardDock);
        add(centeringPanel);
        
        add(new Spacer(20,20));

        setBackground(BACKGROUND); 
    }
}