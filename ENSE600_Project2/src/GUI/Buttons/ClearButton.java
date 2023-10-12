package GUI.Buttons;

import game.Game;
import java.awt.event.*;

import game.Game;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearButton extends MenuButton
{
    public ClearButton(Game game, int buttonSize)
    {
        super(game, buttonSize);
        setText("Clear");
        
        addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                game.getLeaderboardDB().clearLeaderboard();
                game.getLeaderboardGUI().repaint();
            }
        });
    }
//    
//    @Override
//    public void paintComponent(Graphics g)
//    {
//        g.setColor(Color.YELLOW);
//        g.fillOval(0, 0, buttonSize, buttonSize);
//    }
}
