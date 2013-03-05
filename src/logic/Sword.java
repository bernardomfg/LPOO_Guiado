package logic;

public class Sword extends GameElement {
	
	public void placeSword(Maze m) {
		int[] lc = new int[2];

		lc = m.getFree();

		setX(lc[0]);
		setY(lc[1]);
	}

}
