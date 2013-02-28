package logic;

import java.util.Random;
import java.util.Scanner;
import console.Display;

public class Game {

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Maze m = new Maze();
		Drake d = new Drake();
		Hero h = new Hero();
		Sword s = new Sword();
		Eagle e = new Eagle();
		System.out.print("Escolha o tamanho do labirinto (0 para default): ");
		Scanner input = new Scanner(System.in);
		int op = input.nextInt();
		input.close();
		if(op == 0)
		{
			
		}
		else
		{
			m.generateMaze(op);
		}
		Display.print(m.getMaze());
	}

	public void moveDrake(char[][] maze) {
		Random r = new Random();
		int p = r.nextInt(4);

		switch (p) {

		case 0:
		}
	}

}
