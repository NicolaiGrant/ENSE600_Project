/*
    Connect 4 - ENSE600 Project 2
    
    Nicolai Grant

    ID: 21145343
*/

package GUI.Buttons;

import GUI.MainMenu.MainMenuGUI;
import game.Game;
import java.awt.event.*;

public class HomeButton extends MenuButton
{
    public HomeButton(Game game, int buttonSize)
    {
        super(game, buttonSize);
        setText("Home");
        
        addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                MainMenuGUI mainMenu = new MainMenuGUI();
                mainMenu.setVisible(true);
                
                if(game.getLeaderboardGUI() != null)
                {
                    game.getLeaderboardGUI().dispose();
                    game.getLeaderboardDB().closeConnection();
                }
                else
                {
                    game.getGameGUI().dispose();
                }
                        
            }
        });
    }
}