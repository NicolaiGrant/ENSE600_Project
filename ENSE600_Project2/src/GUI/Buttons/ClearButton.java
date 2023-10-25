/*
    Connect 4 - ENSE600 Project 2
    
    Nicolai Grant

    ID: 21145343
*/

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
}
