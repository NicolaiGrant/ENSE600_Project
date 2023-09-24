package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public class WinDialog extends JDialog
{
    private static final Color BACKGROUND = new Color(93, 139, 186);
    
    public WinDialog(String winner)
    {
        setSize(300, 150);
        setUndecorated(true);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int arcWidth = 50; // Adjust the radius of the rounded corners
                int arcHeight = 0; // Adjust the radius of the rounded corners
                int width = getWidth();
                int height = getHeight();
                g.setColor(getBackground());
                g.fillRoundRect(0, 0, width, height, arcWidth, arcHeight);
            }
        };
        
        panel.setBackground(BACKGROUND);
        //anel.setLayout(new BorderLayout());
        
        JLabel winMessage = new JLabel("Connect Four! " + winner + " Wins!");
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
