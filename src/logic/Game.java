package logic;

import java.util.Random;
import java.util.Scanner;
import console.Display;

public class Game {
	public static void main(String[] args) {
		Maze m = new Maze();
		Drake d = new Drake();
		Hero h = new Hero();
		Sword s = new Sword();
		Eagle e = new Eagle();
		System.out.print("Escolha o tamanho do labirinto (0 para default): ");
		Scanner input = new Scanner(System.in);
		int op = 0;
		String mov;
		do {
			op = input.nextInt();
			if (op < 5 && op > 0)
				System.out
						.print("Insira um valor maior que 5 ou 0 para default: ");
		} while (op < 5 && op > 0);
		if (op == 0) {
			m.generateDefault();
		} else {
			m.generateMaze(op);
			placeHero(m, h);
			placeSword(m, s);
			placeDrake(m, d);
		}
		Display.print(m.getMaze());
		do {
			System.out.print("Escolha uma direção (WASD): ");
			mov = input.next();

		} while (mov != "A" && mov != "a" && mov != "W" && mov != "w"
				&& mov != "D" && mov != "d" && mov != "S" && mov != "s");
	}

	public void moveDrake(char[][] maze) {
		Random r = new Random();
		int p = r.nextInt(4);

		switch (p) {

		case 0:
		}
	}

	public static void placeHero(Maze m, Hero h) {
		int[] lc = new int[2];

		lc = m.getFree();

		h.setX(lc[0]);
		h.setY(lc[1]);

		m.maze[lc[0]][lc[1]] = 'H';
	}

	public static void placeSword(Maze m, Sword s) {
		int[] lc = new int[2];

		lc = m.getFree();

		s.setX(lc[0]);
		s.setY(lc[1]);

		m.maze[lc[0]][lc[1]] = 'E';
	}

	public static void placeDrake(Maze m, Drake d) {
		int[] lc = new int[2];

		do {
			lc = m.getFree();

		} while (m.maze[lc[0] + 1][lc[1]] == 'H'
				|| m.maze[lc[0] - 1][lc[1]] == 'H'
				|| m.maze[lc[0]][lc[1] + 1] == 'H'
				|| m.maze[lc[0]][lc[1] - 1] == 'H');

		d.setX(lc[0]);
		d.setY(lc[1]);

		m.maze[lc[0]][lc[1]] = 'D';
	}

	public static void moveHero(Maze m, Hero h, String op) {
		int x = h.getX();
		int y = h.getY();

		switch (op) {
		// para a esquerda
		case "A":
		case "a":
			if (m.maze[y][x - 1] == ' ') {
				m.maze[y][x - 1] = 'H';
				h.setX(x - 1);
			}
			break;
		// para a direita
		case "D":
		case "d":
			if (m.maze[y][x + 1] == ' ') {
				m.maze[y][x + 1] = 'H';
				h.setX(x + 1);
			}
			break;
		// para a cima
		case "W":
		case "w":
			if (m.maze[y - 1][x] == ' ') {
				m.maze[y - 1][x] = 'H';
				h.setY(y - 1);
			}
			break;
		// para a baixo
		case "S":
		case "s":
			if (m.maze[y + 1][x] == ' ') {
				m.maze[y + 1][x] = 'H';
				h.setY(y + 1);
			}
			break;

		}
	}
}
