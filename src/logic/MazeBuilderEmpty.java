package logic;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MazeBuilderEmpty extends MazeBuilder implements Serializable {

	@Override
	public char[][] buildMaze(int N) {
		char[][] temp;
		temp = new char[N][N];
		int y = 0;
		int x = 0;
		for (y = 0; y < N; y++)
			for (x = 0; x < N; x++) {

				if (y % 2 == 0 || x % 2 == 0) {
					temp[y][x] = 'X';
				} else {
					temp[y][x] = ' ';
				}
			}
		return temp;
	}

}
