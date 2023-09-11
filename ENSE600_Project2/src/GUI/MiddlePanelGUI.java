package GUI;

import java.awt.*;
import javax.swing.*;

public class MiddlePanelGUI extends JPanel 
{
    private static final Color BACKGROUND = new Color(93, 139, 186);
    
    public MiddlePanelGUI(GameGUI frame, BoardGridGUI board) 
    {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        Border background = new Border();
        background.add(board, BorderLayout.CENTER);
        this.add(background);
        
        this.add(new Spacer(1, 20));
        
        JPanel centeringPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centeringPanel.setBackground(BACKGROUND);
        
        MenuDockGUI menuDock = new MenuDockGUI(frame);
        centeringPanel.add(menuDock);
        add(centeringPanel);

        setBackground(BACKGROUND); 

    }
}