package GUI.MainMenu;

import GUI.MainMenu.*;
import java.awt.*;
import javax.swing.*;

public abstract class MenuButton extends JButton
{
    protected MainMenu menu;
    protected int buttonSize;

    public MenuButton(MainMenu menu, int buttonSize)
    {
        this.menu = menu;
        this.buttonSize = buttonSize;
        setPreferredSize(new Dimension(this.buttonSize, this.buttonSize));      
    }

}