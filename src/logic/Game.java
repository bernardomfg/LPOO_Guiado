package logic;

import console.Display;
import java.util.Random;

public class Game {

	public void main() {
		Maze m = new Maze();
		Drake d = new Drake();
		Hero h = new Hero();
		Sword s = new Sword();
		Eagle e = new Eagle();
		m.generateMaze();
	}

	public void moveDrake(char[][] maze) {
		Random r = new Random();
		int p = r.nextInt(4);

		switch (p) {

		case 0:
		}
	}
}
