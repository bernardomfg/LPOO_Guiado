package logic;

import java.io.Serializable;
import java.util.Random;
/**
 * @author wilson
 *
 */
public class Maze implements Serializable {

	public char[][] maze;
	public MazeBuilder mb;
	public char[][] getMaze() {
		return maze;
	}
	
	/**
	 * @param N
	 */
	public void generateMaze(int N) {
		if(N==0)
		{
			mb = new MazeBuilderDefault();
			maze=mb.buildMaze(0);
		}
		else
		{
			mb = new MazeBuilderN();
			maze=mb.buildMaze(N);
		}
	}

	public int[] getFree() {
		int N = maze.length;
		int[] lc = new int[2];
		Random r = new Random();
		int i = r.nextInt(N - 3) + 1;
		int j = r.nextInt(N - 3) + 1;

		while (maze[i][j] != ' ') {
			i = r.nextInt(N - 3) + 1;
			j = r.nextInt(N - 3) + 1;
		}
		lc[0] = i;
		lc[1] = j;

		return lc;
	}

}
