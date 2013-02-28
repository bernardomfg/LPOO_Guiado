package console;

public class Display {
	public void print(char[][] maze) {
		for (char[] line : maze) {
			for (char sym : line) {
				System.out.print(sym);
				System.out.print(' ');
			}
			System.out.println();
		}
	}
}