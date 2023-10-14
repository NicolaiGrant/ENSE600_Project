package GUI.Buttons;

import GUI.Leaderboard.ConfirmationDialog;
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
                new ConfirmationDialog(game);
 
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
