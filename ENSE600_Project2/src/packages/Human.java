/*
    Connect 4 - ENSE600 Project 1
    
    Nicolai Grant

    ID: 21145343
*/

package packages;
import game.Board;
import GUI.Colours;

public class Human extends Player 
{
    private String name; 
    
    public Human(String name, Disc disc, Colours colour)
    {
        super(disc, colour);
        this.name = name;
    }
    
    public Human(String name)
    {
        this.name = name;
    }
    
    public Disc getDisc()
    {
        return this.disc;
    }
    
    @Override
    public String getName()
    {
        return this.name;
    }
    
    @Override
    public void move(Board board)
    {
        // Prompts the user to enter a move, confirms it is valid, then executes it
        
        UserInput userInput = new UserInput();
        
        int playerMove = userInput.getPlayerMove(board);
        
        if(!board.isRowFull(playerMove))
        {
            board.dropPiece(playerMove, disc);
            Human.currentPlayer++;
        }
    }   
}