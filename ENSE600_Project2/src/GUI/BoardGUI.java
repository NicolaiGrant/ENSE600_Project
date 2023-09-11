package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.*;

import game.*;
import game.Board;
import packages.Disc;

public class BoardGUI extends JFrame
{
    private static final int ROWS = 6;
    private static final int COLS = 7;
    
    Player player1 = new Player("Player 1", Colours.RED.getColour(), Disc.RED);
    Player player2 = new Player("Player 2", Colours.YELLOW.getColour(), Disc.YELLOW);

    Player currentPlayer = player1; // Initialize the current player
    
    private Board boardLogic;
    
    private static final Color BACKGROUND = new Color(93, 139, 186);
    
    private JPanel board;
    private JPanel boardGrid;
    private BoardSlot[][] boardSlots;
    
    private JPanel leftPanel;
    private JPanel rightPanel;
    
    private int[] colHeight;
    
    private boolean gameRunning;
    
    public BoardGUI()
    {
        setTitle("Connect Four! - Two Player Mode");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setVisible(true);
        getContentPane().setBackground(Colours.BLUE.getColour());
        setResizable(false);
        
        //this.setLayout(new BorderLayout()); // Use BorderLayout for the main layout

        
        
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
        
        this.boardGrid = new JPanel(new GridLayout(ROWS, COLS));
        this.boardSlots = new BoardSlot[ROWS][COLS];
        
        
        this.initialiseBoard();
                
        this.colHeight = new int[COLS];
        
        this.gameRunning = false;
        
        this.boardLogic = new Board();
        
        this.setScreenSize();
                 
        this.printBoard();
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

        //Container container = getContentPane();
        
        //container.setLayout(new BorderLayout());
        
        for(int i = ROWS - 1; i >= 0; i--)
        {
            for(int j = 0; j < COLS; j++)
            {
                this.boardGrid.add(this.boardSlots[i][j]);
            }
        }
        
        //container.add(this.boardGrid, BorderLayout.CENTER);
        
        this.add(this.boardGrid);
        setVisible(true);
    }
    
    public void dropPiece(int col)
    {
        try
        {
            this.getBoardLogic().dropPiece(col, currentPlayer.getDisc());
            
            Color colour = currentPlayer.getColour();
            this.boardSlots[colHeight[col]][col].setCircleColour(colour);
            this.colHeight[col]++; // increment the height of the column
            this.printBoard(); 
            
            this.setTitle(this.currentPlayer.getName() + " Move");
            
            if(this.isConnectFour())
            {
                this.setTitle("Connect Four! " + this.currentPlayer.getName() + " Wins!");
                this.stopGame();
            }
            
            else if(this.isBoardFull())
            {
                this.setTitle("Game Over! Board is Full!");
                this.stopGame();
            }                  
            
            if(this.isGameRunning())
            {
                this.switchPlayers();
            }
            
  
        } catch (ArrayIndexOutOfBoundsException e) {
            // add code to make player retry move
            System.out.println("Try again...");
        }  
    }
    
    private void switchPlayers() 
    {
        // Swaps the current player
        
        if (currentPlayer == player1) 
        {
            currentPlayer = player2;
        } 
        else 
        {
            currentPlayer = player1;
        }
    }
     
    public void setScreenSize()
    {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        //int frameWidth = screenWidth / 2 + 25;
        int frameWidth = screenWidth / 2 + 400;
        int frameHeight = screenHeight / 2 + 290;
        this.setSize(frameWidth, frameHeight);
        this.setLocationRelativeTo(null);
    }
    
    public boolean isConnectFour()
    {
        return this.getBoardLogic().isConnectFour(player1, player2);
    }
    
    public boolean isBoardFull()
    {
        return this.getBoardLogic().isBoardFull();
    }
}