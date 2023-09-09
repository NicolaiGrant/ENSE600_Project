/*
    Connect 4 - ENSE600 Project 1
    
    Nicolai Grant

    ID: 21145343
*/

package packages;

import java.util.Random;
import GUI.Colours;

public class Bot extends Player
{
    Random random;
    String name;
    
    public Bot(Disc disc, Colours colour)
    {
        super(disc, colour);
        this.random = new Random();
        this.name = "Bot";
    }
    
    public Bot()
    {
        super();
        this.random = new Random();
        this.name = "Bot";
    }
        
    @Override
    public String getName()
    {
        return this.name;
    }
     

    @Override
    public void move(Board board)
    {
        // Places the piece in a random column
        
        int x = random.nextInt(7) + 1;
        if(!board.isRowFull(x))
        {
            board.dropPiece(x, disc);
            this.currentPlayer++;
        }
    }
}
