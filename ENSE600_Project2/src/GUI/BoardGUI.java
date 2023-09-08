package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        this.setScreenSize();
        
        
        //this.add(new BoardSlot());

        this.printBoard();
        
        
        
    }
    

    
    public void printBoard()
    {
        JPanel board = new JPanel(new GridLayout(ROWS, COLS));
        
        Container container = getContentPane();
        
        container.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        
        for(int i = 0; i < ROWS; i++)
        {
            for(int j = 0; j < COLS; j++)
            {
                board.add(new BoardSlot());
            }
        }
        container.add(board);
        
        setVisible(true);
    }
    
    public void setScreenSize()
    {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        int frameWidth = screenWidth / 2 + 200;
        int frameHeight = screenHeight / 2 + 200;
        this.setSize(frameWidth, frameHeight);
        this.setLocationRelativeTo(null);
    }
    
    public static void main(String[] args) 
    {
        BoardGUI board = new BoardGUI();
        //board.setVisible(true);
        //board.add(new BoardSlot());
    }
}
