package io.impl;

import io.Tiles;

/**
 * alternative {@code Tiles} implementation: 
 * letter tiles with space ({@code ' '}) as the empty tile
 */
public class LetterTiles implements Tiles
{
	private static final String letters = " ABCDEFGHIJKLMNOPQRSTUVWYZ"; // X is for exit 

	@Override
	public String name() {
		return "Letters";
	}

	@Override
	public int tileSize() {
		return 1;
	}

	@Override
	public String getTile(int order) {
		return String.valueOf(letters.charAt(order));
	}

	@Override
	public String getEmptyTile() {
		return " ";
	}

	@Override
	public int getPos(String tile) throws IllegalArgumentException {
		int pos = letters.indexOf(tile.toUpperCase());
		if (pos < 1) throw new IllegalArgumentException("Invalid tile name");
		return pos;
	}
}
