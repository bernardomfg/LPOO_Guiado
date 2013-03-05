package logic;

public class Hero extends Mobile {
	public Boolean sword = false;
	public Boolean eagle = true;
	
	public Boolean hasSword() {
		return sword;
	}
	public Boolean hasEagle() {
		return eagle;
	}
	
	public void placeHero(Maze m) {
		int[] lc = new int[2];

		lc = m.getFree();

		setX(lc[0]);
		setY(lc[1]);
	}
	
	public void moveHero(Maze m, String op) {

		int x = getX();
		int y = getY();

		// System.out.println(x);
		// System.out.println(y);

		switch (op) {
		// para a esquerda
		case "A":
		case "a":
			if (m.maze[y][x - 1] == ' ')
				move(0);
			break;
		// para a direita
		case "D":
		case "d":
			if (m.maze[y][x + 1] == ' ')
				move(1);
			break;
		// para a cima
		case "W":
		case "w":
			if (m.maze[y - 1][x] == ' ')
				move(2);
			break;
		// para a baixo
		case "S":
		case "s":
			if (m.maze[y + 1][x] == ' ')
				move(3);
			break;

		}
	}
	
}
