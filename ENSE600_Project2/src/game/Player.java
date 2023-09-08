package game;

import java.awt.Color;

public class Player
{
    protected String name;
    protected Color colour;
    
    public Player(String name, Color colour)
    {
        this.name = name;
        this.colour = colour;
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
    
}
