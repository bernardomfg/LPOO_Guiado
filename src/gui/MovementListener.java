package gui;

import java.awt.Dialog;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import logic.Game;

/**Keyboard Listener to play the game
 * 
 *
 */
public class MovementListener implements KeyListener {
	@Override
	public void keyPressed(KeyEvent arg0) {
		if (!Gui.creating) {
			int key = arg0.getKeyCode();		//reads the key and acts accordingly
			// moving up
			if (key == KeyChanger.upKey) {
				Game.play("w", Game.h, Game.s, Game.m, Game.d);
				Gui.panelGame.removeAll();
				TextureLoader.paintMaze(Game.m.getMaze(), Game.h, Game.d,
						Game.s);
				Gui.panelGame.revalidate();
				Gui.panelGame.repaint();
			}
			// moving down
			if (key == KeyChanger.downKey) {
				Game.play("s", Game.h, Game.s, Game.m, Game.d);
				Gui.panelGame.removeAll();
				TextureLoader.paintMaze(Game.m.getMaze(), Game.h, Game.d,
						Game.s);
				Gui.panelGame.revalidate();
				Gui.panelGame.repaint();
			}
			// moving left
			if (key == KeyChanger.leftKey) {
				Game.play("a", Game.h, Game.s, Game.m, Game.d);
				Gui.panelGame.removeAll();
				TextureLoader.paintMaze(Game.m.getMaze(), Game.h, Game.d,
						Game.s);
				Gui.panelGame.revalidate();
				Gui.panelGame.repaint();
			}
			// moving right
			if (key == KeyChanger.rightKey) {
				Game.play("d", Game.h, Game.s, Game.m, Game.d);
				Gui.panelGame.removeAll();
				TextureLoader.paintMaze(Game.m.getMaze(), Game.h, Game.d,
						Game.s);
				Gui.panelGame.revalidate();
				Gui.panelGame.repaint();
			}
			// launching eagle
			if (key == KeyChanger.launchKey && Game.h.hasEagle() && !Game.h.hasSword()) {
				Game.play("l", Game.h, Game.s, Game.m, Game.d);
				Gui.panelGame.removeAll();
				TextureLoader.paintMaze(Game.m.getMaze(), Game.h, Game.d,
						Game.s);
				Gui.panelGame.revalidate();
				Gui.panelGame.repaint();
			}
			// Checking if game is lost
			if (Game.checkDead(Game.h, Game.d)) {
				LostGame lost = new LostGame();
				lost.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
				lost.setVisible(true);
			}
			// Checking if game is won
			if (Game.h.atExit) {
				WonGame won = new WonGame();
				won.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
				won.setVisible(true);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// placeholder

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// placeholder
	}
}
