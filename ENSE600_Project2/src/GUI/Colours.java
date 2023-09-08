/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;

public enum Colours
{
    
    YELLOW(new Color(255, 242, 117));
    
    private final Color colour;
    
    private Colours(Color colour)
    {
        this.colour = colour;
    }
    
    public Color getColour()
    {
        return this.colour;
    }
}
