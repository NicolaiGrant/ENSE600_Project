package GUI.Buttons;

import GUI.GameGUI;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public abstract class MenuButton extends JButton
{
    protected int buttonSize;
    
    private GameGUI board;
    
    public MenuButton(GameGUI board, int buttonSize)
    {
        this.board = board;
        this.buttonSize = buttonSize;
        setPreferredSize(new Dimension(this.buttonSize, this.buttonSize));      
    }

}