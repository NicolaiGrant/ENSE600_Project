package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JButton;

public class BoardSlot extends JButton
{
    private static final int SIZE = 100;
    
    private static final Color BLUE = new Color(18, 69, 89);
    private static final Color EMPTY = new Color(89, 131, 146);
    
    public BoardSlot()
    {
        setPreferredSize(new Dimension(SIZE, SIZE));
        setBorderPainted(true);
        setContentAreaFilled(false);
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        g.setColor(BLUE);
        g.fillRect(0,0,SIZE,SIZE);
        
        int circleSize = SIZE - 20;
        int circleX = (SIZE - circleSize) / 2;
        int circleY = (SIZE - circleSize) / 2;
        
        g.setColor(EMPTY);
        g.fillOval(circleX, circleY, circleSize, circleSize);
    }
}
