/*
    Connect 4 - ENSE600 Project 2
    
    Nicolai Grant

    ID: 21145343
*/

package game;

import packages.Disc;


public final class Board
{
    private static final int ROWS = 6;
    private static final int COLS = 7;
    
    private static final String nums = "① ② ③ ④ ⑤ ⑥ ⑦";
    //private static final String nums = "1 2 3 4 5 6 7";

    private String[][] board;
    
    private int[] colHeight;
    
    public Board()
    {
        this.board = new String[ROWS][COLS];
        this.colHeight = new int[COLS];
        this.emptyBoard();
        //this.displayBoard();
    }
    
    public String[][] getBoard()
    {
        return this.board;
    }
    
    public void setBoard(String[][] board)
    {
        this.board = board;
    }
    
    public int[] getColHeight()
    {
        return this.colHeight;
    }
    
    public int getRows()
    {
        return this.ROWS;
    }
    
    public int getCols()
    {
        return this.COLS;
    }
    
    public void emptyBoard()
    {
        // Replaces all elements in the board array with empty white discs
        
        for(int i = 0; i < ROWS; i++)
        {
            for(int j = 0; j < COLS; j++)
            {
                this.getBoard()[i][j] = Disc.EMPTY.getDisc();
            }
        }
    }
    
    public void displayBoard()
    {
        // Prints the board to the console
        
        for(int i = ROWS - 1; i >= 0; i--)
        {
            for(int j = 0; j < COLS; j++)
            {
                System.out.print(this.getBoard()[i][j]);
            }
            System.out.println("");   
        }
        System.out.println(nums);
        System.out.println("");

    }
    
    public void dropPiece(int x, Disc disc)
    {
        // Places the piece in the desired column and increments the column height
        
        //x = x-1; // shifts x so that index starts at 1
        this.getBoard()[this.getColHeight()[x]][x] = disc.getDisc();
        this.getColHeight()[x]++; // increment the height of the column
        //this.displayBoard();
    }
    
    public boolean isRowFull(int row)
    {
        // Checks colHeight array at index x and returns true if it is full
        
        if(this.getColHeight()[row] == this.ROWS)
        {
            return true;
        }
        
        return false;
        
        
    }
    
    public boolean isBoardFull()
    {
        // Returns true if the board is full 
        
        for(int col = 0; col < COLS; col++)
        {
            if(!isRowFull(col))
            {
                return false;
            }
        }

        return true;
    }
    
    public boolean isEmpty(int x, int y)
    {
        // Returns true if the board is empty
        
        return this.getBoard()[x][y].equals(Disc.EMPTY.getDisc());
    }
    
    public boolean isConnectFour(Disc disc)
    {
        // Returns true if specified disc occurs 4 times consecutively
        
        return (horizontalWin(disc) || verticalWin(disc) || forwardDiagonalWin(disc) || backwardDiagonalWin(disc));
    }
    
    public boolean isConnectFour(Player player1, Player player2)
    {
        return isConnectFour(player1.getDisc()) || isConnectFour(player2.getDisc());
    }
    
    public boolean horizontalWin(Disc disc)
    {
        // Returns true if the specified disc appears four times consecutively in a horizontal row
        
        for(int i = 0; i < ROWS; i++)
        {
            for(int j = 0; j < COLS - 3; j++)
            {
                if(this.getBoard()[i][j].equals(disc.getDisc())
                        && this.getBoard()[i][j+1].equals(disc.getDisc())
                        && this.getBoard()[i][j+2].equals(disc.getDisc())
                        && this.getBoard()[i][j+3].equals(disc.getDisc()))
                {
                    return true;
                }           
            }           
        }
        
        return false;
    }
    
    public boolean verticalWin(Disc disc)
    {
        // Returns true if the specified disc appears four times consecutively in a vertical column
        
        for(int i = 0; i < ROWS - 3; i++)
        {
            for(int j  = 0; j < COLS; j++)
            {
                if(this.getBoard()[i][j].equals(disc.getDisc())
                        && this.getBoard()[i + 1][j].equals(disc.getDisc())
                        && this.getBoard()[i + 2][j].equals(disc.getDisc())
                        && this.getBoard()[i + 3][j].equals(disc.getDisc()))
                {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean forwardDiagonalWin(Disc disc)
    {
        // Returns true if the specified disc appears four times consecutively in a forward diagonal row
        
        for(int i = 0; i < ROWS - 3; i++)
        {
            for(int j  = 0; j < COLS - 3; j++)
            {
                if(this.getBoard()[i][j].equals(disc.getDisc())
                        && this.getBoard()[i + 1][j + 1].equals(disc.getDisc())
                        && this.getBoard()[i + 2][j + 2].equals(disc.getDisc())
                        && this.getBoard()[i + 3][j + 3].equals(disc.getDisc()))
                {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean backwardDiagonalWin(Disc disc)
    {
        // Returns true if the specified disc appears four times consecutively in a backwards diagonal row
        
        for(int i = 3; i < ROWS; i++)
        {
            for(int j  = 0; j < COLS - 3; j++)
            {
                if(this.getBoard()[i][j].equals(disc.getDisc())
                        && this.getBoard()[i - 1][j + 1].equals(disc.getDisc())
                        && this.getBoard()[i - 2][j + 2].equals(disc.getDisc())
                        && this.getBoard()[i - 3][j + 3].equals(disc.getDisc()))
                {
                    return true;
                }
            }
        }
        
        return false;
    }
}

