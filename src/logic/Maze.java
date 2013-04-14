package logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * Represents the Maze
 */
public class Maze implements Serializable {
	private static final long serialVersionUID = 1L;
	public char[][] maze;
	public MazeBuilder mb;

	/**
	 * Returns the maze structure.
	 */
	public char[][] getMaze() {
		return maze;
	}

	/**
	 * Generates a new maze by summoning a new maze builder based on the size of
	 * the maze.
	 * 
	 * @param N
	 *            The size of the maze (0 for default, >6 for randomly generated
	 *            mazes)
	 */
	public void generateMaze(int N) {
		if (N == 0) {
			mb = new MazeBuilderDefault();
			maze = mb.buildMaze(0);
		} else {
			mb = new MazeBuilderN();
			maze = mb.buildMaze(N);
		}
	}

	/**
	 * Finds a free position in the maze. Used to place elements in a free
	 * position.
	 * 
	 * @return Array with a free position
	 */
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

	/**
	 * Fills a temporary maze with all the elements represented by chars to be
	 * printed either in CLI or GUI.
	 * 
	 * @param maze
	 *            Array containing the original maze containing only walls and
	 *            paths.
	 * @param h
	 *            Hero in game.
	 * @param d
	 *            ArrayList containing dragons still in game.
	 * @param s
	 *            Sword in game
	 * @return Returns a temporary maze with all elements represented by
	 *         individual chars.
	 */
	public static char[][] fillMaze(char[][] maze, Hero h, ArrayList<Drake> d,
			Sword s) {
		int N = maze.length;
		char[][] temp = new char[N][N];
		// copies the original maze to the temporary one
		for (int i = 0; i < N; i++) {
			// copying the basic maze to the dynamic maze
			for (int j = 0; j < N; j++) {
				temp[i][j] = maze[i][j];
			}
		}
		if (h.hasEagle()) { // places hero
			if (h.hasSword()) {
				temp[h.getY()][h.getX()] = 'A';
			} else {
				temp[h.getY()][h.getX()] = 'H';
			}
		} else {

			if (h.hasSword()) {
				temp[h.getY()][h.getX()] = 'A';
			} else {
				temp[h.getY()][h.getX()] = 'H';
			}
			// places eagle
			if (!h.e.isDead) {
				temp[h.e.getY()][h.e.getX()] = 'P';
			}
		}
		// places all possible dragons
		for (int i = 0; i < d.size(); i++) {
			if (d.get(i).isSleeping()) {
				temp[d.get(i).getY()][d.get(i).getX()] = 'd';
			} else {
				temp[d.get(i).getY()][d.get(i).getX()] = 'D';
			}
		}
		// places sword checking if it's in same position as dragon and if its
		// being carried by the eagle
		if (!h.hasSword()) {
			if (temp[s.getY()][s.getX()] == 'D' && !h.e.inFlight) {
				temp[s.getY()][s.getX()] = 'F';
			} else if (temp[s.getY()][s.getX()] == 'd' && !h.e.inFlight) {
				temp[s.getY()][s.getX()] = 'f';
			} else if (temp[s.getY()][s.getX()] != 'P') {
				temp[s.getY()][s.getX()] = 'E';
			}
		}
		return temp;
	}

	/**
	 * Calls the necessary functions to build the correct maze according to the
	 * value of N (default maze if N equals 0 or random if different)
	 * 
	 * @param d
	 *            ArrayList containing dragons still in game
	 * @param m
	 *            Original game maze
	 * @param h
	 *            Hero in game
	 * @param s
	 *            Sword in game
	 * @param N
	 *            Maze size
	 */
	public static void BuildMaze(ArrayList<Drake> d, Maze m, Hero h, Sword s,
			int N) {
		if (N == 0) { // default maze
			m.generateMaze(N);
			h.setX(1);
			h.setY(1);
			d.get(0).setX(1);
			d.get(0).setY(3);
			s.setX(1);
			s.setY(8);
		} else { // random maze
			m.generateMaze(N);
			Game.placeElements(m, d, h, s);
		}
	}

}
