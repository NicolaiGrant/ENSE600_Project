/*
    Connect 4 - ENSE600 Project 1
    
    Nicolai Grant

    ID: 21145343
*/

package packages;

import GUI.BoardGUI;

public class Game
{
    protected Player player1;
    protected Player player2;
    protected Player bot;
    protected Player currentPlayer;
    
    protected Board board;
    
    protected Score score;
    
    protected UserInput userInput;
    
    protected BoardGUI boardGUI;
    
    public Game()
    {
        this.userInput = new UserInput();
    }
    
    public Player getPlayer1()
    {
        return player1;
    }

    public void setPlayer1(Player player1)
    {
        this.player1 = player1;
    }

    public Player getPlayer2()
    {
        return player2;
    }

    public void setPlayer2(Player player2)
    {
        this.player2 = player2;
    }
    
    public Player getBot()
    {
        return bot;
    }

    public void setBot(Player bot)
    {
        this.bot = bot;
    }

    public Player getCurrentPlayer()
    {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer)
    {
        this.currentPlayer = currentPlayer;
    }
        
    public void play()
    {
        // Initialises a new board and plays the game until it is over 
        
        this.board = new Board();
        
        this.boardGUI = new BoardGUI();
                
        this.setCurrentPlayer(Player.getCurrentPlayer(getPlayer1(), getPlayer2()));

        while(!board.isConnectFour(this.currentPlayer.disc) && !board.isBoardFull())
        {
            this.setCurrentPlayer(Player.getCurrentPlayer(getPlayer1(), getPlayer2())); // swaps player turn
            
            this.makeMoveMessage();
            
            //boardGUI.setCurrentPlayer(Player.getCurrentPlayer(getPlayer1(), getPlayer2()));
            
            //boardGUI.printBoard();


            getCurrentPlayer().move(board);
        }
        
        this.gameOver();
    }
    
    public void makeMoveMessage()
    {
        // Displays a message to the current player to make their move (unless they are the computer)
        
        if(!this.getCurrentPlayer().getName().equals("Bot"))
        {
            String message = this.getCurrentPlayer().disc.getDisc() + getCurrentPlayer().getName() + " Select a Column";
            System.out.println(message);
        }    
    }
    
    public void winner(Player player)
    {
        // Prints win message and updates score on scorebaord
        
        System.out.println("Connect Four! " + player.disc.getDisc() + player.getName() + " is the winner!\n");
        this.score.addWin(player);
    }
    
    public void noWinner()
    {
        System.out.println("Game Over! No winner\n");
    }
    
    public Player getPlayer(int n)
    {
        // Prompts the user to enter their name and assigns to a player object
        
        String playerName = this.userInput.getPlayerName(n);
        
        return new Human(playerName);  
    }
    
    public void assignPlayers()
    {
        // Assigns the player name and disc colour 
        
        this.setPlayer1(this.getPlayer(1));
        score.addUserScore(getPlayer1());
                    
        this.setPlayer2(this.getPlayer(2)); 
        score.addUserScore(getPlayer2());
                    
                    
        if(this.getPlayer1().disc == this.getPlayer2().disc)
        {
            if(this.getPlayer1().disc == Disc.RED)
            {
                this.getPlayer2().disc = Disc.YELLOW;
            }
            else
            {
                this.getPlayer2().disc = Disc.RED;
            }
        } 
    }
    
    public void gameOver()
    {
        // Checks if there is a winner or not at the end of the game
        
        if(board.isBoardFull())
        {
            this.noWinner();
        }
        else if(board.isConnectFour(getCurrentPlayer().disc))
        {
            this.winner(getCurrentPlayer());
        }
        
        this.replay();
    }
    
    public void replay()
    {
        // Prompts the user to play again
        
        if(new UserInput().replay())
        {
            this.play();
        }
    }
}
