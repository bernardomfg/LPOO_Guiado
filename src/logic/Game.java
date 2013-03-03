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
			d.placeDrake(m);
		}
		Display.print(m.getMaze());

		while (true) {
			do {
				System.out.print("Escolha uma direção (WASD): ");
				mov = input.next();
			} while (mov != "A" && mov != "a" && mov != "W" && mov != "w"
					&& mov != "D" && mov != "d" && mov != "S" && mov != "s");

			h.moveHero(m, mov);
			Display.print(m.getMaze());
		}
	}
}
