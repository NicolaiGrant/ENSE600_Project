/*
    Connect 4 - ENSE600 Project 2
    
    Nicolai Grant

    ID: 21145343
*/

package GUI;

import game.Game;
import java.awt.*;
import javax.swing.*;

public class MiddlePanelGUI extends JPanel 
{
    private static final Color BACKGROUND = new Color(93, 139, 186);
    
    public MiddlePanelGUI(Game game) 
    {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        Border background = new Border();
        background.add(game.getBoardGUI(), BorderLayout.CENTER);
        this.add(background);
        
        this.add(new Spacer(1, 20));
        
        JPanel centeringPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centeringPanel.setBackground(BACKGROUND);
        
        MenuDockGUI menuDock = new MenuDockGUI(game);
        centeringPanel.add(menuDock);
        add(centeringPanel);

        setBackground(BACKGROUND); 

    }
}