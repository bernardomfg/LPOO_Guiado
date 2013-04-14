package logic;

import java.io.Serializable;

/**
 * Abstract Class to represent a generic game element (Sword, Hero, Eagle...)
 * 
 */
public abstract class GameElement implements Serializable {
	private static final long serialVersionUID = 1L;
	public int x, y;

	/**
	 * Returns x position in the maze
	 * 
	 * @return x position
	 */
	public int getX() {
		return x;
	}

	/**
	 * Returns y position in the maze
	 * 
	 * @return y position
	 */
	public int getY() {
		return y;
	}

	/**
	 * Changes x position in maze
	 * 
	 * @param value
	 *            new x position
	 */
	public void setX(int value) {
		x = value;
	}

	/**
	 * Changes y position in maze
	 * 
	 * @param value
	 *            new y position
	 */
	public void setY(int value) {
		y = value;
	}
}
