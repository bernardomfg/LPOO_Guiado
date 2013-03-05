package logic;

import java.util.Random;
public class Maze {

	public char[][] maze;
	public mazeBuilder mb;
	public char[][] getMaze() {
		return maze;
	}
	
	public void generateMaze(int N) {
		if(N==0)
		{
			mb = new mazeBuilderDefault();
			maze=mb.buildMaze(0);
		}
		else
		{
			mb = new mazeBuilderN();
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
