package console;

import java.util.ArrayList;

import logic.Drake;
import logic.Hero;
import logic.Maze;
import logic.Sword;

/** Handles the prints in the console. */
public class DisplayConsole {

	/**
	 * Receives the maze, the hero, the dragon ArrayList and the sword and
	 * displays them in place in the console.
	 * 
	 * @param maze
	 *            The maze
	 * @param h
	 *            The hero
	 * @param d
	 *            The dragon ArrayList
	 * @param s
	 *            The sword
	 */
	public static void print(char[][] maze, Hero h, ArrayList<Drake> d, Sword s) {

		char[][] temp = Maze.fillMaze(maze, h, d, s);
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
