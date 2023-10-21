package GUI;

import game.Player;
import java.awt.*;
import javax.swing.*;

public class CurrentPlayerGUI extends JPanel
{
    private Player player;
    private Color colour;
    
    private final int SIZE = 100;
    
    String playerName;
    
    public CurrentPlayerGUI(Player player)
    {
        this.player = player;
        this.playerName = player.getName();
        this.colour = player.getColour();
        
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(200, 300));
        setBackground(Colours.BLUE.getColour());
                
        setVisible(true);
    }
    
    private Color getColour()
    {
        return this.colour;
    }
    
    public void setColour(Color colour)
    {
        this.colour = colour;
        repaint();
        revalidate();
    }
        
    @Override
    public void paintComponent(Graphics g) 
    {
        int width = getWidth();  
        int height = getHeight();

        int arcWidth = 50; 
        
        setOpaque(false);

        g.setColor(Colours.BLUE.getColour());
        g.fillRoundRect(0, 0, width, height, arcWidth, arcWidth); 

        int circleSize = 100;  
        int circleX = (width - circleSize) / 2;     
        int circleY = (height - circleSize) / 2;      

        g.setColor(player.getColour());
        g.fillOval(circleX, circleY, circleSize, circleSize);
        
        String nameLabel = this.playerName;
        g.setColor(Color.WHITE); 
        Font originalFont = g.getFont();
        Font labelFont = new Font(originalFont.getName(), Font.BOLD, 30);
        g.setFont(labelFont);
        int labelX = (width - g.getFontMetrics().stringWidth(nameLabel)) / 2; 
        int labelY = circleY - 20; 
        g.drawString(nameLabel, labelX, labelY);

        if(player.isTurn())
        {
            String yourTurn = "Your Turn";
            int turnX = (width - g.getFontMetrics().stringWidth(yourTurn)) / 2;;
            int turnY = circleY + circleSize + 60; 
            g.drawString(yourTurn, turnX, turnY);
        }
        
        
    }
}
