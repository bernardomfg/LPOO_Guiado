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

		m.maze[lc[0]][lc[1]] = 'H';
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
			if (m.maze[y][x - 1] == ' ') {
				m.maze[y][x] = ' ';
				m.maze[y][x - 1] = 'H';
				setX(x - 1);
			}
			break;
		// para a direita
		case "D":
		case "d":
			if (m.maze[y][x + 1] == ' ') {
				m.maze[y][x + 1] = 'H';
				m.maze[y][x] = ' ';
				setX(x + 1);
			}
			break;
		// para a cima
		case "W":
		case "w":
			if (m.maze[y - 1][x] == ' ') {
				m.maze[y - 1][x] = 'H';
				m.maze[y][x] = ' ';
				setY(y - 1);
			}
			break;
		// para a baixo
		case "S":
		case "s":
			if (m.maze[y + 1][x] == ' ') {
				m.maze[y + 1][x] = 'H';
				m.maze[y][x] = ' ';
				setY(y + 1);
			}
			break;

		}
	}
	
}
