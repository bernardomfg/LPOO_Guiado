package logic;

public class Hero extends Mobile {
	public Boolean sword = false;
	public Boolean eagle = true;
	public Boolean atExit = false;
	public Eagle e;

	public Hero() {
		e = new Eagle();
	}
	
	public Boolean hasSword() {
		return sword;
	}

	public Boolean hasEagle() {
		return eagle;
	}
	
	public void launchEagle()
	{
		e.motion = 1;
		e.setX(x);
		e.setY(y);
		e.xIn = x;
		e.yIn = y;
		eagle = false;
		e.inFlight = true;
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
			if (m.maze[y][x - 1] == 'S' && hasSword()) {
				move(0);
				atExit = true;
			}
			break;
		// para a direita
		case "D":
		case "d":
			if (m.maze[y][x + 1] == ' ')
				move(1);
			if (m.maze[y][x + 1] == 'S' && hasSword()) {
				move(0);
				atExit = true;
			}
			break;
		// para a cima
		case "W":
		case "w":
			if (m.maze[y - 1][x] == ' ')
				move(2);
			if (m.maze[y-1][x] == 'S' && hasSword()) 
			{
				move(0);
				atExit = true;
			}
			break;
		// para a baixo
		case "S":
		case "s":
			if (m.maze[y + 1][x] == ' ')
				move(3);
			if (m.maze[y + 1][x] == 'S' && hasSword())
			{
				move(0);
				atExit = true;
			}
			break;

		}
	}
}
