package logic;

import java.io.Serializable;

public abstract class GameElement implements Serializable{
	public int x, y;

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int value) {
		x = value;
	}

	public void setY(int value) {
		y = value;
	}
}
