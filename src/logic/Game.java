package logic;

import java.io.Serializable;
import java.util.ArrayList;

public class Game implements Serializable {
	private static final long serialVersionUID = 1L;

	public static int gameMode = 1;

	public static int N = 0;
	public static int dN = 0;
	public static ArrayList<Drake> d = new ArrayList<Drake>();
	public static Maze m = new Maze();
	public static Hero h = new Hero();
	public static Sword s = new Sword();
	public static String mov;

	/**
	 * Responsible for putting the game logic in action to be able to play the
	 * game (checks conditions, calls movement functions...)
	 * 
	 * @param mov
	 *            String containing the char representation of the movement the
	 *            hero will take
	 * @param h
	 *            Hero in game
	 * @param s
	 *            Sword in game
	 * @param m
	 *            Original maze
	 * @param d
	 *            ArrayList containing all drakes in game
	 */
	public static void play(String mov, Hero h, Sword s, Maze m,
			ArrayList<Drake> d) {
		if (mov.equals("l") || mov.equals("L")) { // launches eagle if mov
													// equals L
			h.launchEagle();
		} else { // else moves hero
			h.moveHero(m, mov, d);
			if (!h.e.isDead) { // moves the eagle if she is in flight and not
								// dead
				h.e.moveEagle(s);

			}
		}
		if (gameMode != 1) { // checks the game mode
			for (int i = 0; i < d.size(); i++) { // if there is Dragons moving
				d.get(i).moveDrake(m);
				if (gameMode == 3) // if there is Dragons sleeping
					d.get(i).sleepDrake();
			}
		}
		if (!h.hasSword() && !h.e.inFlight) { // checks if the hero caught the
												// sword
			Game.checkSword(h, s);
		}
	}

	/**
	 * When a random maze is built this function is called to attribute all
	 * elements a valid position in the maze
	 * 
	 * @param m
	 *            Original maze
	 * @param d
	 *            ArrayList containing all Dragons in game
	 * @param h
	 *            Hero in game
	 * @param s
	 *            Sword in game
	 */
	public static void placeElements(Maze m, ArrayList<Drake> d, Hero h, Sword s) {
		int[] lc = new int[2];
		int[] lc1 = new int[2];
		int[] lc2 = new int[2];
		lc = m.getFree();
		h.setX(lc[1]);
		h.setY(lc[0]);
		lc1 = m.getFree(); // gets a free position from the maze
		for (int i = 0; i < d.size(); i++) {
			while ((lc1[0] + 1 == h.getY() && lc1[1] == h.getX())
					|| (lc1[0] - 1 == h.getY() && lc1[1] == h.getX())
					|| (lc1[0] == h.getY() && lc1[1] + 1 == h.getX())
					|| (lc1[0] == h.getY() && lc1[1] - 1 == h.getX())
					|| (lc1[0] == h.getY() && lc1[1] == h.getX())) {
				lc1 = m.getFree();
			}
			d.get(i).setX(lc1[1]); // places the Dragons on the free position
			d.get(i).setY(lc1[0]);
			lc1 = new int[2];
			lc1 = m.getFree();
		}
		lc2 = m.getFree();
		while ((lc2[0] == h.getY() && lc2[1] == h.getX())) {
			lc2 = m.getFree();
		}
		s.setX(lc2[1]);
		s.setY(lc2[0]);
	}

	/**
	 * Checks if the hero caught the sword
	 * 
	 * @param h
	 *            Hero in game
	 * @param s
	 *            Sword in game
	 */
	public static void checkSword(Hero h, Sword s) {
		if (h.getX() == s.getX() && h.getY() == s.getY()) {
			h.sword = true;
			h.e.kill();
		}
	}

	/**
	 * Checks if either the eagle or the hero are killed by a dragon
	 * 
	 * @param h
	 *            Hero in game
	 * @param d
	 *            ArrayList containing all Dragons in game
	 * @return Returns a boolean indicating whether the Hero was killed or not.
	 */
	public static Boolean checkDead(Hero h, ArrayList<Drake> d) {
		Boolean isDead = false;
		for (int i = 0; i < d.size(); i++) {
			if (!h.e.isDead) { // checks if the eagle is killed
				if (h.e.getY() + 1 == d.get(i).getY()
						&& h.e.getX() == d.get(i).getX()) {
					if (!d.get(i).isSleeping() && !h.e.inFlight) {
						h.e.kill();
					}
				} else if (h.e.getY() - 1 == d.get(i).getY()
						&& h.e.getX() == d.get(i).getX()) {
					if (!d.get(i).isSleeping() && !h.e.inFlight) {
						h.e.kill();
					}
				} else if (h.e.getY() == d.get(i).getY()
						&& h.e.getX() + 1 == d.get(i).getX()) {
					if (!d.get(i).isSleeping() && !h.e.inFlight) {
						h.e.kill();
					}
				} else if (h.e.getY() == d.get(i).getY()
						&& h.e.getX() - 1 == d.get(i).getX()) {
					if (!d.get(i).isSleeping() && !h.e.inFlight) {
						h.e.kill();
					}
				} else if (h.e.getY() == d.get(i).getY()
						&& h.e.getX() == d.get(i).getX()) {
					if (!d.get(i).isSleeping() && !h.e.inFlight) {
						h.e.kill();
					}
				}
			}
			if (h.getY() + 1 == d.get(i).getY() && h.getX() == d.get(i).getX()) {
				// checks if the hero is killed or kills a dragon
				if (!h.hasSword() && !d.get(i).isSleeping()) {
					isDead = true;
					break;
				} else if (h.hasSword()) {
					d.remove(i);
					if (i > 0) {
						i--;
					}
				}
			} else if (h.getY() - 1 == d.get(i).getY()
					&& h.getX() == d.get(i).getX()) {
				if (!h.hasSword() && !d.get(i).isSleeping()) {
					isDead = true;
					break;
				} else if (h.hasSword()) {
					d.remove(i);
					if (i > 0) {
						i--;
					}
				}
			} else if (h.getY() == d.get(i).getY()
					&& h.getX() + 1 == d.get(i).getX()) {
				if (!h.hasSword() && !d.get(i).isSleeping()) {
					isDead = true;
					break;
				} else if (h.hasSword()) {
					d.remove(i);
					if (i > 0) {
						i--;
					}
				}
			} else if (h.getY() == d.get(i).getY()
					&& h.getX() - 1 == d.get(i).getX()) {
				if (!h.hasSword() && !d.get(i).isSleeping()) {
					isDead = true;
					break;
				} else if (h.hasSword()) {
					d.remove(i);
					if (i > 0) {
						i--;
					}
				}
			} else if (h.getY() == d.get(i).getY()
					&& h.getX() == d.get(i).getX()) {
				if (!h.hasSword() && !d.get(i).isSleeping()) {
					isDead = true;
					break;
				} else if (h.hasSword()) {
					d.remove(i);
					if (i > 0) {
						i--;
					}
				}
			}

		}

		if (isDead) {
			return true;
		} else {
			return false;
		}
	}
}
