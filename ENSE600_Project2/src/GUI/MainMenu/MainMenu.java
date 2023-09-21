package GUI.MainMenu;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author RYZEN RTX
 */
public class MainMenu extends JFrame
{
    public MainMenu()
    {
        setTitle("Connect Four! Main Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setScreenSize();
        setVisible(true);
        
        TwoPlayerGameButton twoPlayerButton = new TwoPlayerGameButton(this, 30);
        add(twoPlayerButton);
        
        
    }
    
    public void setScreenSize()
    {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        int frameWidth = screenWidth / 2 + 200;
        int frameHeight = screenHeight / 2 + 200;
        this.setSize(frameWidth, frameHeight);
        this.setLocationRelativeTo(null);
    }
    
    public static void main(String[] args) {
        MainMenu menu = new MainMenu();
    }
}
