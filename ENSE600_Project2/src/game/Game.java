
package game;

import GUI.BoardGUI;
import packages.Board;

public class Game
{
    private BoardGUI boardGUI;

    public Game()
    {
    }
    
    public static void main(String[] args)
    {
        Game game = new Game();
        game.play();
    }
    
    public void play()
    {
        boardGUI = new BoardGUI();
       
        while(!this.isConnectFour())
        {
            boardGUI.startGame();
        }
        
        boardGUI.stopGame();  
    }
    
    public boolean isConnectFour()
    {
        Player currentPlayer = this.boardGUI.getCurrentPlayer();
        return this.boardGUI.getBoardLogic().isConnectFour(currentPlayer.getDisc());
    }
}
