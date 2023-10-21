package GUI;

import java.awt.Color;

public enum Colours
{
    YELLOW(new Color(255, 242, 117)),
    RED(new Color(255, 60, 56)),
    BLUE(new Color(102, 153, 204)),
    EMPTY(new Color(255,255,255));
    

    final Color colour;
    
    private Colours(Color colour)
    {
        this.colour = colour;
    }
    
    public Color getColour()
    {
        return this.colour;
    }
}
