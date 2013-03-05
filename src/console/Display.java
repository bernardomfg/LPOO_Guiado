package console;

import logic.Drake;
import logic.Eagle;
import logic.Hero;
import logic.Sword;

public class Display {
	public static void print(char[][] maze, Hero h, Drake d, Sword s, Eagle e) {
		char [][] temp = maze.clone();
		temp[h.getY()][h.getX()]='H';
		temp[d.getY()][d.getX()]='D';
		temp[s.getY()][s.getX()]='E';
		for (char[] line : temp) {
			for (char sym : line) {
				System.out.print(sym);
				System.out.print(' ');
			}
			System.out.println();
		}
	}
}
