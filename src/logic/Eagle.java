package logic;

public class Eagle extends Mobile {
	public int xIn, yIn;
	public Boolean dead = false;
	public int motion = 0;
	public Boolean hasSword = false;
	public Boolean inFlight = false;
	public Boolean isDead = false;

	public Boolean isDead() {
		return dead;
	}

	public void moveEagle(Sword s) {

		float x_temp = 0;
		float y_temp = 0;
		float ratio = 0;

		switch (motion) {
		case 1:
			x_temp = s.getX() - getX();
			y_temp = s.getY() - getY();
			if (x_temp == 0 && y_temp == 0) {
				motion = 3;
				hasSword = true;
			} else if (y_temp == 0) {
				if (x_temp > 0)
					setX(getX() + 1);
				else
					setX(getX() - 1);
			} else if (x_temp == 0) {
				if (y_temp > 0)
					setY(getY() + 1);
				else
					setY(getY() - 1);
			} else {
				ratio = x_temp / y_temp;

				if (ratio > 0) {
					if (Math.abs(ratio) == 1) {
						if (x_temp > 0) {
							setX(getX() + 1);
							setY(getY() + 1);
						}
						if (x_temp < 0) {
							setX(getX() - 1);
							setY(getY() - 1);
						}
					} else

					if (Math.abs(ratio) > 1) {
						if (x_temp < 0)
							setX(getX() - 1);
						else
							setX(getX() + 1);
					} else {
						if (y_temp < 0)
							setY(getY() - 1);
						else
							setY(getY() + 1);
					}
				}
				if (ratio < 0) {
					if (Math.abs(ratio) == 1) {
						if (x_temp < 0)
							setX(getX() - 1);
						else
							setX(getX() + 1);
						if (y_temp < 0)
							setY(getY() - 1);
						else
							setY(getY() + 1);
					} else

					if (Math.abs(ratio) > 1) {
						if (x_temp < 0)
							setX(getX() - 1);
						else
							setX(getX() + 1);
					} else {
						if (y_temp < 0)
							setY(getY() - 1);
						else
							setY(getY() + 1);
					}
				}
			}
			break;
		case 2:
			x_temp = xIn - getX();
			y_temp = yIn - getY();
			if (x_temp == 0 && y_temp == 0) {
				motion = 4;
				inFlight = false;
				hasSword = true;
			} else if (x_temp == 0) {
				if (y_temp > 0)
					setY(getY() + 1);
				else
					setY(getY() - 1);
			} else if (y_temp == 0) {
				if (x_temp > 0)
					setX(getX() + 1);
				else
					setX(getX() - 1);
			} else {
				ratio = x_temp / y_temp;

				if (ratio > 0) {
					if (Math.abs(ratio) == 1) {
						if (x_temp > 0) {
							setX(getX() + 1);
							setY(getY() + 1);
						}
						if (x_temp < 0) {
							setX(getX() - 1);
							setY(getY() - 1);
						}
					} else

					if (Math.abs(ratio) > 1) {
						if (x_temp < 0)
							setX(getX() - 1);
						else
							setX(getX() + 1);
					} else {
						if (y_temp < 0)
							setY(getY() - 1);
						else
							setY(getY() + 1);
					}
				}
				if (ratio < 0) {
					if (Math.abs(ratio) == 1) {
						if (x_temp < 0)
							setX(getX() - 1);
						else
							setX(getX() + 1);
						if (y_temp < 0)
							setY(getY() - 1);
						else
							setY(getY() + 1);
					} else

					if (Math.abs(ratio) > 1) {
						if (x_temp < 0)
							setX(getX() - 1);
						else
							setX(getX() + 1);
					} else {
						if (y_temp < 0)
							setY(getY() - 1);
						else
							setY(getY() + 1);
					}
				}
			}
			break;
		case 3: if (inFlight)
					inFlight = false;
				else {
					inFlight = true;
					motion = 2;
				}
				break;	
		default:
			break;
		}
	}
}
