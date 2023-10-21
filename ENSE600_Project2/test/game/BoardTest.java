/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package game;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import packages.Disc;

public class BoardTest {
    
    private Board board;
    
    public BoardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() 
    {
        board = new Board();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testDropPiece() 
    {
        // Test dropping a piece and check if it's in the correct position
        Disc disc = Disc.RED;
        int x = 0;
        board.dropPiece(x, disc);
        assertEquals(disc.getDisc(), board.getBoard()[0][x]);
    }
    
    @Test
    public void testIsRowFull() 
    {
        // Test when a row is not full
        assertFalse(board.isRowFull(0));

        // Populate a row
        Disc disc = Disc.RED;
        int x = 0;
        for (int i = 0; i < board.getRows(); i++) 
        {
            board.dropPiece(x, disc);
        }

        // Test when a row is full
        assertTrue(board.isRowFull(0));
    }

    @Test
    public void testIsBoardFull() 
    {
        // Test when the board is empty
        assertFalse(board.isBoardFull());

        // Populate the entire board 
        Disc disc = Disc.RED;
        for (int i = 0; i < board.getCols(); i++) 
        {
            for (int j = 0; j < board.getRows(); j++) 
            {
                board.dropPiece(i, disc);
            }
        }

        // Test when the board is full
        assertTrue(board.isBoardFull());
    }

    @Test
    public void testHorizontalWin() 
    {
        // Test a horizontal win with four pieces horizontally
        Disc disc = Disc.RED;

        // Add four pieces in a horizontal row
        for (int i = 0; i < 4; i++) 
        {
            board.dropPiece(i, disc);
        }

        assertTrue(board.horizontalWin(disc));
    }
    
    @Test
    public void testVerticalWin() 
    {
        // Test a vertical win with four pieces vertically
        Disc disc = Disc.YELLOW;

        // Create a winning condition in a column
        for (int i = 0; i < 4; i++) 
        {
            board.dropPiece(0, disc);
        }

        assertTrue(board.verticalWin(disc));
    }
    
}
