package gui;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import logic.Drake;
import logic.Hero;
import logic.Sword;

import console.DisplayConsole;

public class TextureLoader {

	public static ImageIcon currentImg = new ImageIcon();
	public static char currentSym;
	public static boolean hasExit = false;
	public static boolean hasHero = false;
	public static boolean hasSword = false;
	
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
	public static ImageIcon drakesleepSwordImg = new ImageIcon("sprites\\cellsword.png");
	public static ImageIcon mainTheme = new ImageIcon("sprites\\mainTheme.jpg");

	public static void paintMaze(char[][] maze, Hero h, ArrayList<Drake> d,	Sword s) {
		char[][] temp = DisplayConsole.fillMaze(maze, h, d, s);
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp.length; j++) {
				switch (temp[i][j]) {
				case 'H':
					Gui.panelGame.add(new GameTile(TextureLoader.heroImg, ' '));
					break;
				case 'D':
					Gui.panelGame.add(new GameTile(TextureLoader.drakeImg, ' '));
					break;
				case 'd': 
					Gui.panelGame.add(new GameTile(TextureLoader.drakeSleepImg, ' '));
					break;
				case 'f':
					Gui.panelGame.add(new GameTile(TextureLoader.drakesleepSwordImg, ' '));
					break;
				case 'F':
					Gui.panelGame.add(new GameTile(TextureLoader.drakeSwordImg, ' '));
					break;
				case 'P':
					Gui.panelGame.add(new GameTile(TextureLoader.eagleImg, ' '));
					break;
				case 'E':
					Gui.panelGame.add(new GameTile(TextureLoader.swordImg, ' '));
					break;
				case 'A':
					Gui.panelGame.add(new GameTile(TextureLoader.superImg, ' '));
					break;
				case ' ':
					Gui.panelGame.add(new GameTile(TextureLoader.backgroundImg, ' '));
					break;
				case 'X':
					Gui.panelGame.add(new GameTile(TextureLoader.wallImg, ' '));
					break;
				case 'S':
					Gui.panelGame.add(new GameTile(TextureLoader.exitImg, ' '));
					break;
				}
			}
		}
	}
}
