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
    
    private int[] colHeight;
    
    public BoardGUI()
    {
        setTitle("Connect Four");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        getContentPane().setBackground(BACKGROUND);
        
        this.boardPanel = new JPanel(new GridLayout(ROWS, COLS));
        this.boardSlots = new BoardSlot[ROWS][COLS];
        
        this.colHeight = new int[COLS];
        
        this.setScreenSize();
        
        this.initialiseBoard();

        this.printBoard();
    }
    
    public int[] getColHeight()
    {
        return this.colHeight;
    }
    
    public void initialiseBoard()
    {
        for(int row = 0; row < ROWS; row++)
        {
            for(int col = 0; col < COLS; col++)
            {
                this.boardSlots[row][col] = new BoardSlot(this, col);
            }
        }
    }
    
    public void printBoard()
    {
        // JPanel board = new JPanel(new GridLayout(ROWS, COLS));
        
        Container container = getContentPane();
        
        container.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        
        for(int i = ROWS - 1; i >= 0; i--)
        {
            for(int j = 0; j < COLS; j++)
            {
                this.boardPanel.add(this.boardSlots[i][j]);
            }
  
        }
        container.add(this.boardPanel);
        setVisible(true);
    }
    
    public void dropPiece(int col)
    {
        Color colour = Colours.YELLOW.getColour();
        this.boardSlots[colHeight[col]][col].setCircleColour(colour);
        this.colHeight[col]++; // increment the height of the column
        this.printBoard();
    }
    
    public boolean isRowFull(int col)
    {
        // Checks colHeight array at index x and returns true if it is full
        
        if(this.getColHeight()[col] < this.ROWS)
        {
            return false;
        }
        return true;
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
