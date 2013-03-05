package logic;

public abstract class Mobile extends GameElement {
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
