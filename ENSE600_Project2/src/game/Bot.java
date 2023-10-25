/*
    Connect 4 - ENSE600 Project 2
    
    Nicolai Grant

    ID: 21145343
*/

package game;

import java.util.Random;

public class Bot extends Player
{
    Random random;
    
    public Bot()
    {
        super("Bot");
        this.random = new Random();
    }

    public void move(Board board)
    {
        // Places the piece in a random column
        
        int x = random.nextInt(7) + 1;
        if(!board.isRowFull(x))
        {
            board.dropPiece(x, disc);
            //this.currentPlayer++;
        }
    }
}