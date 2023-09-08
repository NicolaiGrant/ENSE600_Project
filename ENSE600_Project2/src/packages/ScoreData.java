/*
    Connect 4 - ENSE600 Project 1
    
    Nicolai Grant

    ID: 21145343
*/

package packages;

public class ScoreData implements Comparable<ScoreData>
{
    private String name;
    private int score;
    
    public ScoreData(String name, int score)
    {
        this.name = name;
        this.score = score;
    }
 
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getScore()
    {
        return score;
    }

    public void setScore(int score)
    {
        this.score = score;
    }

    @Override
    public int compareTo(ScoreData o)
    {
        return Integer.compare(o.score, this.score);
    }
}
