package logic;

import console.*;

public class Game {
	public static void placeElements(Maze m, Drake[] d, Hero h, Sword s, Eagle e) {
		int[] lc = new int[2];
		int[] lc1 = new int[2];
		int[] lc2 = new int[2];
		lc = m.getFree();

		h.setX(lc[1]);
		h.setY(lc[0]);

		lc1 = m.getFree();
		for (int i = 0; i < d.length; i++) {
			while ((lc1[0] + 1 == h.getY() && lc1[1] == h.getX())
					|| (lc1[0] - 1 == h.getY() && lc1[1] == h.getX())
					|| (lc1[0] == h.getY() && lc1[1] + 1 == h.getX())
					|| (lc1[0] == h.getY() && lc1[1] - 1 == h.getX())
					|| (lc1[0] == h.getY() && lc1[1] == h.getX())) {
				lc1 = m.getFree();
				
			}
			d[i].setX(lc1[1]);
			d[i].setY(lc1[0]);
			lc1=new int[2];
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
		Eagle e = new Eagle();
		String mov;
		Boolean gameOver = false;
		int N = Interface.readMazeSize();
		int dN = 1;
		if (N!=0)
		 dN = Interface.readDrakeNumber();
		Drake[] d = new Drake[dN];
		for (int i=0;i<d.length; i++)
		{
			d[i] = new Drake();
		}
		if (N == 0) {
			m.generateMaze(N);
			h.setX(1);
			h.setY(1);
			d[0].setX(1);
			d[0].setY(3);
			s.setX(1);
			s.setY(8);
		} else {
			m.generateMaze(N);
			placeElements(m, d, h, s, e);
		}
		Display.print(m.getMaze(), h, d, s, e);

		while (!gameOver) {
			mov = Interface.readDirection();
			h.moveHero(m, mov);
			for (int i=0;i<d.length; i++)
			{
				d[i].moveDrake(m);
			}
			if (!h.hasSword())
				checkSword(h, s);
			gameOver = checkDead(h, d);
			Display.print(m.getMaze(), h, d, s, e);
		}
	}
	
	private static void checkSword(Hero h, Sword s) {
		
		if (h.getX() == s.getX() && h.getY() == s.getY()){
			h.sword = true;
		}
		else
			h.sword = false;
	}

	public static Boolean checkDead(Hero h, Drake[] d)
	{
		Boolean isDead = false;
		for (int i=0;i<d.length;i++)
		{
			if (h.getY() + 1 == d[i].getY() && h.getX() == d[i].getX())
			{
				isDead = true;
				break;
			}
			
			if (h.getY() - 1 == d[i].getY() && h.getX() == d[i].getX())
			{
				isDead = true;
				break;
			}
			
			if (h.getY() == d[i].getY() && h.getX() + 1 == d[i].getX())
			{
				isDead = true;
				break;
			}
			
			if (h.getY() == d[i].getY() && h.getX() - 1 == d[i].getX())
			{
				isDead = true;
				break;
			}
		}
		
		if (isDead)
		{
			return true;
		}
		else
			return false;
	}
}
