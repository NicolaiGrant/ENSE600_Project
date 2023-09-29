package GUI.Buttons;

import GUI.GameGUI;
import game.Game;
import java.awt.*;
import java.awt.event.*;

public class ReplayButton extends MenuButton
{
    public ReplayButton(Game game, int buttonSize)
    {
        super(game, buttonSize);
        setText("Replay");

        addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                game.switchPlayers();
                game.getBoardGUI().resetBoard();  
            }
        });
    }
    
//    @Override
//    public void paintComponent(Graphics g)
//    {
//        g.setColor(Color.WHITE);
//        g.fillOval(0, 0, buttonSize, buttonSize);
//    }
}
