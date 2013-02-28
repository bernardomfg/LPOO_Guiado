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
			placeHero(m, h);
			placeSword(m, s);
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
	
	public static void placeHero(Maze m, Hero h)
	{
		int[] lc = new int[2];
		
		
		lc = m.getFree();
		
		h.setX(lc[0]);
		h.setY(lc[1]);
		
		m.maze[lc[0]][lc[1]] = 'H';
	}
	
	public static void placeSword(Maze m, Sword s)
	{
		int[] lc = new int[2];
		
		lc = m.getFree();
		
		s.setX(lc[0]);
		s.setY(lc[1]);
		
		m.maze[lc[0]][lc[1]] = 'E';
	}

}
