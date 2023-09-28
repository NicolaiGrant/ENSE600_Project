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
    
    private Player currentPlayer;
    
    private boolean gameRunning;
    
    
    
    //private Board boardLogic;

    //private GameGUI game;
    
    
//    public BoardGridGUI(GameGUI game)
//    {
//        this.game = game;
//        
//        setLayout(new GridLayout(ROWS, COLS, 0, 0));
//        setPreferredSize(new Dimension(700, 600));
//        
//        this.player1 = new Player(game.getPlayer1().getName(), Colours.RED.getColour(), Disc.RED);
//        this.player2 = new Player(game.getPlayer2().getName(), Colours.YELLOW.getColour(), Disc.YELLOW);
//        
//        initialiseBoard();
//        
//        printBoard();
//    }
    
    public BoardGridGUI(Game game)
    {
        this.game = game;
        
        setLayout(new GridLayout(ROWS, COLS, 0, 0));
        setPreferredSize(new Dimension(700, 600));
        
        //this.player1 = new Player(game.getPlayer1().getName(), Colours.RED.getColour(), Disc.RED);
        //this.player2 = new Player(game.getPlayer2().getName(), Colours.YELLOW.getColour(), Disc.YELLOW);
        
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
        this.currentPlayer = this.player1; // change this so its random
        this.currentPlayer.startTurn();

        game.getGameGUI().setTitle("Connect Four! - Two Player Mode");

        revalidate();
        repaint();
    }

        
    public void initialiseBoard()
    {
        // Initialises the board with empty board slot objects in a 6x7 array
        
        //this.boardLogic = new Board();
        game.setBoardLogic(new Board());
        this.setBoardSlots(new BoardButton[ROWS][COLS]);
        this.setColHeight(new int[COLS]);
        
        this.gameRunning = false;
        this.currentPlayer = this.player1;
        
        for(int row = 0; row < ROWS; row++)
        {
            for(int col = 0; col < COLS; col++)
            {
                this.getBoardSlots()[row][col] = new BoardButton(getGame(), col);
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
    
//    public void dropPiece(int col)
//    {
//        try
//        {
//            game.getBoardLogic().dropPiece(col, currentPlayer.getDisc());
//            //this.getBoardLogic().dropPiece(col, currentPlayer.getDisc());
//            //this.getBoardLogic().dropPiece(col, currentPlayer.getColour());
//
//            Color colour = currentPlayer.getColour();
//            this.boardSlots[colHeight[col]][col].setCircleColour(colour);
//            this.colHeight[col]++; // increment the height of the column
//            //this.printBoard(); 
//            
//            // add ability for player panel to display "Your tunr" if it is their turn
////            game.getPlayer1Panel().revalidate();
////            game.getPlayer1Panel().repaint();
////            
////            game.getPlayer2Panel().revalidate();
////            game.getPlayer2Panel().repaint();
//            
//            game.getGameGUI().setTitle(this.currentPlayer.getName() + " Move");
//            
//            if(this.isConnectFour())
//            {
//                game.getGameGUI().setTitle("Connect Four! " + this.currentPlayer.getName() + " Wins!");
//                new WinDialog(this.currentPlayer.getName());
//                this.stopGame();
//            }
//            
//            else if(this.isBoardFull())
//            {
//                game.getGameGUI().setTitle("Game Over! Board is Full!");
//                this.stopGame();
//            }                  
//            
//            if(this.isGameRunning())
//            {
//                this.switchPlayers();
//            }
//            
//  
//        } catch (ArrayIndexOutOfBoundsException e) {
//            // add code to make player retry move
//            System.out.println("Try again...");
//        }  
//    }
        
//    public void switchPlayers() 
//    {
//        // Swaps the current player
//        
//        Player prevPlayer = player1;
//        
//        if (currentPlayer == player1) 
//        {
//            currentPlayer = player2;
//        } 
//        else 
//        {
//            currentPlayer = player1;
//            prevPlayer = player2;
//        }
//        
//        currentPlayer.startTurn();
//        prevPlayer.stopTurn();
//    }
    
    public boolean isConnectFour()
    {
        return game.getBoardLogic().isConnectFour(player1, player2);
    }
    
    public boolean isBoardFull()
    {
        return game.getBoardLogic().isBoardFull();
    }
}
