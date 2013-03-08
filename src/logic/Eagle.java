package logic;

public class Eagle extends Mobile {
	public int xIn, yIn;
	public Boolean dead = false;
	public int motion = 0;
	public Boolean hasSword = false;

	public Boolean isDead() {
		return dead;
	}

	public void moveEagle(Sword s) {

		int x_temp = 0;
		int y_temp = 0;
		int ratio = 0;

		switch (motion) {
		case 1:
			x_temp = s.getX() - x;
			y_temp = s.getY() - y;
			if (y_temp == 0) {
				if (x_temp > 0)
					x += 1;
				else
					x -= 1;
			} else if (x_temp == 0) {
				if (y_temp > 0)
					y += 1;
				else
					y -= 1;
			} else if (x_temp == 0 && y_temp == 0) {
				motion = 2;
				hasSword = true;
			} else {
				ratio = x_temp / y_temp;

				if (ratio > 0) {
					if (Math.abs(ratio) == 1) {
						if (x_temp > 0) {
							x += 1;
							y += 1;
						}
						if (x_temp < 0) {
							x -= 1;
							y -= 1;
						}
					}

					if (Math.abs(ratio) > 1) {
						if (x_temp < 0)
							x -= 1;
						else
							x += 1;
					} else {
						if (y_temp < 0)
							y -= 1;
						else
							y += 1;
					}
				} else
				if (ratio < 0) {
					if (Math.abs(ratio) == 1) {
						if (x_temp < 0)
							x -= 1;
						else
							x += 1;
						if (y_temp < 0)
							y -= 1;
						else
							y += 1;
					}

					if (Math.abs(ratio) > 1) {
						if (x_temp < 0)
							x -= 1;
						else
							x += 1;
					} else {
						if (y_temp < 0)
							y -= 1;
						else
							y += 1;
					}
				}
			}
			break;
		case 2:
			x_temp = xIn - x;
			y_temp = yIn - y;
			if (y_temp == 0) {
				if (x_temp > 0)
					x += 1;
				else
					x -= 1;
			} else if (x_temp == 0) {
				if (y_temp > 0)
					y += 1;
				else
					y -= 1;
			} else if (x_temp == 0 && y_temp == 0) {
				motion = 2;
				hasSword = true;
			} else {
				ratio = x_temp / y_temp;

				if (ratio > 0) {
					if (Math.abs(ratio) == 1) {
						if (x > 0) {
							x += 1;
							y += 1;
						}
						if (x < 0) {
							x -= 1;
							y -= 1;
						}
					}

					if (Math.abs(ratio) > 1) {
						if (x < 0)
							x -= 1;
						else
							x += 1;
					} else if (y < 0)
						y -= 1;
					else
						y += 1;
				}
				if (ratio < 0) {
					if (Math.abs(ratio) == 1) {
						x -= 1;
						y -= 1;
					}

					if (Math.abs(ratio) > 1) {
						if (x < 0)
							x -= 1;
						else
							x += 1;
					} else if (y < 0)
						y -= 1;
					else
						y += 1;
				}
			}
			break;
		default:
			break;
		}
	}
}
