package logic;

import java.io.Serializable;


public abstract class MazeBuilder implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * @param m Array containing the maze
	 */
	protected char[][] m;

	/**
	 * @return Returns maze
	 */
	public char[][] getMaze() {
		return m;
	};

	/** Abstract function to be overwritten by the correct constructor according to the value of N 
	 * @param N Maze size
	 * @return
	 */
	public abstract char[][] buildMaze(int N);
}
