/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author nicolaigrant
 */
public class Spacer extends JPanel
{
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
