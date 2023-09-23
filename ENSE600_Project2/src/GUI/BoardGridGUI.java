package GUI;

import game.Board;
import game.Player;
import java.awt.*;
import javax.swing.*;
import packages.Disc;

public class BoardGridGUI extends JPanel
{
    private static final int ROWS = 6;
    private static final int COLS = 7;

    private Player player1;
    private Player player2;
            
    private int[] colHeight;
    
    private Player currentPlayer;
    
    private boolean gameRunning;
    
    private BoardButton[][] boardSlots;
    
    private Board boardLogic;

    private GameGUI game;
    
    
    public BoardGridGUI(GameGUI game)
    {
        this.game = game;
        
        setLayout(new GridLayout(ROWS, COLS, 0, 0));
        setPreferredSize(new Dimension(700, 600));
        
        this.player1 = new Player(game.getPlayer1().getName(), Colours.RED.getColour(), Disc.RED);
        this.player2 = new Player(game.getPlayer2().getName(), Colours.YELLOW.getColour(), Disc.YELLOW);
        
        initialiseBoard();
        
        printBoard();
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
    
    public Board getBoardLogic()
    {
        return this.boardLogic;
    }
    
    public void resetBoard() 
    {
        removeAll();
        initialiseBoard();
        
        printBoard();

        this.gameRunning = true;
        this.currentPlayer = this.player1;

        game.setTitle("Connect Four! - Two Player Mode");

        revalidate();
        repaint();
    }

        
    public void initialiseBoard()
    {
        // Initialises the board with empty board slot objects in a 6x7 array
        
        this.boardLogic = new Board();
        this.boardSlots = new BoardButton[ROWS][COLS];
        this.colHeight = new int[COLS];
        
        this.gameRunning = false;
        this.currentPlayer = this.player1;
        
        for(int row = 0; row < ROWS; row++)
        {
            for(int col = 0; col < COLS; col++)
            {
                this.boardSlots[row][col] = new BoardButton(this, col);
            }
        }
    }
    
    public void printBoard()
    {
        // Adds the board buttons to the JPanel in the 6x7 grid
        
        for(int i = ROWS - 1; i >= 0; i--)
        {
            for(int j = 0; j < COLS; j++)
            {
                this.add(this.boardSlots[i][j]);
            }
        }
        
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
            
            game.setTitle(this.currentPlayer.getName() + " Move");
            
            if(this.isConnectFour())
            {
                game.setTitle("Connect Four! " + this.currentPlayer.getName() + " Wins!");
                this.stopGame();
            }
            
            else if(this.isBoardFull())
            {
                game.setTitle("Game Over! Board is Full!");
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
    
    public boolean isConnectFour()
    {
        return this.getBoardLogic().isConnectFour(player1, player2);
    }
    
    public boolean isBoardFull()
    {
        return this.getBoardLogic().isBoardFull();
    }
}
