package matrix;

/**
 * @author Andrei Petraru
 * 10 Apr 2014
 */
public class Matrix {

	/**
	 * Prints the transposition (rows and columns changed)
	 * of a two-dimensional array
	 *
	 * @param a
	 */
	public static void printTransposition(int[][] a) {
		for (int i = 0; i < a[0].length; i++) {
			System.out.print("[ ");
			for (int j = 0; j < a.length; j++) {
				System.out.print(a[j][j] + " ");
			}
			System.out.print("]");
			System.out.println();
		}
	}

	/**
	 * Prints a two dimensional array
	 *
	 * @param a
	 */
	public static void print(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print("[ ");
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.print("]");
			System.out.println();
		}
	}
}
