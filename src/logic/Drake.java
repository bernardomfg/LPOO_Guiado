package logic;

import java.io.Serializable;
import java.util.Random;

/**
 * Represents the Dragon
 */
public class Drake extends Mobile implements Serializable {
	private static final long serialVersionUID = 1L;
	public Boolean sleeping = false;
	public int sleeps = Game.gameMode;

	/**
	 * Sets drake to sleep
	 * 
	 * @param state
	 *            Boolean indicating whether drake is sleeping or not
	 */
	public void setSleep(Boolean state) {
		sleeping = state;
	}

	/**
	 * Checks if drake is sleeping or not.
	 * 
	 * @return Boolean indicating whether drake is sleeping or not.
	 */
	public Boolean isSleeping() {
		return sleeping;
	}

	/**
	 * Decides if the drake is sleeping or not, according to a random value.
	 */
	public void sleepDrake() {
		Random r = new Random();
		int p = r.nextInt(10);

		switch (p) {
		case 0:
		case 1:
			setSleep(true);
			break;
		default:
			setSleep(false);
			break;
		}
	}

	/**
	 * Moves the drake to a free position in a random direction only if he is
	 * awake
	 * 
	 * @param m
	 *            Original maze containing only the walls and free spaces.
	 */
	public void moveDrake(Maze m) {
		Random r = new Random();
		int p = r.nextInt(4);

		if (!isSleeping()) {
			switch (p) {
			// left
			case 0:
				if (m.maze[y][x - 1] != 'X' && m.maze[y][x - 1] != 'S') {
					move(0);
				}
				break;
			// right
			case 1:
				if (m.maze[y][x + 1] != 'X' && m.maze[y][x + 1] != 'S') {
					move(1);
				}
				break;
			// up
			case 2:
				if (m.maze[y - 1][x] != 'X' && m.maze[y - 1][x] != 'S') {
					move(2);
				}
				break;
			// down
			case 3:
				if (m.maze[y + 1][x] != 'X' && m.maze[y + 1][x] != 'S') {
					move(3);
				}
				break;
			}
		}
	}
}
