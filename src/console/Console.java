package console;

import logic.Drake;
import logic.Game;
import logic.Maze;

/**
 * Manages the game running in console mode.
 * 
 */
public class Console {

	/**
	 * Main function for the game's console mode
	 */
	public static void main(String[] args) {

		Boolean gameOver = false;

		Game.gameMode = InterfaceConsole.readGameMode();
		Game.N = InterfaceConsole.readMazeSize();
		Game.dN = 1;
		if (Game.N != 0) {
			Game.dN = InterfaceConsole.readDrakeNumber();
		}
		for (int i = 0; i < Game.dN; i++) {
			Game.d.add(new Drake());
		}

		Maze.BuildMaze(Game.d, Game.m, Game.h, Game.s, Game.N);

		DisplayConsole.print(Game.m.getMaze(), Game.h, Game.d, Game.s);

		while (!gameOver) {
			Game.mov = InterfaceConsole.readDirection();

			Game.play(Game.mov, Game.h, Game.s, Game.m, Game.d);

			DisplayConsole.print(Game.m.getMaze(), Game.h, Game.d, Game.s);

			if (Game.checkDead(Game.h, Game.d)) {
				InterfaceConsole.lostTheGame();
				gameOver = true;
			}
			if (Game.h.atExit) {
				InterfaceConsole.wonTheGame();
				gameOver = true;
			}
		}
	}

}
