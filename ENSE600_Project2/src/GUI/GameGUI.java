package GUI;

import game.Player;
import java.awt.*;
import javax.swing.*;

public class GameGUI extends JFrame
{
    private static final Color BACKGROUND = new Color(93, 139, 186);
    
    private BoardGridGUI board;
    
    private CurrentPlayerGUI player1Panel;
    private CurrentPlayerGUI player2Panel;
    
    private Player player1;
    private Player player2;
    
    public GameGUI()
    {
        setTitle("Connect Four! - Two Player Mode");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        getContentPane().setBackground(BACKGROUND);
        setScreenSize();        
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 50)); 
        
        
        this.player1 = new Player("", Colours.RED.getColour());
        this.player2 = new Player("", Colours.YELLOW.getColour());
        
        this.player1Panel = new CurrentPlayerGUI(this.getPlayer1());
        this.player2Panel = new CurrentPlayerGUI(this.getPlayer2());
        
        this.display();
    }
    
    public GameGUI(String player1Name, String player2Name)
    {
        //setTitle("Connect Four! - Two Player Mode");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        getContentPane().setBackground(BACKGROUND);
        this.setScreenSize();        
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 50)); 
        
        this.player1 = new Player(player1Name, Colours.RED.getColour());
        this.player2 = new Player(player2Name, Colours.YELLOW.getColour());
        
        this.player1Panel = new CurrentPlayerGUI(this.getPlayer1());
        this.player2Panel = new CurrentPlayerGUI(this.getPlayer2());
        
        this.display();
    }
    
    
    
    public BoardGridGUI getBoard()
    {
        return this.board;
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
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        int frameWidth = screenWidth / 2 + 300;
        int frameHeight = screenHeight / 2 + 200;
        this.setSize(frameWidth, frameHeight);
        this.setLocationRelativeTo(null);
    }
    
    public void display()
    {
        //this.add(new CurrentPlayerGUI(new Player("Player1", Colours.RED.getColour())), BorderLayout.WEST);
        this.add(this.getPlayer1Panel(), BorderLayout.WEST);
        this.add(new Spacer(50, 1));
        this.board = new BoardGridGUI(this);
        this.add(new MiddlePanelGUI(this, board));
        this.add(new Spacer(50, 1));
        //this.add(new CurrentPlayerGUI(new Player("Player2", Colours.YELLOW.getColour())), BorderLayout.EAST);
        this.add(this.getPlayer2Panel(), BorderLayout.EAST);
        setVisible(true);
    }
    
    public void resetBoard()
    {
        this.board.resetBoard();
    }
    
    public void assignPlayers(String playerName1, String playerName2)
    {
        this.player1 = new Player(playerName1, Colours.RED.getColour());
        this.player2 = new Player(playerName2, Colours.YELLOW.getColour());
        
        this.player1Panel = new CurrentPlayerGUI(this.getPlayer1());
        this.player2Panel = new CurrentPlayerGUI(this.getPlayer2());
        
        getPlayer1Panel().repaint();
        getPlayer2Panel().repaint();

        repaint();
        revalidate();
        //dispose();
        //display();
        
        System.out.println("Player1: " + this.player1.getName());
        System.out.println("Player2: " + this.player2.getName());
    }
    
    public static void main(String[] args)
    {
        GameGUI game = new GameGUI();
    
    }
}


