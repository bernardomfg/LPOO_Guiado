package logic;

import console.*;

public class Game {
	public static void main(String[] args) {
		Maze m = new Maze();
		Drake d = new Drake();
		Hero h = new Hero();
		Sword s = new Sword();
		Eagle e = new Eagle();
		String mov;
		int op = Interface.readMazeSize();
		if (op == 0) {
			m.generateDefault();
			h.setX(1);
			h.setY(1);
			d.setX(1);
			d.setY(3);
			s.setX(1);
			s.setY(8);
		} else {
			m.generateMaze(op);
			h.placeHero(m);
			s.placeSword(m);
			d.placeDrake(m,h);
		}
		Display.print(m.getMaze(),h,d,s,e);

		while (true) {
			mov = Interface.readDirection();
			h.moveHero(m, mov);
			Display.print(m.getMaze(),h,d,s,e);
		}
	}
}
