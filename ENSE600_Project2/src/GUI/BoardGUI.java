package GUI;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;

public class BoardGUI extends JFrame
{
    private static final int ROWS = 6;
    private static final int COLS = 7;
    
    private JPanel boardPanel;
    private JButton[] boardSlots;
    
    public BoardGUI()
    {
        setTitle("Connect Four");
        
        Toolkit kit=Toolkit.getDefaultToolkit();
        Dimension screenSize=kit.getScreenSize();
        int screenWidth=screenSize.width;
        int screenHeight=screenSize.height;
        int frameWidth=screenWidth / 2;
        int frameHeight=screenHeight / 2;
        this.setSize(frameWidth, frameHeight);
        this.setLocationRelativeTo(null);
    }
    
    public static void main(String[] args) 
    {
        BoardGUI board = new BoardGUI();
        board.setVisible(true);
    }
}
