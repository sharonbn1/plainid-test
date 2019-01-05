package data.impl;

import java.util.*;
import java.util.stream.*;

import data.*;

/**
 * board implementation using one dimension array.<br>
 * one dimension array is easy to traverse and set/get values.<br>
 * translation from/to x/y coordinates is easy enough
 */
public class ArrayBoard implements Board
{
	private int   size;
	private int[] flatGrid;

	public ArrayBoard(int size) {
		this.size = size;
	}

	@Override
	public void shuffle() {
		setComplete();  // fill the grid in order
		Random rnd = new Random();
		// replace each cell with random position
		IntStream.range(0, flatGrid.length)
				.forEach(i -> swap(i, rnd.nextInt(flatGrid.length)));
	}

	@Override
	public void setComplete() {
		flatGrid = IntStream.range(0, size*size)
				.map(i -> i+1)
				.toArray();
		flatGrid[size*size-1] = 0;
	}

	@Override
	public int getSize() { return size; }

	@Override
	public int get(int row, int col) throws ArrayIndexOutOfBoundsException {
		if (row >= size || col >= size) throw new ArrayIndexOutOfBoundsException();
		return flatGrid[row*size+col];
	}
	
	@Override
	public boolean move(int value) throws IllegalArgumentException {
		int valuePos = locate(value);
		int emptyPos = locate(EMPTY);
		if (areAdjacent(valuePos, emptyPos)) {
			swap(valuePos, emptyPos);
			return true;
		}
		return false;
	}

	@Override
	public boolean isComplete() {
		// note: this check skips empty place 
		return IntStream.range(0, size*size-1)
				.allMatch(i -> flatGrid[i] == i+1);
	}

	// locate given value in grid
	// @throws IllegalArgumentException if value not found
	private int locate(int value) throws IllegalArgumentException {
		return IntStream.range(0, size*size)
				.filter(i -> flatGrid[i] == value)
				.findFirst().orElseThrow(() -> new IllegalArgumentException("tile value out of range"));
	}

	// translate one-dimensional array position to row in two-dimensional grid 
	private int row(int pos) { return pos / size; }
	// translate one-dimensional array position to column in two-dimensional grid 
	private int col(int pos) { return pos % size; }

	// positions are adjacent if they are on the same row and on adjacent columns
	// or are on the same column and on adjacent rows
	private boolean areAdjacent(int pos1, int pos2) { 
		return row(pos1) == row(pos2) && Math.abs(col(pos1) - col(pos2)) == 1  || 
				col(pos1) == col(pos2) && Math.abs(row(pos1) - row(pos2)) == 1;
	}

	// swap values of given positions
	private void swap(int pos1, int pos2) { 
		int temp = flatGrid[pos1];
		flatGrid[pos1] = flatGrid[pos2];
		flatGrid[pos2] = temp;
	}

}
