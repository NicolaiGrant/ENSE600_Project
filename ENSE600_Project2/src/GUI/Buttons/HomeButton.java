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
                }
                else
                {
                    game.getGameGUI().dispose();
                }
                        
            }
        });
    }
    
//    @Override
//    public void paintComponent(Graphics g)
//    {
//        g.setColor(Color.RED);
//        g.fillOval(0, 0, buttonSize, buttonSize);
//    }
}