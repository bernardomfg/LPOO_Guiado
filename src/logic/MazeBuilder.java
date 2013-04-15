package logic;

import java.io.Serializable;


public abstract class MazeBuilder implements Serializable{
	private static final long serialVersionUID = 1L;

	protected char[][] m;

	/**
	 * @return Returns maze
	 */
	public char[][] getMaze() {
		return m;
	};

	/** Abstract function to be overwritten by the correct constructor according to the value of N 
	 * @param N Maze size
	 * @return Returns built maze
	 */
	public abstract char[][] buildMaze(int N);
}
