package logic;

import java.io.Serializable;

public class Eagle extends Mobile implements Serializable {
	private static final long serialVersionUID = 1L;
	public int xIn, yIn;
	/**
	 * @param motion
	 *            Integer represents which objective the eagle is moving towards
	 */
	public int motion = 0;
	public Boolean hasSword = false;
	public Boolean inFlight = false;
	public Boolean isDead = false;

	/**
	 * Checks if the eagle is dead.
	 * 
	 * @return Returns a boolean indicating whether the eagle is dead or alive.
	 */
	public Boolean isDead() {
		return isDead;
	}

	/**
	 * Kills eagle and changes all the necessary flags
	 * 
	 */
	public void kill() {
		isDead = true;
		hasSword = false;
		motion = 4;
	}

	/**
	 * Moves the eagle towards the sword and back to the original position
	 * 
	 * @param s
	 *            The sword needed to calculate the position to where the eagle
	 *            will move.
	 */
	public void moveEagle(Sword s) {

		float x_temp = 0;
		float y_temp = 0;
		float ratio = 0;

		switch (motion) {
		case 1: // moving towards the sword
			x_temp = s.getX() - getX();
			y_temp = s.getY() - getY();
			if (x_temp == 0 && y_temp == 0) { // arrived at goal
				inFlight = false;
				motion = 3;
				hasSword = true;
			} else if (y_temp == 0) { // going horizontally
				if (x_temp > 0) {
					setX(getX() + 1);
				} else {
					setX(getX() - 1);
				}
			} else if (x_temp == 0) { // going vertically
				if (y_temp > 0) {
					setY(getY() + 1);
				} else {
					setY(getY() - 1);
				}
			} else {
				ratio = x_temp / y_temp; // ratio to see if should go diagonally
											// or not
				if (ratio > 0) { // if ratio positive
					if (Math.abs(ratio) == 1) { // if ratio equals 1 the eagle
												// will move diagonally
						if (x_temp > 0) {
							setX(getX() + 1);
							setY(getY() + 1);
						}
						if (x_temp < 0) {
							setX(getX() - 1);
							setY(getY() - 1);
						}
					} else // checks if x bigger than y and moves to a position
							// to shorten the difference

					if (Math.abs(ratio) > 1) {
						if (x_temp < 0) {
							setX(getX() - 1);
						} else {
							setX(getX() + 1);
						}
					} else {
						if (y_temp < 0) {
							setY(getY() - 1);
						} else {
							setY(getY() + 1);
						}
					}
				}
				if (ratio < 0) {
					if (Math.abs(ratio) == 1) {
						if (x_temp < 0) {
							setX(getX() - 1);
						} else {
							setX(getX() + 1);
						}
						if (y_temp < 0) {
							setY(getY() - 1);
						} else {
							setY(getY() + 1);
						}
					} else

					if (Math.abs(ratio) > 1) {
						if (x_temp < 0) {
							setX(getX() - 1);
						} else {
							setX(getX() + 1);
						}
					} else {
						if (y_temp < 0) {
							setY(getY() - 1);
						} else {
							setY(getY() + 1);
						}
					}
				}
			}
			break;
		case 2: // moving towards the launch position
			x_temp = xIn - getX();
			y_temp = yIn - getY();
			if (x_temp == 0 && y_temp == 0) {
				motion = 4;
				inFlight = false;
			} else if (x_temp == 0) {
				if (y_temp > 0) {
					setY(getY() + 1);
				} else {
					setY(getY() - 1);
				}
			} else if (y_temp == 0) {
				if (x_temp > 0) {
					setX(getX() + 1);
				} else {
					setX(getX() - 1);
				}
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
						if (x_temp < 0) {
							setX(getX() - 1);
						} else {
							setX(getX() + 1);
						}
					} else {
						if (y_temp < 0) {
							setY(getY() - 1);
						} else {
							setY(getY() + 1);
						}
					}
				}
				if (ratio < 0) {
					if (Math.abs(ratio) == 1) {
						if (x_temp < 0) {
							setX(getX() - 1);
						} else {
							setX(getX() + 1);
						}
						if (y_temp < 0) {
							setY(getY() - 1);
						} else {
							setY(getY() + 1);
						}
					} else

					if (Math.abs(ratio) > 1) {
						if (x_temp < 0) {
							setX(getX() - 1);
						} else {
							setX(getX() + 1);
						}
					} else {
						if (y_temp < 0) {
							setY(getY() - 1);
						} else {
							setY(getY() + 1);
						}
					}
				}
			}
			if (hasSword) {
				s.setX(getX());
				s.setY(getY());
			}
			x_temp = xIn - getX();
			y_temp = yIn - getY();
			if (x_temp == 0 && y_temp == 0) {
				motion = 4;
				inFlight = false;
			}
			break;
		case 3: // launching eagle after catching the sword
			inFlight = true;
			motion = 2;
			break;
		default:
			break;
		}
	}
}
