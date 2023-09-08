package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class BoardSlot extends JButton
{
    private static final int SIZE = 100;
    
    //private static final Color BLUE = new Color(18, 69, 89);
    private static final Color BLUE = new Color(102, 153, 204);
    //private static final Color EMPTY = new Color(89, 131, 146);
    private static final Color YELLOW = new Color(255, 242, 117);
    private static final Color EMPTY = new Color(255,255,255);
    
    private static final Color RED = new Color(255, 60, 56);
    
    public Color circleColour = EMPTY;
    
    private int column;
    
    public BoardSlot(int j)
    {
        setPreferredSize(new Dimension(SIZE, SIZE));
        setBorderPainted(true);
        setContentAreaFilled(false);
        
        this.column = j;
        
        this.mouseHover();
        
        this.getColumn();
    }
    
    public int getColumn()
    {
        return this.column;
    }
    
    public void mouseHover()
    {
        // Adds a border around the slots when hovered over with the mouse
        
        addMouseListener(new MouseAdapter() 
        {         
            @Override
            public void mouseEntered(MouseEvent e) 
            {
                setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            }

            @Override
            public void mouseExited(MouseEvent e) 
            {
                setBorder(null);
            }
        });
    }
    
    public void mouseClick()
    {
        addMouseListener(new MouseAdapter() 
        {                
            @Override
            public void mousePressed(MouseEvent e) {

                circleColour = YELLOW;
                repaint();
            }
        });
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        // Paints the button to be a blue square with a circle in the middle
        
        g.setColor(BLUE);
        g.fillRect(0,0,SIZE,SIZE);
        
        int circleSize = SIZE - 20;
        int circleX = (SIZE - circleSize) / 2;
        int circleY = (SIZE - circleSize) / 2;
        
        g.setColor(circleColour);
        g.fillOval(circleX, circleY, circleSize, circleSize);
    }
}
