/*
    Connect 4 - ENSE600 Project 2
    
    Nicolai Grant

    ID: 21145343
*/

package GUI.Leaderboard;

import GUI.Buttons.ClearButton;
import GUI.Buttons.ExitButton;
import GUI.Buttons.HomeButton;
import GUI.MenuDockGUI;
import game.Game;

public class LeaderboardDockGUI extends MenuDockGUI
{
    public LeaderboardDockGUI(Game game)
    {
        super(game);
        setSize(width, height);
    }
    
    @Override
    public void addButtons(Game game)
    {
        add(new ClearButton(game, buttonSize));
        add(new HomeButton(game, buttonSize));
        add(new ExitButton(game, buttonSize));
    }
}
