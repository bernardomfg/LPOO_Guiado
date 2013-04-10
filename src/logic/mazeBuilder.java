package logic;

import java.io.Serializable;

public abstract class MazeBuilder implements Serializable{
	protected char[][] m;

	public char[][] getMaze() {
		return m;
	};

	public abstract char[][] buildMaze(int N);
}
