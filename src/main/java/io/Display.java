package io;

import data.*;

/**
 * interface for display of game prompts and progress
 */
public interface Display
{
	/**
	 * welcome message, get initial input
	 */
	void start();

	/**
	 * get input for game turn (tile to move or exit)
	 * @param turnNumber {@code int} current turn 
	 * @param currentBoard current {@code Board} 
	 * @param tiles {@code Tile} values to display on board
	 */
	void turn(int turnNumber, Board currentBoard, Tiles tiles);

	/**
	 * display victory message
	 * @param turns {@code int} number of turns until victory
	 * @param currentBoard current {@code Board} 
	 * @param tiles {@code Tile} values to display on board
	 */
	void victory(int turns, Board currentBoard, Tiles tiles);

	/**
	 * display exit message
	 */
	void exit();

	/**
	 * display message when invalid input received
	 */
	void inputError();

	/**
	 * display message when wrong tile was chosen
	 */
	void cannotMoveTile();

	/**
	 * display message when unexpected exception is thrown 
	 */
	void unexpectedError();
}
