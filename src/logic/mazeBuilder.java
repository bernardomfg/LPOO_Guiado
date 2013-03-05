package logic;

public abstract class mazeBuilder {
	protected char[][] m;

	public char[][] getMaze() {
		return m;
	};

	public abstract char[][] buildMaze(int N);
}
