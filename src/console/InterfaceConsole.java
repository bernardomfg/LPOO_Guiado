package console;

import java.util.Scanner;

import logic.Game;

/** Controls the player interaction with the game in console mode. */
@SuppressWarnings("resource")
// Suppressing Scanner warnings since System.in should not be closed.
public class InterfaceConsole {

	/**
	 * Returns the game mode. If 1 the dragon doesn't move. If 2, the dragon
	 * moves but doesn't sleep. If 3, the dragon moves and sleeps.
	 * 
	 * @return Game mode.
	 */
	public static int readGameMode() {
		Scanner mode = new Scanner(System.in);
		int op = 0;
		System.out.println("Modos de Jogo:");
		System.out.println("1 - Dragao sem movimento");
		System.out.println("2 - Dragao com movimento");
		System.out.println("3 - Dragao com movimento intercalado com dormir");
		System.out.print("Insira o modo de jogo: ");

		do {
			op = mode.nextInt();
			if (op > 3 || op < 1) {
				System.out.print("Insira o modo de jogo: ");
			}
		} while (op > 3 || op < 1);
		return op;
	}

	/**
	 * Reads the maze size using a Scanner.
	 * 
	 * @return The maze size.
	 */
	public static int readMazeSize() {
		Scanner size = new Scanner(System.in);
		int op = 0;
		System.out
				.print("Insira o tamanho do labirinto (maior que 6 ou 0 para default): ");
		do {
			op = size.nextInt();
			if (op < 7 && op > 0) {
				System.out
						.print("Insira o tamanho do labirinto (maior que 6 ou 0 para default): ");
			}
		} while (op < 7 && op > 0);
		return op;
	}

	/**
	 * Reads the direction the player wants the hero to move to or if the Eagle
	 * is to be launched.
	 * 
	 * @return W if up, S if down, A if left, D if right and L to launch eagle.
	 */
	public static String readDirection() {
		Scanner dir = new Scanner(System.in);
		String mov;
		Boolean invalid;
		do {
			if (Game.h.hasEagle()) {
				System.out
						.print("Escolha uma direção (WASD) ou lancar aguia (L): ");
				mov = dir.next();
				if (mov != "A" && mov != "a" && mov != "W" && mov != "w"
						&& mov != "D" && mov != "d" && mov != "S" && mov != "s"
						&& mov != "L" && mov != "l") {
					invalid = true;
				} else {
					invalid = false;
				}
			} else {
				System.out.print("Escolha uma direção (WASD):");
				mov = dir.next();
				if (mov != "A" && mov != "a" && mov != "W" && mov != "w"
						&& mov != "D" && mov != "d" && mov != "S" && mov != "s") {
					invalid = true;
				} else {
					invalid = false;
				}
			}
		} while (!invalid);
		return mov;
	}

	/**
	 * Reads the number of dragons to be in the game.
	 * 
	 * @return the number of dragons.
	 */
	public static int readDrakeNumber() {
		Scanner dN = new Scanner(System.in);
		int op = 0;
		System.out.print("Insira o número de Dragões (maior que 0): ");
		do {
			op = dN.nextInt();
			if (op < 0) {
				System.out.print("Insira o número de Dragões (maior que 0): ");
			}
		} while (op < 0);
		return op;
	}

	/**
	 * Prints a message if the game is lost.
	 */
	public static void lostTheGame() {
		System.out.print("Perdeu o jogo!");
	}

	/**
	 * Prints a message if the game is won.
	 */
	public static void wonTheGame() {
		System.out.print("Ganhou o jogo!");
	}
}
