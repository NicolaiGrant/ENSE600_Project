package GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.*;

import game.*;
import packages.Board;
import packages.Disc;

public class BoardGUI extends JFrame
{
    private static final int ROWS = 6;
    private static final int COLS = 7;
    
    Player player1 = new Player("Player 1", Colours.RED.getColour(), Disc.RED);
    Player player2 = new Player("Player 2", Colours.YELLOW.getColour(), Disc.YELLOW);

    Player currentPlayer = player1; // Initialize the current player
    
    private Board boardLogic;
    
    private static final Color BACKGROUND = new Color(255,255,255);
    
    private JPanel boardPanel;
    private BoardSlot[][] boardSlots;
    
    private int[] colHeight;
    
    private boolean gameRunning;
    
    public BoardGUI()
    {
        setTitle("Connect Four");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        getContentPane().setBackground(BACKGROUND);
        
        this.boardPanel = new JPanel(new GridLayout(ROWS, COLS));
        this.boardSlots = new BoardSlot[ROWS][COLS];
        
        this.colHeight = new int[COLS];
        
        this.gameRunning = false;
        
        this.boardLogic = new Board();
        
        this.setScreenSize();
        
        this.initialiseBoard();
        this.printBoard();
        
        
        
        //this.currentPlayer = 
    }
    
    public void startGame()
    {
        this.gameRunning = true;
    }
    
    public void stopGame()
    {
        this.gameRunning = false;
    }
    
    public boolean isGameRunning()
    {
        return this.gameRunning;
    }
    
    public Player getCurrentPlayer()
    {
        return this.currentPlayer;
    }
    
    public int[] getColHeight()
    {
        return this.colHeight;
    }
    
    public Board getBoardLogic()
    {
        return this.boardLogic;
    }
    
    public void initialiseBoard()
    {
        // Initialises the board with empty board slot objects in a 6x7 array
        
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
        // Print the board slots in a 6x7 grid
        
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
            System.out.println("Current Player: " + currentPlayer.getName());
            this.getBoardLogic().dropPiece(col, currentPlayer.getDisc());
            
            Color colour = currentPlayer.getColour();
            this.boardSlots[colHeight[col]][col].setCircleColour(colour);
            this.colHeight[col]++; // increment the height of the column
            this.printBoard(); 
            
            this.switchPlayers();
            
            
            if(this.isBoardFull())
            {
                this.stopGame();
            }
            
            
            
        } catch (ArrayIndexOutOfBoundsException e) {
            // add code to make player retry move
            System.out.println("Try again...");
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
    
    public boolean isColFull(int col)
    {
        // Checks colHeight array at index x and returns true if it is full
        
        if(this.getColHeight()[col] < this.COLS - 1)
        {
            return false;
        }
        return true;
    }
    
    public boolean isBoardFull()
    {
        // Returns true if the board is full 

        for(int i = 0; i < COLS; i++)
        {
            if(!isColFull(i))
            {
                return false;
            }
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
}
