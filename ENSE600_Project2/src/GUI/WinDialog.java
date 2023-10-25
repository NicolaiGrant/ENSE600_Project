/*
    Connect 4 - ENSE600 Project 2
    
    Nicolai Grant

    ID: 21145343
*/

package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public class WinDialog extends JDialog
{
    // JDialog box used to notify the player that the game is over with a win
    // message "Connect Four! 'player name' Wins! that lasts for 2 seconds.
    private static final Color BACKGROUND = new Color(93, 139, 186);
    
    public WinDialog(String winner)
    {
        setUndecorated(true);
        
        
        JPanel panel = new JPanel() {};     
        panel.setBackground(BACKGROUND);
        
        JLabel winMessage = new JLabel("Connect Four! " + winner + " Wins!");
        winMessage.setFont(new Font("TW Cen MT Condensed Extra Bold", Font.BOLD, 60));
        winMessage.setForeground(Color.WHITE);
        winMessage.setHorizontalAlignment(JLabel.CENTER);
        setSize(new Dimension(winMessage.getPreferredSize().width + 40, 80));
        panel.add(winMessage);
         
        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
        
        int delay = 2000;
        // Close the Win Dialog after delay
        Timer timer = new Timer(delay, new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {   
                dispose();
            }
        });
        
        timer.start();
    }
}
