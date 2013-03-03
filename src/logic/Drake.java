package logic;

import java.util.Random;

public class Drake extends Mobile {
	public Boolean alive = true;
	public Boolean sleeping = false;

	public void kill() {
		alive = false;
	}

	public void setSleep(Boolean state) {
		sleeping = state;
	}

	public Boolean isAlive() {
		return alive;
	}

	public Boolean isSleeping() {
		return sleeping;
	}
	
	public void placeDrake(Maze m) {
		int[] lc = new int[2];

		do {
			lc = m.getFree();

		} while (m.maze[lc[0] + 1][lc[1]] == 'H'
				|| m.maze[lc[0] - 1][lc[1]] == 'H'
				|| m.maze[lc[0]][lc[1] + 1] == 'H'
				|| m.maze[lc[0]][lc[1] - 1] == 'H');

		setX(lc[0]);
		setY(lc[1]);

		m.maze[lc[0]][lc[1]] = 'D';
	}
	
	public void moveDrake(char[][] maze) {
		Random r = new Random();
		int p = r.nextInt(4);

		switch (p) {

		case 0:
		}
	}

}
