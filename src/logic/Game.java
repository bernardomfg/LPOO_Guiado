package logic;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Game implements Serializable {

	public static int gameMode;

	public static void BuildMaze(ArrayList<Drake> d, Maze m, Hero h, Sword s,
			int N) {

		if (N == 0) {
			m.generateMaze(N);
			h.setX(1);
			h.setY(1);
			d.get(0).setX(1);
			d.get(0).setY(3);
			s.setX(1);
			s.setY(8);
		} else {
			m.generateMaze(N);
			Game.placeElements(m, d, h, s);
		}
	}

	public static void play(String mov, Hero h, Sword s, Maze m,
			ArrayList<Drake> d) {
		if (mov.equals("l") || mov.equals("L")) {
			h.launchEagle();
		} else {
			h.moveHero(m, mov, d);
			if (!h.e.isDead) {
				h.e.moveEagle(s);

			}
		}
		if (gameMode != 1)
			for (int i = 0; i < d.size(); i++) {
				d.get(i).moveDrake(m);
				if (gameMode == 3)
					d.get(i).sleepDrake(m);
			}
		if (!h.hasSword() && !h.e.inFlight)
			Game.checkSword(h, s);
	}

	public static void placeElements(Maze m, ArrayList<Drake> d, Hero h, Sword s) {
		int[] lc = new int[2];
		int[] lc1 = new int[2];
		int[] lc2 = new int[2];
		lc = m.getFree();
		h.setX(lc[1]);
		h.setY(lc[0]);
		lc1 = m.getFree();
		for (int i = 0; i < d.size(); i++) {
			while ((lc1[0] + 1 == h.getY() && lc1[1] == h.getX())
					|| (lc1[0] - 1 == h.getY() && lc1[1] == h.getX())
					|| (lc1[0] == h.getY() && lc1[1] + 1 == h.getX())
					|| (lc1[0] == h.getY() && lc1[1] - 1 == h.getX())
					|| (lc1[0] == h.getY() && lc1[1] == h.getX())) {
				lc1 = m.getFree();

			}
			d.get(i).setX(lc1[1]);
			d.get(i).setY(lc1[0]);
			lc1 = new int[2];
			lc1 = m.getFree();
		}
		lc2 = m.getFree();
		while ((lc2[0] == h.getY() && lc2[1] == h.getX())) {
			lc2 = m.getFree();
		}
		s.setX(lc2[1]);
		s.setY(lc2[0]);
	}

	public static void checkSword(Hero h, Sword s) {
		if (h.getX() == s.getX() && h.getY() == s.getY()) {
			h.sword = true;
			h.e.kill();
		}
	}

	public static Boolean checkDead(Hero h, ArrayList<Drake> d) {
		Boolean isDead = false;
		for (int i = 0; i < d.size(); i++) {

			if (!h.e.isDead) {
				if (h.e.getY() + 1 == d.get(i).getY()
						&& h.e.getX() == d.get(i).getX()) {
					if (!d.get(i).isSleeping() && !h.e.inFlight)
						h.e.kill();
				} else if (h.e.getY() - 1 == d.get(i).getY()
						&& h.e.getX() == d.get(i).getX()) {
					if (!d.get(i).isSleeping() && !h.e.inFlight)
						h.e.kill();
				} else if (h.e.getY() == d.get(i).getY()
						&& h.e.getX() + 1 == d.get(i).getX()) {
					if (!d.get(i).isSleeping() && !h.e.inFlight)
						h.e.kill();
				} else if (h.e.getY() == d.get(i).getY()
						&& h.e.getX() - 1 == d.get(i).getX()) {
					if (!d.get(i).isSleeping() && !h.e.inFlight)
						h.e.kill();
				} else if (h.e.getY() == d.get(i).getY()
						&& h.e.getX() == d.get(i).getX()) {
					if (!d.get(i).isSleeping() && !h.e.inFlight)
						h.e.kill();
				}
			}

			if (h.getY() + 1 == d.get(i).getY() && h.getX() == d.get(i).getX()) {
				if (!h.hasSword() && !d.get(i).isSleeping()) {
					isDead = true;
					break;
				} else if (h.hasSword()) {
					d.remove(i);
					if (i > 0)
						i--;
				}
			} else if (h.getY() - 1 == d.get(i).getY()
					&& h.getX() == d.get(i).getX()) {
				if (!h.hasSword() && !d.get(i).isSleeping()) {
					isDead = true;
					break;
				} else if (h.hasSword()) {
					d.remove(i);
					if (i > 0)
						i--;
				}
			} else if (h.getY() == d.get(i).getY()
					&& h.getX() + 1 == d.get(i).getX()) {
				if (!h.hasSword() && !d.get(i).isSleeping()) {
					isDead = true;
					break;
				} else if (h.hasSword()) {
					d.remove(i);
					if (i > 0)
						i--;
				}
			} else if (h.getY() == d.get(i).getY()
					&& h.getX() - 1 == d.get(i).getX()) {
				if (!h.hasSword() && !d.get(i).isSleeping()) {
					isDead = true;
					break;
				} else if (h.hasSword()) {
					d.remove(i);
					if (i > 0)
						i--;
				}
			} else if (h.getY() == d.get(i).getY()
					&& h.getX() == d.get(i).getX()) {
				if (!h.hasSword() && !d.get(i).isSleeping()) {
					isDead = true;
					break;
				} else if (h.hasSword()) {
					d.remove(i);
					if (i > 0)
						i--;
				}
			}

		}

		if (isDead) {
			return true;
		} else
			return false;
	}
}
