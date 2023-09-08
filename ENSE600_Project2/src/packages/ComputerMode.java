/*
    Connect 4 - ENSE600 Project 1
    
    Nicolai Grant

    ID: 21145343
*/

package packages;

import java.io.IOException;

public class ComputerMode extends Game
{
    public ComputerMode(Score score) throws IOException
    {
        this.score = score;
        this.assignPlayers();
    }

    @Override
    public void assignPlayers()
    {
        this.setPlayer1(this.getPlayer(1));
        score.addUserScore(getPlayer1());
                    
        this.setPlayer2(new Bot());
        score.addUserScore(getPlayer2());
                    
                    
        if(getPlayer1().disc == getPlayer2().disc)
        {
            if(getPlayer1().disc == Disc.RED)
            {
                player2.disc = Disc.YELLOW;
            }
            else
            {
                player2.disc = Disc.RED;
            }
        }
    }
    
    @Override
    public void winner(Player player)
    {
        // Prints win message and updates score on scorebaord
        
        String winMessage = "Connect Four! " + player.disc.getDisc() + player.getName() + " is the winner!\n";
        if(player.getName().equals("Bot"))
        {
            winMessage = "Connect Four! You Lose! " + player.disc.getDisc() + player.getName() + " is the winner!\n";
        }
        System.out.println(winMessage);
        this.score.addWin(player);
    }
}
