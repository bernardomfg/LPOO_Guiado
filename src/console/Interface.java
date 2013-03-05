package console;

import java.util.Scanner;

public class Interface {

	/**
	 * Reads desired maze size from user making sure it's a valid size.
	 */
	public static int readMazeSize() {
		Scanner input = new Scanner(System.in);
		int op = 0;
		System.out
				.print("Insira o tamanho do labirinto (maior que 6 ou 0 para default): ");
		do {
			op = input.nextInt();
			if (op < 7 && op > 0)
				System.out
						.print("Insira o tamanho do labirinto (maior que 6 ou 0 para default): ");
		} while (op < 7 && op > 0);
		return op;
	}

	/**
	 * Reads the direction the user wants to move to.
	 */
	public static String readDirection() {
		Scanner dir = new Scanner(System.in);
		String mov;
		Boolean valid;
		do {
			System.out.print("Escolha uma direção (WASD): ");
			mov = dir.next();
			if (mov != "A" && mov != "a" && mov != "W" && mov != "w"
					&& mov != "D" && mov != "d" && mov != "S" && mov != "s")
				valid = true;
			else
				valid = false;
		} while (!valid);
		return mov;
	}
	
	/**
	 * Reads number of Dragons from user.
	 */
	public static int readDrakeNumber() {
		Scanner input = new Scanner(System.in);
		int op = 0;
		System.out.print("Insira o número de Dragões (maior que 0): ");
		do {
			op = input.nextInt();
			if (op < 0)
				System.out.print("Insira o número de Dragões (maior que 0): ");
		} while (op < 0);
		return op;
	}
}
