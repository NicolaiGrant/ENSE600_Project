package GUI;

import game.Bot;
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
        //setTitle("Connect Four! - Two Player Mode");
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
        setResizable(true);
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        int frameWidth = screenWidth / 2 + 300;
        int frameHeight = screenHeight / 2 + 200;
        setSize(frameWidth, frameHeight);
        setLocationRelativeTo(null);
    }
    
    public void display()
    {
        //this.add(new CurrentPlayerGUI(new Player(this.getPlayer1().getName(), Colours.RED.getColour())), BorderLayout.WEST);
        add(this.getPlayer1Panel(), BorderLayout.WEST);
        add(new Spacer(50, 1));
        game.setBoardGUI(new BoardGridGUI(getGame()));
        //board = new BoardGridGUI(this);
        //add(new MiddlePanelGUI(this, board));
        add(new MiddlePanelGUI(game));
        add(new Spacer(50, 1));
        //this.add(new CurrentPlayerGUI(new Player("Player2", Colours.YELLOW.getColour())), BorderLayout.EAST);
        add(new CurrentPlayerGUI(getPlayer2()),BorderLayout.EAST);
        //add(this.getPlayer2Panel(), BorderLayout.EAST);
        setVisible(true);
    }
    
    public void resetBoard()
    {
        game.getBoardGUI().resetBoard();
        
        getPlayer1().setColour(Colours.RED.getColour());
        getPlayer2().setColour(Colours.RED.getColour());
        
        getPlayer1Panel().setColour(Colours.RED.getColour());
        getPlayer2Panel().setColour(Colours.RED.getColour());
        
        display();
    }   
}