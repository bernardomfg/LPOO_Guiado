package interfaces;

import java.util.ArrayList;
import logic.Drake;
import logic.Hero;
import logic.Sword;

public abstract class Display {
	/**
	 * Uses the initial maze built by the maze builder and places all the game
	 * elements in their position. It then prints the array's lines one by one
	 * to draw the maze
	 */
	public abstract void print(char[][] maze, Hero h, ArrayList<Drake> d, Sword s);
}
