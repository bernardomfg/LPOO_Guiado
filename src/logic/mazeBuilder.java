package logic;

public abstract class mazeBuilder {
	protected Maze m;

	public char[][] getMaze() {
		return m.maze.clone();
	};

	public void createNewMaze(char[][] temp) {
		m.setMaze(temp);
	}

	public abstract void buildMaze(int N);
}
