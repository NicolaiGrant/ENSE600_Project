package GUI;

import game.Player;
import java.awt.*;
import javax.swing.*;

public class GameGUI extends JFrame
{
    private static final Color BACKGROUND = new Color(93, 139, 186);
    
    private BoardGridGUI board;
    
    public GameGUI()
    {
        setTitle("Connect Four! - Two Player Mode");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        getContentPane().setBackground(BACKGROUND);
        this.setScreenSize();        
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 50));    
        
        this.display();
    }
    
    public void setScreenSize()
    {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        int frameWidth = screenWidth / 2 + 600;
        int frameHeight = screenHeight / 2 + 200;
        this.setSize(screenWidth, screenHeight);
        this.setLocationRelativeTo(null);
    }
    
    public void display()
    {
        this.add(new CurrentPlayerGUI(new Player("Player1", Colours.RED.getColour())), BorderLayout.WEST);
        this.add(new Spacer(50, 1));
        this.board = new BoardGridGUI(this);
        this.add(new MiddlePanelGUI(this, board));
        this.add(new Spacer(50, 1));
        this.add(new CurrentPlayerGUI(new Player("Player2", Colours.YELLOW.getColour())), BorderLayout.EAST);
        setVisible(true);
    }
    
    public void resetBoard()
    {
        this.board.resetBoard();
    }
    
    public static void main(String[] args)
    {
        GameGUI game = new GameGUI();
    
    }
}


