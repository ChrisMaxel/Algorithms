package matrix;

import math.Arith;

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
	public static void printMatrix(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print("[ ");
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.print("]");
			System.out.println();
		}
	}

	/**
	 * creates an N-by-N boolean array a[][] such that  a[i][j] is  true if
	 * i and  j are relatively prime (have no common factors), and  false otherwise.
	 *
	 * @param n size of the created array
	 * @return the relatively prime array
	 */
	public static boolean[][] relativePrime(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("Array size cannot be negative");
		}

		boolean[][] result = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (Arith.gcd(i, j) == 1) {
					result[i][j] = true;
				}
			}
		}
		return result;
	}
}
