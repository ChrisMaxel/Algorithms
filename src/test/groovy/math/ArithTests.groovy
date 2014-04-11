package math

import spock.lang.Specification

/**
 * @author Andrei Petraru 
 * 10 Apr 2014
 */
class ArithTests extends Specification {
	def 'gcd'() {
		def gcd = Arith.gcd(1111111, 1234567)

		expect:
		gcd == 1
	}
}
