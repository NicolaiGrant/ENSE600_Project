/*
    Connect 4 - ENSE600 Project 1
    
    Nicolai Grant

    ID: 21145343
*/

package packages;

import game.Board;
import java.util.Scanner;

public class UserInput 
{
    private Scanner scanner;
    
    private String input;
    
    public UserInput()
    {
        this.scanner = new Scanner(System.in);
        this.input = "";
    }
    
    public String getUserInput(String message)
    {
        // Prompts the user using a specified message, collects the input and 
        // returns it as a String. If an error occurs, an error is returned,
        // and the user is prompted to retry.
        // If at any point, an 'x' is entered, the program is quit.
        
        boolean isValid = false;

        while(!isValid)
        {
            try
            {
                System.out.print(message);
                this.input = scanner.nextLine();
                this.checkExit(input); // checks input for x
                
                //System.out.println("");
                
                isValid = true;
                
            } catch (NumberFormatException e)
            {               
                this.errorMessage();
            }
        }
        
        return input;
    }
    
    public int getMenuInput()
    {
        // Receives input from user to select desired sub-menu and returns it. 
        // If invalid input is received, user is prompted to retry.
        
        boolean isValid = false;
        
        int input = 0;
        
        while(!isValid)
        {
            try
            {
                input = Integer.parseInt(this.getUserInput(""));
                
                if(input >= 1 && input <= 4)
                {
                    isValid = true;
                }
                else
                {
                    this.errorMessage();   
                } 
                
            } catch (NumberFormatException e){
                
                this.errorMessage();
            }  
        }
        
        return input;
    }
    
    public void checkExit(String input)
    {
        // Checks the input String for an 'x' and quits the program if so.
        
        if(input.trim().equalsIgnoreCase("x"))
        {
            System.out.println("\nThank You for Playing Connect 4!\n");
            System.out.println("Game created by Nicolai Grant\n");
            System.exit(0);
        }
    }
    
    public int getPlayerMove(Board board)
    {
        // Prompts user to enter a move. If it is not a valid move, the user
        // is prompted to retry until they enter a correct move (or an 'x' is entered)
        
        boolean isValidMove = false;
        int columnNum = 0;
        
        while(!isValidMove)
        {
            try
            {
                columnNum = Integer.parseInt(this.getUserInput(""));
                
                if(columnNum >= 0 & columnNum <= board.getCols())
                {
                    isValidMove = true;
                }
                else
                {
                    board.displayBoard();
                
                    this.errorMessage();
                }
            } catch (NumberFormatException n) {
                
                board.displayBoard();
                
                this.errorMessage();
            } 
        }
        
        return columnNum;
    }
    
    public String getPlayerName(int playerNum)
    {
        // Prompts the user to enter their name. playerNum is used to differentiate
        // between player 1 and player 2
        
        String playerName = this.getUserInput("Enter Player" + playerNum + " Name: ");
        
        System.out.println("");
        
        return playerName;
    }
    
    public boolean replay()
    {
        // Asks the user if they would like to replay. If 'y', return true, if 
        // 'n' return false.
        
        boolean replay = false;
        
        while(!replay)
        {
            String input = this.getUserInput("Would you like to replay? (y/n): ");
            
            System.out.println("");
        
            if(input.trim().equalsIgnoreCase("y"))
            {
                replay = true;
            }
            else if(input.trim().equalsIgnoreCase("n"))
            {
                return false;
            }
        }

        return replay;
    }
    
    public boolean isExistingPlayer(Player player)
    {
        // If the user already exists on the scoreboard, the player it prompted
        // to continue progress (returns true)  or override progress (returns false).
        
        boolean isExistingPlayer = false;
        
        if(player.getName().equals("Bot"))
        {
            isExistingPlayer = true;
        }
        
        while(!isExistingPlayer)
        {
            String input = this.getUserInput("Player: " + player.getName() + " already exists. Would you like to play as " + player.getName() + " or override progress (y/n): ");
            
            System.out.println("");
            
            if(input.trim().equalsIgnoreCase("y"))
            {
                isExistingPlayer = true;
            }
            else if(input.trim().equalsIgnoreCase("n"))
            {
                return false;
            }
        }

        return isExistingPlayer;
    }
    
    public boolean scoreBoard()
    { 
        // Asks the user if they would like to clear the scoreboard, and then 
        // confirms their request before return true or false.
        
        String input = this.getUserInput("Press 'c' to clear the scoreboard or 'r' to return to the main menu: ");

        if(input.trim().equalsIgnoreCase("c"))
        {
            while(true)
            {
                String choice = this.getUserInput("\nAre you sure you want to clear the scoreboard? (y/n): ");
                
                if(choice.trim().equalsIgnoreCase("y"))
                {
                    return true;
                }
                else if(choice.trim().equalsIgnoreCase("n"))
                {
                    return false;
                }
                else
                {
                    this.errorMessage();
                }
            }
            
            
        }
        else if(input.trim().equalsIgnoreCase("r"))
        {
            return false;
        }
        else
        {
            this.errorMessage();
            this.scoreBoard();       
        }
        
        return false;
    }
    
    public void errorMessage()
    {
        System.out.println("Invalid Input! Please try again...");
    } 
}
