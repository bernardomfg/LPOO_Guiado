package logic;

import java.io.Serializable;

public class MazeBuilderDefault extends MazeBuilder implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * Builds the default maze
	 * 
	 * @return Returns the built maze
	 */
	public char[][] buildMaze(int N) {
		char[][] temp = { { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
				{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
				{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', 'S' },
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
				{ 'X', ' ', 'X', 'X', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };

		return temp;
	}
}
