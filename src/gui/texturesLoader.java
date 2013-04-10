package gui;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import logic.Drake;
import logic.Hero;
import logic.Sword;

import console.DisplayConsole;

public class texturesLoader {
	
	public static ImageIcon heroImg = new ImageIcon("sprites\\goku.png");
	public static ImageIcon drakeImg = new ImageIcon("sprites\\cell.png");
	public static ImageIcon wallImg = new ImageIcon("sprites\\block.png");
	public static ImageIcon eagleImg = new ImageIcon("sprites\\cloud.png");
	public static ImageIcon exitImg = new ImageIcon("sprites\\chichi.png");
	public static ImageIcon swordImg = new ImageIcon("sprites\\dragonball.png");
	public static ImageIcon superImg = new ImageIcon("sprites\\gokuSayan.png");
	public static ImageIcon backgroundImg = new ImageIcon("sprites\\grass.png");
	public static ImageIcon drakeSwordImg = new ImageIcon("sprites\\cellBall.png");
	public static ImageIcon drakeSleepImg = new ImageIcon("sprites\\cellSleep.png");
	

	public static void paintMaze(char[][] maze, Hero h, ArrayList<Drake> d, Sword s) {

		char[][] temp = DisplayConsole.fillMaze(maze, h, d, s);

		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp.length; j++) {

				switch (temp[i][j]) {

				case 'H':
					Gui.panelGame.add(new gameTiles(texturesLoader.heroImg,' '));
					break;

				case 'D':
					Gui.panelGame.add(new gameTiles(texturesLoader.drakeImg,' '));
					break;
				case 'd': // test
				case 'f':
					Gui.panelGame.add(new gameTiles(texturesLoader.drakeSleepImg,' '));
					break;
				case 'F':
					Gui.panelGame.add(new gameTiles(texturesLoader.drakeSwordImg,' '));
					break;

				case 'P':
					Gui.panelGame.add(new gameTiles(texturesLoader.eagleImg,' '));
					break;

				case 'E':
					Gui.panelGame.add(new gameTiles(texturesLoader.swordImg,' '));
					break;

				case 'A':
					Gui.panelGame.add(new gameTiles(texturesLoader.superImg,' '));
					break;

				case ' ':
					Gui.panelGame.add(new gameTiles(texturesLoader.backgroundImg,' '));
					break;

				case 'X':
					Gui.panelGame.add(new gameTiles(texturesLoader.wallImg,' '));
					break;

				case 'S':
					Gui.panelGame.add(new gameTiles(texturesLoader.exitImg,' '));
					break;
				}
			}
		}

	}

}
