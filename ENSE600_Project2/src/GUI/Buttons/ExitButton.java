/*
    Connect 4 - ENSE600 Project 2
    
    Nicolai Grant

    ID: 21145343
*/

package GUI.Buttons;

import game.Game;
import java.awt.event.*;

public class ExitButton extends MenuButton
{
    public ExitButton(Game game, int buttonSize)
    {
        super(game, buttonSize);
        setText("Exit");
        
        addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                game.getGameGUI().dispose();
                game.exit();
            }
        });
    }
}