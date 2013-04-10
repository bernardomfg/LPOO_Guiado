package logic;

import java.io.Serializable;
import java.util.Random;

public class Drake extends Mobile implements Serializable {
	public Boolean sleeping = false;
	public int sleeps = Game.gameMode;


	public void setSleep(Boolean state) {
		sleeping = state;
	}


	public Boolean isSleeping() {
		return sleeping;
	}
	
	public void sleepDrake(Maze m) {
		Random r = new Random();
		int p = r.nextInt(10);

		switch (p) {
		// dormir
		case 0:
		case 1: setSleep(true);
				break;
		default : setSleep(false);
					break;
		}
	}

	public void moveDrake(Maze m) {
		Random r = new Random();

		int p = r.nextInt(4);

		if (!isSleeping()) {
		switch (p) {
		// para a esquerda
		case 0:
			if (m.maze[y][x - 1] != 'X' && m.maze[y][x - 1] != 'S')
				move(0);
			break;
		// para a direita
		case 1:
			if (m.maze[y][x + 1] != 'X' && m.maze[y][x + 1] != 'S')
				move(1);
			break;
		// para a cima
		case 2:
			if (m.maze[y - 1][x] != 'X' && m.maze[y - 1][x] != 'S')
				move(2);
			break;
		// para a baixo
		case 3:
			if (m.maze[y + 1][x] != 'X' && m.maze[y + 1][x] != 'S')
				move(3);
			break;

		}
		}

	}

}
