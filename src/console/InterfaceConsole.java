package console;

import java.util.Scanner;

public class InterfaceConsole {
	
	
	public static int readGameMode() {
		@SuppressWarnings("resource")
		Scanner mode = new Scanner(System.in);
		int op = 0;
		System.out.println("Modos de Jogo:");
		System.out.println("1 - Dragao sem movimento");
		System.out.println("2 - Dragao com movimento");
		System.out.println("3 - Dragao com movimento intercalado com dormir");
		System.out.print("Insira o modo de jogo: ");
		
		do {
			op = mode.nextInt();
			if (op > 3 || op < 1)
				System.out
						.print("Insira o modo de jogo: ");
		} while (op > 3 || op < 1);
		return op;
		
	}

	public static int readMazeSize() {

		@SuppressWarnings("resource")
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
	
	public static String readDirection() {

		@SuppressWarnings("resource")
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

	public static String readDirectionEagle() {

		@SuppressWarnings("resource")
		Scanner dir = new Scanner(System.in);
		String mov;
		Boolean valid;
		do {
			System.out.print("Escolha uma direção (WASD) ou lancar aguia (L): ");
			mov = dir.next();
			if (mov != "A" && mov != "a" && mov != "W" && mov != "w"
					&& mov != "D" && mov != "d" && mov != "S" && mov != "s" && mov != "L" && mov != "l")
				valid = true;
			else
				valid = false;
		} while (!valid);
		return mov;
	}

	public static int readDrakeNumber() {

		@SuppressWarnings("resource")
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

	public static void lostTheGame() {

		System.out.print("Perdeu o jogo!");
		
	}


	public static void wonTheGame() {

		System.out.print("Ganhou o jogo!");
		
	}

}
