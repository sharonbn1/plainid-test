package io.impl;

import io.Tiles;

/**
 * default {@code Tiles} implementation: 
 * numbered tiles with space ({@code ' '}) as the empty tile
 */
public class NumberTiles implements Tiles
{
	@Override
	public String name() {
		return "Numbers";
	}

	@Override
	public int tileSize() {
		return 2;
	}

	@Override
	public String getTile(int order) {
		return String.format("%2d", order);
	}

	@Override
	public String getEmptyTile() {
		return "  ";  // note: assumes board size is two digits...
	}

	@Override
	public int getPos(String tile) throws IllegalArgumentException {
		try {
			return Integer.parseInt(tile);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Invalid tile name");
		}
	}
}
