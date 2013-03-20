package logic;

import java.util.ArrayList;
import console.*;

public class Game {
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

	public static void main(String[] args) {
		Maze m = new Maze();
		Hero h = new Hero();
		Sword s = new Sword();
		String mov;
		Boolean gameOver = false;
		int N = Interface.readMazeSize();
		int dN = 1;
		if (N != 0)
			dN = Interface.readDrakeNumber();
		ArrayList<Drake> d = new ArrayList<Drake>();
		for (int i = 0; i < dN; i++) {
			d.add(new Drake());
		}
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
			placeElements(m, d, h, s);
		}
		Display.print(m.getMaze(), h, d, s);

		while (!gameOver) {
			if (h.hasEagle())
				mov = Interface.readDirectionEagle();
			else
				mov = Interface.readDirection();
			if (mov.equals("l") || mov.equals("L"))
			{
				h.launchEagle();
			}
			else {
				h.moveHero(m, mov);
				h.e.moveEagle(s);
				if (h.e.hasSword)
				{
					s.setX(h.e.getX());
					s.setY(h.e.getY());
				}
			}
			for (int i = 0; i < d.size(); i++) {
				d.get(i).moveDrake(m);
			}
			if (!h.hasSword() && !h.e.inFlight)
				checkSword(h, s);
			Display.print(m.getMaze(), h, d, s);
			if (checkDead(h, d)) {
				Interface.lostTheGame();
				gameOver = true;
			}
			if (h.atExit) {
				Interface.wonTheGame();
				gameOver = true;
			}
		}
	}

	private static void checkSword(Hero h, Sword s) {
		if (h.getX() == s.getX() && h.getY() == s.getY()) {
			h.sword = true;
		} else
			h.sword = false;
	}

	public static Boolean checkDead(Hero h, ArrayList<Drake> d) {
		Boolean isDead = false;
		for (int i = 0; i < d.size(); i++) {
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
			}
		}
		if (isDead) {
			return true;
		} else
			return false;
	}

}
