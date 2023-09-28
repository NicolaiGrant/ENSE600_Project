package game;

import GUI.Colours;
import java.awt.Color;
import java.util.Random;
import packages.Disc;

public class Player
{
    protected String name;
    protected Color colour;
    protected Disc disc;
    protected boolean isTurn;
    
    public Player(String name)
    {
        this.name = name;
        this.colour = this.assignColour();
        this.isTurn = false;
    }
    
//    public Player(String name, Color colour)
//    {
//        this.name = name;
//        this.colour = colour;
//        this.isTurn = false;
//    }
//    
//    public Player(String name, Color colour, Disc disc)
//    {
//        this.name = name;
//        this.colour = colour;
//        this.disc = disc;
//        this.isTurn = false;
//    }
    
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Color getColour()
    {
        return colour;
    }

    public void setColour(Color colour)
    {
        this.colour = colour;
    }
    
    public Disc getDisc()
    {
        return this.disc;
    }
    
    public void setDisc(Disc disc)
    {
        this.disc = disc;
    }
    
    public boolean isTurn()
    {
        return this.isTurn;
    }
    
    public void startTurn()
    {
        this.isTurn = true;
    }
    
    public void stopTurn()
    {
        this.isTurn = false;
    }
    
    public Disc randomDisc()
    {
        // Returns a yellow or red disc at random
        
        Random random = new Random();
        
        int num = random.nextInt(2);
        
        if(num == 1)
        {
            return Disc.RED;
        }
        return Disc.YELLOW;     
    }

    private Color assignColour() 
    {
        Random random = new Random();
        int num = random.nextInt(2);
        
        if(num == 1)
        {
            this.disc = Disc.RED;
            return Colours.RED.getColour();
        }
        else
        {
            this.disc = Disc.YELLOW;
            return Colours.YELLOW.getColour();
        }
    }
}
