package interfaces;

import java.util.Scanner;

public interface Interface {

	/**
	 * Reads desired maze size from user making sure it's a valid size.
	 */
	public int readMazeSize();

	/**
	 * Reads the direction the user wants to move to.
	 */
	public String readDirection();
	
	public String readDirectionEagle();

	/**
	 * Reads number of Dragons from user.
	 */
	public int readDrakeNumber();

	public void lostTheGame();

	public void wonTheGame();
}
