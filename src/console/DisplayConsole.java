package console;

import java.util.ArrayList;

import logic.Drake;
import logic.Hero;
import logic.Sword;

public class DisplayConsole {

	public static void print(char[][] maze, Hero h, ArrayList<Drake> d, Sword s) {

		char[][] temp = fillMaze(maze, h, d, s);
		// maze printing cycle
		for (char[] line : temp) {
			for (char sym : line) {
				System.out.print(sym);
				System.out.print(' ');
			}
			System.out.println();
		}
	}

	public static char[][] fillMaze(char[][] maze, Hero h, ArrayList<Drake> d,
			Sword s) {

		int N = maze.length;

		char[][] temp = new char[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				// copying the basic maze to the dynamic maze
				temp[i][j] = maze[i][j];
		// places hero
		if (h.hasEagle()) {
			if (h.hasSword())
				temp[h.getY()][h.getX()] = 'A';
			else
				temp[h.getY()][h.getX()] = 'H';
		} else {

			if (h.hasSword())
				temp[h.getY()][h.getX()] = 'A';
			else
				temp[h.getY()][h.getX()] = 'H';

			if (!h.e.isDead)
				temp[h.e.getY()][h.e.getX()] = 'P';
		}
		// places all possible dragons
		for (int i = 0; i < d.size(); i++) {
			if (d.get(i).isSleeping())
				temp[d.get(i).getY()][d.get(i).getX()] = 'd';
			else
				temp[d.get(i).getY()][d.get(i).getX()] = 'D';
		}
		// places sword checking if it's in same position as dragon
		if (!h.hasSword()) {
			if (temp[s.getY()][s.getX()] == 'D' && !h.e.inFlight)
				temp[s.getY()][s.getX()] = 'F';
			else if (temp[s.getY()][s.getX()] == 'd' && !h.e.inFlight)
				temp[s.getY()][s.getX()] = 'f';
			else if (temp[s.getY()][s.getX()] != 'P')
				temp[s.getY()][s.getX()] = 'E';
		}
		return temp;
	}

}
