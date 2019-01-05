package io;

/**
 * interface for receiving user input
 */
public interface Input
{
	/**
	 * get difficulty indicator
	 */
	String difficulty();

	/**
	 * get tile to move
	 */
	String turn();
}
