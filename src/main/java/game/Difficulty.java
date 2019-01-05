package game;

import java.util.*;
import java.util.stream.*;

import io.*;
import io.impl.*;

/**
 * Difficulty settings
 * TODO: version 2: load settings from external file  
 * TODO: version 2: support custom difficulty (custom board size...) 
 */
public enum Difficulty
{
	Beginner("[B]eginner (3x3)", 3, new NumberTiles()),
	Normal("[N]ormal (4x4)", 4, new NumberTiles()),
	Hard("[H]ard (4x4 letters)", 4, new LetterTiles());

	public String description;
	public int size;
	public Tiles tiles;

	Difficulty(String description, int size, Tiles tiles) {
		this.description = description;
		this.size = size;
		this.tiles = tiles;
	}

	/**
	 * translate user input to Difficulty 
	 * @param userInput {@code String} user input  
	 * @return {@code Difficulty} enum instance
	 * @throws IllegalArgumentException if user input cannot be translated
	 */
	public static Difficulty getUserChoice(String userInput) throws IllegalArgumentException {
		return Arrays.stream(Difficulty.values())
				.filter(diff -> diff.toString().substring(0, 1).equalsIgnoreCase(userInput))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("invalid difficulty indicator"));
	}

	/**
	 * get description of all difficulties (e.g. for display)
	 * @return {@code String} description of all difficulties
	 */
	public static String getDescriptions() {
		return Arrays.stream(Difficulty.values())
				.map(diff -> diff.description)
				.collect(Collectors.joining(", "));
	}
}
