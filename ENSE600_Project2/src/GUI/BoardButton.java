package GUI;

import game.Game;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BoardButton extends JButton
{
    private static final int SIZE = 100;

    public Color circleColour = Colours.EMPTY.getColour();
    
    private int column;
    
    private Game game;
    
    public BoardButton(Game game, int column)
    {
        setPreferredSize(new Dimension(SIZE, SIZE));
        setBorderPainted(true);
        setBorder(null);
        setContentAreaFilled(false);
        setFocusable(false);
        
        this.game = game;
        
        this.column = column;
        
        this.mouseHover();
        this.mouseClick();
        this.getColumn();
    }
    
    public Color getCircleColour()
    {
        return this.circleColour;
    }
    
    public void setCircleColour(Color colour) 
    {
        this.circleColour = colour;
        repaint();
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
                if(game.getBoardGUI().isGameRunning())
                {
                    
                    setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                    //setBorder(BorderFactory.createLineBorder(game.getCurrentPlayer().getColour(), 1));
                } 
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
        // If any of the slot buttons are pressed, execute the drop piece method
        
        addMouseListener(new MouseAdapter() 
        {                
            @Override
            public void mousePressed(MouseEvent e) 
            {
                if(game.getBoardGUI().isGameRunning())
                {           
                    //game.getBoardGUI().dropPiece(column);
                    game.dropPiece(column);
                }
            }
        });             
    }
        
    @Override
    public void paintComponent(Graphics g)
    {
        // Paints the button to be a blue square with a circle in the middle
        
        g.setColor(Colours.BLUE.getColour());
        g.fillRect(0,0,SIZE,SIZE);
        
        int circleSize = SIZE - 15;
        int circleX = (SIZE - circleSize) / 2;
        int circleY = (SIZE - circleSize) / 2;
        
        g.setColor(this.getCircleColour());
        g.fillOval(circleX, circleY, circleSize, circleSize);
    }
}