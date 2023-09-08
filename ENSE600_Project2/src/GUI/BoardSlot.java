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
    
    private static final Color BLUE = new Color(18, 69, 89);
    private static final Color EMPTY = new Color(89, 131, 146);
    
    public BoardSlot()
    {
        setPreferredSize(new Dimension(SIZE, SIZE));
        setBorderPainted(true);
        setContentAreaFilled(false);
        
        // Add a mouse listener to handle hover events
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBorder(null);
            }
        });
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
