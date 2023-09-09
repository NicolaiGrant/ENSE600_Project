package game;

import java.awt.Color;
import java.util.Random;
import packages.Disc;

public class Player
{
    protected String name;
    protected Color colour;
    protected Disc disc;
    
    public Player(String name, Color colour)
    {
        this.name = name;
        this.colour = colour;
    }
    
    public Player(String name, Color colour, Disc disc)
    {
        this.name = name;
        this.colour = colour;
        this.disc = disc;
    }
    
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
}
