package Database;

public class LeaderboardData implements Comparable<LeaderboardData>
{
    private String playerName;
    private int score;
    private int rank;
    private String date;
    
    public LeaderboardData(String playerName, int score, String date)
    {
        this.playerName = playerName;
        this.score = score;
        this.date = date;
        this.rank = 0;
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
    
    public int getRank()
    {
        return this.rank;
    }
    
    public void setRank(int rank)
    {
        this.rank = rank;
    }
    
    @Override
    public int compareTo(LeaderboardData o) 
    {
        return Integer.compare(this.rank, o.rank);
    }
}
