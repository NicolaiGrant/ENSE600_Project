package GUI.Buttons;

import GUI.GameGUI;
import java.awt.*;
import java.awt.event.*;

public class ReplayButton extends MenuButton
{
    public ReplayButton(GameGUI board, int buttonSize)
    {
        super(board, buttonSize);
        setText("Replay");
        
        //this.SIZE = buttonSize;
        
        addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                board.resetBoard();
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
