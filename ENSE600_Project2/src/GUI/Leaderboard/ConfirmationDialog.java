package GUI.Leaderboard;

import GUI.Spacer;
import game.Game;
import static game.Game.BACKGROUND;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ConfirmationDialog extends JDialog
{
    public ConfirmationDialog(Game game)
    {
        setSize(720, 400);
        setUndecorated(false);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);

        JPanel panel = new JPanel() {};
        panel.setBackground(BACKGROUND);

        JLabel warningMessage = new JLabel("Are you sure you would like to clear the leaderboard?");
        JLabel lineTwo = new JLabel("This cannot be undone!");
        warningMessage.setFont(new Font("SansSerif", Font.PLAIN, 20));
        lineTwo.setFont(new Font("SansSerif", Font.PLAIN, 20));

        warningMessage.setForeground(Color.WHITE);
        lineTwo.setForeground(Color.WHITE);

        JButton clearButton = new JButton("Clear");
        JButton backButton = new JButton("Back");
        
        clearButton.setFont(new Font("SansSerif", Font.PLAIN, 20));
        backButton.setFont(new Font("SansSerif", Font.PLAIN, 20));

        // Increase the button size
        clearButton.setPreferredSize(new java.awt.Dimension(200, 60));
        backButton.setPreferredSize(new java.awt.Dimension(200, 60));

        // Create a panel to hold the buttons with spacing
        JPanel buttonPanel = new JPanel();
        panel.add(add(new Spacer(100,100)));
        buttonPanel.setBackground(BACKGROUND);
        buttonPanel.add(clearButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(20, 0))); // Add spacing between buttons
        buttonPanel.add(backButton);
        
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Use BoxLayout for vertical alignment
        
        JPanel centerAlignedPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Create a panel with center-aligned layout
        centerAlignedPanel.add(lineTwo);
        centerAlignedPanel.setBackground(BACKGROUND);

        panel.add(warningMessage);
        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing between message and buttons
        panel.add(centerAlignedPanel);
        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing between message and buttons
        panel.add(buttonPanel);
        
        clearButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                game.getLeaderboardDB().clearLeaderboard();
                game.getLeaderboardGUI().clearLeaderboardTable();
                dispose();
            }
        });
        
         backButton.addActionListener(new ActionListener() 
         {
            public void actionPerformed(ActionEvent e) 
            {
                dispose();
            }
        });

        add(panel);
        setVisible(true);
    }

}
