package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MiddlePanelGUI extends JPanel 
{
    private static final Color BACKGROUND = new Color(93, 139, 186);
    
    public MiddlePanelGUI(GameGUI frame, BoardGridGUI board) 
    {
        // Set the layout to vertical BoxLayout
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        Border background = new Border();
        
        //BoardGridGUI board = new BoardGridGUI(frame);
        background.add(board, BorderLayout.CENTER);
        this.add(background);
        
        this.add(new Spacer(1, 30));
        
        JPanel centeringPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centeringPanel.setBackground(BACKGROUND);
        
        MenuDockGUI menuDock = new MenuDockGUI(frame);
        centeringPanel.add(menuDock);
        
        //centeringPanel.add(new JButton());
        add(centeringPanel);
  
        //setPreferredSize(new Dimension(800, 800)); // Adjust the dimensions as needed
        setBackground(BACKGROUND); // Adjust the background color as needed

    }
}