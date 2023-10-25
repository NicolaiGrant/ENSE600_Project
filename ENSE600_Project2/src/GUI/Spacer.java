/*
    Connect 4 - ENSE600 Project 2
    
    Nicolai Grant

    ID: 21145343
*/

package GUI;

import java.awt.*;
import javax.swing.*;

public class Spacer extends JPanel
{
    // Custom JPanel object used to create a custom spacer to add custom gaps
    // between other Jobjects
    
    private int width;
    private int height;
    
    private static final Color BACKGROUND = new Color(93, 139, 186);
    
    public Spacer(int width, int height)
    {
        this.setLayout(new GridLayout());
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(BACKGROUND);
        this.setVisible(true);
    }
}
