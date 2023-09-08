/*
    Connect 4 - ENSE600 Project 1
    
    Nicolai Grant

    ID: 21145343
*/

package packages;

import java.io.IOException;

public class TwoPlayerMode extends Game
{
    public TwoPlayerMode(Score score) throws IOException
    {
        this.score = score;
        this.assignPlayers();
    }
}