package data;

/**
 * an interface to manipulate the game board.<br>
 * tile values are represented in {@code int} values from 1 to board's total size-1. 
 * for example, a 4X4 board has tile values from 1 to 15<br>
 * the empty tile is represented as value {@code 0}.<br>
 */
public interface Board
{
	/**
	 * the empty tile position
	 */
	public static final int EMPTY = 0;

	/**
	 * initialize board: set tiles in random order
	 */
	void shuffle();

	/**
	 * initialize board: set to complete state
	 */
	void setComplete();

	/**
	 * returns board's size
	 * @return {@code int} board's size as size of one row (or column). <br>
	 * For example, value {@code 4} represents a 4X4 board. 
	 */
	int getSize();

	/**
	 * returns value of tile at given coordinates
	 * @param row {@code int} row number (starting from {@code 0}). <br>
	 * @param col {@code int} column number (starting from {@code 0}). <br>
	 * @return value of tile as {@code int} in range of {@code 0} to board's total size-1. <br>
	 * @throws ArrayIndexOutOfBoundsException if args point outside the board
	 */
	int get(int row, int col) throws ArrayIndexOutOfBoundsException;

	/**
	 * move tile with given value to the empty place 
	 * @param value {@code int} tile value
	 * @return {@code true} if the move was successful
	 * @throws IllegalArgumentException if given value cannot be parsed
	 */
	boolean move(int value) throws IllegalArgumentException;

	/**
	 * checks whether this board represents finished state 
	 * @return ({@code true} if all tiles are in place
	 */
	boolean isComplete();

}
