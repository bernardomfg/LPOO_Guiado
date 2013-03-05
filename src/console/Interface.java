package console;

import java.util.Scanner;

public class Interface {

	public static int readMazeSize() {
		Scanner input = new Scanner(System.in);
		int op = 0;
		System.out.print("Insira o tamanho do labirinto (maior que 6 ou 0 para default): ");
		do {
			op = input.nextInt();
			if (op < 7 && op > 0)
				System.out
						.print("Insira o tamanho do labirinto (maior que 6 ou 0 para default): ");
		} while (op < 7 && op > 0);
		return op;
	}

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
}
