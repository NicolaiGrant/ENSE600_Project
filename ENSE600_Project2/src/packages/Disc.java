/*
    Connect 4 - ENSE600 Project 2
    
    Nicolai Grant

    ID: 21145343
*/

package packages;

public enum Disc
{
    RED("🔴 "),
    YELLOW("🟡 "),
    BLUE("🔵 "),
    EMPTY("⚪ ");
    
    
    private final String disc;
    
    private Disc(String disc)
    {
        this.disc = disc;
    }
    
    public String getDisc()
    {
        return this.disc;
    }
}