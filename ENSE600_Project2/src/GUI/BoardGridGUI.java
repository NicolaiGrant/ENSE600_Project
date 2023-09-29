package GUI;

import game.Board;
import game.Game;
import game.Player;
import java.awt.*;
import javax.swing.*;
import packages.Disc;

public class BoardGridGUI extends JPanel
{
    private static final int ROWS = 6;
    private static final int COLS = 7;
    
    private Game game;

    private Player player1;
    private Player player2;
    
    BoardButton[][] boardSlots;
    int[] colHeight;
    
//    private Player currentPlayer;
    
    private boolean gameRunning;
    

    public BoardGridGUI(Game game)
    {
        this.game = game;
        
        setLayout(new GridLayout(ROWS, COLS, 0, 0));
        setPreferredSize(new Dimension(700, 600));

        this.player1 = game.getPlayer1();
        this.player2 = game.getPlayer2();
        
        initialiseBoard();
        
        printBoard();
    }
    
    public Game getGame()
    {
        return this.game;
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
    
//    public Board getBoardLogic()
//    {
//        return this.boardLogic;
//    }
    
    public void resetBoard() 
    {
        removeAll();
        initialiseBoard();
        
        printBoard();

        this.gameRunning = true;
        //this.currentPlayer = this.player1; // change this so its random
        //this.currentPlayer.startTurn();

        game.getGameGUI().setTitle("Connect Four! - Two Player Mode");

        revalidate();
        repaint();
    }

        
    public void initialiseBoard()
    {
        // Initialises the board with empty board slot objects in a 6x7 array
        
        //this.boardLogic = new Board();
        game.setBoardLogic(new Board());
        setBoardSlots(new BoardButton[ROWS][COLS]);
        setColHeight(new int[COLS]);
        
        this.gameRunning = false;
        game.setCurrentPlayer(game.getPlayer1());
        
        for(int row = 0; row < ROWS; row++)
        {
            for(int col = 0; col < COLS; col++)
            {
                getBoardSlots()[row][col] = new BoardButton(getGame(), col);
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
                this.add(this.getBoardSlots()[i][j]);
            }
        }
        
        setVisible(true);
    }
    
    public void updateBoard(int col, Color colour)
    {
        getBoardSlots()[getColHeight()[col]][col].setCircleColour(colour);
        getColHeight()[col]++; // increment the height of the column
    }
    
    public BoardButton[][] getBoardSlots() 
    {
        return boardSlots;
    }

    public void setBoardSlots(BoardButton[][] boardSlots) 
    {
        this.boardSlots = boardSlots;
    }

    public int[] getColHeight() 
    {
        return colHeight;
    }

    public void setColHeight(int[] colHeight) 
    {
        this.colHeight = colHeight;
    }
    
    public boolean isConnectFour()
    {
        return game.getBoardLogic().isConnectFour(player1, player2);
    }
    
    public boolean isBoardFull()
    {
        return game.getBoardLogic().isBoardFull();
    }
}
