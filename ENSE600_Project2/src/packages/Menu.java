/*
    Connect 4 - ENSE600 Project 1
    
    Nicolai Grant

    ID: 21145343
*/

package packages;

public class Menu
{
    private UserInput userInput;
    private Score score;
    
    public Menu(Score score)
    {
        this.userInput = new UserInput();
        this.score = score;
    }
    
    public void displayMenu()
    {
        System.out.println("===== Connect Four =====");
        System.out.println("1. Play against Computer");
        System.out.println("2. 2 Player Mode");
        System.out.println("3. View Scores");
        System.out.println("4. Quit");
        System.out.println("========================");
        System.out.println("Press 'x' at any time to quit!");
    }
    
    public void scoreMenu()
    {
        // Displays the the scoreboard and prompts the user to clear the scores 
        // or return to the main menu
        
        score.printScores();
        
        if(this.userInput.scoreBoard() == true)
        {
            this.score.clearScoreBoard();   
            this.scoreMenu();
        }
    }
}
