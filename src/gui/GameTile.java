package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class GameTile extends JLabel {

	public char symbol;
	ImageIcon image;

	public GameTile(ImageIcon img, char sym) {

		super();
		image = img;
		symbol = sym;
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("teste");
				TextureLoader.currentImg = image;
				TextureLoader.currentSym = symbol;
				System.out.println(TextureLoader.currentSym);
			}});
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image.getImage(), 0, 0, this.getWidth(), this.getHeight(),
				null);
	}


}
