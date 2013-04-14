package logic;

import java.io.Serializable;
import java.util.Random;
import java.util.Stack;
import java.util.Vector;

public class MazeBuilderN extends MazeBuilder implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * Builds a random maze according to given N (size)
	 * 
	 * @param N
	 *            maze size
	 * 
	 * @return Returns the built maze
	 */
	public char[][] buildMaze(int N) {
		char[][] temp;
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

		// Initialising empty maze ready for backtracker algorithm

		if (N % 2 == 0) {
			N--;
		}
		temp = new char[N][N];
		visited = new Boolean[N][N];

		for (y = 0; y < N; y++) {
			for (x = 0; x < N; x++) {
				if (y % 2 == 0 || x % 2 == 0) {
					temp[y][x] = 'X';
					visited[y][x] = true;
				} else {
					temp[y][x] = ' ';
					visited[y][x] = false;
				}
			}
		}

		y = r.nextInt(N - 3) + 1;
		if (y % 2 == 0) {
			y--;
		}
		x = r.nextInt(4);
		switch (x) { // places the exit in one of the walls
		// left
		case 0:
			temp[y][0] = 'S';
			lc[0] = y;
			lc[1] = 1;
			break;
		// right
		case 1:
			temp[y][N - 1] = 'S';
			lc[0] = y;
			lc[1] = N - 2;
			break;
		// up
		case 2:
			temp[0][y] = 'S';
			lc[0] = 1;
			lc[1] = y;
			break;
		// down
		case 3:
			temp[N - 1][y] = 'S';
			lc[0] = N - 2;
			lc[1] = y;
			break;
		}

		visited[lc[0]][lc[1]] = true; // sets the first cell as visited

		Boolean neighbour = false; // checks if there is cell available to build

		while (unvisited(visited, temp)) { // runs as long as there is unvisited
											// cells in maze
			neighbour = false;
			if (lc[1] > 2) { // checks available cells around current cell
				if (visited[lc[0]][lc[1] - 2] == false) {
					lc_aux1[0] = lc[0];
					lc_aux1[1] = lc[1] - 2;
					lc_aux1[2] = 0;
					neighbours.addElement(lc_aux1.clone());
					neighbour = true;
				}
			}
			// right
			if (lc[1] < N - 3) {
				if (visited[lc[0]][lc[1] + 2] == false) {
					lc_aux2[0] = lc[0];
					lc_aux2[1] = lc[1] + 2;
					lc_aux2[2] = 1;
					neighbours.addElement(lc_aux2.clone());
					neighbour = true;
				}
			}
			// up
			if (lc[0] > 2) {
				if (visited[lc[0] - 2][lc[1]] == false) {
					lc_aux3[0] = lc[0] - 2;
					lc_aux3[1] = lc[1];
					lc_aux3[2] = 2;
					neighbours.addElement(lc_aux3.clone());
					neighbour = true;
				}
			}
			// down
			if (lc[0] < N - 3) {
				if (visited[lc[0] + 2][lc[1]] == false) {
					lc_aux4[0] = lc[0] + 2;
					lc_aux4[1] = lc[1];
					lc_aux4[2] = 3;
					neighbours.addElement(lc_aux4.clone());
					neighbour = true;
				}
			}
			if (neighbour) { // if an available neighbour is found
				z = r.nextInt(neighbours.size());
				// chooses one of the neighbours to continue the path
				paths.push(lc.clone()); // push the current cell into a stack
				lc = neighbours.get(z);
				neighbours.clear();
				visited[lc[0]][lc[1]] = true;
				switch (lc[2]) { // draws the path
				// left
				case 0:
					temp[lc[0]][lc[1] + 1] = ' ';
					break;
				// right
				case 1:
					temp[lc[0]][lc[1] - 1] = ' ';
					break;
				// up
				case 2:
					temp[lc[0] + 1][lc[1]] = ' ';
					break;
				// down
				case 3:
					temp[lc[0] - 1][lc[1]] = ' ';
					break;
				}
			} else {
				if (!paths.empty()) { // when it can't progress, gets a position
										// from the stack to create a new path
					lc = paths.pop();
				} else {
					lc = chooseRandom(visited, temp);
					// if the stack is empty choose a random unvisited cell to
					// create a new path
				}
			}
		}
		return temp;
	}

	/**
	 * Checks for any unvisited cells
	 * 
	 * @param visited
	 *            Array containing booleans indicating if a cell has been
	 *            visited before
	 * @param temp
	 *            the array where the maze is built
	 * @return Returns a boolean indicating if there are unvisited cells in the
	 *         maze
	 */
	public Boolean unvisited(Boolean[][] visited, char[][] temp) {
		int N = temp.length;

		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (visited[y][x] == false)
					return true;
			}
		}
		return false;
	}

	/**
	 * Chooses a random unvisited cell in the maze
	 * 
	 * @param visited
	 *            Array containing booleans indicating if a cell has been
	 *            visited before
	 * @param temp
	 *            the array where the maze is built
	 * @return Returns an array containing the coordinates in the maze to the
	 *         unvisited cell
	 */
	public int[] chooseRandom(Boolean[][] visited, char[][] temp) { // choose
																	// random
																	// unvisited
		// cell
		int N = temp.length;
		int[] lc = new int[3];

		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (visited[y][x] == false) {
					lc[0] = y;
					lc[1] = x;
					visited[y][x] = true;
					return lc;
				}
			}
		}
		return null;
	}
}
