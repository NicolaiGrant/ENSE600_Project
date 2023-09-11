package GUI;

import GUI.Colours;
import game.Player;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class CurrentPlayerGUI extends JPanel
{
    private Player currentPlayer;
    private Color colour;
    
    private final int SIZE = 100;
    
    public CurrentPlayerGUI(Player currentPlayer)
    {
        this.currentPlayer = currentPlayer;
        this.colour = currentPlayer.getColour();
        
        setLayout(new BorderLayout());
        //setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        setPreferredSize(new Dimension(200, 300));
        setBackground(Colours.BLUE.getColour());
                
        setVisible(true);
    }
    
    private Color getColour()
    {
        return this.colour;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        // Paints the button to be a blue square with a circle in the middle

        int width = getWidth();  // Get the width of the component
        int height = getHeight(); // Get the height of the component

        int arcWidth = 50; // Adjust the arc width for the rounded edges

        g.setColor(Colours.BLUE.getColour());
        g.fillRoundRect(0, 0, width, height, arcWidth, arcWidth); // Fill the rounded rectangle

        int circleSize = 100;  // Fixed circle size
        int circleX = (width - circleSize) / 2;        // Center horizontally
        int circleY = (height - circleSize) / 2;      // Center vertically

        g.setColor(this.getColour());
        g.fillOval(circleX, circleY, circleSize, circleSize);
        
        String label = currentPlayer.getName();
        g.setColor(Color.WHITE); // Set color for the label text
        Font originalFont = g.getFont();
        Font labelFont = new Font(originalFont.getName(), Font.BOLD, 30); // Customize the font size and style
        g.setFont(labelFont);
        int labelX = (width - g.getFontMetrics().stringWidth(label)) / 2; // Center horizontally
        int labelY = circleY - 20; // Position above the circle
        g.drawString(label, labelX, labelY);
    }
    
    
}
