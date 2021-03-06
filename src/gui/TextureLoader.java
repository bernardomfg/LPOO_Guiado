package gui;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JSpinner;

import logic.Drake;
import logic.Game;
import logic.Hero;
import logic.Maze;
import logic.Sword;

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
	public static ImageIcon drakeSwordImg = new ImageIcon(
			"sprites\\cellBall.png");
	public static ImageIcon drakeSleepImg = new ImageIcon(
			"sprites\\cellSleep.png");
	public static ImageIcon drakesleepSwordImg = new ImageIcon(
			"sprites\\cellsword.png");
	public static ImageIcon mainTheme = new ImageIcon("sprites\\mainTheme.jpg");

	/**
	 * Paints the maze in the panelGame panel.
	 * 
	 * @param maze
	 *            The maze
	 * @param h
	 *            The hero
	 * @param d
	 *            The dragon ArrayList
	 * @param s
	 *            The sword
	 */
	public static void paintMaze(char[][] maze, Hero h, ArrayList<Drake> d,
			Sword s) {
		char[][] temp = Maze.fillMaze(maze, h, d, s);
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp.length; j++) {
				switch (temp[i][j]) {
				case 'H':
					Gui.panelGame.add(new GameTile(TextureLoader.heroImg, ' '));
					break;
				case 'D':
					Gui.panelGame
							.add(new GameTile(TextureLoader.drakeImg, ' '));
					break;
				case 'd':
					Gui.panelGame.add(new GameTile(TextureLoader.drakeSleepImg,
							' '));
					break;
				case 'f':
					Gui.panelGame.add(new GameTile(
							TextureLoader.drakesleepSwordImg, ' '));
					break;
				case 'F':
					Gui.panelGame.add(new GameTile(TextureLoader.drakeSwordImg,
							' '));
					break;
				case 'P':
					Gui.panelGame
							.add(new GameTile(TextureLoader.eagleImg, ' '));
					break;
				case 'E':
					Gui.panelGame
							.add(new GameTile(TextureLoader.swordImg, ' '));
					break;
				case 'A':
					Gui.panelGame
							.add(new GameTile(TextureLoader.superImg, ' '));
					break;
				case ' ':
					Gui.panelGame.add(new GameTile(TextureLoader.backgroundImg,
							' '));
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

	/**
	 * Paints the customisable maze as its undergoing creation.
	 * 
	 * @param panelCreate
	 *            The panel that contains the various selectable elements.
	 * @param spinner
	 *            The spinner that sets the maze's size.
	 */
	public static void paintCreation(final JPanel panelCreate,
			final JSpinner spinner) {
		int[] temp = new int[2];
		Gui.panelGame.removeAll();
		Game.N = (Integer) spinner.getValue();
		Game.m.maze = new char[Game.N][Game.N];
		Gui.panelGame.setLayout(new GridLayout(Game.N, Game.N, 0, 0));
		panelCreate.revalidate();
		panelCreate.repaint();
		for (int i = 0; i < Game.N; i++) {
			for (int j = 0; j < Game.N; j++) {
				temp[0] = i;
				temp[1] = j;
				Gui.panelGame.add(new EditableGameTile(TextureLoader.wallImg,
						'X', temp.clone()));
				Game.m.maze[i][j] = 'X';
			}
		}
		TextureLoader.hasHero = false;
		TextureLoader.hasExit = false;
		TextureLoader.hasSword = false;
		Game.d.removeAll(Game.d);
		panelCreate.revalidate();
		panelCreate.repaint();
	}
}
