/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.Leaderboard;

import GUI.Buttons.ClearButton;
import GUI.Buttons.ExitButton;
import GUI.Buttons.HomeButton;
import GUI.MenuDockGUI;
import game.Game;

/**
 *
 * @author RYZEN RTX
 */
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
