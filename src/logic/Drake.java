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
	
	public void placeDrake(Maze m, Hero h) {
		int[] lc = new int[2];

		do {
			lc = m.getFree();

		} while ((lc[0] + 1 == h.getY() && lc[1] == h.getX())
				|| (lc[0] - 1 == h.getY() && lc[1] == h.getX())
				|| (lc[0] == h.getY() && lc[1] + 1 == h.getX())
				|| (lc[0] == h.getY() && lc[1] - 1 == h.getX()));

		setX(lc[0]);
		setY(lc[1]);
	}
	
	public void moveDrake(char[][] maze) {
		Random r = new Random();
		int p = r.nextInt(4);

		switch (p) {

		case 0:
		}
	}

}
