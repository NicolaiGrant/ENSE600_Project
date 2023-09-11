///*
//    Connect 4 - ENSE600 Project 1
//    
//    Nicolai Grant
//
//    ID: 21145343
//*/
//
//package packages;
//
//import java.io.IOException;
//import GUI.BoardGUI;
//
//public class ConnectFour
//{
//    public static void main(String[] args) throws IOException
//    {
//        Score score = new Score();
//        Menu menu = new Menu(score);
//        UserInput userInput = new UserInput();
//        
//        final int MENU = 0;
//        final int PLAY_VS_COMPUTER = 1;
//        final int TWO_PLAYER_MODE = 2;
//        final int SCOREBOARD = 3;
//        final int EXIT = 4;
//
//        int state = MENU;
//        
//        while(true)
//        {      
//            // Displays the Main Menu and prompts the user to choose to
//            // play against the Computer, play against a friend, view 
//            // scoreboard, or exit.
//            
//            switch(state)
//            {
//                case MENU:
//
//                    menu.displayMenu();
//                    
//                    state = userInput.getMenuInput();
//
//                    break;
//
//                    
//                case PLAY_VS_COMPUTER:
//                    
//                    ComputerMode computerMode = new ComputerMode(score);
//                    
//                    computerMode.play();
//                    
//                    state = MENU;
//                    
//                    break;
//                    
//       
//                case TWO_PLAYER_MODE:
//
//                    TwoPlayerMode twoPlayerMode = new TwoPlayerMode(score);
//                    
//                    twoPlayerMode.play();
//                                   
//                    state = MENU;
//                    
//                    break;
//                    
//                case SCOREBOARD:
//                    
//                    menu.scoreMenu();
//                    
//                    System.out.println("");
//                    
//                    state = MENU;
//                    
//                    break;
//                    
//                case EXIT:
//                    
//                    System.out.println("Thank You for Playing Connect 4!");
//                    System.exit(0);
//                    
//                    break;
//                
//                default:
//                    
//                    System.out.println("Invalid Entry");
//                    
//                    state = MENU;
//                    
//                    break;
//            } 
//        }   
//    }
//}
