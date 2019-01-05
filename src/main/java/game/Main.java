package game;

import io.*;
import io.impl.*;

/**
 * bootstrap the game engine
 */
public class Main
{
	private static Input input = null;
	private static Display display = null;

	public static void main(String[] args) {
		try {
			bootstrap();
			Engine gameEngine = new Engine(input, display);
			gameEngine.gameOn();
			display.exit();
		} catch (Exception e) {
			display.unexpectedError();
		}
	}

	// bootstrap game dependencies
	private static void bootstrap() {
		// for the sake of this exercise, use default console input/output
		input = new ConsoleInput(System.in);
		display = new ConsoleDisplay(System.out);
	}
}
