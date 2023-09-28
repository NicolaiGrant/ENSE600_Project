/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import GUI.Colours;
import java.awt.Color;
import java.util.Random;

public class Bot extends Player
{
    Random random;
    String name;
    
    public Bot()
    {
        super("Bot");
        this.random = new Random();
        this.name = "Bot";
    }
        
    @Override
    public String getName()
    {
        return this.name;
    }

    public void move(Board board)
    {
        // Places the piece in a random column
        
        int x = random.nextInt(7) + 1;
        if(!board.isRowFull(x))
        {
            board.dropPiece(x, disc);
            //this.currentPlayer++;
        }
    }
}