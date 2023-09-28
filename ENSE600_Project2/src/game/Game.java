package game;

import Database.LeaderboardDB;
import GUI.BoardGridGUI;
import GUI.Colours;
import GUI.GameGUI;
import GUI.WinDialog;
import java.awt.Color;
import packages.Disc;

public class Game
{
    private GameGUI gameGUI;
    private Board boardLogic;
    private BoardGridGUI boardGUI;
    private LeaderboardDB leaderboardDB;
    
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    
    private boolean gameRunning;

    public Game()
    {
        this.leaderboardDB = new LeaderboardDB();
    }
    
    public void assignPlayers(String player1Name, String player2Name)
    {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
        
        this.currentPlayer = getPlayer1();
        
        if(getPlayer1().getColour() == Colours.RED.getColour())
        {
            getPlayer2().setDisc(Disc.YELLOW);
            getPlayer2().setColour(Colours.YELLOW.getColour());
        }
        else
        {
            getPlayer2().setDisc(Disc.RED);
            getPlayer2().setColour(Colours.RED.getColour());
        }
    }
    
    public Player getPlayer1()
    {
        return this.player1;
    }
    
    public Player getPlayer2()
    {
        return this.player2;
    }
    
    public Board getBoardLogic()
    {
        return this.boardLogic;
    }
    
    public void setBoardLogic(Board boardLogic)
    {
        this.boardLogic = boardLogic;
    }
    
    public GameGUI getGameGUI()
    {
        return this.gameGUI;
    }
    
    public void setGameGUI(GameGUI gameGUI)
    {
        this.gameGUI = gameGUI;
    }
    
    public BoardGridGUI getBoardGUI()
    {
        return this.boardGUI;
    }
    
    public void setBoardGUI(BoardGridGUI boardGUI)
    {
        this.boardGUI = boardGUI;
    }

    public void play()
    {
        this.gameGUI = new GameGUI(this);
        this.gameGUI.getBoard().startGame();
        this.gameRunning = true;
    }
    
    public void exit()
    {
        this.leaderboardDB.closeConnection();
    }

    public void dropPiece(int col)
    {
        try
        {
            getBoardLogic().dropPiece(col, currentPlayer.getDisc());

            getBoardGUI().updateBoard(col, currentPlayer.getColour());
            
            // add ability for player panel to display "Your tunr" if it is their turn
//            game.getPlayer1Panel().revalidate();
//            game.getPlayer1Panel().repaint();
//            
//            game.getPlayer2Panel().revalidate();
//            game.getPlayer2Panel().repaint();
            
            getGameGUI().setTitle(this.currentPlayer.getName() + " Move");
            
            if(getBoardGUI().isConnectFour())
            {
                getGameGUI().setTitle("Connect Four! " + this.currentPlayer.getName() + " Wins!");
                new WinDialog(this.currentPlayer.getName());
                getBoardGUI().stopGame();
            }
            
            else if(getBoardGUI().isBoardFull())
            {
                getGameGUI().setTitle("Game Over! Board is Full!");
                getBoardGUI().stopGame();
            }                  
            
            if(getBoardGUI().isGameRunning())
            {
                switchPlayers();
            }
            
  
        } catch (ArrayIndexOutOfBoundsException e) {
            // add code to make player retry move
            System.out.println("Try again...");
        }  
    }
    
    public void switchPlayers() 
    {
        // Swaps the current player
        
        Player prevPlayer = getPlayer1();
        
        if (currentPlayer == getPlayer1()) 
        {
            currentPlayer = getPlayer2();
        } 
        else 
        {
            currentPlayer = getPlayer1();
            prevPlayer = getPlayer2();
        }
        
        currentPlayer.startTurn();
        prevPlayer.stopTurn();
    }
}
