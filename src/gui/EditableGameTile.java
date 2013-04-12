package gui;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import logic.Drake;
import logic.Game;

@SuppressWarnings("serial")
public class EditableGameTile extends JLabel {
	Boolean mode;
	int[] lc;
	public char symbol;
	ImageIcon image;

	public EditableGameTile(ImageIcon img, char sym, Boolean mode, int[] pos) {
		image = img;
		symbol = sym;
		this.mode = mode;
		lc = pos;
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getButton() == MouseEvent.BUTTON1) {
					switch (TextureLoader.currentSym) {
					case 'S':
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
					case 'H':
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
					case 'E':
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
					case 'D':
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
					case ' ':
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
				} else if (arg0.getButton() == MouseEvent.BUTTON3) {

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

	public void deleteDrake() {

		for (int i = 0; i < Game.d.size(); i++) {

			if (Game.d.get(i).getX() == lc[1] && (Game.d.get(i).getY() == lc[0])) {

				Game.d.remove(i);
			}
		}
	}
}
