package logic;

import console.*;

public class Game {
	public static void placeElements(Maze m, Drake[] d, Hero h, Sword s, Eagle e) {
		int[] lc = new int[2];
		lc = m.getFree();

		h.setX(lc[0]);
		h.setY(lc[1]);

		for (int i = 0; i < d.length; i++) {
			while ((lc[0] + 1 == h.getY() && lc[1] == h.getX())
					|| (lc[0] - 1 == h.getY() && lc[1] == h.getX())
					|| (lc[0] == h.getY() && lc[1] + 1 == h.getX())
					|| (lc[0] == h.getY() && lc[1] - 1 == h.getX())
					|| (lc[0] == h.getY() && lc[1] == h.getX())) {
				lc = m.getFree();
			}

			d[i].setX(lc[1]);
			d[i].setY(lc[0]);
		}
		
		while ((lc[0] == h.getY() && lc[1] == h.getX())) {
			lc = m.getFree();
		}
		
		s.setX(lc[1]);
		s.setY(lc[0]);
	}

	public static void main(String[] args) {
		Maze m = new Maze();
		Hero h = new Hero();
		Sword s = new Sword();
		Eagle e = new Eagle();
		String mov;
		int N = Interface.readMazeSize();
		int dN = Interface.readDrakeNumber();
		Drake[] d = new Drake[dN];
		mazeBuilder mb;
		if (N == 0) {
			mb = new mazeBuilderDefault();
			mb.buildMaze(0);
			m.maze = mb.getMaze();
			h.setX(1);
			h.setY(1);
			d[0].setX(1);
			d[0].setY(3);
			s.setX(1);
			s.setY(8);
		} else {
			mb = new mazeBuilderN();
			mb.buildMaze(N);
			m.maze = mb.getMaze();
			placeElements(m, d, h, s, e);
		}
		Display.print(m.getMaze(), mb, h, d, s, e);

		while (true) {
			mov = Interface.readDirection();
			h.moveHero(m, mov);
			Display.print(m.getMaze(), mb, h, d, s, e);
		}
	}
}
