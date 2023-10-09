package GUI;

import java.awt.Color;
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
        setSize(900, 100);
        setUndecorated(true);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel() {};     
        panel.setBackground(BACKGROUND);
        
        JLabel winMessage = new JLabel("Connect Four! " + winner + " Wins!");
        winMessage.setFont(new Font("TW Cen MT Condensed Extra Bold", Font.BOLD, 70));
        winMessage.setForeground(Color.WHITE);
        panel.add(winMessage);
         
        add(panel);
        setVisible(true);
        
        int delay = 2000; // 2 second delay
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
