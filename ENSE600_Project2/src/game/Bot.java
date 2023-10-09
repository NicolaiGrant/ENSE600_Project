package game;

import GUI.Colours;
import java.awt.Color;
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