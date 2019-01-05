package game;

import data.*;
import data.impl.*;
import io.*;

/**
 * drives the process of one game
 */
public class Engine
{
	private Display display;
	private Input input;

	/**
	 * start a game with given input/output
	 * (i.e. manual dependency injection...)
	 */
	public Engine(Input input, Display display) {
		this.input = input;
		this.display = display;
	}

	/**
	 * control the game flow
	 */
	public void gameOn() {
		// start game: determine difficulty 
		Difficulty difficulty = null;
		do {
			try {
				display.start();
				String userInput = input.difficulty();
				if (isExitRequested(userInput)) return;
				difficulty = Difficulty.getUserChoice(userInput);
			} catch (IllegalArgumentException e) {
				display.inputError();
			}
		} while (difficulty == null);

		// initialize game board 
		Board board = new ArrayBoard(difficulty.size);
		board.shuffle();

		// game main loop: move tiles until complete
		int turnNumber = 1;
		do {
			try {
				display.turn(turnNumber, board, difficulty.tiles);
				String userInput = input.turn();
				if (isExitRequested(userInput)) return;
				int pos = difficulty.tiles.getPos(userInput);
				if (!board.move(pos)) display.cannotMoveTile();
				else turnNumber++;  // advance turn number only if move successful 
			} catch (IllegalArgumentException e) {
				display.inputError();
			}
		} while (!board.isComplete());

		// end of game!
		display.victory(turnNumber, board, difficulty.tiles);
	}

	private boolean isExitRequested(String userInput) {
		return userInput.equalsIgnoreCase(Globals.exit);
	}
}
