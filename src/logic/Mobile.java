package logic;

import java.io.Serializable;

public abstract class Mobile extends GameElement implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * Moves the element based on the calculations made by the subclass.
	 * 
	 * @param dir
	 *            Direction of the movement.
	 */
	public void move(int dir) {
		switch (dir) {
		case 0:
			setX(getX() - 1);
			break;
		case 1:
			setX(getX() + 1);
			break;
		case 2:
			setY(getY() - 1);
			break;
		case 3:
			setY(getY() + 1);
			break;
		}
	}
}
