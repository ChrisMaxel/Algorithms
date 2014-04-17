package math

import spock.lang.Specification

import static math.Arith.*

/**
 * @author Andrei Petraru 
 * 10 Apr 2014
 */
class ArithTests extends Specification {
	def 'gcd'() {
		def gcd = gcd(1111111, 1234567)

		expect:
		gcd == 1
	}

	def 'is prime'() {
		expect:
		isPrime(5)
		!isPrime(4)
		!isPrime(169)
		isPrime(53)
		!isPrime(11111)
	}

	def 'test is prime with negative number'() {
		when:
		isPrime(-5)

		then:
		def ex = thrown(IllegalArgumentException)
		ex.message == 'Negative numbers cannot be prime'
	}
}
