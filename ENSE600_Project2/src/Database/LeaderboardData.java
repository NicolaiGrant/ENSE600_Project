/*
    Connect 4 - ENSE600 Project 2
    
    Nicolai Grant

    ID: 21145343
*/

package Database;

public class LeaderboardData implements Comparable<LeaderboardData>
{
    private String playerName;
    private int score;
    private String date;
    
    public LeaderboardData(String playerName, int score, String date)
    {
        this.playerName = playerName;
        this.score = score;
        this.date = date;
    }
    
    public String getPlayerName()
    {
        return this.playerName;
    }
    
    public int getScore()
    {
        return this.score;
    }
    
    public String getDate()
    {
        return this.date;
    }
    
    @Override
    public int compareTo(LeaderboardData o) 
    {
        return Integer.compare(this.score, o.score);
    }
}
