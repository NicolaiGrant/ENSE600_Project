package GUI;

import GUI.Colours;
import game.Player;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import packages.Disc;

public class BoardGridGUI extends JPanel
{
    private static final int ROWS = 6;
    private static final int COLS = 7;
    
    private Player player1 = new Player("Player 1", Colours.RED.getColour(), Disc.RED);
    private Player player2 = new Player("Player 2", Colours.YELLOW.getColour(), Disc.YELLOW);
    
    private int[] colHeight;
    
    private Player currentPlayer;
    
    private boolean gameRunning;
    
    private BoardButton[][] boardSlots;
    
    private Board boardLogic;
    
    private JFrame frame;
    
    
    public BoardGridGUI(JFrame frame)
    {
        this.frame = frame;
        
        setLayout(new GridLayout(ROWS, COLS, 0, 0));
        setPreferredSize(new Dimension(700, 600));
                
        JPanel blackBackground = new JPanel();
        blackBackground.setBackground(Color.BLACK); // Set the background color to black
        blackBackground.setLayout(new BorderLayout()); // Use BorderLayout to center your board

        // Add your BoardGridGUI to the black background panel
        blackBackground.add(this, BorderLayout.CENTER);
        frame.add(blackBackground);
        
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

        frame.setTitle("Connect Four! - Two Player Mode");

        revalidate();
        repaint();
    }

        
    public void initialiseBoard()
    {
        // Initialises the board with empty board slot objects in a 6x7 array
        this.boardLogic = new Board();
        this.boardSlots = new BoardButton[ROWS][COLS];
        this.colHeight = new int[COLS];
        
        this.gameRunning = true;
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
        for(int i = ROWS - 1; i >= 0; i--)
        {
            for(int j = 0; j < COLS; j++)
            {
                this.add(this.boardSlots[i][j]);
            }
        }
        
        setVisible(true);
    }
    
//    public void dropPiece(int col)
//    {
//        System.out.println(col);
//    }
    
    public void dropPiece(int col)
    {
        try
        {
            this.getBoardLogic().dropPiece(col, currentPlayer.getDisc());
            
            Color colour = currentPlayer.getColour();
            this.boardSlots[colHeight[col]][col].setCircleColour(colour);
            this.colHeight[col]++; // increment the height of the column
            this.printBoard(); 
            
            frame.setTitle(this.currentPlayer.getName() + " Move");
            
            if(this.isConnectFour())
            {
                frame.setTitle("Connect Four! " + this.currentPlayer.getName() + " Wins!");
                this.stopGame();
            }
            
            else if(this.isBoardFull())
            {
                frame.setTitle("Game Over! Board is Full!");
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
