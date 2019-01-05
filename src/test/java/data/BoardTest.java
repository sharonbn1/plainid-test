package data;

import static org.junit.Assert.*;
import org.junit.*;

import data.impl.*;
import game.Difficulty;

public class BoardTest
{
    @Test
    public void testSetComplete() {
		Board board = new ArrayBoard(4);
		board.setComplete();
		assertTrue("not very good set compelte", board.isComplete()); 
    }

    @Test
    public void testShuffle() {
		Board board = new ArrayBoard(4);
		board.shuffle();  // after shuffling, should not be ordered
		assertFalse("not very good shuffle", board.isComplete()); 
    }

    @Test
    public void testGetSize() {
		Board board = new ArrayBoard(Difficulty.Beginner.size);
		board.shuffle();
		assertEquals("wrong get size", Difficulty.Beginner.size, board.getSize());
		board = new ArrayBoard(Difficulty.Normal.size);
		board.shuffle();
		assertEquals("wrong get size", Difficulty.Normal.size, board.getSize());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGet() {
		Board board = new ArrayBoard(Difficulty.Normal.size);
		board.setComplete();
		assertEquals("wrong get", 1, board.get(0, 0));
		board.get(4, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidInputSize3() {
		Board board = new ArrayBoard(Difficulty.Beginner.size);
		board.shuffle();
		board.move(9); 
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidInputSize4() {
		Board board = new ArrayBoard(Difficulty.Normal.size);
		board.shuffle();
		board.move(16); 
    }

    @Test
    public void testSuccessfulMove() {
		Board board = new ArrayBoard(Difficulty.Normal.size);
		board.setComplete();
		assertTrue("should be able to move this tile", board.move(15)); 
    }

    @Test
    public void testCannotMove() {
		Board board = new ArrayBoard(Difficulty.Normal.size);
		board.setComplete();
		assertFalse("should not be able to move this tile", board.move(1)); 
    }

    @Test
    public void testVictory() {
		Board board = new ArrayBoard(Difficulty.Normal.size);
		board.setComplete();
		board.move(15);  // move one tile
		board.move(15);  // move it again 
		assertTrue("should be complete", board.isComplete()); 
    }
}
