/*
    Connect 4 - ENSE600 Project 2
    
    Nicolai Grant

    ID: 21145343
*/

package GUI;

import game.Game;
import game.Player;
import java.awt.*;
import javax.swing.*;

public class GameGUI extends JFrame
{
    private static final Color BACKGROUND = new Color(93, 139, 186);
    
    private Game game;
    private BoardGridGUI board;
    
    private CurrentPlayerGUI player1Panel;
    private CurrentPlayerGUI player2Panel;
    
    private Player player1;
    private Player player2;
    
    
    public GameGUI(Game game)
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        getContentPane().setBackground(BACKGROUND);
        setScreenSize();        
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 50)); 
        
        this.game = game;
        
        this.player1 = game.getPlayer1();
        this.player2 = game.getPlayer2();
        
        this.player1Panel = new CurrentPlayerGUI(this.getPlayer1());
        this.player2Panel = new CurrentPlayerGUI(this.getPlayer2());
        
        display();
    }
    
    public Game getGame()
    {
        return this.game;
    }
    
    public BoardGridGUI getBoard()
    {
        return game.getBoardGUI();
    }
    
    public Player getPlayer1()
    {
        return this.player1;
    }
    
    public Player getPlayer2()
    {
        return this.player2;
    }
    
    public CurrentPlayerGUI getPlayer1Panel()
    {
        return this.player1Panel;
    }
    
    public CurrentPlayerGUI getPlayer2Panel()
    {
        return this.player2Panel;
    }
    
    public void setScreenSize()
    {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        setResizable(false);
        //int screenWidth = screenSize.width;
        //int screenHeight = screenSize.height;
        //int frameWidth = screenWidth / 2 + 500;
        //int frameHeight = screenHeight / 2 + 400;
        int frameWidth = 1380;
        int frameHeight = 880;
        setSize(frameWidth, frameHeight);
        setLocationRelativeTo(null);
    }
    
    public void display()
    {
        add(getPlayer1Panel(), BorderLayout.WEST);
        add(new Spacer(50, 1));
        game.setBoardGUI(new BoardGridGUI(getGame()));
        add(new MiddlePanelGUI(game));
        add(new Spacer(50, 1));
        add(getPlayer2Panel(),BorderLayout.EAST);
        setVisible(true);
    }
    
    public void resetBoard()
    {
        game.getBoardGUI().resetBoard();
        
        getPlayer2Panel().repaint();
        display();
    }   
}