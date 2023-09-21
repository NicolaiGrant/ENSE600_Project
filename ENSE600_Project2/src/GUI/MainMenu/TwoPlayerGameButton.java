package GUI.MainMenu;

import GUI.GameGUI;
import java.awt.*;
import java.awt.event.*;

public class TwoPlayerGameButton extends MenuButton
{
    public TwoPlayerGameButton(MainMenu menu, int buttonSize)
    {
        super(menu, buttonSize);
        setText("Two Player Mode");
        
        addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                GameGUI game = new GameGUI();
                game.getBoard().startGame();
                menu.dispose();
            }
        });
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        g.setColor(Color.RED);
        g.fillOval(0, 0, buttonSize, buttonSize);
    }
}