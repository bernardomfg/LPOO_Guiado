package gui;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import logic.Drake;
import logic.Game;


/**Class which extends JLabel and saves 4 additional variables.
 * 
 *
 */
public class EditableGameTile extends JLabel {
	private static final long serialVersionUID = 1L;

	/**
	 * lc Array containing the correspondent position of the label in the maze
	 */
	int[] lc;
	/**
	 * symbol Char equivalent to the image of the label in the maze
	 */
	public char symbol;
	/**
	 * image Image of the label
	 */
	ImageIcon image;

	/** Constructor of the class
	 * @param img Image to be placed as background of the label
	 * @param sym Char corresponding to the object in the maze
	 * @param pos Position of the label equivalent to the position in the array
	 */
	public EditableGameTile(ImageIcon img, char sym, int[] pos) {
		image = img;
		symbol = sym;
		lc = pos;
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getButton() == MouseEvent.BUTTON1) {		//if label clicked with left mouse button
					switch (TextureLoader.currentSym) {
					case 'S':													//places the exit in the maze and verifies the game conditions for it to be placed
						if ((lc[0] == 0 && (lc[1] > 0 && lc[1] < Game.N - 1))
								|| (lc[0] == Game.N - 1 && (lc[1] > 0 && lc[1] < Game.N - 1))
								|| (lc[1] == 0 && (lc[0] > 0 && lc[0] < Game.N - 1))
								|| (lc[1] == Game.N - 1 && (lc[0] > 0 && lc[0] < Game.N - 1))) {
							if (!TextureLoader.hasExit) {
								image = TextureLoader.currentImg;
								symbol = TextureLoader.currentSym;
								Game.m.maze[lc[0]][lc[1]] = symbol;
								TextureLoader.hasExit = true;
							}
						}
						break;
					case 'H':											//places the hero
						if (lc[0] != 0 && lc[0] != Game.N - 1 && lc[1] != 0
								&& lc[1] != Game.N - 1) {
							if (!TextureLoader.hasHero) {
								checkDrawn();
								image = TextureLoader.currentImg;
								symbol = TextureLoader.currentSym;
								Game.h.y = lc[0];
								Game.h.x = lc[1];
								Game.m.maze[lc[0]][lc[1]] = ' ';
								TextureLoader.hasHero = true;
							}
						}
						break;
					case 'E':			//places the sword
						if (lc[0] != 0 && lc[0] != Game.N - 1 && lc[1] != 0
								&& lc[1] != Game.N - 1) {
							if (!TextureLoader.hasSword) {
								checkDrawn();
								image = TextureLoader.currentImg;
								symbol = TextureLoader.currentSym;
								Game.s.y = lc[0];
								Game.s.x = lc[1];
								Game.m.maze[lc[0]][lc[1]] = ' ';
								TextureLoader.hasSword = true;
							}
						}
						break;
					case 'D':				//places the dragons
						if (lc[0] != 0 && lc[0] != Game.N - 1 && lc[1] != 0
								&& lc[1] != Game.N - 1) {
							checkDrawn();
							image = TextureLoader.currentImg;
							symbol = TextureLoader.currentSym;
							Game.d.add(new Drake());
							Game.d.get(Game.d.size() - 1).y = lc[0];
							Game.d.get(Game.d.size() - 1).x = lc[1];
							Game.m.maze[lc[0]][lc[1]] = ' ';
						}
						break;
					case ' ':				//places the path
						if (lc[0] != 0 && lc[0] != Game.N - 1 && lc[1] != 0
								&& lc[1] != Game.N - 1) {
							checkDrawn();
							image = TextureLoader.currentImg;
							symbol = TextureLoader.currentSym;
							Game.m.maze[lc[0]][lc[1]] = symbol;
						}
						break;
					default:
					}
				} else if (arg0.getButton() == MouseEvent.BUTTON3) {			//if clicked with right mouse button removes the element and places a wall
					switch (symbol) {
					case 'S':
						image = TextureLoader.wallImg;
						symbol = 'X';
						Game.m.maze[lc[0]][lc[1]] = symbol;
						TextureLoader.hasExit = false;
						break;
					case 'H':
						image = TextureLoader.wallImg;
						symbol = 'X';
						Game.h.y = 0;
						Game.h.x = 0;
						Game.m.maze[lc[0]][lc[1]] = symbol;
						TextureLoader.hasHero = false;
						break;
					case 'E':
						image = TextureLoader.wallImg;
						symbol = 'X';
						Game.s.y = 0;
						Game.s.x = 0;
						Game.m.maze[lc[0]][lc[1]] = symbol;
						TextureLoader.hasSword = false;
						break;
					case 'D':
						image = TextureLoader.wallImg;
						symbol = 'X';
						Game.m.maze[lc[0]][lc[1]] = symbol;
						deleteDrake();
						break;
					case ' ':
						image = TextureLoader.wallImg;
						symbol = 'X';
						Game.m.maze[lc[0]][lc[1]] = symbol;
						break;
					default:
					}
				}
				Gui.panelGame.revalidate();
				Gui.panelGame.repaint();
			}
		});
	}


	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image.getImage(), 0, 0, this.getWidth(), this.getHeight(),
				null);
	}

	/**Checks if a new game element has been placed on top of an existing main element. (Grass placed on sword)
	 * 
	 */
	public void checkDrawn() {
		switch (symbol) {
		case 'S':
			TextureLoader.hasSword = false;
			break;
		case 'H':
			TextureLoader.hasHero = false;
			break;
		case 'E':
			TextureLoader.hasSword = false;
			break;
		case 'D':
			deleteDrake();
			break;
		}
	}

	/**Removes a drake from the maze when something is placed on top of it
	 * 
	 */
	public void deleteDrake() {
		for (int i = 0; i < Game.d.size(); i++) {
			if (Game.d.get(i).getX() == lc[1]
					&& (Game.d.get(i).getY() == lc[0])) {
				Game.d.remove(i);
			}
		}
	}
}
