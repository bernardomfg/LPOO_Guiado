package console;

import java.util.ArrayList;

import logic.Drake;
import logic.Hero;
import logic.Maze;
import logic.Sword;
import logic.Game;

public class Console {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Maze m = new Maze();
		Hero h = new Hero();
		Sword s = new Sword();
		String mov;
		Boolean gameOver = false;

		Game.gameMode = InterfaceConsole.readGameMode();
		int N = InterfaceConsole.readMazeSize();
		int dN = 1;
		if (N != 0)
			dN = InterfaceConsole.readDrakeNumber();
		ArrayList<Drake> d = new ArrayList<Drake>();
		for (int i = 0; i < dN; i++) {
			d.add(new Drake());
		}

		Game.BuildMaze(d, m, h, s, N);

		DisplayConsole.print(m.getMaze(), h, d, s);

		while (!gameOver) {
			if (h.hasEagle())
				mov = InterfaceConsole.readDirectionEagle();
			else
				mov = InterfaceConsole.readDirection();

			Game.play(mov, h, s, m, d);

			DisplayConsole.print(m.getMaze(), h, d, s);

			if (Game.checkDead(h, d)) {
				InterfaceConsole.lostTheGame();
				gameOver = true;
			}
			if (h.atExit) {
				InterfaceConsole.wonTheGame();
				gameOver = true;
			}
		}
	}

}
