/*
    Connect 4 - ENSE600 Project 2
    
    Nicolai Grant

    ID: 21145343
*/

package GUI.Buttons;

import game.Game;
import java.awt.*;
import javax.swing.*;

public abstract class MenuButton extends JButton
{
    protected int buttonSize;
    
    private Game game;
    
    public MenuButton(Game game, int buttonSize)
    {
        this.game = game;
        this.buttonSize = buttonSize;
        setBorderPainted(false);
        setFocusPainted(false);
        setBorder(null);
        setPreferredSize(new Dimension(this.buttonSize, this.buttonSize));      
    }
}