package math;

/**
 * @author Andrei Petraru 
 * 10 Apr 2014
 */
public class MathUtils {
	/**
	 * Greatest common divisor of two numbers
	 * @param p
	 * @param q
	 * @return
	 */
	public static int gcd(int p, int q) {
		if (p < 0 || q < 0) {
			throw new IllegalArgumentException("Cannot compute gcd for negative numbers");
		}
		if (q == 0) {
			return p;
		}
		int r = p % q;
		return gcd(q, r);
	}

	/**
	 * Checks if a number is prime
	 * @param n
	 * @return
	 */
	public static boolean isPrime(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("Negative numbers cannot be prime");
		}

		int sqrN = (int) Math.sqrt(n);
		for (int i = 2; i <= sqrN; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
