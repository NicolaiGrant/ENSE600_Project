package GUI;

import GUI.Buttons.*;
import game.Game;
import java.awt.*;
import javax.swing.*;

public class MenuDockGUI extends JPanel
{
    private static final Color BACKGROUND = new Color(93, 139, 186);
    
    private int width = 280;
    private int height = 80;
    
    private int buttonSize = 50;
    
    public MenuDockGUI(Game game)
    {
        setLayout(new FlowLayout(FlowLayout.CENTER, 40, (height / 2) - (buttonSize / 2)));
        setPreferredSize(new Dimension(width, height));
        setBackground(BACKGROUND);
        
        add(new ReplayButton(game, buttonSize));
        add(new HomeButton(game, buttonSize));
        add(new ExitButton(game, buttonSize));
        
        setVisible(true);
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
