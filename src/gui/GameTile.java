package gui;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class GameTile extends JLabel {

	public char symbol;
	private ImageIcon image;

	public GameTile(ImageIcon img, char sym) {

		super();
		image = img;
		symbol = sym;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image.getImage(), 0, 0, this.getWidth(), this.getHeight(),
				null);
	}


}
