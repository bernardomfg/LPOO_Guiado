package logic;



import java.util.Random;
import java.util.Stack;
import java.util.Vector;

public class Maze {

	public char[][] maze;

	public char[][] getMaze() {
		return maze;
	}

	public Boolean Unvisited(Boolean[][] visited) {
		int N = maze.length;

		for (int y = 0; y < N; y++)
			for (int x = 0; x < N; x++) {
				if (visited[y][x] == false)
					return true;
			}
		return false;
	}

	public int[] chooseRandom(Boolean[][] visited) {
		int N = maze.length;
		int[] lc = new int[3];

		for (int y = 0; y < N; y++)
			for (int x = 0; x < N; x++) {
				if (visited[y][x] == false) {
					lc[0] = y;
					lc[1] = x;
					visited[y][x] = true;
					return lc;
				}

			}

		return null;

	}

	public void generateMaze(int N) {

		// Variables
		Random r = new Random();
		Boolean[][] visited;
		int y = 0;
		int x = 0;
		int z = 0;
		int[] lc = new int[3];
		int[] lc_aux1 = new int[3];
		int[] lc_aux2 = new int[3];
		int[] lc_aux3 = new int[3];
		int[] lc_aux4 = new int[3];
		Vector<int[]> neighbours = new Vector<int[]>();
		Stack<int[]> paths = new Stack<int[]>();
		// Reading maze size from user

		// Initialising empty maze

		if (N % 2 == 0)
			N--;
		maze = new char[N][N];
		visited = new Boolean[N][N];

		for (y = 0; y < N; y++)
			for (x = 0; x < N; x++) {

				if (y % 2 == 0 || x % 2 == 0) {
					maze[y][x] = 'X';
					visited[y][x] = true;
				} else {
					maze[y][x] = ' ';
					visited[y][x] = false;
				}
			}

		y = r.nextInt(N - 3) + 1;
		if (y % 2 == 0)
			y--;
		x = r.nextInt(4);
		switch (x) {
		// esquerda
		case 0:
			maze[y][0] = 'S';
			lc[0] = y;
			lc[1] = 1;
			break;
		// direita
		case 1:
			maze[y][N - 1] = 'S';
			lc[0] = y;
			lc[1] = N - 2;
			break;
		// cima
		case 2:
			maze[0][y] = 'S';
			lc[0] = 1;
			lc[1] = y;
			break;
		// baixo
		case 3:
			maze[N - 1][y] = 'S';
			lc[0] = N - 2;
			lc[1] = y;
			break;
		}

		

		visited[lc[0]][lc[1]] = true;

		Boolean neighbour = false;

		while (Unvisited(visited)) {
			neighbour = false;

			// a esquerda
			if (lc[1] > 2) {
				if (visited[lc[0]][lc[1] - 2] == false) {
					lc_aux1[0] = lc[0];
					lc_aux1[1] = lc[1] - 2;
					lc_aux1[2] = 0;
					neighbours.addElement(lc_aux1.clone());
					neighbour = true;
				}

			}
			// a direita
			if (lc[1] < N - 3) {
				if (visited[lc[0]][lc[1] + 2] == false) {
					lc_aux2[0] = lc[0];
					lc_aux2[1] = lc[1] + 2;
					lc_aux2[2] = 1;
					neighbours.addElement(lc_aux2.clone());
					neighbour = true;
				}

			}
			// para cima
			if (lc[0] > 2) {
				if (visited[lc[0] - 2][lc[1]] == false) {
					lc_aux3[0] = lc[0] - 2;
					lc_aux3[1] = lc[1];
					lc_aux3[2] = 2;
					neighbours.addElement(lc_aux3.clone());
					neighbour = true;
				}

			}
			// para baixo
			if (lc[0] < N - 3) {
				if (visited[lc[0] + 2][lc[1]] == false) {
					lc_aux4[0] = lc[0] + 2;
					lc_aux4[1] = lc[1];
					lc_aux4[2] = 3;
					neighbours.addElement(lc_aux4.clone());
					neighbour = true;
				}

			}

			if (neighbour) {
				z = r.nextInt(neighbours.size());
				paths.push(lc.clone());
				lc = neighbours.get(z);
				neighbours.clear();
				visited[lc[0]][lc[1]] = true;
				
				switch (lc[2]) {
				// a esquerda
				case 0:
					maze[lc[0]][lc[1] + 1] = ' ';
					break;
				// a direita
				case 1:
					maze[lc[0]][lc[1] - 1] = ' ';
					break;
				// para cima
				case 2:
					maze[lc[0] + 1][lc[1]] = ' ';
					break;
				// para baixo
				case 3:
					maze[lc[0] - 1][lc[1]] = ' ';
					break;
				}
			} else {
				if (!paths.empty()) {
					lc = paths.pop();
				} else {
					lc = chooseRandom(visited);
				}
			}
			//Display.print(maze);
			//System.out.println();
		}
	}
}
