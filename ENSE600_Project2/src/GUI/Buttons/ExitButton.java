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
//    
//    @Override
//    public void paintComponent(Graphics g)
//    {
//        g.setColor(Color.YELLOW);
//        g.fillOval(0, 0, buttonSize, buttonSize);
//    }
}