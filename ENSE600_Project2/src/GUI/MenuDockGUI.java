/*
    Connect 4 - ENSE600 Project 2
    
    Nicolai Grant

    ID: 21145343
*/

package GUI;

import GUI.Buttons.*;
import game.Game;
import java.awt.*;
import javax.swing.*;

public class MenuDockGUI extends JPanel
{
    // JPanel that contains buttons for users to replay, return to the main menu
    // and exit the game.
    protected static final Color BACKGROUND = new Color(93, 139, 186);
    
    protected int width = 280;
    protected int height = 80;
    
    protected int buttonSize = 50;
    
    public MenuDockGUI(Game game)
    {
        setLayout(new FlowLayout(FlowLayout.CENTER, 40, (height / 2) - (buttonSize / 2)));
        setPreferredSize(new Dimension(width, height));
        setBackground(BACKGROUND);
        
        addButtons(game);

        setVisible(true);
    }
    
    public void addButtons(Game game)
    {
        add(new ReplayButton(game, buttonSize));
        add(new HomeButton(game, buttonSize));
        add(new ExitButton(game, buttonSize));
    }
    
    @Override
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        
        int width = getWidth();
        int height = getHeight();

        int arcWidth = 80; 

        g.setColor(Colours.BLUE.getColour());
        g.fillRoundRect(0, 0, width, height, height, height);

    }   
}
