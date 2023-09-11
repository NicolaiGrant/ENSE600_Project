package GUI.Buttons;

import GUI.GameGUI;
import java.awt.*;
import java.awt.event.*;

public class ExitButton extends MenuButton
{
    public ExitButton(GameGUI board, int buttonSize)
    {
        super(board, buttonSize);
        setText("Exit");
        
        addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                board.dispose();
                System.exit(0);
            }
        });
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        g.setColor(Color.YELLOW);
        g.fillOval(0, 0, buttonSize, buttonSize);
    }
}