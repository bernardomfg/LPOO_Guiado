package console;

import logic.Drake;
import logic.Eagle;
import logic.Hero;
import logic.Sword;

public class Display {
	public static void print(char[][] maze, Hero h, Drake d, Sword s, Eagle e) {
		int N = maze.length;
		char[][] temp = new char[N][N];

		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) {
				temp[i][j] = maze[i][j];
			}
		temp[h.getY()][h.getX()] = 'H';
		temp[d.getY()][d.getX()] = 'D';
		temp[s.getY()][s.getX()] = 'E';
		for (char[] line : temp) {
			for (char sym : line) {
				System.out.print(sym);
				System.out.print(' ');
			}
			System.out.println();
		}
	}
}
