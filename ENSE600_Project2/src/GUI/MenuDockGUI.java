/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import GUI.Colours;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class MenuDockGUI extends JPanel
{
    private static final Color BACKGROUND = new Color(93, 139, 186);
    
    public MenuDockGUI(GameGUI board)
    {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(300, 200));
        setBackground(BACKGROUND);
        setVisible(true);
        
        add(new ReplayButton(board));
    }
    
    @Override
    public void paintComponent(Graphics g) {
        // Paints the button to be a blue square with a circle in the middle

        int width = getWidth();  // Get the width of the component
        int height = getHeight(); // Get the height of the component

        int arcWidth = 50; // Adjust the arc width for the rounded edges

        g.setColor(Colours.BLUE.getColour());
        g.fillRoundRect(0, 0, 300, 60, arcWidth, arcWidth); // Fill the rounded rectangle

    }
      
}
