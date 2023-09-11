package GUI;

import java.awt.*;
import javax.swing.*;

public class Border extends JPanel
{
    public Border()
    {
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 25));
        this.setPreferredSize(new Dimension(750, 650));
        this.setBackground(Colours.BLUE.getColour());
                
        setVisible(true);
    }
    
    @Override
    public void paintComponent(Graphics g) 
    {
        int width = getWidth();  
        int height = getHeight();

        int arcWidth = 50; 

        g.setColor(Colours.BLUE.getColour());
        g.fillRoundRect(0, 0, width, height, arcWidth, arcWidth);
    }
}
