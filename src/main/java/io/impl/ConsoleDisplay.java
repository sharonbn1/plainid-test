package io.impl;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import data.*;
import io.*;
import game.Difficulty;

/**
 * output to a {@code PrintStream} (usually stdout)
 */
public class ConsoleDisplay implements Display
{
	private PrintStream ps;

	private static final String horizontalBorder = "-";
	private static final String verticalBorder = "|";
	private static final String junction = "+";
	private static final String tileDisplay = " %s ";

	/**
	 * construct instance with given stream
	 */
	public ConsoleDisplay(PrintStream ps) {
		this.ps = ps;
	}
	
	@Override
	public void start() {
		ps.println();
		ps.println("Welcome to the 15 Puzzle game!");
		ps.println();
		ps.println("Let's start by choosing difficulty: " + Difficulty.getDescriptions() + ", [X] exit: ");
	}

	@Override
	public void turn(int turnNumber, Board currentBoard, Tiles tiles) {
		ps.println();
		ps.println("Turn: " + turnNumber);
		printBoard(currentBoard, tiles);
		ps.println("Enter tile to move or X to exit: ");
	}

	@Override
	public void victory(int turns, Board currentBoard, Tiles tiles) {
		ps.println();
		ps.println("You've done it! You've finished in " + turns + " turns.");
		printBoard(currentBoard, tiles);
		ps.println();
	}

	@Override
	public void exit() {
		ps.println("goodbye...");
	}

	@Override
	public void inputError() {
		ps.println("Invalid input!");
	}

	@Override
	public void cannotMoveTile() {
		ps.println("Don't cheet! This tile cannot move!");
	}

	@Override
	public void unexpectedError() {
		ps.println("Unexpected error occurred. please restart the game...");
	}

	private void printBoard(Board board, Tiles tiles) {

		int size = board.getSize();
		// create horizontal border of one cell according to size of one tile
		String cellHorizontalBorder = String.join("", Collections.nCopies(tiles.tileSize()+2, horizontalBorder)); 
		// create horizontal border of entire row according to board size
		String boardHorizontalBorder = junction + 
				String.join(junction, Collections.nCopies(size, cellHorizontalBorder)) + junction;
		// print first horizontal border
		ps.println(boardHorizontalBorder);
		// print tile row and horizontal border according to number of rows (board size)
		IntStream.range(0, size).forEach(row -> {
			ps.println(
					// build tile row by collecting all columns
					IntStream.range(0, size)
						.mapToObj(col -> String.format(tileDisplay, getTile(board, row, col, tiles)))
						.collect(Collectors.joining(verticalBorder, verticalBorder, verticalBorder)));
			ps.println(boardHorizontalBorder);
		});
	}

	// get tile value for given row/col (possibly the empty tile)
	private String getTile(Board board, int row, int col, Tiles tiles) {
		int value = board.get(row, col);
		return value == Board.EMPTY ? tiles.getEmptyTile() : tiles.getTile(value);
	}
}
