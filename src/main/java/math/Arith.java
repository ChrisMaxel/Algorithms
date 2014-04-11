package math;

/**
 * @author Andrei Petraru 
 * 10 Apr 2014
 */
public class Arith {
	public static int gcd(int p, int q) {
		if (p < 0 || q < 0) {
			throw new IllegalArgumentException("Cannot compute gcd for negative numbers");
		}
		if (q == 0) {
			return p;
		}
		int r = p % q;
		System.out.printf("p: %d q: %d r: %d\n", p, q, r);
		return gcd(q, r);
	}
}
