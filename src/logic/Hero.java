package logic;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Represents the Hero
 */
public class Hero extends Mobile implements Serializable {
	private static final long serialVersionUID = 1L;
	public Boolean sword = false;
	public Boolean eagle = true;
	public Boolean atExit = false;
	public Eagle e;

	/**
	 * Hero constructor. Generates his eagle.
	 */
	public Hero() {
		e = new Eagle();
	}

	/**
	 * Checks if hero has the Sword
	 */
	public Boolean hasSword() {
		return sword;
	}

	/**
	 * Checks if hero has the Eagle
	 */
	public Boolean hasEagle() {
		return eagle;
	}

	/**
	 * Sets the Eagle in motion to get the Sword
	 */
	public void launchEagle() {
		e.motion = 1;
		e.setX(x);
		e.setY(y);
		e.xIn = x;
		e.yIn = y;
		eagle = false;
		e.inFlight = true;
	}

	/**
	 * Moves the hero and checks for walls and if the hero is at the exit and
	 * wins the game (has sword and has killed all dragons)
	 * 
	 * @param m
	 *            The Maze
	 * @param op
	 *            "W" for up "S" for down "A" for left "D" for right
	 * @param d
	 *            The Dragon ArrayList
	 */
	public void moveHero(Maze m, String op, ArrayList<Drake> d) {
		int x = getX();
		int y = getY();

		switch (op) {
		// para a esquerda
		case "A":
		case "a":
			if (m.maze[y][x - 1] == ' ') {
				move(0);
			}
			if (m.maze[y][x - 1] == 'S' && d.isEmpty()) {
				atExit = true;
			}
			break;
		// para a direita
		case "D":
		case "d":
			if (m.maze[y][x + 1] == ' ') {
				move(1);
			}
			if (m.maze[y][x + 1] == 'S' && d.isEmpty()) {
				atExit = true;
			}
			break;
		// para a cima
		case "W":
		case "w":
			if (m.maze[y - 1][x] == ' ') {
				move(2);
			}
			if (m.maze[y - 1][x] == 'S' && d.isEmpty()) {
				atExit = true;
			}
			break;
		// para a baixo
		case "S":
		case "s":
			if (m.maze[y + 1][x] == ' ') {
				move(3);
			}
			if (m.maze[y + 1][x] == 'S' && d.isEmpty()) {
				atExit = true;
			}
			break;
		}
	}
}
