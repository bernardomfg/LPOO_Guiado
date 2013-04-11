package gui;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import logic.Drake;

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
						if ((lc[0] == 0 && (lc[1] > 0 && lc[1] < Gui.N - 1))
								|| (lc[0] == Gui.N - 1 && (lc[1] > 0 && lc[1] < Gui.N - 1))
								|| (lc[1] == 0 && (lc[0] > 0 && lc[0] < Gui.N - 1))
								|| (lc[1] == Gui.N - 1 && (lc[0] > 0 && lc[0] < Gui.N - 1))) {
							if (!TextureLoader.hasExit) {
								image = TextureLoader.currentImg;
								symbol = TextureLoader.currentSym;
								Gui.m.maze[lc[0]][lc[1]] = symbol;
								TextureLoader.hasExit = true;
							}
						}
						break;
					case 'H':
						if (lc[0] != 0 && lc[0] != Gui.N - 1 && lc[1] != 0
								&& lc[1] != Gui.N - 1) {
							if (!TextureLoader.hasHero) {
								image = TextureLoader.currentImg;
								symbol = TextureLoader.currentSym;
								Gui.h.y = lc[0];
								Gui.h.x = lc[1];
								Gui.m.maze[lc[0]][lc[1]] = ' ';
								TextureLoader.hasHero = true;
							}
						}
						break;
					case 'E':
						if (lc[0] != 0 && lc[0] != Gui.N - 1 && lc[1] != 0
								&& lc[1] != Gui.N - 1) {
							if (!TextureLoader.hasSword) {
								image = TextureLoader.currentImg;
								symbol = TextureLoader.currentSym;
								Gui.s.y = lc[0];
								Gui.s.x = lc[1];
								Gui.m.maze[lc[0]][lc[1]] = ' ';
								TextureLoader.hasSword = true;
							}
						}
						break;
					case 'D':
						if (lc[0] != 0 && lc[0] != Gui.N - 1 && lc[1] != 0
								&& lc[1] != Gui.N - 1) {
							image = TextureLoader.currentImg;
							symbol = TextureLoader.currentSym;
							Gui.d.add(new Drake());
							Gui.d.get(Gui.d.size() - 1).y = lc[0];
							Gui.d.get(Gui.d.size() - 1).x = lc[1];
							Gui.m.maze[lc[0]][lc[1]] = ' ';
						}
						break;
					case ' ':
						if (lc[0] != 0 && lc[0] != Gui.N - 1 && lc[1] != 0
								&& lc[1] != Gui.N - 1) {
							image = TextureLoader.currentImg;
							symbol = TextureLoader.currentSym;
							Gui.m.maze[lc[0]][lc[1]] = symbol;
						}
						break;
					default:

					}
				} else if (arg0.getButton() == MouseEvent.BUTTON3) {

					switch (symbol) {
					case 'S':
						image = TextureLoader.wallImg;
						symbol = 'X';
						Gui.m.maze[lc[0]][lc[1]] = symbol;
						TextureLoader.hasExit = false;

						break;
					case 'H':
						image = TextureLoader.wallImg;
						symbol = 'X';
						Gui.h.y = 0;
						Gui.h.x = 0;
						TextureLoader.hasHero = false;
						break;
					case 'E':
						image = TextureLoader.wallImg;
						symbol = 'X';
						Gui.s.y = 0;
						Gui.s.x = 0;
						TextureLoader.hasSword = false;
						break;
					case 'D':
						image = TextureLoader.wallImg;
						symbol = 'X';
						Gui.d.remove(Gui.d.size() - 1);
						break;
					case ' ':
						image = TextureLoader.wallImg;
						symbol = 'X';
						Gui.m.maze[lc[0]][lc[1]] = symbol;
						break;
					default:

					}

				}

				Gui.panelGame.revalidate();
				Gui.panelGame.repaint();
				// image = TextureLoader.currentImg;
				// symbol = TextureLoader.currentSym;
				// Gui.m.maze[lc[0]][lc[1]] = symbol;
			}
		});

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image.getImage(), 0, 0, this.getWidth(), this.getHeight(),
				null);
	}
}
