/*
    Connect 4 - ENSE600 Project 1
    
    Nicolai Grant

    ID: 21145343
*/

package packages;

import game.Board;
import java.util.Random;
import GUI.Colours;
import java.awt.Color;

public abstract class Player
{
    protected Disc disc;
    protected Colours colour;
    protected int score;
    protected static int currentPlayer = 0;
    
    protected UserInput userInput;
    
    public Player(Disc disc, Colours colour)
    {
        this.disc = disc;
        this.score = 0;
        this.userInput = new UserInput();
    }
    
    public Player()
    {
        this.disc = this.randomDisc();
        this.colour = this.randomColour();
        this.score = 0;
    }
    
    public int getCurrentPlayer()
    {
        // Returns an integer representing the current player
        
        return this.currentPlayer;
    }
    
    public static Player getCurrentPlayer(Player player1, Player player2)
    {
        // Returns the player whos turn it is next
        
        Player currentPlayer = player1;
        
        if(Player.currentPlayer % 2 == 0)
        {
            currentPlayer = player1;
        }
        else
        {
            currentPlayer = player2;
        } 
        
        return currentPlayer;
    }
    
    public Disc randomDisc()
    {
        // Returns a yellow or red disc at random
        
        Random random = new Random();
        
        int num = random.nextInt(2);
        
        if(num == 1)
        {
            return Disc.RED;
        }
        return Disc.YELLOW;     
    }
    
    public Colours randomColour()
    {
        // Returns a yellow or red disc at random
        
        Random random = new Random();
        
        int num = random.nextInt(2);
        
        if(num == 1)
        {
            return Colours.RED;
        }
        
        return Colours.YELLOW;
    }
    
    public int getScore()
    {
        // Returns the current player score
        
        return this.score;
    }
    
    public Color getColour()
    {
        return this.colour.getColour();
    }

    public void incrementScore()
    {
        // Increases the player score by 1
        
        this.score++;
    }
    
    public void resetScore()
    {
        // Resets the player score to 0
        
        this.score = 0;
    }
        
    public abstract String getName();
    
    public abstract void move(Board board);
}
