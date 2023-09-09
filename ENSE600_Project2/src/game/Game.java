
package game;

import GUI.BoardGUI;

public class Game
{
    private BoardGUI boardGUI;
    Player currentPlayer;
    

    public Game()
    {
        
    }
    
    public Player getCurrentPlayer()
    {
        return this.currentPlayer;
    }
    
    public static void main(String[] args)
    {
        Game game = new Game();
        game.play();
    }
    
    public void play()
    {
        this.boardGUI = new BoardGUI();
        this.currentPlayer = this.boardGUI.getCurrentPlayer();
        
        boardGUI.startGame();
        
        while(this.boardGUI.isGameRunning())
        {
            this.boardGUI.setTitle(this.currentPlayer.getName() + " Move");
            this.currentPlayer = this.boardGUI.getCurrentPlayer();
        }
        
        this.boardGUI.setTitle("Connect Four! " + this.currentPlayer.getName() + " Wins!");
    }
    
    public boolean isConnectFour()
    {
        return this.boardGUI.isConnectFour() || this.boardGUI.isBoardFull();
    }
}
