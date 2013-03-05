package console;

import logic.Drake;
import logic.Eagle;
import logic.Hero;
import logic.Sword;
import logic.mazeBuilder;

public class Display {
	public static void print(char[][] maze, mazeBuilder mb, Hero h, Drake[] d,
			Sword s, Eagle e) {

		maze = mb.getMaze();
		maze[h.getY()][h.getX()] = 'H';
		for (int i = 0; i < d.length; i++) {
			maze[d[i].getY()][d[i].getX()] = 'D';
		}
		
		if (maze[s.getY()][s.getX()] == 'D')
			maze[s.getY()][s.getX()] = 'F';
		else
			maze[s.getY()][s.getX()] = 'E';
		
		for (char[] line : maze) {
			for (char sym : line) {
				System.out.print(sym);
				System.out.print(' ');
			}
			System.out.println();
		}
	}
}
