package console;

import java.util.ArrayList;

import logic.Drake;
import logic.Eagle;
import logic.Hero;
import logic.Sword;

public class Display {
	/**
	 * Uses the initial maze built by the maze builder and places all the game
	 * elements in their position. It then prints the array's lines one by one
	 * to draw the maze
	 */
	public static void print(char[][] maze, Hero h, ArrayList<Drake> d, Sword s, Eagle e) {
		int N = maze.length;
		char[][] temp = new char[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				// copying the basic maze to the dynamic maze
				temp[i][j] = maze[i][j];

		// places hero
		if (h.hasSword())
			temp[h.getY()][h.getX()] = 'A';
		else
			temp[h.getY()][h.getX()] = 'H';

		// places all possible dragons
		for (int i = 0; i < d.size(); i++) {
			if (d.get(i).isSleeping())
				temp[d.get(i).getY()][d.get(i).getX()] = 'd';
			else
				temp[d.get(i).getY()][d.get(i).getX()] = 'D';
		}

		// places sword checking if it's in same position as dragon
		if (!h.hasSword()) {
			if (temp[s.getY()][s.getX()] == 'D')
				temp[s.getY()][s.getX()] = 'F';
			else if (temp[s.getY()][s.getX()] == 'd')
				temp[s.getY()][s.getX()] = 'f';
			else
				temp[s.getY()][s.getX()] = 'E';
		}
		// maze printing cycle
		for (char[] line : temp) {
			for (char sym : line) {
				System.out.print(sym);
				System.out.print(' ');
			}
			System.out.println();
		}
	}
}
