package GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.*;

import game.*;

public class BoardGUI extends JFrame
{
    private static final int ROWS = 6;
    private static final int COLS = 7;
    
    Player player1 = new Player("Player 1", Colours.RED.getColour());
    Player player2 = new Player("Player 2", Colours.YELLOW.getColour());

    Player currentPlayer = player1; // Initialize the current player
    
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
        
        //this.currentPlayer = 
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
    
    public void setCurrentPlayer(Player currentPlayer)
    {
        this.currentPlayer = currentPlayer;
    }
    
    public void printBoard()
    {
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
        try
        {
            //Color colour = Colours.RED.getColour();
            
            Color colour = currentPlayer.getColour();
            this.boardSlots[colHeight[col]][col].setCircleColour(colour);
            this.colHeight[col]++; // increment the height of the column
            this.printBoard(); 
            
            this.switchPlayers();
            
        } catch (ArrayIndexOutOfBoundsException e) {
            // add code to make player retry move
            System.out.println("Column Full");
        }  
    }
    
    private void switchPlayers() 
    {
        if (currentPlayer == player1) 
        {
            currentPlayer = player2;
        } 
        else 
        {
            currentPlayer = player1;
        }
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
