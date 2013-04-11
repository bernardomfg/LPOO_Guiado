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
							System.out.println("success");
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
							TextureLoader.hasHero = true;
							System.out.println("success");
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
							TextureLoader.hasSword = true;
							System.out.println("success");
						}
					}
					break;
				case 'D':
					if (lc[0] != 0 && lc[0] != Gui.N - 1 && lc[1] != 0
							&& lc[1] != Gui.N - 1) {
						image = TextureLoader.currentImg;
						symbol = TextureLoader.currentSym;
						Gui.d.add(new Drake());
						Gui.d.get(Gui.d.size()-1).y = lc[0];
						Gui.d.get(Gui.d.size()-1).x = lc[1];
						TextureLoader.hasSword = true;
						System.out.println("success");
					}
					break;
				case ' ':
					if (lc[0] != 0 && lc[0] != Gui.N - 1 && lc[1] != 0
							&& lc[1] != Gui.N - 1) {
						if (!TextureLoader.hasSword) {
							image = TextureLoader.currentImg;
							symbol = TextureLoader.currentSym;
							Gui.m.maze[lc[0]][lc[1]] = symbol;
							System.out.println("success");
						}
					}
					break;
				default:
					System.out.println("fail");
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
