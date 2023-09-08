package GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.*;

public class BoardGUI extends JFrame
{
    private static final int ROWS = 6;
    private static final int COLS = 7;
    
    private static final Color BACKGROUND = new Color(255,255,255);
    
    private JPanel boardPanel;
    private BoardSlot[][] boardSlots;
    
    public BoardGUI()
    {
        setTitle("Connect Four");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        getContentPane().setBackground(BACKGROUND);
        
        this.boardPanel = new JPanel(new GridLayout(ROWS, COLS));
        this.boardSlots = new BoardSlot[ROWS][COLS];
        
        this.setScreenSize();
        
        this.initialiseBoard();

        this.printBoard();
        
    }
    
    public void initialiseBoard()
    {
        for(int i = 0; i < ROWS; i++)
        {
            for(int j = 0; j < COLS; j++)
            {
                this.boardSlots[i][j] = new BoardSlot(j);
            }
        }
    }
    
    public void printBoard()
    {
        //JPanel board = new JPanel(new GridLayout(ROWS, COLS));
        
        Container container = getContentPane();
        
        container.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        
        for(int i = 0; i < ROWS; i++)
        {
            for(int j = 0; j < COLS; j++)
            {
                this.boardPanel.add(this.boardSlots[i][j]);
            }
        }
        container.add(this.boardPanel);
        setVisible(true);
    }
    
//    public void printBoard()
//    {
//        //JPanel board = new JPanel(new GridLayout(ROWS, COLS));
//        
//        Container container = getContentPane();
//        
//        container.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
//        
//        for(int i = 0; i < ROWS; i++)
//        {
//            for(int j = 0; j < COLS; j++)
//            {
//                this.boardPanel.add(new BoardSlot(j));
//            }
//        }
//        container.add(this.boardPanel);
//        setVisible(true);
//    }
    
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
