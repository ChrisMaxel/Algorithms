package array;

/**
 * @author Andrei Petraru
 * 10 Apr 2014
 */
public class Array {

	/**
	 * Write a static method histogram() that takes an array a[] of int values and
	 * an integer M as arguments and returns an array of length M whose i-th entry is the number
	 * of times the integer i appeared in the argument array. If the values in a[] are all
	 * between 0 and  M–1, the sum of the values in the returned array should be equal to
	 * a.length
	 * @param a
	 * @param m
	 * @return
	 */
	public static int[] histogram(int[] a, int m) {
		if (m < 0) {
			throw new IllegalArgumentException("Cannot have an array with negative length");
		}
		int[] result = new int[m];
		for (int i = 0; i < m; i++) {
			int times = 0;
			for (int j = 0; j < a.length; j++) {
				if (i == a[j]) {
					times++;
				}
			}
			result[i] = times;
		}
		return result;
	}

	/**
	 * The dot products of two vectors
	 * @param x
	 * @param y
	 * @return
	 */
	public static double dotProduct(double[] x, double[] y) {
		if (x.length != y.length) {
			throw new IllegalArgumentException("Arrays have different lengths");
		}

		double sum = 0;
		for (int i = 0; i < x.length; i++) {
			sum += x[i] * y[i];
		}
		return sum;
	}
}
