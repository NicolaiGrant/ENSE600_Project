/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PlayerInputGUI extends JDialog
{
    private JTextField player1Input;
    private JTextField player2Input;
    
    public PlayerInputGUI(JFrame frame, GameGUI board)
    {
        super(board, "Enter Player Names", false);
        setLayout(new GridLayout(3, 2));
        setPreferredSize(new Dimension(500, 300));
        setUndecorated(true);

        JLabel player1Label = new JLabel("Player 1 Name:");
        player1Input = new JTextField();

        JLabel player2Label = new JLabel("Player 2 Name:");
        player2Input = new JTextField();

        JButton startButton = new JButton("Start Game");
        
        startButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String player1Name = getPlayer1Name();
                String player2Name = getPlayer2Name();
                
                board.dispose();
                
                GameGUI newGame = new GameGUI(player1Name, player2Name);
                newGame.getBoard().startGame();
                
                board.assignPlayers(player1Name, player2Name);
                
                //board.display();
                
                //board.repaint();
                
                //board.getBoard().startGame();
                
                dispose();
            }
        });
        
        add(player1Label);
        add(player1Input);
        add(player2Label);
        add(player2Input);
        add(startButton);

        pack();
        setLocationRelativeTo(frame);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        setOpacity(0.9f);
        
        setVisible(true);
    }
    
    public String getPlayer1Name()
    {
        return this.player1Input.getText();
    }
    
    public String getPlayer2Name()
    {
        return this.player2Input.getText();
    }
    
//    @Override
//    public void paint(Graphics g) 
//    {
//        super.paint(g);
//        int width = getWidth();  
//        int height = getHeight();
//
//        int arcWidth = 50; 
//
//        g.setColor(Colours.BLUE.getColour());
//        g.fillRoundRect(0, 0, width, height, arcWidth, arcWidth); 
//    }
}
