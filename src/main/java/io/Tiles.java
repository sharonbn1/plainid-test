package io;

/** 
 * interface for display set of tiles
 */
public interface Tiles 
{
	/**
	 * name of this set of tiles
	 */
	String name();

	/**
	 * String size of a tile value (number of characters)
	 * note: all tiles must have same size!
	 */
	int    tileSize();

	/**
	 * get tile value
	 */
	String getTile(int order);

	/**
	 * get empty tile value
	 */
	String getEmptyTile();

	/**
	 * get board position from tile value
	 * @param tile
	 * @return
	 * @throws IllegalArgumentException
	 */
	int getPos(String tile) throws IllegalArgumentException;
}
