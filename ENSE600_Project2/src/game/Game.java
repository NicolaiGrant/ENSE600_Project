package game;

import Database.LeaderboardDB;
import GUI.BoardGridGUI;
import GUI.Colours;
import GUI.GameGUI;
import GUI.Leaderboard.LeaderboardGUI;
import GUI.WinDialog;
import java.awt.Color;
import packages.Disc;

public class Game
{
    private GameGUI gameGUI;
    private Board boardLogic;
    private BoardGridGUI boardGUI;
    private LeaderboardDB leaderboardDB;
    private LeaderboardGUI leaderboardGUI;
    
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    
    private boolean gameRunning;
    
    public static final Color BACKGROUND = new Color(93, 139, 186);

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
    
    public void switchPlayers()
    {
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
    
    public boolean isConnectFour()
    {
        return getBoardLogic().isConnectFour(player1, player2);
    }
    
    public boolean isBoardFull()
    {
        return getBoardLogic().isBoardFull();
    }
    
    public Player getPlayer1()
    {
        return this.player1;
    }
    
    public void setPlayer1(Player player1)
    {
        this.player1 = player1;
    }
    
    public Player getPlayer2()
    {
        return this.player2;
    }
    
    public void setPlayer2(Player player2)
    {
        this.player2 = player2;
    }
    
    
    public Player getCurrentPlayer()
    {
        return this.currentPlayer;
    }
    
    public void setCurrentPlayer(Player currentPlayer)
    {
        this.currentPlayer = currentPlayer;
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
    
    public LeaderboardDB getLeaderboardDB()
    {
        return this.leaderboardDB;
    }
    
    public LeaderboardGUI getLeaderboardGUI()
    {
        return this.leaderboardGUI;
    }

    public void play()
    {
        gameGUI = new GameGUI(this);
        gameGUI.getBoard().startGame();
        gameRunning = true;
    }
    
    public void exit()
    {
        this.leaderboardDB.closeConnection();
        System.exit(0);
    }

    public void dropPiece(int col)
    {
        try
        {
            getBoardLogic().dropPiece(col, currentPlayer.getDisc());

            getBoardGUI().updateBoard(col, currentPlayer.getColour());
            
            if(isConnectFour())
            {
                getGameGUI().setTitle("Connect Four! " + this.currentPlayer.getName() + " Wins!");
                new WinDialog(this.currentPlayer.getName());
                getLeaderboardDB().incrementPlayerScore(currentPlayer.getName());
                
                getBoardGUI().stopGame();
            }
            
            else if(isBoardFull())
            {
                getGameGUI().setTitle("Game Over! Board is Full!");
                getBoardGUI().stopGame();
            }                  
            
            if(getBoardGUI().isGameRunning())
            {
                changePlayerTurn();
                getGameGUI().setTitle(this.currentPlayer.getName() + " Move");
            }
            
  
        } catch (ArrayIndexOutOfBoundsException e) {
            // add code to make player retry move
            System.out.println("Try again...");
        }  
    }
    
    public void changePlayerTurn() 
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
