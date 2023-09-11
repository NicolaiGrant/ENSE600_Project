package GUI;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import game.Player;

public class PlayerDiscGUI extends JPanel
{
    private final int SIZE = 100;
    
    private Color colour;
    
    public PlayerDiscGUI(Player currentPlayer)
    {
        this.colour = currentPlayer.getColour();
    }
    
    public Color getColour()
    {
        return this.colour;
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        int circleSize = SIZE - 15;
        int circleX = (SIZE - circleSize) / 2;
        int circleY = (SIZE - circleSize) / 2;
        
        g.setColor(this.getColour());
        g.fillOval(circleX, circleY, circleSize, circleSize);
    }
}
