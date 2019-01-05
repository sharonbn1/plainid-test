package io.impl;

import java.io.*;
import java.util.*;

import io.*;

/**
 * input from character based {@code InputStream} (usually stdin)
 */
public class ConsoleInput implements Input
{
	private Scanner scanner;

	/**
	 * construct instance with given stream
	 */
	public ConsoleInput(InputStream is) {
		scanner = new Scanner(is);
	}

	@Override
	public String difficulty() {
		return scanner.next();
	}

	@Override
	public String turn() {
		return scanner.next();
	}
}
