package GUI;

import game.Player;
import java.awt.*;
import javax.swing.*;

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
    public void paintComponent(Graphics g) 
    {
        int width = getWidth();  
        int height = getHeight();

        int arcWidth = 50; 

        g.setColor(Colours.BLUE.getColour());
        g.fillRoundRect(0, 0, width, height, arcWidth, arcWidth); 

        int circleSize = 100;  
        int circleX = (width - circleSize) / 2;     
        int circleY = (height - circleSize) / 2;      

        g.setColor(this.getColour());
        g.fillOval(circleX, circleY, circleSize, circleSize);
        
        String label = currentPlayer.getName();
        g.setColor(Color.WHITE); 
        Font originalFont = g.getFont();
        Font labelFont = new Font(originalFont.getName(), Font.BOLD, 30);
        g.setFont(labelFont);
        int labelX = (width - g.getFontMetrics().stringWidth(label)) / 2; 
        int labelY = circleY - 20; 
        g.drawString(label, labelX, labelY);
    }
}
