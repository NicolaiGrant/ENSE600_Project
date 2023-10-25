/*
    Connect 4 - ENSE600 Project 2
    
    Nicolai Grant

    ID: 21145343
*/

package game;

import GUI.Colours;
import GUI.WinDialog;
import java.util.Random;
import packages.Disc;

public class BotGame extends Game
{
    private Random random;
    
    public BotGame()
    {
        super();
        this.random = new Random();
    }

    public void assignPlayers(String player1Name)
    {
        setPlayer1(new Player(player1Name));
        setPlayer2(new Bot());
        
        setCurrentPlayer(getPlayer1());
        
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
    
    @Override
    public void play()
    {
        super.play();
    }
    
    @Override 
    public void dropPiece(int col)
    {
        try
        {
            getBoardLogic().dropPiece(col, getCurrentPlayer().getDisc());
            getBoardGUI().updateBoard(col, getCurrentPlayer().getColour());
            
            checkGameOver();
            
            if(getBoardGUI().isGameRunning())
            {
                changePlayerTurn();

                if(getCurrentPlayer().getName().equals("Bot"))
                {
                    
                    while(true)
                    {
                        col = random.nextInt(7);
                        try
                        {
                            getBoardLogic().dropPiece(col, getCurrentPlayer().getDisc());
                            getBoardGUI().updateBoard(col, getCurrentPlayer().getColour());
                            break;
                            
                        } catch (ArrayIndexOutOfBoundsException e) {
                            // Invalid move.
                        } 
                    }
                    
                    checkGameOver();
                    
                    changePlayerTurn();
                }
                
                getGameGUI().setTitle(getCurrentPlayer().getName() + " Move");    
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            // add code to make player retry move
            System.out.println("Try again...");
        }  
    } 
    
    public void checkGameOver()
    {
        if(isConnectFour())
        {
            getGameGUI().setTitle("Connect Four! " + getCurrentPlayer().getName() + " Wins!");
            new WinDialog(getCurrentPlayer().getName());
            getLeaderboardDB().incrementPlayerScore(getCurrentPlayer().getName());

            getBoardGUI().stopGame();
        }

        else if(isBoardFull())
        {
            getGameGUI().setTitle("Game Over! Board is Full!");
            getBoardGUI().stopGame();
        }
    }
}
