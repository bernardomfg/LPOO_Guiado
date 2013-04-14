package gui;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Represents a game tile. Includes its ImageIcon and the respective logic
 * symbol (Ex: Goku = H)
 */
public class GameTile extends JLabel {
	private static final long serialVersionUID = 1L;
	public char symbol;
	ImageIcon image;

	
	/**Game Tile constructor. Also adds mouse listener for choosing a game element when creating a maze. 
	 * @param img
	 * @param sym
	 */
	public GameTile(ImageIcon img, char sym) {
		super();
		image = img;
		symbol = sym;

		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				TextureLoader.currentImg = image;
				TextureLoader.currentSym = symbol;
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
