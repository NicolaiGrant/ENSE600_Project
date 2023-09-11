package GUI.Test;

import GUI.Colours;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

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
    public void paintComponent(Graphics g) {
        // Paints the button to be a blue square with a circle in the middle

        int width = getWidth();  // Get the width of the component
        int height = getHeight(); // Get the height of the component

        int arcWidth = 50; // Adjust the arc width for the rounded edges

        g.setColor(Colours.BLUE.getColour());
        g.fillRoundRect(0, 0, width, height, arcWidth, arcWidth); // Fill the rounded rectangle
    }
}
